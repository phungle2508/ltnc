package home.bai27a;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Bai27 extends JFrame {
    SchoolManage schoolManage = new SchoolManage(new ArrayList<>());
    JPanel cardPanel;
    CardLayout cardLayout;
    JTextField courseJTextFieldStudentID, courseJTextFieldStudentName, courseJTextFieldCourseID,
            courseJTextFieldCourseName;
    JComboBox<String> gradeJComboBoxCoursesName = new JComboBox<>();
    JTextField gradeJTextFieldStudentID,
            gradeJTextFieldStudentName,
            gradeJTextFieldGrade;

    DefaultTableModel courseDefaultTableModel, gradeDefaultTableModel;
    JTable courseJTable, gradeJTable;

    public Bai27() {
        setVisible(true);
        setTitle("Khoa CNTT");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(menuBar(), BorderLayout.NORTH);
        cardPanel = cardPanel();
        add(cardPanel, BorderLayout.CENTER);
    }

    private JMenuBar menuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        JMenuItem jMenuFileItemExit = new JMenuItem("Exit");
        jMenuFile.add(jMenuFileItemExit);
        menuBar.add(jMenuFile);

        JMenu jMenuInfoManage = new JMenu("Quan Ly Sinh Vien");
        JMenuItem jMenuInfoManageItemCourse = new JMenuItem("Quan Ly Mon Hoc");
        jMenuInfoManageItemCourse.addActionListener(e -> cardLayout.show(cardPanel, "Course"));
        JMenuItem jMenuInfoManageItemGrade = new JMenuItem("Quan Ly Diem");
        jMenuInfoManageItemGrade.addActionListener(e -> cardLayout.show(cardPanel, "Grade"));
        jMenuInfoManage.add(jMenuInfoManageItemCourse);
        jMenuInfoManage.add(jMenuInfoManageItemGrade);
        menuBar.add(jMenuInfoManage);
        return menuBar;
    }

    private JPanel cardPanel() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(mainPanel(), "Main");
        cardPanel.add(coursePanel(), "Course");
        cardPanel.add(gradePanel(), "Grade");
        return cardPanel;

    }

    private JPanel coursePanel() {
        JPanel coursePanel = new JPanel(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());

        JPanel jPanelADD = new JPanel(new GridLayout(4, 2));
        jPanelADD.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Them Mon Hoc"),
                BorderFactory.createEmptyBorder(0, 100, 0, 100)));
        JLabel jLabelMSSV = new JLabel("MSSV");
        courseJTextFieldStudentID = new JTextField();
        JLabel jLabelHoVaTen = new JLabel("Ho Va Ten");
        courseJTextFieldStudentName = new JTextField();
        JLabel jLabelMaMonHoc = new JLabel("Ma Mon Hoc");
        courseJTextFieldCourseID = new JTextField();
        JLabel jLabelTenMonHoc = new JLabel("Ten Mon Hoc");
        courseJTextFieldCourseName = new JTextField();
        jPanelADD.add(jLabelMSSV);
        jPanelADD.add(courseJTextFieldStudentID);
        jPanelADD.add(jLabelHoVaTen);
        jPanelADD.add(courseJTextFieldStudentName);
        jPanelADD.add(jLabelMaMonHoc);
        jPanelADD.add(courseJTextFieldCourseID);
        jPanelADD.add(jLabelTenMonHoc);
        jPanelADD.add(courseJTextFieldCourseName);
        northPanel.add(jPanelADD, BorderLayout.NORTH);

        JPanel jPanelAction = new JPanel();
        jPanelAction.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Thao Tac"),
                BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        JButton buttonADD = new JButton("Them Mon Hoc");
        buttonADD.addActionListener(e -> courseAddStudent());
        JButton buttonFind = new JButton("Tim Sinh Vien");
        buttonFind.addActionListener(e -> courseFindStudent());
        jPanelAction.add(buttonADD);
        jPanelAction.add(buttonFind);
        northPanel.add(jPanelAction, BorderLayout.CENTER);
        coursePanel.add(northPanel, BorderLayout.NORTH);

        courseDefaultTableModel = new DefaultTableModel(new String[] { "STT", "Ten Mon Hoc", "Diem" }, 0);
        courseJTable = new JTable(courseDefaultTableModel);
        coursePanel.add(new JScrollPane(courseJTable), BorderLayout.CENTER);
        return coursePanel;

    }

    private void courseAddStudent() {
        boolean ifStudentAddOrCourseAddSuccess = schoolManage.studentAddOrCourseAdd(courseJTextFieldStudentID.getText(),
                courseJTextFieldStudentName
                        .getText(),
                courseJTextFieldCourseID.getText(), courseJTextFieldCourseName.getText());
        if (ifStudentAddOrCourseAddSuccess) {
            JOptionPane.showConfirmDialog(this, "Thanh Cong");
            courseFindStudent();

        } else {
            JOptionPane.showConfirmDialog(this, "That Bai");
        }
    }

    private void courseFindStudent() {
        Student studentFound = schoolManage.findStudent(courseJTextFieldStudentID.getText());
        if (studentFound == null) {
            JOptionPane.showConfirmDialog(this, "Khong tim thay sinh vien");
        } else {
            courseDefaultTableModel.setRowCount(0);
            gradeJComboBoxCoursesName.removeAllItems();
            for (Course course : studentFound.getCourse()) {
                courseDefaultTableModel.addRow(new String[] { course.getId(), course.getName(),
                        course.getGrade() + "" });
                gradeJComboBoxCoursesName.addItem((course.getName()));
            }
        }
    }

    private void gradeAddGrade() {
        boolean ifGradeAddSuccess = schoolManage.addGrade(gradeJTextFieldStudentID.getText(),
                gradeJComboBoxCoursesName
                        .getSelectedItem().toString(),

                gradeJTextFieldGrade.getText());
        if (ifGradeAddSuccess) {
            JOptionPane.showConfirmDialog(this, "Thanh Cong");
            gradeFindStudent();
        } else {
            JOptionPane.showConfirmDialog(this, "That Bai");
        }
    }

    private void gradeFindStudent() {
        Student studentFound = schoolManage.findStudent(gradeJTextFieldStudentID.getText());
        if (studentFound == null) {
            JOptionPane.showConfirmDialog(this, "Khong tim thay sinh vien");
        } else {
            gradeDefaultTableModel.setRowCount(0);
            for (Course course : studentFound.getCourse()) {
                gradeDefaultTableModel.addRow(new String[] { course.getId(), course.getName(),
                        course.getGrade() + "" });
            }
        }
    }

    private JPanel gradePanel() {
        JPanel gradePanel = new JPanel(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());

        JPanel jPanelADD = new JPanel(new GridLayout(4, 2));
        jPanelADD.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Them Diem"),
                BorderFactory.createEmptyBorder(0, 100, 0, 100)));
        JLabel jLabelMSSV = new JLabel("MSSV");
        gradeJTextFieldStudentID = new JTextField();
        JLabel jLabelHoVaTen = new JLabel("Ho Va Ten");
        gradeJTextFieldStudentName = new JTextField();
        JLabel jLabelTenMonHoc = new JLabel("Ten Mon Hoc");
        gradeJComboBoxCoursesName = new JComboBox<>(schoolManage.getAllCoursesName());
        JLabel jLabelDiem = new JLabel("Diem");
        gradeJTextFieldGrade = new JTextField();
        jPanelADD.add(jLabelMSSV);
        jPanelADD.add(gradeJTextFieldStudentID);
        jPanelADD.add(jLabelHoVaTen);
        jPanelADD.add(gradeJTextFieldStudentName);
        jPanelADD.add(jLabelTenMonHoc);
        jPanelADD.add(gradeJComboBoxCoursesName);
        jPanelADD.add(jLabelDiem);
        jPanelADD.add(gradeJTextFieldGrade);
        northPanel.add(jPanelADD, BorderLayout.NORTH);

        JPanel jPanelAction = new JPanel();
        jPanelAction.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Thao Tac"),
                BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        JButton buttonADD = new JButton("Them Mon Hoc");
        buttonADD.addActionListener(e -> gradeAddGrade());
        JButton buttonFind = new JButton("Tim Sinh Vien");
        buttonFind.addActionListener(e -> gradeFindStudent());
        jPanelAction.add(buttonADD);
        jPanelAction.add(buttonFind);
        northPanel.add(jPanelAction, BorderLayout.CENTER);
        gradePanel.add(northPanel, BorderLayout.NORTH);

        gradeDefaultTableModel = new DefaultTableModel(new String[] { "STT", "Ten Mon Hoc", "Diem" }, 0);
        gradeJTable = new JTable(gradeDefaultTableModel);
        gradePanel.add(new JScrollPane(gradeJTable), BorderLayout.CENTER);
        return gradePanel;

    }

    private JPanel mainPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel jLabel = new JLabel("Quan Ly Sinh Vien K.CNTT");
        mainPanel.add(jLabel, BorderLayout.CENTER);
        jLabel.setHorizontalAlignment(SwingUtilities.CENTER);
        return mainPanel;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Bai27::new);
    }
}
