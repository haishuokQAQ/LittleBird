package com.littlebird.scriptcreate;

/**
 * Create part of memory
 * Created by haishuo_k on 2017/12/12.
 */
public class CreateMem {
    public static String getMem(String pid){
        return "cpu=`cat $path | grep" + pid.trim() + " awk 'END{ print $8 }";
    }
}
