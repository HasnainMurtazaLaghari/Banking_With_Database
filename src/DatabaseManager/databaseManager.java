/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

//import DecodeAndEncode.Encoder;
//import DecodeAndEncode.Encoder;
import beanClass.accountBean;
import beanClass.customerBean;
import beanClass.loanBean;
import beanClass.loanPaymentBean;
import beanClass.transactionBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Ammar
 */
public class databaseManager {
  private static Connection con;
    
    static{
        
        try{
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            System.out.println("Successfully connection with Database 1");
            
            String file="E:\\1.Java\\3.Database\\6.E-BankingHamidNew\\BankingNew.accdb";
            
            con=DriverManager.getConnection("jdbc:ucanaccess://"+file);
            
            System.out.println("Successfully connection with Database 2");
            
        }catch(Exception e){JOptionPane.showMessageDialog(null," Error: "+e.getMessage()); e.printStackTrace();}
    }
    
    public static Vector  getCustomer() throws Exception{
        String  query = "select * from customer";
        System.out.println(query);
        Statement st = null;
        ResultSet result=null;

        try{
        st=con.createStatement();
        result=st.executeQuery(query);
        Vector v= new Vector();

        while(result.next()){
            customerBean bean = new customerBean();
            bean.setCustomerId(result.getInt("customer_id"));
            bean.setFirstName(result.getString("first_name"));
            bean.setLastName(result.getString("last_name"));
            bean.setCity(result.getString("city"));
            bean.setState(result.getString("state"));
            bean.setCountry(result.getString("country"));
            bean.setAddress(result.getString("address"));
            bean.setEmail(result.getString("email"));
            bean.setDateOfCreate(result.getString("date_of_create"));
            bean.setContactNo(result.getString("contact_no"));
            bean.setRemarks(result.getString("remarks"));
            v.addElement(bean);
        }
        return v;

                }finally{
            if (result!=null)
                result.close();
            if(st!=null)
                st.close();
            }
    }//END getCUSTOMER
    
    public static Vector  getAccount(int customerId) throws Exception{
            String  query = "select * from accounts where customer_id = "+customerId;
            System.out.println(query);
            Statement st = null;
            ResultSet result=null;

            try{
            st=con.createStatement();
            result=st.executeQuery(query);
            Vector v= new Vector();

            while(result.next()){
                accountBean bean = new accountBean();
                bean.setCustomerId(result.getInt("customer_id"));
                bean.setAccountId(result.getInt("account_id"));
                bean.setAccountNo(result.getString("account_no"));
                bean.setPinCode(result.getInt("pin_code"));
                bean.setDateOfCreate(result.getString("date_of_create"));
                bean.setAccType(result.getString("acc_type"));
                bean.setAmount(result.getInt("amount"));
                bean.setRemarks(result.getString("remarks"));
                v.addElement(bean);
            }
            return v;

                    }finally{
                if (result!=null)
                    result.close();
                if(st!=null)
                    st.close();
                }

    }//END getACCOUNT

    public static Vector getTransaction(int accountId)throws Exception{
          String  query = "select * from transaction where account_id = "+accountId;
          System.out.println(query);
          Statement st = null;
          ResultSet result = null ;
          try{
              st=con.createStatement();
              result=st.executeQuery(query);
          Vector v = new Vector();
          while(result.next()  ){
              transactionBean bean = new transactionBean();
              bean.setAccountId(result.getInt("account_id"));
              bean.setTransId(result.getInt("trans_id"));
              bean.setTransType(result.getString("trans_type"));
              bean.setAmountType(result.getString("amount_type"));
              bean.setDateOfTrans(result.getString("date_of_trans"));
              bean.setAmount(result.getInt("amount")); 
              bean.setRemarks(result.getString("remarks"));
              v.addElement(bean);
          }
          return v ;
          }finally{
              if(result!=null)
                  result.close();
              if(st!=null)
                  st.close();
          }
    }//END getTRANSACTION
    
