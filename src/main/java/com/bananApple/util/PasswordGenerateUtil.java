package com.bananApple.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordGenerateUtil {

    public static String getPassword(String password, String salt, int hashTimes){
        Md5Hash md5Hash = new Md5Hash(password, salt, hashTimes);
        return md5Hash.toString();
    }

    public static void main(String[] args) {
        String password = getPassword("wb382014", "newwbbie", 2);
        System.out.println("password = " + password);
    }
}