package dados;

public class Edicao {
    private int edicaoid;
    private String cidade;
    private String uf;
    private int qtdparticipantes;
    private int ano;
    
    
    /**
     * Retorna o id da Edicao 
     * @return int
     */
    public int getEdicaoid() {
        return edicaoid;
    }
    
    /** 
     * Atribui o id da Edicao
     * @param edicaoid
     */
    public void setEdicaoid(int edicaoid) {
        this.edicaoid = edicaoid;
    }
    
    /** 
     * Retorna a cidade da Edicao
     * @return String
     */
    public String getCidade() {
        return cidade;
    }
    
    /**
     * Atribui a cidade da Edicao 
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    /** 
     * Retorna o estado da Edicao
     * @return String
     */
    public String getUf() {
        return uf;
    }
    
    /** 
     * Atribui o estado da edicao
     * @param uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
    
    /** 
     * Retorna a quantidade de participantes da Edicao
     * @return int
     */
    public int getQtdparticipantes() {
        return qtdparticipantes;
    }
    
    /** 
     * Atribui a quantidade de participantes da Edicao
     * @param qtdparticipantes
     */
    public void setQtdparticipantes(int qtdparticipantes) {
        this.qtdparticipantes = qtdparticipantes;
    }
    
    /** 
     * Retorna o ano da Edicao
     * @return int
     */
    public int getAno() {
        return ano;
    }
    
    /** 
     * Atribui o ano da Edicao
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    /** 
     * Retorna os valores da Edicao em String formatada
     * @return String
     */
    @Override
    public String toString() {
        return "Edicao [id = " + edicaoid +", ano=" + ano + ", cidade=" + cidade +  ", qtdparticipantes="
                + qtdparticipantes + ", uf=" + uf + "]";
    }

    

}
