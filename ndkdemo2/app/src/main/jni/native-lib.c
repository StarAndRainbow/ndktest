#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_sanhen_www_ndkdemo2_MainActivity_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, returnValue);
}