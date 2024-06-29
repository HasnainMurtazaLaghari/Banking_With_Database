/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DecodeAndEncode;

/**
 *
 * @author Ntech
 */
public class Encoder {
    
  public static String  accountTypeEncode(String accountType){
      
    switch (accountType){
        
            case "SAVING ACCOUNT":return "SA";
            case "CURRENT ACCOUNT":return "CA";
            case "PROFIT LOSS SHARING":return "PLS";
    }
    return accountType;
}    // end accountTypeEncode
   
public static String  transactionTypeEncode(String transactionType){
    
    switch (transactionType){
        
            case "DEPOSITE" :return "D";
            case "WITHDRAW" :return "W";
            
    }
    return transactionType;
} // end transactionsType
public static String  amountTypeEncode(String amountType){
    
    switch (amountType){
        
            case "CHECK":return "CK";
            case "ONLINE":return "OL";
            case "DEMAND DRAFT":return "DD";
            case "PAY ORDER":return "PO";
    }
    return amountType;
}    // end amountTypeEncode
    

   // public static Encoder TransactionsTypeEncode(Encoder transTpye) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
}
