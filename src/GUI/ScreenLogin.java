package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenLogin extends JFrame{
    private JPanel panel1;
    private JTextField tênĐăngNhậpTextField;
    private JPasswordField passwordField1;
    private JButton button1;
    private JLabel Label;
    public ScreenLogin(){
        add(panel1);
        setSize(500,400);
        setTitle("Login");
        setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField1.getPassword());
                String admin = new String(tênĐăngNhậpTextField.getText());
                if (admin.equals("admin") && password.equals("12345")){
                    Label.setText("Dang nhap thanh cong");
                    Menu menu = new Menu();
                    menu.setVisible(true);
                    dispose();
                }else {
                    Label.setText("Sai ten tai khoan hoac mat khau");
                }
            }
        });
    }
}
