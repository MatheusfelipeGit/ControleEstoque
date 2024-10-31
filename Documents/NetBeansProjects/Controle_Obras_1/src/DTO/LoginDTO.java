package DTO;


public class LoginDTO {

    /**
     * @return the If
     */
    public String getIf() {
        return If;
    }

    /**
     * @param If the If to set
     */
    public void setIf(String If) {
        this.If = If;
    }

    /**
     * @return the Senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param Senha the Senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    private String If;
    private String Senha;
           
}
