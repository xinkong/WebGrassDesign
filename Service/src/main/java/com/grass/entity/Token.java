package com.grass.entity;


import java.util.Date;

public class Token {

  private String id;
  private long userId;
  private Date careatTime;
  private Date updateTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public Date getCareatTime() {
    return careatTime;
  }

  public void setCareatTime(Date careatTime) {
    this.careatTime = careatTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
