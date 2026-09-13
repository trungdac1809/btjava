package bt.btchuong2;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BT03 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exit Application");

        frame.setSize(300, 200);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnExit = new JButton("Exit");

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        frame.add(btnExit);

        frame.setVisible(true);
    }
}