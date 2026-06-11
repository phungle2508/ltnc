package home.bai20;

// (7) Viết chương trình xây dựng đối tượng CD gồm có các thuộc tính sau:

// Mã CD là số nguyên, Tựa CD: chuỗi ký tự, Ca sỹ: chuỗi ký tự, Số bài hát: số nguyên
// (>0), Giá thành : số thực (>0)
// 1) Định nghĩa các phương thức get/set cho từng thuộc tính.
// 2) Xây dựng lớp lưu danh sách các CD (dùng mảng).
// 3) Phương thức thêm 1 CD vào danh sách, thêm thành công nếu không trùng mã CD
// và kích thước mảng còn cho phép.
// 4) Tính số lượng CD có trong danh sách.
// 5) Tình tổng giá thành của các CD.
// 6) Phương thức xuất toàn bộ danh sách.

// 7) Phương thức sắp xếp danh sách giảm dần theo giá thành.
// 8) Phương thức sắp xếp danh sách tăng dần theo tựa CD.
// 9) Viết lớp cho ph
public class CD {
    int id;
    String name;
    String singer;
    int songNumbers;
    double price;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return this.singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSongNumbers() {
        return this.songNumbers;
    }

    public void setSongNumbers(int songNumbers) {
        this.songNumbers = songNumbers;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", singer='" + getSinger() + "'"
                + ", songNumbers='" + getSongNumbers() + "'" + ", price='" + getPrice() + "'" + "}";
    }
}
