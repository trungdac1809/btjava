package vn.edu.eaut.lab3;

import javax.swing.*;
import java.awt.*;

public class Bai07MayTinhMini extends JFrame {

    private JTextField txtSo1;
    private JTextField txtSo2;
    private JTextField txtKetQua;
    private JTextArea txtLichSu;

    public Bai07MayTinhMini() {

        setTitle("Bài 7 - Máy tính mini");

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setSize(550, 450);

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

        JPanel panelNhap =
                new JPanel(
                        new GridLayout(3, 2, 10, 10)
                );

        panelNhap.add(
                new JLabel("Số thứ nhất:")
        );

        txtSo1 = new JTextField();

        panelNhap.add(txtSo1);

        panelNhap.add(
                new JLabel("Số thứ hai:")
        );

        txtSo2 = new JTextField();

        panelNhap.add(txtSo2);

        panelNhap.add(
                new JLabel("Kết quả:")
        );

        txtKetQua = new JTextField();

        txtKetQua.setEditable(false);

        panelNhap.add(txtKetQua);

        panelChinh.add(
                panelNhap,
                BorderLayout.NORTH
        );

        JPanel panelNut =
                new JPanel(
                        new GridLayout(1, 5, 8, 8)
                );

        JButton btnCong =
                new JButton("Cộng");

        JButton btnTru =
                new JButton("Trừ");

        JButton btnNhan =
                new JButton("Nhân");

        JButton btnChia =
                new JButton("Chia");

        JButton btnClear =
                new JButton("Clear");

        panelNut.add(btnCong);
        panelNut.add(btnTru);
        panelNut.add(btnNhan);
        panelNut.add(btnChia);
        panelNut.add(btnClear);

        panelChinh.add(
                panelNut,
                BorderLayout.CENTER
        );

        txtLichSu = new JTextArea();

        txtLichSu.setEditable(false);

        txtLichSu.setLineWrap(true);

        txtLichSu.setWrapStyleWord(true);

        JScrollPane scrollPane =
                new JScrollPane(txtLichSu);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Lịch sử phép tính"
                )
        );

        panelChinh.add(
                scrollPane,
                BorderLayout.SOUTH
        );

        setContentPane(panelChinh);

        btnCong.addActionListener(
                e -> tinhToan("+")
        );

        btnTru.addActionListener(
                e -> tinhToan("-")
        );

        btnNhan.addActionListener(
                e -> tinhToan("*")
        );

        btnChia.addActionListener(
                e -> tinhToan("/")
        );

        btnClear.addActionListener(
                e -> clear()
        );
    }

    private void tinhToan(String phepToan) {

        try {

            double so1 =
                    Double.parseDouble(
                            txtSo1.getText().trim()
                    );

            double so2 =
                    Double.parseDouble(
                            txtSo2.getText().trim()
                    );

            double ketQua;

            switch (phepToan) {

                case "+":
                    ketQua = so1 + so2;
                    break;

                case "-":
                    ketQua = so1 - so2;
                    break;

                case "*":
                    ketQua = so1 * so2;
                    break;

                case "/":

                    if (so2 == 0) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Không thể chia cho 0!",
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE
                        );

                        return;
                    }

                    ketQua = so1 / so2;
                    break;

                default:
                    return;
            }

            txtKetQua.setText(
                    String.valueOf(ketQua)
            );

            String lichSu =
                    so1 + " "
                    + phepToan + " "
                    + so2
                    + " = "
                    + ketQua;

            txtLichSu.append(
                    lichSu + "\n"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Vui lòng nhập hai số hợp lệ!",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clear() {

        txtSo1.setText("");

        txtSo2.setText("");

        txtKetQua.setText("");

        txtLichSu.setText("");

        txtSo1.requestFocus();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {
                    Bai07MayTinhMini mayTinh =
                            new Bai07MayTinhMini();

                    mayTinh.setVisible(true);
                }
        );
    }
}