package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BT28 extends JFrame {

    public BT28() {
        // Tiêu đề
        setTitle("Student List");

        // Kích thước JFrame
        setSize(500, 400);

        // Tên các cột
        String[] columnNames = {
            "Tên",
            "Tuổi",
            "Điểm"
        };

        // Dữ liệu sinh viên
        Object[][] data = {
            {"Nguyễn Văn An", 20, 8.5},
            {"Trần Thị Bình", 21, 9.0},
            {"Lê Văn Cường", 20, 7.5},
            {"Phạm Thị Dung", 22, 8.0},
            {"Hoàng Văn Em", 21, 9.5}
        };

        // Tạo JTable
        JTable table = new JTable(data, columnNames);

        // Đưa JTable vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Thêm vào JFrame
        add(scrollPane, BorderLayout.CENTER);

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT28 frame = new BT28();
        frame.setVisible(true);
    }
}