package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class BT30 extends JFrame {

    public BT30() {
        setTitle("ToolBar Demo");

        setSize(500, 400);

        JToolBar toolBar = new JToolBar();

        JButton newButton = new JButton("New");
        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Open");

        toolBar.add(newButton);
        toolBar.add(saveButton);
        toolBar.add(openButton);

        newButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Bạn đã nhấn New",
                    "New",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        saveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Bạn đã nhấn Save",
                    "Save",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        openButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Bạn đã nhấn Open",
                    "Open",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        add(toolBar, BorderLayout.NORTH);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT30 frame = new BT30();
        frame.setVisible(true);
    }
}