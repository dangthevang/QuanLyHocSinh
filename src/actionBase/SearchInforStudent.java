package actionBase;

import base.EducationStudents;
import base.Student;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchInforStudent {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn; }
    public List<String> searchListStudent(String mssv, String hoten) {
        String s = "";
        if (!mssv.equals("")){
            s = s + " ThongTinHocSinh.MSSV = '" + mssv+"'";
        }
        if (!hoten.equals("")){
            s = s + " ThongTinHocSinh.HoTen = '" + hoten + "'";
        }
        String sql ="select * from ThongTinHocSinh where " + s;
        List<String> LED = new ArrayList<String>();
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String MSSV = rs.getString(1).replaceAll("\\s", "");
                String HoTen = rs.getString(2).replaceAll("\\s", "");
                String DiaChi = rs.getString(3).replaceAll("\\s", "");
                String SDT = rs.getString(4).replaceAll("\\s", "");
                LED.add(MSSV);
                LED.add(HoTen);
                LED.add(DiaChi);
                LED.add(SDT);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return LED;
    }
}