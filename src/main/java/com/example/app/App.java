package com.example.app;

import org.apache.commons.lang3.StringUtils;

/**
 * Main application class demonstrating Maven build process.
 */
public class App {
    
    /**
     * Main method - entry point of the application.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello Maven World!");
        
        // Demonstrate using an external dependency
        String message = "  maven tutorial  ";
        String cleanMessage = StringUtils.trim(message);
        String capitalizedMessage = StringUtils.capitalize(cleanMessage);
        
        System.out.println("Original: '" + message + "'");
        System.out.println("Processed: '" + capitalizedMessage + "'");
        
        // Call our utility method
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.add(5, 3);
        System.out.println("5 + 3 = " + result);
    }
}
