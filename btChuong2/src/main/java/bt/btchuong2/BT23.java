package bt.btchuong2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BT23 extends JFrame {

    private JTextField display;

    public BT23() {
        // Tiêu đề
        setTitle("Calculator");

        // Kích thước JFrame
        setSize(300, 400);

        // Sử dụng GridBagLayout
        setLayout(new GridBagLayout());

        // Tạo ô hiển thị kết quả
        display = new JTextField();
        display.setEditable(false);

        // GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // JTextField ở trên cùng
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;

        add(display, gbc);

        // Các nút máy tính
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Tạo 16 JButton
        for (int i = 0; i < buttons.length; i++) {

            JButton button = new JButton(buttons[i]);

            gbc.gridwidth = 1;
            gbc.gridx = i % 4;
            gbc.gridy = (i / 4) + 1;

            add(button, gbc);
        }

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT23 frame = new BT23();
        frame.setVisible(true);
    }
}