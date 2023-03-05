/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Categories {
    private int cateId;
    private String cateName;
    private int status;
    private String cateCode;

    public Categories(int cateId, String cateName, int status, String cateCode) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.status = status;
        this.cateCode = cateCode;
    }
    
    public Categories(int cateId, String cateName, int status) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.status = status;
        
    }
    public Categories() {
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }
    
    
}
