/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammed Asloof
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    public void getBookDetails() {
        String input = txtBookId.getText();
        if (input.matches("-?\\d+")) {
            int bookId = Integer.parseInt(input);
            String query = "SELECT * FROM book_details WHERE book_Id = ?;";
            Connection con = DbConnection.getconnection();
            try {
                PreparedStatement pstat = con.prepareStatement(query);
                pstat.setInt(1, bookId);
                ResultSet rst = pstat.executeQuery();
                if (rst.next()) {
                    String bookIdi = rst.getString(1);
                    String bookName = rst.getString(2);
                    String bookAuthor = rst.getString(3);
                    String Quantity = rst.getString(4);
                    lblBookId.setText(bookIdi);
                    lblBookName.setText(bookName);
                    lblAuthor.setText(bookAuthor);
                    lblQuantity.setText(Quantity);
                    lbl_BookError.setText(" ");

                } else {
                    lbl_BookError.setText("Invalid Book Id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void getStudentDetails() {
        String studentId = txtStudentId.getText();
        String query = "SELECT * FROM student_signup_details WHERE Admission_No=?;";
        Connection con = DbConnection.getconnection();
        try {
            PreparedStatement psat = con.prepareStatement(query);
            psat.setString(1, studentId);
            ResultSet rst = psat.executeQuery();
            if (rst.next()) {
                lblStudentId.setText(rst.getString(1));
                lblStudentName.setText(rst.getString(2));
                lblCourse.setText(rst.getString(5));
                lblFaculty.setText(rst.getString(6));
                lbl_StudentError.setText(" ");

            } else {
                lbl_StudentError.setText("Inavlid Student Id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean issueBook() {
        String bookIdText = txtBookId.getText().trim();
        String studentId = txtStudentId.getText().trim();
        String bookName = lblBookName.getText().trim();
        String studentName = lblStudentName.getText().trim();

        java.util.Date issueDateValue = issueDate.getDatoFecha();
        java.util.Date dueDateValue = dueDate.getDatoFecha();

        // Validate if any field is empty or invalid
        if (bookIdText.isEmpty() || studentId.isEmpty() || bookName.isEmpty() || studentName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        // Validate date fields
        if (issueDateValue == null || dueDateValue == null) {
            JOptionPane.showMessageDialog(this, "Please select valid issue and due dates!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        int bookId;
        try {
            bookId = Integer.parseInt(bookIdText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Book ID. Please enter a valid number!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        long issueDateMillis = issueDateValue.getTime();
        long dueDateMillis = dueDateValue.getTime();
        java.sql.Date sqlIssueDate = new java.sql.Date(issueDateMillis);
        java.sql.Date sqlDueDate = new java.sql.Date(dueDateMillis);

        try {
            Connection con = DbConnection.getconnection();
            String sql = "INSERT INTO issue_book_details (book_id, book_name, student_id, student_name, issue_date, due_date, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sqlIssueDate);
            pst.setDate(6, sqlDueDate);
            pst.setString(7, "pending");

            int rowCount = pst.executeUpdate();
            return rowCount > 0;  // Return true if the book is issued, otherwise false
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error issuing the book. Please try again.", "Database Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public Boolean isAlreadyIssued() {
        String bookIdText = txtBookId.getText().trim();
        String studentId = txtStudentId.getText().trim();

        if (bookIdText.isEmpty() || studentId.isEmpty()) {
            return null;  // Return null if either field is empty
        }

        int bookId;
        try {
            bookId = Integer.parseInt(bookIdText);
        } catch (NumberFormatException e) {
            return null;  // Return null if the Book ID is not a valid integer
        }

        try {
            Connection con = DbConnection.getconnection();
            String sql = "SELECT * FROM issue_book_details WHERE book_id = ? AND student_id = ? AND status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, studentId);
            pst.setString(3, "pending");

            ResultSet rst = pst.executeQuery();
            return rst.next();  // Return true if the record exists, otherwise false
        } catch (SQLException e) {
            e.printStackTrace();
            return null;  // Return null if there's a database error
        }
    }

    public void updateBookCount() {
        // Ensure the txtBookId field is not empty before parsing it
        String bookIdText = txtBookId.getText().trim();

        if (bookIdText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book ID cannot be empty!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return; // Exit the method if the input is invalid
        }

        int bookId;
        try {
            bookId = Integer.parseInt(bookIdText);  // Convert the text to integer
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Book ID. Please enter a valid number!", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return; // Exit the method if conversion fails
        }

        try {
            Connection con = DbConnection.getconnection();
            String sql = "UPDATE book_details SET quantity = quantity - 1 WHERE book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book count updated successfully!", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update book count. Book ID may not exist.", "Update Failed", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error in database operation", "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(
            "unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblFaculty = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblStudentId = new javax.swing.JLabel();
        lblStudentName = new javax.swing.JLabel();
        lblCourse = new javax.swing.JLabel();
        lbl_StudentError = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblQuantity = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lblBookId = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_BookError = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtStudentId = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        txtBookId = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel16 = new javax.swing.JLabel();
        dueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel17 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel3.setText("Student Details ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 290, 100));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Faculty :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 330, 5));

        lblFaculty.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblFaculty.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 200, 40));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student Name : ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 40));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Course :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, 40));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student Id :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, 40));

        lblStudentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblStudentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 150, 40));

        lblStudentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblStudentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 150, 40));

        lblCourse.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblCourse.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 210, 40));

        lbl_StudentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_StudentError.setForeground(new java.awt.Color(255, 204, 51));
        jPanel2.add(lbl_StudentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 400, 590));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel5.setText("Book Details");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 260, 90));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 330, 5));

        lblQuantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 150, 40));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Book Name : ");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Author :");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, 40));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bookId.setText("Book Id :");
        jPanel6.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, 40));

        lblBookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblBookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lblBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 150, 40));

        lblBookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblBookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lblBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 250, 40));

        lblAuthor.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lblAuthor.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 150, 40));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quantity :");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 40));

        lbl_BookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_BookError.setForeground(new java.awt.Color(255, 204, 51));
        jPanel6.add(lbl_BookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 150, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 590));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel13.setText("Student Details ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 290, -1));

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 185, 310, 5));

        txtStudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txtStudentId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtStudentId.setPlaceholder("20APSE****");
        txtStudentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentIdFocusLost(evt);
            }
        });
        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 260, 230, 30));

        jLabel14.setBackground(new java.awt.Color(255, 51, 51));
        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Student Id :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 260, 120, 30));

        txtBookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txtBookId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtBookId.setPlaceholder("1");
        txtBookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBookIdFocusLost(evt);
            }
        });
        txtBookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtBookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 320, 230, 30));

        jLabel15.setBackground(new java.awt.Color(255, 51, 51));
        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Issue Date :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 110, 30));

        issueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        issueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        issueDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        issueDate.setPlaceholder("Select Issue Date");
        jPanel1.add(issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 51, 51));
        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("Book Id :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 110, 30));

        dueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        dueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        dueDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        dueDate.setPlaceholder("Select Issue Date");
        jPanel1.add(dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 440, -1, -1));

        jLabel17.setBackground(new java.awt.Color(255, 51, 51));
        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Return Date :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 450, 120, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Issue Book");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 520, 220, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 610));

        setSize(new java.awt.Dimension(1294, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtStudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentIdFocusLost
        getStudentDetails();
    }//GEN-LAST:event_txtStudentIdFocusLost

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed

    }//GEN-LAST:event_txtStudentIdActionPerformed

    private void txtBookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBookIdFocusLost
        getBookDetails();
    }//GEN-LAST:event_txtBookIdFocusLost

    private void txtBookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIdActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed

    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        if (lblQuantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, " Book is not Avalilable", "Books", JOptionPane.WARNING_MESSAGE);

        } else {
            if (isAlreadyIssued() == false) {
                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(this, "book issued successfully");
                    updateBookCount();
                } else {
                    JOptionPane.showMessageDialog(this, "can't issue the book");
                }
            }
        }

    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser dueDate;
    private rojeru_san.componentes.RSDateChooser issueDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookId;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblFaculty;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lbl_BookError;
    private javax.swing.JLabel lbl_StudentError;
    private javax.swing.JLabel lbl_bookId;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txtBookId;
    private app.bolivia.swing.JCTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}
