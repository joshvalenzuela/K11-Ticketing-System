package k11finalsplf;
import java.io.*;
import java.util.Scanner;

public class userCore {
    public static Scanner sc = new Scanner(System.in);
    public static String[] sectionA = new String[10];
    public String[] readSeatFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int readcounter = 0;
            sectionA[readcounter++] = line;
            while ((line = reader.readLine()) != null) {
                sectionA[readcounter++] = line;
            }
        } catch (IOException e) {
            System.out.println("Error, Please contact Program Admin. : " + e);
            System.exit(0);
        }
        return sectionA;
    }

    public void savetoFile(String[] arr) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt", false));
        for (String s : arr) {
            writer.write(s);
            writer.newLine();
        }
        writer.flush();
        System.out.println("Successfully saved.");
    }

}
