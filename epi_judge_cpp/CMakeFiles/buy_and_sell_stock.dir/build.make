# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

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
CMAKE_COMMAND = /usr/local/Cellar/cmake/3.10.1/bin/cmake

# The command to remove a file.
RM = /usr/local/Cellar/cmake/3.10.1/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp"

# Include any dependencies generated for this target.
include CMakeFiles/buy_and_sell_stock.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/buy_and_sell_stock.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/buy_and_sell_stock.dir/flags.make

CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o: CMakeFiles/buy_and_sell_stock.dir/flags.make
CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o: buy_and_sell_stock.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o -c "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp/buy_and_sell_stock.cc"

CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp/buy_and_sell_stock.cc" > CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.i

CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp/buy_and_sell_stock.cc" -o CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.s

CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.requires:

.PHONY : CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.requires

CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.provides: CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.requires
	$(MAKE) -f CMakeFiles/buy_and_sell_stock.dir/build.make CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.provides.build
.PHONY : CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.provides

CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.provides.build: CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o


# Object files for target buy_and_sell_stock
buy_and_sell_stock_OBJECTS = \
"CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o"

# External object files for target buy_and_sell_stock
buy_and_sell_stock_EXTERNAL_OBJECTS =

buy_and_sell_stock: CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o
buy_and_sell_stock: CMakeFiles/buy_and_sell_stock.dir/build.make
buy_and_sell_stock: CMakeFiles/buy_and_sell_stock.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable buy_and_sell_stock"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/buy_and_sell_stock.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/buy_and_sell_stock.dir/build: buy_and_sell_stock

.PHONY : CMakeFiles/buy_and_sell_stock.dir/build

CMakeFiles/buy_and_sell_stock.dir/requires: CMakeFiles/buy_and_sell_stock.dir/buy_and_sell_stock.cc.o.requires

.PHONY : CMakeFiles/buy_and_sell_stock.dir/requires

CMakeFiles/buy_and_sell_stock.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/buy_and_sell_stock.dir/cmake_clean.cmake
.PHONY : CMakeFiles/buy_and_sell_stock.dir/clean

CMakeFiles/buy_and_sell_stock.dir/depend:
	cd "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp" "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp" "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp" "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp" "/Users/TsungHsienLee/Google Drive/episolutions/EPIJudge/epi_judge_cpp/CMakeFiles/buy_and_sell_stock.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/buy_and_sell_stock.dir/depend
