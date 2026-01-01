package framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtil {
	
	static Properties prop = PropUtil.readData("Config.properties");
	
	//Common method to connect with the database and get the raw data in the form of ResultSet
	public static ResultSet executeQuery(String query) throws SQLException {
		ResultSet dataset = null;
		String url = prop.getProperty("DB_URL");
		String username = prop.getProperty("DB_USERNAME");
		String password = prop.getProperty("DB_PASSWORD");
		
		Connection connection = DriverManager.getConnection(url, username, password);
		dataset = connection.createStatement().executeQuery(query);
		
		return dataset;
	}

	//Convert raw data collected from the database into a List<Map<String,String>>  format.
	public static List<Map<String, String>> getData(String query) throws SQLException {
		
		//Create an empty List of Map to store the data.
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();

		//Get the raw data from database in the form of ResultSet
		ResultSet rs = executeQuery(query);
		
		//Convert the ResultSet data into List<Map<String,String>> format.
		while(rs.next())	{//if there is data present in the ResultSet and move the cursor to next row.
			Map<String, String> row = new HashMap<String, String>();
			
			for(int c=1; c<=rs.getMetaData().getColumnCount(); c++) {
				String columnName = rs.getMetaData().getColumnName(c);
				String columnValue = rs.getString(c);
				row.put(columnName, columnValue);
			}
			
			data.add(row);
		}		
			
			
		//return the data
		return data;
	}
	
	public static void main(String args[]) throws SQLException {
		String query = "SELECT FILM.TITLE AS MOVIE_NAME, CATEGORY.NAME AS MOVIE_CATEGORY, LANGUAGE.NAME AS MOVIE_LANGUAGE FROM CATEGORY\r\n"
				+ "JOIN\r\n"
				+ "FILM_CATEGORY\r\n"
				+ "ON\r\n"
				+ "CATEGORY.CATEGORY_ID = FILM_CATEGORY.CATEGORY_ID\r\n"
				+ "JOIN\r\n"
				+ "FILM\r\n"
				+ "ON\r\n"
				+ "FILM_CATEGORY.FILM_ID = FILM.FILM_ID\r\n"
				+ "JOIN\r\n"
				+ "LANGUAGE\r\n"
				+ "ON\r\n"
				+ "FILM.LANGUAGE_ID = LANGUAGE.LANGUAGE_ID\r\n"
				+ "WHERE\r\n"
				+ "CATEGORY.NAME = 'Horror'\r\n"
				+ "AND\r\n"
				+ "FILM.TITLE LIKE '%Devil%'\r\n"
				+ "AND\r\n"
				+ "LANGUAGE.NAME ='English'\r\n"
				+ "ORDER BY\r\n"
				+ "FILM.TITLE ASC\r\n"
				+ "LIMIT 10;";
		
		List<Map<String, String>> data = getData(query);
		//System.out.println(data.size());
		//System.out.println(data);
		System.out.println(data.get(1).get("movie_name"));
		
	}
	
}
