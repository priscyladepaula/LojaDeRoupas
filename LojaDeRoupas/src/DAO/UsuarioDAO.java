/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author priscyla.poliveira
 * @see DAO.UsuarioDAO
 */
public class UsuarioDAO {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/lojaderoupaNew";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection conexao;
    
    
    /**
     * Método para verificar se os usuários e senhas constam no banco de dados
     * @param usuario objeto do tipo String
     * @param senha objeto do tipo String
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */

    public static boolean CheckUsuario(String usuario, String senha){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM login WHERE usuario = ? AND senha = ?");
            
            comando.setString(1, usuario);
            comando.setString(2, senha);
            
            ResultSet rs = comando.executeQuery();
            
            if(rs.next()){
                retorno = true;
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            retorno = false;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                retorno = false;
            }
        }
        
        return retorno;
    }
}
