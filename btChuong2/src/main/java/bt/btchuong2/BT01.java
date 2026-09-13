package bt.btchuong2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT01 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("My First Swing App");

        frame.setSize(400, 300);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(label);

        frame.setVisible(true);
    }
}