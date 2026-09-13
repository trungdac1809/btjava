package vn.edu.eaut.lab4;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileSearchFrame extends JFrame {

    private JButton btnChoose;
    private JButton btnSearch;

    private JTextField txtKeyword;
    private JTextArea txtResult;

    private JLabel lblFile;
    private JLabel lblCount;

    private File selectedFile;

    public FileSearchFrame() {

        setTitle("Bài 7 - Tìm kiếm từ khóa");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnChoose = new JButton("Chọn file");
        btnSearch = new JButton("Tìm kiếm");

        txtKeyword = new JTextField();

        txtResult = new JTextArea();
        txtResult.setEditable(false);

        lblFile = new JLabel("Chưa chọn file");
        lblCount = new JLabel("Số dòng tìm thấy: 0");

        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        topPanel.add(new JLabel("File:"));
        topPanel.add(lblFile);

        topPanel.add(new JLabel("Từ khóa:"));
        topPanel.add(txtKeyword);

        topPanel.add(btnChoose);
        topPanel.add(btnSearch);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.add(lblCount, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(txtResult), BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        btnSearch.setEnabled(false);

        btnChoose.addActionListener(e -> chooseFile());

        btnSearch.addActionListener(e -> searchKeyword());
    }

    private void chooseFile() {

        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            selectedFile = chooser.getSelectedFile();

            lblFile.setText(selectedFile.getName());

            btnSearch.setEnabled(true);

            txtResult.setText("");

            lblCount.setText("Số dòng tìm thấy: 0");
        }
    }

    private void searchKeyword() {

        String keyword = txtKeyword.getText().trim();

        if (keyword.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập từ khóa"
            );

            return;
        }

        btnSearch.setEnabled(false);

        txtResult.setText("");

        lblCount.setText("Đang tìm kiếm...");

        SwingWorker<Integer, String> worker = new SwingWorker<>() {

            @Override
            protected Integer doInBackground() throws Exception {

                int count = 0;

                try (BufferedReader reader =
                             new BufferedReader(
                                     new InputStreamReader(
                                             new FileInputStream(selectedFile),
                                             StandardCharsets.UTF_8))) {

                    String line;

                    while ((line = reader.readLine()) != null) {

                        if (line.toLowerCase()
                                .contains(keyword.toLowerCase())) {

                            count++;

                            publish(line);
                        }
                    }
                }

                return count;
            }

            @Override
            protected void process(java.util.List<String> chunks) {

                for (String line : chunks) {

                    txtResult.append(line);
                    txtResult.append("\n");
                }
            }

            @Override
            protected void done() {

                try {

                    int count = get();

                    lblCount.setText(
                            "Số dòng tìm thấy: " + count
                    );

                } catch (Exception ex) {

                    lblCount.setText("Có lỗi khi đọc file");

                    JOptionPane.showMessageDialog(
                            FileSearchFrame.this,
                            "Không thể đọc file: "
                            + ex.getMessage()
                    );
                }

                btnSearch.setEnabled(true);
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FileSearchFrame().setVisible(true);
        });
    }
}