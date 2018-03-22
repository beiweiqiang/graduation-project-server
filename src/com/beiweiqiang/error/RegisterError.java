package com.beiweiqiang.error;

public class RegisterError extends RuntimeException {
  private int code = 1001;
  private String msg = "username already exist!";

  public RegisterError() {

  }
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
