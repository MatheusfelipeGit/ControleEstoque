/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


public class EntradaDTO {

    /**
     * @return the Responsavel
     */
    public String getResponsavel() {
        return Responsavel;
    }

    /**
     * @param Responsavel the Responsavel to set
     */
    public void setResponsavel(String Responsavel) {
        this.Responsavel = Responsavel;
    }

    /**
     * @return the Local
     */
    public String getLocal() {
        return Local;
    }

    /**
     * @param Local the Local to set
     */
    public void setLocal(String Local) {
        this.Local = Local;
    }

    /**
     * @return the codigo_item
     */
    public String getCodigo_item() {
        return codigo_item;
    }

    /**
     * @param codigo_item the codigo_item to set
     */
    public void setCodigo_item(String codigo_item) {
        this.codigo_item = codigo_item;
    }

    /**
     * @return the NomeItem
     */
    public String getNomeItem() {
        return NomeItem;
    }

    /**
     * @param NomeItem the NomeItem to set
     */
    public void setNomeItem(String NomeItem) {
        this.NomeItem = NomeItem;
    }

    /**
     * @return the Quantidade
     */
    public Integer getQuantidade() {
        return Quantidade;
    }

    /**
     * @param Quantidade the Quantidade to set
     */
    public void setQuantidade(Integer Quantidade) {
        this.Quantidade = Quantidade;
    }

    /**
     * @return the QuemRecebeu
     */
    public String getQuemRecebeu() {
        return QuemRecebeu;
    }

    /**
     * @param QuemRecebeu the QuemRecebeu to set
     */
    public void setQuemRecebeu(String QuemRecebeu) {
        this.QuemRecebeu = QuemRecebeu;
    }

    /**
     * @return the Data
     */
    public String getData_entrada() {
        return Data_entrada;
    }

    /**
     * @param Data the Data to set
     */
    public void setData_entrada(String Data_entrada) {
        this.Data_entrada = Data_entrada;
    }

    private String codigo_item;
    private String NomeItem;
    private Integer Quantidade;
    private String QuemRecebeu;
    private String Data_entrada;
    private String Responsavel;
    private String Local;
 
}
