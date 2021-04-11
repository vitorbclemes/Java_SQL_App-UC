package dados;

public class Artigo {
    private int artigoid;
    private String titulo;
    private Tipo tipo;
    private Edicao edicao;
    
    
    /** 
     * Retorna o id do Artigo
     * @return int
     */
    public int getArtigoid() {
        return artigoid;
    }
    
    /** 
     * Atribui o id do Artigo
     * @param artigoid
     */
    public void setArtigoid(int artigoid) {
        this.artigoid = artigoid;
    }
    
    /** 
     * Retorna o titulo do Artigo
     * @return String
     */
    public String getTitulo() {
        return titulo;
    }
    
    /** 
     * Atribui o titulo do Artigo
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /** 
     * Retorna a Edicao do Artigo
     * @return Edicao
     */
    public Edicao getEdicao() {
        return edicao;
    }
    
    /** 
     * Atribui a Edicao do Artigo
     * @param edicao
     */
    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
    
    /** 
     * Retorna o Tipo do Artigo
     * @return Tipo
     */
    public Tipo getTipo() {
        return tipo;
    }
    
    /** 
     * Atribui o Tipo do Artigo
     * @param tipo
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    /** 
     * Retorna os valores do Artigo em String formatada para uso geral
     * @return String
     */
    @Override
    public String toString() {
        String tipoid = (tipo == null) ? "null" : Integer.toString(tipo.getTipoid());
        String edicaoid = (edicao == null) ? "null" : Integer.toString(edicao.getEdicaoid());
        return "Artigo [id=" + artigoid + ", edicaoId=" + edicaoid + ", tipoId=" + tipoid + ", titulo=" + titulo + "]";
    }

    
    /** 
     * Retorna os valores do Artigo em String formatada para uso específico
     * @return String
     */
    public String composedToString(){
        return "Artigo [id =" + artigoid + ", titulo="+titulo + "  //  Edicao [cidade=" + edicao.getCidade() + ", ano=" + edicao.getAno();
    }
}
