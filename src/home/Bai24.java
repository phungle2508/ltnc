package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Bai24 extends JFrame {
    public Bai24() {
        setTitle("Draw Shapes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        DrawPanel panel = new DrawPanel();
        add(panel);

        setVisible(true);
    }

    static class ShapeInfo {
        int x1, y1, x2, y2;
        String type;

        ShapeInfo(int x1, int y1, int x2, int y2, String type) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.type = type;
        }
    }

    static class DrawPanel extends JPanel {
        ArrayList<ShapeInfo> shapes = new ArrayList<>();

        int startX, startY, currentX, currentY;
        boolean drawing = false;
        String currentType = "line";

        DrawPanel() {
            setBackground(Color.WHITE);

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

                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    if (drawing) {
                        currentX = e.getX();
                        currentY = e.getY();
                        repaint();
                    }
                }
            };

            addMouseListener(mouse);
            addMouseMotionListener(mouse);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (ShapeInfo s : shapes) {
                drawShape(g, s.x1, s.y1, s.x2, s.y2, s.type);
            }

            if (drawing) {
                g.setColor(Color.RED);
                drawShape(g, startX, startY, currentX, currentY, currentType);
            }
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
                    int size = Math.min(w, h);
                    g.drawOval(x, y, size, size);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai24::new);
    }
}