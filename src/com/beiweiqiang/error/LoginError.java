package com.beiweiqiang.error;

public class LoginError extends RuntimeException{
  private int code = 1001;  //异常对应的返回码
  private String msg = "Username or password error!";  //异常对应的描述信息

  public LoginError() {
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

