package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnexionUnique {

	private static Connection connection = null;
	
	public Connection getConnection() {
		return connection;
	}

	private static ConnexionUnique instance;
	private static String CONNECT_URL = "jdbc:mysql://localhost:3306/maBD";
	static final String login = "root";
	static final String psw = "mysql";
	
	private ConnexionUnique () throws SQLException {
		connection = DriverManager.getConnection(CONNECT_URL, login, psw);
		
	};
	
	public static ConnexionUnique getInstance () {
		if (null == instance)
			try {
				instance = new ConnexionUnique();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//Wait & See
			}
		return instance;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
