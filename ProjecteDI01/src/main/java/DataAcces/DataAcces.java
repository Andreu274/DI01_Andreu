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
    
    public int updateNomUsuari(int userId, String newNom){

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
    


    public ArrayList<Intent> getPendingAttempts() {
        ArrayList<Intent> pendingAttempts = new ArrayList<>();
        String sql = """
            SELECT Intents.* FROM Intents LEFT JOIN Review ON Review.Id = Intents.Id WHERE Review.Id IS NULL ORDER BY Intents.Timestamp_Inici;
        """;

        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Intent intent = new Intent();
                intent.setId(resultSet.getInt("Id"));
                intent.setIdUsuari(resultSet.getInt("IdUsuari"));
                intent.setIdExercici(resultSet.getInt("IdExercici"));
                intent.setTimestampInici(resultSet.getDate("Timestamp_Inici"));
                intent.setTimestampFi(resultSet.getDate("Timestamp_Fi"));
                intent.setVideofile(resultSet.getString("Videofile"));
                pendingAttempts.add(intent);
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pendingAttempts;
    }

    
    public ArrayList<Usuari> getAllUsers() {
        ArrayList<Usuari> users = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris ORDER BY Nom"; // Ordena por nombre, opcional

        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("IsInstructor"));
                users.add(user);
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }


    public ArrayList<Intent> getAllAttemptsForUser(int userId) {
        ArrayList<Intent> attempts = new ArrayList<>();
            String sql ="SELECT i.Id, i.IdUsuari, i.IdExercici, i.Timestamp_Inici, i.Timestamp_Fi, i.Videofile, e.NomExercici\n" +
                        "FROM Intents i\n" +
                        "JOIN Exercicis e ON i.IdExercici = e.Id\n" +
                        "WHERE i.IdUsuari = ? \n" +
                        "ORDER BY i.Timestamp_Inici;";

        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Intent intent = new Intent();
                intent.setId(resultSet.getInt("Id"));
                intent.setIdUsuari(resultSet.getInt("IdUsuari"));
                intent.setIdExercici(resultSet.getInt("IdExercici"));
                intent.setTimestampInici(resultSet.getDate("Timestamp_Inici"));
                intent.setTimestampFi(resultSet.getDate("Timestamp_Fi"));
                intent.setVideofile(resultSet.getString("Videofile"));
                intent.setExerciseName(resultSet.getString("NomExercici")); // Establecer el nombre del ejercicio
                attempts.add(intent);
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }

        return attempts;
    }
    
    public Intent getAttemptById(int attemptId) {
        Intent intent = null;
        String sql = "SELECT i.*, e.NomExercici FROM Intents i "
                   + "JOIN Exercicis e ON i.IdExercici = e.Id "
                   + "WHERE i.Id = ?";

        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, attemptId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                intent = new Intent();
                intent.setId(resultSet.getInt("Id"));
                intent.setIdUsuari(resultSet.getInt("IdUsuari"));
                intent.setIdExercici(resultSet.getInt("IdExercici"));
                intent.setTimestampInici(resultSet.getDate("Timestamp_Inici"));
                intent.setTimestampFi(resultSet.getDate("Timestamp_Fi"));
                intent.setVideofile(resultSet.getString("Videofile"));
                intent.setExerciseName(resultSet.getString("NomExercici"));
            }

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAcces.class.getName()).log(Level.SEVERE, null, ex);
        }

        return intent;
    }





    
    
}
