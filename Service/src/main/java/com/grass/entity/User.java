package com.grass.entity;


public class User {

  private long userId;
  private String userName;
  private String userPwd;
  private String userHeadPic;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public String getUserHeadPic() {
    return userHeadPic;
  }

  public void setUserHeadPic(String userHeadPic) {
    this.userHeadPic = userHeadPic;
  }
}
