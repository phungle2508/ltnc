package lab10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Lab10 extends JFrame {

	private static final Map<String, Double> products = new LinkedHashMap<>();

	private final Map<JCheckBox, Double> checkBoxMap = new LinkedHashMap<>();

	private DefaultTableModel model;

	private JLabel totalLabel;

	public Lab10() {

		setTitle("Mua Hang Online");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout(10, 10));

		// ================= NORTH =================

		JPanel northPanel = new JPanel(new GridLayout(1, 2, 10, 10));

		JPanel customerPanel = new JPanel(new GridLayout(3, 2, 5, 5));

		customerPanel.setBorder(BorderFactory.createTitledBorder("Thong tin khach hang"));

		customerPanel.add(new JLabel("Ho va ten:"));
		customerPanel.add(new JTextField());

		customerPanel.add(new JLabel("Dia chi:"));
		customerPanel.add(new JTextField());

		customerPanel.add(new JLabel("So dien thoai:"));
		customerPanel.add(new JTextField());

		JPanel productPanel = new JPanel(new GridLayout(4, 1, 5, 5));

		productPanel.setBorder(BorderFactory.createTitledBorder("Chon san pham"));

		for (Map.Entry<String, Double> entry : products.entrySet()) {

			JCheckBox checkBox = new JCheckBox(entry.getKey() + String.format(" (%.0f)", entry.getValue()));

			checkBoxMap.put(checkBox, entry.getValue());

			productPanel.add(checkBox);
		}

		northPanel.add(customerPanel);
		northPanel.add(productPanel);

		// ================= CENTER =================

		JPanel centerPanel = new JPanel(new BorderLayout());

		centerPanel.setBorder(BorderFactory.createTitledBorder("Danh sach Don Hang"));

		String[] columns = { "STT", "Ten san pham", "Don gia" };

		model = new DefaultTableModel(columns, 0);

		JTable table = new JTable(model);

		centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);

		totalLabel = new JLabel();

		updateTotal();

		centerPanel.add(totalLabel, BorderLayout.SOUTH);

		// ================= SOUTH =================

		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

		JButton btnOrder = new JButton("Dat Hang");

		btnOrder.addActionListener(e -> orderProducts());

		JButton btnDelete = new JButton("Xoa San Pham");

		btnDelete.addActionListener(e -> {

			int row = table.getSelectedRow();

			if (row != -1) {

				model.removeRow(row);

				updateTotal();
			}
		});

		JButton btnExit = new JButton("Thoat");

		btnExit.addActionListener(e -> dispose());

		southPanel.add(btnOrder);
		southPanel.add(btnDelete);
		southPanel.add(btnExit);

		// ================= FRAME =================

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	private void orderProducts() {

		for (Map.Entry<JCheckBox, Double> entry : checkBoxMap.entrySet()) {

			JCheckBox checkBox = entry.getKey();

			if (!checkBox.isSelected()) {
				continue;
			}

			model.addRow(
					new Object[] { model.getRowCount() + 1, checkBox.getText().split("\\(")[0], entry.getValue() });

			checkBox.setSelected(false);
		}

		updateTotal();
	}

	private void updateTotal() {

		double total = 0;

		for (int i = 0; i < model.getRowCount(); i++) {

			total += ((Number) model.getValueAt(i, 2)).doubleValue();
		}

		totalLabel.setText(String.format("Tong so tien can thanh toan: %.0f VND", total));
	}

	public static void main(String[] args) {

		products.put("Banh Tran Tron", 15000.0);
		products.put("Khoai Tay Chien", 10000.0);
		products.put("Tra Sua Tran Chau", 20000.0);
		products.put("Tra Sua Matcha", 30000.0);

		SwingUtilities.invokeLater(Lab10::new);
	}
}