package GUI;

import actionBase.CUD.UpdateInforStudent;
import base.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuaHocSinh extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton cậpNhậtButton;
    public SuaHocSinh(Student studentCur) {
        add(panel1);
        setSize(700,800);
        setTitle("Admin");
        setLocationRelativeTo(null);
        textField1.setText(studentCur.getIdStudent());
        textField2.setText(studentCur.getName());
        textField3.setText(studentCur.getAdress());
        textField4.setText(studentCur.getPhone());
        cậpNhậtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateInforStudent edit = new UpdateInforStudent();
                String mssv = new String(textField1.getText());
                String hoten =new String(textField2.getText());
                String diachi = new String(textField3.getText());
                String sdt = new String(textField4.getText());
                edit.updateStudent(mssv,hoten,diachi,sdt);
                DanhsachHocSinh ds = new DanhsachHocSinh();
                ds.setVisible(true);
                dispose();
            }
        });
    }
}
