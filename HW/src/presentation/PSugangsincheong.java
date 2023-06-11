package presentation;

import java.io.IOException;
import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {
	
	private PLectureSelection pLectureSelection;
	private PLectureBasket pLectureBasket;
	private PMiridamgiBasket pMiridamgiBasket;
	private PSincheongBasket pSincheongBasket;

	public PSugangsincheong() throws IOException {
		this.pLectureSelection = new PLectureSelection();
		this.pLectureBasket = new PLectureBasket();
		this.pMiridamgiBasket = new PMiridamgiBasket();
		this.pSincheongBasket = new PSincheongBasket();
	}
	public void run(VUserInfo vUserInfo, Scanner keyboard) throws IOException {
		VLecture vLecture = null;
		boolean brunning = true;

		while(true) {
			System.out.println("강좌선택 0, 미리담기 1, 수강신청 2, 종료 9");
			String sCode = keyboard.next();
			int iCode = Integer.parseInt(sCode);
			String info = "";
			
			switch(iCode) {
				case 0:
					//과목을 여러 개 선택하도록 하고 싶으면 벡터로 받아오면 
					vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);
					info = vLecture.string();
					break;
				case 1:
					//미리담기 강좌 전
					pMiridamgiBasket.add(info);
					pMiridamgiBasket.miriList();
//					vLecture = null;
				case 2: 
					pSincheongBasket.add(info);
					pSincheongBasket.singcheongList();
					break;
				case 9:
					brunning = false;
					break;
				default:System.exit(0); break;
			}
		
		}
		

	}
}
