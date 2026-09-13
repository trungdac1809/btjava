package bt.btchuong2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BT02 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Welcome");

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JOptionPane.showMessageDialog(
                frame,
                "Welcome to Java Swing",
                "Welcome",
                JOptionPane.INFORMATION_MESSAGE
        );

     
        frame.dispose();
    }
}