package actionBase;

import base.Student;
import base.Subject;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetSubjectStudentInTime {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn ;}

    public List<Subject> GetListSubject(Student student,String Time){
        var sql = "Select ThongTinHocPhan.HocPhan,TinChi,TenHocPhan From ThongTinHocPhan, HocPhanCuaHocSinh Where HocPhanCuaHocSinh.MSSV = ? and HocPhanCuaHocSinh.NamHoc = ? and ThongTinHocPhan.HocPhan = HocPhanCuaHocSinh.HocPhan;";
        List<Subject> subjects = new ArrayList<Subject>();
        try {
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,student.getIdStudent());
            stmt.setString(2,Time);
            var rs = stmt.executeQuery();
            while (rs.next()) {
                String HocPhan = rs.getString(1).replaceAll("\\s", "");
                int TinChi = rs.getInt(2);
                String TenHocPhan = rs.getString(3).replaceAll("\\s", "");
                Subject subject = new Subject(HocPhan,TinChi,TenHocPhan);
                subjects.add(subject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subjects;
    }
}
