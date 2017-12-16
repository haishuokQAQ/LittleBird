package com.littlebird.scriptcreate;

/**
 * Create disk monitor using iotop
 * Created by haishuo_k on 2017/12/12.
 */
public class CreateDisk {
    private static String path = "disk_path=";
    private static String topHead = "iotop -p ";
    private static String topTail = " > $disk_path";
    private static String diskAllHead = "diskall=`cat $disk_path | grep ";
    private static String diskAllTail = " |awk 'END{ print $7 } `";
    private static String diskInHead = "diskin=`cat $disk_path | grep ";
    private static String diskInTail = "|awk 'END{ print $7 } `";
    private static String diskOutHead = "diskout=`cat $disk_path | grep ";
    private static String diskOutTail = "|awk 'END{ print $7 } `";


    public static  String getDisk(String filePath, String pid){
        StringBuilder sb = new StringBuilder();
        sb.append(path).append(filePath).append("\n");
        sb.append(topHead).append(pid).append(topTail).append("\n");
        sb.append(diskAllHead).append(pid).append(diskAllTail).append("\n");
        sb.append(diskInHead).append(pid).append(diskInTail).append("\n");
        sb.append(diskOutHead).append(pid).append(diskOutTail).append("\n");
        return sb.toString();
    }
}
