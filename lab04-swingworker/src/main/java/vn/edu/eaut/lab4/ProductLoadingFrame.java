package vn.edu.eaut.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductLoadingFrame extends JFrame {

    private JButton btnLoad;

    private JProgressBar progressBar;

    private JLabel lblStatus;

    private JTable table;

    private DefaultTableModel model;

    public ProductLoadingFrame() {

        setTitle("Bài 9 - Tải danh sách sản phẩm");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnLoad = new JButton("Tải sản phẩm");

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        lblStatus = new JLabel(
                "Chưa tải dữ liệu",
                SwingConstants.CENTER
        );

        model = new DefaultTableModel(
                new Object[]{
                    "Mã SP",
                    "Tên SP",
                    "Đơn giá"
                },
                0
        );

        table = new JTable(model);

        JPanel topPanel = new JPanel(
                new GridLayout(3, 1, 5, 5)
        );

        topPanel.add(btnLoad);
        topPanel.add(progressBar);
        topPanel.add(lblStatus);

        add(topPanel, BorderLayout.NORTH);

        add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        btnLoad.addActionListener(e -> loadProducts());
    }

    private void loadProducts() {

        btnLoad.setEnabled(false);

        model.setRowCount(0);

        progressBar.setValue(0);

        lblStatus.setText("Đang tải sản phẩm...");

        SwingWorker<List<Product>, Integer> worker =
                new SwingWorker<>() {

            @Override
            protected List<Product> doInBackground()
                    throws Exception {

                List<Product> products =
                        new ArrayList<>();

                products.add(
                        new Product(
                                "SP01",
                                "Bàn phím",
                                250000
                        )
                );

                products.add(
                        new Product(
                                "SP02",
                                "Chuột",
                                150000
                        )
                );

                products.add(
                        new Product(
                                "SP03",
                                "Màn hình",
                                2500000
                        )
                );

                for (int i = 0; i < products.size(); i++) {

                    Thread.sleep(2000);

                    int progress =
                            (i + 1) * 100
                            / products.size();

                    setProgress(progress);
                }

                return products;
            }

            @Override
            protected void done() {

                try {

                    List<Product> products = get();

                    for (Product product : products) {

                        model.addRow(
                                new Object[]{
                                    product.id,
                                    product.name,
                                    product.price
                                }
                        );
                    }

                    progressBar.setValue(100);

                    lblStatus.setText(
                            "Tải sản phẩm hoàn tất"
                    );

                } catch (Exception ex) {

                    lblStatus.setText(
                            "Có lỗi khi tải dữ liệu"
                    );

                    JOptionPane.showMessageDialog(
                            ProductLoadingFrame.this,
                            ex.getMessage()
                    );
                }

                btnLoad.setEnabled(true);
            }
        };

        worker.addPropertyChangeListener(e -> {

            if ("progress".equals(
                    e.getPropertyName())) {

                progressBar.setValue(
                        (Integer) e.getNewValue()
                );
            }
        });

        worker.execute();
    }

    private static class Product {

        String id;
        String name;
        double price;

        Product(
                String id,
                String name,
                double price
        ) {

            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ProductLoadingFrame().setVisible(true);
        });
    }
}