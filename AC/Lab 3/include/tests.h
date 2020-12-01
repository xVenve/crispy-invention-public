#ifndef TESTS_H
#define TESTS_H

#include "generators.h"
#include "reducers.h"

template <typename RunnerType, 
          template <typename T> class BufferType>
void test_random(int bsize, long nitems) {
  using namespace std;

  // Setup buffer, generator and reducer
  BufferType<long> buf{bsize};
  random_numeric_generator<long> generator{nitems};
  numeric_reducer<long> reducer;

  // Run generation -> Reduction
  RunnerType runner;
  runner(generator,reducer,buf);

  // Get the result
  cout << "Min: " << reducer.min() << endl;
  cout << "Max: " << reducer.max() << endl;
}

template <typename RunnerType, 
          template <typename T> class BufferType>
void test_file(int bsize, const std::string & fname) {
  using namespace std;

  // Setup buffer, generator and reducer
  BufferType<long> buf{bsize};
  file_generator<long> generator{fname};
  numeric_reducer<long> reducer;

  // Run generation -> Reduction
  RunnerType runner;
  runner(generator,reducer, buf);

  // Get the result
  cout << "Min: " << reducer.min() << endl;
  cout << "Max: " << reducer.max() << endl;
}

template <typename R,
          template <typename T> class BufferType>
void test_file_count(int bsize, const std::string & fname) {
  using namespace std;

  // Setup buffer, generator and reducer
  BufferType<string> buf{bsize};
  file_generator<string> generator{fname};
  word_counter reducer;

  // Run generation -> Reduction
  R runner;
  runner(generator,reducer,buf);

  // Get the result
  auto res = reducer.most_frequent();
  cout << "Most frequent: " << res->first << " -> " << res->second << "\n";
}

class invalid_mode : public std::runtime_error {
public:
  explicit invalid_mode(const std::string & msg) : std::runtime_error{msg} {}
};

template <typename Runner, 
          template <typename T> class BufferType>
void run_test(const std::string & mode, int bufsize, const std::string & arg) {
  using namespace std;
  if (mode=="random") {
    const long nitems = stol(arg);
    test_random<Runner,BufferType>(bufsize, nitems);
  }
  else if(mode=="file") {
    const string name = arg;
    test_file<Runner,BufferType>(bufsize, name);
  }
  else if (mode=="count") {
    const string name = arg;
    test_file_count<Runner,BufferType>(bufsize, name);
  }
  else {
    throw invalid_mode{mode};
  }
}

#endif
