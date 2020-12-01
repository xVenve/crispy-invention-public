#include <string>
#include <iostream>
#include <stdexcept>

#include "concrunner.h"
#include "atomicbuffer.h"
#include "tests.h"

int main(int argc, char ** argv) {
  using namespace std;
  if (argc !=4) {
    cerr << "Wrong arguments" << endl;
    cerr << "Valid formats: " << endl;
    cerr << "  " << argv[0] << " random bufsize nitems" << endl;
    cerr << "  " << argv[0] << " file bufsize filename" << endl;
    cerr << "  " << argv[0] << " count bufsize filename" << endl;
    return -1;
  }
   
  try {
    const string mode = argv[1];
    const int bsize = stoi(argv[2]);
    run_test<concurrent_runner,atomic_buffer>(mode, bsize, argv[3]);
  }
  catch (const exception & e) {
    cerr << "Error: " << e.what() << "\n";
    return -2;
  }

  return 0;
}

