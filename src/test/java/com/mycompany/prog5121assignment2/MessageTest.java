/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121assignment2;

import java.util.ArrayList;
import java.util.Map;
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
public class MessageTest {
    
    public MessageTest() {
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
    
    // Test of isValidMessage method, of Message class.
    // Message must not exceed 250 characters. 

    @Test
    public void testIsValidMessage() {
        String message = "a".repeat(250); 
        boolean result = Message.isValidMessage(message);
        if (!result) {
            int extraCharacters = message.length() - 250;
            System.out.println("Message exceeds 250 characters by " + extraCharacters + ", please reduce size.");}
        else {
            System.out.println("Message ready to send.");}
    }
    
    // Test of checkRecipientCell method, of Message class.
    // Cellphone Number is correctly formatted.
    // Cellphone Number must contain the international country code.
    // Cellphone number must ten numbers long.

    @Test
    public void testCheckRecipientCell() {
        String recipientCell = "+27628426280";
        boolean result = Message.checkRecipientCell(recipientCell);
        if (!result) {
            System.out.println("Cellphone Number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");}
        else {
            System.out.println("Cellpone Number successfully captured.");}
    }
    
    // Test of createMessageHash method, of Message class.
    // Message Hash is correct.
    // Message ID is automatically generated.
    // Message number is displayed.
    //First and Last words of the message are displayed in capital letters.

    @Test
    public void testCreateMessageHash() {
    String message = "Hi Mike, can you join us for dinner tonight";
    String messageId = Message.checkMessageID();
    int messageNumber = 1;
    String result = Message.createMessageHash(messageId, messageNumber, message);
    System.out.println("Generated Message Hash: " + result);
   }
    
    // Test of checkMessageID method, of Message class.
    // Message ID is generated.
    // Message ID generates 10 random numbers.

    @Test
    public void testCheckMessageID() {
    String result = Message.checkMessageID();
    System.out.println("Message ID generated: " + result);
   }
    
    // Test of sentMessage method, of Message class.
    // If "Send Message" is selected, "Message successfully sent" is displayed. 
    // If "Disregard Message" is selected, "Press 0 to delete message" is displayed.     
    // If "Store Message" is selected, "Message successfully stored" is displayed. 
    // If option is invalid, "Invalid option" is displayed.

    @Test
    public void testsentMessage() {
        String userOption = "Send Message";  
        String result;
        if (userOption.equalsIgnoreCase("Send Message")) {
            result = "Message successfully sent.";}
          else if (userOption.equalsIgnoreCase("Disregard Message")) {
            result = "Press 0 to delete message.";}
          else if (userOption.equalsIgnoreCase("Store Message")) {
            result = "Message successfully stored.";}
          else {
            result = "Invalid option";}
        System.out.println(result);
    }
    
}


