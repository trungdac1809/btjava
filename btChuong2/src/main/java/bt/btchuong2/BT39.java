package bt.btchuong2;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BT39 extends JFrame {

    public BT39() {
        setTitle("Key Listener");

        setSize(300, 200);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));

        JTextField textField = new JTextField(15);

        JLabel label = new JLabel("You typed: ");

        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                char key = e.getKeyChar();

                if (!Character.isISOControl(key)) {
                    label.setText("You typed: " + key);
                }
            }
        });

        add(textField);
        add(label);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT39 frame = new BT39();
        frame.setVisible(true);
    }
}