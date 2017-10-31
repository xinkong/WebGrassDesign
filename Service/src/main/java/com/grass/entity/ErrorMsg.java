package com.grass.entity;

/**
 * 错误码提示
 */
public class ErrorMsg {

  private String errorCode;
  private String errorMessage;
  private String errorMessageClient;


  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessageClient() {
    return errorMessageClient;
  }

  public void setErrorMessageClient(String errorMessageClient) {
    this.errorMessageClient = errorMessageClient;
  }
}
