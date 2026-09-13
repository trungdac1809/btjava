package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class BT20 extends JFrame {

    public BT20() {
        // Đặt tiêu đề cửa sổ
        setTitle("Tabbed Pane Demo");

        // Đặt kích thước JFrame 500x400
        setSize(500, 400);

        // Tạo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // ==============================
        // TAB HOME
        // ==============================

        JLabel homeLabel = new JLabel("Welcome to Home");
        homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        homeLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Thêm tab Home
        tabbedPane.addTab("Home", homeLabel);

        // ==============================
        // TAB PROFILE
        // ==============================

        JLabel profileLabel = new JLabel("This is your Profile");
        profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profileLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Thêm tab Profile
        tabbedPane.addTab("Profile", profileLabel);

        // ==============================
        // TAB SETTINGS
        // ==============================

        JLabel settingsLabel = new JLabel("This is Settings");
        settingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingsLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Thêm tab Settings
        tabbedPane.addTab("Settings", settingsLabel);

        // Thêm JTabbedPane vào JFrame
        add(tabbedPane, BorderLayout.CENTER);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT20 frame = new BT20();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}