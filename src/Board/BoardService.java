package Board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardService {
	
	Scanner input = new Scanner(System.in); 
	private DB db = new DB();
	
	// 최신날짜순서
	public ArrayList<BoardDTO> date_select() {
		String sql = "select * from board order by b_reg_date desc";
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			db.ps = db.con.prepareStatement(sql);
			db.rs = db.ps.executeQuery();
			while(db.rs.next() ) {
			BoardDTO dto =	new BoardDTO();
			dto.setbId( db.rs.getInt("B_ID"));
			dto.setBnName(db.rs.getString("B_NAME"));
			dto.setbScore( db.rs.getInt("B_SCORE"));
			dto.setbRegDate(db.rs.getDate("B_REG_DATE"));
			dto.setbOpenTime(db.rs.getString("B_OPEN_TIME"));
			dto.setbAddr(db.rs.getString("B_ADDR"));
			dto.setbDesc(db.rs.getString("B_DESC"));
			dto.setbTel(db.rs.getString("B_TEL"));
			
			list.add(dto);
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 평점날짜순서
	public ArrayList<BoardDTO> score_select() {
		String sql = "select * from board order by B_score desc";
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			db.ps = db.con.prepareStatement(sql);
			db.rs = db.ps.executeQuery();
			while(db.rs.next() ) {
			BoardDTO dto =	new BoardDTO();
			dto.setbId( db.rs.getInt("B_ID"));
			dto.setBnName(db.rs.getString("B_NAME"));
			dto.setbScore( db.rs.getInt("B_SCORE"));
			dto.setbRegDate(db.rs.getDate("B_REG_DATE"));
			dto.setbOpenTime(db.rs.getString("B_OPEN_TIME"));
			dto.setbAddr(db.rs.getString("B_ADDR"));
			dto.setbDesc(db.rs.getString("B_DESC"));
			dto.setbTel(db.rs.getString("B_TEL"));
			
			list.add(dto);
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return list;
	}
	
	//등록
	public void register() {
		String sql = "insert into board values('',?, ?, sysdate, ?, ?, ?, ?  )";
		try {
			db.ps = db.con.prepareStatement(sql);
		
		int result;
		int B_SCORE;
		String B_NAME, B_ADDR, B_OPEN_TIME, B_DESC, B_TEL;
		
		System.out.print("추가할 음식점 이름  : ");
		B_NAME = input.next();
		System.out.print("추가할 음식점 주소  : ");
		B_ADDR = input.next();
		System.out.print("추가할 음식점 오픈/마감시간  : ");
		B_OPEN_TIME = input.next();
		System.out.print("추가할 음식점의 간단한 설명  : ");
		B_DESC = input.next();
		System.out.print("추가할 음식점 전화번호  : ");
		B_TEL = input.next();
		System.out.print("추가할 음식점 평점  : ");
		B_SCORE = input.nextInt();
		
		db.ps.setString(1, B_NAME);
		db.ps.setInt(2,B_SCORE);
		db.ps.setString(3,B_ADDR);
		db.ps.setString(4,B_OPEN_TIME);
		db.ps.setString(5,B_DESC);
		db.ps.setString(6,B_TEL);
		result = db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1건이 추가 되었습니다.");
				
	}
	
	//삭제
	public void  delete() {
		String sql = "delete from board  where B_NAME = ?";
		try {
			db.ps = db.con.prepareStatement(sql);
		
		int result;
		String B_NAME;
		
		System.out.print("삭제할 상점 이름  : ");
		B_NAME = input.next();
		db.ps.setString(1, B_NAME);
		result = db.ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1건이 삭제 되었습니다.");
				
	}
		
		
	
	
	
		
}
