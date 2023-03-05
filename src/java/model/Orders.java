package model;

import java.util.Date;

public class Orders{
    private int orderId;
    private String orderDate;
    private int status;
    private String phone;

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", status=" + status + ", phone=" + phone + ", cusId=" + cusId + '}';
    }
    private int cusId;

    public Orders(int orderId, String orderDate, int status, String phone, int cusId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.phone = phone;
        this.cusId = cusId;
    }

    public Orders(String orderDate, int status, String phone, int cusId) {
        this.orderDate = orderDate;
        this.status = status;
        this.phone = phone;
        this.cusId = cusId;
    }

    public Orders(int orderId, String orderDate, String phone, int cusId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.phone = phone;
        this.cusId = cusId;
    }

    public Orders() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }
}
