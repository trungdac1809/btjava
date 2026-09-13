package bt.btchuong2;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT37 extends JFrame {

    public BT37() {
        setTitle("Mouse Coordinates");

        setSize(400, 300);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 100));

        JLabel label = new JLabel("Mouse at: (0, 0)");

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                label.setText("Mouse at: (" + x + ", " + y + ")");
            }
        });

        add(label);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT37 frame = new BT37();
        frame.setVisible(true);
    }
}