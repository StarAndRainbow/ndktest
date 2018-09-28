# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

#设置构建本机库所需的最小CMake版本。
#这可确保
#的构建可以使用一组特定的CMake功能。
cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.



#指定库名，指定库是STATIC还是
#SHARE，并提供源代码的相对路径。您可以
#过添加多个add.library（）命令来定义多个库，
#和CMake为您构建它们。在构建应用程序时，Gradle
#会自动将共享库与您的APK打包在一起。
add_library( # Sets the name of the library.         #指定库的名称.ranic
        native-lib

        # Sets the library as a shared library.      #将库设置为共享库
        SHARED

        # Provides a relative path to your source file(s).       #提供源文件的相对路径。
        src/main/cpp/native-lib.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.


#将 find_library() 命令添加到您的 CMake 构建脚本中以定位 NDK 库，并将其路径存储为一个变量。
#您可以使用此变量在构建脚本的其他部分引用 NDK 库。以下示例可以定位 Android 特定的日志支持库并将其路径存储在 log-lib 中
find_library( # Sets the name of the path variable.       #定义存储   NDK库的位置的路径变量的名称
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.                       #指定  CMake需要定位的NDK库的名称
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.


#为了确保您的原生库可以在 log 库中调用函数，您需要使用 CMake 构建脚本中的 target_link_libraries() 命令关联库：
#将本机库与一个或多个其他本机库相链接
target_link_libraries( # Specifies the target library.          指定目标库native   这里的目标库是自己写的本地库
        native-lib

        # Links the target library to the log library
        # included in the NDK.                                  将日志库链接到目标库。
        ${log-lib})


target_link_libraries( # Specifies the target library.          指定目标库native   这里的目标库是自己写的本地库
        native-lib

        # Links the target library to the log library
        # included in the NDK.                                  将日志库链接到目标库。
        ${log-lib})