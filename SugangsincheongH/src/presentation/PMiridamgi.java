package presentation;
import java.io.IOException;

import controller.CMiriDamgi;
import model.MMiridamgi;

public class PMiridamgi {
	public String info;
	PGangjwaSelection pGangjwaSelection;
	CMiriDamgi cMiri;
	MMiridamgi mMiri;
	
	public PMiridamgi() throws IOException {
		cMiri = new CMiriDamgi();
	}

	public void addMiri() throws IOException {
		pGangjwaSelection = new PGangjwaSelection();
		//���¸�� �����ֱ�
		this.info = pGangjwaSelection.run();
		String []s = this.info.split(" ");
		if(cMiri.dupliLecture(s[0])) System.out.println("�ߺ��� ������ �����ϼ̽��ϴ�.");
		else {
			if(cMiri.addMiri(this.info)) System.out.println("�̸���� ����");
			else System.out.println("�̸���� ����");
		}
	}
	
	public void miriCancel(String code) throws IOException {
//		pGangjwaSelection = new PGangjwaSelection();

		if(cMiri.miriCancel(code)) System.out.println("�̸���� ��� ����");
		else System.out.println("�̸���� ��� ����");
	}

	public String miriList() {
		return cMiri.miriList();
	}
}
