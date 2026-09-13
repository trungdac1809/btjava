package bt.btchuong2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT06 extends JFrame {

    public BT06() {
        setTitle("Custom Icon Window");

        setSize(500, 400);

        ImageIcon icon = new ImageIcon(
                "src/main/java/anh/logo.png"
        );

        setIconImage(icon.getImage());

        JLabel label = new JLabel("Custom Icon Window");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.setVerticalAlignment(SwingConstants.CENTER);

        add(label);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT06 frame = new BT06();
        frame.setVisible(true);
    }
}