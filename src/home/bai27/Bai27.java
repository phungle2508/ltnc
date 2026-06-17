package home.bai27;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import home.bai27.model.Course;
import home.bai27.model.SchoolManage;
import home.bai27.model.Student;

public class Bai27 extends JFrame {
    SchoolManage schoolManage;
    CardLayout cardLayout;
    JPanel cardPanel;
    DefaultTableModel modelCourse, modelGrade;
    JTable jTableCourse, jtableGrade;
    JTextField jTextFieldMSSV, jTextFieldName, jTextFieldCourseID, jTextFieldCourseName, jTextFieldGrade,
            jTextFieldMSSVCourse, jTextFieldNameCourse, jTextFieldCourseIDCourse, jTextFieldCourseNameCourse;
    JComboBox<String> jTextFieldCourseList;

    Bai27() {
        schoolManage = new SchoolManage(new ArrayList<Student>());

        schoolManage.students.add(new Student(
                "SV01",
                "Nguyen Van A",
                new ArrayList<Course>(List.of(
                        new Course("MH01", "Java", 8.5f),
                        new Course("MH02", "CSDL", 7.0f)))));

        schoolManage.students.add(new Student(
                "SV02",
                "Tran Thi B",
                new ArrayList<Course>(List.of(
                        new Course("MH01", "Java", 9.0f),
                        new Course("MH03", "Lap trinh Web", 8.0f)))));

        schoolManage.students.add(new Student(
                "SV03",
                "Le Van C",
                new ArrayList<Course>(List.of(
                        new Course("MH02", "CSDL", 6.5f),
                        new Course("MH04", "OOP", 7.5f)))));

        setTitle("Khoa Công Nghệ Thông Tin");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(mainToolBar(), BorderLayout.NORTH);
        add(createCardPanel(), BorderLayout.CENTER);
    }

