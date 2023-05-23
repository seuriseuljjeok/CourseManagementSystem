package presentation;

import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong {
	
	private PLectureSelection pLectureSelection;
	private PLectureBasket pLectureBasket;
	private PMiridamgiBasket pMiridamgiBasket;
	private PSincheongBasket pSincheongBasket;

	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pLectureBasket = new PLectureBasket();
	}
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean brunning = true;

		while(true) {
			System.out.println("강좌선택 0, 미리담기 1, 수강신청 2, 종료 9");
			String sCode = keyboard.next();
			int iCode = Integer.parseInt(sCode);
			
			switch(iCode) {
				case 0:
					//과목을 여러 개 선택하도록 하고 싶으면 벡터로 받아오면 
					vLecture = this.pLectureSelection.selectLecture(vUserInfo, keyboard);

					break;
				case 1:
					//미리담기 강좌 전
					pMiridamgiBasket.add(vLecture);
					pMiridamgiBasket.show();
					vLecture = null;
				case 2: 
					pMiridamgiBasket.add(vLecture);
					pMiridamgiBasket.show();
					break;
				case 9:
					brunning = false;
					break;
				default: break;
			}
		
		}
		

	}
}
