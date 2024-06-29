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
public class loanBean {
    private int accountId;
    private int loanId;
    private String accountNumber;
    private String amount;
    private String monthLimit;
    private String qistLimit;
    private String intereset;
    private String profit;
    private String remarks;
    
    public void setAccountId(int accountId){
        this.accountId= accountId;
    }
    public int getAccountId(){
        return accountId;
    }
    public void setLoanId(int loanId){
        this.loanId= loanId;
    }
     public int getLoanId(){
         return loanId;
     }
    public void setAccountNumber(String accountNumber){
        this.accountNumber= accountNumber;
    }
    public String getAccountNumber(){
        return accountNumber;
    } 
    public void setAmount(String amount){
        this.amount =amount; 
    }
    public String getAmount(){
        return amount;
    }
    public void setMonthLimit(String monthLimit){
        this.monthLimit = monthLimit;
    }
    public String getMonthLimit(){
        return monthLimit;
    }
    public void setQistLimit(String qistLimit){
        this.qistLimit= qistLimit;
    }
    public String getQistLimit(){
        return qistLimit;
    }
    public void setIntereset(String intereset){
        this.intereset= intereset;
    }
     public String getIntereset(){
        return intereset;
    }
      public void setProfit(String profit){
        this.profit= profit;
    }
     public String getProfit(){
        return profit;
    }
     public void setRemarks(String remarks){
        this.remarks = remarks; 
    }
      public String getRemarks(){
         return remarks;
     }
      @ Override
      public String toString(){
          return amount;
      }

}


