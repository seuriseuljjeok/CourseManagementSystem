package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VLogin;
import valueObject.VUserInfo;

//file이나 database 담당 
public class MAccount {

	public VUserInfo login(VLogin vLogin) {
		VUserInfo vUserInfo = null; //결과를 담을그릇 => Account 파일에서 찾은 정보가 결과 
		Scanner scn;

		try {
			scn = new Scanner(new File("account/Account.txt"));

			while(scn.hasNext()) {
				String line = scn.nextLine(); //한 줄씩 읽어들임 
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
