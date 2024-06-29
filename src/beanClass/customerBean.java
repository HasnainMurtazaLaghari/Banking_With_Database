/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanClass;

import java.util.Date;

/**
 *
 * @author Ammar
 */
public class customerBean {
    private int customerId;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String address;
    private String email;
    private String dateOfCreate;
    private String contactNo;
    private String remarks;
    
    public void setCustomerId(int customerId){
        this.customerId= customerId;
    }
    public void setFirstName(String firstName){
        this.firstName= firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setCity(String city){
        this.city =city; 
    }
    public void setState(String state){
        this.state= state;
    }
    public void setCountry(String country){
        this.country= country;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setEmail(String email){
        this.email =email; 
    }
    public void setDateOfCreate(String dateOfCreate){
        this.dateOfCreate = dateOfCreate ;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
     public void setRemarks(String remarks){
        this.remarks = remarks; 
    }
     
    public int getCustomerId(){
         return customerId;
     }
     
     public String getFirstName(){
         return firstName;
     }
     public String getLastName(){
         return lastName;
     }
     public String getCity(){
         return city;
     }
     
    public String getState(){
         return state;
     }
     
     public String getCountry(){
         return country;
     }
     public String getAddress(){
         return address;
     }
     public String getEmail(){
         return email;
     }
     public String getDateOfCreate(){
            return dateOfCreate;
     }
     public String getContactNo(){
         return contactNo;
     }
      public String getRemarks(){
         return remarks;
     }
      @ Override
      public String toString(){
          return firstName;
      }

}
  




