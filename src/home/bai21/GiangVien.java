package home.bai21;

import java.util.Date;

public class GiangVien extends NhanVienCLCao {

    private double thuLaoGG;

    public GiangVien() {
    }

    public GiangVien(
            String ten,
            int namSinh,
            double luong,
            Date ngayNhanViec,
            PhongBan pbk,
            String trinhDo,
            String nganh,
            String noiDaoTao,
            double thuLaoGG) {

        super(ten, namSinh, luong, ngayNhanViec,
                pbk, trinhDo, nganh, noiDaoTao);

        this.thuLaoGG = thuLaoGG;
    }

    @Override
    public double tinhLuong() {
        return luong + thuLaoGG;
    }
}