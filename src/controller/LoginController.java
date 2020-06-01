/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConnectionPG;
import model.LoginModelo;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian Carlo Mantuan
 */
public class LoginController extends ConnectionPG {
    
    private StringBuilder sql = new StringBuilder();
    
    public Integer loginAccess (LoginModelo login) {
        super.executeSQL("SELECT * FROM irc.usuario WHERE usuario = '"+ login.getUsuario() +"'");        

        try {
            if (super.resultset == null) {
                super.executeSQL("SELECT * FROM irc.usuario WHERE senha = '"+ login.getSenha() +"'");
                
                if (super.resultset.first() == true) {                     
                    return (resultset.getInt("id"));
                }
                
                JOptionPane.showMessageDialog(null, "Senha Incorreta!");
                return null;
            }
            createUsuario(login);
            return login.getId();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return 0;
    }
    
    private void createUsuario (LoginModelo loginf) {
        super.insertUsuarioSQL("INSERT INTO irc.usuario (nome, senha) VALUES ('"+ loginf.getUsuario() +"', '"+ loginf.getSenha() +"')");
    }
}
