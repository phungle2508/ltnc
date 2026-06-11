package home.bai21;

import java.util.Date;

public abstract class NhanVien extends Nguoi {
    protected double luong;
    protected Date ngayNhanViec;
    protected PhongBan pbk;

    public NhanVien() {
    }

    public NhanVien(String ten,
            int namSinh,
            double luong,
            Date ngayNhanViec,
            PhongBan pbk) {

        super(ten, namSinh);
        this.luong = luong;
        this.ngayNhanViec = ngayNhanViec;
        this.pbk = pbk;
    }

    public abstract double tinhLuong();
}