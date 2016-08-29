# Makefile for ICPC ACM2006 South American Regionals
# r. anido

CC = gcc -Wall
CPP = g++ -Wall
LD_FLAGS = -lm 

.SUFFIXES: .java .class

#TIME = /usr/local/bin/time -f "%Uu %Ss"
TIME = time -p
DIFF = diff
TESTS = ../tests/
CPROGS := $(patsubst %.c,%,$(wildcard *.c))
CCPROGS := $(patsubst %.cc,%,$(wildcard *.cc))
CPPPROGS := $(patsubst %.cpp,%,$(wildcard *.cpp))
JCLASSES := $(patsubst %.java,%.class,$(wildcard *.java))
PROGSJ := $(patsubst %.java,%,$(wildcard *.java))

PROGS = $(CPROGS) $(CCPROGS) $(CPPPROGS)

DIR := $(shell (cd ..; pwd))
NAME := $(shell basename $(DIR))

all:	$(PROGS) $(JCLASSES)

time: $(JCLASSES) $(PROGS)
	@$(foreach file, $(PROGSJ), echo $(file) ; $(TIME) java $(file) < $(TESTS)/in1 > /tmp/out1; echo;)
	@$(foreach file, $(PROGS), echo $(file); $(TIME) ./$(file) < $(TESTS)/in1 > /tmp/out1; echo;)

diff: $(JCLASSES) $(JCLASSES)
	@$(foreach file, $(PROGSJ),  echo $(file); java $(file) < $(TESTS)/in1 | $(DIFF) -  $(TESTS)/out1;)
	@$(foreach file, $(PROGS),  echo $(file); ./$(file) < $(TESTS)/in1 | $(DIFF) -  $(TESTS)/out1;)

sol: $(PROGS)
	./$< < $(TESTS)/$(NAME).in > $(TESTS)/$(NAME).sol
	./$< < $(TESTS)/sample.in > $(TESTS)/sample.sol

clean:
	rm -f *~ *.o *.class $(PROGS) $(PROGSJ)

# suffix rules
.java.class:
	javac $<
