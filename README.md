YouTube Video Link: https://youtu.be/F2o2MpcFvz4 

Reflection Report

As part of my PROG5121 Assignment 2, I was required to develop a functional Chat App messaging feature that allows users to create and
send messages to recipients, after they have successfully logged into the application. This Chat App messaging feature requires users to
firstly create an account and login into the application using the same credentials. The feature then requests the user to select one of
three options in the Chat Apps Main Menu (1. Send Message, 2. View Message, 3. Quit), allowing users to either create and send messages, 
view the messages sent, or quit the application.

If users select option 1, they are required to input the number of messages that they would like to send, enter the recipients phone number,
and create the messages. After creating each message, a preview of the message is displayed with the recipients number, message, message id,
and message hash, making it easier for users to track and find different messages. Once all the messages have been created, users are finally
given the option to either send, disregard, or store all the messages. To view all the messages sent, users can select option 2 from the Chat 
Apps Main Menu to review the messages and make sure they are sent to the correct recipients. Once the user has created, sent, and reviewed the
messages, they can exit the application by selecting option 3 from the Chat Apps Main Menu. To successfully develop this Chat App messaging feature,
I continued building on my assignment 1 by creating an additional two Java Class Files, ChatApp.java and Message.java, which work together to create,
send, and store messages.

The ChatApp.java file handles user interactions by displaying the Main Menu, capturing user input, and controlling the overall flow of the program 
using loops and conditions. It manages the menu navigation and calls methods from the Message class to perform actions such as sending, viewing, or
storing the messages. The ChatApp.java file also ensures that the user experience is smooth and that the correct options are executed based on the 
user’s selections. The Message.java file contains all of the logic that is related to messages. This includes validating phone numbers, checking 
message length, generating unique message IDs, creating message hashes for easy tracking, and storing messages in a JSON file. The Message.java file 
also displays message summaries and processes the user’s final decision to send, discard, or save the messages. 

Overall, the Chat App messaging feature provides users with a simple and functional user interface which allows them to securely login, create, send,
view, and store their messages. By integrating the ChatApp.java file for user interaction and Message.java file for message processing, this application
ensures that all the key features, such as message validation, ID and hash generation, JSON storage, and automated testing, functions seamlessly and efficiently. 

(470 Words)  

