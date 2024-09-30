/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe.student;

/**
 *
 * @author Mohammed Asloof
 */
public class SessionManager {
      private static SessionManager instance;
    private String username;
    private String admissionNo;

    // Private constructor to prevent instantiation
    private SessionManager() {}

    // Method to get the single instance of the class
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Getter and setter methods for session data
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setAdmissionNo(String admissionNo){
        this.admissionNo = admissionNo;
    }
    public String getAdmissionNo(){
        return admissionNo;
    }
    
}
