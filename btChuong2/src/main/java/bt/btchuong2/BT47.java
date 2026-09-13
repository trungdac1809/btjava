package bt.btchuong2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT47 extends JFrame {

    public BT47() {
        setTitle("Follow Mouse");

        setSize(500, 400);

        setLayout(null);

        JLabel label = new JLabel("Follow Me");

        label.setSize(80, 30);

        label.setLocation(200, 150);

        add(label);

        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();

                label.setLocation(
                        x - label.getWidth() / 2,
                        y - label.getHeight() / 2
                );
            }
        });

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT47 frame = new BT47();
        frame.setVisible(true);
    }
}