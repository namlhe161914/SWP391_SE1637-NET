     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author nguye
 */
public class Informations {
    private int iId;
    private String title;
    private String coverImgPath;
    private String description;
    private String content;
    private Date createDate;
    private int accId;
    private int id;

    public Informations() {
    }

    public Informations(int iId, String title, String coverImgPath, String description,String content ,Date createDate, int accId, int id) {
        this.iId = iId;
        this.title = title;
        this.coverImgPath = coverImgPath;
        this.description = description;
        this.content = content;
        this.createDate = createDate;
        this.accId = accId;
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImgPath() {
        return coverImgPath;
    }

    public void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Informations{" + "iId=" + iId + ", title=" + title + ", coverImgPath=" + coverImgPath + ", description=" + description + ", createDate=" + createDate + ", accId=" + accId + ", id=" + id + '}';
    }
    
    

    
    
    
}
