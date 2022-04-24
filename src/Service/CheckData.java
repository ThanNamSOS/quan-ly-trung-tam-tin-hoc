package Service;

import Model.SinhVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class CheckData {
    public static boolean checkGmail(JTextField txt) {
        if (!txt.getText().matches(".+@.+\\..+")) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, "Mail sai định dạng mời nhập lại");
            return true;
        }
        return false;
    }
    public static boolean checkDiem(JTextField diemsv){
        try {
            Float.parseFloat(diemsv.getText());
            if(Float.parseFloat(diemsv.getText()) > 10 || Float.parseFloat(diemsv.getText()) < 0){
                JOptionPane.showMessageDialog(null, "Thang điểm từ 0 - 10");
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Điểm phải là số.");
            diemsv.requestFocus();
            return true;
        }
        return false;
    }
    public static boolean checkRong(JTextComponent txt, String mss) {
        if (txt.getText().trim().isEmpty()) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, mss);
            return true;
        }
        return false;
    }
   
}
