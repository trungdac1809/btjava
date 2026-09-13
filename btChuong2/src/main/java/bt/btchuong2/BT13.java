package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT13 extends JFrame {

    public BT13() {
        // Đặt tiêu đề JFrame chính
        setTitle("Main Window");

        // Kích thước JFrame chính 400x300
        setSize(400, 300);

        // Tạo JButton
        JButton button = new JButton("Open Child Window");

        // Thêm JButton vào giữa cửa sổ chính
        add(button, BorderLayout.CENTER);

        // Xử lý sự kiện khi nhấn nút
        button.addActionListener(e -> openChildWindow());

        // Đưa cửa sổ chính ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Hàm mở cửa sổ con
    private void openChildWindow() {

        // Tạo JFrame thứ hai
        JFrame childFrame = new JFrame("Child Window");

        // Đặt kích thước cửa sổ con 200x200
        childFrame.setSize(200, 200);

        // Tạo JLabel
        JLabel label = new JLabel("Child Window");

        // Căn giữa JLabel theo chiều ngang
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Căn giữa JLabel theo chiều dọc
        label.setVerticalAlignment(SwingConstants.CENTER);

        // Thêm JLabel vào cửa sổ con
        childFrame.add(label);

        // Đặt cửa sổ con gần giữa cửa sổ chính
        childFrame.setLocationRelativeTo(this);

        // Đóng cửa sổ con khi nhấn X
        childFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Hiển thị cửa sổ con
        childFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Tạo JFrame chính
        BT13 frame = new BT13();

        // Hiển thị JFrame chính
        frame.setVisible(true);
    }
}