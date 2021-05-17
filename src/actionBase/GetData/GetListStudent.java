package actionBase.GetData;

import base.Student;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetListStudent{
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn; }
    public List<Student> getListStudent() {
        List<Student> liststudent = new ArrayList<Student>();
        var sql ="select * from ThongTinHocSinh";
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                String MSSV = rs.getString(1).replaceAll("\\s", "");
                String HoTen = rs.getString(2).replaceAll("\\s", "");
                String DiaChi = rs.getString(3).replaceAll("\\s", "");
                String SoDienThoai = rs.getString(4).replaceAll("\\s", "");
                Student student = new Student(MSSV,HoTen,DiaChi,SoDienThoai);
                liststudent.add(student);
                i+=1;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return liststudent;
    }
}
