package presentation;
import java.io.IOException;

import controller.CMiriDamgi;
import global.Locale;
import model.MMiridamgi;

public class PMiridamgiBasket {
	public String info;
	PLectureSelection pGangjwaSelection;
	CMiriDamgi cMiri;
	MMiridamgi mMiri;
	
	public PMiridamgiBasket() throws IOException {
		cMiri = new CMiriDamgi();
	}

	public void addMiri() throws IOException {
		pGangjwaSelection = new PLectureSelection();
		this.info = pGangjwaSelection.run();
		String []s = this.info.split(" ");
		if(cMiri.dupliLecture(s[0])) System.out.println(Locale.DUP_MIRIDAMGI);
		else {
			if(cMiri.addMiri(this.info)) System.out.println(Locale.SUCCESS_MIRIDAMGI);
			else System.out.println(Locale.FAIL_MIRIDAMGI);
		}
	}
	
	public void miriCancel(String code) throws IOException {
		if(cMiri.miriCancel(code)) System.out.println(Locale.SUCCESS_CANCEL_MIRIDAMGI);
		else System.out.println(Locale.FAIL_CANCEL_MIRIDAMGI);
	}

	public String miriList() {
		return cMiri.miriList();
	}
}
