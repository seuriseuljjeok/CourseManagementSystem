package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import global.Locale;
import valueObject.VLecture;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class MAccount {
    public ArrayList<VUserInfo> accountList;
    
    public MAccount() throws IOException {
        BufferedReader accountFile = new BufferedReader(new FileReader(Locale.ACCOUNT));
        this.accountList = new ArrayList<>();
        while (accountFile.ready()){
            String accountInfo = accountFile.readLine();
            if(!accountInfo.equals("")) this.accountList.add(new VUserInfo(accountInfo));
        }
        accountFile.close();
    }


	public VUserInfo login(VLogin vLogin) {
		VUserInfo vUserInfo = null; 
		Scanner scn;
		try {
			scn = new Scanner(new File(Locale.ACCOUNT));
			while(scn.hasNext()) {
				String line = scn.nextLine(); 
				String[] tokens = line.split(" ");
				if(tokens[0].equals(vLogin.getUserID())) {
					if(tokens[1].equals(vLogin.getUserPW())) {
						vUserInfo = new VUserInfo();
						vUserInfo.setName(tokens[2]);
					}
				}
			}	
			scn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vUserInfo;
	}
	
    public boolean isRegistered(String ID){  //이미 등록되어 있는 학생인지 확인
        for(int i=0; i<this.accountList.size();i++){
            VUserInfo v = this.accountList.get(i);
            if(ID!= Locale.BLANK)  if (v.checkID(ID)) return false; //이미 등록
        } return true;  //등록되지 않은 학생
    }

    public VUserInfo checkLogin(VLogin vLogin){//입력 받은 ID와 PW의 파일 존재 여부 & ID와 PW 일치 확인
    	VUserInfo vUserInfo = null;
        for(VUserInfo v : this.accountList) {
            if (v.matchPW(vLogin.getUserID(),vLogin.getUserPW())){
            	vUserInfo = new VUserInfo(); 
            	vUserInfo.setName(v.getName()); 
            	break; 
            }else vUserInfo = null;
        }
        return vUserInfo;
    }
	
	 public boolean signUp(String info) throws IOException {
	        if(this.accountList.add(new VUserInfo(info)) && this.saveSignUp(this.accountList)) {
	        	return true;
	        }
	        return false;
	    }
	 
    public boolean saveSignUp(ArrayList<VUserInfo> accountList) throws IOException {
        File file = new File(Locale.ACCOUNT);
		file.delete();
		if(!file.exists()) file.createNewFile();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
		for(VUserInfo v : this.accountList) {
			bufferedWriter.write(v.getString());
			bufferedWriter.newLine();
		}bufferedWriter.close(); 
		return true;
    }

}
