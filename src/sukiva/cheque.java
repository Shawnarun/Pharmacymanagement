/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukiva;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static sukiva.Admin.q;

/**
 *
 * @author Snake_Eye
 */
public class cheque extends javax.swing.JInternalFrame {
DefaultTableModel defaultTableModel = new DefaultTableModel();
   int deletee;
   java.util.Date date;
   java.sql.Date sqlda;
   java.util.Date date1;
 java.sql.Date sqldate;
    /**
     * Creates new form cheque
     */
Connection connection = null;
    PreparedStatement prp = null;
    ResultSet rs = null;
    public cheque() {
        initComponents();
        connection = DataBase.database.ConnectDb();
        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

         tcqn.setBackground(new java.awt.Color(0,0,0,1));
         tcqa.setBackground(new java.awt.Color(0,0,0,1));
         tcqnum.setBackground(new java.awt.Color(0,0,0,1));
         tcqsearch.setBackground(new java.awt.Color(0,0,0,0));
         tcqsearch2.setBackground(new java.awt.Color(0,0,0,1));
        tcqst.setBackground(new java.awt.Color(0,0,0,0));
         
         cscroll.setBackground(new java.awt.Color(0,0,0,1));
        cscroll.getViewport().setBackground(new java.awt.Color(0,0,0,1));
         ct.setBackground(new java.awt.Color(0,0,0,1));
     
         
         JTableHeader header = ct.getTableHeader();
                 header.setEnabled(false);
        header.setBackground(new java.awt.Color(0,0,0,0));
        ct.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));
        
    
        Object columns[] = {"Cheque Name"," Issue Date", " Realize Date","Status","Amount","C_N","ID"};
        defaultTableModel.setColumnIdentifiers(columns);
        ct.setModel(defaultTableModel);
            ct.setDefaultEditor(Object.class, null);
         
         
        ((JTextFieldDateEditor)tcqiss.getDateEditor()).setBackground(new java.awt.Color(0,0,0,1));
        ((JTextFieldDateEditor)tcqiss.getDateEditor()).setBorder(javax.swing.BorderFactory.createEmptyBorder());
         (tcqiss.getCalendarButton()).setBackground(new java.awt.Color(0,0,0,0));

        ((JTextFieldDateEditor)tcqr.getDateEditor()).setBackground(new java.awt.Color(0,0,0,1));
        ((JTextFieldDateEditor)tcqr.getDateEditor()).setBorder(javax.swing.BorderFactory.createEmptyBorder());
        (tcqr.getCalendarButton()).setBackground(new java.awt.Color(0,0,0,0));

        ((JTextFieldDateEditor)tcqser.getDateEditor()).setBackground(new java.awt.Color(0,0,0,1));
        ((JTextFieldDateEditor)tcqser.getDateEditor()).setBorder(javax.swing.BorderFactory.createEmptyBorder());
        (tcqser.getCalendarButton()).setBackground(new java.awt.Color(0,0,0,0));
        
        loadData();
    }

        public void loadData() {
        //Object columns[] = {"Cheque Name"," Issue Date", " Realize Date","Status","Amount","C_N","ID"};
        String sql = "SELECT `name`, `idate`, `rdate`, `num`, `chid`, `amount`,`status` FROM `cheque`";
        try {
            prp = connection.prepareStatement(sql);
            rs = prp.executeQuery();
            Object columnData[] = new Object[7];
            while (rs.next()) {
                columnData[0] = rs.getString("name");
                columnData[1] = rs.getString("idate");
                columnData[2] = rs.getString("rdate");
                columnData[3] = rs.getString("status");
                columnData[4] = rs.getString("amount");
               columnData[5] = rs.getString("num");
              columnData[6] = rs.getString("chid");
                  defaultTableModel.addRow(columnData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tcqn.setText(null);
        tcqa.setText(null);
        tcqiss.setDate(null);
        tcqr.setDate(null);
        tcqnum.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cqn = new javax.swing.JLabel();
        tcqn = new javax.swing.JTextField();
        exd = new javax.swing.JLabel();
        tcqser = new com.toedter.calendar.JDateChooser();
        cqiss = new javax.swing.JLabel();
        tcqiss = new com.toedter.calendar.JDateChooser();
        cqa = new javax.swing.JLabel();
        tcqa = new javax.swing.JTextField();
        cqst = new javax.swing.JLabel();
        tcqst = new javax.swing.JComboBox<>();
        cqadd = new javax.swing.JButton();
        cqdelete = new javax.swing.JButton();
        cqupdate = new javax.swing.JButton();
        cqsearch = new javax.swing.JButton();
        cscroll = new javax.swing.JScrollPane();
        ct = new javax.swing.JTable();
        tcqsearch = new javax.swing.JComboBox<>();
        tcqsearch2 = new javax.swing.JTextField();
        tcqr = new com.toedter.calendar.JDateChooser();
        cqn1 = new javax.swing.JLabel();
        tcqnum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(960, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cqn.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        cqn.setForeground(new java.awt.Color(0, 0, 0));
        cqn.setText("Payee");
        getContentPane().add(cqn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 30));

        tcqn.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tcqn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqn.setOpaque(false);
        tcqn.setPreferredSize(new java.awt.Dimension(6, 22));
        tcqn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcqnActionPerformed(evt);
            }
        });
        getContentPane().add(tcqn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 160, 20));

        exd.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        exd.setForeground(new java.awt.Color(0, 0, 0));
        exd.setText("Realize Date");
        getContentPane().add(exd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 30));

        tcqser.setBackground(new java.awt.Color(176, 106, 179));
        tcqser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqser.setForeground(new java.awt.Color(176, 106, 179));
        tcqser.setOpaque(false);
        tcqser.setPreferredSize(new java.awt.Dimension(22, 6));
        getContentPane().add(tcqser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 160, 30));

        cqiss.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        cqiss.setForeground(new java.awt.Color(0, 0, 0));
        cqiss.setText("Issue Date");
        getContentPane().add(cqiss, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 30));

        tcqiss.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqiss.setOpaque(false);
        tcqiss.setPreferredSize(new java.awt.Dimension(22, 6));
        getContentPane().add(tcqiss, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 160, 30));

        cqa.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        cqa.setForeground(new java.awt.Color(0, 0, 0));
        cqa.setText("Amount");
        getContentPane().add(cqa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 30));

        tcqa.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tcqa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqa.setOpaque(false);
        tcqa.setPreferredSize(new java.awt.Dimension(6, 22));
        getContentPane().add(tcqa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 160, 20));

        cqst.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        cqst.setForeground(new java.awt.Color(0, 0, 0));
        cqst.setText("Status");
        getContentPane().add(cqst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, 30));

        tcqst.setEditable(true);
        tcqst.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        tcqst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Passed", "Canceled", "Bounced" }));
        tcqst.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqst.setOpaque(false);
        getContentPane().add(tcqst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 160, 30));

        cqadd.setBackground(new java.awt.Color(176, 106, 179));
        cqadd.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        cqadd.setForeground(new java.awt.Color(0, 0, 204));
        cqadd.setText("Add");
        cqadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cqaddActionPerformed(evt);
            }
        });
        getContentPane().add(cqadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 80, 40));

        cqdelete.setBackground(new java.awt.Color(176, 106, 179));
        cqdelete.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        cqdelete.setForeground(new java.awt.Color(0, 0, 204));
        cqdelete.setText("Delete");
        cqdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cqdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(cqdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 80, 40));

        cqupdate.setBackground(new java.awt.Color(176, 106, 179));
        cqupdate.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        cqupdate.setForeground(new java.awt.Color(0, 0, 204));
        cqupdate.setText("update");
        cqupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cqupdateActionPerformed(evt);
            }
        });
        getContentPane().add(cqupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 90, 40));

        cqsearch.setBackground(new java.awt.Color(176, 106, 179));
        cqsearch.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        cqsearch.setForeground(new java.awt.Color(0, 0, 204));
        cqsearch.setText("Search");
        getContentPane().add(cqsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 110, 30));

        cscroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cscroll.setOpaque(false);

        ct.setBackground(new java.awt.Color(176, 106, 179));
        ct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ct.setFont(new java.awt.Font("Ebrima", 0, 10)); // NOI18N
        ct.setForeground(new java.awt.Color(0, 0, 0));
        ct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ct.setGridColor(new java.awt.Color(0, 0, 0));
        ct.setOpaque(false);
        ct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctMouseClicked(evt);
            }
        });
        cscroll.setViewportView(ct);

        getContentPane().add(cscroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 610, 530));

        tcqsearch.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        tcqsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Payee", "Issue Date", "Realize Date", "Pending", "Pass", "Bounced", "Cancelled", " " }));
        tcqsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqsearch.setOpaque(false);
        tcqsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcqsearchActionPerformed(evt);
            }
        });
        getContentPane().add(tcqsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 110, 30));

        tcqsearch2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tcqsearch2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqsearch2.setOpaque(false);
        tcqsearch2.setPreferredSize(new java.awt.Dimension(6, 22));
        tcqsearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcqsearch2ActionPerformed(evt);
            }
        });
        getContentPane().add(tcqsearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 160, 30));

        tcqr.setBackground(new java.awt.Color(176, 106, 179));
        tcqr.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqr.setForeground(new java.awt.Color(176, 106, 179));
        tcqr.setOpaque(false);
        tcqr.setPreferredSize(new java.awt.Dimension(22, 6));
        getContentPane().add(tcqr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 30));

        cqn1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        cqn1.setForeground(new java.awt.Color(0, 0, 0));
        cqn1.setText("Cheque no");
        getContentPane().add(cqn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 120, 30));

        tcqnum.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tcqnum.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tcqnum.setOpaque(false);
        tcqnum.setPreferredSize(new java.awt.Dimension(6, 22));
        tcqnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcqnumActionPerformed(evt);
            }
        });
        getContentPane().add(tcqnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 160, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sukiva/images/internal.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tcqnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcqnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcqnActionPerformed

    private void cqdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cqdeleteActionPerformed
        // TODO add your handling code here:
        
        String sql = "DELETE FROM `cheque`WHERE chid ='" + deletee + "'";
        try {
            prp = connection.prepareStatement(sql);
            prp.execute();
            JOptionPane.showMessageDialog(null, "Employer " + deletee + " has been deleted");
            defaultTableModel.getDataVector().removeAllElements();
            defaultTableModel.fireTableDataChanged();
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Employer nicid " + deletee + " not found");
        }
        
        
        
    }//GEN-LAST:event_cqdeleteActionPerformed

    private void tcqsearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcqsearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcqsearch2ActionPerformed

    private void tcqsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcqsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcqsearchActionPerformed

    private void tcqnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcqnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcqnumActionPerformed

    private void cqaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cqaddActionPerformed
        // TODO add your handling code here:
        String cname=tcqn.getText();
        Double amount=Double.parseDouble(tcqa.getText());
        
        date=tcqiss.getDate();
        sqlda= new java.sql.Date(date.getTime());
        
        date1=tcqr.getDate();
        sqldate= new java.sql.Date(date1.getTime());
        
     
         String stat = tcqst.getSelectedItem().toString();
                 String num =tcqnum.getText();


         if(cname.equals("")||amount.equals("")||tcqiss.equals("")||tcqr.equals("")||stat.equals("")||num.equals("")){

            JOptionPane.showMessageDialog(null,"Complete Your Account Information","Missing Information",2);

        }
        else {
            String sql = "INSERT INTO `cheque`(`name`, `idate`, `rdate`, `num`, `amount`, `status`)  VALUES (?,?,?,?,?,?)";
            if (connection != null) {

                try {
                    prp = connection.prepareStatement(sql);
                    prp.setString(1, cname);
                    prp.setDate(2,sqlda );
                     prp.setDate(3, sqldate);
                    prp.setString(4, num);
                    prp.setDouble(5, amount);
                    prp.setString(6, stat);
                    
                    prp.execute();
                    defaultTableModel.getDataVector().removeAllElements();
                    defaultTableModel.fireTableDataChanged();
                    loadData();
                    JOptionPane.showMessageDialog(null, "Data Saved");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        
        
    }//GEN-LAST:event_cqaddActionPerformed

    private void ctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctMouseClicked
        // TODO add your handling code here:
        //Object columns[] = {"Cheque Name"," Issue Date", " Realize Date","Status","Amount"};
         int row = ct.getSelectedRow();
        
        tcqn.setText(ct.getValueAt(row, 0).toString());
        
         
    try {
             java.util.Date h = new SimpleDateFormat("yyyy-MM-dd").parse((String)ct.getValueAt(row, 1).toString());
              tcqiss.setDate(h);
              java.util.Date hh = new SimpleDateFormat("yyyy-MM-dd").parse((String)ct.getValueAt(row, 2).toString());
              tcqr.setDate(hh);

    } catch (ParseException ex) {
        Logger.getLogger(cheque.class.getName()).log(Level.SEVERE, null, ex);
    }
                    
       tcqst.getEditor().setItem(ct.getValueAt(row, 3).toString());
        tcqa.setText(ct.getValueAt(row, 4).toString());
         tcqnum.setText(ct.getValueAt(row, 5).toString());
          deletee = Integer.parseInt(ct.getValueAt(row, 6).toString());

         
    }//GEN-LAST:event_ctMouseClicked

    private void cqupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cqupdateActionPerformed
        // TODO add your handling code here:
          String cname=tcqn.getText();
        Double amount=Double.parseDouble(tcqa.getText());
        
        date=tcqiss.getDate();
        sqlda= new java.sql.Date(date.getTime());
        
        date1=tcqr.getDate();
        sqldate= new java.sql.Date(date1.getTime());
        
   
         String stat = tcqst.getSelectedItem().toString();
                 String num =tcqnum.getText();


         if(cname.equals("")||amount.equals("")||tcqiss.equals("")||tcqr.equals("")||stat.equals("")||num.equals("")){

            JOptionPane.showMessageDialog(null,"Complete Your Account Information","Missing Information",2);

        }
        else {
            String sql = "UPDATE `cheque` SET `name`='"+ cname +"',`idate`='"+sqlda+"',`rdate`='"+sqldate+"',`num`='"+num+"',`amount`='"+amount+"',`status`='"+stat+"' WHERE chid ='" + deletee + "' ";
            if (connection != null) {

                try {    
                     prp = connection.prepareStatement(sql);
                    prp.execute();
                    defaultTableModel.getDataVector().removeAllElements();
                    defaultTableModel.fireTableDataChanged();
                    loadData();
                     q.removeAll();
        cheque ne = new cheque();
        q.add(ne).setVisible(true);
                    JOptionPane.showMessageDialog(null, "Data Saved");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        
        
    }//GEN-LAST:event_cqupdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cqa;
    private javax.swing.JButton cqadd;
    private javax.swing.JButton cqdelete;
    private javax.swing.JLabel cqiss;
    private javax.swing.JLabel cqn;
    private javax.swing.JLabel cqn1;
    private javax.swing.JButton cqsearch;
    private javax.swing.JLabel cqst;
    private javax.swing.JButton cqupdate;
    private javax.swing.JScrollPane cscroll;
    private javax.swing.JTable ct;
    private javax.swing.JLabel exd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tcqa;
    private com.toedter.calendar.JDateChooser tcqiss;
    private javax.swing.JTextField tcqn;
    private javax.swing.JTextField tcqnum;
    private com.toedter.calendar.JDateChooser tcqr;
    private javax.swing.JComboBox<String> tcqsearch;
    private javax.swing.JTextField tcqsearch2;
    private com.toedter.calendar.JDateChooser tcqser;
    private javax.swing.JComboBox<String> tcqst;
    // End of variables declaration//GEN-END:variables
}
