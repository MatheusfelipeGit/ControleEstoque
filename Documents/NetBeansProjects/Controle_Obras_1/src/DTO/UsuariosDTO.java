/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


public class UsuariosDTO {

    /**
     * @return the NomeCompleto
     */
    public String getNomeCompleto() {
        return NomeCompleto;
    }

    /**
     * @param NomeCompleto the NomeCompleto to set
     */
    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    /**
     * @return the If_USER
     */
    public String getIf_USER() {
        return If_USER;
    }

    /**
     * @param If_USER the If_USER to set
     */
    public void setIf_USER(String If_USER) {
        this.If_USER = If_USER;
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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

 
    private String NomeCompleto;
    private String If_USER;
    private String email;
    private String senha;
    
}