    private JPanel createCardPanel() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(mainPanel(), "Main");
        cardPanel.add(coursePanel(), "Course");
        cardPanel.add(gradePanel(), "Grade");
        return cardPanel;
    }

    private JPanel mainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel lblTitle = new JLabel("QUẢN LÝ SINH VIÊN K.CNTT");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(lblTitle);
        return mainPanel;
    }

    private JPanel coursePanel() {

        JPanel coursePanel = new JPanel(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());
        JPanel courseAddPanel = new JPanel(new GridLayout(4, 2));
        JLabel jLabelMSSV = new JLabel("MSSV");
        jTextFieldMSSVCourse = new JTextField();
        JLabel jLabelName = new JLabel("Ho va ten");
        jTextFieldNameCourse = new JTextField();
        JLabel jLabelCourseID = new JLabel("Ma Mon Hoc");
        jTextFieldCourseIDCourse = new JTextField();
        JLabel jLabelCourseName = new JLabel("Ten Mon Hoc");
        jTextFieldCourseNameCourse = new JTextField();

        courseAddPanel.add(jLabelMSSV);
        courseAddPanel.add(jTextFieldMSSVCourse);
        courseAddPanel.add(jLabelName);
        courseAddPanel.add(jTextFieldNameCourse);
        courseAddPanel.add(jLabelCourseID);
        courseAddPanel.add(jTextFieldCourseIDCourse);
        courseAddPanel.add(jLabelCourseName);
        courseAddPanel.add(jTextFieldCourseNameCourse);
        courseAddPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(""),
                        BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        northPanel.add(courseAddPanel, BorderLayout.NORTH);

        JPanel jPanelButton = new JPanel();
        JButton jButtonAddCourse = new JButton("Them Mon Hoc");
        JButton jButtonFindStudent = new JButton("Tim Sinh Vien");

        jButtonFindStudent.addActionListener(e -> findStudent(false));

        jPanelButton.add(jButtonAddCourse);
        jPanelButton.add(jButtonFindStudent);
        jPanelButton.setBorder(BorderFactory.createTitledBorder("Thao Tac"));
        northPanel.add(jPanelButton, BorderLayout.SOUTH);
        coursePanel.add(northPanel, BorderLayout.NORTH);
        String[] columnName = new String[] { "So TT", "Ten mon hoc", "Diem" };
        modelCourse = new DefaultTableModel(columnName, 0);
        jTableCourse = new JTable(modelCourse);
        coursePanel.add(new JScrollPane(jTableCourse), BorderLayout.CENTER);

        return coursePanel;
    }

    private JPanel gradePanel() {

        JPanel gradePanel = new JPanel(new BorderLayout());

        JPanel northPanel = new JPanel(new BorderLayout());
        JPanel courseAddPanel = new JPanel(new GridLayout(4, 2));
        JLabel jLabelMSSV = new JLabel("MSSV");
        jTextFieldMSSV = new JTextField();
        JLabel jLabelName = new JLabel("Ho va ten");
        jTextFieldName = new JTextField();
        JLabel jLabelCourseList = new JLabel("Mon Hoc");
        jTextFieldCourseList = new JComboBox<String>(schoolManage.findALLCurrentCourse());
        JLabel jLabelGrade = new JLabel("Diem");
        jTextFieldGrade = new JTextField();

        courseAddPanel.add(jLabelMSSV);
        courseAddPanel.add(jTextFieldMSSV);
        courseAddPanel.add(jLabelName);
        courseAddPanel.add(jTextFieldName);
        courseAddPanel.add(jLabelCourseList);
        courseAddPanel.add(jTextFieldCourseList);
        courseAddPanel.add(jLabelGrade);
        courseAddPanel.add(jTextFieldGrade);
        courseAddPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Them Diem"),
                        BorderFactory.createEmptyBorder(10, 100, 10, 100)));
        northPanel.add(courseAddPanel, BorderLayout.NORTH);

        JPanel jPanelButton = new JPanel();
        JButton jButtonAddGrade = new JButton("Them Diem");
        JButton jButtonFindStudent = new JButton("Tim Sinh Vien");
        jButtonFindStudent.addActionListener(e -> findStudent(true));
        jPanelButton.add(jButtonAddGrade);
        jPanelButton.add(jButtonFindStudent);
        jPanelButton.setBorder(BorderFactory.createTitledBorder("Thao Tac"));
        northPanel.add(jPanelButton, BorderLayout.SOUTH);
        gradePanel.add(northPanel, BorderLayout.NORTH);
        String[] columnName = new String[] { "So TT", "Ten mon hoc", "Diem" };
        modelGrade = new DefaultTableModel(columnName, 0);
        jtableGrade = new JTable(modelGrade);
        gradePanel.add(new JScrollPane(jtableGrade), BorderLayout.CENTER);

        return gradePanel;
    }

    private JMenuBar mainToolBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu infoManageMenu = new JMenu("Quản lý sinh viên");

        JMenuItem courseInfoManageMenu = new JMenuItem("Quản lý Môn học");
        courseInfoManageMenu.setMnemonic(KeyEvent.VK_M);
        JMenuItem gradeInfoManageMenu = new JMenuItem("Quản lý Điểm");
        gradeInfoManageMenu.setMnemonic(KeyEvent.VK_D);
        gradeInfoManageMenu.setDisplayedMnemonicIndex(8);
        infoManageMenu.add(courseInfoManageMenu);
        infoManageMenu.add(gradeInfoManageMenu);

        courseInfoManageMenu.addActionListener(e -> {

            cardLayout.show(cardPanel, "Course");
        });
        gradeInfoManageMenu.addActionListener(e -> {

            cardLayout.show(cardPanel, "Grade");
        });

        jMenuBar.add(fileMenu);
        jMenuBar.add(infoManageMenu);

        return jMenuBar;

    }

    public void findStudent(boolean isGrade) {
        if (isGrade) {
            Student studentFound = schoolManage.findStudent(jTextFieldMSSV.getText());
            if (studentFound != null) {
                for (Course course : studentFound.getCourses()) {
                    modelGrade.addRow(new String[] { course.getId(), course.getName(), course.getGrade() + "" });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Loi roi ban oi");
                return;
            }

        } else {
            Student studentFound = schoolManage.findStudent(jTextFieldMSSVCourse.getText());
            if (studentFound != null) {
                for (Course course : studentFound.getCourses()) {
                    modelCourse.addRow(new String[] { course.getId(), course.getName(), course.getGrade() + "" });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Loi roi ban oi");
                return;
            }
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Bai27::new);
    }

}
