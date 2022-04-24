package Service;

import Model.Diem;
import Model.SinhVien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAO_QLSinhVien implements InterFace.InterFaceSinhVien {

    SinhVien sv = new SinhVien();
    ArrayList<SinhVien> _lstSinhVien = listSinhVien();

    @Override
    public ArrayList<SinhVien> listSinhVien() {
        String sql = "SELECT MASV,HOTEN,NGAYSINH,EMAIL,SDT,GIOITINH,DIACHI,HINH FROM STUDENT";
        try (Connection con = JDBC.getConnection();
                Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(sql);
            
            ArrayList list = new ArrayList();
            while (rs.next()) {
                list.add(new SinhVien(rs.getString(1), rs.getString(2),rs.getDate(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getString(7), rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//-----------------------------------------------------------------------------------------------------------

    @Override
    public void save(SinhVien sv) {
        _lstSinhVien.add(sv);
        insert_Database(sv);
    }
    public void insert_Database(SinhVien sv) {
        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = JDBC.getConnection();
                Statement stmm = con.createStatement();
                PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, sv.getMaSV());
                stm.setString(2, sv.getHoTen());
                stm.setDate(3, new java.sql.Date(sv.getNgaySinh().getTime()));
                stm.setString(4, sv.getEmail());
                stm.setString(5, sv.getSdt());
                stm.setBoolean(6, sv.isGioiTinh());
                stm.setString(7, sv.getDiaChi());
                stm.setString(8, sv.getHinhAnh());
                stm.executeUpdate();
                System.out.println("Insert thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//-----------------------------------------------------------------------------------------------------------
    @Override
    public void delete(int index) {
        _lstSinhVien.remove(index);
    }

    @Override
    public void Delete_Database(String masv) {
        String sql = "{CALL DELETE_MASV(?)}";
        try (Connection con = JDBC.getConnection();
                CallableStatement stm = con.prepareCall(sql)) {
            stm.setString(1, masv);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Lỗi xóa sql");
            e.printStackTrace();
        }
    }
//-----------------------------------------------------------------------------
 
        @Override
     public void update_Database(SinhVien sv) {
        String sql = "UPDATE STUDENT SET HOTEN = ?,NGAYSINH = ?,EMAIL=?,"
                + "SDT =?,GIOITINH =?,DIACHI=?,HINH =? WHERE MASV = ?";
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
                stm.setString(1, sv.getHoTen());
                stm.setDate(2,new java.sql.Date(sv.getNgaySinh().getTime()));
                stm.setString(3, sv.getEmail());
                stm.setString(4, sv.getSdt());
                stm.setBoolean(5, sv.isGioiTinh());
                stm.setString(6, sv.getDiaChi());
                stm.setString(7, sv.getHinhAnh());
                stm.setString(8, sv.getMaSV());
                stm.executeUpdate();
                if(stm.executeUpdate()>0){
                    System.out.println("update thanh cong");
                }else{
                    System.out.println("update khong thanh cong");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//--------------------------------------------------------------------------------
    @Override
    public SinhVien findById(String maSV) {
        for (SinhVien x : _lstSinhVien) {
            if (maSV.equalsIgnoreCase(x.getMaSV())) {
                return x;
            }
        }
        return null;
    }

}
