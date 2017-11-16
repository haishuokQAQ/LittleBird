package com.littlebird;

import com.jcraft.jsch.UserInfo;

public class MyUserInfo implements UserInfo {
    public MyUserInfo(){

    }
    public String getPassphrase() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public boolean promptPassword(String s) {
        return false;
    }

    public boolean promptPassphrase(String s) {
        return false;
    }

    public boolean promptYesNo(String s) {
        return true;
    }

    public void showMessage(String s) {

    }
}
