package com.littlebird.scriptcreate;

/**
 * Create cpu monitor part of script
 * Created by haishuo_k on 2017/11/18.
 */
public class CreatCpu {
    private static final String path = "pathcpu=";
    private static final String topHead = "top -n 1 -p ";
    private static final String topMid = ">";
    private static final String findHead = "cpu=`cat ";
    private static final String findSec = " | grep ";
    private static final String findTrd = "awk 'END{ print $8 }'";

}
