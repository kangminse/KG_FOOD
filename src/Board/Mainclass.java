package Board;

import java.util.ArrayList;

import java.util.Scanner;

import MenuService.MenuService;


public class Mainclass {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);	
		BoardService order = new BoardService();
		
		
		while(true) {
			System.out.println("식당목록을 보여드립니다.");
			System.out.println("보고 싶은 순서를 선택하세요.\n");
			System.out.println("1. 평점순서");
			System.out.println("2. 최근등록순서");
			System.out.print("번호 입력 => ");
			int num1 = input.nextInt();
			
		// 평점순서
		switch (num1) {
		case 1:
			ArrayList<BoardDTO> list1 = order.score_select();
			for (BoardDTO b: list1) {
				System.out.println();
				System.out.println(b.toString());
			}
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("원하시는 메뉴를 클릭하세요.");
			System.out.println("1. 자세히 보기");
			System.out.println("2. 식당 등록하기");
			System.out.println("3. 식당 삭제하기");
			System.out.println("4. 목록 다시 보기");
			System.out.print("번호 입력 => ");
			int num2 = input.nextInt();
			System.out.println();
				if(num2==1) {
					System.out.print("자세히 보고 싶은 식당 번호를 입력하세요 : ");
					MenuService menuService = new MenuService(input.nextInt());
					menuService.item();
				}else if(num2==2) {
					order.register();
				}else if(num2==3) {
					order.delete();
				}else {
					System.out.println("목록 선택으로 돌아갑니다.\n");
				}
				break;
		
		// 최신날짜순서
		case 2:
			ArrayList<BoardDTO> list2 = order.date_select();
			for (BoardDTO b: list2) {
				System.out.println();
				System.out.println(b.toString());
			}
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("상점에 대한 자세한 내용을 보시겠습니까?");
			System.out.println("원하시는 메뉴를 클릭하세요.");
			System.out.println("1. 자세히보기");
			System.out.println("2. 식당 등록하기");
			System.out.println("3. 식당 삭제하기");
			System.out.println("4. 목록 다시 보기");
			System.out.print("번호 입력 => ");
			int num3 = input.nextInt();
			System.out.println();
			if(num3==1) {
				//민서님
				System.out.println("자세히 보고 싶은 식당 번호를 입력하세요 : ");
				input.next();
			}else if(num3==2) {
				order.register();
			}else if(num3==3) {
				order.delete();
			}else {
				System.out.println("목록 선택으로 돌아갑니다.\n");
			}
			break;
			
			}//switch문 
			
		}//while문
		
		
		
	}

}
