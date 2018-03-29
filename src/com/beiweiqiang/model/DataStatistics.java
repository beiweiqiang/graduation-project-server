package com.beiweiqiang.model;

public class DataStatistics {
  private int userId;
  private String value;
  private String groupName;

  public DataStatistics(int userId) {
    this.userId = userId;
  }

  public DataStatistics(int userId, String groupName) {
    this.userId = userId;
    this.groupName = groupName;
  }

  public int getUserId() {
    return userId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
