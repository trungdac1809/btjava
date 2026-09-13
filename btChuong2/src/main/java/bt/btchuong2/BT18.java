package bt.btchuong2;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BT18 extends JFrame {

    public BT18() {
        // Đặt tiêu đề cửa sổ
        setTitle("Chess Board");

        // Đặt kích thước JFrame 400x400
        setSize(400, 400);

        // Sử dụng GridLayout 8 hàng, 8 cột
        setLayout(new GridLayout(8, 8));

        // Tạo 64 ô cờ
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                // Tạo một JPanel đại diện cho một ô cờ
                JPanel cell = new JPanel();

                // Tô màu đen và trắng xen kẽ
                if ((row + col) % 2 == 0) {
                    cell.setBackground(Color.WHITE);
                } else {
                    cell.setBackground(Color.BLACK);
                }

                // Thêm ô cờ vào JFrame
                add(cell);
            }
        }

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT18 frame = new BT18();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}