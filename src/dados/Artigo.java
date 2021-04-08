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
        return "Artigo [id=" + artigoid + ", edicaoId=" + edicao.getEdicaoid() + ", tipoId=" + tipo + ", titulo=" + titulo + "]";
    }


}
