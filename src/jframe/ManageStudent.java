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
import jframe.student.StudentSignUpPage;

/**
 *
 * @author Mohammed Asloof
 */
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form ManageBook
     */
    public ManageStudent() {
        initComponents();
        getStudentDetailsToTable();
    }

    public void getStudentDetailsToTable() {
        String admission, studentName, course, faculty, passWord;
        int phoneNo;
        DefaultTableModel model;

        try {
            Connection con = DbConnection.getconnection();
            Statement stat = con.createStatement();
            ResultSet rst = stat.executeQuery("SELECT * FROM student_signup_details");
            while (rst.next()) {
                admission = rst.getString(1);
                studentName = rst.getString(2);
                passWord = rst.getString(3);
                phoneNo = rst.getInt(4);
                course = rst.getString(5);
                faculty = rst.getString(6);

                Object[] obj = {admission, studentName, passWord, phoneNo, course, faculty};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void clearTableDetails() {
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
    }

    public boolean validSignup() {
        String name = txtStudentName.getText();
        String pwd = txtPassWord.getText();
        String admission = txtAdmission.getText();
        String pno = txtPhNo.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Enter the Name", "Filling Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Enter the PassWOrd", "Filling Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (admission.equals("")) {
            JOptionPane.showMessageDialog(this, "Enter the valid mail ", "Filling Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (pno.equals("") || pno.length() != 10) {
            JOptionPane.showMessageDialog(this, "Enter the Contact", "Filling Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public boolean chkUsrName() {
        String admission = txtAdmission.getText();
        String query = "SELECT Admission_No FROM student_signup_details WHERE Admission_No = ?";
        Connection con = DbConnection.getconnection();
        boolean isExist = false;
        try {
            PreparedStatement pstat = con.prepareStatement(query);
            pstat.setString(1, admission);
            ResultSet rst = pstat.executeQuery();
            if (rst.next()) {
                isExist = true;
            } else {
                isExist = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentSignUpPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isExist;
    }

   public boolean addStudentDetails() {

    boolean added = false;
    String admission = txtAdmission.getText();
    String name = txtStudentName.getText();
    String pwd = txtPassWord.getText();
    String pno = txtPhNo.getText();
    String course = comboCourse.getSelectedItem().toString();
    String faculty = comboFaculty.getSelectedItem().toString();

    // First check if the student already exists
    String checkQuery = "SELECT COUNT(*) FROM student_signup_details WHERE Admission_No = ?";
    String insertQuery = "INSERT INTO student_signup_details VALUES(?,?,?,?,?,?);";
    Connection con = DbConnection.getconnection();
    try {
        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
        checkStmt.setString(1, admission);
        ResultSet rst = checkStmt.executeQuery();
        rst.next();
        if (rst.getInt(1) > 0) {
            // Student already exists, set added to false and return
            return added;
        }

        // If no duplicate, proceed with insertion
        PreparedStatement pstat = con.prepareStatement(insertQuery);
        pstat.setString(1, admission);
        pstat.setString(2, name);
        pstat.setString(3, pwd);
        pstat.setString(4, pno);
        pstat.setString(5, course);
        pstat.setString(6, faculty);

        int chk = pstat.executeUpdate();
        if (chk == 1) {
            added = true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
    }

    return added;
}

    public boolean updateStudentDetails() {
        boolean isUpdate = false;

        // Check if the fields are not empty or null before proceeding
        if (txtAdmission.getText().isEmpty() || txtStudentName.getText().isEmpty()
                || txtPassWord.getText().isEmpty() || txtPhNo.getText().isEmpty()
                || comboCourse.getSelectedItem() == null || comboFaculty.getSelectedItem() == null) {
            System.out.println("All fields are required!");
            return false;
        }

        String admission = txtAdmission.getText();
        String name = txtStudentName.getText();
        String pwd = txtPassWord.getText();
        String pno = txtPhNo.getText();
        String course = comboCourse.getSelectedItem().toString();
        String faculty = comboFaculty.getSelectedItem().toString();

        String query = "UPDATE student_signup_details SET userName = ?, passWord = ?, phoneNumber = ?, course = ?, faculty = ? WHERE Admission_No = ?;";

        Connection con = DbConnection.getconnection();
        try {
            PreparedStatement pstat = con.prepareStatement(query);
            pstat.setString(1, name);
            pstat.setString(2, pwd);
            pstat.setString(3, pno);
            pstat.setString(4, course);
            pstat.setString(5, faculty);
            pstat.setString(6, admission);

            int chk = pstat.executeUpdate();
            if (chk > 0) {
                isUpdate = true;
            } else {
                isUpdate = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUpdate;
    }

    public boolean deleteStudentDetails() {
        boolean isDelete = false;
        String admission = txtAdmission.getText(); // Fetch admission number from input

        if (admission.isEmpty()) {
            System.out.println("Admission number is empty, cannot delete.");
            return false; // Ensure admission number is present
        }

        String query = "DELETE FROM student_signup_details WHERE Admission_No = ?;";
        Connection con = DbConnection.getconnection();
        try {
            PreparedStatement pstat = con.prepareStatement(query);
            pstat.setString(1, admission);  // Set the admission number

            int chk = pstat.executeUpdate(); // Execute the delete query
            if (chk > 0) {
                isDelete = true;  // Record successfully deleted
            } else {
                isDelete = false; // No record found for deletion
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isDelete;
    }

    public void emptyText() {
        txtAdmission.setText("");
        txtStudentName.setText("");

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
        txtAdmission = new app.bolivia.swing.JCTextField();
        txtStudentName = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        comboCourse = new javax.swing.JComboBox<>();
        comboFaculty = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPassWord = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPhNo = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student Admission No");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 210, 30));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 30, 40));

        txtAdmission.setBackground(new java.awt.Color(102, 102, 255));
        txtAdmission.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAdmission.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtAdmission.setPlaceholder("20APSE****");
        txtAdmission.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAdmissionFocusLost(evt);
            }
        });
        jPanel1.add(txtAdmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 230, -1));

        txtStudentName.setBackground(new java.awt.Color(102, 102, 255));
        txtStudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtStudentName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtStudentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentNameFocusLost(evt);
            }
        });
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 230, 30));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Student Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 130, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Course");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 120, 30));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Faculty");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 150, 30));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, -1, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, -1, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 640, -1, 70));

        comboCourse.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        comboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Software Engineering", "Information System", "Sport Science", "Physical Education", "Natural Resourse Managemnt" }));
        jPanel1.add(comboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 240, -1));

        comboFaculty.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        comboFaculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Faculty of Computing", "Faculty of Applied Science", "Faculty of Management", "Faculty of Social Science" }));
        jPanel1.add(comboFaculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, 240, -1));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("PassWord");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 101, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 40, 40));

        txtPassWord.setBackground(new java.awt.Color(102, 102, 255));
        txtPassWord.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPassWord.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtPassWord.setPlaceholder("********");
        txtPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 290, -1));

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 40, 40));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Phone Number");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 135, 30));

        txtPhNo.setBackground(new java.awt.Color(102, 102, 255));
        txtPhNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPhNo.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtPhNo.setPlaceholder("0771234567");
        jPanel1.add(txtPhNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 290, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admission No", "Student Name", "Password", "Phone Number", "Course", "Faculty"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 102, 102));
        tbl_studentDetails.setFocusable(false);
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(25);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 880, 310));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel2.setText("Manage Student");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 330, 100));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 390, 4));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 890, 720));

        setSize(new java.awt.Dimension(1390, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage homepg = new HomePage();
        homepg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtAdmissionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdmissionFocusLost

    }//GEN-LAST:event_txtAdmissionFocusLost

    private void txtStudentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStudentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameFocusLost

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (addStudentDetails()) {
            JOptionPane.showMessageDialog(this, "Book details add Successfully");
            chkUsrName();
            validSignup();
            clearTableDetails();
            getStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Student Details Added Not success fully", "Adding Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        txtAdmission.setText(model.getValueAt(rowNo, 0).toString());
        txtPassWord.setText(model.getValueAt(rowNo, 2).toString());
        txtPhNo.setText(model.getValueAt(rowNo, 3).toString());
        txtStudentName.setText(model.getValueAt(rowNo, 1).toString());
        comboCourse.setSelectedItem(model.getValueAt(rowNo, 4));
        comboFaculty.setSelectedItem(model.getValueAt(rowNo, 5));


    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updateStudentDetails()) {

            clearTableDetails();
            getStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Update Failiur", "Update", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (deleteStudentDetails()) {
            clearTableDetails();
            getStudentDetailsToTable();
            emptyText();
        } else {
            JOptionPane.showMessageDialog(this, "Delete Failiur", "Delete", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txtPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassWordActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCourse;
    private javax.swing.JComboBox<String> comboFaculty;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircleBeanInfo rSMaterialButtonCircleBeanInfo1;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txtAdmission;
    private app.bolivia.swing.JCTextField txtPassWord;
    private app.bolivia.swing.JCTextField txtPhNo;
    private app.bolivia.swing.JCTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
