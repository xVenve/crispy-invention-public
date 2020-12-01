#ifndef PRODCONS_H
#define PRODCONS_H

template <typename G, typename B>
class producer {
public:
  producer(G & g, B & b) : gen_{g}, buffer_{b} {}

  void operator()() {
    for (;;) {
      auto x = gen_();
      buffer_.put(x);
      if (!x) break;
    }
  } 

  template <typename P> 
  void operator()(P predicate) {
    while (predicate()) {
      auto x = gen_();
      buffer_.put(x);
      if (!x) return;
    }
  }

private:
  G & gen_;
  B & buffer_;
};


template <typename R, typename B>
class consumer {
public:
  consumer(R & r, B & b) : red_{r}, buffer_{b} {}

  void operator()() {
    for(;;) {
      auto x = buffer_.get();
      if (!x) break;
      red_ += *x;
    }
  }

  template <typename P>
  bool operator()(P predicate) {
    while (predicate()) {
      auto x = buffer_.get();
      if (!x) return false;
      red_ += *x;
    }
    return true;
  }

private:
  R & red_;
  B & buffer_;
};

#endif
