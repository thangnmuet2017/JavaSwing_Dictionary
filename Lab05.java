package lab05;

public class Lab05 {

    public static void main(String[] args) {
        /*
        A subclass does not inherit the private members of its parent class.
        However, if the superclass has public or protected methods for accessing its private fields,
        these can also be used by the subclass.
        */
        
        HoaQua qua = new HoaQua("bau duc", "do", "chat");
        qua.inThongTin();
        Tao apple = new Tao("tron", "xanh", "ngot vua");
        apple.setNguon_goc("USA");
        apple.setDon_gia(90000);
        apple.setSo_luong(3);
        apple.setNgay_nhap("07/10/2018");
        System.out.println("Thong tin cho Tao:");
        apple.inThongTin();
        
        Cam orange = new Cam();
        orange.setNguon_goc("Nam Bo");
        orange.setHinh_dang("oval");
        orange.setMau_sac("vang cam");
        orange.setHuong_vi("ngot thanh");
        orange.setDon_gia(30000);
        orange.setSo_luong(100);
        orange.setNgay_nhap("27/08/2018");
        System.out.println("Thong tin cho Cam:");
        orange.inThongTin();
             
        CamCaoPhong CP_orange = new CamCaoPhong("tron", "cam", "hoi chua");
        CP_orange.setSo_luong(1000);
        CP_orange.setDon_gia(25000);
        CP_orange.setNgay_nhap("05/09/2017");
        System.out.println("Thong tin cho cam Cao Phong");
        CP_orange.inThongTin();
        
        CamSanh S_orange = new CamSanh("Hoi meo", "xanh la", "rat ngot");
        S_orange.setSo_luong(200);
        S_orange.setNgay_nhap("07/12/2016");
        System.out.println("Thong tin cho cam sanh");
        S_orange.inThongTin();
    }
    
}
// class HoaQua (superclass)
class HoaQua {
    private String hinh_dang;
    private String mau_sac;
    private String huong_vi;
    // constructor
    public HoaQua() {
        hinh_dang = "";
        mau_sac = "";
        huong_vi = "";
    }

    public HoaQua(String hinh_dang, String mau_sac, String huong_vi) {
        this.hinh_dang = hinh_dang;
        this.mau_sac = mau_sac;
        this.huong_vi = huong_vi;
    }
    // cac phuong thuc getter setter
    public String getHinh_dang() {
        return hinh_dang;
    }

    public void setHinh_dang(String hinh_dang) {
        this.hinh_dang = hinh_dang;
    }

    public String getMau_sac() {
        return mau_sac;
    }

    public void setMau_sac(String mau_sac) {
        this.mau_sac = mau_sac;
    }

    public String getHuong_vi() {
        return huong_vi;
    }

    public void setHuong_vi(String huong_vi) {
        this.huong_vi = huong_vi;
    }
    
    // in ra thong tin
    public void inThongTin() {
        System.out.print("Qua hinh " + getHinh_dang());
        System.out.print(", mau " + getMau_sac());
        System.out.println(", vi " + getHuong_vi());
        System.out.println();
    }
}

// class Tao ke thua class HoaQua
class Tao extends HoaQua {
    private String nguon_goc;
    private int don_gia;
    private int so_luong;
    private String ngay_nhap;
    // constructor
    public Tao() {
    }

    public Tao(String hinh_dang, String mau_sac, String huong_vi) {
        super(hinh_dang, mau_sac, huong_vi);
    }
    // cac phuong thuc setter va getter
    public String getNguon_goc() {
        return nguon_goc;
    }

    public void setNguon_goc(String nguon_goc) {
        this.nguon_goc = nguon_goc;
    }

    public int getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(int don_gia) {
        this.don_gia = don_gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getNgay_nhap() {
        return ngay_nhap;
    }

    public void setNgay_nhap(String ngay_nhap) {
        this.ngay_nhap = ngay_nhap;
    }
    // phuong thuc tinh tien don hang
    public int thanh_tien() {
        return getSo_luong()*getDon_gia();
    }
    // phuong thuc in thong tin 
    @Override
    public void inThongTin() {
        System.out.println("Nguon goc san pham: " + getNguon_goc());
        System.out.println("Huong vi: " + getHuong_vi());
        System.out.println("So luong: " + getSo_luong());
        System.out.println("Don gia: " + getDon_gia());
        System.out.println("Thanh tien: " + thanh_tien());
        System.out.println("Ngay nhap: " + getNgay_nhap());
        System.out.println();
    }
}

// class Cam ke thua class HoaQua
class Cam extends HoaQua {
    private String nguon_goc;
    private int don_gia;
    private int so_luong;
    private String ngay_nhap;
    // cac phuong thuc getter va setter
    public Cam() {
    }

    public Cam(String hinh_dang, String mau_sac, String huong_vi) {
        super(hinh_dang, mau_sac, huong_vi);
    }

    public String getNguon_goc() {
        return nguon_goc;
    }

    public void setNguon_goc(String nguon_goc) {
        this.nguon_goc = nguon_goc;
    }

    public int getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(int don_gia) {
        this.don_gia = don_gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getNgay_nhap() {
        return ngay_nhap;
    }

    public void setNgay_nhap(String ngay_nhap) {
        this.ngay_nhap = ngay_nhap;
    }
    
    // phuong thuc tinh tien don hang
    public int thanh_tien() {
        return getSo_luong()*getDon_gia();
    }
    
     // phuong thuc in thong tin 
    @Override
    public void inThongTin() {
        System.out.println("Nguon goc san pham: " + getNguon_goc());
        System.out.println("Huong vi: " + getHuong_vi());
        System.out.println("So luong: " + getSo_luong());
        System.out.println("Don gia: " + getDon_gia());
        System.out.println("Thanh tien: " + thanh_tien());
        System.out.println("Ngay nhap: " + getNgay_nhap());
        System.out.println();
    }
}
// class cam Cao Phong ke thua class Cam
class CamCaoPhong extends Cam {
    // constructor
    public CamCaoPhong() {
    }

    public CamCaoPhong(String hinh_dang, String mau_sac, String huong_vi) {
        super(hinh_dang, mau_sac, huong_vi);
    }
    
    /// override phuong thuc getNguon_goc
    @Override
    public String getNguon_goc() {
        return "Cao Phong, Hoa Binh";
    }
    
}

// class cam sanh ke thua class cam
class CamSanh extends Cam {
    // constructor
    public CamSanh() {
    }

    public CamSanh(String hinh_dang, String mau_sac, String huong_vi) {
        super(hinh_dang, mau_sac, huong_vi);
    }
    
    // override phuong thuc getNguon_goc
    @Override 
    public String getNguon_goc() {
        return "Bo Ha, Yen The, Bac Giang";
    }
    
    // override phuong thuc getDon_gia
    @Override
    public int getDon_gia() {
        return 20000;
    }
}