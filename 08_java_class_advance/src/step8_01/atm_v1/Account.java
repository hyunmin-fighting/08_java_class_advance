package step8_01.atm_v1;

public class Account {
	//계좌번호는 유일, 돈도 유일
	String number = "";
	int money = 0;
	
	void printOwnAccount() {
		System.out.println(number +  " : " + money);
	}
	
}
