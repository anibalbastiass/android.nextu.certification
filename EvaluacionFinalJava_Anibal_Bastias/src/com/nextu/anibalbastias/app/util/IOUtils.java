package com.nextu.anibalbastias.app.util;

import java.util.Scanner;

/**
 *
 * @author anibalbastias
 */
public class IOUtils {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void print(String message) {
        System.out.println(message);
    }
    
    public static void scanInt(
            int countOptions, 
            ScanListener callback, 
            ScanResourceListener resourceCallback) {
        int option;
        
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.nextLine();
            }
            option = scanner.nextInt();
            
            if (callback != null) {
                callback.onSelectedItem(option);
            } else {
                if (resourceCallback != null) {
                    resourceCallback.onSelectedResourceItem(option);
                }
            }
        } while (option < 1 && option > countOptions);
    }
    
    public static int scanIntTyped() {
        int option = -1;
        
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.nextLine();
            }
            option = scanner.nextInt();
        } while (option < 1);
        
        return option;
    }
    
    public static String scanContentTyped() {
        String contentTyped = "";
        
        do {
            while (!scanner.hasNext()) {
                System.out.println("Type data please!");
                scanner.nextLine();
            }
            contentTyped = scanner.nextLine();
        } while (contentTyped.isEmpty());
        
        return contentTyped;
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    public interface ScanListener {
        public void onSelectedItem(int option);
    }
    
    public interface ScanResourceListener {
        public void onSelectedResourceItem(int option);
    }
}
