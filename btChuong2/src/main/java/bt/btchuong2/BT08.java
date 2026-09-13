package bt.btchuong2;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT08 extends JFrame {

    public BT08() {
        setTitle("Colored Background");

        setSize(400, 400);

        JLabel label = new JLabel("Colored Background");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.setVerticalAlignment(SwingConstants.CENTER);

        getContentPane().setBackground(Color.GREEN);

        add(label);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT08 frame = new BT08();
        frame.setVisible(true);
    }
}