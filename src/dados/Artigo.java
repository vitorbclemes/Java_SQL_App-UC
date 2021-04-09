package dados;

public class Artigo {
    private int artigoid;
    private String titulo;
    private Tipo tipo;
    private Edicao edicao;
    
    public int getArtigoid() {
        return artigoid;
    }
    public void setArtigoid(int artigoid) {
        this.artigoid = artigoid;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Edicao getEdicao() {
        return edicao;
    }
    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        String tipoid = (tipo == null) ? "null" : Integer.toString(tipo.getTipoid());
        String edicaoid = (edicao == null) ? "null" : Integer.toString(edicao.getEdicaoid());
        return "Artigo [id=" + artigoid + ", edicaoId=" + edicaoid + ", tipoId=" + tipoid + ", titulo=" + titulo + "]";
    }

    public String composedToString(){
        return "Artigo [id =" + artigoid + ", titulo="+titulo + "  //  Edicao [cidade=" + edicao.getCidade() + ", ano=" + edicao.getAno();
    }
}
