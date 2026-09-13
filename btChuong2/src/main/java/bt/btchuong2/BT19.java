package bt.btchuong2;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BT19 extends JFrame {

    public BT19() {
        // Đặt tiêu đề cửa sổ
        setTitle("BoxLayout Demo");

        // Đặt kích thước JFrame 400x300
        setSize(400, 300);

        // ==============================
        // TẠO PANEL CHÍNH
        // ==============================

        JPanel mainPanel = new JPanel();

        // BoxLayout dọc cho JPanel chính
        mainPanel.setLayout(
                new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );

        // ==============================
        // PANEL CON 1
        // ==============================

        JPanel panel1 = new JPanel();

        // BoxLayout ngang cho panel con 1
        panel1.setLayout(
                new BoxLayout(panel1, BoxLayout.X_AXIS)
        );

        // Tạo 2 JLabel
        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");

        // Tạo JButton
        JButton button1 = new JButton("Button 1");

        // Thêm 2 JLabel và 1 JButton vào panel con 1
        panel1.add(label1);
        panel1.add(Box.createHorizontalStrut(20));
        panel1.add(label2);
        panel1.add(Box.createHorizontalStrut(20));
        panel1.add(button1);

        // ==============================
        // PANEL CON 2
        // ==============================

        JPanel panel2 = new JPanel();

        // BoxLayout ngang cho panel con 2
        panel2.setLayout(
                new BoxLayout(panel2, BoxLayout.X_AXIS)
        );

        // Tạo 2 JLabel
        JLabel label3 = new JLabel("Label 3");
        JLabel label4 = new JLabel("Label 4");

        // Tạo JButton
        JButton button2 = new JButton("Button 2");

        // Thêm 2 JLabel và 1 JButton vào panel con 2
        panel2.add(label3);
        panel2.add(Box.createHorizontalStrut(20));
        panel2.add(label4);
        panel2.add(Box.createHorizontalStrut(20));
        panel2.add(button2);

        // ==============================
        // THÊM PANEL CON VÀO PANEL CHÍNH
        // ==============================

        mainPanel.add(panel1);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(panel2);

        // ==============================
        // THÊM PANEL CHÍNH VÀO JFrame
        // ==============================

        add(mainPanel);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT19 frame = new BT19();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}