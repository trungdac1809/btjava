package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BT42 extends JFrame {

    public BT42() {
        setTitle("Color Selection");

        setSize(300, 200);

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 70));

        String[] colors = {
            "Red",
            "Blue",
            "Green",
            "Yellow",
            "Orange"
        };

        JComboBox<String> colorComboBox = new JComboBox<>(colors);

        colorComboBox.addActionListener(e -> {

            String selectedColor =
                    (String) colorComboBox.getSelectedItem();

            JOptionPane.showMessageDialog(
                    this,
                    "You selected: " + selectedColor,
                    "Selected Color",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        add(colorComboBox);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT42 frame = new BT42();
        frame.setVisible(true);
    }
}