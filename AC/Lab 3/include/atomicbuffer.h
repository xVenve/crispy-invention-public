#ifndef ATOMIC_BUFFER_H
#define ATOMIC_BUFFER_H

#include <memory>
#include <atomic>
#include <utility>
#include <optional>

template <typename T>
class atomic_buffer {
public:
  // Creates buffer of size n
  explicit atomic_buffer(int n) :
    size_{n},
    buf_{new std::optional<T>[size_]}
  {
  }

  // Destructor (default generated)
  ~atomic_buffer() = default;

  // Gets buffer size
  int size() const noexcept {
    return size_;
  }

  // Check whether buffer is empty
  bool empty() const noexcept {
    return next_read_ == next_write_;
  }

  // Check whether buffer is full
  bool full() const noexcept {
    const int next = next_position(next_write_.load());
    return next == next_read_.load();
  }

  // Put an optional value in the queue
  void put(const std::optional<T> & x);

  // Get an optional value from the queue
  std::optional<T> get();

private:
  int next_position(int p) const noexcept {
    return p + ((p+1>=size_)?(1-size_):1);
  }

private:
  const int size_;
  const std::unique_ptr<std::optional<T>[]> buf_;
  alignas(64) std::atomic<int> next_read_ {0};
  alignas(64) std::atomic<int> next_write_ {0};
};

template <typename T>
void atomic_buffer<T>::put(const std::optional<T> & x)
{
  const int next = next_position(next_write_.load());
  while (next == next_read_.load()) {}
  buf_[next_write_.load()] = x;
  next_write_.store(next);
}

template <typename T>
std::optional<T> atomic_buffer<T>::get()
{
  while (empty()) {}
  auto res = buf_[next_read_.load()];
  next_read_.store(next_position(next_read_.load()));
  return res;
}

#endif
