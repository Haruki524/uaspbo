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
import java.sql.ResultSet;
import java.sql.SQLException;
import config.Koneksi;

public class authLogin {

    public static boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try ( Connection connection = Koneksi.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if there is at least one matching user
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getUserRole(String username) {
        String userRole = null;
        String query = "SELECT role FROM users WHERE username = ?";

        try ( Connection connection = Koneksi.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    userRole = resultSet.getString("role");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRole;
    }
}
