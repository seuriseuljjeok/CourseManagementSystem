package main;
import java.io.IOException;
import java.util.Scanner;
import presentation.PLogin;
import presentation.PMiridamgi;
import presentation.PSugangsincheong;
import valueObject.VUserInfo;

public class Main {
	PSugangsincheong pSugangsincheong;
	PMiridamgi pMiridamgi;
	
	private void run() throws IOException {
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		if(vUserInfo != null) { //������ �־ �α��� ���� �� ���� ��û ����
			menu(vUserInfo);
		}
	}
	
	private void menu(VUserInfo vUserInfo) throws IOException {
		
		System.out.println("*******������û�ý��ۿ� ���� ���� ȯ���մϴ�.*******");
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. �̸����  | 2. �̸���� ��� | 3. ������û | 4. ����öȸ | 5. �̸���� ��� | 6. ������û ���  | 0. ������");
			int choice = scn.nextInt();
			
			switch(choice) {
				case 1: miriDamgi(vUserInfo); break;
				case 2: miriCancel(); break;
				case 3: sugangSincheong(vUserInfo); break;
				case 4: sugangCancel(vUserInfo); break;
				case 5: miriDamgiList(vUserInfo); break;
				case 6: sugangSincheongList(vUserInfo); break;
				case 0: exitProgram(); break;
			}
		}	
	}

	private void miriCancel() throws IOException {
		System.out.println("*******�̸� ��� ���*******");
		System.out.println("*******���� ���*******");
		pMiridamgi = new PMiridamgi();
		System.out.println(pMiridamgi.miriList());
		Scanner scn = new Scanner(System.in);
		System.out.println("����� ���� �ڵ带 �����ּ���");
		String code = scn.next();
		pMiridamgi.miriCancel(code);
	}

	private void miriDamgi(VUserInfo vUserInfo) throws IOException {
		System.out.println("*******�̸� ���*******");
		System.out.println("*******���� ���*******");
		pMiridamgi = new PMiridamgi();
		pMiridamgi.addMiri();
	}
	
	private void sugangSincheong(VUserInfo vUserInfo) throws IOException {
		System.out.println("*******���� ��û*******");
		System.out.println("*******���� ���*******");
		pSugangsincheong = new PSugangsincheong();
		pSugangsincheong.sincheong();
	}

	private void sugangCancel(VUserInfo vUserInfo) throws IOException {
		System.out.println("*******���� öȸ*******");
		System.out.println("*******������û ���*******");
		pSugangsincheong = new PSugangsincheong();
		System.out.println(pSugangsincheong.singcheongList());
		Scanner scn = new Scanner(System.in);
		System.out.println("����� ���� �ڵ带 �����ּ���");
		String code = scn.next();
		pSugangsincheong.sincheongCancel(code);		

	}

	private void miriDamgiList(VUserInfo vUserInfo) throws IOException {
		System.out.println("*******�̸���� ���*******");
		pMiridamgi = new PMiridamgi();
		System.out.println(pMiridamgi.miriList());
	}
	
	private void sugangSincheongList(VUserInfo vUserInfo) throws IOException {
		System.out.println("*******������û ���*******");
		pSugangsincheong = new PSugangsincheong();
		System.out.println(pSugangsincheong.singcheongList());
	}
	
	private void exitProgram() {
		System.out.println("������û�ý��� ����!!!");
		System.exit(0);
	}


	public static void main(String[] args) {
		//object name declaration
		//memory allocation
		//invoke constructor
		//object name and memory address binding
		Main main = new Main(); //main�̶�� �̸����� ������Ʈ�� �ּҸ� ��ڴٴ� �ǹ�
		try {
			main.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
