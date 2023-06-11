package presentation;
import java.util.Scanner;

import control.CLogin;
import valueObject.VUserInfo;
import valueObject.VLogin;

public class PLogin {
	private CLogin cLogin;
	

	Scanner scn = new Scanner(System.in); 
	public VUserInfo login() {
		
		System.out.println("ID를 입력하세요.");
		String userID = scn.next();
		System.out.println("Password를 입력하세요.");
		String userPW = scn.next();
		
		//vLogin에 ID와 PW 담아주기 
		VLogin vLogin = new VLogin();
		vLogin.setUserID(userID);
		vLogin.setUserPW(userPW);

		
		//vLogin에 담아줬으니 cLogin에 전달해줘야 함 
		cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin); //userID와 userPW를 담은 vLogin를 전달해줌
		if(vUserInfo == null) {
			System.out.println("입력하신 정보와 일치하는 사용자가 존재하지 않습니다.");
		} else { //정보가 있으면 정보를 전달해줘야 함 
			System.out.println(vUserInfo.getName()+"님 안녕하세요.");
		}
		
		
		return vUserInfo;
	}

}
