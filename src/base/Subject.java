package base;

public class Subject {
    private String hocphan;
    private int tinchi;
    private String tenhocphan;
    public Subject(String hocphan,int tinchi,String tenhocphan){
        this.hocphan = hocphan;
        this.tinchi = tinchi;
        this.tenhocphan = tenhocphan;
    }

    public String getHocphan() {
        return hocphan;
    }

    public void setHocphan(String hocphan) {
        this.hocphan = hocphan;
    }

    public int getTinchi() {
        return tinchi;
    }

    public void setTinchi(int tinchi) {
        this.tinchi = tinchi;
    }

    public String getTenhocphan() {
        return tenhocphan;
    }

    public void setTenhocphan(String tenhocphan) {
        this.tenhocphan = tenhocphan;
    }
}
