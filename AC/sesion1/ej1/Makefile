CPP = clang++
CPPFLAGS = -Xpreprocessor -fopenmp -I/usr/local/include -L/usr/local/lib -lomp

exseq: exseq.cpp
	$(CPP) $(CPPFLAGS) $^ -o $@
