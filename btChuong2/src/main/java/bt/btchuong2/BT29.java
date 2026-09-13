package bt.btchuong2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BT29 extends JFrame {

    public BT29() {
        setTitle("CardLayout Demo");

        setSize(400, 300);

        CardLayout cardLayout = new CardLayout();

        JPanel cardPanel = new JPanel(cardLayout);

        JPanel card1 = new JPanel();

        JLabel pageLabel = new JLabel("Page 1");
        pageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pageLabel.setVerticalAlignment(SwingConstants.CENTER);

        card1.add(pageLabel);

        JPanel card2 = new JPanel();

        JButton clickButton = new JButton("Click");

        card2.add(clickButton);

        cardPanel.add(card1, "Card 1");
        cardPanel.add(card2, "Card 2");

        JButton switchButton = new JButton("Switch");

        switchButton.addActionListener(e -> {
            cardLayout.next(cardPanel);
        });

        add(cardPanel, BorderLayout.CENTER);
        add(switchButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT29 frame = new BT29();
        frame.setVisible(true);
    }
}