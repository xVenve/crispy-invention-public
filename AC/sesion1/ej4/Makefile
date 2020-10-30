CPP = clang++
CPPFLAGS = -Xpreprocessor -fopenmp -std=c++11 -I/usr/local/include -L/usr/local/lib -lomp

pi: pi.cpp
	$(CPP) $(CPPFLAGS) $^ -o $@
