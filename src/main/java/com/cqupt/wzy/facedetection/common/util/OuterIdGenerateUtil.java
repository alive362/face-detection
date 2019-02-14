package com.cqupt.wzy.facedetection.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 外部id生成器
 *
 */
public class OuterIdGenerateUtil {

    /**
     * 公共的盐
     */
    public static final String COMMON_SALT = "3#223!@312&**%^";
    /**
     * 简单的字符格式化
     */
    public static final String FORMAT_SIMPLE = "%s_%s";
    /**
     * 图片前缀
     */
    public static final String IMAGE_PREFIX = "image1989%^&%^";
    /**
     * TOKEN前缀
     */
    public static final String TOKEN_PREFIX = "tokenlove32423%$^$%";
    /**
     * TOKEN前缀
     */
    public static final String TOKEN_SALT = "tokensalebbq@#$@";
    /**
     * 多台部署的时候用 TODO
     */
    public static final String MAC_ADDRESS = getMAC();
    private static String FORMAT_STRING = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHH");

    static {
        Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
            @Override
            public void run() {
                FORMAT_STRING = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHH");
            }
        }, 20, TimeUnit.MINUTES);
    }

    public static void main(String[] args) {

        System.out.println(generateOuterChangeId(11111100052L, IMAGE_PREFIX, COMMON_SALT));
    }

    public static String generateOuterChangeId(String sourceId, String prefix, String salt) {
        String result = DigestUtils.sha256Hex(String.format(FORMAT_SIMPLE, sourceId, prefix) + salt);
        return String.format("%s%s", result, FORMAT_STRING);
    }

    public static String generateOuterChangeId(long sourceId, String prefix, String salt) {
        return generateOuterChangeId(String.valueOf(sourceId), prefix, salt);
    }

    private static String hexByte(byte b) {
        String s = "000000" + Integer.toHexString(b);
        return s.substring(s.length() - 2);
    }

    private static String getMAC() {
        Enumeration<NetworkInterface> el;
        String mac_s = "";
        try {
            el = NetworkInterface.getNetworkInterfaces();
            while (el.hasMoreElements()) {
                byte[] mac = el.nextElement().getHardwareAddress();
                if (mac == null)
                    continue;
                mac_s = hexByte(mac[0]) + "-" + hexByte(mac[1]) + "-" + hexByte(mac[2]) + "-" + hexByte(mac[3]) + "-"
                        + hexByte(mac[4]) + "-" + hexByte(mac[5]);
                return mac_s;

            }
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        return mac_s;
    }

}
