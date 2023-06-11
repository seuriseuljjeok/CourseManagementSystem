package main;
import java.io.IOException;
import java.util.Scanner;

import global.Locale;
import presentation.PLogin;
import presentation.PSignUp;
import presentation.PMiridamgiBasket;
import presentation.PSugangsincheongBasket;
import valueObject.VUserInfo;

public class Main {
	PSugangsincheongBasket pSugangsincheong;
	PMiridamgiBasket pMiridamgi;
	
	private void run() throws IOException {
		PLogin pLogin = new PLogin();
		VUserInfo vUserInfo = pLogin.login();
		if(vUserInfo != null) { 
			menu(vUserInfo);
		}
	}
	private void signUp() throws IOException {
		PSignUp pSignUp = new PSignUp();
		if(pSignUp.signUp()) System.out.println(Locale.SUCCESS_SIGNUP);
		else System.out.println(Locale.FAIL_SIGNUP);
	}
	
	private void user() throws IOException {
		System.out.println(Locale.USER_PAGE);
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println(Locale.USER_MENU);
			int choice = scn.nextInt();
			
			switch(choice) {
				case 1: run(); break;
				case 2: signUp(); break;
			}
		}	
	}
	
	private void menu(VUserInfo vUserInfo) throws IOException {
		
		System.out.println(Locale.WELCOME_MESSAGE);
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println(Locale.MENU);
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
		System.out.println(Locale.MIRIDAMGI_CANCEL);
		System.out.println(Locale.MIRIDAMGI_BASKET);
		pMiridamgi = new PMiridamgiBasket();
		System.out.println(pMiridamgi.miriList());
		Scanner scn = new Scanner(System.in);
		System.out.println();
		String code = scn.next();
		pMiridamgi.miriCancel(code);
	}

	private void miriDamgi(VUserInfo vUserInfo) throws IOException {
		System.out.println(Locale.MIRIDAMGI);
		pMiridamgi = new PMiridamgiBasket();
		pMiridamgi.addMiri();
	}
	
	private void sugangSincheong(VUserInfo vUserInfo) throws IOException {
		System.out.println(Locale.SUGANGSINCHEONG);
		pSugangsincheong = new PSugangsincheongBasket();
		pSugangsincheong.sincheong();
	}

	private void sugangCancel(VUserInfo vUserInfo) throws IOException {
		System.out.println(Locale.SUGANGSINCHEONG_CANCEL);
		System.out.println(Locale.SUGANGSINCHEONG_BASKET);
		pSugangsincheong = new PSugangsincheongBasket();
		System.out.println(pSugangsincheong.singcheongList());
		Scanner scn = new Scanner(System.in);
		System.out.println(Locale.SUGANGSINCHEONG_CHOICE);
		String code = scn.next();
		pSugangsincheong.sincheongCancel(code);		

	}

	private void miriDamgiList(VUserInfo vUserInfo) throws IOException {
		System.out.println(Locale.MIRIDAMGI_BASKET);
		pMiridamgi = new PMiridamgiBasket();
		System.out.println(pMiridamgi.miriList());
	}
	
	private void sugangSincheongList(VUserInfo vUserInfo) throws IOException {
		System.out.println(Locale.SUGANGSINCHEONG_BASKET);
		pSugangsincheong = new PSugangsincheongBasket();
		System.out.println(pSugangsincheong.singcheongList());
	}
	
	private void exitProgram() {
		System.out.println(Locale.EXIT_TITLE);
		System.exit(0);
	}


	public static void main(String[] args) {
		//object name declaration
		//memory allocation
		//invoke constructor
		//object name and memory address binding
		Main main = new Main(); 
		try {
			main.user();
//			main.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