    /*
public static Vector  getLoan(int accountId) throws Exception{
String  query = "select * from loan where account_id= "+accountId;
System.out.println(query);
Statement st = null;
ResultSet result=null;

try{
st=con.createStatement();
result=st.executeQuery(query);
Vector v= new Vector();

while(result.next()){
    loanBean bean = new loanBean();
    
    bean.setAccountId(result.getInt("account_id"));
    bean.setLoanId(result.getInt("loan_id"));
    bean.setAccountNumber(result.getString("account_number"));
    bean.setAmount(result.getString("amount"));
    bean.setMonthLimit(result.getString("month_limit"));
    bean.setQistLimit(result.getString("qist_limit"));
    bean.setIntereset(result.getString("intereset"));
    bean.setProfit(result.getString("profit"));
    bean.setRemarks(result.getString("remarks"));
    v.addElement(bean);
}
return v;
        
        }finally{
    if (result!=null)
        result.close();
    if(st!=null)
        st.close();
    }

 }
public static Vector  getLoanPayment(int loanId) throws Exception{
String  query = "select * from loanpayment where loan_id= "+loanId;
System.out.println(query);
Statement st = null;
ResultSet result=null;

try{
st=con.createStatement();
result=st.executeQuery(query);
Vector v= new Vector();

while(result.next()){
    loanPaymentBean bean = new loanPaymentBean();
    
    bean.setLoanId(result.getInt("loan_id"));
    bean.setLoanPayId(result.getInt("loan_pay_id"));
    bean.setPaymentDate(result.getString("payment_date"));
    bean.setPaymentAmount(result.getString("payment_amount"));
    bean.setLateFees(result.getString("late_fees"));
    bean.setTotalPay(result.getString("total_pay"));
    bean.setRemainder(result.getString("remainder"));
    bean.setRemarks(result.getString("remarks"));
    v.addElement(bean);
}
return v;
        
        }finally{
    if (result!=null)
        result.close();
    if(st!=null)
        st.close();
    }

 }
*/
    public static int  deleteCustomer (int customerId) throws Exception{
        String query= "delete from customer where customer_id=" +customerId ;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }//END deleteCUSTOMER

    public static int  deleteAccount (int accountId) throws Exception{
        String query= "delete from account where account_id=" +accountId ;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }//END deleteACCOUNT

    public static int  deleteTransaction (int transId) throws Exception{
        String query= "delete from transaction where trans_id = " +transId ;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }//END deleteTRANSACTION
/*
public static int  deleteLoan (int loanId) throws Exception{
    String query= "delete from loan where loan_id=" +loanId ;
    System.out.println(query);
    Statement st=null;
    try{
        st=con.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
    }finally{
        if(st!=null)
            st.close();
    }
}
public static int  deleteLoanPayment (int loanPayId) throws Exception{
    String query= "delete from loanpayment where loan_pay_id=" +loanPayId ;
    System.out.println(query);
    Statement st=null;
    try{
        st=con.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
    }finally{
        if(st!=null)
            st.close();
    }
}
*/
    public static int  updateCustomer (int customerId, String firstName,String lastName,String city,String state,String country,String address,String email,String dateOfCreate,String contactNo,String remarks) throws Exception{
        String query= "update  customer set first_name ='"+firstName+"',last_name ='"+lastName+"',city ='"+city+"',state ='"+state+"',country ='"+country+"',address ='"+address+"',email ='"+email+"',date_of_create ='"+dateOfCreate+"',contact_no ='"+contactNo+"',remarks ='"+remarks+"' where customer_id= " +customerId ;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }//END updateCUSTOMER

    public static int  updateAccount (int accountId,String accountNo,int pinCode,String dateOfCreate,int amount,String accType,String remarks) throws Exception{
        String query= "update  accounts set account_No ='"+accountNo+"',pin_code ='"+pinCode+"',date_of_create ='"+dateOfCreate+"',amount="+amount+",acc_type ='"+accType+"', remarks='"+remarks+"' where account_id = " +accountId ;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }//END updateACCOUNT
    
