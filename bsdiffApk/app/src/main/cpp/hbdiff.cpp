#include <jni.h>
#include <string>
#include "bsdiff.h"

extern "C"
JNIEXPORT void JNICALL
Java_hebiao_online_bsdiffapk_DiffUtil_diff(JNIEnv *env, jclass type, jstring oldpath_,
                                           jstring newpath_, jstring patch_) {
    const char *oldpath = env->GetStringUTFChars(oldpath_, 0);
    const char *newpath = env->GetStringUTFChars(newpath_, 0);
    const char *patch = env->GetStringUTFChars(patch_, 0);

    char  * argv[4];
    argv[0] = "diff_main";
    argv[1] = (char *)oldpath;
    argv[2] = (char *)newpath;
    argv[3] = (char *)patch;

    diff_main(4,argv);

    env->ReleaseStringUTFChars(oldpath_, oldpath);
    env->ReleaseStringUTFChars(newpath_, newpath);
    env->ReleaseStringUTFChars(patch_, patch);
}