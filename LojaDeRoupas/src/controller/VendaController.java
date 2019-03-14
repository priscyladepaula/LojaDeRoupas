/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import DAO.VendaDAO;
import model.ItemVenda;
import model.Venda;

/**
 *
 * @author priscyla.poliveira
 */
public class VendaController {
    
    /**
     * Método para salvar a venda do produto
     * @param venda objeto do tipo Venda
     * @return <code>boolean</code> indicando true: sucesso, false: falha
     */
    public static boolean SalvarVenda(Venda venda){
        return DAO.VendaDAO.SalvarVenda(venda);
    }
    
    /**
     * Método para pegar os itens a partir do ID do cliente na venda
     * @param cpf objeto do tipo String
     * @param DataVenda objeto do tipo String
     * @param valorTotalPago objeto do tipo double
     * @return <code>int</code>
     */
    public static int RecuperaIdVenda(String cpf, String DataVenda, double valorTotalPago){
        return VendaDAO.recuperaIdDaVenda(cpf, DataVenda, valorTotalPago);
    }
    
    /**
     * Método para salvar os itens da venda
     * @param item objeto do tipo ItemVenda
     * @param idVenda objeto do tipo int
     * @return <code>boolean</code>
     */
    public static boolean SalvarItensVenda(ItemVenda item, int idVenda){
        return VendaDAO.SalvarItensVenda(item, idVenda);
    }
    
    /**
     * Método para pegar as vendas
     * @return <code>ArrayList</code>
     */
    public static ArrayList<Venda> getVendas(){
        return DAO.VendaDAO.getVendas();
    }
    
    /**
     * Método para salvar a venda do produto
     * @param idVenda objeto do tipo int
     * @return <code>ArrayList</code>
     */
    public static ArrayList<ItemVenda> getItensVenda(int idVenda){
        return VendaDAO.getItensVenda(idVenda);
    }
}
