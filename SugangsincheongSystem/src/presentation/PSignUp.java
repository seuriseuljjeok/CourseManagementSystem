package presentation;

import java.io.IOException;
import java.util.Scanner;

import controller.CLogin;
import global.Locale;
import model.MAccount;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PSignUp {
	Scanner scn = new Scanner(System.in); 
	private MAccount mAccount;
	public boolean signUp() throws IOException {
		System.out.println(Locale.WRITE_ID);
		String userID = scn.next();
		System.out.println(Locale.WRITE_PW);
		String userPW = scn.next();
		System.out.println(Locale.WRITE_NAME);
		String userName = scn.next();
		
		String info = userID + " " + userPW + " " + userName + " ";
		
		mAccount = new MAccount();
		if(mAccount.signUp(info)) return true;
		else return false;
	}
}
