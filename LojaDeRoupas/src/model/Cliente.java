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
public class Cliente {
    /**
     * Classe para passar os valores para o parâmetro
     * @param nome objeto do tipo String
     * @param endereco objeto do tipo String
     * @param bairro objeto do tipo String
     * @param cidade objeto do tipo String
     * @param email objeto do tipo String
     * @param UF objeto do tipo String
     * @param genero objeto do tipo String
     * @param estadoCivil objeto do tipo String
     * @param tipoEndereco objeto do tipo String
     * @param cpf objeto do tipo String
     * @param dataNasc objeto do tipo String
     * @param telefone objeto do tipo long
     * @param id objeto do tipo int
     * @param cep objeto do tipo cep
     * @param numeroResidencia objeto do tipo int
     */
        
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String email;
    private String UF;
    private String genero;
    private String estadoCivil;
    private String tipoEndereco;
    private String cpf;
    private String dataNasc;
    private long telefone;
    private int id;
    private int cep;
    private int numeroResidencia;
    private String complemento;

    public Cliente(String nome, String cpf, String genero, String dataNasc, String estadoCivil,
                   String tipoEndereco, String endereco, int numero, int cep, String bairro, String complemento, String cidade,
                   String uf, String email, long telefone){
        
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNasc = dataNasc;
        this.estadoCivil = estadoCivil;
        this.tipoEndereco = tipoEndereco;
        this.numeroResidencia = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = uf;
        this.email = email;
        this.telefone = telefone;
        this.complemento = complemento;
    }

    public Cliente(String nome, String cpf, String genero, String dataNasc, String estadoCivil,
                   String tipoEndereco, String endereco, int numero, int cep, String bairro, String complemento, String cidade,
                   String uf, String email, long telefone, int id){
        
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.genero = genero;
        this.dataNasc = dataNasc;
        this.estadoCivil = estadoCivil;
        this.tipoEndereco = tipoEndereco;
        this.numeroResidencia = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = uf;
        this.email = email;
        this.telefone = telefone;
        this.complemento = complemento;
        this.id = id;
    }
    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the dataNasc
     */
    public String getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
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
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the tipoEndereco
     */
    public String getTipoEndereco() {
        return tipoEndereco;
    }

    /**
     * @param tipoEndereco the tipoEndereco to set
     */
    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    /**
     * @return the numeroResidencia
     */
    public int getNumeroResidencia() {
        return numeroResidencia;
    }

    /**
     * @param numeroResidencia the numeroResidencia to set
     */
    public void setNumeroResidencia(int numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    /**
     * @return the UF
     */
    public String getUF() {
        return UF;
    }

    /**
     * @param UF the UF to set
     */
    public void setUF(String UF) {
        this.UF = UF;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public long getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(int cep) {
        this.cep = cep;
    }
    
    public Cliente(){
        this.nome = "";
        this.endereco = "";
        this.cpf = "";
        this.genero = "";
        this.dataNasc = "";
        this.estadoCivil = "";
        this.tipoEndereco = "";
        this.numeroResidencia = 0;
        this.cep = 0;
        this.bairro = "";
        this.cidade = "";
        this.UF = "";
        this.email = "";
        this.telefone = 0;
        this.complemento = "";
    }
}
