/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author priscyla.poliveira
 */
public class Venda {
    
    /**
     * Classe para passar os valores para o parâmetro
     * @param itens objeto do tipo ArrayList
     * @param cpfCliente objeto do tipo String
     * @param nomeCliente objeto do tipo String
     * @param dataVenda objeto do tipo String
     * @param valorTotalPagar objeto do tipo double
     * @param idvenda objeto do tipo int
     */
    private ArrayList<ItemVenda> itens = new ArrayList<>();
    private String cpfCliente;
    private String nomeCliente;
    private String dataVenda;
    private double valorTotalPagar;
    private int idvenda;

    public Venda(String cpfCliente, String nomeCliente, String dataVenda, double valorTotalPagar, ArrayList<ItemVenda> itens) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.dataVenda = dataVenda;
        this.valorTotalPagar = valorTotalPagar;
        this.itens = itens;
    }
    
     public Venda(String cpfCliente, String nomeCliente, String dataVenda, double valorTotalPagar, int idvenda) {
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.dataVenda = dataVenda;
        this.valorTotalPagar = valorTotalPagar;
        this.idvenda = idvenda;
        
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }
    /**
     * @return the valorTotalPagar
     */
    public double getValorTotalPagar() {
        return valorTotalPagar;
    }

    /**
     * @param valorTotalPagar the valorTotalPagar to set
     */
    public void setValorTotalPagar(double valorTotalPagar) {
        this.valorTotalPagar = valorTotalPagar;
    }

    /**
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the itens
     */
    
    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }    

    /**
     * @return the dataVenda
     */
    public String getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
