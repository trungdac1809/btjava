package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;

public class ProgressCancelFrame extends JFrame {

    private JButton btnStart;
    private JButton btnCancel;
    private JProgressBar progressBar;
    private JLabel lblStatus;

    private SwingWorker<Void, Void> worker;

    public ProgressCancelFrame() {
        setTitle("Bài 6 - Hủy tác vụ");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnStart = new JButton("Bắt đầu");
        btnCancel = new JButton("Hủy");
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        lblStatus = new JLabel("Chưa bắt đầu", SwingConstants.CENTER);

        btnCancel.setEnabled(false);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        panel.add(btnStart);
        panel.add(btnCancel);
        panel.add(progressBar);
        panel.add(lblStatus);

        add(panel);

        btnStart.addActionListener(e -> startTask());
        btnCancel.addActionListener(e -> cancelTask());
    }

    private void startTask() {

        btnStart.setEnabled(false);
        btnCancel.setEnabled(true);

        progressBar.setValue(0);
        lblStatus.setText("Đang xử lý...");

        worker = new SwingWorker<>() {

            @Override
            protected Void doInBackground() throws Exception {

                for (int i = 0; i <= 100; i++) {

                    if (isCancelled()) {
                        break;
                    }

                    setProgress(i);

                    Thread.sleep(100);

                }

                return null;
            }

            @Override
            protected void done() {

                if (isCancelled()) {
                    lblStatus.setText("Đã hủy tác vụ");
                } else {
                    progressBar.setValue(100);
                    lblStatus.setText("Hoàn thành");
                }

                btnStart.setEnabled(true);
                btnCancel.setEnabled(false);
            }
        };

        worker.addPropertyChangeListener(e -> {

            if ("progress".equals(e.getPropertyName())) {

                int value = (Integer) e.getNewValue();

                progressBar.setValue(value);
            }
        });

        worker.execute();
    }

    private void cancelTask() {

        if (worker != null && !worker.isDone()) {

            worker.cancel(true);

            lblStatus.setText("Đang hủy...");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ProgressCancelFrame().setVisible(true);
        });
    }
}