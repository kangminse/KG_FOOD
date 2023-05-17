package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
	
	private Scanner input = new Scanner(System.in);
	
	public boolean login() {
		System.out.println("아이디 입력");
		String inputLoginId = input.next();
		System.out.println("비밀번호 입력");
		String inputLoginPwd = input.next();
		
		Connection con = connectAuto();
		String sql = "SELECT u_login_pwd FROM kg_user where u_login_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, inputLoginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String pwd = rs.getString(1);
				if( pwd.equals(inputLoginPwd) ) {
					System.out.println("로그인 성공");
					return true;
				}else {
					System.out.println("로그인 실패");
					return false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public void join(){
		System.out.println("아이디 입력");
		String inputLoginId = input.next();
		System.out.println("비밀번호 입력");
		String inputLoginPwd = input.next();
		System.out.println("닉네임입력");
		String inputLoginNick = input.next();
		try {
						
			Connection con = connectAuto();
			String sql = "INSERT INTO kg_user(u_login_id,u_login_pwd,u_nick) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, inputLoginId);
			ps.setString(2, inputLoginPwd);
			ps.setString(3, inputLoginNick);
			ps.execute();
			System.out.println("회원가입 완료");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("회원가입 실패");
		}
		
	}
	

public static Connection connectAuto() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String id = "java", pwd="1234";
		String url = 
				"jdbc:oracle:thin:@localhost:1521/xe";
		return DriverManager.getConnection(url, id, pwd);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}

}
