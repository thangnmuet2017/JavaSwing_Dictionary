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
public class TuDinhNghia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // thiet lap
        Student stu = new Student();
        stu.setHoTen("Nguyen Manh Thang");
        stu.setMSSV("17021030");
        stu.setNamSinh(1999);
        stu.setQueQuan("TX Son Tay, Ha Noi");
        stu.setTruong("Dai hoc Cong nghe, Dai hoc Quoc gia Ha Noi");
        stu.setKhoa("Cong nghe thong tin");
        // in ra
        System.out.println("Ho va ten: " + stu.getHoTen());
        System.out.println("MSSV: " + stu.getMSSV());
        System.out.println("Nam sinh: " + stu.getNamSinh());
        System.out.println("Que quan: " + stu.getQueQuan());
        System.out.println("Truong: " + stu.getTruong());
        System.out.println("Khoa: " + stu.getKhoa());
        stu.tuDinhNghia();
    }
    
}
