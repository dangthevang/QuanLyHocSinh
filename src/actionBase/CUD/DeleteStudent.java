package actionBase.CUD;

import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn; }

    public void deleteStudent(String MSSV) {
        try{
            String sql = "delete from ChuongTrinhCuaHocSinh where MSSV=?";
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,MSSV);
            stmt.executeUpdate();
            sql = "delete from HocPhanCuaHocSinh where MSSV=?";
            stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,MSSV);
            stmt.executeUpdate();
            sql = "delete from ThongTinHocSinh where MSSV=?";
            stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,MSSV);
            stmt.executeUpdate(); }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
