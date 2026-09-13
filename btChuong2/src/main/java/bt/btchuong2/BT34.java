package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class BT34 extends JFrame {

    public BT34() {
        setTitle("Spinner Demo");

        setSize(300, 200);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));

        JSpinner spinner = new JSpinner(
                new SpinnerNumberModel(1, 1, 100, 1)
        );

        JLabel resultLabel = new JLabel(
                "Giá trị: " + spinner.getValue()
        );

        spinner.addChangeListener(e -> {
            resultLabel.setText(
                    "Giá trị: " + spinner.getValue()
            );
        });

        add(spinner);
        add(resultLabel);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT34 frame = new BT34();
        frame.setVisible(true);
    }
}