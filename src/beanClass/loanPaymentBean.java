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
public class loanPaymentBean {
    private int loanId;
    private int loanPayId;
    private String paymentDate;
    private String paymentAmount;
    private String lateFees;
    private String totalPay;
    private String remainder;
    private String remarks;
    
    public void setLoanId(int loanId){
        this.loanId= loanId;
    }
     public int getLoanId(){
         return loanId;
    } 
     public void setLoanPayId(int loanPayId){
        this.loanPayId= loanPayId;
    }
    public int getLoanPayId(){
        return loanPayId;
    }
    public void setPaymentDate(String paymentDate){
        this.paymentDate= paymentDate;
    }
    public String getPaymentDate(){
        return paymentDate;
    } 
    public void setPaymentAmount(String paymentAmount){
        this.paymentAmount =paymentAmount; 
    }
    public String getPaymentAmount(){
        return paymentAmount;
    }
    public void setLateFees(String lateFees){
        this.lateFees = lateFees;
    }
    public String getLateFees(){
        return lateFees;
    }
    public void setTotalPay(String totalPayq){
        this.totalPay= totalPay;
    }
    public String getTotalPay(){
        return totalPay;
    }
    public void setRemainder(String remainder){
        this.remainder= remainder;
    }
     public String getRemainder(){
        return remainder;
    }
     public void setRemarks(String remarks){
        this.remarks = remarks; 
    }
      public String getRemarks(){
         return remarks;
     }
      @ Override
      public String toString(){
          return paymentDate;
      }
}
