import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class guiTest extends userCore implements ActionListener  {
    static String[] sectionA;
    String userName;
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton confirm;
    JRadioButton button;
    JRadioButton button2;
    JRadioButton button3;
    JRadioButton button4;
    JRadioButton button5;
    JRadioButton button6;
    ButtonGroup bg = new ButtonGroup();
    boolean confirmBool;
    static userCore obj = new userCore();
    public guiTest() {
        frame = new JFrame();
        panel = new JPanel();

        button = new JRadioButton("1A");
        button2 = new JRadioButton("2A");
        button3 = new JRadioButton("3A");
        button4 = new JRadioButton("4A");
        button5 = new JRadioButton("5A");
        button6 = new JRadioButton("6A");
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        bg.add(button);
        bg.add(button2);
        bg.add(button3);
        bg.add(button4);
        bg.add(button5);
        bg.add(button6);

        panel.setBorder(BorderFactory.createEmptyBorder(250, 500, 250, 500));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(confirm);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test Java GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        sectionA = obj.readFile();
        System.out.println(Arrays.toString(sectionA));


        new guiTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.isSelected()) {
            if (Objects.equals(sectionA[0], "1A")) {
                confirmBool = (0 == (JOptionPane.showConfirmDialog(frame, "This seat is free. Would you like to take it?")));
                if (confirmBool) {
                    userName = JOptionPane.showInputDialog(frame, "Please state your name: ");
                    sectionA[0] = "1A" + "-" + userName;
                    confirmBool = false;
                    try {
                        obj.savetoFile(sectionA);
                    } catch (IOException e2) {
                        System.out.println("Error: " + e2);
                        System.exit(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "This seat is already taken. Please select a different seat.");
            }
        } else if (button2.isSelected()) {
            if (Objects.equals(sectionA[1], "2A")) {
                confirmBool = (0 == (JOptionPane.showConfirmDialog(frame, "This seat is free. Would you like to take it?")));
                if (confirmBool) {
                    userName = JOptionPane.showInputDialog(frame, "Please state your name: ");
                    sectionA[1] = "2A" + "-" + userName;
                    confirmBool = false;
                    try {
                        obj.savetoFile(sectionA);
                    } catch (IOException e2) {
                        System.out.println("Error: " + e2);
                        System.exit(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "This seat is already taken. Please select a different seat.");
            }
        } else if (button3.isSelected()) {
            if (Objects.equals(sectionA[2], "3A")) {
                confirmBool = (0 == (JOptionPane.showConfirmDialog(frame, "This seat is free. Would you like to take it?")));
                if (confirmBool) {
                    userName = JOptionPane.showInputDialog(frame, "Please state your name: ");
                    sectionA[2] = "3A" + "-" + userName;
                    confirmBool = false;
                    try {
                        obj.savetoFile(sectionA);
                    } catch (IOException e2) {
                        System.out.println("Error: " + e2);
                        System.exit(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "This seat is already taken. Please select a different seat.");
            }
        } else if (button4.isSelected()) {
            if (Objects.equals(sectionA[3], "4A")) {
                confirmBool = (0 == (JOptionPane.showConfirmDialog(frame, "This seat is free. Would you like to take it?")));
                if (confirmBool) {
                    userName = JOptionPane.showInputDialog(frame, "Please state your name: ");
                    sectionA[3] = "4A" + "-" + userName;
                    confirmBool = false;
                    try {
                        obj.savetoFile(sectionA);
                    } catch (IOException e2) {
                        System.out.println("Error: " + e2);
                        System.exit(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "This seat is already taken. Please select a different seat.");
            }
        } else if (button5.isSelected()) {
            if (Objects.equals(sectionA[4], "5A")) {
                confirmBool = (0 == (JOptionPane.showConfirmDialog(frame, "This seat is free. Would you like to take it?")));
                if (confirmBool) {
                    userName = JOptionPane.showInputDialog(frame, "Please state your name: ");
                    sectionA[4] = "5A" + "-" + userName;
                    confirmBool = false;
                    try {
                        obj.savetoFile(sectionA);
                    } catch (IOException e2) {
                        System.out.println("Error: " + e2);
                        System.exit(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "This seat is already taken. Please select a different seat.");
            }
        } else if (button6.isSelected()) {
            if (Objects.equals(sectionA[5], "6A")) {
                confirmBool = (0 == (JOptionPane.showConfirmDialog(frame, "This seat is free. Would you like to take it?")));
                if (confirmBool) {
                    userName = JOptionPane.showInputDialog(frame, "Please state your name: ");
                    sectionA[5] = "6A" + "-" + userName;
                    confirmBool = false;
                    try {
                        obj.savetoFile(sectionA);
                    } catch (IOException e2) {
                        System.out.println("Error: " + e2);
                        System.exit(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "This seat is already taken. Please select a different seat.");
            }
        }

    }
}
