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

public class delete {

    public static void hapusData(String id) {
        Connection conn = Koneksi.getConnection();
        int confirm = JOptionPane.showConfirmDialog(null, "YAKIN INGIN MENGHAPUS PRODUK?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == 0) {
            try {
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM sepatu WHERE id = ?");
                stmt.setString(1, id);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "PRODUK BERHASIL DIHAPUS", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "PRODUK GAGAL DIHAPUS" + e.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
