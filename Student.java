/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu.dinh.nghia;

/**
 *
 * @author DELL
 */
public class Student {
     // cac thuoc tinh cua lop Student
    private String HoTen;
    private String MSSV;
    private int NamSinh;
    private String QueQuan;
    private String Truong;
    private String Khoa;
    
    // cac phuong thuc cua lop Student
    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getTruong() {
        return Truong;
    }

    public void setTruong(String Truong) {
        this.Truong = Truong;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }
    public void tuDinhNghia() {
        System.out.println("QH2017/I-CQ-C-L");
    }
}
