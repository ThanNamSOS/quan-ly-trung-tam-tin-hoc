package Service;

import InterFace.InterFaceDiemSV;
import InterFace.InterFaceSinhVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Diem;
import Model.SinhVien;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DAO_QLDiem implements InterFaceDiemSV {

    InterFaceSinhVien qlSV = new DAO_QLSinhVien();
    Diem qldiem = new Diem();
    public ArrayList<Diem> _lstDiem = null;
    ArrayList<SinhVien> _lstSinhVien = qlSV.listSinhVien();

    public DAO_QLDiem() {
        _lstDiem = new ArrayList<Diem>();
    }

    @Override
    public ArrayList<Diem> listQLDiem() {
        _lstDiem.clear();
        String sql = "SELECT * FROM GRADE";
        try (Connection con = JDBC.getConnection();
                Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(sql);
            ArrayList list = new ArrayList<>();
            float DiemTB;
            while (rs.next()) {
                int idSV = rs.getInt(1);
                SinhVien sv = qlSV.findById(rs.getString(2));
                float tiengAnh = rs.getFloat(3);
                float tinHoc = rs.getFloat(4);
                float gdtc = rs.getFloat(5);
                float diemTB = qldiem.diemtb(rs.getFloat(3), rs.getFloat(4), rs.getFloat(5));
                list.add(new Diem(idSV, sv, tiengAnh, tinHoc, gdtc, diemTB));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Diem> listTop3SV() {
        String sql = "	select top 3  ID,GRADE.MASV,TIENGANH,TINHOC,GDTC,(TIENGANH+TINHOC+GDTC)/3 AS TBM from GRADE inner join STUDENT on STUDENT.MASV=GRADE.MASV order by TBM desc";
        try (Connection con = JDBC.getConnection();
                Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(sql);
            ArrayList list = new ArrayList<>();
            float DiemTB;
            while (rs.next()) {
                int idSV = rs.getInt(1);
                String masv = rs.getString(2);
                SinhVien sv = qlSV.findById(masv);
                float tiengAnh = rs.getFloat(3);
                float tinHoc = rs.getFloat(4);
                float gdtc = rs.getFloat(5);
                float diemTB = qldiem.diemtb(rs.getFloat(3), rs.getFloat(4), rs.getFloat(5));
                list.add(new Diem(idSV, sv, tiengAnh, tinHoc, gdtc, diemTB));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert() {
        String sql = "INSERT INTO GRADE(MASV,TIENGANH,TINHOC,GDTC) VALUES(?,?,?,?)";
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            for (Diem x : _lstDiem) {
                stm.setString(1, x.getSv().getMaSV());
                stm.setFloat(2, x.getTiengAnh());
                stm.setFloat(3, x.getTinHoc());
                stm.setFloat(4, x.getGdtc());
            }
            System.out.println("Số bản ghi được thêm vào bảng GRADE: " + stm.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Diem diem) {
        _lstDiem.add(diem);
        insert();
    }

    @Override
    public void delete(int viTri) {
        _lstDiem = listQLDiem();
        _lstDiem.remove(viTri);
    }

    @Override
    public Diem search(int viTri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diem getSV(String maSV) {
        for (Diem diem : listQLDiem()) {
            if (diem.getSv().getMaSV().equalsIgnoreCase(maSV)) {
                return diem;
            }
        }
        return null;
    }

    @Override
    public void DeleteDatabase(String maSv) {
        String sql = "delete from GRADE  where MASV = ?";
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, maSv);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("delete erro");
            e.printStackTrace();
        }
    }

    @Override
    public void updateDiem(Diem diem) {
        String sql = "UPDATE GRADE SET TIENGANH = ?,TINHOC=?,GDTC=? where MASV = ?";
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setFloat(1, diem.getTiengAnh());
            stm.setFloat(2, diem.getTinHoc());
            stm.setFloat(3, diem.getGdtc());
            stm.setString(4, diem.getSv().getMaSV());
            stm.executeUpdate();
            System.out.println("Update Thanh cong");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Update erro");
        }
    }

    public static void main(String[] args) {
        DAO_QLDiem qldiem = new DAO_QLDiem();
        ArrayList<Diem> _lstDiem4 = qldiem.listQLDiem();
        System.out.println(_lstDiem4.toString());
    }

    @Override
    public void loadDataToTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
