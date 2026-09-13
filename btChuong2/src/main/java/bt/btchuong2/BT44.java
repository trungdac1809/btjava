package bt.btchuong2;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BT44 extends JFrame {

    public BT44() {
        setTitle("Font Size");

        setSize(400, 200);

        setLayout(new FlowLayout(
                FlowLayout.CENTER,
                20,
                40
        ));

        JLabel label = new JLabel("Sample Text");

        JSlider slider = new JSlider(10, 50, 20);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.addChangeListener((ChangeEvent e) -> {
            int fontSize = slider.getValue();
            
            label.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            fontSize
                    )
            );
        });

        add(label);
        add(slider);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT44 frame = new BT44();
        frame.setVisible(true);
    }
}