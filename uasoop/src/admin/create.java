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

public class create {

    public static void simpanData(String id, String merk, String model, String harga) {
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO sepatu(id, merek, model, harga) VALUES(?,?,?,?)");
            stmt.setString(1, id);
            stmt.setString(2, merk);
            stmt.setString(3, model);
            stmt.setString(4, harga);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "PRODUK BERHASIL DISIMPAN", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
