
import DatabaseManager.databaseManager;
import DecodeAndEncode.Decoder;
import beanClass.accountBean;
import beanClass.customerBean;
import beanClass.loanBean;
import beanClass.transactionBean;
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
public class Loan extends javax.swing.JFrame {

    /**
     * Creates new form Loan
     */
    public Loan() {
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
        accountBean bean=(accountBean)accountCB.getSelectedItem();
        if(bean==null)return;
        
        try{
            Vector v=databaseManager.getLoan(bean.getAccountId());
            ammL.setListData(v);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this," Error: "+e.getMessage());
            e.printStackTrace();
        }
    }// end Transaction
    public void clear(){
    
        loanTF.setText("");
        ammTF.setText("");
        accNoTF.setText("");
        monLimTF.setText("");
        qistLimTF.setText("");
        interesetTF.setText("");
        loanTF.setText("");
        profitTF.setText("");
        remarksTF.setText("");
    }
    private void addRecord(){
        accountBean bean=(accountBean)accountCB.getSelectedItem();
        if(bean==null)return;  
            String  accountNumber   =accNoTF.getText();
            String  amount           =ammTF.getText();
            String  monthLimit       =monLimTF.getText();
            String  qistLimit        =qistLimTF.getText();
            String  intereset        =interesetTF.getText();
            String  profit           =profitTF.getText();
            String  remarks          =remarksTF.getText();
          
            try{
                int rows= databaseManager.addLoan(bean.getAccountId(),accountNumber,amount,monthLimit,qistLimit,intereset,profit,remarks);
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"RECORD INSERTED ");
                clear();
                getLoan();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            } 
    } //end addRecord
     private void updateRecord(){
         loanBean bean=(loanBean)ammL.getSelectedValue();
         if(bean==null)return ;
            String  accountNumber   =accNoTF.getText();
            String  amount           =ammTF.getText();
            String  monthLimit       =monLimTF.getText();
            String  qistLimit        =qistLimTF.getText();
            String  intereset        =interesetTF.getText();
            String  profit           =profitTF.getText();
            String  remarks          =remarksTF.getText();
         try{
          int rows=databaseManager.updateLoan(bean.getLoanId(),accountNumber,amount,monthLimit,qistLimit,intereset,profit,remarks);
            
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"RECORD UPDATED ");
                clear();
                getLoan();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         }//end updateRecord
     private void deleteRecord(){
    loanBean bean = (loanBean)ammL.getSelectedValue();
    if(bean==null)return;
    try{
        int rows = databaseManager.deleteLoan(bean.getLoanId());
          if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+" RECORD DELETED ");
                clear();
                getLoan();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         }  //end deleteRecord
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        remarksLab = new javax.swing.JLabel();
        loanIdLab = new javax.swing.JLabel();
        accountIdLab = new javax.swing.JLabel();
        accNoLab = new javax.swing.JLabel();
        ammLab = new javax.swing.JLabel();
        monLimLab = new javax.swing.JLabel();
        qistLimLab = new javax.swing.JLabel();
        intersetLab = new javax.swing.JLabel();
        profitLab = new javax.swing.JLabel();
        remarksTF = new javax.swing.JTextField();
        accNoTF = new javax.swing.JTextField();
        ammTF = new javax.swing.JTextField();
        monLimTF = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        qistLimTF = new javax.swing.JTextField();
        interesetTF = new javax.swing.JTextField();
        profitTF = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ammL = new javax.swing.JList();
        backBu = new javax.swing.JButton();
        addBu = new javax.swing.JButton();
        updateBu = new javax.swing.JButton();
        deleteBu = new javax.swing.JButton();
        clearBu = new javax.swing.JButton();
        remarksLab1 = new javax.swing.JLabel();
        loanIdLab2 = new javax.swing.JLabel();
        accNoLab1 = new javax.swing.JLabel();
        ammLab1 = new javax.swing.JLabel();
        monLimLab1 = new javax.swing.JLabel();
        qistLimLab1 = new javax.swing.JLabel();
        intersetLab1 = new javax.swing.JLabel();
        profitLab1 = new javax.swing.JLabel();
        remarksTF1 = new javax.swing.JTextField();
        accNoTF1 = new javax.swing.JTextField();
        ammNoTF1 = new javax.swing.JTextField();
        monLimTF1 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        qistLimTF1 = new javax.swing.JTextField();
        intersetTF1 = new javax.swing.JTextField();
        profitTF1 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        accIdL1 = new javax.swing.JList<>();
        backBu1 = new javax.swing.JButton();
        addBu1 = new javax.swing.JButton();
        updateBu1 = new javax.swing.JButton();
        deleteBu1 = new javax.swing.JButton();
        clearBu1 = new javax.swing.JButton();
        remarksLab2 = new javax.swing.JLabel();
        loanIdLab4 = new javax.swing.JLabel();
        accNoLab2 = new javax.swing.JLabel();
        ammLab2 = new javax.swing.JLabel();
        monLimLab2 = new javax.swing.JLabel();
        qistLimLab2 = new javax.swing.JLabel();
        intersetLab2 = new javax.swing.JLabel();
        profitLab2 = new javax.swing.JLabel();
        remarksTF2 = new javax.swing.JTextField();
        accNoTF2 = new javax.swing.JTextField();
        ammNoTF2 = new javax.swing.JTextField();
        monLimTF2 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        qistLimTF2 = new javax.swing.JTextField();
        intersetTF2 = new javax.swing.JTextField();
        profitTF2 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        accIdL2 = new javax.swing.JList<>();
        backBu2 = new javax.swing.JButton();
        addBu2 = new javax.swing.JButton();
        updateBu2 = new javax.swing.JButton();
        deleteBu2 = new javax.swing.JButton();
        clearBu2 = new javax.swing.JButton();
        loanIdLab1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customerCB = new javax.swing.JComboBox();
        accountCB = new javax.swing.JComboBox();
        loanTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        remarksLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksLab.setText("REMARKS");
        getContentPane().add(remarksLab);
        remarksLab.setBounds(50, 540, 70, 17);

        loanIdLab.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loanIdLab.setText("LOAN  FRAME ");
        getContentPane().add(loanIdLab);
        loanIdLab.setBounds(260, 10, 140, 40);

        accountIdLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accountIdLab.setText("AMOUNT");
        getContentPane().add(accountIdLab);
        accountIdLab.setBounds(430, 40, 90, 30);

        accNoLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accNoLab.setText("ACCOUNT NO");
        getContentPane().add(accNoLab);
        accNoLab.setBounds(30, 240, 100, 40);

        ammLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ammLab.setText("AMOUNT");
        getContentPane().add(ammLab);
        ammLab.setBounds(60, 290, 70, 40);

        monLimLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        monLimLab.setText("MONTH LIMIT");
        getContentPane().add(monLimLab);
        monLimLab.setBounds(30, 340, 100, 40);

        qistLimLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        qistLimLab.setText("QIST LIMIT");
        getContentPane().add(qistLimLab);
        qistLimLab.setBounds(50, 390, 80, 40);

        intersetLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        intersetLab.setText("INTERESET");
        getContentPane().add(intersetLab);
        intersetLab.setBounds(50, 440, 80, 40);

        profitLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profitLab.setText("PROFIT");
        getContentPane().add(profitLab);
        profitLab.setBounds(70, 490, 60, 40);

        remarksTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(remarksTF);
        remarksTF.setBounds(130, 540, 290, 100);

        accNoTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(accNoTF);
        accNoTF.setBounds(130, 240, 130, 40);

        ammTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(ammTF);
        ammTF.setBounds(130, 290, 290, 40);

        monLimTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(monLimTF);
        monLimTF.setBounds(130, 340, 290, 40);

        jTextField8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField8);
        jTextField8.setBounds(130, 340, 290, 40);

        qistLimTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(qistLimTF);
        qistLimTF.setBounds(130, 390, 290, 40);

        interesetTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(interesetTF);
        interesetTF.setBounds(130, 440, 290, 40);

        profitTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(profitTF);
        profitTF.setBounds(130, 490, 290, 40);

        jTextField12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField12);
        jTextField12.setBounds(130, 490, 290, 40);

        ammL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ammL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ammLValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ammL);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 70, 190, 570);

        backBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backBu.setText("BACK");
        backBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBuActionPerformed(evt);
            }
        });
        getContentPane().add(backBu);
        backBu.setBounds(500, 650, 120, 40);

        addBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addBu.setText("ADD");
        addBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBuActionPerformed(evt);
            }
        });
        getContentPane().add(addBu);
        addBu.setBounds(130, 650, 70, 40);

        updateBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBu.setText("UPDATE");
        updateBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBuActionPerformed(evt);
            }
        });
        getContentPane().add(updateBu);
        updateBu.setBounds(210, 650, 90, 40);

        deleteBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteBu.setText("DELETE");
        deleteBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBuActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBu);
        deleteBu.setBounds(310, 650, 90, 40);

        clearBu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearBu.setText("CLEAR");
        clearBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBuActionPerformed(evt);
            }
        });
        getContentPane().add(clearBu);
        clearBu.setBounds(410, 650, 80, 40);

        remarksLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksLab1.setText("REMARKS");
        getContentPane().add(remarksLab1);
        remarksLab1.setBounds(50, 540, 70, 17);

        loanIdLab2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loanIdLab2.setText("LOAN  FRAME ");
        getContentPane().add(loanIdLab2);
        loanIdLab2.setBounds(260, 10, 140, 40);

        accNoLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accNoLab1.setText("ACCOUNT NO");
        getContentPane().add(accNoLab1);
        accNoLab1.setBounds(30, 240, 100, 40);

        ammLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ammLab1.setText("AMOUNT");
        getContentPane().add(ammLab1);
        ammLab1.setBounds(60, 290, 70, 40);

        monLimLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        monLimLab1.setText("MONTH LIMIT");
        getContentPane().add(monLimLab1);
        monLimLab1.setBounds(30, 340, 100, 40);

        qistLimLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        qistLimLab1.setText("QIST LIMIT");
        getContentPane().add(qistLimLab1);
        qistLimLab1.setBounds(50, 390, 80, 40);

        intersetLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        intersetLab1.setText("INTERESET");
        getContentPane().add(intersetLab1);
        intersetLab1.setBounds(50, 440, 80, 40);

        profitLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profitLab1.setText("PROFIT");
        getContentPane().add(profitLab1);
        profitLab1.setBounds(70, 490, 60, 40);

        remarksTF1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(remarksTF1);
        remarksTF1.setBounds(130, 540, 290, 100);

        accNoTF1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(accNoTF1);
        accNoTF1.setBounds(130, 240, 130, 40);

        ammNoTF1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(ammNoTF1);
        ammNoTF1.setBounds(130, 290, 290, 40);

        monLimTF1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(monLimTF1);
        monLimTF1.setBounds(130, 340, 290, 40);

        jTextField9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField9);
        jTextField9.setBounds(130, 340, 290, 40);

        qistLimTF1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(qistLimTF1);
        qistLimTF1.setBounds(130, 390, 290, 40);

        intersetTF1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(intersetTF1);
        intersetTF1.setBounds(130, 440, 290, 40);

        profitTF1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(profitTF1);
        profitTF1.setBounds(130, 490, 290, 40);

        jTextField13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField13);
        jTextField13.setBounds(130, 490, 290, 40);

        accIdL1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(accIdL1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(430, 70, 190, 490);

        backBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backBu1.setText("BACK");
        backBu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBu1ActionPerformed(evt);
            }
        });
        getContentPane().add(backBu1);
        backBu1.setBounds(500, 650, 100, 40);

        addBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addBu1.setText("ADD");
        getContentPane().add(addBu1);
        addBu1.setBounds(130, 650, 70, 40);

        updateBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBu1.setText("UPDATE");
        getContentPane().add(updateBu1);
        updateBu1.setBounds(210, 650, 90, 40);

        deleteBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteBu1.setText("DELETE");
        getContentPane().add(deleteBu1);
        deleteBu1.setBounds(310, 650, 90, 40);

        clearBu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearBu1.setText("CLEAR");
        getContentPane().add(clearBu1);
        clearBu1.setBounds(410, 650, 80, 40);

        remarksLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remarksLab2.setText("REMARKS");
        getContentPane().add(remarksLab2);
        remarksLab2.setBounds(50, 540, 70, 17);

        loanIdLab4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loanIdLab4.setText("LOAN  FRAME ");
        getContentPane().add(loanIdLab4);
        loanIdLab4.setBounds(260, 10, 140, 40);

        accNoLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accNoLab2.setText("ACCOUNT NO");
        getContentPane().add(accNoLab2);
        accNoLab2.setBounds(30, 240, 100, 40);

        ammLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ammLab2.setText("AMOUNT");
        getContentPane().add(ammLab2);
        ammLab2.setBounds(60, 290, 70, 40);

        monLimLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        monLimLab2.setText("MONTH LIMIT");
        getContentPane().add(monLimLab2);
        monLimLab2.setBounds(30, 340, 100, 40);

        qistLimLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        qistLimLab2.setText("QIST LIMIT");
        getContentPane().add(qistLimLab2);
        qistLimLab2.setBounds(50, 390, 80, 40);

        intersetLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        intersetLab2.setText("INTERESET");
        getContentPane().add(intersetLab2);
        intersetLab2.setBounds(50, 440, 80, 40);

        profitLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profitLab2.setText("PROFIT");
        getContentPane().add(profitLab2);
        profitLab2.setBounds(70, 490, 60, 40);

        remarksTF2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(remarksTF2);
        remarksTF2.setBounds(130, 540, 290, 100);

        accNoTF2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(accNoTF2);
        accNoTF2.setBounds(130, 240, 130, 40);

        ammNoTF2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(ammNoTF2);
        ammNoTF2.setBounds(130, 290, 290, 40);

        monLimTF2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(monLimTF2);
        monLimTF2.setBounds(130, 340, 290, 40);

        jTextField10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField10);
        jTextField10.setBounds(130, 340, 290, 40);

        qistLimTF2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(qistLimTF2);
        qistLimTF2.setBounds(130, 390, 290, 40);

        intersetTF2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(intersetTF2);
        intersetTF2.setBounds(130, 440, 290, 40);

        profitTF2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(profitTF2);
        profitTF2.setBounds(130, 490, 290, 40);

        jTextField14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jTextField14);
        jTextField14.setBounds(130, 490, 290, 40);

        accIdL2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jScrollPane3.setViewportView(accIdL2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(430, 70, 190, 490);

        backBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        backBu2.setText("BACK");
        backBu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBu2ActionPerformed(evt);
            }
        });
        getContentPane().add(backBu2);
        backBu2.setBounds(500, 650, 100, 40);

        addBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addBu2.setText("ADD");
        getContentPane().add(addBu2);
        addBu2.setBounds(130, 650, 70, 40);

        updateBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBu2.setText("UPDATE");
        getContentPane().add(updateBu2);
        updateBu2.setBounds(210, 650, 90, 40);

        deleteBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        deleteBu2.setText("DELETE");
        getContentPane().add(deleteBu2);
        deleteBu2.setBounds(310, 650, 90, 40);

        clearBu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clearBu2.setText("CLEAR");
        getContentPane().add(clearBu2);
        clearBu2.setBounds(410, 650, 80, 40);

        loanIdLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loanIdLab1.setText("LOAN ID");
        getContentPane().add(loanIdLab1);
        loanIdLab1.setBounds(70, 190, 60, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CUSTOMER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 90, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ACCOUNT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 120, 80, 40);

        customerCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerCBActionPerformed(evt);
            }
        });
        getContentPane().add(customerCB);
        customerCB.setBounds(130, 70, 290, 40);

        accountCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        accountCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountCBActionPerformed(evt);
            }
        });
        getContentPane().add(accountCB);
        accountCB.setBounds(130, 120, 290, 40);

        loanTF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        loanTF.setEnabled(false);
        getContentPane().add(loanTF);
        loanTF.setBounds(130, 180, 120, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBuActionPerformed
       hide(); // TODO add your handling code here:
    }//GEN-LAST:event_backBuActionPerformed

    private void backBu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backBu1ActionPerformed

    private void backBu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backBu2ActionPerformed

    private void customerCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerCBActionPerformed
        getAccount();           // TODO add your handling code here:

    }//GEN-LAST:event_customerCBActionPerformed

    private void accountCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountCBActionPerformed
                // TODO add your handling code here:
              getLoan();
    }//GEN-LAST:event_accountCBActionPerformed

    private void ammLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ammLValueChanged
        // TODO add your handling code here:
        loanBean bean =(loanBean)ammL.getSelectedValue();
        if(bean==null)return;
       
       accNoTF.setText(""+bean.getAccountNumber());
       ammTF.setText(""+bean.getAmount());
       monLimTF.setText(""+bean.getMonthLimit());
       qistLimTF.setText(""+bean.getQistLimit());
       interesetTF.setText(bean.getIntereset());
       profitTF.setText(bean.getProfit());
       remarksTF.setText(""+bean.getRemarks());
        
    }//GEN-LAST:event_ammLValueChanged

    private void addBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBuActionPerformed
           addRecord();        // TODO add your handling code here:
    }//GEN-LAST:event_addBuActionPerformed

    private void updateBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBuActionPerformed
          updateRecord();// TODO add your handling code here:
    }//GEN-LAST:event_updateBuActionPerformed

    private void deleteBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBuActionPerformed
         deleteRecord();// TODO add your handling code here:
    }//GEN-LAST:event_deleteBuActionPerformed

    private void clearBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBuActionPerformed
        clear();// TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> accIdL1;
    private javax.swing.JList<String> accIdL2;
    private javax.swing.JLabel accNoLab;
    private javax.swing.JLabel accNoLab1;
    private javax.swing.JLabel accNoLab2;
    private javax.swing.JTextField accNoTF;
    private javax.swing.JTextField accNoTF1;
    private javax.swing.JTextField accNoTF2;
    private javax.swing.JComboBox accountCB;
    private javax.swing.JLabel accountIdLab;
    private javax.swing.JButton addBu;
    private javax.swing.JButton addBu1;
    private javax.swing.JButton addBu2;
    private javax.swing.JList ammL;
    private javax.swing.JLabel ammLab;
    private javax.swing.JLabel ammLab1;
    private javax.swing.JLabel ammLab2;
    private javax.swing.JTextField ammNoTF1;
    private javax.swing.JTextField ammNoTF2;
    private javax.swing.JTextField ammTF;
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
    private javax.swing.JTextField interesetTF;
    private javax.swing.JLabel intersetLab;
    private javax.swing.JLabel intersetLab1;
    private javax.swing.JLabel intersetLab2;
    private javax.swing.JTextField intersetTF1;
    private javax.swing.JTextField intersetTF2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel loanIdLab;
    private javax.swing.JLabel loanIdLab1;
    private javax.swing.JLabel loanIdLab2;
    private javax.swing.JLabel loanIdLab4;
    private javax.swing.JTextField loanTF;
    private javax.swing.JLabel monLimLab;
    private javax.swing.JLabel monLimLab1;
    private javax.swing.JLabel monLimLab2;
    private javax.swing.JTextField monLimTF;
    private javax.swing.JTextField monLimTF1;
    private javax.swing.JTextField monLimTF2;
    private javax.swing.JLabel profitLab;
    private javax.swing.JLabel profitLab1;
    private javax.swing.JLabel profitLab2;
    private javax.swing.JTextField profitTF;
    private javax.swing.JTextField profitTF1;
    private javax.swing.JTextField profitTF2;
    private javax.swing.JLabel qistLimLab;
    private javax.swing.JLabel qistLimLab1;
    private javax.swing.JLabel qistLimLab2;
    private javax.swing.JTextField qistLimTF;
    private javax.swing.JTextField qistLimTF1;
    private javax.swing.JTextField qistLimTF2;
    private javax.swing.JLabel remarksLab;
    private javax.swing.JLabel remarksLab1;
    private javax.swing.JLabel remarksLab2;
    private javax.swing.JTextField remarksTF;
    private javax.swing.JTextField remarksTF1;
    private javax.swing.JTextField remarksTF2;
    private javax.swing.JButton updateBu;
    private javax.swing.JButton updateBu1;
    private javax.swing.JButton updateBu2;
    // End of variables declaration//GEN-END:variables
}
