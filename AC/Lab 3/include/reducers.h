#ifndef REDUCERS_H
#define REDUCERS_H

#include <limits>
#include <string>
#include <map>
#include <algorithm>

// Reducer for values of generic type T.
template <class T>
class numeric_reducer {
  static_assert(std::is_integral<T>(), 
    "T must be a numeric integer type");

public:
  // Empty constructor.
  // Sets data members to default values.
  numeric_reducer() noexcept = default;

  // Reduces one value.
  void operator+=(T x) noexcept {
    min_ = std::min(min_, x);
    max_ = std::max(max_, x);
  }

  // Gets the minimum value.
  T min() const noexcept { return min_; }

  // Gets the maximum value.
  T max() const noexcept { return max_; }

private:
  // Minimum value. Initially set to max value for type T.
  T min_ { std::numeric_limits<T>::max() };

  // Maximum value. Initially set to min value for type T.
  T max_ { std::numeric_limits<T>::min() };
};

// Word reducer.
// Allows getting the most frequent word and its number of occurrences.
class word_counter {
public:
  // Empty constructor. Initializes associative table.
  word_counter() noexcept : dict{} {}

  // Adds a word to the associative table.
  void operator+=(const std::string & w) {
    dict[w]++;
  }

  // Gets the <word,num_times> pair with the highest value for num_times.
  // The obtained value is of type std::pair<string,int>
  auto most_frequent() const {
    return std::max_element(dict.begin(), dict.end(),
      [](const auto & x, const auto & y) {
        return x.second < y.second;
      });
  }

private:
  // Associative table with pairs <word,num_items>.
  // Each word is associated with it number of occurrences.
  std::map<std::string, int> dict;
};

#endif
