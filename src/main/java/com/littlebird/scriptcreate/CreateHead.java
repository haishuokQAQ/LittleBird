package com.littlebird.scriptcreate;

/**
 * Create the head of script
 *      Head:
 *          #!/bin/sh
 *          pid=yourpid
 *          hostname=currenthostname
 *          tarhost=receiveserverhost
 * Created by haishuo_k on 2017/11/18.
 */
public class CreateHead {
    private static final String pidBuilder = "pid=";
    private static final String hostNameBuilder = "hostname=";
    private static final String tarHostBuilder = "tarhost=";

    public static String createHead(String pid, String hostName, String tarHost){
        StringBuilder headCreater = new StringBuilder();
        headCreater.append("#!bin/sh\n").append(pidBuilder).append(pid).append("\n");
        headCreater.append(hostNameBuilder).append(hostName).append("\n");
        headCreater.append(tarHostBuilder).append(tarHost).append("\n");
        return headCreater.toString();
    }

    public static String createHead(int pid, String hostName, String tartHost){
        return createHead(String.valueOf(pid), hostName, tartHost);
    }
}
