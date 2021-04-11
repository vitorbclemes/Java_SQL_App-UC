package persistencia;

//SQL Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DATA Imports
import dados.Tipo;

import exceptions.SelectException;

public class TipoDAO {
    public static TipoDAO instance = null;
    
    //Apenas o necessario para manipular os artigos
    private PreparedStatement select;

    private TipoDAO() throws SQLException,ClassNotFoundException{
        Connection conexao = Conexao.getConexao();
		
        select = conexao.prepareStatement("select *	from tipos where tipoid = ?");
    }

    
    /** 
     * Inicia a instancia DAO caso ela nao exista
     * @return TipoDAO
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static TipoDAO getInstance() throws SQLException,ClassNotFoundException{
        if(instance == null)
            instance = new TipoDAO();
        return instance;
    }

    
    /** 
     * Seleciona um tipo do DB
     * @param tipoid
     * @return Tipo
     * @throws SelectException
     */
    public Tipo select(int tipoid) throws SelectException{
        Tipo tipo = null;
        try{
            select.setInt(1,tipoid);
            ResultSet rs = select.executeQuery();
            if(rs.next()){
                tipo = new Tipo();
                tipo.setTipoid(rs.getInt("tipoid"));
                tipo.setNome(rs.getString("nome"));
            }
            return tipo;
        }catch(Exception e){
            throw new SelectException("Nao foi possivel selecionar o tipo");
        }
    }
}
