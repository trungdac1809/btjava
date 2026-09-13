package bt.btchuong2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class BT04 extends JFrame {

    public BT04() {
        setTitle("Image Viewer");

        ImageIcon imageIcon = new ImageIcon(
                "src/main/java/anh/anh.png"
        );

        JLabel imageLabel = new JLabel(imageIcon);

        add(imageLabel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BT04 frame = new BT04();
            frame.setVisible(true);
        });
    }
}