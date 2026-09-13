package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT40 extends JFrame {

    private int count = 0;

    public BT40() {
        setTitle("Button Counter");

        setSize(300, 200);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 60));

        JButton clickButton = new JButton("Click Me");

        JLabel countLabel = new JLabel("Count: 0");

        clickButton.addActionListener(e -> {

            count++;

            countLabel.setText("Count: " + count);
        });

        add(clickButton);
        add(countLabel);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT40 frame = new BT40();
        frame.setVisible(true);
    }
}