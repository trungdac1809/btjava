package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BT22 extends JFrame {

    public BT22() {
        // Tiêu đề
        setTitle("Fruit Selection");

        // Kích thước JFrame
        setSize(300, 200);

        // Sử dụng FlowLayout
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));

        // Tạo JComboBox
        String[] fruits = {
            "Apple",
            "Banana",
            "Orange",
            "Mango",
            "Watermelon"
        };

        JComboBox<String> fruitComboBox = new JComboBox<>(fruits);

        // JLabel hiển thị lựa chọn
        JLabel resultLabel = new JLabel(
                "Bạn chọn: " + fruitComboBox.getSelectedItem()
        );

        // Khi người dùng chọn trái cây
        fruitComboBox.addActionListener(e -> {
            resultLabel.setText(
                    "Bạn chọn: " + fruitComboBox.getSelectedItem()
            );
        });

        // Thêm thành phần
        add(fruitComboBox);
        add(resultLabel);

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT22 frame = new BT22();
        frame.setVisible(true);
    }
}