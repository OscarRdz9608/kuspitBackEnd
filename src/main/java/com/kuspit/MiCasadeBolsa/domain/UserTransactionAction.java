package com.kuspit.MiCasadeBolsa.domain;


import java.time.LocalDateTime;

public class UserTransactionAction {

    private int userTransactionActionId;
    private String userId;
    private String userName;
    private String actionSymbol;
    private String companyActionName;
    private double actionPrice;
    private double actionVolume;
    private LocalDateTime transactionDate;


    public int getUserTransactionActionId() {
        return userTransactionActionId;
    }

    public void setUserTransactionActionId(int userTransactionActionId) {
        this.userTransactionActionId = userTransactionActionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getActionSymbol() {
        return actionSymbol;
    }

    public void setActionSymbol(String actionSymbol) {
        this.actionSymbol = actionSymbol;
    }

    public String getCompanyActionName() {
        return companyActionName;
    }

    public void setCompanyActionName(String companyActionName) {
        this.companyActionName = companyActionName;
    }

    public double getActionPrice() {
        return actionPrice;
    }

    public void setActionPrice(double actionPrice) {
        this.actionPrice = actionPrice;
    }

    public double getActionVolume() {
        return actionVolume;
    }

    public void setActionVolume(double actionVolume) {
        this.actionVolume = actionVolume;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
