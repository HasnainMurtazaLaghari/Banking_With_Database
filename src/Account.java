/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beanClass.accountBean;
import beanClass.customerBean;
import DatabaseManager.databaseManager;
import DecodeAndEncode.Decoder;
import DecodeAndEncode.Encoder;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ntech
 */
public class Account extends javax.swing.JFrame {

    public Account() {
        initComponents();
        getCustomer();
        
             accountTypeCB.addItem("SAVING ACCOUNT");
             accountTypeCB.addItem("CURRENT ACCOUNT");
             accountTypeCB.addItem("PROFIT LOSS SHARING");
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==addButton)
            addRecord();
        if(e.getSource()==backButton){
            hide();
         } 
        if(e.getSource()==clearButton)
            clear();
    }
    public void getCustomer(){

        try{
            Vector v=databaseManager.getCustomer();
            
            for(int i=0; i<v.size(); i++){
             
                customerBean bean=(customerBean)v.elementAt(i);
                customerCB.addItem(bean);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this," Error: "+e.getMessage());
            e.printStackTrace();
        }
    }// end Customer
    
    public void getAccount(){
        customerBean bean=(customerBean)customerCB.getSelectedItem();
        if(bean==null)return;
        
        try{
            Vector v=databaseManager.getAccount(bean.getCustomerId());
            accountNoL.setListData(v);
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(this," Error: "+e.getMessage());
            e.printStackTrace();
        }
    }// end Account
    
    public void clear(){
    
        accountIdTF.setText("");
        accountNumberTF.setText("");
        pinCodeTF.setText("");
        dateOfCreateTF.setText("");
        remarksTA.setText("");
        amountTF.setText("");
    
    }
    private void addRecord(){
       customerBean bean=(customerBean)customerCB.getSelectedItem();
       if(bean==null)return;  
            String  accountNo     = accountNumberTF.getText();
            int     pinCode       = Integer.parseInt(pinCodeTF.getText());
            String  dateOfCreate  = dateOfCreateTF.getText();
            String  accType       = Encoder.accountTypeEncode((String)accountTypeCB.getSelectedItem());
            String  remarks       = remarksTA.getText();
            int amount            =Integer.parseInt(amountTF.getText());
            try{
                int rows= databaseManager.addAccount(bean.getCustomerId(),accountNo,pinCode,dateOfCreate,amount,accType,remarks);
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"RECORD INSERTED ");
                clear();
                getAccount();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            } 
    } // end addRecord
     private void updateRecord(){
         accountBean bean=(accountBean)accountNoL.getSelectedValue();
         if(bean==null)return ;
            String  accountNo     =accountNumberTF.getText();
            int     pinCode       =Integer.parseInt(pinCodeTF.getText());
            String  dateOfCreate  =dateOfCreateTF.getText();
            String  accType       =Encoder.accountTypeEncode((String)accountTypeCB.getSelectedItem());
            String  remarks       =remarksTA.getText();
            int amount            =Integer.parseInt(amountTF.getText());
         try{
          int rows=databaseManager.updateAccount(bean.getAccountId(),accountNo,pinCode,dateOfCreate,amount,accType,remarks);
            
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"RECORD UPDATED ");
                clear();
                getAccount();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         }//end updateRecord
    private void deleteRecord(){
    accountBean bean = (accountBean)accountNoL.getSelectedValue();
    if(bean==null)return;
    try{
        int rows = databaseManager.deleteAccount(bean.getAccountId());
          if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+" RECORD DELETED ");
                clear();
                getAccount();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         } //end deleteRecord  

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        customerCB = new javax.swing.JComboBox();
        accountIdTF = new javax.swing.JTextField();
        accountNumberTF = new javax.swing.JTextField();
        pinCodeTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTA = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountNoL = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        dateOfCreateTF = new javax.swing.JTextField();
        accountTypeCB = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(750, 750));
        setMinimumSize(new java.awt.Dimension(850, 850));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CUSTOMER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 100, 130, 60);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ACCOUNT ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 250, 100, 60);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ACCOUNT TYPE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 180, 120, 60);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ACCOUNT NO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 320, 100, 60);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("PIN CODE");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(110, 390, 67, 60);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("DATE OF CREATE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 460, 130, 60);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("REMARKS");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(190, 520, 70, 20);

        customerCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerCBActionPerformed(evt);
            }
        });
        getContentPane().add(customerCB);
        customerCB.setBounds(190, 100, 370, 60);

        accountIdTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accountIdTF.setEnabled(false);
        getContentPane().add(accountIdTF);
        accountIdTF.setBounds(190, 250, 140, 60);

        accountNumberTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(accountNumberTF);
        accountNumberTF.setBounds(190, 320, 140, 60);

        pinCodeTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(pinCodeTF);
        pinCodeTF.setBounds(190, 390, 140, 60);

        remarksTA.setColumns(20);
        remarksTA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksTA.setRows(5);
        jScrollPane1.setViewportView(remarksTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 540, 370, 80);

        addButton.setBackground(new java.awt.Color(255, 51, 255));
        addButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(190, 630, 80, 50);

        updateButton.setBackground(new java.awt.Color(255, 51, 255));
        updateButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton);
        updateButton.setBounds(280, 630, 87, 50);

        deleteButton.setBackground(new java.awt.Color(255, 51, 255));
        deleteButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton);
        deleteButton.setBounds(380, 630, 85, 50);

        clearButton.setBackground(new java.awt.Color(255, 51, 255));
        clearButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton);
        clearButton.setBounds(480, 630, 79, 50);

        backButton.setBackground(new java.awt.Color(255, 0, 0));
        backButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(570, 630, 170, 50);

        accountNoL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        accountNoL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                accountNoLValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(accountNoL);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(570, 90, 170, 530);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ACCOUNT NO");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(560, 60, 150, 40);
        getContentPane().add(filler1);
        filler1.setBounds(0, 0, 0, 0);
        getContentPane().add(filler2);
        filler2.setBounds(0, 0, 0, 0);
        getContentPane().add(filler3);
        filler3.setBounds(0, 0, 0, 0);
        getContentPane().add(filler4);
        filler4.setBounds(0, 0, 0, 0);
        getContentPane().add(filler5);
        filler5.setBounds(0, 0, 0, 0);

        dateOfCreateTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(dateOfCreateTF);
        dateOfCreateTF.setBounds(190, 460, 140, 60);

        accountTypeCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(accountTypeCB);
        accountTypeCB.setBounds(190, 180, 370, 60);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(230, -40, 10, 10);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 204, 255));
        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("       ACCOUNT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(220, 0, 330, 60);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Amount");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(340, 440, 80, 17);

        amountTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(amountTF);
        amountTF.setBounds(340, 460, 220, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
      addRecord();
    }//GEN-LAST:event_addButtonActionPerformed

    private void customerCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerCBActionPerformed
        // TODO add your handling code here:
        getAccount();
    }//GEN-LAST:event_customerCBActionPerformed

    private void accountNoLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_accountNoLValueChanged
    accountBean bean= (accountBean)accountNoL.getSelectedValue();
    if(bean==null)return;
       
       accountTypeCB.setSelectedItem(Decoder.accountTypeDecode(bean.getAccType()));
       accountIdTF.setText(""+bean.getAccountId());
       accountNumberTF.setText(""+bean.getAccountNo());
       pinCodeTF.setText(""+bean.getPinCode());
       dateOfCreateTF.setText(""+bean.getDateOfCreate());
       remarksTA.setText(""+bean.getRemarks());
       amountTF.setText(""+bean.getAmount());
    }//GEN-LAST:event_accountNoLValueChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteRecord();
     
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
      updateRecord();        
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountIdTF;
    private javax.swing.JList accountNoL;
    private javax.swing.JTextField accountNumberTF;
    private javax.swing.JComboBox<String> accountTypeCB;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField amountTF;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox customerCB;
    private javax.swing.JTextField dateOfCreateTF;
    private javax.swing.JButton deleteButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pinCodeTF;
    private javax.swing.JTextArea remarksTA;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
