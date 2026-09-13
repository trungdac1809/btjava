package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT09 extends JFrame {

    public BT09() {
        setTitle("Main Window");

        setSize(500, 400);

        JButton button = new JButton("Open Dialog");

        add(button, BorderLayout.CENTER);

        button.addActionListener(e -> openDialog());

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void openDialog() {

        JDialog dialog = new JDialog(this, "Dialog", true);

        dialog.setSize(200, 150);

        JLabel label = new JLabel("This is a dialog");

        label.setHorizontalAlignment(SwingConstants.CENTER);

        label.setVerticalAlignment(SwingConstants.CENTER);

        dialog.add(label);

        dialog.setLocationRelativeTo(this);

        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        BT09 frame = new BT09();

        frame.setVisible(true);
    }
}