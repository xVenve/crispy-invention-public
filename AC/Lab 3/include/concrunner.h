#ifndef CONCURRENT_RUNNER_H
#define CONCURRENT_RUNNER_H

#include <thread>
#include "prodcons.h"

// Function object for concurrent execution of applications with
// one producer and one consumer.
struct concurrent_runner {

  // Invocation operator.
  // Creates a producer and a consumer and runs them in two separate threads.
  template <typename G, typename R, typename B>
  void operator()(G & generator, R & reducer, B & buffer) {
    producer<G,B> prod{generator,buffer};
    consumer<R,B> cons{reducer,buffer};

    std::thread tp{prod};
    std::thread tc{cons};

    tp.join();
    tc.join();
  }

};

#endif
