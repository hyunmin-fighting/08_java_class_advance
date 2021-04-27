package step8_01.atm_v1;

import java.util.Scanner;

public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	User[] user = null;							//User클래스 배열의 참조변수 user
	int userCount = 0;							//가입 회원 수 확인을 위한 변수 usercount, 0으로 초기화
	
	
	void printAllUser() {
		for(int i = 0; i < userCount; i++) {
			user[i].printAccount();
		}
	}
	
	
	
	void addUser() {
		
		if(userCount == 0) {			//가입 회원수가 없으면
			user = new User[1];    		// user 인스턴스에 배열 1개를 담는다
		}
		else {											//가입 회원수가 있으면
			User[] temp = user;							// user 참조변수를 temp 참조변수에 주소 복사
			user = new User[userCount + 1];				// user 참조변수에는 배열크기를 1늘린다
			for(int i = 0; i < userCount; i++) {		// 가입회원수만큼 for문 돌려
				user[i] = temp[i];						// temp 참조변수의 배열값을 배열크기 1증가된 user 참조변수의 배열값에 다시 옮겨 담는다
			}
			temp = null;								// temp 참조변수의 배열값은 메모리 해제
		}
		
		
		System.out.print("[가입] 아이디를 입력하세요 : ");
		String id = scan.next();				//id문자열 변수에 문자열 입력받는다
		
		boolean isDuple = false;				//isDuple 불리언 변수에 false로 초기화. ==> ID 중복 확인 목적 변수 생성 
		for (int i = 0; i < userCount; i++) {	//가입회원수만큼 for문 돌려
			if (user[i].id.equals(id)) {		// user참조변수에 각각의 배열값이 입력받은 id의 문자열과 일치 여부 확인하여
				isDuple = true;					// 일치하면 isDuple 변수에 true값을 담는다.
			}
		}
		if (!isDuple) {							//ID 중복이 없으면
			user[userCount] = new User();		// user 참조변수 배열의 "회원수" 인덱스 위치에 새로운 인스턴스를 생성하여
			user[userCount].id = id;			// 해당 인덱스의 User 클래스에 id값을 호출하여 입력받은 id값을 전달하고
			System.out.println("[메시지] ID : '" + id+ "' 가입 되었습니다.\n");
			userCount++;						// 회원수는 1 증가 시킨다
		}
		else {									//ID 중복이 있으면
			System.out.println("[메시지] '"+ id + "'은 이미 가입된 아이디 입니다.\n");	// 중복 알림 메시지를 출력한다
		}
		
	}
	
	
	
	User getUser(int idx) {
		
		return user[idx];
	}
	
	
	
	
	int logUser() {
		
		int identifier = -1;							// identifer 정수형 변수 선언하고 -1로 초기화
		System.out.print("[입력] 아이디를 입력하세요 : ");		// id 입력 요청
		String name = scan.next();						// name 문자열 변수 선언하고 값을 입력 받는다
		
		for (int i = 0; i < userCount; i++) {			// 가입회원만큼 for문을 돌려
			if (name.equals(user[i].id)) {				// 입력받은 name 문자열 값이 user인스턴스 각 클래스의 id를 검색하여 일치여부 확인 후
				identifier = i;							// 일치하면 해당 인덱스 정보를 identifier 변수에 복사
				System.out.println("[" + user[identifier].id + "] 님 로그인.\n"); // user인스턴스 identifier인덱스 위치 배열의 id값 호출 및 로그인 안내
			}
		}
		
		return identifier;								//아이디가 검색된 user 인스턴스 클래스의 인덱스(위치) = identifier 반환
		
	}
	
	
	
	void leave() {
		
		System.out.print("[입력] 탈퇴할 아이디를 입력하세요 : ");	 
		String name = scan.next();							// name 문자열 변수에 문자열[ID]을 입력받아서.. 
		int identifier = -1;								// 정수형 identifier변수를 선언하고 -1로 초기화하여
		for (int i = 0; i < userCount; i++) {				// 회원수만큼 For문을 돌려
			if (name.equals(user[i].id)) {					// 입력받은 ID 문자열 값이 user참조변수 배열List의 각ID값과 일치하는지 확인하여
				identifier = i;								// 일치하면 identifier값에 해당위치인덱스값을 담는다
			}
		}
		
		if(identifier == -1) {								// 입력받은 ID문자열값이 user참조변수 배열List안에 없으면
			System.out.println("[메시지] 아이디를 다시 확인하세요.");	// 재확인 알람 메시지를 띄우고
			return;											// 종료
		}
		
		System.out.println("ID : '" +user[identifier].id + "' 가 탈퇴되었습니다."); // 탈퇴 확인 알람을 띄우고
		
		User[] temp = user;									// User클래스의 temp 참조변수를 생성하여 user참조변수 값을 복사
		user = new User[userCount - 1];						// user참조변수는 클래수수를 1줄여서 새로운 배열 껍데기를 생성
		
		for(int i = 0; i < identifier; i++) {				// id가 같았던 위치 인덱스 값만큼 for문을 돌려
			user[i] = temp[i];								// 해당 인덱스 위치까지는 temp 참조변수의 배열값을 user참조변수 배열로 복사하고
		}
		for(int i =identifier; i < userCount-1; i++) {		// id가 같았던 위치부터 회원가입수-1 만큼의 for문을 돌려
			user[i] =temp[i + 1];							// user참조변수의 i번위치에 temp참조변수 i+1번 클래스를 복사
		}
		
		userCount--;										// 회원수는 1감소
		
	}
	
}
