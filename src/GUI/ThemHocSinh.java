package GUI;

import actionBase.CUD.CreateStudent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemHocSinh extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton thêmButton;
    private JLabel Label;

    public ThemHocSinh(){
        add(panel1);
        setSize(700,800);
        setTitle("Thêm học sinh");
        setLocationRelativeTo(null);
        thêmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateStudent cs = new CreateStudent();
                String mssv = new String(textField1.getText());
                String hoten =new String(textField2.getText());
                String diachi = new String(textField3.getText());
                String sdt = new String(textField4.getText());
                cs.createStudent(mssv,hoten,diachi,sdt);
                Label.setText("Thêm thành công");
                DanhsachHocSinh ds = new DanhsachHocSinh();
                ds.setVisible(true);
                dispose();
            }
        });
    }
}
