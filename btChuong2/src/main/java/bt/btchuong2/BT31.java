package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class BT31 extends JFrame {

    public BT31() {
        setTitle("JSplitPane Demo");

        setSize(600, 400);

        DefaultListModel<String> model = new DefaultListModel<>();

        model.addElement("Java");
        model.addElement("C++");
        model.addElement("Python");
        model.addElement("JavaScript");
        model.addElement("C#");

        JList<String> list = new JList<>(model);

        JScrollPane listScrollPane = new JScrollPane(list);

        JTextArea textArea = new JTextArea();

        JScrollPane textScrollPane = new JScrollPane(textArea);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                listScrollPane,
                textScrollPane
        );

        splitPane.setDividerLocation(200);

        add(splitPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT31 frame = new BT31();
        frame.setVisible(true);
    }
}