
import DatabaseManager.databaseManager;
import beanClass.accountBean;
import beanClass.customerBean;
import beanClass.loanBean;
import beanClass.loanPaymentBean;
import java.awt.event.ActionEvent;
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
public class LoanPayment extends javax.swing.JFrame {

    /**
     * Creates new form LoanPayment
     */
    public LoanPayment() {
        initComponents();
        getCustomer();
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==addBu)
            addRecord();
        if(e.getSource()==backBu){
         hide();
         } 
        if(e.getSource()==clearBu)
            clear();
    }
    public void getCustomer(){
    
        try{       
            Vector v=databaseManager.getCustomer();
            customerCB.removeAllItems();
            
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
        customerBean custBean=(customerBean)customerCB.getSelectedItem();
        if(custBean==null)return;
    
        try{       
            Vector v=databaseManager.getAccount(custBean.getCustomerId());
            accountCB.removeAllItems();
            
            for(int i=0; i<v.size(); i++){
            
                accountBean bean=(accountBean)v.elementAt(i);
                accountCB.addItem(bean);
            }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this," Error: "+e.getMessage());
            e.printStackTrace();
        }
    }// end Account
    
    
    public void getLoan(){
        accountBean Bean=(accountBean)accountCB.getSelectedItem();
        if(Bean==null)return;
        
      try{       
            Vector v=databaseManager.getLoan(Bean.getAccountId());
            loanCB.removeAllItems();
            
            for(int i=0; i<v.size(); i++){
            
                loanBean bean=(loanBean)v.elementAt(i);
                loanCB.addItem(bean);
            }
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(this," Error: "+e.getMessage());
            e.printStackTrace();
        }
    }//   
    
    public void getLoanPayment(){
        loanBean bean=(loanBean)loanCB.getSelectedItem();
        if(bean==null)return;
        
        try{
            Vector v=databaseManager.getLoanPayment(bean.getLoanId());
            payDateL.setListData(v);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this," Error: "+e.getMessage());
            e.printStackTrace();
        }
    }// end Transaction
       public void clear(){
    
        loanPay1TF.setText("");
        payDateTF.setText("");
        payAmoTF.setText("");
        lateFeesTF.setText("");
        totalPayTF.setText("");
        remainderTF.setText("");
        remarksTF.setText("");
    }//end clear
    private void addRecord(){
        loanBean bean=(loanBean)loanCB.getSelectedItem();
        if(bean==null)return;  
            String  paymentDate    =payDateTF.getText();
            String  paymentAmount  =payAmoTF.getText();
            String  lateFees       =lateFeesTF.getText();
            String  totalPay       =totalPayTF.getText();
            String  remainder      =remainderTF.getText();
            String  remarks        =remarksTF.getText();
          
            try{
                int rows= databaseManager.addLoanPayment(bean.getLoanId(),paymentDate,paymentAmount,lateFees,totalPay,remainder,remarks);
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"RECORD INSERTED ");
                clear();
                getLoanPayment();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            } 
    } //end addRecord
     private void updateRecord(){
         loanPaymentBean bean=(loanPaymentBean)payDateL.getSelectedValue();
         if(bean==null)return ;
            String  paymentDate    =payDateTF.getText();
            String  paymentAmount  =payAmoTF.getText();
            String  lateFees       =lateFeesTF.getText();
            String  totalPay       =totalPayTF.getText();
            String  remainder      =remainderTF.getText();
            String  remarks        =remarksTF.getText();
         try{
          int rows=databaseManager.updateLoanPayment(bean.getLoanPayId(),paymentDate,paymentAmount,lateFees,totalPay,remainder,remarks);
            
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"RECORD UPDATED ");
                clear();
                getLoanPayment();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         }//end updateRecord
     private void deleteRecord(){
    loanPaymentBean bean = (loanPaymentBean)payDateL.getSelectedValue();
    if(bean==null)return;
    try{
        int rows = databaseManager.deleteLoanPayment(bean.getLoanPayId());
          if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+" RECORD DELETED ");
                clear();
                getLoanPayment();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         }//end delete record

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        remarksLab = new javax.swing.JLabel();
        remainderTF = new javax.swing.JTextField();
        loanPayTF = new javax.swing.JLabel();
        loanLab = new javax.swing.JLabel();
        payAmoLab = new javax.swing.JLabel();
        paydateLab = new javax.swing.JLabel();
        lateFeesLaB = new javax.swing.JLabel();
        totalPayLab = new javax.swing.JLabel();
        remainLab = new javax.swing.JLabel();
        loanCB = new javax.swing.JComboBox();
        loanPay1TF = new javax.swing.JTextField();
        payAmoTF = new javax.swing.JTextField();
        lateFeesTF = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        remarksTF = new javax.swing.JTextField();
        totalPayTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        payDateL = new javax.swing.JList();
        backBu = new javax.swing.JButton();
        addBu = new javax.swing.JButton();
        updateBu = new javax.swing.JButton();
        deleteBu = new javax.swing.JButton();
        clearBu = new javax.swing.JButton();
        backBu1 = new javax.swing.JButton();
        addBu1 = new javax.swing.JButton();
        updateBu1 = new javax.swing.JButton();
        deleteBu1 = new javax.swing.JButton();
        clearBu1 = new javax.swing.JButton();
        backBu2 = new javax.swing.JButton();
        addBu2 = new javax.swing.JButton();
        updateBu2 = new javax.swing.JButton();
        deleteBu2 = new javax.swing.JButton();
        clearBu2 = new javax.swing.JButton();
        paymentDateLab = new javax.swing.JLabel();
        paydateLab1 = new javax.swing.JLabel();
        paydateLab2 = new javax.swing.JLabel();
        loanLab1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        accountCB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        customerCB = new javax.swing.JComboBox();
        payDateTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        remarksLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksLab.setText("REMARKS");
        getContentPane().add(remarksLab);
        remarksLab.setBounds(100, 580, 70, 17);

        remainderTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(remainderTF);
        remainderTF.setBounds(190, 470, 300, 40);

        loanPayTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loanPayTF.setText("LOAN PAYMENT ID");
        getContentPane().add(loanPayTF);
        loanPayTF.setBounds(50, 220, 140, 40);

        loanLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loanLab.setText("LOAN");
        getContentPane().add(loanLab);
        loanLab.setBounds(130, 170, 60, 40);

        payAmoLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        payAmoLab.setText("PAYMENT AMOUNT");
        getContentPane().add(payAmoLab);
        payAmoLab.setBounds(40, 320, 150, 40);

        paydateLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        paydateLab.setText("PAYMENT DATE");
        getContentPane().add(paydateLab);
        paydateLab.setBounds(500, 130, 120, 40);

        lateFeesLaB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lateFeesLaB.setText("LATE FEES");
        getContentPane().add(lateFeesLaB);
        lateFeesLaB.setBounds(100, 370, 90, 40);

        totalPayLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        totalPayLab.setText("  TOTAL PAY");
        getContentPane().add(totalPayLab);
        totalPayLab.setBounds(90, 420, 100, 40);

        remainLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remainLab.setText(" REMAINDER");
        getContentPane().add(remainLab);
        remainLab.setBounds(90, 470, 100, 40);

        loanCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loanCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanCBActionPerformed(evt);
            }
        });
        getContentPane().add(loanCB);
        loanCB.setBounds(190, 170, 290, 40);

        loanPay1TF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(loanPay1TF);
        loanPay1TF.setBounds(190, 220, 110, 40);

        payAmoTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(payAmoTF);
        payAmoTF.setBounds(190, 320, 300, 40);

        lateFeesTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(lateFeesTF);
        lateFeesTF.setBounds(190, 370, 300, 40);

        jTextField6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField6);
        jTextField6.setBounds(220, 350, 59, 0);

        remarksTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(remarksTF);
        remarksTF.setBounds(190, 520, 300, 100);

        totalPayTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(totalPayTF);
        totalPayTF.setBounds(190, 420, 300, 40);

        payDateL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        payDateL.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                payDateLVetoableChange(evt);
            }
        });
        payDateL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                payDateLValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(payDateL);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(500, 170, 190, 450);

        backBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backBu.setText("BACK");
        backBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBuActionPerformed(evt);
            }
        });
        getContentPane().add(backBu);
        backBu.setBounds(560, 630, 130, 50);

        addBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addBu.setText("ADD");
        addBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBuActionPerformed(evt);
            }
        });
        getContentPane().add(addBu);
        addBu.setBounds(190, 630, 70, 50);

        updateBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBu.setText("UPDATE");
        updateBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBuActionPerformed(evt);
            }
        });
        getContentPane().add(updateBu);
        updateBu.setBounds(270, 630, 90, 50);

        deleteBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteBu.setText("DELETE");
        deleteBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBuActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBu);
        deleteBu.setBounds(370, 630, 90, 50);

        clearBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearBu.setText("CLEAR");
        clearBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBuActionPerformed(evt);
            }
        });
        getContentPane().add(clearBu);
        clearBu.setBounds(470, 630, 80, 50);

        backBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backBu1.setText("BACK");
        backBu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBu1ActionPerformed(evt);
            }
        });
        getContentPane().add(backBu1);
        backBu1.setBounds(560, 630, 100, 50);

        addBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addBu1.setText("ADD");
        getContentPane().add(addBu1);
        addBu1.setBounds(190, 630, 70, 50);

        updateBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBu1.setText("UPDATE");
        getContentPane().add(updateBu1);
        updateBu1.setBounds(270, 630, 90, 50);

        deleteBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteBu1.setText("DELETE");
        getContentPane().add(deleteBu1);
        deleteBu1.setBounds(370, 630, 90, 50);

        clearBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearBu1.setText("CLEAR");
        getContentPane().add(clearBu1);
        clearBu1.setBounds(470, 630, 80, 50);

        backBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backBu2.setText("BACK");
        backBu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBu2ActionPerformed(evt);
            }
        });
        getContentPane().add(backBu2);
        backBu2.setBounds(560, 630, 100, 50);

        addBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addBu2.setText("ADD");
        getContentPane().add(addBu2);
        addBu2.setBounds(190, 630, 70, 50);

        updateBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBu2.setText("UPDATE");
        getContentPane().add(updateBu2);
        updateBu2.setBounds(270, 630, 90, 50);

        deleteBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteBu2.setText("DELETE");
        getContentPane().add(deleteBu2);
        deleteBu2.setBounds(370, 630, 90, 50);

        clearBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearBu2.setText("CLEAR");
        getContentPane().add(clearBu2);
        clearBu2.setBounds(470, 630, 80, 50);

        paymentDateLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        paymentDateLab.setText("PAYMENT DATE");
        getContentPane().add(paymentDateLab);
        paymentDateLab.setBounds(70, 270, 120, 40);

        paydateLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        paydateLab1.setText("PAYMENT DATE");
        getContentPane().add(paydateLab1);
        paydateLab1.setBounds(500, 130, 120, 40);

        paydateLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        paydateLab2.setText("PAYMENT DATE");
        getContentPane().add(paydateLab2);
        paydateLab2.setBounds(500, 130, 120, 40);

        loanLab1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loanLab1.setText("LOAN PAYMENT");
        getContentPane().add(loanLab1);
        loanLab1.setBounds(250, 10, 190, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ACCOUNT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 120, 80, 40);

        accountCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accountCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountCBActionPerformed(evt);
            }
        });
        getContentPane().add(accountCB);
        accountCB.setBounds(190, 120, 290, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CUSTOMER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 70, 90, 40);

        customerCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerCBActionPerformed(evt);
            }
        });
        getContentPane().add(customerCB);
        customerCB.setBounds(190, 70, 290, 40);

        payDateTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(payDateTF);
        payDateTF.setBounds(190, 270, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBuActionPerformed
      hide();        // TODO add your handling code here:
    }//GEN-LAST:event_backBuActionPerformed

    private void backBu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backBu1ActionPerformed

    private void backBu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backBu2ActionPerformed

    private void payDateLVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_payDateLVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_payDateLVetoableChange

    private void payDateLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_payDateLValueChanged
        // TODO add your handling code here:
          loanPaymentBean bean =(loanPaymentBean)payDateL.getSelectedValue();
        if(bean==null)return;
       
       payDateTF.setText(""+bean.getPaymentDate());
       payAmoTF.setText(""+bean.getPaymentAmount());
       lateFeesTF.setText(""+bean.getLateFees());
       totalPayTF.setText(""+bean.getTotalPay());
       remainderTF.setText(bean.getRemainder());
       remarksTF.setText(""+bean.getRemarks());
    }//GEN-LAST:event_payDateLValueChanged

    private void loanCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanCBActionPerformed
        // TODO add your handling code here:
        getLoanPayment();
    }//GEN-LAST:event_loanCBActionPerformed

    private void accountCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountCBActionPerformed
        // TODO add your handling code here:
        getLoan();
    }//GEN-LAST:event_accountCBActionPerformed

    private void customerCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerCBActionPerformed
        getAccount();           // TODO add your handling code here:
    }//GEN-LAST:event_customerCBActionPerformed

    private void addBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBuActionPerformed
      addRecord();        // TODO add your handling code here:
    }//GEN-LAST:event_addBuActionPerformed

    private void updateBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBuActionPerformed
      updateRecord();        // TODO add your handling code here:
    }//GEN-LAST:event_updateBuActionPerformed

    private void deleteBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBuActionPerformed
      deleteRecord();        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBuActionPerformed

    private void clearBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBuActionPerformed
      clear();        // TODO add your handling code here:
    }//GEN-LAST:event_clearBuActionPerformed

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
            java.util.logging.Logger.getLogger(LoanPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoanPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoanPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoanPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountCB;
    private javax.swing.JButton addBu;
    private javax.swing.JButton addBu1;
    private javax.swing.JButton addBu2;
    private javax.swing.JButton backBu;
    private javax.swing.JButton backBu1;
    private javax.swing.JButton backBu2;
    private javax.swing.JButton clearBu;
    private javax.swing.JButton clearBu1;
    private javax.swing.JButton clearBu2;
    private javax.swing.JComboBox customerCB;
    private javax.swing.JButton deleteBu;
    private javax.swing.JButton deleteBu1;
    private javax.swing.JButton deleteBu2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lateFeesLaB;
    private javax.swing.JTextField lateFeesTF;
    private javax.swing.JComboBox loanCB;
    private javax.swing.JLabel loanLab;
    private javax.swing.JLabel loanLab1;
    private javax.swing.JTextField loanPay1TF;
    private javax.swing.JLabel loanPayTF;
    private javax.swing.JLabel payAmoLab;
    private javax.swing.JTextField payAmoTF;
    private javax.swing.JList payDateL;
    private javax.swing.JTextField payDateTF;
    private javax.swing.JLabel paydateLab;
    private javax.swing.JLabel paydateLab1;
    private javax.swing.JLabel paydateLab2;
    private javax.swing.JLabel paymentDateLab;
    private javax.swing.JLabel remainLab;
    private javax.swing.JTextField remainderTF;
    private javax.swing.JLabel remarksLab;
    private javax.swing.JTextField remarksTF;
    private javax.swing.JLabel totalPayLab;
    private javax.swing.JTextField totalPayTF;
    private javax.swing.JButton updateBu;
    private javax.swing.JButton updateBu1;
    private javax.swing.JButton updateBu2;
    // End of variables declaration//GEN-END:variables
}
