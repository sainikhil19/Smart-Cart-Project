package com.example.sainikhil.smartcartproject;

public class ImageClick {
    private String imageName;
    private int imageid;

    public ImageClick() {
    }

    public ImageClick(String imageName, int imageid) {
        this.imageName = imageName;
        this.imageid = imageid;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
