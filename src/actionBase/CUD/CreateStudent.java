package actionBase.CUD;

import base.Student;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateStudent {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn; }
    public Student createStudent(String MSSV, String HoTen, String DiaChi, String SoDienThoai) {
        var sql ="INSERT INTO ThongTinHocSinh VALUES (?,?,?,?); ";
        PreparedStatement stmt = null;
        Student student = new Student();
        try {
            stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1, MSSV);
            stmt.setString(2,HoTen);
            stmt.setString(3, DiaChi);
            stmt.setString(4, SoDienThoai);
            stmt.execute();
            student = new Student(MSSV,HoTen,DiaChi,SoDienThoai);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return student;
    }
}
