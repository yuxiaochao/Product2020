package com.huarui.common.utils;

import com.github.tuzip.sso.Encrypt;
import com.github.tuzip.sso.SSOConfig;
import com.github.tuzip.sso.Token;
import com.github.tuzip.sso.common.Browser;
import com.github.tuzip.sso.common.CookieHelper;
import com.github.tuzip.sso.common.IpHelper;
import com.github.tuzip.sso.common.util.RandomUtil;
import com.github.tuzip.sso.exception.KissoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class KissoHelper
/*     */ {
/*  37 */   private static final Logger logger = LoggerFactory.getLogger(KissoHelper.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String encryptCookie(HttpServletRequest request, Token token, Encrypt encrypt)
/*     */     throws Exception
/*     */   {
/*  50 */     if (token == null) {
/*  51 */       throw new KissoException(" Token not for null.");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  56 */     String jt = token.jsonToken();
/*  57 */     StringBuffer sf = new StringBuffer();
/*  58 */     sf.append(jt);
/*  59 */     sf.append("#");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  64 */     if (SSOConfig.getCookieBrowser()) {
/*  65 */       sf.append(Browser.getUserAgent(request, jt));
/*     */     } else {
/*  67 */       sf.append(RandomUtil.getCharacterAndNumber(8));
/*     */     }
/*  69 */     //return encrypt.encrypt(sf.toString(), SSOConfig.getSecretKey());
			  return new AESHelper().encrypt(sf.toString(), SSOConfig.getSecretKey());
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
/*     */   public static Token checkIp(HttpServletRequest request, Token token)
/*     */   {
/*  84 */     if (SSOConfig.getCookieCheckip()) {
/*  85 */       String ip = IpHelper.getIpAddr(request);
/*  86 */       if ((token != null) && (ip != null) && (!ip.equals(token.getUserIp())))
/*     */       {
/*     */ 
/*     */ 
/*  90 */         logger.info("ip inconsistent! return token null, token userIp:{}, reqIp:{}", 
/*  91 */           new Object[] { token.getUserIp(), ip });
/*  92 */         return null;
/*     */       }
/*     */     }
/*  95 */     return token;
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
/*     */   public static String getJsonToken(HttpServletRequest request, Encrypt encrypt, String cookieName)
/*     */   {
/* 109 */     Cookie uid = CookieHelper.findCookieByName(request, cookieName);
/* 110 */     if (uid != null) {
/* 111 */       String jsonToken = uid.getValue();
/* 112 */       String[] tokenAttr = new String[2];
/*     */       try {
/* 114 */         jsonToken = encrypt.decrypt(jsonToken, SSOConfig.getSecretKey());
/* 115 */         tokenAttr = jsonToken.split("#");
/*     */       } catch (Exception e) {
/* 117 */         logger.info("jsonToken decrypt error.");
/* 118 */         e.printStackTrace();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 124 */       if (SSOConfig.getCookieBrowser()) {
/* 125 */         if (Browser.isLegalUserAgent(request, tokenAttr[0], tokenAttr[1])) {
/* 126 */           return tokenAttr[0];
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 131 */         logger.error("SSOHelper getToken, find Browser is illegal.");
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 138 */         return tokenAttr[0];
/*     */       }
/*     */     }
/*     */     
/* 142 */     return null;
/*     */   }
/*     */ }
