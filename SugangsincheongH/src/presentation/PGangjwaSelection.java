package presentation;
import java.io.IOException;
import java.util.Scanner;

import model.MData;

public class PGangjwaSelection {
	public MData vDataRoot, vDataCampus, vDataCollege, vDataDepartment;
	public String info;

	public PGangjwaSelection() throws IOException{
		vDataRoot = new MData("data/root");	
	}
	

	public String run() throws IOException { //���¼���(ķ�۽� -> ���� -> �а� -> ���� ..)
		String choice;
		Scanner scn = new Scanner(System.in);
		
		System.out.println();
		System.out.println("ķ�۽� �ڵ带 �����ϼ���");
		System.out.println(vDataRoot.printAllDataList());
		choice = scn.next();
		String campusFileName = vDataRoot.findFileName(choice);
		
		vDataCampus = new MData("data/"+campusFileName);
		System.out.println();
		System.out.println("���� �ڵ带 �����ϼ���");
		System.out.println(vDataCampus.printAllDataList());
		choice = scn.next();
		String collegeFileName = vDataCampus.findFileName(choice);
		
		vDataCollege = new MData("data/"+collegeFileName);
		System.out.println();
		System.out.println("���� �ڵ带 �����ϼ���");
		System.out.println(vDataCollege.printAllDataList());
		choice = scn.next();
		String departmentFileName = vDataCollege.findFileName(choice);
	
		vDataDepartment = new MData("data/"+departmentFileName);
		System.out.println();
		System.out.println("���� �ڵ带 �����ϼ���");
		System.out.println(vDataDepartment.printAllDataList());
		choice = scn.next();
		return vDataDepartment.popData(choice);	
	}
		
}
