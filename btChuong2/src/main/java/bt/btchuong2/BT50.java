package bt.btchuong2;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT50 extends JFrame {

    private int count = 0;

    public BT50() {
        setTitle("Multi Event");

        setSize(400, 300);

        setLayout(new FlowLayout(
                FlowLayout.CENTER,
                10,
                60
        ));

        JButton button = new JButton("Multi-Event");

        JLabel countLabel = new JLabel("Count: 0");

        JLabel coordinateLabel =
                new JLabel("Mouse: (0, 0)");


        button.addActionListener(e -> {

            count++;

            countLabel.setText(
                    "Count: " + count
            );
        });

        button.addMouseListener(
                new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();

                coordinateLabel.setText(
                        "Mouse: (" + x + ", " + y + ")"
                );
            }
        });

        add(button);
        add(countLabel);
        add(coordinateLabel);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT50 frame = new BT50();
        frame.setVisible(true);
    }
}