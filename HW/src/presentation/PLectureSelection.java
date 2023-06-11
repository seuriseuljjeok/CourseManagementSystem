package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import model.MLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection {
	private CIndex cIndex;
	private CLecture cLecture;
	private MLecture mLecture;

	
	public PLectureSelection(){
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
	}

	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message+"코드를 선택하세요.");

		Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
		for(VIndex vIndex: vIndexVector) {
			vIndex.show();
		}
		//CIndex에게 indexVector를 가져와서 화면에 뿌려주라 해야 함.
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		//iCode를 selectedIndex로 바꿔줘야 함 
		String selectedFileName = this.convertIndex(vIndexVector, iCode);
		
		return selectedFileName;
	}
	
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		System.out.println(message+"코드를 선택하세요.");

//		Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
		Vector<VLecture> vLectureVector = mLecture.findFileName(fileName);
		for(VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
		//CIndex에게 indexVector를 가져와서 화면에 뿌려주라 해야 함.
		String sCode = keyboard.next();
//		int iCode = Integer.parseInt(sCode);
		//iCode를 selectedIndex로 바꿔줘야 함 
		VLecture vLecture = this.convertLecture(vLectureVector, sCode);
		
		return vLecture;
	}
	
	private String convertIndex(Vector<VIndex> vIndexVector, int iCode) {
		for(int i=0; i<vIndexVector.size(); i++) {
			if(iCode == vIndexVector.get(i).getCode()) return vIndexVector.get(i).getFileName();
		}return null;
	}
	
	private VLecture convertLecture (Vector<VLecture> vLectureVector, String iCode) {
		for(int i=0; i<vLectureVector.size(); i++) {
			if(iCode == vLectureVector.get(i).getCode()) return vLectureVector.get(i);
		}return null;
	}
	
	public VLecture selectLecture(VUserInfo vUserInfo, Scanner keyboard) { 
		String campusFileName = this.findIndex("캠퍼스", "root", keyboard);
		String collegeFileName = this.findIndex("대학", campusFileName, keyboard);
		String departmentFileName = this.findIndex("학부", collegeFileName, keyboard);
		VLecture vLecture = this.findLecture("강좌", departmentFileName, keyboard);
		return vLecture;
	}


}
