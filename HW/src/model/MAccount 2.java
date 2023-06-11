package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VLogin;
import valueObject.VUserInfo;

//file�̳� database ���
public class MAccount {

	public VUserInfo login(VLogin vLogin) {
		VUserInfo vUserInfo = null; //����� ���� �׸�. => Account ���Ͽ��� ã�� ������ ���
		Scanner scn;

		try {
			scn = new Scanner(new File("account/Account.txt"));

			while(scn.hasNext()) {
				String line = scn.nextLine(); //�� �پ� �о����
				String[] tokens = line.split(" ");
				
				if(tokens[0].equals(vLogin.getUserID())) {
					if(tokens[1].equals(vLogin.getUserPW())) {
						vUserInfo = new VUserInfo();
						vUserInfo.setName(tokens[2]);
						break;
					}
				}
			}	
			scn.close();

		} catch (FileNotFoundException e) {e.printStackTrace();}
		return vUserInfo;
	}
}
