# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.16

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build"

# Include any dependencies generated for this target.
include apps/CMakeFiles/seq_test.dir/depend.make

# Include the progress variables for this target.
include apps/CMakeFiles/seq_test.dir/progress.make

# Include the compile flags for this target's objects.
include apps/CMakeFiles/seq_test.dir/flags.make

apps/CMakeFiles/seq_test.dir/seq_main.cpp.o: apps/CMakeFiles/seq_test.dir/flags.make
apps/CMakeFiles/seq_test.dir/seq_main.cpp.o: ../apps/seq_main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object apps/CMakeFiles/seq_test.dir/seq_main.cpp.o"
	cd "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/apps" && /usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/seq_test.dir/seq_main.cpp.o -c "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/apps/seq_main.cpp"

apps/CMakeFiles/seq_test.dir/seq_main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/seq_test.dir/seq_main.cpp.i"
	cd "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/apps" && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/apps/seq_main.cpp" > CMakeFiles/seq_test.dir/seq_main.cpp.i

apps/CMakeFiles/seq_test.dir/seq_main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/seq_test.dir/seq_main.cpp.s"
	cd "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/apps" && /usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/apps/seq_main.cpp" -o CMakeFiles/seq_test.dir/seq_main.cpp.s

# Object files for target seq_test
seq_test_OBJECTS = \
"CMakeFiles/seq_test.dir/seq_main.cpp.o"

# External object files for target seq_test
seq_test_EXTERNAL_OBJECTS =

seq_test: apps/CMakeFiles/seq_test.dir/seq_main.cpp.o
seq_test: apps/CMakeFiles/seq_test.dir/build.make
seq_test: apps/CMakeFiles/seq_test.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ../seq_test"
	cd "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/apps" && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/seq_test.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
apps/CMakeFiles/seq_test.dir/build: seq_test

.PHONY : apps/CMakeFiles/seq_test.dir/build

apps/CMakeFiles/seq_test.dir/clean:
	cd "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/apps" && $(CMAKE_COMMAND) -P CMakeFiles/seq_test.dir/cmake_clean.cmake
.PHONY : apps/CMakeFiles/seq_test.dir/clean

apps/CMakeFiles/seq_test.dir/depend:
	cd "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3" "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/apps" "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build" "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/apps" "/mnt/d/Documents/Gits/crispy-invention/AC/Lab 3/build/apps/CMakeFiles/seq_test.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : apps/CMakeFiles/seq_test.dir/depend