    public static int updateTransaction(int transId, String transType, String amountType, String dateOfTrans, int amount, String remarks) throws Exception {
        String query = "UPDATE transaction SET trans_type='" + transType + "', amount_type='" + amountType + "', date_of_trans='" + dateOfTrans + "', amount='" + amount + "', remarks='" + remarks + "' WHERE trans_id=" + transId;
        System.out.println(query);
        Statement st = null;
        try{
            st = con.createStatement();
            int rows = st.executeUpdate(query);
            return rows;
        }finally {
            if (st != null)
                st.close();
        }
    }//END updateTRANSACTION

/*
public static int  updateLoan(int loanId,String accountNumber,String amount,String monthLimit,String qistLimit,String intereset,String profit,String remarks) throws Exception{
    String query= "update  loan set account_number ="+accountNumber+",amount='"+amount+"' ,month_limit ='"+monthLimit+"',qist_limit ='"+qistLimit+"',intereset ='"+intereset+"',profit ='"+profit+"',remarks='"+remarks+"'where loan_id =" +loanId ;
    System.out.println(query);
    Statement st=null;
    try{
        st=con.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
    }finally{
        if(st!=null)
            st.close();
    }
}
public static int  updateLoanPayment(int loanPayId,String paymentDate,String paymentAmount,String lateFees,String totalPay,String remainder,String remarks) throws Exception{
    String query= "update  loanpayment set payment_date ="+paymentDate+",payment_amount='"+paymentAmount+"' ,late_fees ='"+lateFees+"',total_pay ='"+totalPay+"',remainder ='"+remainder+"',remarks='"+remarks+"'where loan_pay_id =" +loanPayId ;
    System.out.println(query);
    Statement st=null;
    try{
        st=con.createStatement();
        int rows=st.executeUpdate(query);
        return rows;
    }finally{
        if(st!=null)
            st.close();
    }
}*/

    public static int  addCustomer(String firstName,String lastName,String city,String state,String country,String address,String email,String dateOfCreate,String contactNo,String remarks) throws Exception{
        String query= "insert into customer (first_name,last_name,city,state,country,address,email,date_of_create,contact_no,remarks) values('"+firstName+"','"+lastName+"','"+city+"','"+state+"','"+country+"','"+address+"','"+email+"','"+dateOfCreate+"','"+contactNo+"','"+remarks+"')"; 
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }

