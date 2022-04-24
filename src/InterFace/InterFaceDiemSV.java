package InterFace;

import Model.Diem;
import java.util.ArrayList;

public interface InterFaceDiemSV {
    public void add(Diem gr);
        public void delete(int viTri);
        public Diem search(int viTri);
        public ArrayList<Diem> listQLDiem();
        public ArrayList<Diem> listTop3SV();
        public Diem getSV(String maSV);
        public void DeleteDatabase(String maSv);
        public void updateDiem(Diem gr);
        public void loadDataToTable();
}
