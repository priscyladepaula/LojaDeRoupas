/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author priscyla.poliveira
 */
public class ItemVenda {
    
    /**
     * Classe para passar os valores para o parâmetro
     * @param descricaoProduto objeto do tipo String
     * @param qtd objeto do tipo int
     * @param valorUnitario objeto do tipo double
     */
    
    private String descricaoProduto;
    private int qtd;
    private double valorUnitario;

    public ItemVenda(String descricaoProduto, int qtd, double valorUnitario) {
        this.descricaoProduto = descricaoProduto;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
    }
    public ItemVenda(){
        
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
