/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Products {
    private int pId;
    private String pName;
    private String imgPath;
    private String description;
    private int status;

    @Override
    public String toString() {
        return "Products{" + "pId=" + pId + ", pName=" + pName + ", imgPath=" + imgPath + ", kichCo=" + kichCo + ", trongLuong=" + trongLuong + '}';
    }
    private int cateId;
    private String kichCo;
    private String trongLuong;
    private String detailPath;
    private String price;

    public Products() {
    }

    public Products(int pId, String pName, String imgPath, String description, int status, int cateId, String kichCo, String trongLuong, String detailPath, String price) {
        this.pId = pId;
        this.pName = pName;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.cateId = cateId;
        this.kichCo = kichCo;
        this.trongLuong = trongLuong;
        this.detailPath = detailPath;
        this.price = price;
    }
    
     public Products(int pId,String imgPath, String pName, String kichCo) {
        this.pId = pId;
        this.imgPath = imgPath;
        this.pName = pName;
        this.kichCo = kichCo;
    }

    public Products(int pId, String pName, String imgPath, String description, int cateId, String kichCo, String trongLuong, String price) {
        this.pId = pId;
        this.pName = pName;
        this.imgPath = imgPath;
        this.description = description;
        this.cateId = cateId;
        this.kichCo = kichCo;
        this.trongLuong = trongLuong;
        this.price = price;
    }
     
     

    public Products(int pId, String pName, String description, int cateId, String kichCo, String trongLuong, String price) {
        this.pId = pId;
        this.pName = pName;
        this.description = description;
        this.cateId = cateId;
        this.kichCo = kichCo;
        this.trongLuong = trongLuong;
        this.price = price;
    }
     
     

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public int getCateId() {
        return cateId;
    }

    public String getKichCo() {
        return kichCo;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public String getDetailPath() {
        return detailPath;
    }

    public String getPrice() {
        return price;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public void setDetailPath(String detailPath) {
        this.detailPath = detailPath;
    }

    public void setPrice(String price) {
        this.price = price;
    }


  }
