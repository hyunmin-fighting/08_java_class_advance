package step8_01.atm_v1;
import java.util.Random;
import java.util.Scanner;

public class ATM_Question2 {
	
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
			
			if 		(sel == 1) {
				if(userManager.user[identifier].accCount == 0) {
					userManager.user[identifier].acc = new Account[1];
					userManager.user[identifier].acc[0] = new Account();
					userManager.user[identifier].acc[0].number = makeAccount;
				}
				else {
					Account[] tempAccount = userManager.getUser(identifier).acc;
					int tempAccCount = userManager.user[identifier].accCount;
					
					userManager.user[identifier].acc = new Account[tempAccCount+1];
					for (int i = 0; i < tempAccCount; i++) {
						userManager.user[identifier].acc[i] = tempAccount[i];
					}
					userManager.user[identifier].acc[tempAccCount] = new Account();
					userManager.user[identifier].acc[tempAccCount].number = makeAccount;
				}
				userManager.user[identifier].accCount++;
				System.out.println("[메시지] " + makeAccount + "계좌가 생성되었습니다." );
			}
			
			else if (sel == 2) {
				if(userManager.user[identifier].accCount == 0) {
					System.out.println("[메시지] 더이상 삭제할 계좌가 없습니다.");
					continue;
				}
				else if(userManager.user[identifier].accCount == 1) {
					System.out.println("[메시지]" + userManager.user[identifier].acc[0].number + "계좌가 삭제되었습니다.");
					userManager.user[identifier].acc = null;
				}
				else {
					System.out.print("[메시지] 삭제할 계좌를 입력하세요 : ");
					String delAccount = scan.next();
					int delIdx = -1;
					int tempAccCount = userManager.user[identifier].accCount;
					for (int i = 0; i < tempAccCount; i++) {
						if(userManager.user[identifier].acc[i].number.equals(delAccount)) {
							delIdx = i;
						}
					}
					if(delIdx == -1) {
						System.out.print("[메시지] 존재하지 않는 계좌번호입니다. ");
						continue;
					}
					else {
						System.out.println("[메시지] " + userManager.user[identifier].acc[delIdx].number + "계좌번호가 삭제되었습니다.");
						Account[] tempAccount = userManager.user[identifier].acc;
						userManager.user[identifier].acc = new Account[tempAccCount - 1];
						
						for (int i = 0; i < delIdx; i++) {
							userManager.user[identifier].acc[i] = tempAccount[i];
						}
						for (int i = delIdx; i < tempAccCount-1; i++) {
							userManager.user[identifier].acc[i] = tempAccount[i+1];
						}
					}
				}
				userManager.user[identifier].accCount--;
			}
			
			else if (sel == 3) {
				
				if(userManager.user[identifier].accCount == 0) {
					System.out.println("[메시지] 생성된 계좌가 없습니다.");
				}
				else {
					userManager.user[identifier].printAccount();
				}
			}
			
			else if (sel == 0) {
				logout();
				break;
			} 	
		}
		
	}	
}
