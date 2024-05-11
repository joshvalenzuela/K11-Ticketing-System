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
    JRadioButton[] buttons;
    ButtonGroup bg = new ButtonGroup();
    boolean confirmBool;
    static userCore obj = new userCore();

    public guiTest() {
        frame = new JFrame();
        panel = new JPanel();

        buttons = new JRadioButton[6];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JRadioButton((i + 1) + "A");
            bg.add(buttons[i]);
            panel.add(buttons[i]);

        }
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(250, 500, 250, 500));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(confirm);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Customer Gui");
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
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                if (Objects.equals(sectionA[i], ((i + 1) + "A"))) {
                    confirmBool = (0 == (JOptionPane.showConfirmDialog(frame, "This seat is free. Would you like to take it?")));
                    if (confirmBool) {
                        userName = JOptionPane.showInputDialog(frame, "Please state your name: ");
                        sectionA[i] = "1A-" + userName;
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
}
