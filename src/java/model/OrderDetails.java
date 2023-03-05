package model;


public class OrderDetails extends Products{
    private int orderdetailId, orderId, pId, cateId;
    private String pName;

    public OrderDetails(int orderId, int pId, String pName) {
        this.orderId = orderId;
        this.pId = pId;
        this.pName = pName;
    }

    public OrderDetails(int orderdetailId, int orderId, int pId, String pName) {
        this.orderdetailId = orderdetailId;
        this.orderId = orderId;
        this.pId = pId;
        this.pName = pName;
    }

    public OrderDetails(int orderdetailId, int orderId, String imgPath, String pName, String kichCo) {
        super(orderId , imgPath, pName, kichCo);
        this.orderdetailId = orderdetailId;
        this.orderId = orderId;
    }

    public OrderDetails(int orderdetailId, int orderId, int pId, String pName, String description, int cateId, String kichCo, String trongLuong, String price) {
        super(pId, pName, description, cateId, kichCo, trongLuong, price);
        this.orderdetailId = orderdetailId;
        this.orderId = orderId;
    }

    public OrderDetails(int orderdetailId, int orderId, int pId, int cateId, String pName) {
        this.orderdetailId = orderdetailId;
        this.orderId = orderId;
        this.pId = pId;
        this.cateId = cateId;
        this.pName = pName;
    }

    

    @Override
    public int getCateId() {
        return cateId;
    }

    @Override
    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    

   
    
    

    public int getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(int orderdetailId) {
        this.orderdetailId = orderdetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int getpId() {
        return pId;
    }

    @Override
    public void setpId(int pId) {
        this.pId = pId;
    }

    @Override
    public String getpName() {
        return pName;
    }

    @Override
    public void setpName(String pName) {
        this.pName = pName;
    }
}
