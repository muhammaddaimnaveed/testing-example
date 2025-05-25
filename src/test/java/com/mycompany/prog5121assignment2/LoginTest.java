/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121assignment2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author daimm
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // Test of checkUsername method, of Login class.
    // Username is correctly formatted.
    // Username must contain a underscore.
    // Username must not be longer than five characters.
    
    @Test
    public void testValidUsername() {
        String username = "kyl_1";
        System.out.println("Welcome " + username + ", it is great to see you.");
        boolean expResult = true;
        boolean result = Login.checkUsername(username);
        assertEquals(expResult, result);
        
    }
    
    // Test of checkUsername method, of Login class.
    // Username is incorrectly formatted.
    // Username does not contain a underscore.
    // Username is greater than five characters long.
    
    @Test
    public void testInvalidUsername() {
        String username = "kyle!!!!!!!";
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        boolean expResult = false;
        boolean result = Login.checkUsername(username);
        assertEquals(expResult, result);
        
    }
    
    // Test of checkPassword method, of Login class.
    // Password meets the complexity requirements. 
    // Password must be at least eight characters long.
    // Password must have a capital letter.
    // Password must have a number.
    // Password must have a special symbol.
    
    @Test
    public void testValidPassword() {
        String password = "Ch&&sec@ke99!";
        System.out.println("Password successfully captured.");
        boolean expResult = true;
        boolean result = Login.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }
    
    // Test of checkPassword method, of Login class.
    // Password does not meet the complexity requirements. 
    // Password is not eight characters long.
    // Password does not have a capital letter.
    // Password does not have a number.
    // Password does not have a special symbol.
    
    @Test
    public void testInvalidPassword() {
        String password = "password";
        System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
        boolean expResult = false;
        boolean result = Login.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }
    
    // Test of checkCellphoneNumber method, of Login class.
    // Cellphone Number is correctly formatted.
    // Cellphone Number must contain the international country code.
    // Cellphone number must ten numbers long.
    
    @Test
    public void testValidCellphoneNumber() {
        String cellphoneNumber = "+27838968976";
        System.out.println("Cellphone number successfully captured.");
        boolean expResult = true;
        boolean result = Login.checkCellphoneNumber(cellphoneNumber);
        assertEquals(expResult, result);
        
    }
    
    // Test of checkCellphoneNumber method, of Login class.
    // Cellphone Number is correctly formatted.
    // Cellphone Number must contain the international country code.
    // Cellphone number must ten numbers long.
    
    @Test
    public void testInvalidCellphoneNumber() {
        String cellphoneNumber = "08966553";
        System.out.println("Cellphone number incorrectly formatted or does not contain the international code. Please correct the number and try again.");
        boolean expResult = false;
        boolean result = Login.checkCellphoneNumber(cellphoneNumber);
        assertEquals(expResult, result);
        
    }

    // Test of verifyCredentials method, of Login class.
    // The newly created Credentials match the Login details.
    @Test
    public void testVerifyCorrectCredentials() {
        String loginUsername = "kyl_1";
        String loginPassword = "CH&&sec@ke99";
        String username = "kyl_1";
        String password = "CH&&sec@ke99";
        System.out.println("Login Successful");
        boolean expResult = true;
        boolean result = Login.verifyCredentials(loginUsername, loginPassword, username, password);
        assertEquals(expResult, result);
       
    }
    
    // Test of verifyCredentials method, of Login class.
    // The newly created Credentials do not match the Login details.
    @Test
    public void testVerifyIncorrectCredentials() {
        String loginUsername = "kyl_1";
        String loginPassword = "CH&&sec@ke99";
        String username = "kyle!!!!!!!";
        String password = "password";
        System.out.println("Login Failed");
        boolean expResult = false;
        boolean result = Login.verifyCredentials(loginUsername, loginPassword, username, password);
        assertEquals(expResult, result);
       
    }
   
}
