/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import config.Koneksi;

public class authRegister {

    public static void registerUser(String username, String password) {
        try ( Connection connection = Koneksi.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try ( PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
