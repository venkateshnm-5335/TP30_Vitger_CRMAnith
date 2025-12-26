package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {

	Connection conn=null; 
	ResultSet result=null;
	/**
	 * this method is used to connect To Database
	 * @return
	 * @throws SQLException
	 */
	public ResultSet connectToDb() throws SQLException{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		conn = DriverManager.getConnection(IpathConstants.dbUrl,IpathConstants.dbusername,IpathConstants.dbpassword);
		return result;
	}
	/**
	 * this method is used to execute Query
	 * @return
	 * @throws SQLException
	 */
	//execute query
	public ResultSet executeQuery() throws SQLException{
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("query");
		return result;
	}
	/**
	 * this method is used to update Query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public Statement updateQuery(String query) throws SQLException{
		Statement res = conn.createStatement();
		return res;
	}
	/**
	 * to close the Db connection
	 * @throws SQLException
	 */
	//close  database connection 

	public void disconnectDB() throws SQLException
	{
		conn.close();
	}

}






