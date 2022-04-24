package Main;

import Service.DAO_QLDiem;
import Service.JDBC;
import InterFace.InterFaceDiemSV;
import InterFace.InterFaceSinhVien;
import Model.Diem;
import Model.SinhVien;
import Service.CheckData;
import Service.DAO_QLSinhVien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLDiem extends javax.swing.JFrame {

    DefaultTableModel model_table;
    InterFaceDiemSV dAO_QLDiem = new DAO_QLDiem();
    InterFaceSinhVien QLSV = new DAO_QLSinhVien();
    Model.Diem diem = new Model.Diem();
    ArrayList<Model.Diem> _lstQLDiem = dAO_QLDiem.listQLDiem();
    ArrayList<Model.Diem> _lst3QLDiem = dAO_QLDiem.listTop3SV();
    ArrayList<SinhVien> _listSV = QLSV.listSinhVien();

    public QLDiem() {
        initComponents();
        model_table = (DefaultTableModel) tblTop3SV.getModel();
        setLocationRelativeTo(null);
        loadTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }

    public void clearForm() {
        txtMaSV.setText("");
        txtSearchMaSV.setText("");
        txtTiengAnh.setText("");
        txtTinHoc.setText("");
        txtGDTC.setText("");
        tblTop3SV.clearSelection();
    }

    public void showDetail(int index) {
        Model.Diem diem = dAO_QLDiem.listQLDiem().get(index);
        txtMaSV.setText(diem.getSv().getMaSV());
        txtTiengAnh.setText(String.valueOf(diem.getTiengAnh()));
        txtTinHoc.setText(String.valueOf(diem.getTinHoc()));
        txtGDTC.setText(String.valueOf(diem.getGdtc()));
        float diemTB = (diem.getTiengAnh() + diem.getTinHoc() + diem.getGdtc()) / 3;
        lblDiemTB.setText(String.format("%.1f", diemTB));
        lblHoTen.setText(diem.getSv().getHoTen());
    }

    public void showDetail(Diem diem) {
        txtMaSV.setText(diem.getSv().getMaSV());
        txtTiengAnh.setText(String.valueOf(diem.getTiengAnh()));
        txtTinHoc.setText(String.valueOf(diem.getTinHoc()));
        txtGDTC.setText(String.valueOf(diem.getGdtc()));
        float diemTB = (diem.getTiengAnh() + diem.getTinHoc() + diem.getGdtc()) / 3;
        lblDiemTB.setText(String.format("%.1f", diemTB));
        lblHoTen.setText(diem.getSv().getHoTen());
    }

//    public void fillToTable() {
//        model = (DefaultTableModel) tblTop3SV.getModel();
//        model.setRowCount(0);
//        for (Model.Diem x : _lstQLDiem) {
//            model.addRow(new Object[]{x.getSv().getMaSV(), x.getSv().getHoTen(), x.getTiengAnh(), x.getTinHoc(), x.getGdtc(), x.getDiemTB()});
//        }
//        tblTop3SV.setModel(model);
//    }

    public void loadTable() {
        _lstQLDiem.clear();
        this.model_table.setRowCount(0);
        for (Diem x : dAO_QLDiem.listQLDiem()) {
            model_table.addRow(new Object[]{x.getSv().getMaSV(), x.getSv().getHoTen(), x.getTiengAnh(), x.getTinHoc(), x.getGdtc(), x.getDiemTB(),});
        }
    }

    public Diem getDiemSV() {
        Diem diem = new Diem();
        SinhVien sv = new SinhVien(txtMaSV.getText());
        diem.setSv(sv);
        diem.setTiengAnh(Float.parseFloat(txtTiengAnh.getText()));
        diem.setTinHoc(Float.parseFloat(txtTinHoc.getText()));
        diem.setGdtc(Float.parseFloat(txtGDTC.getText()));
        return diem;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSearchMaSV = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtTiengAnh = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        txtGDTC = new javax.swing.JTextField();
        lblDiemTB = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnBackWard = new javax.swing.JButton();
        btnFowar = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTop3SV = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search-icon-24.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 204));
        jLabel14.setText("Mã SV");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(35, 35, 35)
                .addComponent(txtSearchMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Mã SV:");

        txtMaSV.setEditable(false);

        lblDiemTB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDiemTB.setForeground(new java.awt.Color(0, 0, 204));
        lblDiemTB.setText("0,0");

        lblHoTen.setText("...");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Họ Tên");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Tiếng Anh");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Tin Học");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("GDTC");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("Điểm TB");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoTen)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGDTC, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(txtTinHoc)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblDiemTB)
                        .addGap(84, 84, 84))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHoTen)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(lblDiemTB)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Button-First-icon-48.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBackWard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Fast-backward-icon2-48.png"))); // NOI18N
        btnBackWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackWardActionPerformed(evt);
            }
        });

        btnFowar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Button-Forward-icon-48.png"))); // NOI18N
        btnFowar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFowarActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Button-Last-icon-48.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        tblTop3SV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MASV", "HOTEN", "TIENGANH", "TINHOC", "GDTC", "DIEM TB"
            }
        ));
        tblTop3SV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTop3SVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTop3SV);

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new-icon-16.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save-icon.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnNew, btnSave, btnUpdate});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("QUẢN LÝ ĐIỂM SINH VIÊN ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBackWard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFowar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast)
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnBackWard)
                    .addComponent(btnFowar)
                    .addComponent(btnLast))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (CheckData.checkRong(txtTiengAnh, "Bạn chưa nhập điểm tiếng anh")
                    || CheckData.checkRong(txtTinHoc, "Bạn chưa nhập điểm tin học")
                    || CheckData.checkRong(txtGDTC, "Bạn chưa nhập điểm GDTC")
                    || CheckData.checkDiem(txtTiengAnh)
                    || CheckData.checkDiem(txtTinHoc)
                    || CheckData.checkDiem(txtGDTC)) {
                return;
            }
