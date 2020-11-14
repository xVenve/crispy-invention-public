CC=g++
CFLAGS=-std=c++17 -Wall -Wextra -Wno-deprecated -Werror -pedantic -pedantic-errors -O3 -DNDEBUG 
PARFLAGS=-fopenmp

all: bin bin/seq bin/par 

bin:
	mkdir -p bin

bin/seq:	seq.cpp
	$(CC) $(CFLAGS) $< -o $@

bin/par:	par.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@
