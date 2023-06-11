package control;

import java.io.IOException;

import model.MSugangsincheong;

public class CSugangsincheongBasket {

	MSugangsincheong mSugang;
	public CSugangsincheongBasket() throws IOException{
		mSugang = new MSugangsincheong("data/sincheong");
	}
	
	public boolean sincheong(String info) throws IOException {
		if(mSugang.sincheong(info)) return true;
		else return false;
	}

	public boolean sincheongCancel(String code) throws IOException {
		if(mSugang.sincheongCancel(code)) return true;
		else return false;
	}
	
	public String sincheongList() {
		return mSugang.printAllSugangList();
	}

	public boolean dupliLecture(String id) {
		if(mSugang.dupliLecture(id)) return true;
		else return false;
	}

}
