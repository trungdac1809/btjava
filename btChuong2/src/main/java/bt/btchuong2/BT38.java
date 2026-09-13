package bt.btchuong2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT38 extends JFrame {

    public BT38() {
        setTitle("Random Color");

        setSize(400, 400);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 180));

        JLabel colorLabel = new JLabel("RGB: (255, 255, 255)");

        Random random = new Random();

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    int red = random.nextInt(256);
                    int green = random.nextInt(256);
                    int blue = random.nextInt(256);

                    Color randomColor = new Color(
                            red,
                            green,
                            blue
                    );

                    getContentPane().setBackground(randomColor);

                    colorLabel.setText(
                            "RGB: (" + red + ", "
                            + green + ", "
                            + blue + ")"
                    );
                }
            }
        });

        add(colorLabel);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT38 frame = new BT38();
        frame.setVisible(true);
    }
}