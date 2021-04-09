package persistencia;

//SQL Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//JAVA.UTIL imports
import java.util.List;
import java.util.ArrayList;

//DATA Imports
import dados.Edicao;

//EXCEPTIONS Imports
import exceptions.*;

public class EdicaoDAO {
    public static EdicaoDAO instance = null;

    private PreparedStatement insert;
    private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement select;
	private PreparedStatement selectAll;
	private PreparedStatement newId;

    private EdicaoDAO() throws SQLException,ClassNotFoundException{
        Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("insert into edicoes values (?,?,?,?,?)");
		delete = conexao.prepareStatement("delete from edicoes where edicoesid = ?");
		update = conexao.prepareStatement("update edicioes set cidade = ?,uf = ?,qtdparticipantes = ?, ano = ? where edicaoid = ?");
		select = conexao.prepareStatement("select *	from edicoes where edicaoid = ?");
		selectAll = conexao.prepareStatement("select * from edicoes");
		newId = conexao.prepareStatement("select nextval('edicoes_id_seq')"); 
    }

    public static EdicaoDAO getInstance() throws SQLException,ClassNotFoundException{
        if(instance == null)
            instance = new EdicaoDAO();
        return instance;
    }

    public void delete(Edicao ed) throws DeleteException{
        try{
            delete.setInt(1,ed.getEdicaoid());
            delete.executeUpdate();
        } catch(Exception e){
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
        }catch(SQLException e){
            throw new InsertException("Nao foi possivel inserir a edicao");
        }
    }

    public void insert(Edicao ed) throws InsertException{
        try{
            ed.setEdicaoid(newId());
            insert.setString(2, ed.getCidade());
            insert.setString(3, ed.getUf());
            insert.setInt(4, ed.getQtdparticipantes());
            insert.setInt(5, ed.getAno());
        }catch(Exception e){
            throw new InsertException("Nao foi possivel inserir a edicao");
        }
    }

    public Edicao select(int edicaoid) throws SelectException{
        Edicao edicao = null;
        try{
            select.setInt(1, edicaoid);
            ResultSet rs = select.executeQuery();
            if(rs.next()){
                edicao = new Edicao();
                edicao.setEdicaoid(rs.getInt("edicaoid"));
                edicao.setCidade(rs.getString("cidade"));
                edicao.setUf(rs.getString("uf"));
                edicao.setQtdparticipantes(rs.getInt("qtdparticipantes"));
                edicao.setAno(rs.getInt("ano"));
            }
            return edicao;
        }catch(Exception e){
            throw new SelectException("Nao foi possivel selecionar a edicao");
        }
    }

    public List<Edicao> selectAll() throws SelectException{
        List<Edicao> edicoes = new ArrayList<Edicao>();
        Edicao edicao = null;
        try{
            ResultSet rs = selectAll.executeQuery();
            while ( rs.next() ){
                edicao = new Edicao();
                edicao.setEdicaoid(rs.getInt("edicaoid"));
                edicao.setCidade(rs.getString("cidade"));
                edicao.setUf(rs.getString("uf"));
                edicao.setQtdparticipantes(rs.getInt("qtdparticipantes"));
                edicao.setAno(rs.getInt("ano"));

                edicoes.add(edicao);
            }
            return edicoes;
        }catch (Exception e){
            throw new SelectException("Nao foi possivel selecionar a edicao");
        }
    }

    public void update (Edicao ed) throws UpdateException{
        try{
            update.setInt(1, ed.getEdicaoid());
            update.setString(2, ed.getCidade());
            update.setString(3, ed.getUf());
            update.setInt(4, ed.getQtdparticipantes());
            update.setInt(5, ed.getAno());

            update.executeUpdate();
        }catch (SQLException e){
            throw new UpdateException("Nao foi possivel atualizar a edicao");
        }
    }


}
