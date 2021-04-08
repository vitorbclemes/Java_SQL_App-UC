package Sistema;

//JAVA.UTIL Imports
import java.util.List;
import java.util.Scanner;

//SQL Imports
import java.sql.SQLException;

//EXCEPTIONS Imports
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

//PERSISTENCIA Imports
import persistencia.*;

//DATA Imports
import dados.*;

public class Controller {
    private EdicaoDAO edicaoDAO;
    private ArtigoDAO artigoDAO;
    private TipoDAO tipoDAO;
    private Scanner s = new Scanner(System.in);

    public Controller() throws SQLException,ClassNotFoundException{
        edicaoDAO = EdicaoDAO.getInstance();
        artigoDAO = ArtigoDAO.getInstance();
        tipoDAO = TipoDAO.getInstance();
    }

    public Artigo novoArtigo() throws SelectException,InsertException{
        Artigo a = new Artigo();
        System.out.println("Titulo:");
        a.setTitulo(s.nextLine());
        System.out.println("Tipo(Id):");
        a.setTipo(this.selectTipo(s.nextInt()));
        System.out.println("Edicao(id):");
        a.setEdicao(this.selectEdicao(s.nextInt()));

        return a;  
    }

    public Edicao novaEdicao() throws InsertException{
        Edicao e = new Edicao();
        System.out.println("Cidade:");
        e.setCidade(s.nextLine());
        System.out.println("Estado(UF):");
        e.setUf(s.nextLine());
        System.out.println("Quantidade de Participantes:");
        e.setQtdparticipantes(s.nextInt());
        System.out.println("Ano:");
        e.setAno(s.nextInt());

        return e;
    }
    
    public void inserirArtigo(Artigo a) throws InsertException{
        artigoDAO.insert(a);
    }

    public void inserirEdicao(Edicao e) throws InsertException{
        edicaoDAO.insert(e);
    }
    
    public void deletarArtigo(Artigo a) throws DeleteException{
        artigoDAO.delete(a);
    }

    public void deletarEdicao(Edicao e) throws DeleteException{
        edicaoDAO.delete(e);
    }

    public void atualizarArtigo(int artigoid) throws UpdateException,SelectException,InsertException{
        Artigo artigo = novoArtigo();
        artigo.setArtigoid(artigoid);
        artigoDAO.update(artigo);
    }

    public void atualizarEdicao(int edicaoid) throws UpdateException,SelectException,InsertException{
        Edicao edicao = novaEdicao();
        edicao.setEdicaoid(edicaoid);
        edicaoDAO.update(edicao);
    }

    public Artigo selectArtigo(int artigoid) throws SelectException{
        return artigoDAO.select(artigoid);
    }

    public Edicao selectEdicao(int edicaoid) throws SelectException{
        return edicaoDAO.select(edicaoid);
    }

    public Tipo selectTipo(int tipoid) throws SelectException{
        return tipoDAO.select(tipoid);
    }

    public List<Artigo> selectAllArtigo() throws SelectException{
        return artigoDAO.selectAll();
    }
    
    public List<Edicao> selectAllEdicao() throws SelectException{
        return edicaoDAO.selectAll();
    }

    //Customizado
    public List<Artigo> selectAllArtigoWithEdicoes() throws SelectException{
        return artigoDAO.selectAllArtigosWithEdicoes();
    }
}
