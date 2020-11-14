CC=g++
CFLAGS=-std=c++17 -Wall -Wextra -Wno-deprecated -Werror -pedantic -pedantic-errors -O3 -DNDEBUG 
PARFLAGS=-fopenmp

all: bin bin/test

bin:
	mkdir -p bin

bin/test:	main.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@

