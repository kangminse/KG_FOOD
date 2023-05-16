package Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class DB{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public DB() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}