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
public class Decoder {
    
    public static String accountTypeDecode(String accountType){
        switch (accountType){
            case "SA":return "SAVING ACCOUNT";
            case "CA":return "CURRENT ACCOUNT";
            case "PLS":return "PROFIT LOSS SHARING";
            }
    return accountType;   
}// end AccountTypeDecode
    
 public static String transactionTypeDecode(String transactionType){
        switch (transactionType){
            case "D":return "DEPOSITE";
            case "W":return "WITHDRAW";
            }
    return transactionType;   
}//  end transactionsType
 
    public static String amountTypeDecode(String amountType){
        switch (amountType){
            case "CK":return "CHECK";
            case "OL":return "ONLINE";
            case "DD":return "DEMAND DRAFT";
            case "PO":return "PAY ORDER";
            }
    return amountType;   
}// end transactionsType
}
