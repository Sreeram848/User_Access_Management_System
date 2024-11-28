package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//private Connection connection;
import test.Software;
public class Statements {

	 public List<Software> getAllSoftwares() {
	        List<Software> softwares = new ArrayList<>();
		try {
		Connection con = Database.getCon();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM software");
		 ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                Software software = new Software();
	                software.setId(resultSet.getInt("id"));
	                software.setName(resultSet.getString("name"));
	                software.setDescription(resultSet.getString("description"));
	                softwares.add(software);
	            }
	        
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return softwares;
	}
	 public void addSoftware(Software software) {
		 try {
				Connection con = Database.getCon();
				PreparedStatement statement = con.prepareStatement("INSERT INTO software (name, description) VALUES (?, ?)");
				 statement.setString(1, software.getName());
		            statement.setString(2, software.getDescription());
		            statement.executeUpdate();
		            System.out.println("Software Added...");
			            }
		 
		 catch(Exception e) {
				e.printStackTrace();
			}	 
	 }
	 public void deleteSoftware(int id) {
		 try {
				Connection con = Database.getCon();
				PreparedStatement statement = con.prepareStatement("DELETE FROM software WHERE id = ?)");
				statement.setInt(1, id);
	            statement.executeUpdate();
	            System.out.println("Software Deleted...");
			            }
		 
		 catch(Exception e) {
				e.printStackTrace();
			} 
	 }
/*	 
	    public void close() {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
*/	 
	 
	 
	 
	 
	 
	 
	
}
