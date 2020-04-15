package com.huarui.common.utils;

import com.huarui.common.config.Global;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * 对称加密解密AES算法
 *
 */
public class AESUtils {



    public static byte[] generatorKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(Global.AES_IV);
        keyGenerator.init(256);//默认128，获得无政策权限后可为192或256
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    public static IvParameterSpec getIv() throws UnsupportedEncodingException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(Global.AES_IV.getBytes("utf-8"));
        return ivParameterSpec;
    }

    public static String encrypt(String src, String key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes("utf-8"), Global.ALGORITHM);
        IvParameterSpec ivParameterSpec = getIv();
        Cipher cipher = Cipher.getInstance(Global.ALGORITHM_PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] cipherBytes = cipher.doFinal(src.getBytes(Charset.forName("utf-8")));
        return byteToHexString(cipherBytes);
    }

    public static String decrypt(String src, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes("utf-8"), Global.ALGORITHM);

        IvParameterSpec ivParameterSpec = getIv();
        Cipher cipher = Cipher.getInstance(Global.ALGORITHM_PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] hexBytes = hexStringToBytes(src);
        byte[] plainBytes = cipher.doFinal(hexBytes);
        return new String(plainBytes,"utf-8");
    }

    /**
     * 将byte转换为16进制字符串
     * @param src
     * @return
     */
    public static String byteToHexString(byte[] src) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xff;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                sb.append("0");
            }
            sb.append(hv);
        }
        return sb.toString();
    }

    /**
     * 将16进制字符串装换为byte数组
     * @param hexString
     * @return
     */
    public static byte[] hexStringToBytes(String hexString) {
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] b = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            b[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return b;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

//    public static void main(String[] args) {
//        try {
//            // byte key[] = generatorKey();
//            // 密钥必须是16的倍数
//            String key = "itjJrF7vNqjVNn5K";//hexStringToBytes("0123456789ABCDEF");
//            String src = "START=1&LIMIT=10&TACT005=9&KEYWORD=&llog001=6146e4e54b5948efb5acc7f917a33e2d&USER001=bb5412bc6c2740e08a9442efe2b7bed8";
//            System.out.println("密钥:"+byteToHexString(key.getBytes("utf-8")));
//            System.out.println("原字符串:"+src);
//
//            String enc = encrypt(src, key);
//            System.out.println("加密："+enc);
//            System.out.println("解密："+decrypt(enc, key));
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (IllegalBlockSizeException e) {
//            e.printStackTrace();
//        } catch (BadPaddingException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}