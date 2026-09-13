package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class BT27 extends JFrame {

    public BT27() {
        // Tiêu đề
        setTitle("Progress Bar");

        // Kích thước JFrame
        setSize(300, 200);

        // FlowLayout
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));

        // Tạo JProgressBar từ 0 đến 100
        JProgressBar progressBar = new JProgressBar(0, 100);

        // Hiển thị phần trăm
        progressBar.setStringPainted(true);

        // Đặt giá trị ban đầu
        progressBar.setValue(0);

        // Tạo JButton Start
        JButton startButton = new JButton("Start");

        // Xử lý nút Start
        startButton.addActionListener(e -> {

            // Đưa progress về 0
            progressBar.setValue(0);

            // Khóa nút Start trong khi chạy
            startButton.setEnabled(false);

            // Timer chạy mỗi 50 mili-giây
            Timer timer = new Timer(50, null);

            timer.addActionListener(event -> {

                int value = progressBar.getValue();

                if (value < 100) {
                    // Tăng 1 đơn vị
                    progressBar.setValue(value + 1);
                } else {
                    // Đạt 100 thì dừng Timer
                    timer.stop();

                    // Cho phép bấm Start lại
                    startButton.setEnabled(true);
                }
            });

            // Bắt đầu Timer
            timer.start();
        });

        // Thêm thành phần
        add(progressBar);
        add(startButton);

        // Đưa cửa sổ ra giữa
        setLocationRelativeTo(null);

        // Đóng chương trình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT27 frame = new BT27();
        frame.setVisible(true);
    }
}