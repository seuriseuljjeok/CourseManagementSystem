package presentation;
import java.util.Scanner;
import controller.CLogin;
import valueObject.VUserInfo;
import valueObject.VLogin;


public class PLogin {

	Scanner scn = new Scanner(System.in); //scanner�� ��ȯ���ִ� ��. �׷� ��ĳ�ʸ� Ű����� ���� => System.in(Ű����)

	public VUserInfo login() {
		int count = 0;
		while(count<3) {
			System.out.println("����� ���̵� �Է��ϼ���.");
			String userID = scn.next();
			System.out.println("����� ��й�ȣ�� �Է��ϼ���.");
			String userPW = scn.next();
			
			//vLogin�� ID�� PW ����ֱ�
			VLogin vLogin = new VLogin();
			vLogin.setUserID(userID);
			vLogin.setUserPW(userPW);

			//vLogin�� ��������� cLogin�� �����������
			CLogin cLogin = new CLogin();
			VUserInfo vUserInfo = cLogin.login(vLogin); //userID�� userPW�� ���� vLogin�� ��������
			if(vUserInfo == null) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�."); count++;
			} else { //������ ������ ������ ��������� ��.
				System.out.println();System.out.println();
				System.out.println("**********"+vUserInfo.getName() + "�� �ȳ��ϼ���.**********");
				return vUserInfo;
			}
		}if(count==3) {
			System.out.println("3ȸ �̻� �α��� �����ϼ����Ƿ� �ý����� ����˴ϴ�.");
			System.exit(0);} 
		return null;
	}
}
