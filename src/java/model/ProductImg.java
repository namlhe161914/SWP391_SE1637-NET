/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenam
 */
public class ProductImg {
    private int imgId;
    private int pId;
    private String imgPath;

    public ProductImg() {
    }

    public ProductImg(int imgId, int pId, String imgPath) {
        this.imgId = imgId;
        this.pId = pId;
        this.imgPath = imgPath;
    }

    public int getImgId() {
        return imgId;
    }

    public int getpId() {
        return pId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    

    
}
