package com.timain.web.sys.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 8:26
 */
public class MD5Utils {

    public static void main(String[] args) {
        String algorithmName = "MD5";//加密方式
        String password = "123456";//明码
        ByteSource salt = ByteSource.Util.bytes("wjk");//加盐
        int iterations = 1024;
        Object source = password;//要加密的密码
        SimpleHash hash = new SimpleHash(algorithmName, source, salt, iterations);
        System.out.println(hash);
    }

}
