package com.itheima.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Orders implements Serializable {
    private String id;//主键id
    private String orderNum;//订单编号
    private Date orderTime;//下单时间
    private String orderTimeStr;
//    private Integer peopleCount;//出行人数
    private String orderDesc;//订单描述
    private Integer payType ;//支付方式(0 支付宝 1 微信 2其它)
    private String payTypeStr;
    private Integer orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private String[] idStr;
    private Integer productId;//产品id外键
//    private Integer memberid;//会员id外键
    //多表一对一关系关联
    private Product product;

    public String[] getIdStr() {
        return idStr;
    }

    public void setIdStr(String[] idStr) {
        this.idStr = idStr;
    }

    public String getOrderTimeStr() {
        if (orderTime !=null){
            orderTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderTime);
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if (payType != null){
            if (payType ==0 ){
                payTypeStr="支付宝";
            }else if (payType == 1){
                payTypeStr="微信";
            }else if (payType == 2){
                payTypeStr="其他";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if (orderStatus != null){
            if (orderStatus == 0){
                orderStatusStr="未支付";
            }else if (orderStatus == 1) {
                orderStatusStr="已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }



    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
