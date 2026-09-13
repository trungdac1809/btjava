package bt.btchuong2;

import java.awt.FlowLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT45 extends JFrame {

    public BT45() {
        setTitle("Show Image");

        setSize(400, 400);

        setLayout(new FlowLayout(
                FlowLayout.CENTER,
                10,
                30
        ));

        JCheckBox checkBox = new JCheckBox("Show Image");

        JLabel imageLabel = new JLabel();

        URL imageURL = getClass().getResource("/logo.png");

        if (imageURL != null) {

            ImageIcon imageIcon = new ImageIcon(imageURL);

            imageLabel.setIcon(imageIcon);

        } else {

            imageLabel.setText("Image not found");
        }

        imageLabel.setVisible(false);

        checkBox.addActionListener(e -> {

            imageLabel.setVisible(
                    checkBox.isSelected()
            );
        });

        add(checkBox);
        add(imageLabel);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT45 frame = new BT45();
        frame.setVisible(true);
    }
}