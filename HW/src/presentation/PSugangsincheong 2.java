package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {
	private PLectureSelection pLectureSelection;
	
	public PSugangsincheong(){
		this.pLectureSelection = new PLectureSelection();
	}

	public void run(VUserInfo vUserInfo, Scanner keyboard) { 
		//과목을 여러 개 선택하도록 하 싶으면 벡터로 받아오면 
		VLecture vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
	}
}
