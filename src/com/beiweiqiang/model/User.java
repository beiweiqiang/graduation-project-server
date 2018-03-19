package com.beiweiqiang.model;

import java.sql.Timestamp;

public class User {
  private int id;
  private String username;
  private String password;
  private Timestamp createTime;
  private Timestamp lastLoginTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public User(int id, String username, String password, Timestamp createTime, Timestamp lastLoginTime) {

    this.id = id;
    this.username = username;
    this.password = password;
    this.createTime = createTime;
    this.lastLoginTime = lastLoginTime;
  }

  @Override
  public String toString() {
    return User.class.toString() + ": " + id + ", " + username + ", " + password + ", " + createTime + ", " + lastLoginTime;
  }
}
