package bt.btchuong2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT16 extends JFrame {

    public BT16() {
        // Đặt tiêu đề cửa sổ
        setTitle("BorderLayout Demo");

        // Đặt kích thước JFrame 500x400
        setSize(500, 400);

        // Sử dụng BorderLayout
        setLayout(new BorderLayout());

        // Tạo JLabel cho vùng NORTH
        JLabel northLabel = new JLabel("North");
        northLabel.setHorizontalAlignment(SwingConstants.CENTER);
        northLabel.setOpaque(true);
        northLabel.setBackground(Color.RED);

        // Tạo JLabel cho vùng SOUTH
        JLabel southLabel = new JLabel("South");
        southLabel.setHorizontalAlignment(SwingConstants.CENTER);
        southLabel.setOpaque(true);
        southLabel.setBackground(Color.BLUE);

        // Tạo JLabel cho vùng EAST
        JLabel eastLabel = new JLabel("East");
        eastLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eastLabel.setOpaque(true);
        eastLabel.setBackground(Color.YELLOW);

        // Tạo JLabel cho vùng WEST
        JLabel westLabel = new JLabel("West");
        westLabel.setHorizontalAlignment(SwingConstants.CENTER);
        westLabel.setOpaque(true);
        westLabel.setBackground(Color.GREEN);

        // Tạo JLabel cho vùng CENTER
        JLabel centerLabel = new JLabel("Center");
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerLabel.setOpaque(true);
        centerLabel.setBackground(Color.ORANGE);

        // Thêm 5 JLabel vào 5 vùng của BorderLayout
        add(northLabel, BorderLayout.NORTH);
        add(southLabel, BorderLayout.SOUTH);
        add(eastLabel, BorderLayout.EAST);
        add(westLabel, BorderLayout.WEST);
        add(centerLabel, BorderLayout.CENTER);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT16 frame = new BT16();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}