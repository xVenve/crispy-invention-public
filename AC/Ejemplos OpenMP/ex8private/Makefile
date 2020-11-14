CC=g++
CFLAGS=-std=c++14 -O3 -DNDEBUG
PARFLAGS=-fopenmp

all: bin bin/par bin/par2 

bin:
	mkdir -p bin

bin/par:	par.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@
bin/par2:	par2.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@
CFLAGS=-std=c++17 -Wall -Wextra -Wno-deprecated -Werror -pedantic -pedantic-errors -O3 -DNDEBUG 
