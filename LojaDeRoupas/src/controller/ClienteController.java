/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author priscyla.poliveira
 */
public class ClienteController {
    
    /**
     * Método para passar os valores digitados no parâmetro, para salvar as informações do cliente
     * @param nome objeto do tipo String
     * @param cpf objeto do tipo String
     * @param genero objeto do tipo String
     * @param dataNasc objeto do tipo String
     * @param estadoCivil objeto do tipo String
     * @param tipoEndereco objeto do tipo String
     * @param endereco objeto do tipo String
     * @param numero objeto do tipo int
     * @param cep objeto do tipo int
     * @param bairro objeto do tipo String
     * @param complemento objeto do tipo String
     * @param cidade objeto do tipo String
     * @param uf objeto do tipo String
     * @param email objeto do tipo String
     * @param telefone objeto do tipo long
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean Salvar(String nome, String cpf, String genero, String dataNasc, String estadoCivil,
                                 String tipoEndereco, String endereco, int numero, int cep, String bairro, String complemento, String cidade,
                                 String uf, String email, long telefone){
        
        Cliente c = new Cliente(nome, cpf, genero, dataNasc, estadoCivil,
                                tipoEndereco, endereco, numero, cep, bairro, complemento, cidade,
                                uf, email, telefone);
        
        return ClienteDAO.SalvarCliente(c);
    }
    
    /**
     * Método para passar os valores digitados no parâmetro, para salvar as informações do cliente
     * @param idcliente objeto do tipo int
     * @return <code>boolean</code>
     */
    
    public static boolean Excluir(int idcliente){
        return ClienteDAO.ExcluirCliente(idcliente);
    }
    
    /**
     * Método para passar os valores digitados no parâmetro, para atualizar as informações do cliente
     * @param nome objeto do tipo String
     * @param cpf objeto do tipo String
     * @param genero objeto do tipo String
     * @param dataNasc objeto do tipo String
     * @param estadoCivil objeto do tipo String
     * @param tipoEndereco objeto do tipo String
     * @param endereco objeto do tipo String
     * @param numero objeto do tipo int
     * @param cep objeto do tipo int
     * @param bairro objeto do tipo String
     * @param complemento objeto do tipo String
     * @param cidade objeto do tipo String
     * @param uf objeto do tipo String
     * @param email objeto do tipo String
     * @param telefone objeto do tipo long
     * @param id objeto do tipo int
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    
    public static boolean Atualizar(String nome, String cpf, String genero, String dataNasc, String estadoCivil,
                                    String tipoEndereco, String endereco, int numero, int cep, String bairro, String complemento, String cidade,
                                    String uf, String email, long telefone, int id){
        
        
        Cliente c = new Cliente(nome, cpf, genero, dataNasc, estadoCivil,
                                tipoEndereco, endereco, numero, cep, bairro, complemento, cidade,
                                uf, email, telefone, id);
        
        return ClienteDAO.AtualizarCliente(c);
    }
    
    /**
     * Método para pegar os valores e salvar em um ArrayList
     * @return <code>ArrayList</code>
     */
    
    public static ArrayList<String[]> getClientes(){
        
        ArrayList<Cliente> clientes = ClienteDAO.getClientes();
        ArrayList<String[]> listaClientes = new ArrayList<>();
        
        for(int i = 0; i < clientes.size(); i++){
            listaClientes.add(new String[]{String.valueOf(clientes.get(i).getId()), clientes.get(i).getNome(), 
                              clientes.get(i).getCpf(), clientes.get(i).getGenero(),
                              String.valueOf(clientes.get(i).getDataNasc()), clientes.get(i).getEstadoCivil(),
                              clientes.get(i).getTipoEndereco(), clientes.get(i).getEndereco(),
                              String.valueOf(clientes.get(i).getNumeroResidencia()), String.valueOf(clientes.get(i).getCep()),
                              clientes.get(i).getBairro(), clientes.get(i).getCidade(), clientes.get(i).getUF(),
                              clientes.get(i).getEmail(), String.valueOf(clientes.get(i).getTelefone())});
        }
        
        return listaClientes;
    }
    /**
     * Método para pegar o CPF para pesquisar o cliente
     * @param cpf objeto do tipo String
     * @return <code>Cliente</code>
     */
    public static Cliente getClienteByCPF(String cpf){
        return ClienteDAO.getClienteByCPF(cpf);
    }
    
    /**
     * Método para pegar o CPF para deletar o cliente
     * @param id objeto do tipo int
     * @return <code>ArrayList</code>
     */
    public static Cliente getClienteByID(int id){
        return ClienteDAO.getClienteById(id);
    }
    /**
     * Método para pegar os CPF para pesqu
     * @param nome objeto do tipo String
     * @return <code>ArrayList</code>
     */
    public static String getCpfByName(String nome){
        return ClienteDAO.getCpfByName(nome);
    }
}
