package GUI;

import actionBase.CUD.DeleteStudent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreYouSure extends JFrame {
    private JPanel panel1;
    private JButton YESButton;
    private JButton NOButton;
    private JLabel Label;

    public AreYouSure(String mssv){
        add(panel1);
        setSize(500,400);
        Label.setText("Bạn muốn xóa hoc sinh "+ mssv +" ?");
        setTitle("Xóa");
        setLocationRelativeTo(null);
        YESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStudent del = new DeleteStudent();
                del.deleteStudent(mssv);
                DanhsachHocSinh ds = new DanhsachHocSinh();
                ds.setVisible(true);
                dispose();
            }
        });
        NOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DanhsachHocSinh ds = new DanhsachHocSinh();
                ds.setVisible(true);
                dispose();
            }
        });
    }

}
