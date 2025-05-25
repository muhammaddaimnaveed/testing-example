package com.mycompany.prog5121assignment2;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Message {
    
    // Generate a unique 10-digit ID for each message.
    
    public static String checkMessageID() {
        long number = (long)(Math.random() * 10000000000L);
        return String.format("%010d", number);
    }

    // Validates if the Recipient Phone Number is in the correct format.
    // Cellphone Number must contain the international country code.
    // Cellphone number must be ten numbers long.
    
    public static boolean checkRecipientCell(String recipientCell) {
        return recipientCell != null && recipientCell.matches("^\\+27[678][0-9]{8}$");
    }

    // Checks if the message is non-null.
    // Ensure that the message does not exceed 250 characters. 
    
    public static boolean isValidMessage(String message) {
        return message != null && message.length() <= 250;
    }

    /* Generate a unique Message Hash that consists of the first two numbers of the message Id, a colon,
       the number of the message, and the first and last words of the message.*/
    
    public static String createMessageHash(String messageId, int messageNumber, String message) {
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        String messageHash = messageId.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
        return messageHash.toUpperCase();
    }

    // Converts a numeric string input into an interger.
    // Determines how many messages a User wants to send.
    
    public static int getNumberOfMessages(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    // Returns the total number of messages sent.
    
    public static int returnTotalMessages(ArrayList<Map<String, String>> messages) {
        return messages.size();
    }

    // Handles the Users post-send choice for all the messages.
    
    public static void sentMessage(int choice, ArrayList<Map<String, String>> messageList, ArrayList<Map<String, String>> allSentMessages) {
        switch (choice) {

    // Option 1: Send the messages.
            
            case 0: 
                allSentMessages.addAll(messageList);
                displayMessageSummary("Messages sent:\n\n", messageList);
                break;

    // Option 2: Disregard the messages.
                
            case 1: 
                JOptionPane.showMessageDialog(null, "Messages discarded.");
                break;

    // Option 3: Store the messages into a JSON File.
                
            case 2: 
                storeMessage(messageList);
                break;

    // Handles the invalid Menu selection.
                
            default:
                JOptionPane.showMessageDialog(null, "No option selected.");
        }
    }

    // Handles the invalid Menu selection.
    // Displays all the sent messages in the "View Messages" Option in the ChatApps Main Menu. 
    // Prompts the User when they send the messages.
    
    public static void viewAllMessages(ArrayList<Map<String, String>> allMessages) {
        if (allMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent yet.");      
        } else {
            displayMessageSummary("All messages sent:\n\n", allMessages);
        }
    }

    // This method formats and display a summary of the messages after the "Send" button is clicked.
    
    private static void displayMessageSummary(String title, ArrayList<Map<String, String>> messages) {
        StringBuilder viewSummary = new StringBuilder(title);
        for (Map<String, String> msg : messages) {
            viewSummary.append("Message ID: ").append(msg.get("messageId")).append("\n");
            viewSummary.append("Message Hash: ").append(msg.get("messageHash")).append("\n");
            viewSummary.append("Recipient: ").append(msg.get("recipient")).append("\n");
            viewSummary.append("Message: ").append(msg.get("message")).append("\n\n");
        }

        // Display total messages sent in the summary.
        
        viewSummary.append("Total messages sent: ").append(returnTotalMessages(messages)).append("\n");
        
        
        
        JOptionPane.showMessageDialog(null, viewSummary.toString());
    }

    // Saves the list of messages into a local JSON File named messages.json.
    // Each message is stored as an object in the JSON array.
    // Uses basic string manipulation to format JSON manually.
    
    public static void storeMessage(ArrayList<Map<String, String>> messages) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        for (int i = 0; i < messages.size(); i++) {
            Map<String, String> msg = messages.get(i);
            jsonBuilder.append("  {\n");
            jsonBuilder.append("    \"recipient\": \"").append(escapeJson(msg.get("recipient"))).append("\",\n");
            jsonBuilder.append("    \"message\": \"").append(escapeJson(msg.get("message"))).append("\",\n");
            jsonBuilder.append("    \"messageId\": \"").append(msg.get("messageId")).append("\",\n");
            jsonBuilder.append("    \"messageHash\": \"").append(msg.get("messageHash")).append("\"\n");
            jsonBuilder.append("  }");
            if (i < messages.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("]");

        try (FileWriter file = new FileWriter("messages.json")) {
            file.write(jsonBuilder.toString());
            file.flush();
            JOptionPane.showMessageDialog(null, "Messages saved to messages.json.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving messages: " + e.getMessage());
        }
    }

    private static String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
