# Compiler
CC = gcc

# Compiler flags
CFLAGS = -Wall -Wextra -std=c11 -fPIC

# Source files directory
SRC_DIR = src-gen

# Source files
SRCS = $(wildcard $(SRC_DIR)/*.c)

# Object files
OBJS = $(SRCS:.c=.o)

# Target shared library
TARGET_LIB = libshared_snem.so

# Rule to build the shared library
$(TARGET_LIB): $(OBJS)
	$(CC) -shared -o $@ $^

# Rule to compile source files
%.o: %.c
	$(CC) $(CFLAGS) -c -o $@ $<

# Phony target to clean the build
.PHONY: clean
clean:
	rm -f $(OBJS) $(TARGET_LIB)
