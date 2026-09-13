package bt.btchuong2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BT35 extends JFrame {

    public BT35() {
        setTitle("Multiple Layout Manager");

        setSize(500, 400);

        setLayout(new BorderLayout());

   
        JPanel centerPanel = new JPanel();

     
        centerPanel.setLayout(new GridLayout(3, 3, 5, 5));


        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("Button " + i);

            centerPanel.add(button);
        }

        JButton resetButton = new JButton("Reset");

        resetButton.addActionListener(e -> {
            System.out.println("Reset");
        });

        add(centerPanel, BorderLayout.CENTER);

        add(resetButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT35 frame = new BT35();
        frame.setVisible(true);
    }
}