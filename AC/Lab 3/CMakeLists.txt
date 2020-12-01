cmake_minimum_required(VERSION 3.16)

set(PROJECT_NAME_STR bbuffer)
project(${PROJECT_NAME_STR})

set(CMAKE_CXX_STANDARD 17)

# Local project include directory
include_directories("${CMAKE_SOURCE_DIR}/include")

# Build binary directory
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY "${PROJECT_BINARY_DIR}")

add_compile_options(-Wall -Wextra -Wno-deprecated -Werror -pedantic
    -pedantic-errors)

find_package(Threads)

#Process subdirectories
add_subdirectory(apps)
