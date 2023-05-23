package presentation;
import java.io.IOException;
import java.util.Scanner;

import controller.CSugangsincheong;
import model.MSugangsincheong;
import valueObject.VUserInfo;

public class PSugangsincheong {
	
	private VUserInfo vUserInfo;
	public String info;
	CSugangsincheong cSugang;
	PGangjwaSelection pGangjwaSelection;
	MSugangsincheong mSugangsincheong;
	
	//constructor
	public PSugangsincheong() throws IOException {
		cSugang = new CSugangsincheong();
	}
	public void sincheong() throws IOException {
		pGangjwaSelection = new PGangjwaSelection();
		//���¸�� �����ֱ�
		this.info = pGangjwaSelection.run();
		String []s = this.info.split(" ");
		if(cSugang.dupliLecture(s[0])) System.out.println("�ߺ��� ������ �����ϼ̽��ϴ�.");
		else {
			if(cSugang.sincheong(this.info)) System.out.println("������û ����");
			else System.out.println("������û ����");
		}
	}
	public void sincheongCancel(String code) throws IOException {
		if(cSugang.sincheongCancel(code)) System.out.println("����öȸ ����");
		else System.out.println("����öȸ ����");
	}
	public String singcheongList() {
		return cSugang.sincheongList();
	}

}
