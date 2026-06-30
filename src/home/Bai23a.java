package home;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bai23a extends JFrame {
    Color currentColor = Color.RED;
    JRadioButton jRadioButtonSquare,
            jRadioButtonOval,
            jRadioButtonFill,
            jRadioButtonOutLine;
    JPanel jPanelCenter;

    public Bai23a() {
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        setLayout(new BorderLayout());
        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setBackground(Color.pink);
        JButton buttonRed = new JButton("Red");
        buttonRed.setBackground(Color.RED);
        buttonRed.addActionListener(e -> currentColor = Color.RED);
        JButton buttonBlue = new JButton("Blue");
        buttonBlue.addActionListener(e -> currentColor = Color.BLUE);
        buttonBlue.setBackground(Color.blue);
        jRadioButtonSquare = new JRadioButton("Square");
        jRadioButtonOval = new JRadioButton("Oval");
        jRadioButtonFill = new JRadioButton("Fill");
        jRadioButtonOutLine = new JRadioButton("OutLine");
        jPanelNorth.add(buttonRed);
        jPanelNorth.add(buttonBlue);
        jPanelNorth.add(jRadioButtonSquare);
        jPanelNorth.add(jRadioButtonOval);
        jPanelNorth.add(jRadioButtonFill);
        jPanelNorth.add(jRadioButtonOutLine);
        ButtonGroup buttonGroupColor = new ButtonGroup();
        buttonGroupColor.add(buttonRed);
        buttonRed.setSelected(true);
        buttonGroupColor.add(buttonBlue);
        ButtonGroup buttonGroupShape = new ButtonGroup();
        buttonGroupShape.add(jRadioButtonSquare);
        jRadioButtonSquare.setSelected(true);
        buttonGroupShape.add(jRadioButtonOval);
        ButtonGroup buttonGroupStyle = new ButtonGroup();
        buttonGroupStyle.add(jRadioButtonFill);
        jRadioButtonFill.setSelected(true);
        buttonGroupStyle.add(jRadioButtonOutLine);
        add(jPanelNorth, BorderLayout.NORTH);

        JPanel jPanelSouth = new JPanel();
        jPanelSouth.setBackground(Color.pink);
        JButton buttonClear = new JButton("Clear");
        jPanelSouth.add(buttonClear);
        add(jPanelSouth, BorderLayout.WEST);

        jPanelCenter = new JPanel();
        jPanelCenter.setBackground(Color.yellow);
        ComponentWraggler componentWraggler = new ComponentWraggler();
        jPanelCenter.addMouseListener(componentWraggler);
        jPanelCenter.addMouseMotionListener(componentWraggler);
        add(jPanelCenter, BorderLayout.CENTER);
    }

    public class ComponentWraggler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            drawShape(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            drawShape(e);
        }

        private void drawShape(MouseEvent e) {
            Graphics g = jPanelCenter.getGraphics();
            g.setColor(currentColor);
            int x = e.getX();
            int y = e.getY();
            if (jRadioButtonFill.isSelected()) {
                if (jRadioButtonSquare.isSelected()) {
                    g.fillRect(x, y, 10, 10);
                }
                if (jRadioButtonOval.isSelected()) {
                    g.fillOval(x, y, 10, 10);
                }
            }
            if (jRadioButtonOutLine.isSelected()) {
                if (jRadioButtonSquare.isSelected()) {
                    g.drawRect(x, y, 10, 10);
                }
                if (jRadioButtonOval.isSelected()) {
                    g.drawOval(x, y, 10, 10);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai23a::new);
    }
}
