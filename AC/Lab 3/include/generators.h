#ifndef GENERATORS_H
#define GENERATORS_H

#include <string>
#include <random>
#include <fstream>
#include <type_traits>
#include <optional>

// Generator of random numbers.
// Generates n values of integral type T following a random uniform
// distribution.
template <typename T>
class random_numeric_generator {
  static_assert(std::is_integral<T>(),
    "T must be a numeric integer type");

public:
  // Constructs a generator for n values.
  explicit random_numeric_generator(T n) noexcept : num_items_{n} {}

  // Generates next value.
  // After n values it generates an empty value.
  std::optional<T> operator()() noexcept {
    if (num_items_ <= 0) return std::nullopt;
    num_items_--;
    return ud_(rd_);
  }  

private:
  // Remaining values to be generated.
  T num_items_;

  // Random generation engine
  std::random_device rd_ {};

  // Random distribution for values
  std::uniform_int_distribution<T> ud_{
    std::numeric_limits<T>::min(), 
    std::numeric_limits<T>::max()
  };
};

// Generator for obtaining values from a file.
// A file_generator<int> parses int values.
// A file_generator<string> parses words.
template <class T>
class file_generator {
public:
  // Constructs a file generator from a filename
  explicit file_generator(const std::string & filename) noexcept : ifs{filename} {}

  // Gets the next value from file or an empty value if no more data in file
  // is available.
  std::optional<T> operator()() {
    T x; 
    ifs >> x >> std::ws;
    if (!ifs) return std::nullopt;
    return x; 
  }

private:
  // Input file object.
  std::ifstream ifs;
};

#endif
