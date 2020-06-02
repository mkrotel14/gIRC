/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConnectionPG;
import java.sql.ResultSet;
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
        ResultSet user = super.executeSQL("SELECT * FROM irc.usuario u WHERE nome = '"+ login.getUsuario() +"'");

        try {            
            if (user.first()) {
                ResultSet pass = super.executeSQL("SELECT * FROM irc.usuario WHERE senha = '"+ login.getSenha() +"'");
                
                if (pass.first()) {                     
                    return (pass.getInt("id"));
                }
                
                JOptionPane.showMessageDialog(null, "Senha Inválida!");
                return null;
            }
            createUsuario(login);
            
            if (super.retorno == 1) {
                JOptionPane.showMessageDialog(null, "Usuário criado com sucesso");
                return login.getId();
            }
            JOptionPane.showMessageDialog(null, "Erro ao criar novo Usuário");
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    private void createUsuario (LoginModelo createLogin) {
        super.insertUsuarioSQL("INSERT INTO irc.usuario (nome, senha) VALUES ('"+ createLogin.getUsuario() +"', '"+ createLogin.getSenha() +"')");        
    }
}
