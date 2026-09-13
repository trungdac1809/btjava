package bt.btchuong2;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class BT12 extends JFrame {

    public BT12() {
        // Đặt tiêu đề cửa sổ
        setTitle("Custom Look and Feel");

        // Đặt kích thước JFrame 400x300
        setSize(400, 300);

        // Tạo JLabel
        JLabel label = new JLabel("Custom Look and Feel");

        // Căn giữa JLabel theo chiều ngang
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Căn giữa JLabel theo chiều dọc
        label.setVerticalAlignment(SwingConstants.CENTER);

        // Thêm JLabel vào JFrame
        add(label);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        // Thiết lập giao diện Nimbus
        try {
            for (UIManager.LookAndFeelInfo info
                    : UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Không thể thiết lập giao diện Nimbus.");
        }

        // Tạo JFrame
        BT12 frame = new BT12();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}