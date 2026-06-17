package home;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bai26 extends JFrame {
    JTextField txtHoTen, txtDiaChi, txtSDT;
    JCheckBox cbBanhTrang, cbKhoaiTay, cbTraSuaTranChau, cbTraSuaMatcha;
    JTable table;
    DefaultTableModel model;
    JLabel lblTong;

    public Bai26() {
        setTitle("Mua Hang Online");
        setSize(520, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(panelThongTin(), BorderLayout.NORTH);
        add(panelCenter(), BorderLayout.CENTER);
        add(panelTongTien(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel panelThongTin() {
        JPanel main = new JPanel(new GridLayout(2, 1));

        JPanel info = new JPanel(new GridLayout(3, 2, 5, 5));
        info.setBorder(BorderFactory.createTitledBorder("Thong Tin Khach Hang"));

        txtHoTen = new JTextField();
        txtDiaChi = new JTextField();
        txtSDT = new JTextField();

        info.add(new JLabel("Ho va ten"));
        info.add(txtHoTen);
        info.add(new JLabel("Dia chi"));
        info.add(txtDiaChi);
        info.add(new JLabel("So dien thoai"));
        info.add(txtSDT);

        JPanel sp = new JPanel(new GridLayout(2, 2));
        sp.setBorder(BorderFactory.createTitledBorder("Chon San pham"));

        cbBanhTrang = new JCheckBox("Banh Trang Tron(15000)");
        cbKhoaiTay = new JCheckBox("Khoai Tay Chien Bo(5000)");
        cbTraSuaTranChau = new JCheckBox("Tra Sua Tran Chau(20000)");
        cbTraSuaMatcha = new JCheckBox("Tra Sua Thach Macho(30000)");

        sp.add(cbBanhTrang);
        sp.add(cbTraSuaTranChau);
        sp.add(cbKhoaiTay);
        sp.add(cbTraSuaMatcha);

        main.add(info);
        main.add(sp);

        return main;
    }

    private JPanel panelCenter() {
        JPanel main = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createTitledBorder("Thao tac dat hang"));

        JButton btnDatHang = new JButton("DatHang");
        JButton btnThoat = new JButton("Thoat");
        JButton btnXoa = new JButton("XoaSP");
        JButton btnThanhToan = new JButton("ThanhToan");

        buttons.add(btnDatHang);
        buttons.add(btnThoat);
        buttons.add(btnXoa);
        buttons.add(btnThanhToan);

        model = new DefaultTableModel();
        model.addColumn("STT");
        model.addColumn("Ten San Pham");
        model.addColumn("Don Gia");

        table = new JTable(model);

        btnDatHang.addActionListener(e -> datHang());
        btnXoa.addActionListener(e -> xoaSP());
        btnThanhToan.addActionListener(e -> tinhTong());
        btnThoat.addActionListener(e -> System.exit(0));

        main.add(buttons, BorderLayout.NORTH);
        main.add(new JScrollPane(table), BorderLayout.CENTER);

        return main;
    }

    private JPanel panelTongTien() {
        JPanel p = new JPanel(new GridLayout(2, 1));
        p.setBorder(BorderFactory.createTitledBorder("Tong so tien can thanh toan"));

        lblTong = new JLabel("0.0");
        p.add(lblTong);

        return p;
    }

    private void datHang() {
        if (txtHoTen.getText().isEmpty()
                || txtDiaChi.getText().isEmpty()
                || txtSDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap day du thong tin khach hang!");
            return;
        }

        if (cbBanhTrang.isSelected()) {
            themSP("Banh Trang Tron", 15000);
        }
        if (cbKhoaiTay.isSelected()) {
            themSP("Khoai Tay Chien Bo", 5000);
        }
        if (cbTraSuaTranChau.isSelected()) {
            themSP("Tra Sua Tran Chau", 20000);
        }
        if (cbTraSuaMatcha.isSelected()) {
            themSP("Tra Sua Thach Macho", 30000);
        }

        boChonCheckbox();
        capNhatSTT();
    }

    private void themSP(String ten, int gia) {
        model.addRow(new Object[] {
                model.getRowCount() + 1,
                ten,
                gia
        });
    }

    private void xoaSP() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui long chon san pham can xoa!");
            return;
        }

        model.removeRow(row);
        capNhatSTT();
        tinhTong();
    }

    private void tinhTong() {
        int tong = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            tong += Integer.parseInt(model.getValueAt(i, 2).toString());
        }

        lblTong.setText(String.valueOf(tong));
    }

    private void capNhatSTT() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
    }

    private void boChonCheckbox() {
        cbBanhTrang.setSelected(false);
        cbKhoaiTay.setSelected(false);
        cbTraSuaTranChau.setSelected(false);
        cbTraSuaMatcha.setSelected(false);
    }

    public static void main(String[] args) {
        new Bai26();
    }
}