package bt.btchuong2;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class BT24 extends JFrame {

    public BT24() {
        // Tiêu đề
        setTitle("CheckBox Demo");

        // Kích thước JFrame
        setSize(300, 200);

        // FlowLayout căn giữa
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 70));

        // Tạo JCheckBox
        JCheckBox checkBox = new JCheckBox("Enable Background");

        // Xử lý khi chọn / bỏ chọn
        checkBox.addActionListener(e -> {

            if (checkBox.isSelected()) {
                // Khi chọn: nền xanh
                getContentPane().setBackground(Color.GREEN);
            } else {
                // Khi bỏ chọn: trở về màu mặc định
                getContentPane().setBackground(
                        javax.swing.UIManager.getColor(
                                "Panel.background"
                        )
                );
            }
        });

        // Thêm JCheckBox
        add(checkBox);

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT24 frame = new BT24();
        frame.setVisible(true);
    }
}