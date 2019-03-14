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
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author priscyla.poliveira
 * @see DAO.ProdutoDAO
 */
public class ProdutoDAO {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/lojaderoupaNew";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection conexao;
    
    
    /**
     * Método para salvar produto na tabela no banco de dados
     * @param p objeto do tipo Produto
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean SalvarProduto(Produto p){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO produto (descricao, "
                    + "tamanho, cor, genero, quantidade, valorUnitario) VALUES(?, ?, ?, ?, ?, ?)");
            
            comando.setString(1, p.getDescricao());
            comando.setString(2, p.getTamanho());
            comando.setString(3, p.getCor());
            comando.setString(4, p.getGenero());
            comando.setString(5, String.valueOf(p.getQtd()));
            comando.setString(6, String.valueOf(p.getValorUnitario()));
            
            int linhasAfetadas = comando.executeUpdate();
            retorno = linhasAfetadas > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            retorno = false;
        }finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
            
        }
        
        return retorno;
    }
    
    /**
     * Método para atualizar produto na tabela no banco de dados
     * @param p objeto do tipo Produto
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean AtualizarProduto(Produto p){
        boolean retorno = false;
        
        try {
            //Simulo uma inserção no banco de dados (INSERT INTO...)
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            
            PreparedStatement comando = conexao.prepareStatement("UPDATE produto SET descricao = ?, tamanho = ?, cor = ?, "
                    + "genero = ?, quantidade = ?, valorUnitario = ? WHERE idproduto = ?");
           
            comando.setString(1, p.getDescricao());
            comando.setString(2, p.getTamanho());
            comando.setString(3, p.getCor());
            comando.setString(4, p.getGenero());
            comando.setString(5, String.valueOf(p.getQtd()));
            comando.setString(6, String.valueOf(p.getValorUnitario()));
            comando.setString(7, String.valueOf(p.getCodigo()));
            
            int linhasAfetadas = comando.executeUpdate();
            retorno = linhasAfetadas > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            retorno = false;
        }finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
            
        }
        
        return retorno; 
    }
    
    /**
     * Método para pesquisar produto na tabela no banco de dados
     * @param valor objeto do tipo String
     * @return <code>ArrayList</code>
     */
    public static ArrayList<Produto> PesquisarProduto(String valor){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produto where idproduto like '"+valor+"' or tamanho like '"+valor+"'"
                    + "or cor like '"+valor+"' or genero like '"+valor+"' or descricao like '%"+valor+"%'");
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodigo(rs.getInt("idproduto"));
                p.setDescricao(rs.getString("descricao"));
                p.setTamanho(rs.getString("tamanho"));
                p.setCor(rs.getString("cor"));
                p.setGenero(rs.getString("genero"));
                p.setQtd(rs.getInt("quantidade"));
                p.setValorUnitario(rs.getDouble("valorUnitario"));
                listaProdutos.add(p);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            listaProdutos = null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaProdutos = null;
            }
        }
        return listaProdutos;
    }
    
    /**
     * Método para excluir produto na tabela no banco de dados
     * @param id objeto do tipo Int
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean ExcluirProduto(int id){
        boolean retorno = false;
        
        try {
            //Simulo uma inserção no banco de dados (INSERT INTO...)
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            
            Statement comando = conexao.createStatement();
            //PreparedStatement comando = conexao.prepareStatement("DELETE FROM carro WHERE idcarro=?");
            
            int linhasAfetadas = comando.executeUpdate("DELETE FROM produto WHERE idproduto =" + id); 
            retorno = linhasAfetadas>0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            retorno = false;
        }finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
            
        }
        
        return retorno;
    }
    
    /**
     * Método para pegar lista de produtos salvo no banco de dados
     * @return <code>ArrayList</code>
     */
        
    public static ArrayList<Produto> getProdutos(){
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM produto;");
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodigo(rs.getInt("idproduto"));
                p.setDescricao(rs.getString("descricao"));
                p.setTamanho(rs.getString("tamanho"));
                p.setCor(rs.getString("cor"));
                p.setGenero(rs.getString("genero"));
                p.setQtd(rs.getInt("quantidade"));
                p.setValorUnitario(rs.getDouble("valorUnitario"));
                listaProdutos.add(p);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            listaProdutos = null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaProdutos = null;
            }
        }
        return listaProdutos;
    }
    
    public ProdutoDAO(){
        
    }
}
