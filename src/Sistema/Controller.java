package Sistema;

//JAVA.UTIL Imports
import java.util.List;
import java.util.Map;
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

    /** 
     * Busca as instancias DAO
     */
    public Controller() throws SQLException,ClassNotFoundException{
        edicaoDAO = EdicaoDAO.getInstance();
        artigoDAO = ArtigoDAO.getInstance();
        tipoDAO = TipoDAO.getInstance();
    }

    
    /** 
     * Cria um novo artigo a partir da entrada do usuario
     * @return Artigo
     * @throws SelectException
     * @throws InsertException
     */
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

    
    /** 
     * Cria uma nova edicao a partir da entrada do usuario
     * @return Edicao
     * @throws InsertException
     */
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
    
    
    /** 
     * Insere um artigo no DB atraves do DAO
     * @param a
     * @throws InsertException
     */
    public void inserirArtigo(Artigo a) throws InsertException{
        artigoDAO.insert(a);
    }

    
    /** 
     * Insere uma edicao no DB atraves do DAO
     * @param e
     * @throws InsertException
     */
    public void inserirEdicao(Edicao e) throws InsertException{
        edicaoDAO.insert(e);
    }
    
    
    /** 
     * Deleta um artigo no DB atraves do DAO
     * @param a
     * @throws DeleteException
     */
    public void deletarArtigo(Artigo a) throws DeleteException{
        artigoDAO.delete(a);
    }

    
    /** 
     * Deleta uma edicao no DB atraves do DAO
     * @param e
     * @throws DeleteException
     */
    public void deletarEdicao(Edicao e) throws DeleteException{
        edicaoDAO.delete(e);
    }

    
    /** 
     * Atualiza um artigo no DB atraves do DAO
     * @param artigoid
     * @throws UpdateException
     * @throws SelectException
     * @throws InsertException
     */
    public void atualizarArtigo(int artigoid) throws UpdateException,SelectException,InsertException{
        Artigo artigo = novoArtigo();
        artigo.setArtigoid(artigoid);
        artigoDAO.update(artigo);
    }

    
    /** 
     * Atualizar uma edicao no DB atraves do DAO
     * @param edicaoid
     * @throws UpdateException
     * @throws SelectException
     * @throws InsertException
     */
    public void atualizarEdicao(int edicaoid) throws UpdateException,SelectException,InsertException{
        Edicao edicao = novaEdicao();
        edicao.setEdicaoid(edicaoid);
        edicaoDAO.update(edicao);
    }

    
    /** 
     * Seleciona um artigo do DB atraves do DAO
     * @param artigoid
     * @return Artigo
     * @throws SelectException
     */
    public Artigo selectArtigo(int artigoid) throws SelectException{
        return artigoDAO.select(artigoid);
    }

    
    /** 
     * Seleciona uma edicao do DB atraves do DAO
     * @param edicaoid
     * @return Edicao
     * @throws SelectException
     */
    public Edicao selectEdicao(int edicaoid) throws SelectException{
        return edicaoDAO.select(edicaoid);
    }

    
    /** 
     * Seleciona um tipo do DB atraves do DAO
     * @param tipoid
     * @return Tipo
     * @throws SelectException
     */
    public Tipo selectTipo(int tipoid) throws SelectException{
        return tipoDAO.select(tipoid);
    }

    
    /** 
     * Seleciona todos os artigos do DB atraves do DAO
     * @return List<Artigo>
     * @throws SelectException
     */
    public List<Artigo> selectAllArtigo() throws SelectException{
        return artigoDAO.selectAll();
    }
    
    
    /** 
     * Seleciona todas as edicoes do DB atraves do DAO
     * @return List<Edicao>
     * @throws SelectException
     */
    public List<Edicao> selectAllEdicao() throws SelectException{
        return edicaoDAO.selectAll();
    }

    
    /** 
     * Seleciona todos os ids e titulos de Artigos e ids e anos das edicoes que ocorreram em Caxias do Sul do DB
     * @return String
     * @throws SelectException
     */
    public String selectAllArtigoWithEdicoes() throws SelectException{
        Map<Artigo,Edicao> valores =  artigoDAO.selectAllArtigosWithEdicoes();
        String res = "";
        for (Map.Entry<Artigo,Edicao> pair : valores.entrySet()) {
            res += "Artigo [id ="+pair.getKey().getArtigoid() + ", titulo=" + pair.getKey().getTitulo() + "] - Edicao [edicao =" +pair.getValue().getEdicaoid() + ",ano= " + pair.getValue().getAno() + "]\n";
        }
        return res;
    }

    
    /** 
     *Seleciona todas as edicoes que ocorreram no estado do Rio Grande do Sul atraves do DAO.Transforma em String apenas para permitir o print.
     * @return List<Edicao>
     * @throws SelectException
     */
    public List<Edicao> selectAllWhereUFisRS() throws SelectException{
        return edicaoDAO.selectAllWhereUFisRS();
    }
}
