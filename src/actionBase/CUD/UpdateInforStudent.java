package actionBase.CUD;

import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateInforStudent {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn; }
    public void updateStudent(String MSSV, String HoTen,String Diachi,String SoDienThoai) {
        String sql = "UPDATE ThongTinHocSinh SET HoTen = ?,DiaChi = ?, SoDienThoai = ? WHERE MSSV = ?";
        try {
            PreparedStatement stmt = this.getConn().prepareStatement(sql);
            stmt.setString(1,HoTen);
            stmt.setString(2,Diachi);
            stmt.setString(3,SoDienThoai);
            stmt.setString(3,MSSV);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
