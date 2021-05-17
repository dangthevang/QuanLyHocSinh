package base;

public class Student {
    private String idStudent;
    private String name;
    private String adress;
    private String phone;
    public Student(String idStudent, String name, String adress, String phone){
        this.idStudent = idStudent;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }
    public Student(){};
    public String getIdStudent() {
        return idStudent;
    }

    public String getAdress() {
        return adress;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