    public static int  addAccount(int customerId,String accountNo,int pinCode,String dateOfCreate,int amount,String accType,String remarks) throws Exception{

        String query= "insert into accounts (customer_id,account_no,pin_code,date_of_create,amount,acc_type,remarks) values("+customerId+",'"+accountNo+"','"+pinCode+"','"+dateOfCreate+"',"+amount+",'"+accType+"','"+remarks+"')"; 
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }

public static int addTransaction(int accountId,String transType,String amountType,String dateOfTrans,int amount,String remarks) throws Exception{

        String query= "insert into transaction (account_id,trans_type,amount_type,date_of_trans,amount,remarks) values("+accountId+",'"+transType+"','"+amountType+"','"+dateOfTrans+"','"+amount+"','"+remarks+"')"; 
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null)
                st.close();
        }
    }
   
    public static int addTransactionD(int tra,int accountId,int amount ,String amountType,String dateOfTransaction,String transactionType)throws Exception{
        String query1 ="select balance from account where account_no = "+accountId; 
        Statement st = null ;
        ResultSet result = null ;    
         try{
            int am ;
            st=con.createStatement();
            result=st.executeQuery(query1);
            Vector v = new Vector();
            if(result.next()){
                 am=result.getInt("balance");
           
            int amount1 =am+amount;
             String query2 = "update  transaction set total_amount= "+amount1 +" where transaction_id = "+tra ; 
             String query3 = "update  account  set balance= "+amount1 +" where account_no = "+accountId ; 
             String query = "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount)values("+accountId+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"',"+amount1+" )";
             System.out.println(query);
             int row1 = st.executeUpdate(query);
            int row2 = st.executeUpdate(query2);
            int row3 = st.executeUpdate(query3);
            return row1 + row2 + row3;
            
            }
    }finally{        if(st!=null)st.close(); }
        return 0;
    }//end transaction Deposite i am not using this method
   
    public static int addTransactionW(int tra,int accountId,int amount ,String amountType,String dateOfTransaction,String transactionType,int cheque)throws Exception{
        String query1 ="select balance from account where account_no = "+accountId; 
        Statement st = null ;
        ResultSet result = null ;
             
         try{
            int am ;
            st=con.createStatement();
            result=st.executeQuery(query1);
            Vector v = new Vector();
            if(result.next()){
                 am=result.getInt("balance");
             if(am >=amount){
            int amount1 =am-amount;
             String query2 = "update  transaction set total_amount= "+amount1 +" where transaction_id = "+tra ; 
             String query3 = "update  account  set balance= "+amount1 +" where account_no = "+accountId ; 
             String query = "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount,cheque)values("+accountId+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"',"+amount1+" ,"+cheque+" )";
       System.out.println(query);
             int row1 = st.executeUpdate(query);
            int row2 = st.executeUpdate(query2);
            int row3 = st.executeUpdate(query3);
            return row1 + row2 + row3;
             }else
                JOptionPane.showMessageDialog(null,"balance not availble ");
            }
    }finally{
        if(st!=null)st.close();
    }
        return 0;
    }//end transaction Withdraw i am not using this method
    /*
    public static int addTransactionTransfer(int tra,int accountId,int amount ,String amountType,String dateOfTransaction,String transactionType,int transferAccount)throws Exception{
        String query1 ="select balance from account where account_no = "+accountId; 
        String queryT ="select balance from account where account_no = "+transferAccount;         
        Statement st2= null ;
        Statement st = null ;
        ResultSet result2= null ;
        ResultSet result=null;     
         try{
            int am ,tamount;
            st=con.createStatement();
            result=st.executeQuery(query1);
          
            st2=con.createStatement();
            result2=st2.executeQuery(queryT);
            
            Vector v = new Vector();
            if(result.next() && result2.next()){
                 am=result.getInt("balance");
                 tamount =  result2.getInt("balance");
            int transferAmount = tamount+amount;
            int amount1 =am-amount;
            int tr1=tra+1;
             String query2 = "update  transaction set total_amount= "+amount1 +" where transaction_id = "+tra+" and amount_no = "+accountId ; 
             String queryT2 = "update  transaction set total_amount= "+transferAmount +" where transaction_id = "+tr1+" and amount_no = "+transferAccount ;
             String query3 = "update  account  set balance= "+transferAmount +" where account_no = "+transferAccount ; 
             String query4 = "update  account  set balance= "+amount1 +" where account_no = "+accountId ; 
             
             String query =         "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount)values("+accountId+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"',"+amount1+" )";
             String queryTransfer = "insert into transaction(amount_no,amount,amount_type,date_of_transaction,transaction_type,total_amount)values("+transferAccount+ " ,"+amount+",'"+amountType+"','"+dateOfTransaction+"','"+transactionType+"', "+transferAmount+")";
       
             System.out.println(query);
             System.out.println(queryT);
            
             System.out.println(queryTransfer);
       
            int row1 = st.executeUpdate(query);
            int row2 = st.executeUpdate(query2);
            int row3 = st.executeUpdate(query3);
            int row4 = st.executeUpdate(query4);
            int row5 = st.executeUpdate(queryT2);
            int row6 = st.executeUpdate(queryTransfer);
            return row1 + row2 + row3 +row4 + row5 + row6 ;
              
            }
    }finally{
        if(st!=null && st2!=null)st.close();
    }
        return 0;
    }
  public static int addLoan(int accountId, String accountNumber, String amount,String monthLimit,String qistLimit,String intereset, String profit, String remarks)throws Exception{
      String query="insert into loan(account_id, account_number, amount, month_limit, qist_limit,intereset,profit,remarks)values( "+accountId+", '"+accountNumber+"', "+amount+", '"+monthLimit+"', '"+qistLimit+"','"+intereset+"','"+profit+"', '"+remarks+"')";
       System.out.println(query);
       
       Statement st=null;
       
       try{
           st=con.createStatement();
           int rows=st.executeUpdate(query);
           return rows;
       }
       finally{
           if(st!=null)st.close();
       }
   
    } // end AddTransactions
   public static int addLoanPayment(int loanId, String paymentDate, String paymentAmount,String lateFees,String totalPay,String remainder, String remarks)throws Exception{
      String query="insert into loanpayment(loan_id, payment_date, payment_amount, late_fees, total_pay, remainder ,remarks)values( "+loanId+", '"+paymentDate+"', "+paymentAmount+", '"+lateFees+"', '"+totalPay+"','"+remainder+"', '"+remarks+"')";
       System.out.println(query);
       
       Statement st=null;
       
       try{
           st=con.createStatement();
           int rows=st.executeUpdate(query);
           return rows;
       }
       finally{
           if(st!=null)st.close();
       }
   
    } // end AddTransactions
*/

    public static void main(String arg[]){
         databaseManager ob=new databaseManager();
    
    }

   
}//END class databaseManager