package com.grass.entity;


import java.util.Date;

public class Comment {

  private long id;
  private long msgId;
  private long commentUserId;
  private long replyUserId;
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

  public long getCommentUserId() {
    return commentUserId;
  }

  public void setCommentUserId(long commentUserId) {
    this.commentUserId = commentUserId;
  }

  public long getReplyUserId() {
    return replyUserId;
  }

  public void setReplyUserId(long replyUserId) {
    this.replyUserId = replyUserId;
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