//            dAO_QLDiem.updateDiem();
            int index = tblTop3SV.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Chọn học sinh muốn sửa điểm");
                return;
            }
            diem = getDiemSV();
            int choice = JOptionPane.showConfirmDialog(this, "Xác nhân sửa điểm của sinh viên: " + lblHoTen.getText(), "Xác nhận sửa điểm", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                return;
            }
            dAO_QLDiem.updateDiem(diem);
            loadTable();
        } catch (Exception e) {
            System.out.println("Update Erro");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblTop3SVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTop3SVMouseClicked
        try {
            int index = tblTop3SV.getSelectedRow();
            lblHoTen.setText(tblTop3SV.getValueAt(index, 1).toString());
            showDetail(index);
            String masv = dAO_QLDiem.listQLDiem().get(index).getSv().getHoTen();
            System.out.println("Click table diem");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblTop3SVMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int index = tblTop3SV.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Chọn một đối tượng sinh viên muốn xóa.");
                return;
            }
            dAO_QLDiem.delete(index);
            System.out.println("xoa vi tri thanh cong");
            dAO_QLDiem.DeleteDatabase(txtMaSV.getText());
            System.out.println("xoa sql thanh cong");
            _lstQLDiem = dAO_QLDiem.listQLDiem();
            loadTable();
        } catch (Exception e) {
            System.out.println("Loi delete");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (CheckData.checkRong(txtTiengAnh, "Bạn chưa nhập điểm tiếng anh")
                    || CheckData.checkRong(txtTinHoc, "Bạn chưa nhập điểm tin học")
                    || CheckData.checkRong(txtGDTC, "Bạn chưa nhập điểm GDTC")
                    || CheckData.checkDiem(txtTiengAnh)
                    || CheckData.checkDiem(txtTinHoc)
                    || CheckData.checkDiem(txtGDTC)) {
                return;
            }
            for (Diem x : dAO_QLDiem.listQLDiem()) {
                if (x.getSv().getMaSV().equalsIgnoreCase(txtMaSV.getText())) {
                    JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại");
                    return;
                }
            }
            Diem diem = getDiemSV();
            dAO_QLDiem.add(diem);
            loadTable();
            JOptionPane.showMessageDialog(null, "save Thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtSearchMaSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã cần tìm");
        } else {

            SinhVien sv = this.QLSV.findById(txtSearchMaSV.getText());
            if (sv != null) {
                Diem diem = dAO_QLDiem.getSV(sv.getMaSV());
                if (diem != null) {
                    showDetail(diem);
                }
                // neu sinh vien chua co diem txt null
                txtMaSV.setText(sv.getMaSV());
                lblHoTen.setText(sv.getHoTen());
                txtTinHoc.setText("null");
                txtGDTC.setText("null");
                txtTiengAnh.setText("null");
            } else {
                JOptionPane.showMessageDialog(this, "Mã sinh viên không tồn tại");
            }
            if (dAO_QLDiem.getSV(txtSearchMaSV.getText()) != null) {
                showDetail(dAO_QLDiem.getSV(txtSearchMaSV.getText()));
                // sinh vien da co diem thi show diem len from
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        int index = dAO_QLDiem.listQLDiem().size();
        if (index > 0) {
            index--;
            tblTop3SV.setRowSelectionInterval(index, index);
            showDetail(index);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnFowarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFowarActionPerformed
        int index = tblTop3SV.getSelectedRow();
        if (index < dAO_QLDiem.listQLDiem().size() - 1) {
            index++;
            tblTop3SV.setRowSelectionInterval(index, index);
            showDetail(dAO_QLDiem.listQLDiem().get(index));
        }
    }//GEN-LAST:event_btnFowarActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        if (model_table.getRowCount() > 0) {
            tblTop3SV.setRowSelectionInterval(0, 0);
            showDetail(0);
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackWardActionPerformed
        int index = tblTop3SV.getSelectedRow();
        if (index > 0) {
            index--;
            tblTop3SV.setRowSelectionInterval(index, index);
            showDetail(dAO_QLDiem.listQLDiem().get(index));
        }
    }//GEN-LAST:event_btnBackWardActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackWard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnFowar;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiemTB;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JTable tblTop3SV;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSearchMaSV;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables
}
