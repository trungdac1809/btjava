package bt.btchuong2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class BT26 extends JFrame {

    public BT26() {
        // Tiêu đề
        setTitle("RGB Brightness");

        // Kích thước JFrame
        setSize(400, 200);

        // Tạo JSlider từ 0 đến 255
        JSlider slider = new JSlider(0, 255, 128);

        // Hiển thị vạch chia
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // JLabel hiển thị giá trị
        JLabel valueLabel = new JLabel("RGB: 128");
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Thay đổi màu nền theo giá trị slider
        slider.addChangeListener(e -> {
            int value = slider.getValue();

            Color color = new Color(value, value, value);

            getContentPane().setBackground(color);

            valueLabel.setText("RGB: " + value);
        });

        // Màu ban đầu
        getContentPane().setBackground(
                new Color(slider.getValue(),
                        slider.getValue(),
                        slider.getValue())
        );

        // Thêm thành phần
        add(valueLabel, BorderLayout.NORTH);
        add(slider, BorderLayout.CENTER);

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT26 frame = new BT26();
        frame.setVisible(true);
    }
}