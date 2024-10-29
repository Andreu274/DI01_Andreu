/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Maqrok
 */
public class DataAcces {
    private Connection getConnection(){
        Connection connection = null;
        
        String connectionString = "jdbc:sqlserver://localhost;database=simulapdb;" + "user=sa;password=12345678;" + "trustServerCertificate=true;";
        //String connectionString = "jdbc:sqlserver://localhost;database=simulapdb;" + "user=maqrok;password=12345678;" + "trustServerCertificate=true;";
        
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    public ArrayList<Usuari> getUsuaris(){
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM usuaris";
        
        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()){
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                //user.setFoto(resultSet.getBytes("Foto"));
                user.setInstructor(resultSet.getBoolean("IsInstructor"));
                usuaris.add(user);
                         
            }
            
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuaris;
    }
    
    public Usuari getUsuari(String email){
        Usuari user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email=?";

        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()){
                user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                //user.setFoto(resultSet.getBytes("Foto"));
                user.setInstructor(resultSet.getBoolean("IsInstructor"));

            }

            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
    
    public int registerUser(Usuari u){
        Connection connection = getConnection();
        String sql = "INSERT INTO Usuaris(Nom, Email, PasswordHash, IsInstructor)" + " VALUES (?,?,?,?);";
        
        
        try {
            PreparedStatement insertStatement = connection.prepareStatement(sql);
            insertStatement.setString(1, u.getNom());
            insertStatement.setString(2, u.getEmail());
            insertStatement.setString(3, u.getPasswordHash());
            insertStatement.setBoolean(4, u.isInstructor());
            
            insertStatement.executeUpdate();
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return 0;
    }
    
    public int getLastInsertedUserId(){
        String sql = "SELECT MAX(Id) FROM usuaris";
        int UserId = 0;
        
        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()){
                UserId = resultSet.getInt(1);
            }
            
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return UserId;
    }
    
    public int updateNomUsuari(int userId, String newNom)
    {

        String sql = "UPDATE Usuaris SET Nom = ? WHERE Id = ?";
        Connection connection = getConnection();

    try {

        PreparedStatement updateStatement = connection.prepareStatement(sql);
        updateStatement.setString(1, newNom); 
        updateStatement.setInt(2, userId); 

        updateStatement.executeUpdate();

        connection.close();
    } catch (SQLException ex) {
        // Manejo de excepciones
        Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);


        }
        return 0;
    }
}
