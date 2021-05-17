package base;

public class EducationStudents {
    private String Chuongtrinh;
    private String TenChuongTrinh;

    public EducationStudents(String Chuongtrinh,String TenChuongTrinh){
        this.Chuongtrinh = Chuongtrinh;
        this.TenChuongTrinh = TenChuongTrinh;
    }

    public String getChuongtrinh() {
        return Chuongtrinh;
    }

    public void setChuongtrinh(String chuongtrinh) {
        Chuongtrinh = chuongtrinh;
    }

    public String getTenChuongTrinh() {
        return TenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        TenChuongTrinh = tenChuongTrinh;
    }
}
