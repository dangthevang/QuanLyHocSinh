package actionBase;

import base.EducationStudents;
import base.Student;
import base.Subject;
import connect_database.JavaConnectSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CaculatorTuition {
    JavaConnectSQL connect = new JavaConnectSQL();
    Connection conn = connect.ConnectSQL();
    public Connection getConn(){ return conn ;}

    public float Caculator(Student student, String Time){
        var sql ="select ChuongTrinh from ChuongTrinhCuaHocSinh where MSSV = '"+ student.getIdStudent() +"' and NamHoc = '"+Time+"'";
        float caculator = 0;
        try{
            Statement stmt = this.getConn().createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String CT = rs.getString(1).replaceAll("\\s", "");
                GetSubjectStudentInTime n = new GetSubjectStudentInTime();
                List<Subject> a;
                a = n.GetListSubject(student,Time);
                if (CT.equals("TinChi")){
                    for(int i=0; i< a.size();i++){
                        caculator = (float) (caculator + a.get(i).getTinchi()*250000);
                    }
                }
                if (CT.equals("Thuong")){
                    caculator = 1000000;
                    for(int i=0; i< a.size();i++){
                        caculator = (float) (caculator + 250000*2.5);
                    }
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return caculator;
    }

}
