package MenuService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MenuService {
	private int boardId;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	Scanner input = new Scanner(System.in);
	
	public MenuService(int boardId) {
		this.boardId = boardId;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("드라이브 로드 성공!");
			String id = "c##java", pwd="1234";
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			con = DriverManager.getConnection(url, id, pwd);
			//System.out.println("연결 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//DB
	
	public void menu(String type) {
		System.out.println("================================");
		String sql = "select * from menu where m_type=? and b_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, boardId);
			
			rs = ps.executeQuery();//명령문 실행버튼
			while(rs.next()) {
				
				System.out.println(rs.getString("m_type")+"    "+"메뉴:"+rs.getString("m_name")+"     "+"가격:"+rs.getInt("m_price"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("================================");
	}//select
	
	public void item() {
		
		boolean bool = true;
		while(bool) {
			System.out.println("1.메인 2.사이드 3.주류 4.뒤로가기");
			System.out.print("메뉴를 선택해주세요 : ");
			
			int num = input.nextInt();
			
			switch(num) {
			case 1:
				menu("메인");
				break;
			case 2:
				menu("사이드");	
				break;
			case 3:
				menu("주류");	
				break;
			case 4:
				bool=false;
				break;
			}
		}
	}//item
}
