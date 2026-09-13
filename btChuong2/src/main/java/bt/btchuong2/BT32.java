package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BT32 extends JFrame {

    public BT32() {
        setTitle("Text Area Demo");
        setSize(400, 300);

        JTextArea textArea = new JTextArea();

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton clearButton = new JButton("Clear");

        clearButton.addActionListener(e -> {
            textArea.setText("");
        });

        add(scrollPane, BorderLayout.CENTER);
        add(clearButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT32 frame = new BT32();
        frame.setVisible(true);
    }
}