Unit Tests

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

   // Test Data for Task 1
    
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
            System.out.println("Message ready to send.");}}
    
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
            System.out.println("Cellpone Number successfully captured.");}}
   
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
    System.out.println("Generated Message Hash: " + result);}
    
    // Test of checkMessageID method, of Message class.
    // Message ID is generated.
    // Message ID generates 10 random numbers.

    @Test
    public void testCheckMessageID() {
    String result = Message.checkMessageID();
    System.out.println("Message ID generated: " + result);}

    // Test of sentMessage method, of Message class.
    // If "Send Message" is selected, "Message successfully sent" is displayed. 
    // If "Disregard Message" is selected, "Press 0 to delete message" is displayed.     
    // If "Store Message" is selected, "Message successfully stored" is displayed. 
    // If option is invalid, "Invalid option" is displayed.

    @Test
    public void testsentMessage() {
        String userOption = " Send Message";  
        String result;
        if (userOption.equalsIgnoreCase("Send Message")) {
            result = "Message successfully sent.";}
          else if (userOption.equalsIgnoreCase("Disregard Message")) {
            result = "Press 0 to delete message.";}
          else if (userOption.equalsIgnoreCase("Store Message")) {
            result = "Message successfully stored.";}
          else {
            result = "Invalid option";}
        System.out.println(result);}}

    // Test Data for Task 2
   
    // Test of isValidMessage method, of Message class.
    // Message must not exceed 250 characters. 

    @Test
    public void test2IsValidMessage() {
        String message = "a".repeat(250); 
        boolean result = Message.isValidMessage(message);
        if (!result) {
            int extraCharacters = message.length() - 250;
            System.out.println("Message exceeds 250 characters by " + extraCharacters + ", please reduce size.");}
        else {
            System.out.println("Message ready to send.");}}

    // Test of checkRecipientCell method, of Message class.
    // Cellphone Number is correctly formatted.
    // Cellphone Number must contain the international country code.
    // Cellphone number must ten numbers long.

    @Test
    public void test2CheckRecipientCell() {
        String recipientCell = "+27648239164";
        boolean result = Message.checkRecipientCell(recipientCell);
        if (!result) {
            System.out.println("Cellphone Number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");}
        else {
            System.out.println("Cellpone Number successfully captured.");}}

    // Test of createMessageHash method, of Message class.
    // Message is correct.
    // Message Hash is correct.
    // Message ID is automatically generated.
    // Message number is displayed.
    //First and Last words of the message are displayed in capital letters.

    @Test
    public void test2CreateMessageHash() {
    String message = "Hi Keegan, did you receive the payment?";
    String messageId = Message.checkMessageID();
    int messageNumber = 1;
    String result = Message.createMessageHash(messageId, messageNumber, message);
    System.out.println("Generated Message Hash: " + result);
   }
    
    // Test of checkMessageID method, of Message class.
    // Message ID is generated.
    // Message ID generates 10 random numbers.

    @Test
    public void test2CheckMessageID() {
    String result = Message.checkMessageID();
    System.out.println("Message ID generated: " + result);
   }

    // Test of sentMessage method, of Message class.
    // If "Send Message" is selected, "Message successfully sent" is displayed. 
    // If "Disregard Message" is selected, "Press 0 to delete message" is displayed.     
    // If "Store Message" is selected, "Message successfully stored" is displayed. 
    // If option is invalid, "Invalid option" is displayed.

    @Test
    public void test2sentMessage() {
        String userOption = "Disregard Message";  
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

    Test Data for Task 1

1.	Message not being more than 250 characters
  ![image](https://github.com/user-attachments/assets/4354eb1f-44c8-4d27-a794-07e01d411a34)

2.	Recipient Number is correctly formatted
 ![image](https://github.com/user-attachments/assets/ee9eaade-7c9b-4d98-b776-7c4f5a7297d3)

3.	Message Hash is correct
 ![image](https://github.com/user-attachments/assets/86314e34-7abc-406c-b67d-16e04e6c11a6)

4.	Message ID is created
 ![image](https://github.com/user-attachments/assets/e13af06e-d667-440a-ae67-22f0a0a38a56)

5.	Message sent
 ![image](https://github.com/user-attachments/assets/161d14c4-9231-45de-be49-6fa6dd82c6f5)

    Test Data for Task 2
  	
6.	Message not being more than 250 characters 
  ![image](https://github.com/user-attachments/assets/0337ca1e-e3bc-4bbd-b769-9114c42b738f)

7.	Recipient Number is correctly formatted
 ![image](https://github.com/user-attachments/assets/970d4c06-218c-45e5-9d85-0dc584fd0fee)

8.	Message Hash is correct
 ![image](https://github.com/user-attachments/assets/76052f28-1002-4d76-acb0-a65c89fcd50a)

9.	Message ID is created
 ![image](https://github.com/user-attachments/assets/3aff6050-7d9c-4d8d-81ef-dee5b2f24a8d)

10. Message sent
 ![image](https://github.com/user-attachments/assets/04130ec0-ba4a-4fe1-8f90-90f1640fd4a8)

References 

Bro Code. 2020. Java Switch. [YouTube Video]. Available at:   Java switch - YouTube [Accessed: 20 May 2025] 

Bro Code. 2025. While Loops in Java are easy. [YouTube Video]. Available at: WHILE LOOPS in Java are easy [Accessed: 20 May 2025] 

Dev Leonardo. 2023. Understanding GitHub Actions – Automated Testing. [YouTube Video]. Available at: Understanding GitHub Actions - Automated Testing [Accessed: 20 May 2025] 

Neso Academy. 2019. If Statements in Java. [YouTube Video]. Available at: if Statement in Java [Accessed: 20 May 2025]

Neso Academy. 2019. Switch Statements in Java. [YouTube Video]. Available at: switch Statement in Java [Accessed: 20 May 2025]

Neso Academy. 2019. The For Loop in Java. [YouTube Video]. Available at: The For Loop in Java [Accessed: 20 May 2025]

Neso Academy. 2025. Methods in Java. [YouTube Video]. Available at: Methods in Java [Accessed: 20 May 2025]

 ![image](https://github.com/user-attachments/assets/13cafffd-bc08-4e6b-b27a-122a0a5ede9f)
 
Ngema, F. 2025. Switch Statement Code [Image]. Provided in: PROG5121, Varsity College, 22 April 2025.

![image](https://github.com/user-attachments/assets/a3da3847-cb98-407e-8f01-3209e49fbc30)
 
Ngema, F. 2025. While Loop Statement Code [Image]. Provided in: PROG5121, Varsity College, 14 May 2025.

![image](https://github.com/user-attachments/assets/a57e1c43-3137-4f04-b76f-e85d91b18480)
 
Figure 1: ChatGPT response to the prompt “Create a JSON file to store all the messages when the store button is clicked”.   

![image](https://github.com/user-attachments/assets/4cfc72ef-ac8b-48ba-a353-d7611878a06f)
 
Figure 2: ChatGPT response to the prompt “Create a JSON file to store all the messages when the store button is clicked”.

OpenAI, 2025. ChatGPT (April 2025 Version 3.5). [Large Language Model]. Available at: https://chat.openai.com/chat [Accessed: 20 May 2025] 
 








