package home.bai21;

public class Nguoi {
    protected String ten;
    protected int namSinh;

    public Nguoi() {
    }

    public Nguoi(String ten, int namSinh) {
        this.ten = ten;
        this.namSinh = namSinh;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamSinh() {
        return this.namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

}
