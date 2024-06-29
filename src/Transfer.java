
import DatabaseManager.databaseManager;
import beanClass.accountBean;
import beanClass.customerBean;
import beanClass.transactionBean;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ammar
 */
public class Transfer extends javax.swing.JFrame {

    

    /**
     * Creates new form Transfer
     */
    public Transfer() {
        initComponents();
        setTitle("Transaction Frame");
        setLocation(0,0);
        setSize(1400,720);
        getCustomer();
        getCustomer1();
    }
  
    private void transferAmount() {
    accountBean sourceAccount = (accountBean) sourceAccountCB.getSelectedItem();
    accountBean destinationAccount = (accountBean) destinationAccountCB.getSelectedItem();

    if (sourceAccount == null || destinationAccount == null) {
        return;
    }
    
    int amount = Integer.parseInt(amountTF.getText());
    String dateOfTransaction = dateOfTransactionTF.getText();
    String amountType = amountTypeTF.getText();
    String remarks=remarksTA.getText();
    
    try {
        // Get the previous transaction from the destination account
        Vector<transactionBean> previousTransaction = databaseManager.getTransaction(destinationAccount.getAccountId());

        if (previousTransaction != null && !previousTransaction.isEmpty()) {
            transactionBean lastTransaction = previousTransaction.get(previousTransaction.size() - 1);
            int previousAmountValue = lastTransaction.getAmount();

            // Add the transferred amount to the destination account's previous amount
            int updatedDestinationBalance = previousAmountValue + amount;

            // Update the balance of the destination account
            int rows1 = databaseManager.addTransaction(destinationAccount.getAccountId(), "D", amountType, dateOfTransaction, updatedDestinationBalance, remarks);

            if (rows1 >= 1) {
                // Get the previous transaction from the source account
                previousTransaction = databaseManager.getTransaction(sourceAccount.getAccountId());

                if (previousTransaction != null && !previousTransaction.isEmpty()) {
                    lastTransaction = previousTransaction.get(previousTransaction.size() - 1);
                    previousAmountValue = lastTransaction.getAmount();

                    // Subtract the transferred amount from the source account's previous amount
                    int updatedSourceBalance = previousAmountValue - amount;

                    // Update the balance of the source account
                    int rows2 = databaseManager.addTransaction(sourceAccount.getAccountId(), "W", amountType, dateOfTransaction, updatedSourceBalance, "");

                    if (rows2 >= 1) {
                        JOptionPane.showMessageDialog(this, "Amount transferred successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error occurred while updating source account balance");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No previous transaction found for the source account");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error occurred while updating destination account balance");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No previous transaction found for the destination account");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        e.printStackTrace();
    }
}//end transferAmount


    
    private void getCustomer(){
      
        try{
            Vector v=databaseManager.getCustomer();
            sourceCustomerCB.removeAllItems();
               for(int i=0; i<v.size();  i++ ){ 
                    customerBean  bean =(customerBean)v.elementAt(i);
                    sourceCustomerCB.addItem(bean);
                }        

        }catch(Exception e){
            e.printStackTrace ();
          JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
        }      
    }//end getCustomer
    
     private void getCustomer1(){
      
        try{
            Vector v=databaseManager.getCustomer();
            destinationCustomerCB.removeAllItems();
               for(int i=0; i<v.size();  i++ ){ 
                    customerBean  bean =(customerBean)v.elementAt(i);
                    destinationCustomerCB.addItem(bean);
                }        

        }catch(Exception e){
            e.printStackTrace ();
          JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
        }      
    }//end getCustomer
    
    private void getAccount(){
            customerBean bean=(customerBean) sourceCustomerCB.getSelectedItem();
            if(bean==null) return;
            try{
                sourceAccountCB.removeAllItems();
                 Vector v=databaseManager.getAccount(bean.getCustomerId());

            for(int i=0;i<v.size();i++){
                accountBean bean1=(accountBean)v.elementAt(i);
                sourceAccountCB.addItem(bean1);
            }
        }//end try block
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
        }//end catch
    }//end getAccount
    
     private void getAccount1(){
            customerBean bean=(customerBean) destinationCustomerCB.getSelectedItem();
            if(bean==null) return;
            try{
                destinationAccountCB.removeAllItems();
                 Vector v=databaseManager.getAccount(bean.getCustomerId());

            for(int i=0;i<v.size();i++){
                accountBean bean1=(accountBean)v.elementAt(i);
                destinationAccountCB.addItem(bean1);
            }
        }//end try block
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
        }//end catch
    }//end getAccount1
    
     private void getTransaction(){
        accountBean bean = (accountBean)sourceAccountCB.getSelectedItem();
        if(bean==null)return;
            try{
                Vector v = databaseManager.getTransaction(bean.getAccountId());
                TransactionL.setListData(v);
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
            }
           
    }//end getTransaction
    
     private void getTransaction1(){
        accountBean bean = (accountBean)destinationAccountCB.getSelectedItem();
        if(bean==null)return;
            try{
                Vector v = databaseManager.getTransaction(bean.getAccountId());
                TransactionL1.setListData(v);
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
            }
           
    }//end getTransaction
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sourceCustomerCB = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        dateOfTransactionTF = new javax.swing.JTextField();
        transferButton = new javax.swing.JButton();
        backB = new javax.swing.JButton();
        amountTypeTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sourceAccountCB = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TransactionL = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        transactionIdTF = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TransactionL1 = new javax.swing.JList();
        jLabel13 = new javax.swing.JLabel();
        destinationAccountCB = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        dateOfTransactionTF1 = new javax.swing.JTextField();
        amountTypeTF1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        amountTF1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        destinationCustomerCB = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        transactionIdTF1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTA = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        remarksTA1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 800));
        setMinimumSize(new java.awt.Dimension(700, 650));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("SOURCE ACCOUNT ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 170, 120, 50);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("SOURCE CUSTOMER");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 110, 130, 50);

        sourceCustomerCB.setBackground(new java.awt.Color(255, 51, 102));
        sourceCustomerCB.setEditable(true);
        sourceCustomerCB.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        sourceCustomerCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceCustomerCBActionPerformed(evt);
            }
        });
        getContentPane().add(sourceCustomerCB);
        sourceCustomerCB.setBounds(150, 110, 330, 50);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("DATE OF TRANASACTION");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 360, 150, 50);

        dateOfTransactionTF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(dateOfTransactionTF);
        dateOfTransactionTF.setBounds(150, 360, 330, 50);

        transferButton.setBackground(new java.awt.Color(255, 0, 204));
        transferButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        transferButton.setForeground(new java.awt.Color(255, 255, 255));
        transferButton.setText("TRANSFER");
        transferButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transferButtonMouseClicked(evt);
            }
        });
        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferButtonActionPerformed(evt);
            }
        });
        getContentPane().add(transferButton);
        transferButton.setBounds(180, 620, 330, 50);

        backB.setBackground(new java.awt.Color(255, 0, 0));
        backB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backB.setForeground(new java.awt.Color(255, 255, 255));
        backB.setText("BACK");
        backB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBMouseClicked(evt);
            }
        });
        getContentPane().add(backB);
        backB.setBounds(520, 620, 250, 50);

        amountTypeTF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(amountTypeTF);
        amountTypeTF.setBounds(150, 420, 330, 50);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("AMOUNT TYPE");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 420, 90, 50);

        amountTF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(amountTF);
        amountTF.setBounds(150, 300, 330, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("AMOUNT ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 300, 60, 50);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel1.setText("TRANSFER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 10, 550, 80);

        sourceAccountCB.setBackground(new java.awt.Color(255, 51, 102));
        sourceAccountCB.setEditable(true);
        sourceAccountCB.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        sourceAccountCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceAccountCBActionPerformed(evt);
            }
        });
        getContentPane().add(sourceAccountCB);
        sourceAccountCB.setBounds(150, 170, 330, 50);

        TransactionL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TransactionL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                TransactionLValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(TransactionL);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(490, 110, 170, 500);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("SOURCE ACCOUNT LIST");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(490, 80, 170, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("TRANSACTION ID");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 250, 130, 40);

        transactionIdTF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionIdTF.setEnabled(false);
        getContentPane().add(transactionIdTF);
        transactionIdTF.setBounds(150, 240, 180, 50);

        TransactionL1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TransactionL1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                TransactionL1ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(TransactionL1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(1170, 110, 200, 500);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("DESTINATION ACCOUNT LIST");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(1170, 80, 230, 40);

        destinationAccountCB.setEditable(true);
        destinationAccountCB.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        destinationAccountCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationAccountCBActionPerformed(evt);
            }
        });
        getContentPane().add(destinationAccountCB);
        destinationAccountCB.setBounds(830, 170, 330, 50);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("DATE OF TRANASACTION");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(680, 360, 150, 50);

        dateOfTransactionTF1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(dateOfTransactionTF1);
        dateOfTransactionTF1.setBounds(830, 360, 330, 50);

        amountTypeTF1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(amountTypeTF1);
        amountTypeTF1.setBounds(830, 420, 330, 50);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("AMOUNT TYPE");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(740, 420, 90, 50);

        amountTF1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(amountTF1);
        amountTF1.setBounds(830, 300, 330, 50);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("AMOUNT ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(770, 300, 60, 50);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("DESTINATION ACCOUNT");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(680, 170, 140, 50);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("DESTINATION CUSTOMER");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(670, 110, 160, 50);

        destinationCustomerCB.setEditable(true);
        destinationCustomerCB.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        destinationCustomerCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationCustomerCBActionPerformed(evt);
            }
        });
        getContentPane().add(destinationCustomerCB);
        destinationCustomerCB.setBounds(830, 110, 330, 50);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("TRANSACTION ID");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(720, 250, 110, 40);

        transactionIdTF1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactionIdTF1.setEnabled(false);
        getContentPane().add(transactionIdTF1);
        transactionIdTF1.setBounds(830, 240, 180, 50);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("REMARKS");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(30, 510, 100, 40);

        remarksTA.setColumns(20);
        remarksTA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksTA.setRows(5);
        jScrollPane1.setViewportView(remarksTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 500, 330, 110);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("REMARKS");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(720, 510, 100, 40);

        remarksTA1.setColumns(20);
        remarksTA1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksTA1.setRows(5);
        jScrollPane4.setViewportView(remarksTA1);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(830, 500, 330, 110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sourceCustomerCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceCustomerCBActionPerformed
        getAccount();
        
    }//GEN-LAST:event_sourceCustomerCBActionPerformed

    private void transferButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferButtonMouseClicked
        //addRecord();

        TransactionTypes ob= new TransactionTypes();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_transferButtonMouseClicked

    private void backBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBMouseClicked
        TransactionTypes ob= new TransactionTypes();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_backBMouseClicked

    private void sourceAccountCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceAccountCBActionPerformed
        // TODO add your handling code here:
        getTransaction();
    }//GEN-LAST:event_sourceAccountCBActionPerformed

    private void transferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferButtonActionPerformed
        // TODO add your handling code here:
        transferAmount();
    }//GEN-LAST:event_transferButtonActionPerformed

    private void TransactionLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TransactionLValueChanged
        transactionBean bean =(transactionBean)TransactionL.getSelectedValue();
        if(bean==null)return;

        transactionIdTF.setText(""+bean.getTransId());
        amountTF.setText(""+bean.getAmount());
        amountTypeTF.setText(bean.getAmountType());
       // transTypeCB.setSelectedItem(Decoder.transactionTypeDecode(bean.getTransType()));
        dateOfTransactionTF.setText(""+bean.getDateOfTrans());
        remarksTA.setText(""+bean.getRemarks());

    }//GEN-LAST:event_TransactionLValueChanged

    private void TransactionL1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_TransactionL1ValueChanged
        // TODO add your handling code here:
        transactionBean bean =(transactionBean)TransactionL1.getSelectedValue();
        if(bean==null)return;

        transactionIdTF1.setText(""+bean.getTransId());
        amountTF1.setText(""+bean.getAmount());
        amountTypeTF1.setText(bean.getAmountType());
        dateOfTransactionTF1.setText(""+bean.getDateOfTrans());
        remarksTA1.setText(""+bean.getRemarks());                        
     
    }//GEN-LAST:event_TransactionL1ValueChanged

    private void destinationAccountCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationAccountCBActionPerformed
        // TODO add your handling code here:
        getTransaction1();
    }//GEN-LAST:event_destinationAccountCBActionPerformed

    private void destinationCustomerCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationCustomerCBActionPerformed
        // TODO add your handling code here:
        getAccount1();
    }//GEN-LAST:event_destinationCustomerCBActionPerformed

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList TransactionL;
    private javax.swing.JList TransactionL1;
    private javax.swing.JTextField amountTF;
    private javax.swing.JTextField amountTF1;
    private javax.swing.JTextField amountTypeTF;
    private javax.swing.JTextField amountTypeTF1;
    private javax.swing.JButton backB;
    private javax.swing.JTextField dateOfTransactionTF;
    private javax.swing.JTextField dateOfTransactionTF1;
    private javax.swing.JComboBox destinationAccountCB;
    private javax.swing.JComboBox destinationCustomerCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea remarksTA;
    private javax.swing.JTextArea remarksTA1;
    private javax.swing.JComboBox sourceAccountCB;
    private javax.swing.JComboBox sourceCustomerCB;
    private javax.swing.JTextField transactionIdTF;
    private javax.swing.JTextField transactionIdTF1;
    private javax.swing.JButton transferButton;
    // End of variables declaration//GEN-END:variables

   
}
