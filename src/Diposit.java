
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
public class Diposit extends javax.swing.JFrame {

    /**
 
     */
    public Diposit() {
        initComponents();
        getCustomer();
    }
      
    private void addRecord(){
    transactionBean bean  = new      transactionBean();
    accountBean     bean1 =(accountBean)accountC.getSelectedItem();
    if(bean1==null)return;
    
    int tra = bean.getTransId();
    String transactionType ="DIPOSIT"; 
    
    int  amount              = Integer.parseInt(amountTF.getText());    
    String dateOfTransaction = dateOfTransactionTF.getText();
    String amountType        = amountTypeTF.getText();
    try{
        int row = databaseManager.addTransactionD(tra,bean1.getAccountId(), amount,  amountType, dateOfTransaction,transactionType);
        if(row>=1)
            JOptionPane.showMessageDialog(this,"DIPOSIT DONE ");
               
    }catch(Exception e){
        JOptionPane.showMessageDialog(this,"erorr"+e.getMessage());
        e.printStackTrace();}
    
    
}
        private void getCustomer(){
      
    try{
        Vector v=databaseManager.getCustomer();
       customerC.removeAllItems();
           for(int i=0; i<v.size();  i++ ){ 
        customerBean  bean =(customerBean)v.elementAt(i);
        customerC.addItem(bean);
    } 

    }catch(Exception e){
        e.printStackTrace ();
      JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
    
    }      
    }
    
      private void getAccount(){
            customerBean bean=(customerBean) customerC.getSelectedItem();
            if(bean==null) return;
            try{
                accountC.removeAllItems();
                 Vector v=databaseManager.getAccount(bean.getCustomerId());

            for(int i=0;i<v.size();i++){
                accountBean bean1=(accountBean)v.elementAt(i);
                accountC.addItem(bean1);

            }
        }//end try block
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
        }//end catch
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        accountC = new javax.swing.JComboBox();
        customerC = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        dateOfTransactionTF = new javax.swing.JTextField();
        amountTypeTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 800));
        setMinimumSize(new java.awt.Dimension(700, 600));
        getContentPane().setLayout(null);

        backButton.setBackground(new java.awt.Color(255, 0, 0));
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
        backButton.setBounds(400, 450, 120, 50);

        doneButton.setBackground(new java.awt.Color(255, 0, 204));
        doneButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        doneButton.setForeground(new java.awt.Color(255, 255, 255));
        doneButton.setText("DONE");
        doneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneButtonMouseClicked(evt);
            }
        });
        getContentPane().add(doneButton);
        doneButton.setBounds(180, 450, 200, 50);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ACCOUNT ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 150, 60, 50);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("CUSTOMER");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 90, 70, 50);

        accountC.setEditable(true);
        accountC.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(accountC);
        accountC.setBounds(180, 150, 340, 50);

        customerC.setEditable(true);
        customerC.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        customerC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerCActionPerformed(evt);
            }
        });
        getContentPane().add(customerC);
        customerC.setBounds(180, 90, 340, 50);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText(" DATE OF TRANASACTION");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 330, 150, 50);

        dateOfTransactionTF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(dateOfTransactionTF);
        dateOfTransactionTF.setBounds(180, 330, 340, 50);

        amountTypeTF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(amountTypeTF);
        amountTypeTF.setBounds(180, 390, 340, 50);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("AMOUNT TYPE");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(90, 390, 90, 50);

        amountTF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        getContentPane().add(amountTF);
        amountTF.setBounds(180, 270, 340, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("  AMOUNT ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 270, 60, 50);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        jLabel1.setText("DIPOSIT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 10, 560, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        //hide();
    }//GEN-LAST:event_backButtonActionPerformed

    private void customerCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerCActionPerformed
        getAccount();
    }//GEN-LAST:event_customerCActionPerformed

    private void doneButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneButtonMouseClicked
        // TODO add your handling code here:
        addRecord();

        TransactionTypes ob= new TransactionTypes();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_doneButtonMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        TransactionTypes ob= new TransactionTypes();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diposit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountC;
    private javax.swing.JTextField amountTF;
    private javax.swing.JTextField amountTypeTF;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox customerC;
    private javax.swing.JTextField dateOfTransactionTF;
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
