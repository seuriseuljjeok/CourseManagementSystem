package presentation;
import java.io.IOException;
import java.util.Scanner;
import controller.CLogin;
import global.Locale;
import valueObject.VUserInfo;
import valueObject.VLogin;


public class PLogin {

	Scanner scn = new Scanner(System.in); 
	public VUserInfo login() throws IOException {
		int count = 0;
		while(count<3) {
			System.out.println(Locale.WRITE_ID);
			String userID = scn.next();
			System.out.println(Locale.WRITE_PW);
			String userPW = scn.next();
			
			VLogin vLogin = new VLogin();
			vLogin.setUserID(userID);
			vLogin.setUserPW(userPW);


			CLogin cLogin = new CLogin();
			VUserInfo vUserInfo = cLogin.login(vLogin); 
			if(vUserInfo == null) {
				System.out.println(Locale.NO_USERINFO); count++;
			} else { 
				System.out.println();System.out.println();
				System.out.println(Locale.FIRST_WELCOME+vUserInfo.getName() + Locale.SECOND_WELCOME);
				return vUserInfo;
			}
		}if(count==3) {
			System.out.println(Locale.OVER_3TIMES);
			System.exit(0);} 
		return null;
	}
}
