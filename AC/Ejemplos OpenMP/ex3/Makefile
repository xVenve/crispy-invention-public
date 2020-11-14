CC=g++
CFLAGS=-std=c++17 -Wall -Wextra -Wno-deprecated -Werror -pedantic -pedantic-errors -O3 -DNDEBUG 
PARFLAGS=-fopenmp

all: bin bin/seq bin/parcrit bin/paratom

bin:
	mkdir -p bin

bin/seq:	seq.cpp
	$(CC) $(CFLAGS) $< -o $@

bin/parcrit:	parcrit.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@

bin/paratom:	paratom.cpp
	$(CC) $(CFLAGS) $(PARFLAGS) $< -o $@
