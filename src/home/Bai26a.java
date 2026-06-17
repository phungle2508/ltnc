package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Bai26a extends JFrame {
    JTextField jTextFieldAddress, jTextFieldName, jTextFieldPhoneNumber;
    JCheckBox jCheckBoxBanhTrangTron, jCheckBoxTraSuaTranChau, jCheckBoxKhoaiTayChienBo, jCheckBoxTraSuaThachMacho;
    JTable jTable;
    DefaultTableModel model;
    JLabel jLabelTotal;

    public Bai26a() {
        setTitle("Mua ban hang online");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        add(panelNorth(), BorderLayout.NORTH);
        add(panelCenter(), BorderLayout.CENTER);
        add(panelSouth(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel panelNorth() {
        JPanel jPanelInfo = new JPanel(new GridLayout(3, 2));
        jPanelInfo.setBorder(BorderFactory.createTitledBorder("Thong Tin Khach Hang"));
        jPanelInfo.add(new JLabel("Ho va ten"));
        jTextFieldName = new JTextField();
        jTextFieldName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jPanelInfo.add(jTextFieldName);

        jPanelInfo.add(new JLabel("Dia chi"));
        jTextFieldAddress = new JTextField();
        jTextFieldAddress.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jPanelInfo.add(jTextFieldAddress);

        jPanelInfo.add(new JLabel("So dien thoai"));
        jTextFieldPhoneNumber = new JTextField();
        jTextFieldPhoneNumber.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jPanelInfo.add(jTextFieldPhoneNumber);

        return jPanelInfo;
    }

    private JPanel panelCenter() {
        JPanel panelCenter = new JPanel(new BorderLayout());
        JPanel jPanelNorth = new JPanel(new GridLayout(2, 1));
        JPanel jPanelChonSanPham = new JPanel(new GridLayout(2, 2));
        jPanelChonSanPham.setBorder(BorderFactory.createTitledBorder("Chon san pham"));
        jCheckBoxBanhTrangTron = new JCheckBox("Banh trang tron");
        jCheckBoxTraSuaTranChau = new JCheckBox("Tra sua tran chau");
        jCheckBoxKhoaiTayChienBo = new JCheckBox("Khoai tay chien bo");
        jCheckBoxTraSuaThachMacho = new JCheckBox("Tra sua thach macho");

        jPanelChonSanPham.add(jCheckBoxBanhTrangTron);
        jPanelChonSanPham.add(jCheckBoxTraSuaTranChau);
        jPanelChonSanPham.add(jCheckBoxKhoaiTayChienBo);
        jPanelChonSanPham.add(jCheckBoxTraSuaThachMacho);
        jPanelNorth.add(jPanelChonSanPham);

        JPanel jPanelThaoTacDatHang = new JPanel();
        jPanelThaoTacDatHang.setBorder(BorderFactory.createTitledBorder("Thao tac dat hang"));
        JButton jButtonDatHang = new JButton("DatHang");
        jButtonDatHang.addActionListener(e -> datHang());
        JButton jButtonThoat = new JButton("Thoat");
        jButtonThoat.addActionListener(e -> thoat());
        JButton jButtonXoaSanPham = new JButton("Xoa SP");
        jButtonXoaSanPham.addActionListener(e -> xoaSP());
        JButton jButtonThanhToan = new JButton("ThanhToan");
        jButtonThanhToan.addActionListener(e -> thanhToan());

        jPanelThaoTacDatHang.add(jButtonDatHang);
        jPanelThaoTacDatHang.add(jButtonThoat);
        jPanelThaoTacDatHang.add(jButtonXoaSanPham);
        jPanelThaoTacDatHang.add(jButtonThanhToan);

        jPanelNorth.add(jPanelThaoTacDatHang);
        panelCenter.add(jPanelNorth, BorderLayout.NORTH);

        String[] titleName = new String[] { "STT", "Ten San Pham", "Don Gia" };
        model = new DefaultTableModel(titleName, 0);
        jTable = new JTable(model);
        panelCenter.add(new JScrollPane(jTable), BorderLayout.CENTER);
        return panelCenter;
    }

    private JPanel panelSouth() {
        JPanel jPanelTotal = new JPanel(new GridLayout(2, 1));
        jPanelTotal.setBorder(BorderFactory.createTitledBorder("Tong so tien can thanh toan"));
        jLabelTotal = new JLabel("0.0");
        jPanelTotal.add(jLabelTotal);
        return jPanelTotal;
    }

    private void thanhToan() {
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            total += (int) model.getValueAt(i, 2);
        }
        jLabelTotal.setText(total + "");
        JOptionPane.showMessageDialog(this, "Tong so tien can thanh toan la " + total);
    }

    private void xoaSP() {
        int row = jTable.getSelectedRow();
        model.removeRow(row);
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i, i, 0);
        }
    }

    private void thoat() {
        int result = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon thoat ko", "Thoat",
                JOptionPane.YES_OPTION,
                JOptionPane.CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void datHang() {
        if (jTextFieldAddress.getText().isEmpty() || jTextFieldName.getText().isEmpty() || jTextFieldPhoneNumber
                .getText().isEmpty()) {
            return;
        }

        if (jCheckBoxBanhTrangTron.isSelected()) {
            model.addRow(new Object[] { model.getRowCount() + 1, "Banh trang tron", 3500 });
        }
        if (jCheckBoxTraSuaTranChau.isSelected()) {
            model.addRow(new Object[] { model.getRowCount() + 1, "Tra sua tran chau", 3500 });
        }
        if (jCheckBoxKhoaiTayChienBo.isSelected()) {
            model.addRow(new Object[] { model.getRowCount() + 1, "Khoai tay chien bo", 3500 });
        }
        if (jCheckBoxTraSuaThachMacho.isSelected()) {
            model.addRow(new Object[] { model.getRowCount() + 1, "tra sua thanh macho", 3500 });
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai26a::new);
    }
}