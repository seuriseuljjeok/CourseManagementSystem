package presentation;

import java.awt.Color;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import control.CIndex;
import control.CLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection extends JPanel{
	private CLecture cLecture;
		
	private class PSelection extends JTable{
		private CIndex cIndex;

		public PSelection(String titleName, String fileName) {
			String[] title = new String[1];			
			title[0] = titleName;
			DefaultTableModel tableModel = new DefaultTableModel(title,0);
			this.setModel(tableModel);
			
			RowSelectionListener rowSelectionListener = new RowSelectionListener();
			this.getSelectionModel().addListSelectionListener(rowSelectionListener);;

			
			this.cIndex = new CIndex();
			Vector<VIndex> vIndexVector = cIndex.getVIndexVector(fileName);
			for(VIndex vIndex: vIndexVector) {
				String[] row = new String[1];
				row[0] = vIndex.getName();
				tableModel.addRow(row);
			}
		}
	}
	
	private class RowSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				int firstIndex = e.getFirstIndex();
				System.out.println("first-"+firstIndex);
				int lastIndex = e.getLastIndex();
				System.out.println("last-"+lastIndex);

			}
		}
		
	}
	
	
	public PLectureSelection(){
		PSelection PCampus = new PSelection("캠퍼스", "root");
		JScrollPane scrollPane1 = new JScrollPane(PCampus);
		this.add(scrollPane1);
		
		PSelection PCollege = new PSelection("대학", "root");
		JScrollPane scrollPane2 = new JScrollPane(PCollege);
		this.add(scrollPane2);
		
		PSelection PDepartment = new PSelection("학과", "root");
		JScrollPane scrollPane3 = new JScrollPane(PDepartment);
		this.add(scrollPane3);
		
		this.cLecture = new CLecture();
	}

	private String findIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message+"코드를 선택하세요.");

		//CIndex에게 indexVector를 가져와서 화면에 뿌려주라 해야 함.
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		//iCode를 selectedIndex로 바꿔줘야 함 
		String selectedFileName = null;
		return selectedFileName;
	}
	
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		System.out.println(message+"코드를 선택하세요.");

		Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
		for(VLecture vLecture: vLectureVector) {
			vLecture.show();
		}
		//CIndex에게 indexVector를 가져와서 화면에 뿌려주라 해야 함.
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		//iCode를 selectedIndex로 바꿔줘야 함 
		VLecture vLecture = this.convertLecture(vLectureVector, iCode);
		
		return vLecture;
	}
	
	private String convertIndex(Vector<VIndex> vIndexVector, int iCode) {
		for(int i=0; i<vIndexVector.size(); i++) {
			if(iCode == vIndexVector.get(i).getCode()) return vIndexVector.get(i).getFileName();
		}return null;
	}
	
	private VLecture convertLecture (Vector<VLecture> vLectureVector, int iCode) {
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
