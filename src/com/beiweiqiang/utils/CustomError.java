package com.beiweiqiang.utils;

public class CustomError extends RuntimeException{
  private String code ;  //异常对应的返回码
  private String msg;  //异常对应的描述信息

  public CustomError() {
    super();
  }

  public CustomError(String code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
