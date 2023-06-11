package presentation;

import java.io.IOException;
import java.util.Vector;

import control.CMiridamgiBasket;
import valueObject.VLecture;

public class PMiridamgiBasket {
	private Vector<VLecture> vLectureVector;
	private CMiridamgiBasket cMiridamgiBasket;
	
	public PMiridamgiBasket(){
		this.vLectureVector = new Vector<VLecture>();
	}
	public void add(String info) throws IOException {

		String []s = info.split(" ");
		if(cMiridamgiBasket.dupliLecture(s[0])) System.out.println("이미 미리담기 바구니에 있는 강좌입니다.");
		else {
			if(cMiridamgiBasket.addMiri(info)) System.out.println(s[1]+" 강좌 미리담기 성공");
			else System.out.println("미리담기 실패");
		}
	}
	public void show() {
		for(VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
	}
	public void miriList() {
		System.out.println(cMiridamgiBasket.miriList()); 
	}
}
