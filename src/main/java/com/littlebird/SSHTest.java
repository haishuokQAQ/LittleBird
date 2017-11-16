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

    private void init() {
        userInfo = new MyUserInfo();
        jSch = new JSch();
        try {
            session = jSch.getSession(userName, host, port);
            session.setPassword(password);
            session.setUserInfo(userInfo);

            session.connect(30000);
            /*Channel channel = session.openChannel("shell");
           // Properties config = new Properties();
            //config.setProperty("StrictHostKeyChecking", "no");
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




    public static void main(String[] args) throws IOException {
        SSHTest test = new SSHTest("root","19950318", "192.168.109.128",22);
        test.init();
        File file = new File("test.txt");
        FileWriter fw = new FileWriter(file,true);
        fw.write("asdadadasdasd");
        fw.close();
        test.putFile(file);
    }
}
