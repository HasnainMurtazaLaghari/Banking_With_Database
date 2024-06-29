/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import beanClass.accountBean;
import beanClass.customerBean;
import beanClass.transactionBean;
import DatabaseManager.databaseManager;
import DecodeAndEncode.Decoder;
import DecodeAndEncode.Encoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**public TransactionsFrame() {
        initComponents();
        setTitle("Transaction Frame");
        setLocation(0,0);
        setSize(970,720);
        getCustomer();
    }
 *
 * @author Ntech
 */
public class Transaction extends javax.swing.JFrame {
    public Transaction() {
        initComponents();
        setTitle("Transaction Frame");
        setLocation(0,0);
        setSize(970,720);
         transTypeCB.addItem("DEPOSITE");
         transTypeCB.addItem("WITHDRAW");
        
        amountTypeCB.addItem("CHECK");
        amountTypeCB.addItem("ONLINE");
        amountTypeCB.addItem("DEMAND DRAFT");
        amountTypeCB.addItem("PAY ORDER");
        getCustomer();
    }
  // Assuming 'frame' is the name of your JFrame instance
//frame2.setExtendedState(Frame.MAXIMIZED_BOTH);
           //Transaction.setSize(900,800);
        private void clear() {
            amountTypeCB.setSelectedIndex(0);
            depositeButton.setSelected(false);
            withdrawButton.setSelected(false);
            dateTF.setText("");
            amountTF.setText("");
            remarksTA.setText("");


    }
    
    private void getCustomer(){

       try{
           Vector v=databaseManager.getCustomer();
           customerCB.removeAllItems();
              for(int i=0; i<v.size();  i++ ){ 
                   customerBean  bean =(customerBean)v.elementAt(i);
                   customerCB.addItem(bean);
               } 
       }catch(Exception e){
           e.printStackTrace ();
           JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
       }      
    }//end getCustomer
    
    private void getAccount(){
        customerBean bean=(customerBean) customerCB.getSelectedItem();
        if(bean==null) return;
            try{
                accountCB.removeAllItems();
                Vector v=databaseManager.getAccount(bean.getCustomerId());

                for(int i=0;i<v.size();i++){
                    accountBean bean1=(accountBean)v.elementAt(i);
                    accountCB.addItem(bean1);
                }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
        }//end catch
    }//end getAccount
    
    private void getTransaction(){
        accountBean bean = (accountBean)accountCB.getSelectedItem();
        if(bean==null)return;
         currentBalanceTF.setText(""+bean.getAmount());
            try{
                Vector v = databaseManager.getTransaction(bean.getAccountId());
                
                TransactionL.setListData(v);
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
            }
           
    }//end getTransaction
    
