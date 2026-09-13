package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT36 extends JFrame {

    public BT36() {
        setTitle("Change Text");

        setSize(300, 200);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 60));

        JLabel label = new JLabel("Original Text");

        JButton changeButton = new JButton("Change");

        changeButton.addActionListener(e -> {
            label.setText("Text Changed");
        });

        add(label);
        add(changeButton);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT36 frame = new BT36();
        frame.setVisible(true);
    }
}