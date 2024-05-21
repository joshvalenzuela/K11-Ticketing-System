package k11finalsplf;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class userCore {
    public static Scanner sc = new Scanner(System.in);
    public static String[] sectionA = new String[100];
    public static String[] sectionB = new String[100];
    public static String[] sectionC = new String[100];
    public static ArrayList<String> itemCart = new ArrayList<>();
    public static double moviePrice1 = 150;
    public static double moviePrice2 = 200;
    public static double moviePrice3 = 250;
    public static double popcornPrice = 50;
    public static double hotdogPrice = 45;
    public static double cokePrice = 25;
    
    
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
            System.out.println("Seat files is missing! Contact admin.");
            e.printStackTrace();
        }
    }
    
    public String[] readSeatFile(String fileName) {
        if (fileName.equals("godfatherSeats.txt")) {
            return sectionA;
        } else if (fileName.equals("movie2.txt")) {
            return sectionB;
        } else if (fileName.equals("movie3.txt")){
            return sectionC;
        } else {
            return sectionA;
        }
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
    
    public void foodAddtoCart(String foodName) { 
        itemCart.add(foodName);
    }
    
    public void saveReceipt(ArrayList<String> cart, double total, double change, double userCash) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("receipts.txt", true));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date(); 
            writer.write("// Start of Receipt //");
            writer.newLine();

            for (String i : cart) {
                if (i.startsWith("Godfather")) {
                    writer.write(i + " P" + moviePrice1);
                } else if (i.startsWith("Movie 2")) {
                    writer.write(i + " P" + moviePrice2);
                } else if (i.startsWith("Movie 3")) {
                    writer.write(i + " P" + moviePrice3);
                } else if (i.startsWith("Popcorn")) {
                    writer.write(i + " P" + popcornPrice);
                } else if (i.startsWith("Hotdog")) {
                    writer.write(i + " P" + hotdogPrice );
                } else if (i.startsWith("Coke")) {
                    writer.write(i + " P" + cokePrice );
                }  
                writer.newLine();
            }

            writer.write(formatter.format(date));
            writer.newLine();
            writer.write("Cash given: " + userCash);
            writer.newLine();
            writer.write("Total: " + total);
            writer.newLine();
            writer.write("Change: " + change);
            writer.newLine();
            writer.write("// End of Receipt //");
            writer.newLine();
            writer.newLine();

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
