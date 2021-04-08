package dados;

public class Edicao {
    private int edicaoid;
    private String cidade;
    private String uf;
    private int qtdparticipantes;
    private int ano;
    
    public int getEdicaoid() {
        return edicaoid;
    }
    public void setEdicaoid(int edicaoid) {
        this.edicaoid = edicaoid;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public int getQtdparticipantes() {
        return qtdparticipantes;
    }
    public void setQtdparticipantes(int qtdparticipantes) {
        this.qtdparticipantes = qtdparticipantes;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        return "Edicao [id = " + edicaoid +"ano=" + ano + ", cidade=" + cidade +  ", qtdparticipantes="
                + qtdparticipantes + ", uf=" + uf + "]";
    }

    

}
