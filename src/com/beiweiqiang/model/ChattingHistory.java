package com.beiweiqiang.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.sql.Timestamp;

public class ChattingHistory {
  private int id;
  private int userId;
  private String fromWho;
  private String messageContent;
  private Timestamp createTime;
/*
 * 0 来自个人
 * 1 来自群组
 */
  private int messageType;
  private String groupName;
  private String originTitle;
  private String originContent;

  public ChattingHistory() {
  }

  public ChattingHistory(int userId, Timestamp createTime, String originTitle, String originContent) {
    this.userId = userId;
    this.createTime = createTime;
    this.originTitle = originTitle;
    this.originContent = originContent;
  }

  public ChattingHistory(int id, int userId, String fromWho, String messageContent, Timestamp createTime, int messageType, String groupName, String originTitle, String originContent) {
    this.id = id;
    this.userId = userId;
    this.fromWho = fromWho;
    this.messageContent = messageContent;
    this.createTime = createTime;
    this.messageType = messageType;
    this.groupName = groupName;
    this.originTitle = originTitle;
    this.originContent = originContent;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getFromWho() {
    return fromWho;
  }

  public void setFromWho(String fromWho) {
    this.fromWho = fromWho;
  }

  public String getMessageContent() {
    return messageContent;
  }

  public void setMessageContent(String messageContent) {
    this.messageContent = messageContent;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public int getMessageType() {
    return messageType;
  }

  public void setMessageType(int messageType) {
    this.messageType = messageType;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getOriginTitle() {
    return originTitle;
  }

  public void setOriginTitle(String originTitle) {
    this.originTitle = originTitle;
  }

  public String getOriginContent() {
    return originContent;
  }

  public void setOriginContent(String originContent) {
    this.originContent = originContent;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
