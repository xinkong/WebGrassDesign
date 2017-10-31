package com.grass.entity;


public class ImagesInfo {

  private String imageUrl;
  private long imageWidth;
  private long imageHeight;
  private long imageSize;
  public ImagesInfo(){}
  public ImagesInfo(String imageUrl, long imageWidth, long imageHeight, long imageSize) {
    this.imageUrl = imageUrl;
    this.imageWidth = imageWidth;
    this.imageHeight = imageHeight;
    this.imageSize = imageSize;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public long getImageWidth() {
    return imageWidth;
  }

  public void setImageWidth(long imageWidth) {
    this.imageWidth = imageWidth;
  }

  public long getImageHeight() {
    return imageHeight;
  }

  public void setImageHeight(long imageHeight) {
    this.imageHeight = imageHeight;
  }

  public long getImageSize() {
    return imageSize;
  }

  public void setImageSize(long imageSize) {
    this.imageSize = imageSize;
  }
}
