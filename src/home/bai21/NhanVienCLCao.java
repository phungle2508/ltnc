package home.bai21;

import java.util.Date;

public abstract class NhanVienCLCao extends NhanVien {

    protected String trinhDo;
    protected String nganh;
    protected String noiDaoTao;

    public NhanVienCLCao() {
    }

    public NhanVienCLCao(
            String ten,
            int namSinh,
            double luong,
            Date ngayNhanViec,
            PhongBan pbk,
            String trinhDo,
            String nganh,
            String noiDaoTao) {

        super(ten, namSinh, luong, ngayNhanViec, pbk);

        this.trinhDo = trinhDo;
        this.nganh = nganh;
        this.noiDaoTao = noiDaoTao;
    }

}