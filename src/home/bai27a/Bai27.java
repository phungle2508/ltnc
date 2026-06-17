package home.bai27a;

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

import home.bai27a.model.Course;
import home.bai27a.model.SchoolManage;
import home.bai27a.model.Student;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Bai27 extends JFrame {
    SchoolManage schoolManage;
    JPanel cardPanel;
    CardLayout cardLayout;
    DefaultTableModel courseModel;
    JTable courseTable;
    JTextField courseJTextFieldStudentID,
            courseJTextFieldStudentName,
            courseJTextFieldCourseID,
            courseJTextFieldCourseName;

    DefaultTableModel gradeModel;
    JTable gradeTable;
    JComboBox<String> gradeJComboBoxCourseNames;
    JTextField gradeJTextFieldStudentID,
            gradeJTextFieldStudentName,
            gradeJTextFieldCourseGrade;

    public Bai27() {
        schoolManage = new SchoolManage(new ArrayList<>());
        setVisible(true);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Khoa Công Nghệ Thông Tin");
        setLayout(new BorderLayout());
        add(toolBarPanel(), BorderLayout.NORTH);
        add(cardPanel(), BorderLayout.CENTER);
    }

    private JMenuBar toolBarPanel() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        JMenuItem jMenuFileItemExit = new JMenuItem("Exit");
        JMenu jMenuInfoManage = new JMenu("Quản lý sinh viên");
        JMenuItem jMenuInfoManageItemCourse = new JMenuItem("Quản lý môn học");
        jMenuInfoManageItemCourse.setMnemonic(KeyEvent.VK_M);
        jMenuInfoManageItemCourse.addActionListener(e -> cardLayout.show(cardPanel, "Course"));
        JMenuItem jMenuInfoManageItemGrade = new JMenuItem("Quản lý điểm");
        jMenuInfoManageItemGrade.setMnemonic(KeyEvent.VK_D);
        jMenuInfoManageItemGrade.setDisplayedMnemonicIndex(8);
        jMenuInfoManageItemGrade.addActionListener(e -> cardLayout.show(cardPanel, "Grade"));
        jMenuFile.add(jMenuFileItemExit);
        jMenuInfoManage.add(jMenuInfoManageItemCourse);
        jMenuInfoManage.add(jMenuInfoManageItemGrade);
        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuInfoManage);
        return jMenuBar;

    }

    private JPanel cardPanel() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(mainPanel(), "Main");
        cardPanel.add(coursePanel(), "Course");
        cardPanel.add(gradePanel(), "Grade");
        return cardPanel;

    }

    private Component gradePanel() {
        JPanel gradePanel = new JPanel(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());
        JPanel jPanelAdd = new JPanel(new GridLayout(4, 2));
        jPanelAdd
                .setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Them Diem"),
                        BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        JLabel jLabelStudentID = new JLabel("MSSV");
        gradeJTextFieldStudentID = new JTextField();
        JLabel jLabelStudentName = new JLabel("Ho Va Ten");
        gradeJTextFieldStudentName = new JTextField();
        JLabel jLabelCourseID = new JLabel("Ma Mon Hoc");
        gradeJComboBoxCourseNames = new JComboBox<>(schoolManage.getAllCourseName());
        JLabel jLabelCourseName = new JLabel("Ten Mon Hoc");
        gradeJTextFieldCourseGrade = new JTextField();
        jPanelAdd.add(jLabelStudentID);
        jPanelAdd.add(gradeJTextFieldStudentID);
        jPanelAdd.add(jLabelStudentName);
        jPanelAdd.add(gradeJTextFieldStudentName);
        jPanelAdd.add(jLabelCourseID);
        jPanelAdd.add(gradeJComboBoxCourseNames);
        jPanelAdd.add(jLabelCourseName);
        jPanelAdd.add(gradeJTextFieldCourseGrade);
        JPanel jPanelAction = new JPanel();
        jPanelAction
                .setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Thao Tac"),
                        BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        JButton buttonAdd = new JButton("Them Diem");
        buttonAdd.addActionListener(e -> gradeAddGrade());
        JButton buttonFind = new JButton("Tim Sinh Vien");
        buttonFind.addActionListener(e -> gradeFindStudent());
        jPanelAction.add(buttonAdd);
        jPanelAction.add(buttonFind);
        northPanel.add(jPanelAdd, BorderLayout.NORTH);
        northPanel.add(jPanelAction, BorderLayout.CENTER);

        gradePanel.add(northPanel, BorderLayout.NORTH);

        gradeModel = new DefaultTableModel(new String[] { "SoTT", "Ten Mon Hoc", "Diem" }, 0);
        gradeTable = new JTable(gradeModel);
        gradePanel.add(new JScrollPane(gradeTable), BorderLayout.CENTER);
        return gradePanel;
    }

    private void gradeFindStudent() {
        Student student = schoolManage.findStudent(gradeJTextFieldStudentID.getText());
        if (student != null) {
            gradeModel.setRowCount(0);
            List<Course> courses = student.getCourses();

            for (int i = 0; i < courses.size(); i++) {
                gradeModel.addRow(new String[] { i + "", courses.get(i).getName(), courses.get(i).getGrade() + "" });
            }
        } else {
            JOptionPane.showConfirmDialog(this, "Khong tim thay sinh vien");
        }
    }

    private void gradeAddGrade() {
        boolean checkIfAddGradeSuccess = schoolManage.addGrade(gradeJTextFieldStudentID.getText(),
                gradeJComboBoxCourseNames.getSelectedItem().toString(), gradeJTextFieldCourseGrade.getText());
        if (checkIfAddGradeSuccess) {
            JOptionPane.showConfirmDialog(this, "Them Diem Thanh Cong");
            gradeFindStudent();
        } else {
            JOptionPane.showConfirmDialog(this, "Them Diem That Bai");
        }
    }

    private Component coursePanel() {
        JPanel coursePanel = new JPanel(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());
        JPanel jPanelAdd = new JPanel(new GridLayout(4, 2));
        jPanelAdd
                .setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Them Mon Hoc"),
                        BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        JLabel jLabelStudentID = new JLabel("MSSV");
        courseJTextFieldStudentID = new JTextField();
        JLabel jLabelStudentName = new JLabel("Ho Va Ten");
        courseJTextFieldStudentName = new JTextField();
        JLabel jLabelCourseID = new JLabel("Ma Mon Hoc");
        courseJTextFieldCourseID = new JTextField();
        JLabel jLabelCourseName = new JLabel("Ten Mon Hoc");
        courseJTextFieldCourseName = new JTextField();
        jPanelAdd.add(jLabelStudentID);
        jPanelAdd.add(courseJTextFieldStudentID);
        jPanelAdd.add(jLabelStudentName);
        jPanelAdd.add(courseJTextFieldStudentName);
        jPanelAdd.add(jLabelCourseID);
        jPanelAdd.add(courseJTextFieldCourseID);
        jPanelAdd.add(jLabelCourseName);
        jPanelAdd.add(courseJTextFieldCourseName);
        JPanel jPanelAction = new JPanel();
        jPanelAction
                .setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Thao Tac"),
                        BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        JButton buttonAdd = new JButton("Them Mon Hoc");
        buttonAdd.addActionListener(e -> courseAddStudent());
        JButton buttonFind = new JButton("Tim Sinh Vien");
        buttonFind.addActionListener(e -> courseFindStudent());
        jPanelAction.add(buttonAdd);
        jPanelAction.add(buttonFind);
        northPanel.add(jPanelAdd, BorderLayout.NORTH);
        northPanel.add(jPanelAction, BorderLayout.CENTER);

        coursePanel.add(northPanel, BorderLayout.NORTH);

        courseModel = new DefaultTableModel(new String[] { "SoTT", "Ten Mon Hoc", "Diem" }, 0);
        courseTable = new JTable(courseModel);
        coursePanel.add(new JScrollPane(courseTable), BorderLayout.CENTER);
        return coursePanel;
    }

    private void courseAddStudent() {
        boolean checkIfAddSuccess = schoolManage.addAtCoursePanel(courseJTextFieldCourseID.getText(),
                courseJTextFieldCourseName
                        .getText(),
                courseJTextFieldStudentID.getText(), courseJTextFieldStudentName.getText());
        if (checkIfAddSuccess) {
            JOptionPane.showConfirmDialog(this, "Them Mon Hoc Thanh Cong");
            courseFindStudent();
        } else {
            JOptionPane.showConfirmDialog(this, "Khong tim thay sinh vien");
        }
    }

    private void courseFindStudent() {
        Student student = schoolManage.findStudent(courseJTextFieldStudentID.getText());
        if (student != null) {
            courseModel.setRowCount(0);
            List<Course> courses = student.getCourses();
            gradeJComboBoxCourseNames.removeAllItems();

            for (int i = 0; i < courses.size(); i++) {
                courseModel.addRow(new String[] { i + "", courses.get(i).getName(), courses.get(i).getGrade() + "" });
                gradeJComboBoxCourseNames.addItem(courses.get(i).getName());
            }
        } else {
            JOptionPane.showConfirmDialog(this, "Khong tim thay sinh vien");
        }
    }

    private Component mainPanel() {
        JPanel mainPanel = new JPanel();
        JLabel jLabel = new JLabel("Quản lý sinh viên khoa CNTT");
        jLabel.setHorizontalAlignment(SwingUtilities.CENTER);
        return mainPanel.add(jLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai27::new);
    }
}
