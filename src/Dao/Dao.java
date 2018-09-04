package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	private final String DB_NAME ="u22";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private int rc = 0;

	public Dao()throws SQLException , ClassNotFoundException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + DB_NAME + "?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", DB_USER,DB_PASS);
			this.st = this.cn.createStatement();
		}catch (SQLException e) {
			throw e;
		}catch (ClassNotFoundException e){
			throw e;
		}
	}

	public ResultSet execute(String sql)throws SQLException{
		try{
			return this.st.executeQuery(sql);
		}catch(SQLException e) {
			throw e;
		}
	}

	public void executeUpdate(String sql)throws SQLException {
		try{
			this.rc = st.executeUpdate(sql);
		}catch(SQLException e){
			throw e;
		}
	}

	public void close() throws SQLException{
		try{
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}if(cn != null){
				cn.close();
			}
		}catch(SQLException e){
			throw e;
		}
	}
}
