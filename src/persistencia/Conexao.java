package persistencia;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
	private static Connection conexao = null;
	
	private Conexao() {
		
	}
	
	public static Connection getConexao() throws SQLException,ClassNotFoundException {
		if(conexao == null) {
			String url = "jdbc:postgresql://localhost:5432/evento";
			String username = "postgres";
			
			try {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url,username,"postgres" );
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return conexao;
	}


}