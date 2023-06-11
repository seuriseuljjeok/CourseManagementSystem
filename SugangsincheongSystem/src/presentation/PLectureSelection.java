package presentation;
import java.io.IOException;
import java.util.Scanner;

import global.Locale;
import model.MData;

public class PLectureSelection {
	public MData vDataRoot, vDataCampus, vDataCollege, vDataDepartment;
	public String info;

	public PLectureSelection() throws IOException{
		vDataRoot = new MData(Locale.DIRECTORY_ROOT);	
	}
	

	public String run() throws IOException { 
		String choice;
		Scanner scn = new Scanner(System.in);
		
		System.out.println();
		System.out.println(Locale.CHOICE_CAMPUS);
		System.out.println(vDataRoot.printAllDataList());
		choice = scn.next();
		String campusFileName = vDataRoot.findFileName(choice);
		
		vDataCampus = new MData(Locale.PATH+campusFileName);
		System.out.println();
		System.out.println(Locale.CHOICE_COLLEGE);
		System.out.println(vDataCampus.printAllDataList());
		choice = scn.next();
		String collegeFileName = vDataCampus.findFileName(choice);
		
		vDataCollege = new MData(Locale.PATH+collegeFileName);
		System.out.println();
		System.out.println(Locale.CHOICE_DEPARTMENT);
		System.out.println(vDataCollege.printAllDataList());
		choice = scn.next();
		String departmentFileName = vDataCollege.findFileName(choice);
	
		vDataDepartment = new MData(Locale.PATH+departmentFileName);
		System.out.println();
		System.out.println(Locale.CHOICE_LECTURE);
		System.out.println(vDataDepartment.printAllDataList());
		choice = scn.next();
		return vDataDepartment.popData(choice);	
	}
		
}
