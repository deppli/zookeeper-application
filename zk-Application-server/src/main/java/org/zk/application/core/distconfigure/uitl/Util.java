package org.zk.application.core.distconfigure.uitl;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by lishuhong on 16/6/1.
 */
public class Util {

    public static String EncoderByMd5(String str) throws Exception{
        //确定计算方法
        MessageDigest md5= MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