    private void addRecord() {
        accountBean bean = (accountBean) accountCB.getSelectedItem();
        if (bean == null) return;
            String amountType   = Encoder.amountTypeEncode((String)amountTypeCB.getSelectedItem());
            String transType    = Encoder.transactionTypeEncode((String)transTypeCB.getSelectedItem());
            String dateOfTrans  = dateTF.getText();
            int amount          = Integer.parseInt(amountTF.getText());
            String remarks      = remarksTA.getText();
        
        try {
            int rows = databaseManager.addTransaction(bean.getAccountId(),transType,amountType, dateOfTrans, amount, remarks);
            if (rows >= 1)
                JOptionPane.showMessageDialog(this, rows + " RECORD ADDED");
            clear();
            getTransaction();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//end addRecord

    private void updateRecord(){
        transactionBean bean = (transactionBean) TransactionL.getSelectedValue();
        if (bean == null) return;
           String amountType   = Encoder.amountTypeEncode((String)amountTypeCB.getSelectedItem());
           String transType    = Encoder.transactionTypeEncode((String)transTypeCB.getSelectedItem());
           String dateOfTrans  = dateTF.getText();
           int    amount       = Integer.parseInt(amountTF.getText());
           String remarks      = remarksTA.getText();

        try {
             int rows=databaseManager.updateTransaction(bean.getTransId(),transType,amountType,dateOfTrans,amount,remarks);
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"RECORD UPDATED ");
                clear();
                getTransaction();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                e.printStackTrace();
            }
    }//end updateRecord

    private void deleteRecord(){
        transactionBean bean = (transactionBean)TransactionL.getSelectedValue();
        if(bean==null)return;
            try{
                  int rows = databaseManager.deleteTransaction(bean.getTransId());
                  if(rows>=1)
                        JOptionPane.showMessageDialog(this, rows+" RECORD DELETED ");
                    getTransaction();
                }catch(Exception e){
                        JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                        e.printStackTrace();
                }
    }  //end deleteRecord
    
    private void Deposite() {
//        transactionBean bean = (transactionBean) TransactionL.getSelectedValue();
//        if (bean == null) return;
//            try {
//                Vector previousAmount = databaseManager.getTransaction(bean.getAccountId());
//                if (previousAmount.isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "Previous amount not found");
//                    return;
//                }
//                transactionBean previousTransaction = (transactionBean) previousAmount.get(previousAmount.size() - 1);
//                int previousAmountValue = previousTransaction.getAmount();
//
//                int depositeAmount = Integer.parseInt(amountTF.getText()); // Assuming amountTF is a JTextField
//                int newAmount = previousAmountValue + depositeAmount;
//                amountTF.setText(String.valueOf(newAmount));
//            }catch (Exception e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//            }
         accountBean bean = (accountBean)accountCB.getSelectedItem();
            if (bean == null) return;

            // Update current balance in text field
            currentBalanceTF.setText(String.valueOf(bean.getAmount()));
            int currentBalance = bean.getAmount();
            System.out.println("Current Balance: " + currentBalance);

            try {
                // Retrieve transaction amount from text field
                String amountText = amountTF.getText();
                if (amountText.isEmpty()||amountText==null) {
                    JOptionPane.showMessageDialog(this, "Amount cannot be empty. Please enter a valid amount.");
                    System.out.println("Inside Emptty: " + amountText);
                         
                }

                int transactionAmount = Integer.parseInt(amountText);

                // Retrieve transaction type from combo box
                String transType = transTypeCB.getSelectedItem().toString();

                if (transType.equals("DEPOSIT")) {
                    int newAmount = currentBalance + transactionAmount;
                    System.out.println("New Amount: " + newAmount);

                    customerBean cb = (customerBean)customerCB.getSelectedItem();
                    if (cb == null) return;

                    String accountNo = bean.getAccountNo();
                    int pinCode = bean.getPinCode();
                    String dateOfCreate = bean.getDateOfCreate();
                    String accType = Encoder.accountTypeEncode(bean.getAccType());
                    String remarks = bean.getRemarks();
                    int amount = newAmount;

                    try {
                        int rows = databaseManager.updateAccount(bean.getCustomerId(), accountNo, pinCode, dateOfCreate, amount, accType, remarks);
                        if (rows >= 1) {
                            JOptionPane.showMessageDialog(this, rows + ": RECORD UPDATED");

                            // Update current balance in the text field
                            currentBalanceTF.setText(""+amount);
                           // clear();
                            // getAccount();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                        e.printStackTrace();
                    }

                    // Update transaction list
                    Vector<Integer> v = new Vector<>();
                    v.add(newAmount);
                    TransactionL.setListData(v);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.");
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage());
                e.printStackTrace();
            }

    }//end Deposite button method

    private void Withdraw() {
        transactionBean bean = (transactionBean) TransactionL.getSelectedValue();
        if (bean == null) return;
            try {
                Vector previousAmount = databaseManager.getTransaction(bean.getAccountId());
                if (previousAmount.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Previous amount not found");
                    return;
                }
                transactionBean previousTransaction = (transactionBean) previousAmount.get(previousAmount.size() - 1);
                int previousAmountValue = previousTransaction.getAmount();

                int withdrawAmount = Integer.parseInt(amountTF.getText()); // Assuming amountTF is a JTextField
                int newAmount = previousAmountValue -withdrawAmount;
                amountTF.setText(String.valueOf(newAmount));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
    }//end withdraw button method
    
    private void processTransaction() {
        transactionBean bean = (transactionBean) TransactionL.getSelectedValue();
        if (bean == null) return;
            try {
                Vector previousAmount = databaseManager.getTransaction(bean.getAccountId());
                if (previousAmount.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Previous amount not found");
                    return;
                }
                transactionBean previousTransaction = (transactionBean) previousAmount.get(previousAmount.size() - 1);
                int previousAmountValue = previousTransaction.getAmount();

                int transactionAmount = Integer.parseInt(amountTF.getText()); // Assuming amountTF is a JTextField
                String transType = transTypeCB.getSelectedItem().toString(); // Assuming comboBox is your combo box

                if (transType.equals("DEPOSITE")) {
                    //int newAmount =previousAmount  +  transactionAmount;
                    int newAmount =  transactionAmount;
                    amountTF.setText(String.valueOf(newAmount));
                } else if (transType.equals("WITHDRAW")) {
                     //int newAmount =previousAmount  -  transactionAmount;
                    int newAmount =transactionAmount;
                    amountTF.setText(String.valueOf(newAmount));
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
    }//end transTypeCB Method processTransaction
    
    /*
    private void Process() {
    String transType = (String) transTypeCB.getSelectedItem();
    
    if (transType.equals("DEPOSITE")) {
        Deposite();
    } else if (transType.equals("WITHDRAW")) {
        Withdraw();
    }
}
    */
    



    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        customerCB = new javax.swing.JComboBox();
        accountCB = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTA = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TransactionL = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        transactionButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();
        dateTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        depositeButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        addB = new javax.swing.JButton();
        withdrawButton = new javax.swing.JButton();
        amountTypeCB = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        transTypeCB = new javax.swing.JComboBox();
        transactionIdTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        depositeTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        withdrawTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        currentBalanceTF = new javax.swing.JTextField();

        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1200, 8000));
        setSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CUSTOMER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 60, 80, 60);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ACCOUNT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 130, 68, 60);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("REMARKS");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(590, 460, 90, 40);

        customerCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerCBActionPerformed(evt);
            }
        });
        getContentPane().add(customerCB);
        customerCB.setBounds(220, 60, 370, 60);

        accountCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accountCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountCBActionPerformed(evt);
            }
        });
        getContentPane().add(accountCB);
        accountCB.setBounds(220, 130, 370, 60);

        remarksTA.setColumns(20);
        remarksTA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksTA.setRows(5);
        jScrollPane1.setViewportView(remarksTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(610, 490, 350, 80);

        backButton.setBackground(new java.awt.Color(255, 0, 51));
        backButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("BACK");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(610, 640, 350, 50);

        TransactionL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TransactionL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                TransactionLValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(TransactionL);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(610, 60, 350, 400);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("TRANSACTION LIST");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(610, 30, 230, 30);

        transactionButton.setBackground(new java.awt.Color(102, 0, 204));
        transactionButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        transactionButton.setForeground(new java.awt.Color(255, 255, 255));
        transactionButton.setText("TRANSACTION TYPES");
        transactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transactionButton);
        transactionButton.setBounds(220, 640, 380, 50);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("TRANSACTION ID");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(220, 180, 130, 40);

        amountTF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(amountTF);
        amountTF.setBounds(410, 490, 190, 80);

        dateTF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(dateTF);
        dateTF.setBounds(220, 490, 180, 80);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("DATE OF TRANSACTION");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(220, 460, 170, 40);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("TRANSACTION");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 250, 40);

        depositeButton.setBackground(new java.awt.Color(0, 102, 102));
        depositeButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        depositeButton.setForeground(new java.awt.Color(255, 255, 255));
        depositeButton.setText("DEPOSITE");
        depositeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(depositeButton);
        depositeButton.setBounds(410, 380, 190, 80);

        updateButton.setBackground(new java.awt.Color(153, 102, 0));
        updateButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(610, 580, 110, 50);

        deleteButton.setBackground(new java.awt.Color(153, 102, 0));
        deleteButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(730, 580, 120, 50);

        clearButton.setBackground(new java.awt.Color(153, 102, 0));
        clearButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(860, 580, 100, 50);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("AMOUNT");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(410, 460, 90, 40);

        addB.setBackground(new java.awt.Color(153, 0, 153));
        addB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addB.setForeground(new java.awt.Color(255, 255, 255));
        addB.setText("ADD");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });
        getContentPane().add(addB);
        addB.setBounds(220, 580, 380, 50);

        withdrawButton.setBackground(new java.awt.Color(204, 0, 0));
        withdrawButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        withdrawButton.setForeground(new java.awt.Color(255, 255, 255));
        withdrawButton.setText("WITHDRAW");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawButton);
        withdrawButton.setBounds(220, 380, 180, 80);

        amountTypeCB.setBackground(new java.awt.Color(0, 102, 0));
        amountTypeCB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(amountTypeCB);
        amountTypeCB.setBounds(220, 300, 180, 70);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("TRANSACTION TYPE");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(410, 260, 150, 40);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("AMOUNT TYPE");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(220, 260, 120, 40);

        transTypeCB.setBackground(new java.awt.Color(0, 102, 0));
        transTypeCB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transTypeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transTypeCBActionPerformed(evt);
            }
        });
        getContentPane().add(transTypeCB);
        transTypeCB.setBounds(410, 300, 190, 70);

        transactionIdTF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionIdTF.setEnabled(false);
        getContentPane().add(transactionIdTF);
        transactionIdTF.setBounds(220, 210, 180, 60);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("DEPOSITE");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 190, 70, 17);

        depositeTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(depositeTF);
        depositeTF.setBounds(70, 210, 140, 60);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("WITHDRAW");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 280, 77, 17);

        withdrawTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(withdrawTF);
        withdrawTF.setBounds(70, 300, 140, 70);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Current Balance");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(70, 370, 120, 17);

        currentBalanceTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(currentBalanceTF);
        currentBalanceTF.setBounds(70, 390, 140, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountCBActionPerformed
      getTransaction();        // TODO add your handling code here:
      
    }//GEN-LAST:event_accountCBActionPerformed

    private void customerCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerCBActionPerformed
       getAccount();           // TODO add your handling code here:
     
    }//GEN-LAST:event_customerCBActionPerformed

    private void TransactionLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TransactionLValueChanged
      transactionBean bean =(transactionBean)TransactionL.getSelectedValue();
        if(bean==null)return;
   
     
        transactionIdTF.setText(""+bean.getTransId());
        amountTF.setText(""+bean.getAmount());
        amountTypeCB.setSelectedItem(Decoder.amountTypeDecode(bean.getAmountType()));
        transTypeCB.setSelectedItem(Decoder.transactionTypeDecode(bean.getTransType()));
        dateTF.setText(""+bean.getDateOfTrans());
        remarksTA.setText(""+bean.getRemarks());
        
        
    }//GEN-LAST:event_TransactionLValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void transactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionButtonActionPerformed
        // TODO add your handling code here:
        TransactionTypes ob = new TransactionTypes();
         ob.setVisible(true);
         dispose();
         
    }//GEN-LAST:event_transactionButtonActionPerformed

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
//   Bank ob = new Bank();
//    ob.setVisible(true);
//    dispose();
    }//GEN-LAST:event_backButtonMouseClicked

    private void depositeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositeButtonActionPerformed
        // TODO add your handling code here:
        transTypeCB.setSelectedItem("DEPOSITE");
      //  Deposite();
        accountBean bean = (accountBean)accountCB.getSelectedItem();
            if (bean == null) return;

            // Update current balance in text field
            currentBalanceTF.setText(String.valueOf(bean.getAmount()));
            int currentBalance = bean.getAmount();
            System.out.println("Current Balance: " + currentBalance);

            try {
                // Retrieve transaction amount from text field
               

                int transactionAmount =  Integer.parseInt(amountTF.getText());
                      System.out.println("transactionAmount: " + transactionAmount);
                // Retrieve transaction type from combo box
                String transType = transTypeCB.getSelectedItem().toString();

                if (transType.equals("DEPOSIT")) {
                    int newAmount = currentBalance + transactionAmount;
                    System.out.println("New Amount: " + newAmount);

                    customerBean cb = (customerBean)customerCB.getSelectedItem();
                    if (cb == null) return;

                    String accountNo = bean.getAccountNo();
                    int pinCode = bean.getPinCode();
                    String dateOfCreate = bean.getDateOfCreate();
                    String accType = Encoder.accountTypeEncode(bean.getAccType());
                    String remarks = bean.getRemarks();
                    int amount = newAmount;

                    try {
                        int rows = databaseManager.updateAccount(bean.getCustomerId(), accountNo, pinCode, dateOfCreate, amount, accType, remarks);
                        if (rows >= 1) {
                            JOptionPane.showMessageDialog(this, rows + ": RECORD UPDATED");

                            // Update current balance in the text field
                            currentBalanceTF.setText(""+amount);
                           // clear();
                            // getAccount();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                        e.printStackTrace();
                    }

                    // Update transaction list
                    Vector<Integer> v = new Vector<>();
                    v.add(newAmount);
                    TransactionL.setListData(v);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.");
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage());
                e.printStackTrace();
            }
    }//GEN-LAST:event_depositeButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        updateRecord();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteRecord();

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_addBActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        // TODO add your handling code here:
        transTypeCB.setSelectedItem("WITHDRAW");
        Withdraw();
    }//GEN-LAST:event_withdrawButtonActionPerformed

    private void transTypeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transTypeCBActionPerformed
        // TODO add your handling code here:
       //processTransaction();
        //Deposite();
        //Withdraw();
      //  Process();
        accountBean bean = (accountBean)accountCB.getSelectedItem();
        if(bean==null)return;
        currentBalanceTF.setText(""+bean.getAmount());
        int currentBalance=bean.getAmount();
        System.out.println("currentBalance:"+currentBalance);
               
              
        int transactionAmount = Integer.parseInt(amountTF.getText()); // Assuming amountTF is a JTextField
        System.out.println("transactionAmount:"+transactionAmount);
        String transType = transTypeCB.getSelectedItem().toString(); // Assuming comboBox is your combo box
        int newAmount=0;
                if (transType.equals("DEPOSITE")) {
                    //int newAmount =previousAmount  +  transactionAmount;
                     newAmount =  transactionAmount+currentBalance;
                     System.out.println("New Amount:"+newAmount);
                    customerBean cb=(customerBean)customerCB.getSelectedItem();
                    if(cb==null)return;  
                    String  accountNo     = bean.getAccountNo();
                    int     pinCode       = bean.getPinCode();
                    String  dateOfCreate  = bean.getDateOfCreate();
                    String  accType       = Encoder.accountTypeEncode(bean.getAccType());
                    String  remarks       = bean.getRemarks();
                    int amount            = newAmount;
                    try{
                        int rows= databaseManager.updateAccount(bean.getCustomerId(),accountNo,pinCode,dateOfCreate,amount,accType,remarks);
                        if(rows>=1)
                            JOptionPane.showMessageDialog(this, rows+":RECORD UPDATED ");
                        clear();
                       // getAccount();
                    }catch(Exception e){
                           JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                           e.printStackTrace();
                    } 
                    Vector v=new Vector();
                    v.add(newAmount);
                    TransactionL.setListData(v);
                    currentBalanceTF.setText(String.valueOf(newAmount));
                    
                    
                } else if (transType.equals("WITHDRAW")) {
                     //int newAmount =previousAmount  -  transactionAmount;
                   // int newAmount =transactionAmount;
                    amountTF.setText(String.valueOf(newAmount));
                }
      
    }//GEN-LAST:event_transTypeCBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList TransactionL;
    private javax.swing.JComboBox accountCB;
    private javax.swing.JButton addB;
    private javax.swing.JTextField amountTF;
    private javax.swing.JComboBox amountTypeCB;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField currentBalanceTF;
    private javax.swing.JComboBox customerCB;
    private javax.swing.JTextField dateTF;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton depositeButton;
    private javax.swing.JTextField depositeTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea remarksTA;
    private javax.swing.JComboBox transTypeCB;
    private javax.swing.JButton transactionButton;
    private javax.swing.JTextField transactionIdTF;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton withdrawButton;
    private javax.swing.JTextField withdrawTF;
    // End of variables declaration//GEN-END:variables

    private static class setSize {

        public setSize() {
        }
    }
}
