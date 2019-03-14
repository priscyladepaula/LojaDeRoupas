/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sunse
 */
public class Produto {
    
    /**
     * Classe para passar os valores para o parâmetro
     * @param codigo objeto do tipo int
     * @param qtd objeto do tipo int
     * @param descricao objeto do tipo String
     * @param tamanho objeto do tipo String
     * @param genero objeto do tipo String
     * @param cor objeto do tipo String
     * @param valorUnitario objeto do tipo double
     */
    
    private int codigo;
    private int qtd;
    private String descricao;
    private String tamanho;
    private String genero;
    private String cor;
    private double valorUnitario;
    
    public Produto(String descricao, String tamanho, String cor, String genero, int qtd, double valorUnitario){
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        this.genero = genero;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
    }
    
     public Produto(String descricao, String tamanho, String cor, String genero, int qtd, double valorUnitario, int id){
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        this.genero = genero;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
        this.codigo = id;
     }
    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public Produto(){
        
    }
    
}
