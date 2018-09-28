

# 指定需要CMAKE的最小版本
cmake_minimum_required(VERSION 3.4.1)




# 添加库，参数为(库名称<自定义>,库模式<STATIC,SHARED>，路径)
add_library( # Sets the name of the library.       #指定库的名称.ranic
        native-lib

        # Sets the library as a shared library.      #将库设置为共享库
        SHARED

        # Provides a relative path to your source file(s).       #提供源文件的相对路径。
        src/main/cpp/native-lib.cpp)





find_library( # Sets the name of the path variable.       #定义存储   NDK库的位置的路径变量的名称
        log-lib
        # Specifies the name of the NDK library that
        # you want CMake to locate.                       #指定  CMake需要定位的NDK库的名称
        log)

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/../app/src/main/jniLibs/${ANDROID_ABI})
#它将会把生成的so库按照你在 build.gradle 指定的 abi分别放置在 jniLibs下



# 指定目标库
target_link_libraries( # Specifies the target library.          指定目标库native   这里的目标库是自己写的本地库
        native-lib

        # Links the target library to the log library
        # included in the NDK.                                  将日志库链接到目标库。
        ${log-lib})


