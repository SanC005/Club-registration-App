package com.example.clubapp;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class details {
    String reg_id;
    String email_id;
    String password;

    public details(){

    }
    public details(String reg_id, String email_id, String password) {
        this.reg_id = reg_id;
        this.email_id = email_id;
        this.password = password;
    }



    public void setreg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public String getreg_id() {
        return reg_id;
    }


    public void setemail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getemail_id() {
        return email_id;
    }


    public void setpassword(String password) {
        this.password = password;
    }

    public String getpassword() {
        return password;
    }


}