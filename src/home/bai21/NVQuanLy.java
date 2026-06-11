package home.bai21;

import java.util.Date;

public class NVQuanLy extends NhanVienCLCao {

    private double phuCapChucVu;

    public NVQuanLy() {
    }

    public NVQuanLy(
            String ten,
            int namSinh,
            double luong,
            Date ngayNhanViec,
            PhongBan pbk,
            String trinhDo,
            String nganh,
            String noiDaoTao,
            double phuCapChucVu) {

        super(ten, namSinh, luong, ngayNhanViec,
                pbk, trinhDo, nganh, noiDaoTao);

        this.phuCapChucVu = phuCapChucVu;
    }

    @Override
    public double tinhLuong() {
        return luong + phuCapChucVu;
    }
}