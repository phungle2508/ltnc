package midterm.cau1;

public class LenhChuyenNhuong extends GiaoDich {

    int soLuongChuyen;
    String soTKNhan;

    public LenhChuyenNhuong(String maSo, String ngayThucHien, int soLuongChuyen, String soTKNhan) {
        super(maSo, ngayThucHien);
        // TODO Auto-generated constructor stub
        this.soLuongChuyen = soLuongChuyen;
        this.soTKNhan = soTKNhan;
    }

}
