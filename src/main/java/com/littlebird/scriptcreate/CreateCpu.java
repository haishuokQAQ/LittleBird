package com.littlebird.scriptcreate;

/**
 * Create cpu monitor part of script
 * Created by haishuo_k on 2017/11/18.
 */
public class CreateCpu {
    private static final String path = "path=";
    private static final String topHead = "top -n 1 -p ";
    private static final String topMid = "-b > $path";
    private static final String findHead = "cpu=`cat $path ";
    private static final String findSec = " | grep ";
    private static final String findTrd = " awk 'END{ print $8 }'";

    public static String getCPU(String filePath, String pid){
        StringBuilder sb = new StringBuilder();
        sb.append(path).append(filePath.trim()).append("\n");
        sb.append(topHead).append(pid.trim()).append(topMid).append("\n");
        sb.append(findHead).append(findSec).append(pid).append(findTrd);
        return sb.toString();
    }
}
