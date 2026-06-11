package lab.lab8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class Lab8 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color currentColor = Color.RED;

	public Lab8() {
		setTitle("BorderLayout Example");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// BorderLayout is default for JFrame content pane
		setLayout(new BorderLayout(10, 10));

		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.pink);
		// Red button
		JButton redBtn = new JButton("Red");
		redBtn.setBackground(Color.RED);
		redBtn.setForeground(Color.WHITE);
		redBtn.setFocusPainted(false);

		// Blue button
		JButton blueBtn = new JButton("Blue");
		blueBtn.setBackground(Color.BLUE);
		blueBtn.setForeground(Color.WHITE);
		blueBtn.setFocusPainted(false);

		// Radio buttons with borders
		JRadioButton square = new JRadioButton("Square");
		JRadioButton oval = new JRadioButton("Oval");
		JRadioButton fill = new JRadioButton("Fill");
		JRadioButton outline = new JRadioButton("Outline");

		ButtonGroup shapeGroup = new ButtonGroup();
		shapeGroup.add(square);
		shapeGroup.add(oval);

		// Group: Fill OR Outline
		ButtonGroup styleGroup = new ButtonGroup();
		styleGroup.add(fill);
		styleGroup.add(outline);

		// Default selections
		square.setSelected(true);
		fill.setSelected(true);
		// Add to panel
		northPanel.add(redBtn);
		northPanel.add(blueBtn);
		northPanel.add(square);
		northPanel.add(oval);
		northPanel.add(fill);
		northPanel.add(outline);

		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.pink);

		JButton clearAll = new JButton("Clear All");
		westPanel.add(clearAll);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.YELLOW);

		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);

		redBtn.addActionListener(e -> currentColor = Color.RED);

		blueBtn.addActionListener(e -> currentColor = Color.BLUE);
		ComponentWrangler handler = new ComponentWrangler(centerPanel, square, oval, fill, outline);
		centerPanel.addMouseMotionListener(handler);
		centerPanel.addMouseListener(handler);
		// Clear drawings
		clearAll.addActionListener(e -> {
			centerPanel.repaint();
		});

		setVisible(true);
	}

	private class ComponentWrangler extends MouseInputAdapter {

		private JPanel centerPanel;
		
		private JRadioButton square;
		private JRadioButton oval;

		private JRadioButton fill;

		public ComponentWrangler(JPanel centerPanel, JRadioButton square, JRadioButton oval, JRadioButton fill,
				JRadioButton outline) {

			this.centerPanel = centerPanel;
			this.square = square;
			this.oval = oval;
			this.fill = fill;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			drawShape(e);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			drawShape(e);
		}

		private void drawShape(MouseEvent e) {

			Graphics g = centerPanel.getGraphics();
			g.setColor(currentColor);
			int x = e.getX();
			int y = e.getY();

			if (square.isSelected()) {

				if (fill.isSelected()) {
					g.fillRect(x, y, 10, 10);
				} else {
					g.drawRect(x, y, 10, 10);
				}
			}

			if (oval.isSelected()) {

				if (fill.isSelected()) {
					g.fillOval(x, y, 10, 10);
				} else {
					g.drawOval(x, y, 10, 10);
				}
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Lab8::new);
	}
}