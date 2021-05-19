package GUI;

import actionBase.CaculatorTuition;
import actionBase.GetData.GetStudent;
import actionBase.GetSubjectStudentInTime;
import actionBase.StatisticalStudent;
import base.Student;
import base.Subject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Caculator extends JFrame {
    private JPanel panel1;
    private JLabel MSSV;
    private JLabel Year;
    private JLabel chươngTrìnhLabel;
    private JLabel Sum;
    private JLabel HoTen;
    private JTable table1;
    DefaultTableModel defaultTableModel;

    public Caculator(String mssv, String Time,String Ct){
        add(panel1);
        setSize(500,700);
        setTitle("Admin");
        setLocationRelativeTo(null);
        GetStudent getStudent = new GetStudent();
        CaculatorTuition caculatorTuition = new CaculatorTuition();
        Student student =  getStudent.get_Infor(mssv);
        Float sum = caculatorTuition.Caculator(student,Time);
        Sum.setText("Tổng học phí: " + String.valueOf(sum));
        Year.setText("Năm Học: " + Time);
        MSSV.setText("MSSV: "+ mssv);
        HoTen.setText("Họ tên: "+ student.getName());
        chươngTrìnhLabel.setText("Chương Trình:"+ Ct);
        TableStatusUser(student,Time);
    }
    private void setData(List<Subject> LED){
        for(Subject subject: LED) {
            defaultTableModel.addRow(new Object[]{subject.getHocphan(),subject.getTenhocphan(),subject.getTinchi()});
        }
    }
    private void TableStatusUser(Student student, String time) {
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
        defaultTableModel.addColumn("Mã Môn: ");
        defaultTableModel.addColumn("Tên Môn");
        defaultTableModel.addColumn("Tin Chi");
        GetSubjectStudentInTime getSubjectStudentInTime = new GetSubjectStudentInTime();
        setData(getSubjectStudentInTime.GetListSubject(student,time));
        table1.setModel(defaultTableModel);
    }
}
