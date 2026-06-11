package home.bai21;

public class SinhVien extends Nguoi {
    private float diem1;
    private float diem2;
    private float diem3;

    public SinhVien() {
    }

    public SinhVien(String ten, int namSinh,
            float diem1, float diem2, float diem3) {
        super(ten, namSinh);
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public float diemTB() {
        return (diem1 + diem2 + diem3) / 3;
    }
}
