package com.grass.entity.vo;


import com.grass.entity.User;

import java.util.Date;

public class CommentVo {

  private long id;
  private long msgId;
  private User commentUser;
  private User replyUser;
  private String content;
  private Date createTime;


  public long getMsgId() {
    return msgId;
  }

  public void setMsgId(long msgId) {
    this.msgId = msgId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getCommentUser() {
    return commentUser;
  }

  public void setCommentUser(User commentUser) {
    this.commentUser = commentUser;
  }

  public User getReplyUser() {
    return replyUser;
  }

  public void setReplyUser(User replyUser) {
    this.replyUser = replyUser;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
