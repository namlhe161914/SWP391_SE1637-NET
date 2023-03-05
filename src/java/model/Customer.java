package model;

import java.sql.Date;

public class Customer {
    private int cusId;
    private String cusName, email;
    private String phone;
    private Date createdDate;
    private int token;
    public Customer() {
    }

    public int getCusId() {
        return cusId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    
    
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
    
    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(String cusName, String email, String phone) {
        this.cusName = cusName;
        this.email = email;
        this.phone = phone;
    }

    public Customer(int cusId, String cusName, String email, String phone) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.email = email;
        this.phone = phone;
    }

    public Customer(int cusId, String cusName, String email, String phone, Date createdDate) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.email = email;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    public Customer(int cusId, String cusName, String email, String phone, Date createdDate, int token) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.email = email;
        this.phone = phone;
        this.createdDate = createdDate;
        this.token = token;
    }
    
    
    
}
