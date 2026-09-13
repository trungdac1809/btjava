package bt.btchuong2;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT11 extends JFrame {

    public BT11() {
        // Đặt tiêu đề cửa sổ
        setTitle("System Information");

        // Đặt kích thước JFrame 300x200
        setSize(300, 200);

        // Lấy tên hệ điều hành
        String osName = System.getProperty("os.name");

        // Lấy phiên bản Java
        String javaVersion = System.getProperty("java.version");

        // Tạo JLabel hiển thị hệ điều hành
        JLabel osLabel = new JLabel("Hệ điều hành: " + osName);

        // Tạo JLabel hiển thị phiên bản Java
        JLabel javaLabel = new JLabel("Phiên bản Java: " + javaVersion);

        // Sắp xếp 2 JLabel theo chiều dọc
        setLayout(new GridLayout(2, 1));

        // Thêm hai JLabel vào JFrame
        add(osLabel);
        add(javaLabel);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT11 frame = new BT11();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}