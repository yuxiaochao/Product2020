package com.huarui.common.utils;

import com.github.tuzip.sso.Encrypt;
import com.github.tuzip.sso.SSOConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AESHelper
/*     */   extends Encrypt
/*     */ {
/*  18 */   private static final Logger LOGGER = LoggerFactory.getLogger(AESHelper.class);
/*     */   
/*     */   private static final String CipherMode = "AES/ECB/PKCS5Padding";
/*     */   private static final String ALGORITHM = "AES";
/*  22 */   SecretKeySpec secretKey = null;
/*     */   
/*  24 */   public AESHelper() { setKey(SSOConfig.getSecretKey()); }
/*     */   
/*     */   public AESHelper(String str)
/*     */   {
/*  28 */     setKey(str);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SecretKey getSecretKey()
/*     */   {
/*  43 */     return secretKey;
/*     */   }
/*     */   
/*     */   private void setKey(String key) {
/*  47 */     byte[] data = (byte[])null;
/*  48 */     if (key == null) {
/*  49 */       key = "";
/*     */     }
/*  51 */     StringBuffer sb = new StringBuffer(32);
/*  52 */     sb.append(key);
/*  53 */     while (sb.length() < 32) {
/*  54 */       sb.append("0");
/*     */     }
/*  56 */     if (sb.length() > 32) {
/*  57 */       sb.setLength(32);
/*     */     }
/*     */     try
/*     */     {
/*  61 */       data = sb.toString().getBytes(SSOConfig.getEncoding());
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/*  64 */       e.printStackTrace();
/*     */     }
/*  66 */     secretKey = new SecretKeySpec(data, "AES");
/*     */   }
/*     */   
/*     */ 
/*     */   public byte[] encrypt(byte[] content, String password)
/*     */   {
/*     */     try
/*     */     {
/*  74 */       Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
/*  75 */       cipher.init(1, secretKey);
/*  76 */       return cipher.doFinal(content);
/*     */     }
/*     */     catch (Exception e) {
/*  79 */       e.printStackTrace();
/*     */     }
/*  81 */     return null;
/*     */   }
/*     */   
/*     */   public String encrypt(String content, String key)
/*     */   {
/*  86 */     byte[] data = (byte[])null;
/*     */     try {
/*  88 */       data = content.getBytes(SSOConfig.getEncoding());
/*     */     } catch (Exception e) {
/*  90 */       e.printStackTrace();
/*     */     }
/*  92 */     data = encrypt(data, key);
/*  93 */     String result = byte2hex(data);
/*  94 */     return result;
/*     */   }
/*     */   
/*     */   public byte[] decrypt(byte[] content, String password)
/*     */   {
/*     */     try
/*     */     {
/* 101 */       Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
/* 102 */       cipher.init(2, secretKey);
/* 103 */       return cipher.doFinal(content);
/*     */     }
/*     */     catch (Exception e) {
/* 106 */       e.printStackTrace();
/*     */     }
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   public String decrypt(String content, String key)
/*     */   {
/* 113 */     byte[] data = (byte[])null;
/*     */     try {
/* 115 */       data = hex2byte(content);
/*     */     } catch (Exception e) {
/* 117 */       e.printStackTrace();
/*     */     }
/* 119 */     data = decrypt(data, key);
/* 120 */     if (data == null)
/* 121 */       return null;
/* 122 */     String result = null;
/*     */     try {
/* 124 */       result = new String(data, SSOConfig.getEncoding());
/*     */     } catch (UnsupportedEncodingException e) {
/* 126 */       e.printStackTrace();
/*     */     }
/* 128 */     return result;
/*     */   }
/*     */   
/*     */   public static String byte2hex(byte[] b)
/*     */   {
/* 133 */     StringBuffer sb = new StringBuffer(b.length * 2);
/* 134 */     String tmp = "";
/* 135 */     for (int n = 0; n < b.length; n++)
/*     */     {
/* 137 */       tmp = Integer.toHexString(b[n] & 0xFF);
/* 138 */       if (tmp.length() == 1) {
/* 139 */         sb.append("0");
/*     */       }
/* 141 */       sb.append(tmp);
/*     */     }
/* 143 */     return sb.toString().toUpperCase();
/*     */   }
/*     */   
/*     */   private static byte[] hex2byte(String inputString)
/*     */   {
/* 148 */     if ((inputString == null) || (inputString.length() < 2)) {
/* 149 */       return new byte[0];
/*     */     }
/* 151 */     inputString = inputString.toLowerCase();
/* 152 */     int l = inputString.length() / 2;
/* 153 */     byte[] result = new byte[l];
/* 154 */     for (int i = 0; i < l; i++) {
/* 155 */       String tmp = inputString.substring(2 * i, 2 * i + 2);
/* 156 */       result[i] = ((byte)(Integer.parseInt(tmp, 16) & 0xFF));
/*     */     }
/* 158 */     return result;
/*     */   }
/*     */ }



