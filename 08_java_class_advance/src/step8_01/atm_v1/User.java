package step8_01.atm_v1;

public class User {
	//사용자 한명은 id하나를 갖을 수 있고 계좌는 여러개를 갖을수있다.
	String id;
	int accCount;
	Account[] acc;
	
	void printAccount() {
		
		for (int i = 0; i < accCount; i++) {
			acc[i].printOwnAccount();
		}	
		
	}
	
}
