/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author priscyla.poliveira
 */
public class ProdutoController {
    
    /**
     * Método para passar os valores digitados no parâmetro, para salvar as informações do produto
     * @param descricao objeto do tipo String
     * @param tamanho objeto do tipo String
     * @param cor objeto do tipo String
     * @param genero objeto do tipo String
     * @param qtd objeto do tipo int
     * @param valorUnitario objeto do tipo double
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean Salvar(String descricao, String tamanho, String cor, String genero, int qtd, double valorUnitario){
        Produto p = new Produto(descricao, tamanho, cor, genero, qtd, valorUnitario);
        return ProdutoDAO.SalvarProduto(p);
    }
    
    /**
     * Método para passar o valores digitado no parâmetro, para salvar as informações do produto
     * @param id objeto do tipo int
     * @return <code>boolean</code>
     */
    public static boolean Excluir(int id){
        return ProdutoDAO.ExcluirProduto(id);
    }
    
    /**
     * Método para passar os valores digitados no parâmetro, para atualizar as informações do produto
     * @param descricao objeto do tipo String
     * @param tamanho objeto do tipo String
     * @param cor objeto do tipo String
     * @param genero objeto do tipo String
     * @param qtd objeto do tipo int
     * @param valorUnitario objeto do tipo double
     * @return <code>boolean</code> indicando true: sucesso, false:falha
     */
    public static boolean Atualizar(String descricao, String tamanho, String cor, String genero, int qtd, double valorUnitario, int codigo){
        Produto p = new Produto(descricao, tamanho, cor, genero, qtd, valorUnitario, codigo);
        return ProdutoDAO.AtualizarProduto(p); 
    }
    
    /**
     * Método para pesquisar o valor do produto
     * @param valor objeto do tipo String
     * @return <code>ArrayList</code>
     */
    public static ArrayList<Produto> Pesquisar(String valor){
        return ProdutoDAO.PesquisarProduto(valor);
    }
    
    /**
     * Método para pegar os valores do produto
     * @return <code>ArrayList</code>
     */
    public static ArrayList<String[]> getProdutos(){
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
        for(int i=0; i < produtos.size(); i++){
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getCodigo()),produtos.get(i).getDescricao(), produtos.get(i).getTamanho(),
                                           produtos.get(i).getCor(), produtos.get(i).getGenero(),
                                           String.valueOf(produtos.get(i).getQtd()), String.valueOf(produtos.get(i).getValorUnitario())});
        }
        
        return listaProdutos;
    }

}
