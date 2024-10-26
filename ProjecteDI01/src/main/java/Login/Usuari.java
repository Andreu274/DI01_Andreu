/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Maqrok
 */
public class Usuari {
    private int Id;
    private String Nom;
    private String Email;
    private String PasswordHash;
    private byte[] Foto;
    private boolean Instructor;

    public int getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public String getEmail() {
        return Email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public boolean isInstructor() {
        return Instructor;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public void setInstructor(boolean Instructor) {
        this.Instructor = Instructor;
    }
}

    