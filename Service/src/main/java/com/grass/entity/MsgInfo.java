package com.grass.entity;


import java.util.Date;
import java.util.List;

public class MsgInfo {

  private long id;
  private long userId;
  private String msgContent;
  private String msgImages;
  private Date createTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getMsgContent() {
    return msgContent;
  }

  public void setMsgContent(String msgContent) {
    this.msgContent = msgContent;
  }

  public String getMsgImages() {
    return msgImages;
  }

  public void setMsgImages(String msgImages) {
    this.msgImages = msgImages;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
