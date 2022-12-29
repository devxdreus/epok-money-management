/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import com.mysql.jdbc.Driver;
import Main.DashboardNew;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import connect.Koneksi;
import java.util.Date;
import javax.swing.JOptionPane;
import login.login;
import controller.Transaction;
import java.lang.reflect.Field;
import java.sql.Connection;

/**
 *
 * @author INSPIRON N4050
 */
public class Transaksi_Lanjut extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi_Lanjut
     */
    public Transaksi_Lanjut() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        Nama = new javax.swing.JLabel();
        Nominal = new javax.swing.JLabel();
        txtNominal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbJenis = new javax.swing.JComboBox<>();
        dtTanggal = new com.toedter.calendar.JDateChooser();
        btnSimpan1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("Tambah Transaksi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 59, -1, -1));

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 289, -1));

        Nama.setText("Deskripsi Transaksi");
        jPanel1.add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        Nominal.setText("Nominal");
        jPanel1.add(Nominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        txtNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNominalActionPerformed(evt);
            }
        });
        jPanel1.add(txtNominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 289, -1));

        jLabel4.setText("Kategori");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-", "Makan", "Transportasi", "Belanja", "Lainnya" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });
        jPanel1.add(cmbKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 290, -1));

        jLabel5.setText("Tanggal");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        btnSimpan.setBackground(new java.awt.Color(230, 229, 163));
        btnSimpan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnSimpan.setText("Kembali");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel2.setText("Jenis");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, -1));

        cmbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-", "Pendapatan", "Pengeluaran" }));
        jPanel1.add(cmbJenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 290, -1));
        jPanel1.add(dtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 290, -1));

        btnSimpan1.setBackground(new java.awt.Color(230, 229, 163));
        btnSimpan1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        btnSimpan1.setText("Tambah Transaksi+");
        btnSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 583, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNominalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNominalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        Transaksi back = new Transaksi();
        back.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void btnSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan1ActionPerformed
        String namaTransaksi = txtNama.getText();
        int nominal = Integer.parseInt(txtNominal.getText());
        int kategori = cmbKategori.getSelectedIndex();
        int jenis = cmbJenis.getSelectedIndex();
        Date tanggal = dtTanggal.getDate();
        
        if (kategori == 0 || jenis == 0){
            JOptionPane.showMessageDialog(null, "Masukkan Pilihan!");
            return;
        }
    
        System.out.println(namaTransaksi);
        System.out.println(nominal);
        System.out.println(kategori);
        System.out.println(jenis);
        System.out.println(tanggal);
 
        
        boolean result = Transaction.add(namaTransaksi, nominal, jenis, kategori, tanggal);
        
        if (!result){
            JOptionPane.showMessageDialog(null, "Transaksi Gagal Disimpan");
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Transaksi Berhasil Disimpan");
        Transaksi transaksi = new Transaksi();
        transaksi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSimpan1ActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi_Lanjut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Lanjut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Lanjut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Lanjut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Lanjut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel Nominal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpan1;
    private javax.swing.JComboBox<String> cmbJenis;
    private javax.swing.JComboBox<String> cmbKategori;
    private com.toedter.calendar.JDateChooser dtTanggal;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNominal;
    // End of variables declaration//GEN-END:variables
}