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
//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class read {

    public static DefaultTableModel readData() {
        DefaultTableModel DftTblModel_barang = new DefaultTableModel();
        DftTblModel_barang.addColumn("ID");
        DftTblModel_barang.addColumn("MERK");
        DftTblModel_barang.addColumn("MODEL");
        DftTblModel_barang.addColumn("HARGA");

        Connection conn = Koneksi.getConnection();

        try {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM sepatu";
            ResultSet res = stmt.executeQuery(SQL);

            while (res.next()) {
                DftTblModel_barang.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("merek"),
                    res.getString("model"),
                    //                        res.getString("ram"),
                    res.getString("harga")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return DftTblModel_barang;
    }
}
