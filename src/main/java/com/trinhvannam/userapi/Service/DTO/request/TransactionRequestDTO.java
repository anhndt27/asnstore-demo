package com.trinhvannam.userapi.Service.DTO.request;

import com.trinhvannam.userapi.Model.Order;
import com.trinhvannam.userapi.Model.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionRequestDTO {
    private long id;
    private float transactionTotalPay;
    private String userAddress;
    private String userEmail;
    private String userPhone;
    private String userFirstName;
    private String userLastName;
    private List<OrderRequestDTO> listProduct = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTransactionTotalPay() {
        return transactionTotalPay;
    }

    public void setTransactionTotalPay(float transactionTotalPay) {
        this.transactionTotalPay = transactionTotalPay;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public List<OrderRequestDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<OrderRequestDTO> listProduct) {
        this.listProduct = listProduct;
    }
}
