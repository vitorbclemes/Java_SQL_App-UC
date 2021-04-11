package dados;

public class Tipo {
    private int tipoid;
    private String nome;
    
    
    /** 
     * Retorna o id do Tipo
     * @return int
     */
    public int getTipoid() {
        return tipoid;
    }
    
    /** 
     * Atribui o id do Tipo
     * @param tipoid
     */
    public void setTipoid(int tipoid) {
        this.tipoid = tipoid;
    }
    
    /** 
     * Retorna o nome do Tipo
     * @return String
     */
    public String getNome() {
        return nome;
    }
    
    /** 
     * Atribui o nome do Tipo
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
