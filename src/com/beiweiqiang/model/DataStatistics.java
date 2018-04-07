package com.beiweiqiang.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DataStatistics {
  private int userId;
  private String value;
  private int type;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public DataStatistics(int userId, int type) {

    this.userId = userId;
    this.type = type;
  }

  public int getUserId() {
    return userId;
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

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }
}
