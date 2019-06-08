package com.mark.vote.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Properties;

@Slf4j
public class MD5Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 返回大写MD5
     *
     * @param origin
     * @param charsetname
     * @return
     */
    private static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)){
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }
            else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));

            }
        } catch (Exception exception) {
            log.error("加密失败-加密方式传参错误");
        }
        return resultString.toUpperCase();
    }


    public static String MD5EncodeUtf8(String origin) {
        ClassPathResource classPathResource = new ClassPathResource("application.properties");
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(classPathResource);
            String property = properties.getProperty("password.salt", "");
            origin = origin + property;
            return MD5Encode(origin, "utf-8");
        } catch (IOException e) {
            log.error("MD5加密失败-获取盐值属性失败");
            e.printStackTrace();
        }
        return null;
    }


    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}
