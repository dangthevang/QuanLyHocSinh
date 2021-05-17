package actionBase.GetData;

import base.Student;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GetStudent {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn ;}
    public Student get_Infor(String mssv) {

        Student student = new Student();
        var sql ="select * from ThongTinHocSinh where MSSV = '" + mssv+"'";
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()){
                student.setIdStudent(rs.getString("MSSV"));
                student.setAdress(rs.getString("Diachi"));
                student.setName(rs.getString("HoTen"));
                student.setPhone(rs.getString("SoDienThoai"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }
}
