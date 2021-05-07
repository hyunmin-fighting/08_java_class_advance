package step8_04.test;
import java.util.ArrayList;
import java.util.Arrays;

class Member {
	
	private int    custno;			// 회원번호
	private String custname;		// 회원성명
	private String phone;			// 회원전화
	private String address;			// 통신사
	private String joindate;		// 가입일자
	private String grade;			// 고객등급
	private String city;			// 거주도시
	
	public Member() {}
	
	public Member(int custno, String custname, String phone, String address, String joindate, String grade, String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	int getCustno() {
		return custno;
	}

	void setCustno(int custno) {
		this.custno = custno;
	}

	String getCustname() {
		return custname;
	}

	void setCustname(String custname) {
		this.custname = custname;
	}

	String getPhone() {
		return phone;
	}

	void setPhone(String phone) {
		this.phone = phone;
	}

	String getAddress() {
		return address;
	}

	void setAddress(String address) {
		this.address = address;
	}

	String getJoindate() {
		return joindate;
	}

	void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	String getGrade() {
		return grade;
	}

	void setGrade(String grade) {
		this.grade = grade;
	}

	String getCity() {
		return city;
	}

	void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}



class Money {
	
	int custno;			// 회원번호
	int saleno; 		// 판매번호
	int pcost;			// 단가
	int amount;			// 수량
	int price;			// 가격(매출)
	String pcode;		// 상품코드
	String sdate;		// 판매일자
	 
	public Money() {}
	 
	public Money(int custno, int saleno, int pcost, int amount, int price, String pcode, String sdate) {
		this.custno = custno;
		this.saleno = saleno;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}

	int getCustno() {
		return custno;
	}

	void setCustno(int custno) {
		this.custno = custno;
	}

	int getSaleno() {
		return saleno;
	}

	void setSaleno(int saleno) {
		this.saleno = saleno;
	}

	int getPcost() {
		return pcost;
	}

	void setPcost(int pcost) {
		this.pcost = pcost;
	}

	int getAmount() {
		return amount;
	}

	void setAmount(int amount) {
		this.amount = amount;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

	String getPcode() {
		return pcode;
	}

	void setPcode(String pcode) {
		this.pcode = pcode;
	}

	String getSdate() {
		return sdate;
	}

	void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	
	
	
}



class Manager{
	
	ArrayList<Member> memberList = new ArrayList<Member>();
	ArrayList<Money> moneyList = new ArrayList<Money>();
	
	void init() {
		
		memberList.add(new Member(100001, "김행복", "010-1111-2222", "SK", "20151202", "A", "01"));
		memberList.add(new Member(100002, "이축복", "010-1111-3333", "SK", "20151206", "B", "01"));
		memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SK", "20151001", "B", "30"));
		memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SK", "20151113", "A", "30"));
		memberList.add(new Member(100005, "진평화", "010-1111-6666", "SK", "20151225", "B", "60"));
		memberList.add(new Member(100006, "차공단", "010-1111-7777", "SK", "20151211", "C", "60"));
		
		moneyList.add(new Money(100001, 20160001, 500, 5, 2500, "A001", "20160101"));
		moneyList.add(new Money(100001, 20160002, 1000, 4, 4000, "A002", "20160101"));
		moneyList.add(new Money(100001, 20160003, 500, 3, 1500, "A008", "20160101"));		//김행복
		moneyList.add(new Money(100002, 20160004, 2000, 1, 2000, "A004", "20160102"));
		moneyList.add(new Money(100002, 20160005, 500, 1, 500, "A001", "20160103"));		//이축복
		moneyList.add(new Money(100003, 20160006, 1500, 2, 3000, "A003", "20160103"));		//장믿음
		moneyList.add(new Money(100004, 20160007, 500, 2, 1000, "A001", "20160104"));
		moneyList.add(new Money(100004, 20160008, 300, 1, 300, "A005", "20160104"));
		moneyList.add(new Money(100004, 20160009, 600, 1, 600, "A006", "20160104"));
		moneyList.add(new Money(100004, 20160010, 3000, 1, 3000, "A007", "20160106"));		//최사랑
			
	}
	
	void addPrice() {
		
		ArrayList<String[]> dataList = new ArrayList<String[]>();
		int custCnt = 0;
		
		int totalPrice1 = 0;
		int totalPrice2 = 0;
		int totalPrice3 = 0;
		int totalPrice4 = 0;
		int maxPrice = 0;
		
		String[] data1 = new String[3];
		String[] data2 = new String[3];
		String[] data3 = new String[3];
		String[] data4 = new String[3];
		
		
		
		for (int i = 0; i < moneyList.size(); i++) {
			if(moneyList.get(i).getCustno() == 100001) {
				totalPrice1 += moneyList.get(i).getPrice();
				data1[0] = Integer.toString(moneyList.get(i).getCustno());
				for (int j = 0; j < memberList.size(); j++) {
					if(memberList.get(j).getCustno() == 100001) {
						data1[1] = memberList.get(j).getCustname();
						custCnt++;
					}
				}
				
			}		
			else if(moneyList.get(i).getCustno() == 100002) {
				totalPrice2 += moneyList.get(i).getPrice();
				data2[0] = Integer.toString(moneyList.get(i).getCustno());
				for (int j = 0; j < memberList.size(); j++) {
					if(memberList.get(j).getCustno() == 100002) {
						data2[1] = memberList.get(j).getCustname();
						custCnt++;
					}
				}
			}
			else if(moneyList.get(i).getCustno() == 100003) {
				totalPrice3 += moneyList.get(i).getPrice();
				data3[0] = Integer.toString(moneyList.get(i).getCustno());
				for (int j = 0; j < memberList.size(); j++) {
					if(memberList.get(j).getCustno() == 100003) {
						data3[1] = memberList.get(j).getCustname();
						custCnt++;
					}
				}
			}
			else if(moneyList.get(i).getCustno() == 100004) {
				totalPrice4 += moneyList.get(i).getPrice();
				data4[0] = Integer.toString(moneyList.get(i).getCustno());
				for (int j = 0; j < memberList.size(); j++) {
					if(memberList.get(j).getCustno() == 100004) {
						data4[1] = memberList.get(j).getCustname();
						custCnt++;
					}
				}
			}
		}
		data1[2] = Integer.toString(totalPrice1);
		dataList.add(data1);
		data2[2] = Integer.toString(totalPrice2);
		dataList.add(data2);
		data3[2] = Integer.toString(totalPrice3);
		dataList.add(data3);
		data4[2] = Integer.toString(totalPrice4);
		dataList.add(data4);


		for (int j = 0; j < dataList.size(); j++) {
			//구현해야함.....
		}

		System.out.println(Arrays.toString(data1));
		System.out.println(Arrays.toString(data2));
		System.out.println(Arrays.toString(data3));
		System.out.println(Arrays.toString(data4));
		
	
		
		
	}
	
	
}




public class TestClass {

	public static void main(String[] args) {
		
		Manager mg = new Manager();
		mg.init();
		mg.addPrice();
		
		/*
		   [문제] 아 래와 같이 출력  매출(price) 의 합계 + 내림차순 
		  
			100001	김행복		8000
			--------------------------------
			100004	최사랑		4900
			--------------------------------
			100003	장믿음		3000
			--------------------------------
			100002	이축복		2500
			--------------------------------
		 */


	}

}
