#ifndef LOCKED_BUFFER_H
#define LOCKED_BUFFER_H

#include <memory>
#include <mutex>
#include <condition_variable>
#include <atomic>
#include <optional>

template <typename T>
class locked_buffer {
public:
  // Creates buffer of size n
  explicit locked_buffer(int n) :
    size_{n},
    buf_{new std::optional<T>[size_]}
  {
  }

  // Remove copy constructor
  locked_buffer(const locked_buffer &) = delete;

  // Destructor (default generated)
  ~locked_buffer() = default;

  // Gets buffer size
  int size() const noexcept {
    return size_;
  }

  // Checks if buffer is empty
  bool empty() const noexcept {
    std::lock_guard<std::mutex> l{mut_};
    return is_empty();
  }

  // Checks if buffer is full
  bool full() const noexcept {
    std::lock_guard<std::mutex> l{mut_};
    return is_full();
  }

  // Put an optional value in the queue
  void put(const std::optional<T> & x);

  // Get a value from the queue
  std::optional<T> get();

private:
  // Next circular position to position p
  int next_position(int p) const noexcept {
    return p + ((p+1>=size_)?(1-size_):1);
  }

  // Check if buffer is empty without locking
  bool is_empty() const noexcept {
    return (next_read_ == next_write_);
  }

  // Check if buffer is full without locking
  bool is_full() const noexcept {
    const int next = next_position(next_write_);
    return next == next_read_;
  }

private:
  const int size_;
  const std::unique_ptr<std::optional<T>[]> buf_;
  int next_read_ = 0;
  int next_write_ = 0;

  mutable std::mutex mut_;
  std::condition_variable not_full_;
  std::condition_variable not_empty_;
};


template <typename T>
void locked_buffer<T>::put(const std::optional<T> & x)
{
  using namespace std;
  unique_lock<mutex> l{mut_};
  not_full_.wait(l, [this] { return !is_full(); });
  buf_[next_write_] = x;
  next_write_ = next_position(next_write_);
  not_empty_.notify_one();
}

template <typename T>
std::optional<T> locked_buffer<T>::get()
{
  using namespace std;
  unique_lock<mutex> l{mut_};
  not_empty_.wait(l, [this] { return !is_empty(); });
  auto res = buf_[next_read_];
  next_read_ = next_position(next_read_);
  not_full_.notify_one();
  return res;
}

#endif
