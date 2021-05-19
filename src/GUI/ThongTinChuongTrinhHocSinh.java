package GUI;

import actionBase.GetData.GetStudent;
import actionBase.StatisticalStudent;
import base.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ThongTinChuongTrinhHocSinh extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JButton timKiếmTheoNămButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JLabel Label;
    private JButton refreshButton;
    private JButton quayLạiButton;
    private String Time;
    private String CT;
    DefaultTableModel defaultTableModel;

    public ThongTinChuongTrinhHocSinh(){
        add(panel);
        setSize(700,800);
        setTitle("Chương trình đạo tạo");
        setLocationRelativeTo(null);
        TableStatusUser();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = getMSSV();
                System.out.print(str);
                if ( str == ""){
                    StudentMessage m = new StudentMessage();
                    m.setVisible(true);
                }else{
                    Caculator caculator = new Caculator(getMSSV(),getTime(),getCT());
                    caculator.setVisible(true);
                }

            }
        });
        timKiếmTheoNămButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CT = new String(textField2.getText());
                String Nam = new String(textField1.getText());
                System.out.print(CT);
                System.out.print(Nam);
                StatisticalStudent statisticalStudent = new StatisticalStudent();
                setData(statisticalStudent.StatisticalEducation(CT,Nam));
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticalStudent statisticalStudent = new StatisticalStudent();
                setData(statisticalStudent.StatisticalEducation());
            }
        });
        quayLạiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Menu menu = new Menu();
                    menu.setVisible(true);
                    dispose();
            }
        });
    }
    private void setData(List<String> LED){
        defaultTableModel.setRowCount(0);
        int i = 0;
        while (i<LED.size()){
            defaultTableModel.addRow(new Object[]{LED.get(i),LED.get(i+1),LED.get(i+2),LED.get(i+3)});
            i+=4;
        }
    }
    private void TableStatusUser() {
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("MSSV");
        defaultTableModel.addColumn("HoTen");
        defaultTableModel.addColumn("Chuong Trinh");
        defaultTableModel.addColumn("NamHoc");
        StatisticalStudent statisticalStudent = new StatisticalStudent();
        setData(statisticalStudent.StatisticalEducation());
        table1.setModel(defaultTableModel);
        ListSelectionModel listSelectionModel = table1.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int [] row = table1.getSelectedRows();
                String mssv = String.valueOf(table1.getValueAt(row[0],0));
                setTime(String.valueOf(table1.getValueAt(row[0],3)));
                setCT(String.valueOf(table1.getValueAt(row[0],2)));
                Label.setText(mssv);
            }
        });
    }
    public String getMSSV(){
        return Label.getText();
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getCT() {
        return CT;
    }

    public void setCT(String CT) {
        this.CT = CT;
    }
}
