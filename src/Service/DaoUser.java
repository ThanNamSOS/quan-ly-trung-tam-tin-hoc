package Service;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Main.QLDiem;
import Main.QLSinhVien;

public class DaoUser {

    QLDiem qLDiem = new QLDiem();
    QLSinhVien qLSinhVien = new QLSinhVien();


    public ArrayList<User> getArrayListUser(){
        String sql = "select * from USERS";
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
                ResultSet rs = stm.executeQuery();
                String user,pass,role;
                ArrayList list = new ArrayList();
                while (rs.next()) {                
                    user = rs.getString(1);
                    pass = rs.getString(2);
                    role = rs.getString(3);
                    User u = new User(user, pass, role);
                    list.add(u);
            }
                return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Truy vấn USERS thất bại.");
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<User> getArrayListUserChucVu(String rolee) throws Exception{
        String sql = "select * from USERS where ROLEE = ?";
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, rolee);
            ResultSet rs = stm.executeQuery();
            ArrayList _lstUserGV = new ArrayList<>();
            while (rs.next()) {                
                _lstUserGV.add(new User(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return _lstUserGV;
        } 
    }
}
