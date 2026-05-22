package lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Lab9 extends JFrame {

    private static final long serialVersionUID = 1L;

    private Color currentColor = Color.RED;
    private int currentShape = 1; 
    private final List<ShapeData> shapes = new ArrayList<>();
    private int startX, startY, endX, endY;
    private boolean isDragging = false;

    private JPanel centerPanel;

    // Shape data
    private static class ShapeData {
        int type;
        int x1, y1, x2, y2;
        Color color;

        ShapeData(int type, int x1, int y1, int x2, int y2, Color color) {
            this.type = type;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }
    }

    public Lab9() {
        setTitle("Shape Drawer");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(createToolbar(), BorderLayout.NORTH);
        centerPanel = createDrawingPanel();
        add(centerPanel, BorderLayout.CENTER);
        setJMenuBar(createMenuBar());

        addMouseHandlers();

        setVisible(true);
    }

    // ------------------------
    // Toolbar
    // ------------------------
    private JToolBar createToolbar() {
        JToolBar toolbar = new JToolBar();
        ButtonGroup colorGroup = new ButtonGroup();

        toolbar.add(createColorButton("Red", Color.RED, colorGroup, true));
        toolbar.add(createColorButton("Blue", Color.BLUE, colorGroup, false));
        toolbar.add(createColorButton("Yellow", Color.YELLOW, colorGroup, false));

        return toolbar;
    }

    private JRadioButton createColorButton(String name, Color color, ButtonGroup group, boolean selected) {
        JRadioButton btn = new JRadioButton(name, selected);
        btn.setFocusPainted(false);
        btn.addActionListener(e -> currentColor = color);
        group.add(btn);
        return btn;
    }

    // ------------------------
    // Drawing panel
    // ------------------------
    private JPanel createDrawingPanel() {
        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawAllShapes(g);
            }
        };
        panel.setBackground(Color.LIGHT_GRAY);
        return panel;
    }

    private void drawAllShapes(Graphics g) {
        for (ShapeData s : shapes) {
            g.setColor(s.color);
            drawShape(g, s.type, s.x1, s.y1, s.x2, s.y2);
        }
        if (isDragging) {
            g.setColor(currentColor);
            drawShape(g, currentShape, startX, startY, endX, endY);
        }
    }

    private void drawShape(Graphics g, int type, int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);

        switch (type) {
            case 1 -> g.drawRect(x, y, width, height); // Rectangle
            case 2 -> g.drawOval(x, y, width, height); // Circle
            case 3 -> g.drawLine(x1, y1, x2, y2);     // Line
        }
    }

    // ------------------------
    // Menu bar
    // ------------------------
    private JMenuBar createMenuBar() {
        JMenuBar menubar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Shape menu
        JMenu shapeMenu = new JMenu("Shape");
        shapeMenu.setMnemonic(KeyEvent.VK_S);

        JMenuItem rectItem = new JMenuItem("Rectangle");
        JMenuItem circleItem = new JMenuItem("Circle");
        JMenuItem lineItem = new JMenuItem("Line");

        rectItem.addActionListener(e -> currentShape = 1);
        circleItem.addActionListener(e -> currentShape = 2);
        lineItem.addActionListener(e -> currentShape = 3);

        shapeMenu.add(rectItem);
        shapeMenu.add(circleItem);
        shapeMenu.add(lineItem);

        menubar.add(fileMenu);
        menubar.add(shapeMenu);

        return menubar;
    }

    // ------------------------
    // Mouse handlers
    // ------------------------
    private void addMouseHandlers() {
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                endX = startX;
                endY = startY;
                isDragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isDragging) {
                    endX = e.getX();
                    endY = e.getY();
                    shapes.add(new ShapeData(currentShape, startX, startY, endX, endY, currentColor));
                    isDragging = false;
//                    centerPanel.repaint();
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                centerPanel.repaint();
            }
        };
        centerPanel.addMouseListener(mouseHandler);
        centerPanel.addMouseMotionListener(mouseHandler);
    }

    // ------------------------
    // Main
    // ------------------------
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab9::new);
    }
}