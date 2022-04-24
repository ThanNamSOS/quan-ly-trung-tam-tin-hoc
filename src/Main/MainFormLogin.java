package Main;

import Service.DaoUser;
import Model.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFormLogin extends javax.swing.JFrame {

    DaoUser daoUser = new DaoUser();
    ArrayList<User> listUser1 = daoUser.getArrayListUser();
    QLDiem qLDiem = new QLDiem();
    QLSinhVien qLSinhVien = new QLSinhVien();

    public MainFormLogin() {
        initComponents();
        setLocationRelativeTo(null);
        System.out.println(listUser1);
    }

    public boolean checkFormLogin(JTextField txtusers, JPasswordField txtPasss) {
        if (txtusers.getText().isEmpty() || txtPasss.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại bạn chua nhập thông tin!");
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassWord = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnUser2 = new javax.swing.JButton();
        btnUser1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FPT POLYTECHNIC");

        jpnLogin.setBackground(new java.awt.Color(51, 51, 255));
        jpnLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        btnLogin.setBackground(new java.awt.Color(255, 0, 0));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");

        javax.swing.GroupLayout jpnLoginLayout = new javax.swing.GroupLayout(jpnLogin);
        jpnLogin.setLayout(jpnLoginLayout);
        jpnLoginLayout.setHorizontalGroup(
            jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLoginLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnLoginLayout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel))
                    .addGroup(jpnLoginLayout.createSequentialGroup()
                        .addGroup(jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(txtPassWord, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jpnLoginLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnLogin});

        jpnLoginLayout.setVerticalGroup(
            jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jpnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnLogin))
                .addGap(20, 20, 20))
        );

        btnUser2.setText("USER2");
        btnUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUser2ActionPerformed(evt);
            }
        });

        btnUser1.setText("USER1");
        btnUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jpnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUser1)
                        .addGap(29, 29, 29)
                        .addComponent(btnUser2))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jpnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUser2)
                    .addComponent(btnUser1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            boolean checkUS = false;
            boolean checkPW = false;
            if (checkFormLogin(txtUser, txtPassWord)) {
                return;
            }
            for (User user : listUser1) {
                if (user.getUserName().equalsIgnoreCase(txtUser.getText())) {
                    checkUS = true;
                    if (user.getPassword().equalsIgnoreCase(txtPassWord.getText())) {
                        checkPW = true;
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công với chức vụ " + user.getRole());
                        if (user.getRole().equalsIgnoreCase("GIAOVIEN")) {
                            QLDiem diem = new QLDiem();
                            diem.setVisible(true);
                        } else if (user.getRole().equalsIgnoreCase("PHONGDAOTAO")) {
                            QLSinhVien lSinhVien = new QLSinhVien();
                            lSinhVien.setVisible(true);
                        } else if (user.getRole().equalsIgnoreCase("ADMIN")) {
                            QLSinhVien lSinhVien = new QLSinhVien();
                            lSinhVien.setVisible(true);
                            QLDiem diem = new QLDiem();
                            diem.setVisible(true);
                        }
                    }
                }
            }
            if (checkUS == false) {
                JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại");
                txtUser.requestFocus();
                return;
            }
            if (checkPW == false) {
                JOptionPane.showMessageDialog(this, "Sai Mat Khau");
                txtPassWord.requestFocus();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUser1ActionPerformed
        txtUser.setText("user1");
        txtPassWord.setText("513223");
    }//GEN-LAST:event_btnUser1ActionPerformed

    private void btnUser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUser2ActionPerformed
        txtUser.setText("user2");
        txtPassWord.setText("513223");
    }//GEN-LAST:event_btnUser2ActionPerformed
    public void windowClosing(WindowEvent e) {
        int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình không?",
                null, JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

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
            java.util.logging.Logger.getLogger(MainFormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFormLogin().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnUser1;
    private javax.swing.JButton btnUser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jpnLogin;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
