package com.sanhen.www.ndkdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



/**
 * android ndk：      https://developer.android.google.cn/studio/projects/add-native-code
 * https://developer.android.com/ndk/reference/group/logging                         这是个没什么用的网址
 *  cmake   官网https://cmake.org/cmake/help/git-master/manual/cmake-commands.7.html
 *
 *  https://developer.android.com/ndk/guides/cmake        生成的so文件E:\ndkdemo2\app\build\intermediates\cmake\release\obj
 *
 *1,源文件
 *2，CMakeLists.txt
 *3,Android Studio UI       Link C++ Project with Gradle
 *4，出问题记得查看一下ndk路径local.properties         和       Project Struce
 * */


//在已有项目中添加c/c++          ,并且打so包
public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}



