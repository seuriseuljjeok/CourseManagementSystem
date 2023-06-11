package presentation;
import java.io.IOException;
import java.util.Scanner;

import controller.CSugangsincheong;
import global.Locale;
import model.MSugangsincheong;
import valueObject.VUserInfo;

public class PSugangsincheongBasket {
	
	private VUserInfo vUserInfo;
	public String info;
	CSugangsincheong cSugang;
	PLectureSelection pGangjwaSelection;
	MSugangsincheong mSugangsincheong;
	
	//constructor
	public PSugangsincheongBasket() throws IOException {
		cSugang = new CSugangsincheong();
	}
	public void sincheong() throws IOException {
		pGangjwaSelection = new PLectureSelection();
		this.info = pGangjwaSelection.run();
		String []s = this.info.split(" ");
		if(cSugang.dupliLecture(s[0])) System.out.println(Locale.DUP_SINCHEONG);
		else {
			if(cSugang.sincheong(this.info)) System.out.println(Locale.SUCCESS_SINCHEONG);
			else System.out.println(Locale.FAIL_SINCHEONG);
		}
	}
	public void sincheongCancel(String code) throws IOException {
		if(cSugang.sincheongCancel(code)) System.out.println(Locale.SUCCESS_CANCEL_SINCHEONG);
		else System.out.println(Locale.FAIL_CANCEL_SINCHEONG);
	}
	public String singcheongList() {
		return cSugang.sincheongList();
	}

}
