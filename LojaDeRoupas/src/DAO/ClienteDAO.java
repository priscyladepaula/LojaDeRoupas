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
import model.Cliente;

/**
 *
 * @author priscyla.poliveira
 * @see DAO.ClienteDAO
 */
public class ClienteDAO {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/lojaderoupaNew";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection conexao;
    
    /**
     * Método para salvar cliente na tabela no banco de dados
     * @param c objeto do tipo Cliente
     * @return <code>boolean</code> indicando true: sucesso, false: falha
     */
    
    public static boolean SalvarCliente(Cliente c){
        
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
                        
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO cliente (nome, cpf, genero, dataNascimento, "
                    + "estadoCivil, tipoEndereco, endereco, numeroResidencia, cep, bairro, complemento, "
                    + "cidade, uf, email, telefone) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            comando.setString(1, c.getNome());
            comando.setString(2, c.getCpf());
            comando.setString(3, c.getGenero());
            comando.setString(4, c.getDataNasc());
            comando.setString(5, c.getEstadoCivil());
            comando.setString(6, c.getTipoEndereco());
            comando.setString(7, c.getEndereco());
            comando.setString(8, String.valueOf(c.getNumeroResidencia()));
            comando.setString(9, String.valueOf(c.getCep()));
            comando.setString(10, c.getBairro());
            comando.setString(11, String.valueOf(c.getComplemento()));
            comando.setString(12, c.getCidade());
            comando.setString(13, c.getUF());
            comando.setString(14, c.getEmail());
            comando.setString(15, String.valueOf(c.getTelefone()));
            
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
     * Método para atualizar cliente na tabela no banco de dados
     * @param c objeto do tipo Cliente
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean AtualizarCliente(Cliente c){
        boolean retorno = true;
        
        try {
            Class.forName(DRIVER);
            
            conexao = DriverManager.getConnection(URL, USER, PASS);
            
            PreparedStatement comando = conexao.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, genero = ?"
                    + ", dataNascimento = ?, estadoCivil = ?, tipoEndereco = ?, endereco = ?, numeroResidencia = ?, "
                    + "cep = ?, bairro = ?, complemento = ?, cidade = ?, uf = ?, email = ?, telefone = ?"
                    + " WHERE idcliente = ?");
            
            comando.setString(1, c.getNome());
            comando.setString(2, c.getCpf());
            comando.setString(3, c.getGenero());
            comando.setString(4, c.getDataNasc());
            comando.setString(5, c.getEstadoCivil());
            comando.setString(6, c.getTipoEndereco());
            comando.setString(7, c.getEndereco());
            comando.setString(8, String.valueOf(c.getNumeroResidencia()));
            comando.setString(9, String.valueOf(c.getCep()));
            comando.setString(10, c.getBairro());
            comando.setString(11, String.valueOf(c.getComplemento()));
            comando.setString(12, c.getCidade());
            comando.setString(13, c.getUF());
            comando.setString(14, c.getEmail());
            comando.setString(15, String.valueOf(c.getTelefone()));
            comando.setString(16, String.valueOf(c.getId()));
            
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
     * Método para excluir cliente na tabela no banco de dados
     * @param id objeto do tipo Int
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean ExcluirCliente(int id){
        boolean retorno = false;
        
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("DELETE FROM cliente WHERE idcliente = " + id);  
            retorno = linhasAfetadas>0;
            
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
     * Método para pegar lista de clientes salvo no banco de dados
     * @return <code>ArrayList</code>
     */
    public static ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cliente;");
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("idcliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setGenero(rs.getString("genero"));
                c.setDataNasc(rs.getString("dataNascimento"));
                c.setEstadoCivil(rs.getString("estadoCivil"));
                c.setTipoEndereco(rs.getString("tipoEndereco"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumeroResidencia(rs.getInt("numeroResidencia"));
                c.setCep(rs.getInt("cep"));
                c.setBairro(rs.getString("bairro"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getLong("telefone"));
                
                listaClientes.add(c);
            }
        } catch (ClassNotFoundException | SQLException e) {
            listaClientes = null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                listaClientes = null;
            }
        }
        
        return listaClientes;
        //return getClientes();
    }
    
    /**
     * Método para pegar CPF na lista de clientes salvos no banco de dados
     * @param cpf objeto do tipo String
     * @return <code>Cliente</code>
     */
    public static Cliente getClienteByCPF(String cpf){
        Cliente c = new Cliente();

        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cliente WHERE cpf = '" + cpf +"'");
                                                
            while(rs.next()){
               c.setId(rs.getInt("idcliente"));
               c.setNome(rs.getString("nome"));
               c.setCpf(rs.getString("cpf"));
               c.setGenero(rs.getString("genero"));
               c.setDataNasc(rs.getString("dataNascimento"));
               c.setEstadoCivil(rs.getString("estadoCivil"));
               c.setTipoEndereco(rs.getString("tipoEndereco"));
               c.setEndereco(rs.getString("endereco"));
               c.setNumeroResidencia(rs.getInt("numeroResidencia"));
               c.setCep(rs.getInt("cep"));
               c.setBairro(rs.getString("bairro"));
               c.setComplemento(rs.getString("complemento"));
               c.setCidade(rs.getString("cidade"));
               c.setUF(rs.getString("uf"));
               c.setEmail(rs.getString("email"));
               c.setTelefone(rs.getLong("telefone"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                c = null;
            }            
        } 
        return c;
    }
    
    /**
     * Método para pegar ID na lista de clientes salvos no banco de dados
     * @param id objeto do tipo Int
     * @return <code>Cliente</code>
     */
    public static Cliente getClienteById(int id){
        Cliente c = new Cliente();

        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cliente WHERE idcliente = " + id);
            
            while(rs.next()){
               c.setId(rs.getInt("idcliente"));
               c.setNome(rs.getString("nome"));
               c.setCpf(rs.getString("cpf"));
               c.setGenero(rs.getString("genero"));
               c.setDataNasc(rs.getString("dataNascimento"));
               c.setEstadoCivil(rs.getString("estadoCivil"));
               c.setTipoEndereco(rs.getString("tipoEndereco"));
               c.setEndereco(rs.getString("endereco"));
               c.setNumeroResidencia(rs.getInt("numeroResidencia"));
               c.setCep(rs.getInt("cep"));
               c.setBairro(rs.getString("bairro"));
               c.setComplemento(rs.getString("complemento"));
               c.setCidade(rs.getString("cidade"));
               c.setUF(rs.getString("uf"));
               c.setEmail(rs.getString("email"));
               c.setTelefone(rs.getLong("telefone"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                c = null;
            }            
        } 
        return c;
    }
    
    /**
     * Método para pegar CPF na lista de clientes salvos no banco de dados
     * @param nome objeto do tipo String
     * @return <code>String</code>
     */
    public static String getCpfByName(String nome){
        
        String cpf = "";
        
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USER, PASS);
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cliente WHERE nome = '" + nome +"'");
                                                
            while(rs.next()){               
               cpf = rs.getString("cpf");
            }
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                cpf = "";
            }            
        } 
        return cpf;
    }
        
}
