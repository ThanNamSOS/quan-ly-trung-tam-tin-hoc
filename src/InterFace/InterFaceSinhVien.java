
package InterFace;

import Model.SinhVien;
import java.util.ArrayList;

public interface InterFaceSinhVien {
    public ArrayList<SinhVien> listSinhVien();
    void save(SinhVien sv);
    void delete(int index);
    void Delete_Database(String masv);
    public SinhVien findById(String maSV);
    void update_Database(SinhVien sv);
    
}
