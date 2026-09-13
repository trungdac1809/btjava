package vn.edu.eaut.lab3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bai08QuanLySinhVien
        extends JFrame {

    private JTextField txtMaSinhVien;

    private JTextField txtHoTen;

    private JTextField txtDiemTrungBinh;

    private JTable table;

    private DefaultTableModel tableModel;

    public Bai08QuanLySinhVien() {

        setTitle(
                "Bài 8 - Quản lý sinh viên"
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setSize(750, 500);

        setLocationRelativeTo(null);

        taoGiaoDien();
    }

    private void taoGiaoDien() {

        JPanel panelChinh =
                new JPanel(new BorderLayout(10, 10));

        panelChinh.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        JLabel lblTieuDe =
                new JLabel(
                        "QUẢN LÝ SINH VIÊN",
                        SwingConstants.CENTER
                );

        lblTieuDe.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        panelChinh.add(
                lblTieuDe,
                BorderLayout.NORTH
        );

        JPanel panelNhap =
                new JPanel(
                        new GridLayout(3, 2, 10, 10)
                );

        panelNhap.add(
                new JLabel("Mã sinh viên:")
        );

        txtMaSinhVien =
                new JTextField();

        panelNhap.add(txtMaSinhVien);

        panelNhap.add(
                new JLabel("Họ tên:")
        );

        txtHoTen =
                new JTextField();

        panelNhap.add(txtHoTen);

        panelNhap.add(
                new JLabel("Điểm trung bình:")
        );

        txtDiemTrungBinh =
                new JTextField();

        panelNhap.add(txtDiemTrungBinh);

        JPanel panelTren =
                new JPanel(new BorderLayout(10, 10));

        panelTren.add(
                panelNhap,
                BorderLayout.CENTER
        );

        JPanel panelNut =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                5
                        )
                );

        JButton btnThem =
                new JButton("Thêm");

        JButton btnSua =
                new JButton("Sửa");

        JButton btnXoa =
                new JButton("Xóa");

        JButton btnLamMoi =
                new JButton("Làm mới");

        panelNut.add(btnThem);

        panelNut.add(btnSua);

        panelNut.add(btnXoa);

        panelNut.add(btnLamMoi);

        panelTren.add(
                panelNut,
                BorderLayout.SOUTH
        );

        panelChinh.add(
                panelTren,
                BorderLayout.CENTER
        );

        String[] columns = {
            "Mã sinh viên",
            "Họ tên",
            "Điểm trung bình",
            "Xếp loại"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {

                        return false;
                    }
                };

        table = new JTable(tableModel);

        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Danh sách sinh viên"
                )
        );

        panelChinh.add(
                scrollPane,
                BorderLayout.SOUTH
        );

        setContentPane(panelChinh);

        btnThem.addActionListener(
                e -> themSinhVien()
        );

        btnSua.addActionListener(
                e -> suaSinhVien()
        );

        btnXoa.addActionListener(
                e -> xoaSinhVien()
        );

        btnLamMoi.addActionListener(
                e -> lamMoi()
        );

        table.getSelectionModel()
                .addListSelectionListener(
                        e -> hienThiSinhVienDaChon()
                );
    }

    private Student docDuLieuTuForm() {

        String ma =
                txtMaSinhVien
                        .getText()
                        .trim();

        String hoTen =
                txtHoTen
                        .getText()
                        .trim();

        String diemText =
                txtDiemTrungBinh
                        .getText()
                        .trim();

        if (ma.isEmpty()) {

            throw new IllegalArgumentException(
                    "Mã sinh viên không được để trống!"
            );
        }

        if (hoTen.isEmpty()) {

            throw new IllegalArgumentException(
                    "Họ tên không được để trống!"
            );
        }

        double diem;

        try {

            diem =
                    Double.parseDouble(diemText);

        } catch (NumberFormatException ex) {

            throw new IllegalArgumentException(
                    "Điểm trung bình phải là số!"
            );
        }

        if (diem < 0 || diem > 10) {

            throw new IllegalArgumentException(
                    "Điểm trung bình phải từ 0 đến 10!"
            );
        }

        return new Student(
                ma,
                hoTen,
                diem
        );
    }

    private void themSinhVien() {

        try {

            Student student =
                    docDuLieuTuForm();

            for (
                    int i = 0;
                    i < tableModel.getRowCount();
                    i++
            ) {

                String maCu =
                        tableModel
                                .getValueAt(i, 0)
                                .toString();

                if (
                        maCu.equalsIgnoreCase(
                                student.getMaSinhVien()
                        )
                ) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Mã sinh viên đã tồn tại!",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }
            }

            tableModel.addRow(
                    new Object[]{
                        student.getMaSinhVien(),
                        student.getHoTen(),
                        String.format(
                                "%.2f",
                                student.getDiemTrungBinh()
                        ),
                        student.getXepLoai()
                    }
            );

            lamMoi();

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Dữ liệu không hợp lệ",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void suaSinhVien() {

        int row =
                table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng chọn sinh viên cần sửa!"
            );

            return;
        }

        try {

            Student student =
                    docDuLieuTuForm();

            String maCu =
                    tableModel
                            .getValueAt(row, 0)
                            .toString();

            for (
                    int i = 0;
                    i < tableModel.getRowCount();
                    i++
            ) {

                if (i == row) {
                    continue;
                }

                String ma =
                        tableModel
                                .getValueAt(i, 0)
                                .toString();

                if (
                        ma.equalsIgnoreCase(
                                student.getMaSinhVien()
                        )
                ) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Mã sinh viên đã tồn tại!",
                            "Lỗi",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }
            }

            tableModel.setValueAt(
                    student.getMaSinhVien(),
                    row,
                    0
            );

            tableModel.setValueAt(
                    student.getHoTen(),
                    row,
                    1
            );

            tableModel.setValueAt(
                    String.format(
                            "%.2f",
                            student.getDiemTrungBinh()
                    ),
                    row,
                    2
            );

            tableModel.setValueAt(
                    student.getXepLoai(),
                    row,
                    3
            );

            lamMoi();

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Dữ liệu không hợp lệ",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void xoaSinhVien() {

        int row =
                table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng chọn sinh viên cần xóa!"
            );

            return;
        }

        int confirm =
                JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có chắc muốn xóa sinh viên này?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION
                );

        if (
                confirm
                ==
                JOptionPane.YES_OPTION
        ) {

            tableModel.removeRow(row);

            lamMoi();
        }
    }

    private void hienThiSinhVienDaChon() {

        int row =
                table.getSelectedRow();

        if (row == -1) {
            return;
        }

        txtMaSinhVien.setText(
                tableModel
                        .getValueAt(row, 0)
                        .toString()
        );

        txtHoTen.setText(
                tableModel
                        .getValueAt(row, 1)
                        .toString()
        );

        txtDiemTrungBinh.setText(
                tableModel
                        .getValueAt(row, 2)
                        .toString()
        );
    }

    private void lamMoi() {

        txtMaSinhVien.setText("");

        txtHoTen.setText("");

        txtDiemTrungBinh.setText("");

        table.clearSelection();

        txtMaSinhVien.requestFocus();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    Bai08QuanLySinhVien app =
                            new Bai08QuanLySinhVien();

                    app.setVisible(true);
                }
        );
    }
}