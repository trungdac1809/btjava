package bt.btchuong2;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class BT21 extends JFrame {

    public BT21() {
        // Tiêu đề
        setTitle("City List");

        // Kích thước JFrame
        setSize(300, 400);

        // Tạo danh sách thành phố
        DefaultListModel<String> model = new DefaultListModel<>();

        model.addElement("Hanoi");
        model.addElement("Ho Chi Minh City");
        model.addElement("Da Nang");
        model.addElement("Hai Phong");
        model.addElement("Can Tho");
        model.addElement("Hue");
        model.addElement("Nha Trang");
        model.addElement("Da Lat");
        model.addElement("Vung Tau");
        model.addElement("Quang Ninh");

        // Tạo JList
        JList<String> cityList = new JList<>(model);

        // Đưa JList vào JScrollPane
        JScrollPane scrollPane = new JScrollPane(cityList);

        // JLabel hiển thị số lượng
        JLabel countLabel = new JLabel(
                "Số lượng thành phố: " + model.getSize()
        );

        countLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Thêm vào JFrame
        add(countLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT21 frame = new BT21();
        frame.setVisible(true);
    }
}