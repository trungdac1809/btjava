package bt.btchuong2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class BT49 extends JFrame {

    public BT49() {
        setTitle("Text Color");

        setSize(300, 200);

        setLayout(new FlowLayout(
                FlowLayout.CENTER,
                10,
                50
        ));


        JLabel label = new JLabel("Sample");

        JRadioButton redButton = new JRadioButton("Red");
        JRadioButton blueButton = new JRadioButton("Blue");
        JRadioButton greenButton = new JRadioButton("Green");


        ButtonGroup group = new ButtonGroup();

        group.add(redButton);
        group.add(blueButton);
        group.add(greenButton);

  
        ItemListener colorListener = e -> {

            if (e.getStateChange()
                    == ItemEvent.SELECTED) {

                if (redButton.isSelected()) {
                    label.setForeground(Color.RED);

                } else if (blueButton.isSelected()) {
                    label.setForeground(Color.BLUE);

                } else if (greenButton.isSelected()) {
                    label.setForeground(Color.GREEN);
                }
            }
        };

   
        redButton.addItemListener(colorListener);
        blueButton.addItemListener(colorListener);
        greenButton.addItemListener(colorListener);

        add(redButton);
        add(blueButton);
        add(greenButton);
        add(label);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT49 frame = new BT49();
        frame.setVisible(true);
    }
}