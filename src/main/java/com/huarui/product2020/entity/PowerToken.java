package com.huarui.product2020.entity;

import com.github.tuzip.sso.Token;

public class PowerToken extends Token
/*    */ {
/*    */   private String username;
/*    */   private String userid;
/*    */   private String authTime;
/*    */   private String endTime;
/*    */   private String resourceId;
/*    */   
/*    */   public String getUsername() {
/* 12 */     return username;
/*    */   }
/*    */   
/* 15 */   public String getUserid() { return userid; }
/*    */   
/*    */   public String getAuthTime() {
/* 18 */     return authTime;
/*    */   }
/*    */   
/* 21 */   public String getEndTime() { return endTime; }
/*    */   
/*    */   public String getResourceId() {
/* 24 */     return resourceId;
/*    */   }
/*    */   
/* 27 */   public void setUsername(String username) { this.username = username; }
/*    */   
/*    */   public void setUserid(String userid) {
/* 30 */     this.userid = userid;
/*    */   }
/*    */   
/* 33 */   public void setAuthTime(String authTime) { this.authTime = authTime; }
/*    */   
/*    */   public void setEndTime(String endTime) {
/* 36 */     this.endTime = endTime;
/*    */   }
/*    */   
/* 39 */   public void setResourceId(String resourceId) { this.resourceId = resourceId; }
/*    */ }
