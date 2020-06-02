/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gian Carlo Mantuan
 */
public class ConnectionPG {
    
    public static Connection conn;
    public static Statement statement = null;
    public static ResultSet resultset;
    public int retorno = 0;
    
    public ConnectionPG() {
        connect();
    }
    
    public static Connection connect() {
        if (conn != null) {
            return conn;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres",
                        "postgres", "xburguer");

                System.out.println("Conectado");
                return conn;

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver não localizado: " + ex);

                ex.printStackTrace();
                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte  de dados: " + ex);
                ex.printStackTrace();
                return null;
            }
        }
    }
    
    public void dc() {
        boolean result = true;
        try {
            conn.close();
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o banco de dados: " + "\n" + fecha);
            result = false;
        }
    }
    
    public ResultSet executeSQL(String sql) {        
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs;
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            return null;
        }           
    }
    
    public ResultSet executeMensageSQL(String sql ) {
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = st.executeQuery(sql);
            return resultset;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar mensagens");
            return null;
        }
    }
    
    public void insertUsuarioSQL(String sql) {
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = st.executeUpdate(sql);            
        } catch (SQLException sqlex) {
            retorno = 0;
        }
    }
    
    public void insertMensagemSQL(String sql) {
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(sql);
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Erro ao enviar mensagem!");
        }
    }
    
    public void deleteMessageSQL(String sql) {
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(sql);            
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Erro em apagar a mensagem!");
        }
    }
    
    public void updateMessageSQL(String sql) {
        try {
            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(sql);            
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Erro em atualizar a mensagem!");
        }
    }
}
