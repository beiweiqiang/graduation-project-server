package com.beiweiqiang.model;

import com.beiweiqiang.utils.ClassCast;

public class UserQuestion {
  private String text;
  private int userId;
  private String responseText;

  public UserQuestion(String text, Double userId) {
    this.text = text;
    this.userId = ClassCast.doubleToInt(userId);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getResponseText() {
    return responseText;
  }

  public void setResponseText(String responseText) {
    this.responseText = responseText;
  }
}
