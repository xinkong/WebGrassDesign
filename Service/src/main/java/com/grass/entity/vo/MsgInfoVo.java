package com.grass.entity.vo;


import com.grass.entity.Comment;
import com.grass.entity.ImagesInfo;
import com.grass.entity.User;

import java.util.Date;
import java.util.List;

public class MsgInfoVo {

  private long id;
  private String msgContent;
  private String msgImages;
  private Date createTime;
  private User userInfo;
  private List<Comment> comments;
  private List<ImagesInfo> imagesInfo;


  public List<ImagesInfo> getImagesInfo() {
    return imagesInfo;
  }

  public void setImagesInfo(List<ImagesInfo> imagesInfo) {
    this.imagesInfo = imagesInfo;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(User userInfo) {
    this.userInfo = userInfo;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
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
