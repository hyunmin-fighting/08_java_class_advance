package step8_01.atm_v1;
import java.util.Random;
import java.util.Scanner;

public class ATM_Question {
	
	Scanner scan = new Scanner(System.in);
	Random ran   = new Random();
	UserManager userManager = new UserManager();
	int identifier = -1;
	
	void printMainMenu() {
				
		while (true) {
			
			System.out.println("\n[ MEGA ATM ]");
			System.out.print("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();
			
			if      (sel == 1) 	    login();
			else if (sel == 2) 		logout();
			else if (sel == 3) 		join();
			else if (sel == 4) 		leave();
			else if (sel == 0) {
				System.out.println("[메시지] 프로그램을 종료합니다.");
				break;
			}
			
		}
		
	}
	
	
	
	void login() {
		
		identifier = userManager.logUser();
		
		if (identifier != -1) {
			printAccountMenu();
		}
		else {
			System.out.println("[메세지] 로그인실패.");
		}
		
	}
	
	
	
	void join() {	
		
		userManager.addUser();
		
	}
	
	
	
	void logout() {
		
		if (identifier == -1) {
			System.out.println("[메시지] 로그인을 하신 후 이용하실 수 있습니다.");
		}
		else {
			identifier = -1;
			System.out.println("[메시지] 로그아웃 되었습니다.");
		}
		
	}
	
	
	
	void leave() {
		
		userManager.leave();
		
	}
	
	
	
	void printAccountMenu() {
		
		while (true) {
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
		 	String makeAccount = Integer.toString(ran.nextInt(90001)+10000);
			//10000~100000 중 랜덤 계좌 번호 생성(makeAccount) 
			
			if 		(sel == 1) {
			//계좌 생성
				if(userManager.user[identifier].accCount == 0) {
					//로그인된 고객클래스의 계좌수가 0이면
					userManager.user[identifier].acc = new Account[1];
					//로그인된 고객클래스의 계좌배열의 크기를 1로 만들어줌
					userManager.user[identifier].acc[0] = new Account();
					//로그인된 고객클래스 계좌배열의 0번인덱스 값에 신규 계좌 인스턴스 생성 
					userManager.user[identifier].acc[0].number = makeAccount;
					//신규계좌인스턴스의 number변수에 생성된 랜덤 계좌번호 복사
				}
				else {
					//로그인된 고객클래스의 계좌수가 0이 아니면 
					Account[] temp = userManager.getUser(identifier).acc;
					//로그인된 고객클래스의 계좌배열을 temp 배열에 복사
					int tempAccCount = userManager.user[identifier].accCount;
					//로그인된 고객클래스의 계좌수를 tempAccCount 변수에 복사
					userManager.user[identifier].acc = new Account[tempAccCount + 1];
					//로그인된 고객 클래스 계좌배열 크기를 1증가하여 초기화
					for (int i = 0; i < tempAccCount; i++) {
						userManager.user[identifier].acc[i] = temp[i];
						//로그인된 고객 클래스 계좌배열의 각 계좌클래스를 복사(temp -> 증가된 계좌배열) 
					}
					userManager.user[identifier].acc[tempAccCount] = new Account();
					//로그인된 고객 클래스의 계좌배열 마지막 인덱스에 계좌 인스턴스 생성
					userManager.user[identifier].acc[tempAccCount].number = makeAccount;
					// 로그인된 고객 클래스의 계좌배열 중 생성한 마지막 계좌의 number변수에 생성된 랜덤 계좌번호 복사 
				}
				userManager.user[identifier].accCount++;
				//로그인된 고객 클래스의 계좌수 변수 크기를 1증가 
				System.out.println("[메시지]" + makeAccount + "계좌가 생성되었습니다.");
				
			} 	// 구현해 보시오.	
			
			else if (sel == 2) {
			
				if(userManager.user[identifier].accCount == 0) {
					//로그인된 고객 클래스의 계좌수가 0과 같으면
					System.out.println("[메시지]더이상 삭제할 계좌가 없습니다.");
					continue;
				}
				if(userManager.user[identifier].accCount == 1) {
					//로그인된 고객 클래스의 계좌수가 1과 같으면
					System.out.println("[메시지]" + userManager.user[identifier].acc[0].number + "가 삭제되었습니다.");
					userManager.user[identifier].acc = null;
					//로그인된 고객 클래스의 계좌배열을 null로 초기화
				}
				else {
					//로그인된 고객 클래스의 계좌수가 0또는 1이 아니면 
					System.out.println("메시지] 삭제하고자하는 계좌번호를 입력하세요.");
					String deleteAccount = scan.next();
					//지우고자하는 계좌번호 입력 받아 
					int tempAccCount = userManager.user[identifier].accCount;
					//로그인된 고객 클래스의 계좌수를 tempAccCount 변수에 복사하고
					int delIdx = -1;
					// delIdx변수를 선언후 -1로 초기화 (입력한 계좌 서치용)
					for (int i = 0; i < tempAccCount; i++) {
						if(userManager.user[identifier].acc[i].number.equals(tempAccCount)) {
							delIdx = i;
						}
						//로그인된 고객 클래스의 계좌배열의 각 클래스 계좌번호와 입력받은 계좌번호가 동일하면
						//해당 인덱스값을 delIdx에 복사
					}
					if(delIdx == -1) {
						System.out.println("[메시지] 계좌번호를 확인하세요.\n");
						continue;
						// 입력받은 계좌번호를 해당 고객의 계좌클래스의 배열에서 찾지 못했으면 재확인 요청 메시지
					}
					else {
						//찾았으면,
						System.out.println("[메시지] " + userManager.user[identifier].acc[delIdx].number + "가 삭제되었습니다.");
						Account[] temp = userManager.user[identifier].acc;
						//로그인된 고객의 계좌클래스 배열을 temp 참조변수에 복사
						userManager.user[identifier].acc = new Account[tempAccCount - 1];
						//로그인된 고객의 계좌클래스 배열을 크기 1개 줄여서 초기화
					
					
					for (int i = 0; i < delIdx; i++) {
						userManager.user[identifier].acc[i] = temp[i];
					}
						for (int i = delIdx; i < tempAccCount-1; i++) {
							userManager.user[identifier].acc[i] = temp[i+1];
						}
					}
					//기존에 복사했던 계좌클래스 배열을 다시 복원 
				}
				userManager.user[identifier].accCount--;
				//계좌수 1 감소
				
			} 	// 구현해 보시오.
			
			else if (sel == 3) {
				
				if(userManager.user[identifier].accCount == 0) {
					//로그인된 고객의 계좌수가 0이면
					System.out.println("[메시지] 생성된 계좌가 없습니다.\n");
				}
				else {
					userManager.user[identifier].printAccount();
				}
				//로그인된 고객의 계좌정보출력
			}  	// 구현해 보시오.
			
			else if (sel == 0) {
				logout();
				break;
				//로그아웃함수 호출하여 identidier를 -1로 셋팅하고 계좌관리 루프에서 빠져나감
			} 	// 구현해 보시오.
		}
		
	}	
}
