package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class BT14 extends JFrame {

    public BT14() {
        // Đặt tiêu đề cửa sổ
        setTitle("Message Demo");

        // Đặt kích thước JFrame 300x200
        setSize(300, 200);

        // Tạo JButton
        JButton button = new JButton("Show Message");

        // Tạo JLabel hiển thị kết quả lựa chọn
        JLabel resultLabel = new JLabel("Chưa có lựa chọn");

        // Căn giữa JLabel
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Thêm JLabel ở phía trên
        add(resultLabel, BorderLayout.NORTH);

        // Thêm JButton ở giữa
        add(button, BorderLayout.CENTER);

        // Xử lý sự kiện khi nhấn nút
        button.addActionListener(e -> {

            // Hiển thị JOptionPane với 3 lựa chọn Yes / No / Cancel
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có muốn tiếp tục không?",
                    "Confirmation",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            // Xử lý lựa chọn của người dùng
            if (choice == JOptionPane.YES_OPTION) {
                resultLabel.setText("Bạn đã chọn: Yes");
            } else if (choice == JOptionPane.NO_OPTION) {
                resultLabel.setText("Bạn đã chọn: No");
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                resultLabel.setText("Bạn đã chọn: Cancel");
            } else {
                // Trường hợp người dùng đóng hộp thoại bằng nút X
                resultLabel.setText("Bạn đã đóng thông báo");
            }
        });

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT14 frame = new BT14();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}