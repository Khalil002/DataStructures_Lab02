/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System2;

import java.util.ArrayList;

/**
 *
 * @author khali
 */
public class User {

    private String userID;
    private String name;
    private String surname;
    private int identificationNumber;
    private String email;
    private String password;

    public User(String name, String surname, int identificationNumber, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.password = password;
        this.userID = calculateHash(); 
    }

    private String calculateHash() {
        return StringUtil.applySha256(
                name
                + surname
                + identificationNumber
                + email
                + password
        );
    }
    
    
    public String getID(){
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString(){
        return userID+","+name+","+surname+","+identificationNumber+","+email+","+password;
    }
}

