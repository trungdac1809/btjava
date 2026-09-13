package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BT15 extends JFrame {

    public BT15() {
        // Đặt tiêu đề cửa sổ
        setTitle("Exit Demo");

        // Đặt kích thước JFrame 400x300
        setSize(400, 300);

        // Tạo JButton Exit
        JButton exitButton = new JButton("Exit");

        // Thêm nút Exit vào giữa cửa sổ
        add(exitButton, BorderLayout.CENTER);

        // Khi nhấn Exit thì thoát chương trình
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Vô hiệu hóa nút đóng X
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT15 frame = new BT15();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}