package vn.edu.eaut.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ProductCsvFrame extends JFrame {

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtPrice;

    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnClear;
    private JButton btnLoad;
    private JButton btnSave;

    private JTable table;
    private DefaultTableModel model;

    private File selectedFile;

    public ProductCsvFrame() {

        setTitle("Bài 10 - Quản lý sản phẩm CSV");

        setSize(750, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createInterface();
        createEvents();
    }

    private void createInterface() {

        txtId = new JTextField();

        txtName = new JTextField();

        txtPrice = new JTextField();

        btnAdd = new JButton("Thêm");

        btnEdit = new JButton("Sửa");

        btnDelete = new JButton("Xóa");

        btnClear = new JButton("Làm mới");

        btnLoad = new JButton("Đọc CSV");

        btnSave = new JButton("Lưu CSV");

        JPanel inputPanel =
                new JPanel(new GridLayout(3, 2, 5, 5));

        inputPanel.add(new JLabel("Mã SP:"));
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Tên SP:"));
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Đơn giá:"));
        inputPanel.add(txtPrice);

        JPanel buttonPanel = new JPanel(
                new FlowLayout()
        );

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnLoad);
        buttonPanel.add(btnSave);

        JPanel northPanel =
                new JPanel(new BorderLayout());

        northPanel.add(
                inputPanel,
                BorderLayout.CENTER
        );

        northPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
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

        add(
                northPanel,
                BorderLayout.NORTH
        );

        add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );
    }

    private void createEvents() {

        btnAdd.addActionListener(
                e -> addProduct()
        );

        btnEdit.addActionListener(
                e -> editProduct()
        );

        btnDelete.addActionListener(
                e -> deleteProduct()
        );

        btnClear.addActionListener(
                e -> clearForm()
        );

        btnLoad.addActionListener(
                e -> loadCsv()
        );

        btnSave.addActionListener(
                e -> saveCsv()
        );

        table.getSelectionModel()
                .addListSelectionListener(e -> {

                    int row =
                            table.getSelectedRow();

                    if (row >= 0) {

                        txtId.setText(
                                model.getValueAt(
                                        row, 0
                                ).toString()
                        );

                        txtName.setText(
                                model.getValueAt(
                                        row, 1
                                ).toString()
                        );

                        txtPrice.setText(
                                model.getValueAt(
                                        row, 2
                                ).toString()
                        );
                    }
                });
    }

    private boolean validateInput() {

        if (txtId.getText().trim().isEmpty()
                || txtName.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập đầy đủ thông tin"
            );

            return false;
        }

        try {

            double price =
                    Double.parseDouble(
                            txtPrice.getText().trim()
                    );

            if (price < 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Đơn giá không được âm"
                );

                return false;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Đơn giá phải là số"
            );

            return false;
        }

        return true;
    }

    private void addProduct() {

        if (!validateInput()) {
            return;
        }

        String id =
                txtId.getText().trim();

        String name =
                txtName.getText().trim();

        double price =
                Double.parseDouble(
                        txtPrice.getText().trim()
                );

        for (int i = 0; i < model.getRowCount(); i++) {

            if (model.getValueAt(i, 0)
                    .toString()
                    .equalsIgnoreCase(id)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Mã sản phẩm đã tồn tại"
                );

                return;
            }
        }

        model.addRow(
                new Object[]{
                    id,
                    name,
                    price
                }
        );

        clearForm();
    }

    private void editProduct() {

        int row =
                table.getSelectedRow();

        if (row < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng chọn sản phẩm cần sửa"
            );

            return;
        }

        if (!validateInput()) {
            return;
        }

        String id =
                txtId.getText().trim();

        String name =
                txtName.getText().trim();

        double price =
                Double.parseDouble(
                        txtPrice.getText().trim()
                );

        model.setValueAt(id, row, 0);

        model.setValueAt(name, row, 1);

        model.setValueAt(price, row, 2);

        clearForm();
    }

    private void deleteProduct() {

        int row =
                table.getSelectedRow();

        if (row < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng chọn sản phẩm cần xóa"
            );

            return;
        }

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có chắc muốn xóa?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION
                );

        if (result ==
                JOptionPane.YES_OPTION) {

            model.removeRow(row);

            clearForm();
        }
    }

    private void clearForm() {

        txtId.setText("");

        txtName.setText("");

        txtPrice.setText("");

        table.clearSelection();
    }

    private void loadCsv() {

        JFileChooser chooser =
                new JFileChooser();

        int result =
                chooser.showOpenDialog(this);

        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        selectedFile =
                chooser.getSelectedFile();

        btnLoad.setEnabled(false);

        model.setRowCount(0);

        SwingWorker<List<Product>, Void> worker =
                new SwingWorker<>() {

            @Override
            protected List<Product> doInBackground()
                    throws Exception {

                List<Product> products =
                        new ArrayList<>();

                try (BufferedReader reader =
                             new BufferedReader(
                                     new InputStreamReader(
                                             new FileInputStream(
                                                     selectedFile
                                             ),
                                             StandardCharsets.UTF_8
                                     ))) {

                    String line;

                    boolean firstLine = true;

                    while ((line =
                            reader.readLine()) != null) {

                        if (firstLine) {

                            firstLine = false;

                            continue;
                        }

                        if (line.trim().isEmpty()) {
                            continue;
                        }

                        String[] parts =
                                line.split(",");

                        if (parts.length >= 3) {

                            String id =
                                    parts[0].trim();

                            String name =
                                    parts[1].trim();

                            double price =
                                    Double.parseDouble(
                                            parts[2].trim()
                                    );

                            products.add(
                                    new Product(
                                            id,
                                            name,
                                            price
                                    )
                            );
                        }
                    }
                }

                return products;
            }

            @Override
            protected void done() {

                try {

                    List<Product> products =
                            get();

                    for (Product product :
                            products) {

                        model.addRow(
                                new Object[]{
                                    product.getId(),
                                    product.getName(),
                                    product.getPrice()
                                }
                        );
                    }

                    JOptionPane.showMessageDialog(
                            ProductCsvFrame.this,
                            "Đọc file thành công"
                    );

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            ProductCsvFrame.this,
                            "Lỗi đọc file: "
                            + ex.getMessage()
                    );
                }

                btnLoad.setEnabled(true);
            }
        };

        worker.execute();
    }

    private void saveCsv() {

        JFileChooser chooser =
                new JFileChooser();

        int result =
                chooser.showSaveDialog(this);

        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file =
                chooser.getSelectedFile();

        btnSave.setEnabled(false);

        SwingWorker<Void, Void> worker =
                new SwingWorker<>() {

            @Override
            protected Void doInBackground()
                    throws Exception {

                try (
                        BufferedWriter writer =
                                new BufferedWriter(
                                        new OutputStreamWriter(
                                                new FileOutputStream(
                                                        file
                                                ),
                                                StandardCharsets.UTF_8
                                        )
                                )
                ) {

                    writer.write(
                            "MaSP,TenSP,DonGia"
                    );

                    writer.newLine();

                    for (int i = 0;
                         i < model.getRowCount();
                         i++) {

                        String id =
                                model.getValueAt(
                                        i, 0
                                ).toString();

                        String name =
                                model.getValueAt(
                                        i, 1
                                ).toString();

                        String price =
                                model.getValueAt(
                                        i, 2
                                ).toString();

                        writer.write(
                                id + ","
                                + name + ","
                                + price
                        );

                        writer.newLine();
                    }
                }

                return null;
            }

            @Override
            protected void done() {

                try {

                    get();

                    JOptionPane.showMessageDialog(
                            ProductCsvFrame.this,
                            "Lưu file thành công"
                    );

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            ProductCsvFrame.this,
                            "Lỗi lưu file: "
                            + ex.getMessage()
                    );
                }

                btnSave.setEnabled(true);
            }
        };

        worker.execute();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new ProductCsvFrame()
                    .setVisible(true);

        });
    }
}