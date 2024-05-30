# The following lines of boilerplate have to be in your project's CMakeLists
# in this exact order for cmake to work correctly
cmake_minimum_required(VERSION 3.16)

#find_program(CCACHE_PROGRAM ccache)
#if(CCACHE_PROGRAM)
#    set(CMAKE_C_COMPILER_LAUNCHER ${CCACHE_PROGRAM})
#    set(CMAKE_CXX_COMPILER_LAUNCHER ${CCACHE_PROGRAM})
#    message(STATUS "Using ccache: ${CCACHE_PROGRAM}")
#else()
#    message(STATUS "ccache not found")
#endif()

include($ENV{IDF_PATH}/tools/cmake/project.cmake)
project(ESP-OTA-MQTT)
