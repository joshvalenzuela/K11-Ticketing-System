/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package k11finalsplf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Josh
 */
public class adminCore {
    public static double moviePrice1;
    public static double moviePrice2;
    public static double moviePrice3;
    public static double popcornPrice;
    public static double hotdogPrice;
    public static double cokePrice;
    public static String[] emptySeatArray = new String[100];
    
    public void adminCoreStart() {
        try {
            for (int i = 0; i < emptySeatArray.length; i++) {
                emptySeatArray[i] = "A" + (1 + i);  
            }
            
            BufferedReader reader = new BufferedReader(new FileReader("prices.txt"));
            
            moviePrice1 = Double.parseDouble(reader.readLine());
            moviePrice2 = Double.parseDouble(reader.readLine());
            moviePrice3 = Double.parseDouble(reader.readLine());
            popcornPrice = Double.parseDouble(reader.readLine());
            hotdogPrice = Double.parseDouble(reader.readLine());
            cokePrice = Double.parseDouble(reader.readLine());
            
            reader.close();
            System.out.println(moviePrice1 + "" + cokePrice);
        } catch (IOException e) {
            System.out.println("Price file not found!");
            e.printStackTrace();
        }
    }
    public void saveToPriceFile() {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("prices.txt", false));
            writer.write(Double.toString(moviePrice1));
            writer.newLine();
            writer.write(Double.toString(moviePrice2));
            writer.newLine();
            writer.write(Double.toString(moviePrice3));
            writer.newLine();
            writer.write(Double.toString(popcornPrice));
            writer.newLine();
            writer.write(Double.toString(hotdogPrice));
            writer.newLine();
            writer.write(Double.toString(cokePrice));
            writer.newLine();
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void resetSeatFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            for (String s : emptySeatArray) {
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
