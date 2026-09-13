package bt.btchuong2;

import java.awt.FlowLayout;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT41 extends JFrame {

    public BT41() {
        setTitle("Dialog Demo");

        setSize(400, 300);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 120));

        JButton openButton = new JButton("Open Dialog");

        openButton.addActionListener(e -> {

            JDialog dialog = new JDialog(
                    this,
                    "Dialog",
                    true
            );

            dialog.setSize(200, 150);

            JLabel label = new JLabel("Dialog Opened");

            dialog.add(label);

            dialog.setLocationRelativeTo(this);

            dialog.setVisible(true);
        });

        add(openButton);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT41 frame = new BT41();
        frame.setVisible(true);
    }
}
