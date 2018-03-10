package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class Room {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Connection conn;
	private String number;
	private String price;
	private String image;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	Room() {
		
	}
	
	Room(Connection conn) {
		this.conn = conn;
	}
	
	Room(String number, String price, String image) {
		this.number = number;
		this.price = price;
		this.image =  image;
	}
	
	public boolean exists(String number) throws SQLException {
		String sql = "SELECT COUNT(*) AS count FROM rooms WHERE number = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		int num = Integer.parseInt(number);
		stmt.setInt(1, num);
		
		ResultSet rs = stmt.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt("count");
		}
		rs.close();

		if (count == 0) {
			return false;
		}
		return true;
	}
	
	public boolean addRoom(String number, String price, String image) throws SQLException {
		String sql = "INSERT INTO rooms (number, price, image) VALUES (?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		int num = Integer.parseInt(number);
		int priceInt = Integer.parseInt(price);
		
		stmt.setInt(1, num);
		stmt.setInt(2, priceInt);
		stmt.setString(3, image);
		stmt.executeUpdate();
		stmt.close();
		
		return true;
	}
	
	/*public ArrayList<Room> viewAllRooms() throws SQLException {
	
		String sql = "SELECT * FROM rooms";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
	
		String number, price, image;
		ArrayList<Room> roomList= new ArrayList<Room>();
		
		int i = 0;
		while (result.next()) 
		{
			number = Integer.toString(result.getInt("number"));
			price = Integer.toString(result.getInt("price"));
			image = result.getString("image");
			roomList.add(new Room());
			roomList.get(i).setNumber(number);
			roomList.get(i).setPrice(price);
			roomList.get(i).setImage(image);
			i++;
		}
		
		return roomList;
	}*/

}
