package home.bai21;

import java.util.List;

public class TruongDaiHoc {
    List<Nguoi> listHuman;

    public void printListStudent() {
        for (Nguoi n : listHuman) {
            if (n instanceof SinhVien) {
                System.out.println(n);
            }
        }

    }

    public void printListEmployee() {
        for (Nguoi n : listHuman) {
            if (n instanceof NhanVien) {
                System.out.println(n);
            }
        }

    }

    public void printListEmployeeWithSalary() {
        for (Nguoi n : listHuman) {
            if (n instanceof NhanVien) {
                NhanVien nhanVien = (NhanVien) n;
                System.out.println(nhanVien.tinhLuong());
            }
        }
    }

    public NhanVien findTheHighestSalaryEmployee() {
        NhanVien employeeMaxSalary = null;
        for (Nguoi nguoi : listHuman) {
            if (nguoi instanceof NhanVien) {
                NhanVien employee = (NhanVien) nguoi;
                if (employeeMaxSalary == null || employeeMaxSalary.tinhLuong() < employee.tinhLuong()) {
                    employeeMaxSalary = employee;
                }
            }
        }
        return employeeMaxSalary;
    }

    public boolean checkIfAHumanIsEmployee(Nguoi n) {
        if (n instanceof NhanVien) {
            return true;
        }
        return false;
    }
}
