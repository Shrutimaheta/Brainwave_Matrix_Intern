/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brainwave_matrix_intern;

import java.util.ArrayList;

public class Bank {
    public static double balance = 0.0;
    
    public static ArrayList<String> history = new ArrayList<>();

    public static void recordTransaction(String type, double amount) {
        String entry = type + ": Rs. " + String.format("%.2f", amount);
        history.add(entry);
    }
}
