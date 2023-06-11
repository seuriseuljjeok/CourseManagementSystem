package main;
import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;
import java.util.Scanner;

import javax.swing.JFrame;

//JFrame 상속 
public class PMain extends JFrame{
	private PLogin pLogin;
	private Scanner keyboard;
	private PSugangsincheong pSugangsincheong;
	
	//constructor : new를 할 때 만들어지면서 초기화됨.
	public PMain() {
		this.setSize(400,600);
		pSugangsincheong = new PSugangsincheong(); 
		this.add(pSugangsincheong);
	}

	private void run() {
		pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		keyboard = new Scanner(System.in);
		if(vUserInfo != null) { //정보가 있어서 로그인 성공 시 수강신청 시작 
			pSugangsincheong = new PSugangsincheong(); 
			//pSugangsincheong.selectLecture(vUserInfo, keyboard);
			pSugangsincheong.run(vUserInfo, keyboard);//수강신청화면에 로그인 정보전달 
		}
	}
	
	public static void main(String[] args) {
		//object name declaration
		//memory allocation
		//invoke constructor
		//object name and memory address binding
		PMain mainFrame = new PMain(); //main이라는 이름으로 오브젝트의 주소를 담겠다.
		mainFrame.setVisible(true);
		
		mainFrame.run();

	}


}
