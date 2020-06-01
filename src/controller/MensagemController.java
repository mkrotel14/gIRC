/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConnectionPG;
import java.sql.ResultSet;
import model.LoginModelo;
import model.MensagemModelo;

/**
 *
 * @author Gian Carlo Mantuan
 */
public class MensagemController extends ConnectionPG {
    private StringBuilder sql = new StringBuilder();
    
    public void sendMessage(MensagemModelo mensagem) {
        super.insertMensagemSQL("INSERT INTO irc.sala_principal (mensagem, usuario) VALUES ('"+ mensagem.getMensagem() +"', "+ mensagem.getUsuario() +")");
    }
    
    public ResultSet getMessage() {
        return super.executeMensageSQL("SELECT u.id AS usuarioId, u.nome, sp.id AS mensagemId, sp.mensagem FROM irc.sala_principal sp JOIN irc.usuario u ON u.id = sp.usuario");
    }
    
    public void deleteMessage(Integer mensagem) {
        super.deleteMessageSQL("DELETE FROM irc.sala_principal WHERE id = '"+ mensagem +"'");
    }
    
    public void updateMessage(Integer mensagemId, String mensagem) {
        super.updateMessageSQL("UPDATE irc.sala_principal SET mensagem = '"+ mensagem +" (editado)' WHERE id = "+ mensagemId +" ");
    }
}
