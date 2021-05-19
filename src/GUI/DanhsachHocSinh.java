package GUI;

import actionBase.CUD.DeleteStudent;
import actionBase.GetData.GetListStudent;
import actionBase.GetData.GetStudent;
import actionBase.SearchInforStudent;
import base.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DanhsachHocSinh extends JFrame {
    private JPanel panel1;
    private JButton thêmButton;
    private JTable table1;
    private JTextField mssvTextField;
    private JButton tìmButton;
    private JButton refreshButton;
    private JButton trởLạiButton;
    private JButton sửaButton;
    private JButton xóaButton;
    GetListStudent listStudent = new GetListStudent();
    DefaultTableModel defaultTableModel;
    private JLabel StudentCur;
    private JTextField textField2;

    public DanhsachHocSinh(){
        add(panel1);
        setSize(700,800);
        setTitle("Admin");
        setLocationRelativeTo(null);
        TableStatusUser();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        trởLạiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultTableModel.setRowCount(0);
                List<Student> students = listStudent.getListStudent();
                setData(students);
            }
        });
        sửaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = getStudentCur();
                System.out.print(str);
                if ( str == ""){
                    StudentMessage m = new StudentMessage();
                    m.setVisible(true);
                }else{
                    GetStudent student = new GetStudent();
                    SuaHocSinh edit = new SuaHocSinh(student.get_Infor(str));
                    edit.setVisible(true);
                    dispose();
                }
            }
        });
        thêmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = getStudentCur();
                ThemHocSinh add = new ThemHocSinh();
                add.setVisible(true);
                dispose();
            }
        });
        xóaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = getStudentCur();
                System.out.print(str);
                if ( str == ""){
                    StudentMessage m = new StudentMessage();
                    m.setVisible(true);
                }else{
                    AreYouSure del = new AreYouSure(str);
                    del.setVisible(true);
                    dispose();
                }

            }
        });
        tìmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mssv = new String(mssvTextField.getText());
                String hoten =new String(textField2.getText());
                SearchInforStudent searchInforStudent = new SearchInforStudent();
                List<Student> listStudent = searchInforStudent.searchListStudent(mssv,hoten);
                defaultTableModel.setRowCount(0);
                setData(listStudent);
            }
        });
    }
    private void setData(List<Student> students){
        for(Student student: students) {
            defaultTableModel.addRow(new Object[]{student.getIdStudent(),student.getName(),student.getAdress(),student.getPhone()});
        }
    }
    private void TableStatusUser() {
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("MSSV");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số điện thoại");
        List<Student> students = listStudent.getListStudent();
        setData(students);
        table1.setModel(defaultTableModel);
        ListSelectionModel listSelectionModel = table1.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int [] row = table1.getSelectedRows();
                String acc = String.valueOf(table1.getValueAt(row[0],0));
                StudentCur.setText(acc);
            }
        });
    }
    private String getStudentCur(){
        return StudentCur.getText();
    }

}
