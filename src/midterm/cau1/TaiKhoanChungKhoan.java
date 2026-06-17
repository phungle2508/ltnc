package midterm.cau1;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanChungKhoan {
    String soTK, chuTK;
    double soTienDu, soLuongCP;
    List<GiaoDich> danhsachGD;

    public String getSoTK() {
        return this.soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getChuTK() {
        return this.chuTK;
    }

    public void setChuTK(String chuTK) {
        this.chuTK = chuTK;
    }

    public double getSoTienDu() {
        return this.soTienDu;
    }

    public void setSoTienDu(double soTienDu) {
        this.soTienDu = soTienDu;
    }

    public double getSoLuongCP() {
        return this.soLuongCP;
    }

    public void setSoLuongCP(double soLuongCP) {
        this.soLuongCP = soLuongCP;
    }

    public List<GiaoDich> getDanhsachGD() {
        return this.danhsachGD;
    }

    public void setDanhsachGD(List<GiaoDich> danhsachGD) {
        this.danhsachGD = danhsachGD;
    }

    public int demSoluongBan() {
        int count = 0;
        for (GiaoDich giaoDich : danhsachGD) {
            if (giaoDich instanceof LenhBan) {
                count++;
            }
        }
        return count;
    }

    public boolean checkIfDupType() {
        for (int i = 0; i < danhsachGD.size(); i++) {
            for (int j = i + 1; j < danhsachGD.size(); j++) {
                if (danhsachGD.get(i).getClass() != danhsachGD.get(j).getClass()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TaiKhoanChungKhoan taiKhoanChungKhoan = new TaiKhoanChungKhoan();
        GiaoDich lenhBan1 = new LenhBan(null, null, 0);
        GiaoDich lenhBan2 = new LenhBan(null, null, 0);
        GiaoDich lenhMua1 = new LenhMua(null, null, 0);
        GiaoDich lenhMua2 = new LenhMua(null, null, 0);
        GiaoDich lenhChuyenNhuong = new LenhChuyenNhuong(null, null, 0, null);
        List<GiaoDich> danhsachGD = new ArrayList<>();
        danhsachGD.add(lenhBan1);
        danhsachGD.add(lenhBan2);
        danhsachGD.add(lenhMua1);
        danhsachGD.add(lenhMua2);
        danhsachGD.add(lenhChuyenNhuong);

        taiKhoanChungKhoan.setDanhsachGD(danhsachGD);
        System.out.println("Cau 2: " + taiKhoanChungKhoan.demSoluongBan());
        System.out.println("Cau 3: " + taiKhoanChungKhoan.checkIfDupType());
    }
}
