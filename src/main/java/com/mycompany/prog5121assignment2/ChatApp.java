package com.mycompany.prog5121assignment2;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatApp {
    
    // An Array List that stores all the messages sent to the Recipient.   
    
    private static final ArrayList<Map<String, String>> allSentMessages = new ArrayList<>();
    
    // Welcomes the User after they have successfully logged in. 
    // Displays the Main Menu of the application, allowing users to send messages, view messages, or quit the application.

    public static void showMenu() {

        boolean exit = false;
        
    // A While Loop that continuously displays the Main Menu until the User chooses to quit the application. 

        while (!exit) {
            
    // Displays the Main Menu options.
    // Prompts the User to select an option. 
    // Stores the input in the menuOption String.
    
            String menuOption = JOptionPane.showInputDialog(
                "Welcome to QuickChat\n" +
                "1. Send Message\n" +
                "2. View Message\n" +
                "3. Quit" );
            
            
    // Handles the User input by executing different actions based on the selected Menu option.

            switch (menuOption) {
                
    //Option 1: Enables the User to send a message.   

                case "1":
                    
    // Prompts the User to input the number of messages they would like to send.
    // Stores the input in the numMessage String.
    /* The input is first received as a String and then converted to an Integer using getNumberOfMessages(), 
       determining how many messages a User wants to send.*/
                    
                    String numMessage = JOptionPane.showInputDialog("How many messages do you want to send?");
                    try {
                        int num = Message.getNumberOfMessages(numMessage);
                        
    // An Array List temporary holds all the messages before sending or storing.                  

                        ArrayList<Map<String, String>> messageList = new ArrayList<>();
                        
    // A While Loop that continuously prompts the User to enter a Recipient Number.
    // Keeps prompting until valid input is provided or the user cancels.
    // Validates the Recipient Phone Number.
    // Stores the input in the recipientNumber String. 

                        String recipientNumber = JOptionPane.showInputDialog("Enter recipient phone number:");
                        while (recipientNumber != null && !Message.checkRecipientCell(recipientNumber)) {
                            JOptionPane.showMessageDialog(null, "Invalid recipient phone number.");
                            recipientNumber = JOptionPane.showInputDialog("Enter recipient phone number (+27 format):");}
                        
                        if (recipientNumber == null) break;
                        
    // A For Loop that prompts and collects all of the Users messages.
    // Stores the messages in the message String. 
    
                        for (int i = 1; i <= num; i++) {
                            String message = JOptionPane.showInputDialog("Enter Message " + i + ":");
                            if (message == null) break;
                            
    // Validates the lenght of each message.  

                            if (!Message.isValidMessage(message)) {
                                JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
                                i--;
                                continue;}
                                
    // Generate a unique 10-digit ID for each message.
    // Stores the message ID in the messageID String. 
    
                            String messageId = Message.checkMessageID();
                            
    /* Generate a unique Message Hash that consists of the first two numbers of the message Id, a colon,
       the number of the message, and the first and last words of the message.*/
    // Stores the Message Hash in the messageHash String
    
                            String messageHash = Message.createMessageHash(messageId, i, message);
                            
    // Creates a message layout to hold each message detail. 

                            Map<String, String> messageData = new HashMap<>();
                            messageData.put("recipient", recipientNumber);
                            messageData.put("message", message);
                            messageData.put("messageId", messageId);
                            messageData.put("messageHash", messageHash);
                            
    // Adds the message to the temporary message list.

                            messageList.add(messageData);
                            
    // Displays the layout of the message with each message detail. 

                            JOptionPane.showMessageDialog(null,
                                "Message Created!\n" +
                                "To: " + recipientNumber + "\n" +
                                "Message " + i + " : " + message + "\n" +
                                "Message ID: " + messageId + "\n" +
                                "Message Hash: " + messageHash);}
                        
    // Prompts the User on what they would like to do with the messages (Send, Disregard, Store).

                        String[] options = {"Send", "Disregard", "Store"};
                        int choice = JOptionPane.showOptionDialog(
                            null,
                            "What do you want to do with the messages?",
                            "Post-Message Options",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                        
    // Handles the message processing based on the Users choice.                   

                        Message.sentMessage(choice, messageList, allSentMessages); }
                    
    // Handles the invalid Menu selection.
    // Prompts the User to enter a valid number from the options.
                    
                     catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");}
                    
                    break;
                    
    //Option 2: Enables the User to all the previously sent messages.   

                case "2":
                    Message.viewAllMessages(allSentMessages);
                    break;
                    
    //Option 3: Enables the User to exit the application.
    // A "Thank You" prompt is displayed to the user. 

                case "3":
                    JOptionPane.showMessageDialog(null, "Thank You for using QuickChat");
                    exit = true;
                    break;
                    
    // Handles the invalid Menu selection.
    // Prompts the User to enter a valid number from the options.

                default:
                    JOptionPane.showMessageDialog(null, "Please Select an Option");
            }
        }
    }
}
