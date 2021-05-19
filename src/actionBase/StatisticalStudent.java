package actionBase;

import base.EducationStudents;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatisticalStudent {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn ;}
    public List<String>  StatisticalEducation(){
        var sql ="SELECT ThongTinHocSinh.MSSV,ThongTinHocSinh.HoTen,ChuongTrinhCuaHocSinh.ChuongTrinh,NamHoc " +
                "FROM ChuongTrinhCuaHocSinh, ThongTinHocSinh " +
                "Where ThongTinHocSinh.MSSV = ChuongTrinhCuaHocSinh.MSSV";
        List<String> LED = new ArrayList<String>();
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String MSSV = rs.getString(1).replaceAll("\\s", "");
                String HoTen = rs.getString(2).replaceAll("\\s", "");
                String ChuongTrinh = rs.getString(3).replaceAll("\\s", "");
                String NamHoc = rs.getString(4).replaceAll("\\s", "");
                LED.add(MSSV);
                LED.add(HoTen);
                LED.add(ChuongTrinh);
                LED.add(NamHoc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return LED;
    }
    public List<String>  StatisticalEducation(String CT, String Time){
        String s = "";
        if (!CT.equals("")){
            s = s + " and ChuongTrinh = '" + CT+"' ";
        }
        if (!Time.equals("")){
            s = s +" and NamHoc = '"+Time+"'";
        }


        var sql ="SELECT ThongTinHocSinh.MSSV,ThongTinHocSinh.HoTen,ChuongTrinhCuaHocSinh.ChuongTrinh,NamHoc " +
                "FROM ChuongTrinhCuaHocSinh, ThongTinHocSinh " +
                "Where ThongTinHocSinh.MSSV = ChuongTrinhCuaHocSinh.MSSV " + s;
        List<String> LED = new ArrayList<String>();
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String MSSV = rs.getString(1).replaceAll("\\s", "");
                String HoTen = rs.getString(2).replaceAll("\\s", "");
                String ChuongTrinh = rs.getString(3).replaceAll("\\s", "");
                String NamHoc = rs.getString(4).replaceAll("\\s", "");
                LED.add(MSSV);
                LED.add(HoTen);
                LED.add(ChuongTrinh);
                LED.add(NamHoc);
            }
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return LED;
    }
}
