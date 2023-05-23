package presentation;
import java.util.Scanner;

import control.CLogin;
import valueObject.VUserInfo;
import valueObject.VLogin;

public class PLogin {

	Scanner scn = new Scanner(System.in); //scanner�� ��ȯ���ִ� ��. �׷� ��ĳ�ʸ� Ű����� ���� => System.in(Ű����)

	public VUserInfo login() {
		
		System.out.println("ID를 입력하세요.");
		String userID = scn.next();
		System.out.println("Password를 입력하세요.");
		String userPW = scn.next();
		
		//vLogin�� ID�� PW ����ֱ�
		VLogin vLogin = new VLogin();
		vLogin.setUserID(userID);
		vLogin.setUserPW(userPW);

		
		//vLogin�� ��������� cLogin�� �����������
		CLogin cLogin = new CLogin();
		VUserInfo vUserInfo = cLogin.login(vLogin); //userID�� userPW�� ���� vLogin�� ��������
		if(vUserInfo == null) {
			System.out.println("입력하신 정보와 일치하는 사용자가 존재하지 않습니다.");
		} else { //������ ������ ������ ��������� ��.
			System.out.println(vUserInfo.getName()+"님 안녕하세요.");
		}
		
		
		return vUserInfo;
	}

}
