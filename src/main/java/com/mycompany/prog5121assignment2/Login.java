/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121assignment2;

/**
 *
 * @author daimm
 */
public class Login {
    
    // Conditions required for the Username.
    // Username must contain a underscore.
    // Username must not be longer than five characters
    
   public static boolean checkUsername (String username){
    return username.contains("_") && username.length() <= 5;}
   
   // Conditions required for the Password.
   // Password must be at least eight characters long.
   // Password must have a capital letter.
   // Password must have a number.
   // Password must have a special symbol.
   
   public static boolean checkPasswordComplexity (String password){
    return password.length() >= 8 && password.matches(".*[A-Z]*.") && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9].*");}
   
   // Conditions required for the Cellphone Number.
   // Cellphone Number must contain the international country code.
   // Cellphone number must be ten numbers long.
   
   public static boolean checkCellphoneNumber(String cellphoneNumber) {
    return cellphoneNumber.matches("^\\+27[678][0-9]{8}$");}
   
   // Verifies the input Login details with the stored credentials.
    
   public static boolean verifyCredentials(String loginUsername, String loginPassword, String username, String password){
    return loginUsername.equals(username) && loginPassword.equals(password);
    
     }
    }

