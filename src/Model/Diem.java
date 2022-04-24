package Model;

public class Diem {

    private int idSV;
    private SinhVien sv;
    private float tiengAnh, tinHoc, gdtc, diemTB;

    public Diem() {
    }

    public Diem(int idSV, SinhVien sv, float tiengAnh, float tinHoc, float gdtc, float diemTB) {
        this.idSV = idSV;
        this.sv = sv;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
        this.diemTB = diemTB;
    }

    public int getIdSV() {
        return idSV;
    }

    public void setIdSV(int idSV) {
        this.idSV = idSV;
    }

    public float getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(float tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public float getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(float tinHoc) {
        this.tinHoc = tinHoc;
    }

    public float getGdtc() {
        return gdtc;
    }

    public void setGdtc(float gdtc) {
        this.gdtc = gdtc;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    @Override
    public String toString() {
        return "Diem{" + "idSV=" + idSV + ", sv=" + sv + ", tiengAnh=" + tiengAnh + ", tinHoc=" + tinHoc + ", gdtc=" + gdtc + ", diemTB=" + diemTB + '}';
    }

    public float diemtb(float tiengAnh, float tinHoc, float gdtc) {
        this.diemTB = (tiengAnh + tinHoc + gdtc) / 3;
        return diemTB;
    }
}
