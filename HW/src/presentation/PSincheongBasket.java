package presentation;

import java.io.IOException;
import java.util.Vector;

import control.CSugangsincheongBasket;
import model.MSugangsincheong;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSincheongBasket {
	private Vector<VLecture> vLectureVector;
	CSugangsincheongBasket cSugangsincheongBasket;
	MSugangsincheong mSugangsincheong;
	
	public PSincheongBasket() throws IOException{
		this.vLectureVector = new Vector<VLecture>();
		cSugangsincheongBasket = new CSugangsincheongBasket();
	}
	public void add(String info) throws IOException {
//		this.vLectureVector.add(vLecture);
		String []s = info.split(" ");
		if(cSugangsincheongBasket.dupliLecture(s[0])) System.out.println("이미 수강신청한 강좌입니다.");
		else {
			if(cSugangsincheongBasket.sincheong(info)) System.out.println(s[1]+"강좌 수강신청 성공");
			else System.out.println("수강신청 실패");
		}
	}
	public void show() {
		for(VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
	}

	public void sincheongCancel(String code) throws IOException {
		if(cSugangsincheongBasket.sincheongCancel(code)) System.out.println("수강철회 성공");
		else System.out.println("수강철회 실패");
	}
	public void singcheongList() {
		System.out.println(cSugangsincheongBasket.sincheongList());
	}
}
