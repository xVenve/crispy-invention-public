#ifndef SEQUENTIAL_RUNNER_H
#define SEQUENTIAL_RUNNER_H

#include "prodcons.h"

// Function object for sequential execution of applications with 
// one producer and one consumer.
struct sequential_runner {

  // Invocation operator.
  // Alternatively runs two phases:
  // 1. Produces elements until the buffer is full.
  // 2. Consumes elements until the buffer is empty.
  // This is repeated until an empty value is consumed. This is
  // considered an end of stream indication.
  template <typename G, typename R, typename B>
  void operator()(G & generator, R & reducer, B & buffer) {
    producer<G,B> prod{generator,buffer};
    consumer<R,B> cons{reducer,buffer};

    for (;;) {
      // Invoke producer
      prod([&]{ 
        return !buffer.full(); 
      });

      // Invoke consumer
      bool more_items = cons([&] {
        return !buffer.empty();
      });
      if (!more_items) return;
    }
  }
};

#endif
