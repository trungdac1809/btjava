package bt.btchuong2;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BT43 extends JFrame {

    public BT43() {
        setTitle("Close Confirmation");

        setSize(400, 300);

        setLayout(new FlowLayout());

        setDefaultCloseOperation(
                JFrame.DO_NOTHING_ON_CLOSE
        );

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                int result = JOptionPane.showConfirmDialog(
                        BT43.this,
                        "Are you sure?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        BT43 frame = new BT43();
        frame.setVisible(true);
    }
}