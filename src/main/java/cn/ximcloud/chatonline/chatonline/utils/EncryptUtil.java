package cn.ximcloud.chatonline.chatonline.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * User: wzard
 * Date: 2018-03-29
 * Time: 18:26
 * ProjectName: chatonline
 * To change this template use File | Settings | File Templates.
 **/

public class EncryptUtil {
    private static Integer encryptType;

    public EncryptUtil(Integer encryptType) {
        this.encryptType = encryptType;
    }

//    public static String passwordMaker(String password) {
//        switch (encryptType) {
//            case 0: return md5PasswordMaker(password); break;
//        }
//    }

    public static String md5PasswordMaker(String password) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
