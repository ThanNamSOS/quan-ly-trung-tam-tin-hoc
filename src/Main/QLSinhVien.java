package Main;

import Service.DAO_QLSinhVien;
import InterFace.InterFaceSinhVien;
import Model.SinhVien;
import Service.CheckData;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class QLSinhVien extends javax.swing.JFrame {

    InterFaceSinhVien faceSinhVien = new DAO_QLSinhVien();
    ArrayList<SinhVien> _ListSinhVien = faceSinhVien.listSinhVien();

    DefaultTableModel model;
    private JFileChooser choice;
     private final String path = "IMG_SQL\\IMG\\";
     private final String imgType = "png";
    public QLSinhVien() {
        initComponents();
        setLocationRelativeTo(null);
        choice = new JFileChooser("C:\\Users\\Admin\\OneDrive\\Máy tính\\Java3\\Test\\SOF203_Assignment_NamTVPH13393\\IMG_SQL");
        choice.setFileFilter(new FileNameExtensionFilter("Image File", "jpg", "png"));
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        fillToTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void fillToTable() {
        model = (DefaultTableModel) tblSinhVien.getModel();
        model.setRowCount(0);
        for (SinhVien x : _ListSinhVien) {
            String gioiTinh = x.isGioiTinh() ? "Nam" : "Nữ";
            model.addRow(new Object[]{x.getMaSV(), x.getHoTen(),x.getNgaySinh(), x.getEmail(), x.getSdt(), gioiTinh, x.getDiaChi(), x.getHinhAnh()});
        }
        tblSinhVien.setModel(model);
    }

    public SinhVien getSinhVien() {
        
        boolean gioiTinh = false;
        if (rdoNam.isSelected()) {
            gioiTinh = true;
        }
       String imgName = null;
        if (lblHinhAnh.getIcon() != null) {
            int index = tblSinhVien.getSelectedRow();
            if (index == -1) {
                imgName = saveImage(((ImageIcon) lblHinhAnh.getIcon()).getImage(), getOriginalImageName(choice.getSelectedFile()));
                System.out.println("img 1: "+imgName);
            } else {
                System.out.println("img null");
                imgName = faceSinhVien.listSinhVien().get(index).getHinhAnh();
            }
        }
        return new SinhVien(txtMaSV.getText(), txtHoTen.getText(), Jdate.getDate(), txtEmail.getText(), txtSDT.getText(), gioiTinh, txtDiaChi.getText(), imgName);
    }

    public void ShowDetail(int index)throws Exception{
        SinhVien sv = faceSinhVien.listSinhVien().get(index);
        txtMaSV.setText(sv.getMaSV());
        txtHoTen.setText(sv.getHoTen());
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sv.getNgaySinh().toString());
        Jdate.setDate(date);
        txtEmail.setText(sv.getEmail());
        txtSDT.setText(sv.getSdt());
        txtDiaChi.setText(sv.getDiaChi());
        boolean gt = true;
        if (sv.isGioiTinh()) {
            rdoNam.setSelected(gt);
        } else {
            rdoNu.setSelected(gt);
        }
        lblHinhAnh.setIcon(sv.getHinhAnh()!= null ? getHinhAnh(sv.getHinhAnh()) : null);

    }

    public void loadTable() {
        model.setRowCount(0);
        for (SinhVien x : faceSinhVien.listSinhVien()) {
            String gt = x.isGioiTinh() ? "Nam" : "Nữ";
            model.addRow(new Object[]{x.getMaSV(), x.getHoTen(),x.getNgaySinh(), x.getEmail(), x.getSdt(), gt, x.getDiaChi(), x.getHinhAnh()});
        }
        tblSinhVien.setModel(model);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        btnNew = new javax.swing.JToggleButton();
        btnSave = new javax.swing.JToggleButton();
        btnDelete = new javax.swing.JToggleButton();
        btnUpdate = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        Jdate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FROM QUAN LY SINH VIEN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Mã SV:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhAnhMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MA SV", "HO TEN", "NGAY SINH", "EMAIL", "SDT", "GIOI TINH", "DIA CHI", "ẢNH"
            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSinhVien);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Họ Tên");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Ngày Sinh");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Email");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Gioi Tinh");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("SDT");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 204));
        jLabel14.setText("Địa Chỉ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(jLabel14))
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rdoNam)
                            .addGap(18, 18, 18)
                            .addComponent(rdoNu))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(98, 98, 98)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDelete)
                                .addComponent(btnNew))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnUpdate)
                                .addComponent(btnSave))
                            .addContainerGap(103, Short.MAX_VALUE))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnNew, btnSave, btnUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnSave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (CheckData.checkRong(txtMaSV, "Bạn chưa nhập mã sinh viên")
                    || CheckData.checkRong(txtHoTen, "Bạn chưa nhập Họ tên")
                    || CheckData.checkRong(txtEmail, "Bạn chưa nhập Email")
                    || CheckData.checkRong(txtSDT, "Bạn chưa nhập SDT")
                    || CheckData.checkRong(txtDiaChi, "Bạn chưa nhập địa chỉ")
                    || CheckData.checkGmail(txtEmail)) {
                return;
            }
            SinhVien sv = getSinhVien();
            for (SinhVien x : _ListSinhVien) {
                if(x.getMaSV().equalsIgnoreCase(sv.getMaSV())){
                    JOptionPane.showMessageDialog(this, "Mã Sinh viên đã tồn tại.");
                    txtMaSV.requestFocus();
                    return;
                }
            }
            if(sv != null){
                System.out.println(sv.getHoTen()+ sv.getHinhAnh());
            faceSinhVien.save(sv);
            loadTable();
            }else{
                System.out.println("Loi getSinhVien");
                return;
            }
        } catch (Exception e) {
            System.out.println("Erro Save");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int index = tblSinhVien.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Chọn sinh viên cần xóa trên table...");
                return;
            }
            faceSinhVien.delete(index);
            System.out.println("xóa list thành công");
            faceSinhVien.Delete_Database(txtMaSV.getText());
            System.out.println("Xóa sv theo mã thành công");
            _ListSinhVien = faceSinhVien.listSinhVien();
            loadTable();
        } catch (Exception e) {
            System.out.println("Erro Delete SV");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        try {
            int index = tblSinhVien.getSelectedRow();
            ShowDetail(index);
            System.out.println("Click Table row " + index);
        } catch (Exception e) {
            System.out.println("Click Die");
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int index = tblSinhVien.getSelectedRow();
        if (CheckData.checkRong(txtMaSV, "Bạn chưa nhập mã sinh viên")
                    || CheckData.checkRong(txtHoTen, "Bạn chưa nhập Họ tên")
                    || CheckData.checkRong(txtEmail, "Bạn chưa nhập Email")
                    || CheckData.checkRong(txtSDT, "Bạn chưa nhập SDT")
                    || CheckData.checkRong(txtDiaChi, "Bạn chưa nhập địa chỉ")
                    || CheckData.checkGmail(txtEmail)) {
                return;
            }
//        if (index < 0) {
//            JOptionPane.showMessageDialog(this, "Chọn 1 sinh viên muốn sửa");
//            return;
//        }
        SinhVien sv = getSinhVien();
        if(sv.getMaSV().equalsIgnoreCase(txtMaSV.getText())){
             faceSinhVien.update_Database(sv);
            loadTable();
        }else{
            JOptionPane.showMessageDialog(this, "Sinh viên không tồn tại - hoặc bạn nhập sai mã");
            txtMaSV.requestFocus();
            return;
        }
        } catch (Exception e) {
            System.out.println("Errro update");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtMaSV.setText("");
        txtHoTen.setText("");
        Jdate.setDate(null);
        txtEmail.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        rdoNam.setSelected(true);
        lblHinhAnh.setIcon(null);
        tblSinhVien.clearSelection();
    }//GEN-LAST:event_btnNewActionPerformed

    private void lblHinhAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMousePressed
        if (choice.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = choice.getSelectedFile();
            System.out.println("file" +file);
            try {
                lblHinhAnh.setIcon(new ImageIcon(ImageIO.read(file).getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                System.out.println("Erro HinhAnhMousePressed");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_lblHinhAnhMousePressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Jdate;
    private javax.swing.JToggleButton btnDelete;
    private javax.swing.JToggleButton btnNew;
    private javax.swing.JToggleButton btnSave;
    private javax.swing.JToggleButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables

    private Icon getHinhAnh(String hinhAnh) {
        return new ImageIcon(path + hinhAnh);
    }
    private String getOriginalImageName(File file) {
        return file.getName().split("\\.")[0];
    }
    private String saveImage(Image image, String name) {
        BufferedImage img = new BufferedImage(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        File saveImg = new File(path + name + "." + imgType);

        try {
            ImageIO.write(img, imgType, saveImg);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return saveImg.getName();
    }
}
