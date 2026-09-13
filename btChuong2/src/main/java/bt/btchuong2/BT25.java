package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class BT25 extends JFrame {

    public BT25() {
        // Tiêu đề
        setTitle("Gender Selection");

        // Kích thước JFrame
        setSize(300, 200);

        // FlowLayout căn giữa
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));

        // Tạo RadioButton Male
        JRadioButton maleButton = new JRadioButton("Male");

        // Tạo RadioButton Female
        JRadioButton femaleButton = new JRadioButton("Female");

        // Tạo ButtonGroup
        ButtonGroup group = new ButtonGroup();

        // Thêm 2 RadioButton vào cùng ButtonGroup
        group.add(maleButton);
        group.add(femaleButton);

        // JLabel hiển thị lựa chọn
        JLabel resultLabel = new JLabel("Chưa chọn");

        // Sự kiện Male
        maleButton.addActionListener(e -> {
            resultLabel.setText("Bạn chọn: Male");
        });

        // Sự kiện Female
        femaleButton.addActionListener(e -> {
            resultLabel.setText("Bạn chọn: Female");
        });

        // Thêm thành phần vào JFrame
        add(maleButton);
        add(femaleButton);
        add(resultLabel);

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT25 frame = new BT25();
        frame.setVisible(true);
    }
}