package com.littlebird;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class SSHTest {
    private static final Logger logger = LoggerFactory.getLogger(SSHTest.class);

    private String userName;

    private String password;

    private String host;

    private int port;

    private UserInfo userInfo;

    private JSch jSch;

    private Session session;

    public SSHTest(String userName, String password, String host, int port) {
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public void init() {
        userInfo = new MyUserInfo();
        jSch = new JSch();
        try {
            session = jSch.getSession(userName, host, port);
            session.setPassword(password);
            session.setUserInfo(userInfo);

            Properties config = new Properties();
            config.setProperty("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(30000);
           /* Channel channel = session.openChannel("shell");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect(3000);*/
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public void putFile(File f) {
        try {
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.put(new FileInputStream(f), "/home/" + f.getName());
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }


    private Channel getShellChannel(){
        if (session == null || !session.isConnected()) {
            System.out.println("Not connect yet.");
            return null;
        }
        try {
            Channel channel = session.openChannel("shell");
            return channel;
        } catch (JSchException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Channel connectShell(InputStream ins, OutputStream ops){
        Channel channel = getShellChannel();
        channel.setInputStream(ins);
        channel.setOutputStream(ops);
        try {
            channel.connect();
        } catch (JSchException e) {
            e.printStackTrace();
            return null;
        }
        return channel;
    }

    public Channel connectShell(){
        Channel channel =  connectShell(System.in, System.out);
        try {
            channel.connect();
        } catch (JSchException e) {
            e.printStackTrace();
            return null;
        }
        return channel;
    }

    public static void main(String[] args) throws Exception {
        SSHTest test = new SSHTest("root","19950318", "192.168.146.128",22);
        test.init();
           /* Channel channel = test.session.openChannel("shell");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect(3000);*/
        Channel channel = test.connectShell();
        //File file = new File("test.txt");
        //FileWriter fw = new FileWriter(file,true);
        //fw.write("asdadadasdasd");
        //fw.close();
        //test.putFile(file);
    }
}
