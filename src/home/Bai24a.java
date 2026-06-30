package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Bai24a extends JFrame {
    class ShapeInfo {
        int x1, y1, x2, y2;
        String type;

        public ShapeInfo(int x1, int y1, int x2, int y2, String type) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.type = type;
        }
    }

    List<ShapeInfo> shapes = new ArrayList<>();

    int startX, startY, currentX, currentY;
    boolean drawing = false;
    String currentType = "line";

    public Bai24a() {
        setTitle("Draw Shapes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        add(drawPanel());

        setVisible(true);
    }

    private JPanel drawPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLACK);
                for (ShapeInfo s : shapes) {
                    drawShape(g, s.x1, s.y1, s.x2, s.y2, s.type);
                }

                if (drawing) {
                    g.setColor(Color.RED);
                    drawShape(g, startX, startY, currentX, currentY, currentType);
                }
            }
        };

        panel.setBackground(Color.WHITE);

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!drawing) {
                    startX = e.getX();
                    startY = e.getY();
                    currentX = startX;
                    currentY = startY;

                    if (e.isShiftDown()) {
                        currentType = "line";
                    } else if (e.isControlDown()) {
                        currentType = "circle";
                    } else if (e.isAltDown()) {
                        currentType = "rect";
                    }

                    drawing = true;
                } else {
                    shapes.add(new ShapeInfo(startX, startY, currentX, currentY, currentType));
                    drawing = false;
                }

                panel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (drawing) {
                    currentX = e.getX();
                    currentY = e.getY();
                    panel.repaint();
                }
            }
        };

        panel.addMouseListener(mouse);
        panel.addMouseMotionListener(mouse);

        return panel;
    }

    private void drawShape(Graphics g, int x1, int y1, int x2, int y2, String type) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int w = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);

        switch (type) {
            case "line":
                g.drawLine(x1, y1, x2, y2);
                break;
            case "rect":
                g.drawRect(x, y, w, h);
                break;
            case "circle":
                int radius = (int) Math.sqrt(
                        Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                g.drawOval(
                        x1 - radius,
                        y1 - radius,
                        radius * 2,
                        radius * 2);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai24a::new);
    }
}