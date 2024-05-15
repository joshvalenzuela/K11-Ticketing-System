package k11finalsplf;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class userCore extends javax.swing.JFrame {
    public static Scanner sc = new Scanner(System.in);
    public static String[] sectionA = new String[100];
    public static String[] sectionB = new String[100];
    public static String[] sectionC = new String[100];
    public static String[] tempSection = new String[100];
    public static ArrayList<String> itemCart = new ArrayList<>();
    
    public void userCoreStart() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("godfatherSeats.txt"));
            String line = reader.readLine();
            int readcounter = 0;
            sectionA[readcounter++] = line;
            while ((line = reader.readLine()) != null) {
                sectionA[readcounter++] = line;
            }
            reader.close();
            
            BufferedReader reader2 = new BufferedReader(new FileReader("movie2.txt"));
            line = reader2.readLine();
            readcounter = 0;
            sectionB[readcounter++] = line;
            while ((line = reader2.readLine()) != null) {
                sectionB[readcounter++] = line;
            }
            reader2.close();
            
            BufferedReader reader3 = new BufferedReader(new FileReader("movie3.txt"));
            line = reader3.readLine();
            readcounter = 0;
            sectionC[readcounter++] = line;
            while ((line = reader3.readLine()) != null) {
                sectionC[readcounter++] = line;
            }
            reader3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String[] readSeatFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int readcounter = 0;

            tempSection[readcounter++] = line;
            while ((line = reader.readLine()) != null) {
                tempSection[readcounter++] = line;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error, Please contact Program Admin. : " + e);
            System.exit(0);
        }
        return tempSection;
    }

    public void savetoFile(String fileName) throws IOException {
        for (String i : itemCart) {
            if (i.startsWith("Godfather")) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("godfatherSeats.txt", false));
                for (String s : sectionA) {
                    writer.write(s);
                    writer.newLine();
                }
                writer.flush();
                writer.close();
            } else if (i.startsWith("Movie 2")) {
                BufferedWriter writer2 = new BufferedWriter(new FileWriter("movie2.txt", false));
                for (String s : sectionB) {
                    writer2.write(s);
                    writer2.newLine();
                }
                writer2.flush();
                writer2.close();
            } else if (i.startsWith("Movie 3")) {
                BufferedWriter writer3 = new BufferedWriter(new FileWriter("movie3.txt", false));
                for (String s : sectionC) {
                    writer3.write(s);
                    writer3.newLine();
                }
                writer3.flush();
                writer3.close();
            }
            
        }
        
        System.out.println("Successfully saved.");
    }
    
    public void movieAddtoCart(int index, String seatNumber, String movieName){
        for (String i : itemCart) {
            if (i.startsWith(movieName + ": A" + (index + 1))) {
                JOptionPane.showMessageDialog(this, "This seat is already in your cart. Please select a different seat."); 

                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new movieSelectionUI().setVisible(true);
                   }
                });
                return;
            }
        }
        if (movieName.equals("Godfather")) {
            sectionA[index] = seatNumber;
        } else if (movieName.equals("Movie 2")) {
            sectionB[index] = seatNumber;
        } else if (movieName.equals("Movie 3")) {
            sectionC[index] = seatNumber;
        }
        itemCart.add(movieName + ": " + seatNumber);
        System.out.println(itemCart);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cartUI().setVisible(true);
            }
        });
    }
}
