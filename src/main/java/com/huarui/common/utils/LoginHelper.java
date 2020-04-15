package com.huarui.common.utils;

import com.github.tuzip.sso.Encrypt;
import com.github.tuzip.sso.SSOConfig;
import com.github.tuzip.sso.Token;
import com.github.tuzip.sso.common.CookieHelper;
import com.github.tuzip.sso.common.util.RandomUtil;
import com.github.tuzip.sso.exception.KissoException;
import com.github.tuzip.sso.common.util.ReflectUtil;
import com.huarui.common.config.Global;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHelper
/*     */ {
/*  37 */   private static final Logger logger = LoggerFactory.getLogger(LoginHelper.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Cookie generateCookie(HttpServletRequest request, Token token, Encrypt encrypt)
/*     */   {
/*     */     try
/*     */     {
/*  51 */       Cookie cookie = new Cookie(SSOConfig.getCookieName(),
/*  52 */         KissoHelper.encryptCookie(request, token, encrypt));
/*  53 */       cookie.setPath(SSOConfig.getCookiePath());
/*  54 */       cookie.setSecure(SSOConfig.getCookieSecure());
               cookie.setDomain(Global.getConfig("cookie.domain"));

/*  55 */       //cookie.setDomain(SSOConfig.getCookieDomain());
/*     */       
/*     */ 
/*     */ 
/*  59 */       int maxAge = SSOConfig.getCookieMaxage();
/*  60 */       if (maxAge >= 0) {
/*  61 */         cookie.setMaxAge(maxAge);
/*     */       }
/*  63 */       return cookie;
/*     */     } catch (Exception e) {
/*  65 */       logger.error("generateCookie is exception!", e.toString()); }
/*  66 */     return null;
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
/*     */   private static void setSSOCookie(HttpServletRequest request, HttpServletResponse response, Token token, Encrypt encrypt)
/*     */   {
/*  79 */     if (encrypt == null) {
/*  80 */       throw new KissoException(" Encrypt not for null.");
/*     */     }
/*     */     try {
/*  83 */       Cookie ck = generateCookie(request, token, encrypt);
/*  84 */       if (SSOConfig.getCookieHttponly())
/*     */       {
/*     */ 
/*     */ 
/*  88 */         CookieHelper.addHttpOnlyCookie(response, ck);
/*     */       } else {
/*  90 */         response.addCookie(ck);
/*     */       }
/*     */     } catch (Exception e) {
/*  93 */       logger.error("set HTTPOnly cookie createAUID is exception!", e.toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void setSSOCookie(HttpServletRequest request, HttpServletResponse response, Token token)
/*     */   {
/* 103 */     setSSOCookie(request, response, token, ReflectUtil.getConfigEncrypt());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void authSSOCookie(HttpServletRequest request, HttpServletResponse response, Token token)
/*     */   {
/* 113 */     CookieHelper.authJSESSIONID(request, RandomUtil.getCharacterAndNumber(8));
/* 114 */     setSSOCookie(request, response, token);
/*     */   }
/*     */ }

