/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

/**
 *
 * @author user
 */
import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class update {

    public static void updateData(String id, String merk, String model, String harga) {
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE sepatu SET merek=?, model=?, harga=? WHERE id=?");
            stmt.setString(1, merk);
            stmt.setString(2, model);
            stmt.setString(3, harga);
            stmt.setString(4, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "PRODUK BERHASIL DIUBAH", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleTableMouseClicked(JTable jTable, DefaultTableModel DftTblModel_barang,
            JTextField jTextField_id, JTextField jTextField_merk, JTextField jTextField_model, JTextField jTextField_harga) {
        int baris = jTable.getSelectedRow();
        jTextField_id.setText(DftTblModel_barang.getValueAt(baris, 0).toString());
        jTextField_merk.setText(DftTblModel_barang.getValueAt(baris, 1).toString());
        jTextField_model.setText(DftTblModel_barang.getValueAt(baris, 2).toString());
        jTextField_harga.setText(DftTblModel_barang.getValueAt(baris, 3).toString());
    }
}
