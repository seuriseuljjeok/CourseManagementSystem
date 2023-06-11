package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheong extends JPanel{
//	
//	private class MyLayout implements LayoutManager {
//		
//	}
	private PLectureSelection pLectureSelection;
	private PLectureBasket pLectureBasket;
	private PMiridamgiBasket pMiridamgiBasket;
	private PSincheongBasket pSincheongBasket;

	public PSugangsincheong() {
		//initialize attributes
		this.setBackground(Color.white);
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		
		//add child components
		this.pLectureSelection = new PLectureSelection();
		this.pLectureSelection.setBackground(Color.GREEN);
		this.add(this.pLectureSelection);
		
		this.pLectureBasket = new PLectureBasket();
		this.pLectureBasket.setBackground(Color.BLUE);
		this.add(this.pLectureBasket);

		this.pSincheongBasket = new PSincheongBasket();
		this.pSincheongBasket.setBackground(Color.RED);
		this.add(this.pSincheongBasket);

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
