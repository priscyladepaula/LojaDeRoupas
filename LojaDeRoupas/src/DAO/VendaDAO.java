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
import model.ItemVenda;
import model.Venda;

/**
 *
 * @author priscyla.poliveira
 * @see DAO.VendaDAO
 */
public class VendaDAO {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/lojaderoupaNew";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conexao;
    
    /**
     * Método para salvar venda na tabela no banco de dados
     * @param v objeto do tipo Venda
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    
    public static boolean SalvarVenda(Venda v){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO venda "
                    + "(nomeCliente, valorTotalPagar, dataCompra, cpfCliente) VALUES (?, ?, ?, ?)");
            
           comando.setString(1, v.getNomeCliente());
           comando.setDouble(2, v.getValorTotalPagar());
           comando.setString(3, v.getDataVenda());
           comando.setString(4, v.getCpfCliente());
        
            int linhasAfetadas = comando.executeUpdate();
            retorno = linhasAfetadas > 0;
            
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
    
    /**
     * Método para salvar a data da venda na tabela no banco de dados
     * @param cpf objeto do tipo String
     * @param DataVenda objeto do tipo String
     * @param valorTotalPago do tipo double
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static int recuperaIdDaVenda(String cpf, String DataVenda, double valorTotalPago){
        int idVenda = 0;
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM venda WHERE cpfCliente = '" + cpf +"'"+"and "
                    + " dataCompra = '"+ DataVenda +"' and valorTotalPagar = '"+ valorTotalPago+ "';");
                                                
            while(rs.next()){
               idVenda = rs.getInt("idvenda");              
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            return 0;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                return 0;
            }            
        } 
        return idVenda;
    }
    
    /**
     * Método para salvar os itens da venda na tabela no banco de dados
     * @param item objeto do tipo ItemVenda
     * @param idVenda objeto do tipo int
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean SalvarItensVenda(ItemVenda item, int idVenda){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO itemvenda (Produto, "
                    + "idVenda, Quantidade, valorUnitario) VALUES (?, ?, ?, ?)");
            
            comando.setString(1, item.getDescricaoProduto());
            comando.setInt(2, idVenda);
            comando.setInt(3, item.getQtd());
            comando.setDouble(4, item.getValorUnitario());
            
            int linhasAfetadas = comando.executeUpdate(); 
            retorno = linhasAfetadas > 0;
            
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
    
    /**
     * Método para pegar lista de vendas salvo no banco de dados
     * @return <code>ArrayList</code>
     */
    public static ArrayList<Venda> getVendas(){
        ArrayList<Venda> vendas = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM venda;");
                                                
            while(rs.next()){
               Venda venda = new Venda(
               rs.getString("cpfCliente"),
               rs.getString("nomeCliente"),
               rs.getString("dataCompra"),
               rs.getDouble("valorTotalPagar"),
               rs.getInt("idvenda")
               );
               vendas.add(venda);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                return null;
            }            
        } 
        return vendas;
    }
    
    /**
     * Método para pegar a data de vendas salvo no relatório
     * @param data do tipo String
     * @return <code>ArrayList</code>
     */
    public static ArrayList<Venda> getVendasByDate(String data){
        return getVendas();
    }
    
    /**
     * Método para pegar a id da venda salvo no banco de dados
     * @param idVenda do tipo int
     * @return <code>ArrayList</code>
     */
    public static ArrayList<ItemVenda> getItensVenda(int idVenda){
         ArrayList<ItemVenda> itensVenda = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM itemvenda where idVenda = "+idVenda+";");
                                                
            while(rs.next()){
               ItemVenda itemVenda = new ItemVenda(
               rs.getString("Produto"),
               rs.getInt("Quantidade"),
               rs.getDouble("valorUnitario")
               );
               itensVenda.add(itemVenda);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                return null;
            }            
        } 
        return itensVenda;
    }
}
