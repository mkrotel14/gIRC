/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.integrado.gIRC2;

import javax.swing.JOptionPane;
import model.LoginModelo;
import controller.LoginController;

/**
 *
 * @author Gian Carlo Mantuan
 */
public class LoginFrame extends javax.swing.JFrame {
    
    private LoginController daologin = new LoginController();    
    private LoginModelo modlogin = new LoginModelo();
    public Integer ret;
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUserLabel = new javax.swing.JLabel();
        jSenhaLabel = new javax.swing.JLabel();
        jUserField = new javax.swing.JTextField();
        jSenhaField = new javax.swing.JTextField();
        jExitButton = new javax.swing.JButton();
        jEnterButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - gIRC");

        jUserLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jUserLabel.setText("Usuario");

        jSenhaLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jSenhaLabel.setText("Senha");

        jUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserFieldActionPerformed(evt);
            }
        });

        jSenhaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSenhaFieldActionPerformed(evt);
            }
        });

        jExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitButtonActionPerformed(evt);
            }
        });

        jEnterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enter.png"))); // NOI18N
        jEnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEnterButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel3.setText("gIRC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSenhaField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUserLabel)
                            .addComponent(jSenhaLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jUserField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 345, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jEnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(jUserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSenhaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSenhaField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jEnterButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSenhaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSenhaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSenhaFieldActionPerformed

    private void jUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserFieldActionPerformed

    private void jEnterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEnterButtonActionPerformed
        modlogin.setUsuario(jUserField.getText());
        modlogin.setSenha(jSenhaField.getText());
        ret = daologin.loginAccess(modlogin);
        
        if (ret.equals(0)){
            JOptionPane.showMessageDialog(null,"Acesso negado");
        } else {
            JOptionPane.showMessageDialog(null, "Olá, seja bem vindo ao gIRC");
            setVisible(false);
            new MensagensFrame(ret).setVisible(true);
            
        }
    }//GEN-LAST:event_jEnterButtonActionPerformed
  
    private void jExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jExitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jEnterButton;
    private javax.swing.JButton jExitButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jSenhaField;
    private javax.swing.JLabel jSenhaLabel;
    private javax.swing.JTextField jUserField;
    private javax.swing.JLabel jUserLabel;
    // End of variables declaration//GEN-END:variables
}
