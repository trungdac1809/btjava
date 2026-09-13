package bt.btchuong2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class BT33 extends JFrame {

    public BT33() {
        setTitle("Form Demo");

        setSize(400, 300);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.anchor = GridBagConstraints.WEST;


        JLabel nameLabel = new JLabel("Name");

        gbc.gridx = 0;
        gbc.gridy = 0;

        add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        add(nameField, gbc);

        JLabel ageLabel = new JLabel("Age");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        add(ageLabel, gbc);

        JSpinner ageSpinner = new JSpinner(
                new SpinnerNumberModel(18, 1, 100, 1)
        );

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        add(ageSpinner, gbc);

        JButton submitButton = new JButton("Submit");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;

        add(submitButton, gbc);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT33 frame = new BT33();
        frame.setVisible(true);
    }
}