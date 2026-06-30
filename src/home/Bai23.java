package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class Bai23 extends JFrame {
    private Color currentColor = Color.RED;

    public Bai23() {
        setTitle("asd");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        setLayout(new BorderLayout());

        JPanel jPanelNorth = new JPanel(new FlowLayout());
        jPanelNorth.setBackground(Color.pink);
        JButton buttonRed = new JButton("Red");
        buttonRed.setBackground(Color.red);
        buttonRed.addActionListener(e -> currentColor = Color.RED);
        JButton buttonBlue = new JButton("Blue");
        buttonBlue.setBackground(Color.blue);
        buttonBlue.addActionListener(e -> currentColor = Color.BLUE);
        jPanelNorth.add(buttonRed);
        jPanelNorth.add(buttonBlue);

        JRadioButton jRadioButtonSquare = new JRadioButton("Square");
        JRadioButton jRadioButtonOval = new JRadioButton("Oval");

        ButtonGroup buttonGroupShape = new ButtonGroup();
        buttonGroupShape.add(jRadioButtonSquare);
        buttonGroupShape.add(jRadioButtonOval);

        JRadioButton jRadioButtonFill = new JRadioButton("Fill");
        JRadioButton jRadioButtonOutLine = new JRadioButton("OutLine");

        ButtonGroup buttonGroupStyle = new ButtonGroup();
        buttonGroupStyle.add(jRadioButtonFill);
        buttonGroupStyle.add(jRadioButtonOutLine);

        jRadioButtonSquare.setSelected(true);
        jRadioButtonFill.setSelected(true);

        jPanelNorth.add(jRadioButtonSquare);
        jPanelNorth.add(jRadioButtonOval);
        jPanelNorth.add(jRadioButtonFill);
        jPanelNorth.add(jRadioButtonOutLine);

        JPanel jPanelWest = new JPanel();
        JButton buttonClearAll = new JButton("Clear All");

        jPanelWest.setBackground(Color.pink);
        jPanelWest.add(buttonClearAll);

        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setBackground(Color.yellow);
        ComponentWraggler componentWraggler = new ComponentWraggler(jPanelCenter, jRadioButtonSquare, jRadioButtonOval,
                jRadioButtonFill, jRadioButtonOutLine);
        jPanelCenter.addMouseListener(componentWraggler);
        jPanelCenter.addMouseMotionListener(componentWraggler);
        add(jPanelNorth, BorderLayout.NORTH);
        add(jPanelWest, BorderLayout.WEST);
        add(jPanelCenter, BorderLayout.CENTER);
    }

    private class ComponentWraggler extends MouseInputAdapter {
        JPanel jPanelCenter;
        JRadioButton jRadioButtonSquare;
        JRadioButton jRadioButtonOval;
        JRadioButton jRadioButtonFill;
        JRadioButton jRadioButtonOutLine;

        public ComponentWraggler(JPanel jPanelCenter, JRadioButton jRadioButtonSquare, JRadioButton jRadioButtonOval,
                JRadioButton jRadioButtonFill, JRadioButton jRadioButtonOutLine) {
            this.jPanelCenter = jPanelCenter;
            this.jRadioButtonFill = jRadioButtonFill;
            this.jRadioButtonOutLine = jRadioButtonOutLine;
            this.jRadioButtonSquare = jRadioButtonSquare;
            this.jRadioButtonOval = jRadioButtonOval;
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
            Graphics g = jPanelCenter.getGraphics();
            g.setColor(currentColor);
            int x = e.getX();
            int y = e.getY();

            if (jRadioButtonSquare.isSelected()) {
                if (jRadioButtonFill.isSelected()) {
                    g.fillRect(x, y, 10, 10);
                } else {
                    g.drawRect(x, y, 10, 10);
                }
            }
            if (jRadioButtonOval.isSelected()) {
                if (jRadioButtonFill.isSelected()) {
                    g.fillOval(x, y, 10, 10);
                } else {
                    g.drawOval(x, y, 10, 10);
                }
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai23::new);
    }
}