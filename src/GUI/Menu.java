package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel panel;
    private JButton danhSáchHọcSinhButton;
    private JButton thôngTinChươngTrìnhButton;
    public Menu(){
        add(panel);
        setSize(700,800);
        setTitle("Menu");
        setLocationRelativeTo(null);
        danhSáchHọcSinhButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DanhsachHocSinh ds = new DanhsachHocSinh();
                ds.setVisible(true);
                dispose();
                }
        });
        thôngTinChươngTrìnhButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ThongTinChuongTrinhHocSinh tt = new ThongTinChuongTrinhHocSinh();
                tt.setVisible(true);
                dispose();
            }
        });
    }
}
