package controller;
import java.io.IOException;

import model.MMiridamgi;

public class CMiriDamgi {
	MMiridamgi mMiri;
	public CMiriDamgi() throws IOException{
		mMiri = new MMiridamgi("data/miridamgi");
	}
	
	public boolean addMiri(String info) throws IOException {
		if(mMiri.addMiri(info)) return true;
		else return false;
	}


	public boolean miriCancel(String code) throws IOException {
		if(mMiri.miriCancel(code)) return true;
		else return false;
	}
	
	public String miriList() {
		return mMiri.printAllMiriList();
	}

	public boolean dupliLecture(String id) {
		if(mMiri.dupliLecture(id)) return true;
		else return false;
	}
}
