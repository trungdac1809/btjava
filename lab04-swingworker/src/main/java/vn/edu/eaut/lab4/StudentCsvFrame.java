package vn.edu.eaut.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StudentCsvFrame extends JFrame {

    private JButton btnChoose;
    private JButton btnLoad;

    private JLabel lblFile;
    private JLabel lblAverage;
    private JLabel lblHighest;

    private JTable table;
    private DefaultTableModel model;

    private File selectedFile;

    public StudentCsvFrame() {

        setTitle("Bài 8 - Đọc CSV điểm sinh viên");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnChoose = new JButton("Chọn CSV");
        btnLoad = new JButton("Đọc dữ liệu");

        lblFile = new JLabel("Chưa chọn file");

        lblAverage = new JLabel("Điểm trung bình: ");

        lblHighest = new JLabel("Sinh viên cao nhất: ");

        model = new DefaultTableModel(
                new Object[]{
                    "Mã SV",
                    "Họ tên",
                    "Điểm"
                },
                0
        );

        table = new JTable(model);

        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        topPanel.add(new JLabel("File:"));
        topPanel.add(lblFile);

        topPanel.add(btnChoose);
        topPanel.add(btnLoad);

        topPanel.add(lblAverage);
        topPanel.add(lblHighest);

        add(topPanel, BorderLayout.NORTH);

        add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        btnLoad.setEnabled(false);

        btnChoose.addActionListener(e -> chooseFile());

        btnLoad.addActionListener(e -> loadCsv());
    }

    private void chooseFile() {

        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            selectedFile = chooser.getSelectedFile();

            lblFile.setText(selectedFile.getName());

            btnLoad.setEnabled(true);
        }
    }

    private void loadCsv() {

        btnLoad.setEnabled(false);

        model.setRowCount(0);

        lblAverage.setText("Đang đọc dữ liệu...");

        SwingWorker<List<StudentData>, Void> worker =
                new SwingWorker<>() {

            @Override
            protected List<StudentData> doInBackground()
                    throws Exception {

                List<StudentData> students =
                        new ArrayList<>();

                try (BufferedReader reader =
                             new BufferedReader(
                                     new InputStreamReader(
                                             new FileInputStream(selectedFile),
                                             StandardCharsets.UTF_8))) {

                    String line;

                    boolean firstLine = true;

                    while ((line = reader.readLine()) != null) {

                        if (firstLine) {
                            firstLine = false;
                            continue;
                        }

                        if (line.trim().isEmpty()) {
                            continue;
                        }

                        String[] parts = line.split(",");

                        if (parts.length >= 3) {

                            String id = parts[0].trim();

                            String name = parts[1].trim();

                            double score =
                                    Double.parseDouble(
                                            parts[2].trim()
                                    );

                            students.add(
                                    new StudentData(
                                            id,
                                            name,
                                            score
                                    )
                            );
                        }
                    }
                }

                return students;
            }

            @Override
            protected void done() {

                try {

                    List<StudentData> students = get();

                    double sum = 0;

                    StudentData highest = null;

                    for (StudentData student : students) {

                        model.addRow(
                                new Object[]{
                                    student.id,
                                    student.name,
                                    student.score
                                }
                        );

                        sum += student.score;

                        if (highest == null
                                || student.score > highest.score) {

                            highest = student;
                        }
                    }

                    if (!students.isEmpty()) {

                        double average =
                                sum / students.size();

                        lblAverage.setText(
                                String.format(
                                        "Điểm trung bình: %.2f",
                                        average
                                )
                        );

                        lblHighest.setText(
                                "Sinh viên cao nhất: "
                                + highest.name
                                + " - "
                                + highest.score
                        );

                    } else {

                        lblAverage.setText(
                                "Không có dữ liệu"
                        );

                        lblHighest.setText(
                                "Không có dữ liệu"
                        );
                    }

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            StudentCsvFrame.this,
                            "Lỗi đọc CSV: "
                            + ex.getMessage()
                    );
                }

                btnLoad.setEnabled(true);
            }
        };

        worker.execute();
    }

    private static class StudentData {

        String id;
        String name;
        double score;

        StudentData(
                String id,
                String name,
                double score
        ) {

            this.id = id;
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new StudentCsvFrame().setVisible(true);
        });
    }
}