package vn.edu.eaut.lab3;

import javax.swing.*;
import java.awt.*;

public class Bai06LoginForm extends JFrame {

    private JTextField txtTaiKhoan;
    private JPasswordField txtMatKhau;
    private JComboBox<String> cboVaiTro;
    private JCheckBox chkHienThiMatKhau;
    private JButton btnDangNhap;

    public Bai06LoginForm() {

        setTitle("Bài 6 - Đăng nhập");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(450, 300);

        setLocationRelativeTo(null);

        taoGiaoDien();
    }

    private void taoGiaoDien() {

        JPanel panelChinh = new JPanel(
                new BorderLayout(10, 10)
        );

        panelChinh.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 20, 25
                )
        );

        JLabel lblTieuDe = new JLabel(
                "ĐĂNG NHẬP HỆ THỐNG",
                SwingConstants.CENTER
        );

        lblTieuDe.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        panelChinh.add(
                lblTieuDe,
                BorderLayout.NORTH
        );

        JPanel panelForm = new JPanel(
                new GridLayout(4, 2, 10, 10)
        );

        panelForm.add(
                new JLabel("Tài khoản:")
        );

        txtTaiKhoan = new JTextField();

        panelForm.add(txtTaiKhoan);

        panelForm.add(
                new JLabel("Mật khẩu:")
        );

        txtMatKhau = new JPasswordField();

        panelForm.add(txtMatKhau);

        panelForm.add(
                new JLabel("Vai trò:")
        );

        cboVaiTro = new JComboBox<>(
                new String[]{
                    "Admin",
                    "User"
                }
        );

        panelForm.add(cboVaiTro);

        panelForm.add(
                new JLabel("Mật khẩu:")
        );

        chkHienThiMatKhau =
                new JCheckBox("Hiển thị mật khẩu");

        panelForm.add(
                chkHienThiMatKhau
        );

        panelChinh.add(
                panelForm,
                BorderLayout.CENTER
        );

        btnDangNhap =
                new JButton("Đăng nhập");

        panelChinh.add(
                btnDangNhap,
                BorderLayout.SOUTH
        );

        setContentPane(panelChinh);

        btnDangNhap.addActionListener(
                e -> dangNhap()
        );

        chkHienThiMatKhau.addActionListener(
                e -> thayDoiHienThiMatKhau()
        );
    }

    private void thayDoiHienThiMatKhau() {

        if (chkHienThiMatKhau.isSelected()) {

            txtMatKhau.setEchoChar(
                    (char) 0
            );

        } else {

            txtMatKhau.setEchoChar('•');
        }
    }

    private void dangNhap() {

        String taiKhoan =
                txtTaiKhoan.getText().trim();

        String matKhau =
                new String(
                        txtMatKhau.getPassword()
                );

        String vaiTro =
                (String) cboVaiTro.getSelectedItem();

        if (taiKhoan.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập tài khoản!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );

            txtTaiKhoan.requestFocus();

            return;
        }

        if (matKhau.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập mật khẩu!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );

            txtMatKhau.requestFocus();

            return;
        }

        boolean dangNhapDung = false;

        if (
                taiKhoan.equals("admin")
                &&
                matKhau.equals("123456")
                &&
                vaiTro.equals("Admin")
        ) {

            dangNhapDung = true;

        } else if (
                taiKhoan.equals("user")
                &&
                matKhau.equals("123456")
                &&
                vaiTro.equals("User")
        ) {

            dangNhapDung = true;
        }

        if (dangNhapDung) {

            JOptionPane.showMessageDialog(
                    this,
                    "Đăng nhập thành công!\n"
                    + "Chào mừng " + taiKhoan
                    + " (" + vaiTro + ")!",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Tài khoản, mật khẩu hoặc vai trò không đúng!",
                    "Đăng nhập thất bại",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {
                    Bai06LoginForm form =
                            new Bai06LoginForm();

                    form.setVisible(true);
                }
        );
    }
}