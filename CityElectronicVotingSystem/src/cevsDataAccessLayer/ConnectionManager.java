package cevsDataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * <p>
 * Represents a class for handling connection.
 * </p>
 * 
 * @author Yared
 * 
 */
public class ConnectionManager {
	/**
	 * <p>
	 * The path to the database.
	 * </p>
	 */
	private String connectionPath;

	/**
	 * <p>
	 * The current connection.
	 * </p>
	 */
	private Connection connection;

	/**
	 * <p>
	 * the Connection manager.
	 * </p>
	 */
	private static ConnectionManager instance = null;

	/**
	 * <p>
	 * Disabled default constructor.
	 * </p>
	 */
	private ConnectionManager() {
		setConnectionPath(getConnectionPath());
		setInstance(this);
	}

	/**
	 * 
	 * @param _connectionPath
	 */
	public ConnectionManager(String _connectionPath) {
		setConnectionPath(_connectionPath);
		setInstance(this);
	}

	/**
	 * <p>
	 * Makes connection to the database.
	 * </p>
	 */
	private Connection makeConnection() 
	{
		Connection cnn = null;
		String connection = "jdbc:sqlite:" + getConnectionPath();
		try {
			Class.forName("org.sqlite.JDBC");
			cnn = DriverManager.getConnection(connection);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return cnn;
	}

	/**
	 * <p>
	 * The
	 * 
	 * @return the current connection path.
	 */
	public String getConnectionPath() {
		return connectionPath;
	}

	/**
	 * <p>
	 * Sets the current connection Path to the DB.
	 * </p>
	 * 
	 * @param connectionPath
	 */
	public void setConnectionPath(String connectionPath) {
		this.connectionPath = connectionPath;
		setConnection(makeConnection());
	}

	/**
	 * @return the instance
	 */
	public static final ConnectionManager getInstance() {
		if (instance == null)
		{
			instance = new ConnectionManager();
		}
		try 
		{
			if (instance.getConnection() != null
					&& instance.getConnection().isClosed()) 
			{
				instance.makeConnection();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return instance;
	}

	/**
	 * @param instance
	 *            the instance to set
	 */
	private static void setInstance(ConnectionManager instance) {
		ConnectionManager.instance = instance;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection()
	{
		try {
			if ( connection.isClosed())
			{
				this.makeConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
