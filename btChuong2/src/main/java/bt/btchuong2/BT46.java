package bt.btchuong2;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class BT46 extends JFrame {

    public BT46() {
        setTitle("JList Selection");

        setSize(300, 400);

        String[] items = {
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10"
        };

        JList<String> list = new JList<>(items);

        JScrollPane scrollPane = new JScrollPane(list);

        list.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    String selectedItem = list.getSelectedValue();

                    if (selectedItem != null) {
                        JOptionPane.showMessageDialog(
                                BT46.this,
                                "Bạn đã chọn: " + selectedItem,
                                "Selected Item",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT46 frame = new BT46();
        frame.setVisible(true);
    }
}