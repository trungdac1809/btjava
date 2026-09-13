package bt.btchuong2;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BT10 extends JFrame {

    public BT10() {
        // Đặt tiêu đề JFrame
        setTitle("Menu Demo");

        // Tạo thanh menu
        JMenuBar menuBar = new JMenuBar();

        // Tạo menu File
        JMenu fileMenu = new JMenu("File");

        // Tạo menu item Exit
        JMenuItem exitItem = new JMenuItem("Exit");

        // Sự kiện khi chọn Exit
        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        // Thêm Exit vào menu File
        fileMenu.add(exitItem);

        // Thêm File vào thanh menu
        menuBar.add(fileMenu);

        // Đặt thanh menu cho JFrame
        setJMenuBar(menuBar);

        // Kích thước cửa sổ
        setSize(500, 400);

        // Đưa cửa sổ ra giữa màn hình
        setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        BT10 frame = new BT10();

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}