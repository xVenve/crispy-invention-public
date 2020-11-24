CC=g++
CFLAGS=-std=c++17 -Wall -Wextra -Wno-deprecated -Werror -pedantic -pedantic-errors -O3 -DNDEBUG
PARFLAGS=-fopenmp

all: image-seq image-par

image-seq:	image-seq.cpp
	$(CC) $(CFLAGS) $< -o $@

image-par:	image-par.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@
