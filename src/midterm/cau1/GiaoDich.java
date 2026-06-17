package midterm.cau1;

public abstract class GiaoDich {
    String maSo, ngayThucHien;

    public GiaoDich(String maSo, String ngayThucHien) {
        this.maSo = maSo;
        this.ngayThucHien = ngayThucHien;
    }

    public String getMaSo() {
        return this.maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getNgayThucHien() {
        return this.ngayThucHien;
    }

    public void setNgayThucHien(String ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }

}
