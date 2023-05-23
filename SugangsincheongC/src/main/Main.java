package main;
import presentation.PLogin;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;
import java.util.Scanner;


public class Main {
	//constructor : new�� �� �� ��������鼭 �ʱ�ȭ��.
	public Main() {		
	}


	private void run() {
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		Scanner keyboard = new Scanner(System.in);
		if(vUserInfo != null) { //������ �־ �α��� ���� �� ���� ��û ����
			PSugangsincheong pSugangsincheong = new PSugangsincheong(); //����ģûȭ�鿡 �α��� ���� ����
			//pSugangsincheong.selectLecture(vUserInfo, keyboard);
			pSugangsincheong.run(vUserInfo, keyboard);
		}
	}
	
	public static void main(String[] args) {
		//object name declaration
		//memory allocation
		//invoke constructor
		//object name and memory address binding
		Main main = new Main(); //main�̶�� �̸����� ������Ʈ�� �ּҸ� ��ڴٴ� �ǹ�
		main.run();
	}


}
