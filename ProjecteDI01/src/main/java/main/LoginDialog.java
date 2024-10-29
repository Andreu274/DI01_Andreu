/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package main;


import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import at.favre.lib.crypto.bcrypt.BCrypt;
import DataAcces.Usuari;
import DataAcces.DataAcces;

/**
 *
 * @author Maqrok
 */
public class LoginDialog extends javax.swing.JDialog {

    private DataAcces da = new DataAcces();
    /**
     * Creates new form Login
     */
    public LoginDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Icono = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        PswLabel = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        PswText = new javax.swing.JPasswordField();
        Loginbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        Icono.setText("jLabel1");

        EmailLabel.setText("Email");

        PswLabel.setText("Password");

        PswText.setText("jPasswordField1");

        Loginbutton.setText("Login");
        Loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Loginbutton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PswLabel)
                            .addComponent(Icono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmailText)
                            .addComponent(PswText, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Icono, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmailLabel)
                            .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PswLabel)
                            .addComponent(PswText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addComponent(Loginbutton))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void LoginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginbuttonActionPerformed
        // TODO add your handling code here:
        Usuari usuari = da.getUsuari(EmailText.getText());
        if (usuari != null){
            // Comporbar password
            char[] passwordtoverify = PswText.getPassword();
            String UserPasswordHashInDatabase = usuari.getPasswordHash();
            var result = BCrypt.verifyer().verify(passwordtoverify, UserPasswordHashInDatabase);
            if(usuari.isInstructor()){
                if(result.verified){
                    JOptionPane.showMessageDialog(this, "Login correcte. Benvingut " + usuari.getNom() + "!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Contrasenya incorrecta");
                }
            } else{
                JOptionPane.showMessageDialog(this, "Error: Usuari no autoritzat");
            }
        } else{
            JOptionPane.showMessageDialog(this, "Error: Usuari incorrecte o inexistent");
        }
    }//GEN-LAST:event_LoginbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear y mostrar el diálogo
        SwingUtilities.invokeLater(() -> {
            JFrame parentFrame = new JFrame();
            parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            parentFrame.setVisible(true); // Asegúrate de que el marco esté visible

            LoginDialog login = new LoginDialog(parentFrame, true);
            login.setVisible(true); // Mostrar el diálogo
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailText;
    private javax.swing.JLabel Icono;
    private javax.swing.JButton Loginbutton;
    private javax.swing.JLabel PswLabel;
    private javax.swing.JPasswordField PswText;
    // End of variables declaration//GEN-END:variables
}
