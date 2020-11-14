CC=g++
CFLAGS=-std=c++17 -Wall -Wextra -Wno-deprecated -Werror -pedantic -pedantic-errors -O3 -DNDEBUG 
PARFLAGS=-fopenmp

all: bin bin/par 

bin:
	mkdir -p bin

bin/par:	par.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@
