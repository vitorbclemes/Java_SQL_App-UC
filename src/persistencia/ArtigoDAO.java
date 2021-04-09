package persistencia;

//SQL Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//JAVA.UTIL imports
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

//DATA Imports
import dados.Artigo;
import dados.Edicao;

//EXCEPTIONS Imports
import exceptions.*;

public class ArtigoDAO {
    public static ArtigoDAO instance = null;
    public static EdicaoDAO edicaoDAO = null;
    public static TipoDAO tipoDAO = null;

    private PreparedStatement insert;
    private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;
    // Customizado
    private PreparedStatement selectAllArtigosWithEdicoes;

    private ArtigoDAO() throws SQLException,ClassNotFoundException{
        Connection conexao = Conexao.getConexao();
        edicaoDAO = EdicaoDAO.getInstance();
        tipoDAO = TipoDAO.getInstance();


        insert = conexao.prepareStatement("insert into artigos values (?,?,?,?)");
		delete = conexao.prepareStatement("delete from artigos where artigoid = ?");
		update = conexao.prepareStatement("update artigos set titulo = ?,tipoid = ?,edicaoid = ? where artigoid = ?");
		select = conexao.prepareStatement("select *	from artigos where artigoid = ?");
		selectAll = conexao.prepareStatement("select * from artigos");
		newId = conexao.prepareStatement("select nextval('artigos_id_seq')");

        // Permitir uma consulta com juncao de Tabelas (OK)
        //Retorna a.artigoid,a.titulo,e.edicaoid,e.ano das edicoes onde cidade = Caxias do Sul
        selectAllArtigosWithEdicoes = conexao.prepareStatement("select a.artigoid,a.titulo,e.edicaoid,e.ano from artigos a JOIN edicoes e ON a.edicaoid = e.edicaoid and e.cidade = 'Caxias do Sul'");
    }

    public Map<Artigo,Edicao> selectAllArtigosWithEdicoes() throws SelectException{
        Map<Artigo,Edicao> objects  = new HashMap<Artigo,Edicao>();
        Artigo artigo = null;
        Edicao edicao = null;
        try{
            ResultSet rs = selectAllArtigosWithEdicoes.executeQuery();
            while ( rs.next() ){
                artigo = new Artigo();
                edicao = new Edicao();
                artigo.setArtigoid(rs.getInt("artigoid"));
                artigo.setTitulo(rs.getString("titulo"));
                edicao.setEdicaoid(rs.getInt("edicaoid"));
                edicao.setAno(rs.getInt("ano"));

                objects.put(artigo, edicao);
            }
            return objects;
        }catch(SQLException e){
            throw new SelectException("Nao foi possivel selecionar o artigo");
        }
    }
    
    public static ArtigoDAO getInstance() throws SQLException,ClassNotFoundException{
        if(instance == null)
            instance = new ArtigoDAO();
        return instance;
    }

    public void delete(Artigo a) throws DeleteException{
        try{
            delete.setInt(1,a.getArtigoid());
            delete.executeUpdate();
        }catch (Exception e){
            throw new DeleteException("Erro na delecao");
        }
    }

    public int newId() throws InsertException{
        try{
            ResultSet rs = newId.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            else{
                return 0;
            }
        }catch (SQLException e){
            throw new InsertException("Nao foi possivel inserir o artigo");
        }
    }

    public void insert(Artigo a) throws InsertException{
        try{
            a.setArtigoid(newId());
            insert.setInt(1, a.getArtigoid());
            insert.setString(2, a.getTitulo());
            insert.setInt(3,a.getTipo().getTipoid());
            insert.setInt(4, a.getEdicao().getEdicaoid());
            insert.executeUpdate();
        
        }catch (Exception e){
            throw new InsertException("Nao foi possivel inserir o artigo");
        }
    }

    public Artigo select(int artigoid) throws SelectException{
        Artigo artigo = null;
        try{
            select.setInt(1, artigoid);
            ResultSet rs = select.executeQuery();
            if( rs.next() ){
                artigo = new Artigo();
                artigo.setArtigoid(rs.getInt("artigoid"));
                artigo.setTitulo(rs.getString("titulo"));
                int tipoid = rs.getInt("tipoid");
                artigo.setTipo(tipoDAO.select(tipoid));
                int edicaoid = rs.getInt("edicaoid");
                artigo.setEdicao(edicaoDAO.select(edicaoid));
            }
            return artigo;
        }catch(Exception e){
            throw new SelectException("Nao foi possivel selecionar o artigo");
        }
    }

    public List<Artigo> selectAll() throws SelectException{
        List<Artigo> artigos = new ArrayList<Artigo>();
        Artigo artigo = null;
        try{
            ResultSet rs = selectAll.executeQuery();
            while ( rs.next() ){
                artigo = new Artigo();
                artigo.setArtigoid(rs.getInt("artigoid"));
                artigo.setTitulo(rs.getString("titulo"));
                int tipoid = rs.getInt("tipoid");
                artigo.setTipo(tipoDAO.select(tipoid));
                int edicaoid = rs.getInt("edicaoid");
                artigo.setEdicao(edicaoDAO.select(edicaoid));

                artigos.add(artigo);
            }
            return artigos;
        }catch(SQLException e){
            throw new SelectException("Nao foi possivel selecionar o artigo");
        }
    }

    public void update(Artigo artigo) throws UpdateException{
        try{
            update.setInt(1, artigo.getArtigoid());
            update.setString(2, artigo.getTitulo());
            update.setInt(3, artigo.getTipo().getTipoid());
            update.setInt(4, artigo.getEdicao().getEdicaoid());
            
            update.executeUpdate();
        }catch (SQLException e){
            throw new UpdateException("Nao foi possivel atualizar o artigo");
        }
    }


    
}