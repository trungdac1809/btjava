package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BT17 extends JFrame {

    public BT17() {
        // Đặt tiêu đề cửa sổ
        setTitle("Login Form");

        // Đặt kích thước JFrame 300x200
        setSize(300, 200);

        // Sử dụng FlowLayout và căn giữa các thành phần
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Tạo JLabel Username
        JLabel usernameLabel = new JLabel("Username");

        // Tạo JTextField nhập Username
        JTextField usernameField = new JTextField(15);

        // Tạo JLabel Password
        JLabel passwordLabel = new JLabel("Password");

        // Tạo JPasswordField nhập Password
        JPasswordField passwordField = new JPasswordField(15);

        // Tạo JButton Login
        JButton loginButton = new JButton("Login");

        // Thêm các thành phần vào JFrame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT17 frame = new BT17();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}