package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class DataTrail1 {
	public static void main(String[] args) {
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
			Statement stm = con.createStatement();
			String sql = "select * from registerantprofile";
			ResultSet rs = stm.executeQuery(sql);
			System.out.println(rs.getString(1));
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ rs.getString(2));
				con.close();
			}
		}
//		catch (ClassNotFoundException e)
//		{
//		e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//		e.printStackTrace();
//		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
}
