package bt.btchuong2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT07 extends JFrame {

    public BT07() {
        setTitle("Resizable Window");

        setSize(400, 300);

        setMinimumSize(new java.awt.Dimension(200, 150));

        setMaximumSize(new java.awt.Dimension(800, 600));

        JLabel label = new JLabel("Resizable Window");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.setVerticalAlignment(SwingConstants.CENTER);

        add(label);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT07 frame = new BT07();
        frame.setVisible(true);
    }
}