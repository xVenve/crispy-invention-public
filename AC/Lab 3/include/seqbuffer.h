#ifndef SEQUENTIAL_BUFFER_H
#define SEQUENTIAL_BUFFER_H

#include <memory>
#include <optional>

// Exceptions classes
struct full_buffer {};
struct empty_buffer {};

// Sequential buffer for values of type T
template <typename T>
class seq_buffer {
public:
  // Constructs a buffer for n elements
  explicit seq_buffer(int n) :
    size_{n},
    buf_{new item_type[size_]}
  {
  }

  // Default destructor
  ~seq_buffer() = default;

  // Size of buffer
  int size() const noexcept { 
    return size_; 
  }

  // Is buffer empty?
  bool empty() const noexcept { 
    return next_read_ == next_write_; 
  }

  // Is buffer full?
  bool full() const noexcept {
    const int next = next_position(next_write_);
    return next == next_read_;
  }

  // Put element x into buffer with marker last.
  // An empty element signals end of buffer.
  void put(const std::optional<T> & x);

  // Gets a pair with next element and last indication.
  // Pair is accessed through members first and second
  std::optional<T> get();

private:
  // Compute next position after p following circular order
  int next_position(int p) const noexcept {
    return p + ((p+1>=size_)?(1-size_):1);
  }

private:
  // Size of buffer
  const int size_;

  using item_type = std::optional<T>;

  // Unique pointer to buffer of size_ elements.
  std::unique_ptr<item_type[]> buf_;

  // Next position to read
  int next_read_ = 0;

  // Next position to write
  int next_write_ = 0;
};

template <typename T>
void seq_buffer<T>::put(const std::optional<T> & x)
{
  const int next = next_position(next_write_);
  if (next == next_read_) throw full_buffer{};
  if (!x) {
    buf_[next_write_] = {};
  }
  else {
    buf_[next_write_] = *x;
  }
  next_write_ = next;
}

template <typename T>
std::optional<T> seq_buffer<T>::get()
{
  if (empty()) throw empty_buffer{};
  auto res = buf_[next_read_];
  next_read_ = next_position(next_read_);
  return res;
}

#endif
