/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mohammed Asloof
 */
public class ManageBook extends javax.swing.JFrame {

    /**
     * Creates new form ManageBook
     */
   
    public ManageBook() {
        initComponents();
        getBookDetailsToTable();
    }

    public void getBookDetailsToTable(){
                String bookName,author;
        int bookId,quantity;
        DefaultTableModel model;
       
        try {
            Connection con = DbConnection.getconnection();
            Statement stat = con.createStatement();
            ResultSet rst = stat.executeQuery("SELECT * FROM book_details;");
            while(rst.next()){
                bookName = rst.getString(2);
                author = rst.getString(3);
                bookId = rst.getInt(1);
                quantity = rst.getInt(4);
                
                Object[] obj = {bookId,bookName,author,quantity};
                model = (DefaultTableModel)tbl_bookDetails.getModel();
                model.addRow(obj);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void clearTableDetails(){
        DefaultTableModel model =(DefaultTableModel) tbl_bookDetails.getModel();
        model.setRowCount(0);
    }
    public boolean addBookDetails() {
    String bookName, author;
    int bookId, quantity;
    boolean added = false;

    // Validate and parse inputs
    try {
        if (txtBookId.getText().trim().isEmpty() || txtQuantity.getText().trim().isEmpty()) {
            System.out.println("Book ID and Quantity fields must not be empty.");
            return false;
        }

        bookId = Integer.parseInt(txtBookId.getText().trim());
        quantity = Integer.parseInt(txtQuantity.getText().trim());

        bookName = txtBookName.getText().trim();
        author = txtAuthorName.getText().trim();

        if (bookName.isEmpty() || author.isEmpty()) {
            System.out.println("Book Name and Author fields must not be empty.");
            return false;
        }

        String query = "INSERT INTO book_details VALUES(?,?,?,?);";
        Connection con = DbConnection.getconnection();

        PreparedStatement pstat = con.prepareStatement(query);
        pstat.setInt(1, bookId);
        pstat.setString(2, bookName);
        pstat.setString(3, author);
        pstat.setInt(4, quantity);

        int chk = pstat.executeUpdate();
        if (chk == 1) {
            added = true;
        }

    } catch (NumberFormatException e) {
        System.out.println("Invalid input: " + e.getMessage());
    } catch (SQLException ex) {
        Logger.getLogger(ManageBook.class.getName()).log(Level.SEVERE, null, ex);
    }

    return added;
}

    
public boolean updateBookDetails() {
    boolean isUpdate = false;

    // Validate input fields
    if (txtBookId.getText().isEmpty() || txtQuantity.getText().isEmpty()) {
        System.out.println("Book ID or Quantity field is empty.");
        return false;  // Return early if inputs are invalid
    }

    try {
        int bookId = Integer.parseInt(txtBookId.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        String bookName = txtBookName.getText();
        String bookAuthor = txtAuthorName.getText();

        // Assuming connection and query preparation remain unchanged
        String query = "UPDATE book_details SET book_Name = ?, book_author = ?, qty = ? WHERE book_Id = ?;";
        Connection con = DbConnection.getconnection();
        PreparedStatement pstat = con.prepareStatement(query);

        pstat.setString(1, bookName);
        pstat.setString(2, bookAuthor);
        pstat.setInt(3, quantity);
        pstat.setInt(4, bookId);

        int chk = pstat.executeUpdate();
        if (chk > 0) {
            isUpdate = true;
        }
    } catch (NumberFormatException ex) {
        System.out.println("Invalid number format: " + ex.getMessage());
    } catch (SQLException ex) {
        Logger.getLogger(ManageBook.class.getName()).log(Level.SEVERE, null, ex);
    }

    return isUpdate;
}

    
    public boolean deleteBookDetails() {
    boolean isDelete = false;

    // Validate the input for book ID
    try {
        if (txtBookId.getText().trim().isEmpty()) {
            System.out.println("Book ID field must not be empty.");
            return false;
        }

        // Parse the book ID
        int bookId = Integer.parseInt(txtBookId.getText().trim());

        String query = "DELETE FROM book_details WHERE book_Id = ?;";
        Connection con = DbConnection.getconnection();

        PreparedStatement pstat = con.prepareStatement(query);
        pstat.setInt(1, bookId);
        int chk = pstat.executeUpdate();

        if (chk > 0) {
            isDelete = true;
        }

    } catch (NumberFormatException e) {
        System.out.println("Invalid input: " + e.getMessage());
    } catch (SQLException ex) {
        Logger.getLogger(ManageBook.class.getName()).log(Level.SEVERE, null, ex);
    }

    return isDelete;
}


    public void emptyText(){
        txtBookId.setText("");
        txtBookName.setText("");
        txtAuthorName.setText("");
        txtQuantity.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMaterialButtonCircleBeanInfo1 = new rojerusan.RSMaterialButtonCircleBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBookId = new app.bolivia.swing.JCTextField();
        txtBookName = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAuthorName = new app.bolivia.swing.JCTextField();
        txtQuantity = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book ID ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 154, 101, 30));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 30, 40));

        txtBookId.setBackground(new java.awt.Color(102, 102, 255));
        txtBookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtBookId.setPlaceholder("1");
        txtBookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBookIdFocusLost(evt);
            }
        });
        jPanel1.add(txtBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 230, -1));

        txtBookName.setBackground(new java.awt.Color(102, 102, 255));
        txtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBookName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtBookName.setPlaceholder("Future Bussiness");
        txtBookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBookNameFocusLost(evt);
            }
        });
        txtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 230, 30));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 101, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author Name");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 120, 30));

        txtAuthorName.setBackground(new java.awt.Color(102, 102, 255));
        txtAuthorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAuthorName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtAuthorName.setPlaceholder("Asloof");
        txtAuthorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAuthorNameFocusLost(evt);
            }
        });
        jPanel1.add(txtAuthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 230, -1));

        txtQuantity.setBackground(new java.awt.Color(102, 102, 255));
        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtQuantity.setPlaceholder("25");
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 230, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quantity");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 101, 30));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, -1, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, -1, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, -1, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Book Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 102, 102));
        tbl_bookDetails.setFocusable(false);
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setRowHeight(25);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 790, 310));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Manage Book");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 250, 70));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 330, 4));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 890, 720));

        setSize(new java.awt.Dimension(1390, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage homepg = new HomePage();
        homepg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookIdFocusLost
       
    }//GEN-LAST:event_txtBookIdFocusLost

    private void txtBookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameFocusLost

    private void txtAuthorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAuthorNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorNameFocusLost

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(addBookDetails()){
            JOptionPane.showMessageDialog(this, "Book details add Successfully");
            clearTableDetails();
            getBookDetailsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Book Details Added Not success fully", "Adding Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        txtBookId.setText(model.getValueAt(rowNo, 0).toString());
        txtBookName.setText(model.getValueAt(rowNo, 1).toString());
        txtAuthorName.setText(model.getValueAt(rowNo, 2).toString());
        txtQuantity.setText(model.getValueAt(rowNo, 3).toString());
        
        
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
       if(updateBookDetails()){
          
           clearTableDetails();
           getBookDetailsToTable();
       }
       else{
           JOptionPane.showMessageDialog(this, "Update Failiur","Update",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(deleteBookDetails()){
           clearTableDetails();
           getBookDetailsToTable();
           emptyText();
        }
        else{
           JOptionPane.showMessageDialog(this, "Delete Failiur","Delete",JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircleBeanInfo rSMaterialButtonCircleBeanInfo1;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txtAuthorName;
    private app.bolivia.swing.JCTextField txtBookId;
    private app.bolivia.swing.JCTextField txtBookName;
    private app.bolivia.swing.JCTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

    void setBookId(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setBookTitle(String valid_Book_Title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
