/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121assignment2;
import javax.swing.JOptionPane;

/**
 *
 * @author daimm
 */
public class Main {

    public static void main(String[] args) {
        
        // Prompts the user to create a Username.
        // Stores the input in the username String.
        
        String username = JOptionPane.showInputDialog("Create an Account \nCreate a Username (max 5 chars, must contain underscore)");
        
        // While Loop ensures that the Username is correctly formatted, meeting all the required condtions.
        // Informs the user if the Username is not captured successfully. (Does not meet the requirements)
        // Prompts the user to create a new Username.
        
        while (!Login.checkUsername(username)) {           
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");          
            username = JOptionPane.showInputDialog(null, "Create an Account \nCreate a Username (max 5 chars, must contain underscore)");}
        
        // Inform the user that their Username was captured successfully. 
         
        JOptionPane.showMessageDialog(null, "Username successfully captured." );
        
        // Prompts the user to create a Password.
        // Stores the input in the password String.
        
        String password = JOptionPane.showInputDialog("Create an Account \nCreate a Password (min 8 chars, must contain capital letter, number and special symbol)");
        
        // While Loop ensures that the Password is correctly formatted, meeting all the required condtions.
        // Informs the user if the Password is not captured successfully. (Does not meet the requirements)
        // Prompts the user to create a new Password.
        
        while (!Login.checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
            password = JOptionPane.showInputDialog(null, "Create an Account \nCreate a Password (min 8 chars, must contain capital letter, number and special symbol)");}
        
        // Inform the user that their Password was captured successfully. 
    
        JOptionPane.showMessageDialog(null, "Password successfully captured.");
        
        // Prompts the user to enter their Cellphone Number.
        // Stores the input in the cellphoneNumber String.
        
        String cellphoneNumber = JOptionPane.showInputDialog("Create an Account \nEnter your Cellphone Number (must consist of 10 numbers, contain the international country code)");
        
        // While Loop ensures that their Cellphone Number is correctly formatted, meeting all the required condtions.
        // Informs the user if the Cellphone Number is not captured successfully. (Does not meet the requirements)
        // Prompts the user to re-enter their Cellphone Number.
        
        while (!Login.checkCellphoneNumber(cellphoneNumber)) {
            JOptionPane.showMessageDialog(null, "Cellphone number incorrectly formatted or does not contain the international code. ");
            cellphoneNumber = JOptionPane.showInputDialog("Create an Account \nEnter your Cellphone Number (must consist of 10 numbers, contain the international country code)");}
        
        // Inform the user that their Cellphone Number was captured successfully. 
        
        JOptionPane.showMessageDialog(null, "Cellphone number successfully added.");
        
        // Starts the Login process.
        
        boolean loggedIn = false; 
        
        // While Loop continuously asks for the Login credentials until the user successfully logs in. 
        // Prompts the user to enter their Username.
        // Prompts the user to enter their Password.
        
        while (!loggedIn) {
            String loginUsername = JOptionPane.showInputDialog("Login \nEnter your Username");
            String loginPassword = JOptionPane.showInputDialog("Login \nEnter your Password");
        
        // Checks if the entered Username and Password are correct.
        // Informs the user if the credentials are correct and welcomes them.
        
        if (Login.verifyCredentials(loginUsername, loginPassword, username, password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + username + " it is great to see you again.");
            loggedIn = true; 
        
        /* If the credentials are correct, the program calls the ChatApp Menu, allowing the User 
           to choose between sending a message, viewing the message, or exiting the application.*/
            
            ChatApp.showMenu();}
        
       // Informs the user if the credentials are incorrect and asks them to try again.
        
        else {JOptionPane.showMessageDialog(null, "Username or Password incorrect, please try again.");
        
        // Asks the user if they would like to reset their Credentials after a unsuccessful Login attempt.
        
        String resetCredentials = JOptionPane.showInputDialog("Reset Credentials? (Yes/No)");
        
        // Checks to see if the user chose to reset their Credentials.
        // If yes, prompt the user to enter their new Username.

        if (resetCredentials != null && resetCredentials.equalsIgnoreCase("yes")) {
            username = JOptionPane.showInputDialog("Create an Account \nEnter new Username(max 5 chars, must contain underscore)");
            
        // Checks if the newly created entered Username is correct.
        // Informs the user if the Username is not captured successfully. (Does not meet the requirements)
            
        while (!Login.checkUsername(username)) {
            username = JOptionPane.showInputDialog("Username incorrect. Try again:");} }
        
        // Checks to see if the user chose to reset their Credentials.
        // If yes, promt the user to enter their new Password.
        
        if (resetCredentials != null && resetCredentials.equalsIgnoreCase("yes")) {
            password = JOptionPane.showInputDialog("Create an Account \nEnter new Password (min 8 chars, must contain capital letter, number and special symbol)");
            
        // Checks if the newly created entered Password is correct.
        // Informs the user if the Password is not captured successfully.(Does not meet the requirements)
            
        while (!Login.checkPasswordComplexity(password)) {
            password = JOptionPane.showInputDialog("Password incorrect. Try again:");}
        
        // Informs the user that their Credentials are reset. (Does meet the requirements) 

        JOptionPane.showMessageDialog(null, "Username and Password reset. Please log in again.");}
    }
   }
        
  }
 }
