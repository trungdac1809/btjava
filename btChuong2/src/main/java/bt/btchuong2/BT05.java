package bt.btchuong2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BT05 extends JFrame {

    public BT05() {
        setTitle("Digital Clock");

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        String time = now.format(formatter);

        JLabel clockLabel = new JLabel(time);

        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clockLabel.setVerticalAlignment(SwingConstants.CENTER);

        add(clockLabel);

        setSize(300, 150);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Tạo và hiển thị JFrame
        BT05 frame = new BT05();
        frame.setVisible(true);
    }
}