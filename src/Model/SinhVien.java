package Model;

import java.util.Date;

public class SinhVien {

    private String maSV;
    private String hoTen;
    private Date ngaySinh;
    private String email;
    private String sdt;
    private boolean gioiTinh;
    private String diaChi;
    private String hinhAnh;

    public SinhVien() {
    }

    public SinhVien(String maSV) {
        this.maSV = maSV;
        this.hoTen = hoTen;
    }

    public SinhVien(String maSV, String hoTen, Date ngaySinh, String email, String sdt, boolean gioiTinh, String diaChi, String hinhAnh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return maSV;
//        return "SinhVien{" + "maSV=" + maSV + ", hoTen=" + hoTen + ", email=" + email + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", hinhAnh=" + hinhAnh + '}';
    }

    
}
