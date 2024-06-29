/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanClass;

/**
 *
 * @author Ammar
 */
public class transactionBean {
    private int accountId;
    private int transId;
    private String transType;
    private String amountType;
    private String dateOfTrans;
    private int amount;
    private String remarks;
    
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getDateOfTrans() {
        return dateOfTrans;
    }

    public void setDateOfTrans(String dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
   
    
    @Override
    public String toString(){       
        return     +amount+   "  " +transType;
    }
    }