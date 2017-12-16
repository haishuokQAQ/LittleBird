package com.littlebird;

import com.jcraft.jsch.Channel;

/**
 * Connect to given server
 * Created by haishuo_k on 2017/11/18.
 */
public class ShellConnector {
    private static final String host = "192.168.1.52";
    private static final String userName = "root";
    private static final String password = "111111";
    private static final int port = 22;

    public static void main(String[] args) {
        SSHTest test = new SSHTest(userName, password, host, port);
        test.init();
        //Channel channel = test.connectShell();
        //channel.toString();
    }

    public boolean validateConnectable(String host, String userName, String password){
        return validateConnectable(host, userName, password, 22);
    }

    public boolean validateConnectable(String host, String userName, String password, int port){
        SSHTest test = new SSHTest(userName, password,host,port);
        try {
            test.init();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
