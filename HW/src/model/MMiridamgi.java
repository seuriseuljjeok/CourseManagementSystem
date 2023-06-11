package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import valueObject.VMiriDamgi;

public class MMiridamgi {
	ArrayList<VMiriDamgi> miriList;
	VMiriDamgi vMiridamgi;
	
	public MMiridamgi(String fileName) throws IOException {
		BufferedReader dataFile = new BufferedReader(new FileReader(fileName));
		this.miriList = new ArrayList<VMiriDamgi>();
		while(dataFile.ready()) {
			String data = dataFile.readLine(); //���پ�
			if(!data.equals("")) this.miriList.add(new VMiriDamgi(data));
		}
		dataFile.close();
	}

	public ArrayList<VMiriDamgi> getAllMiri(){
		if(this.miriList.size()==0) System.out.println("DATA IS NULL");
		return this.miriList;
	}

	public String printAllMiriList() {
		String returnList = "";
		if(this.getAllMiri().size()==0) System.out.println("DATA IS NULL");
		for(VMiriDamgi mMiri : this.getAllMiri()) returnList = returnList + printAllMiri(mMiri)+"\n";

		return returnList;
	}

	private String printAllMiri(VMiriDamgi mMiridamgi) {
		String returnData = mMiridamgi.id + " " + mMiridamgi.name + " " + mMiridamgi.professor + " " + mMiridamgi.credit + " "+ mMiridamgi.time;
        return returnData+"\n";
	}
	
//	public String popData(String code) {
//		for(int i=0; i<this.miriList.size(); i++) {
//			VMiriDamgi mMiridamgi = this.miriList.get(i);
//			if(mMiridamgi.checkID(code)) {
//				return mMiridamgi.toString();
//			}
//		}return null;
//	}
	
	public boolean addMiri(String data) throws IOException {
		boolean retVal = false;
		if(this.miriList.add(new VMiriDamgi(data))) {
			if(saveFile()) retVal = true;
		}
		return retVal;
	}
	
	public boolean miriCancel(String id) throws IOException {
		boolean retVal = false;
		for(int i=0; i<this.miriList.size(); i++) {
			VMiriDamgi mMiridamgi = this.miriList.get(i);
			if(mMiridamgi.checkID(id)) {
				if(this.miriList.remove(mMiridamgi) && saveFile()) {
					retVal = true; 
					return retVal;
				}
			}
		}return retVal;
	}
	
	public boolean saveFile() throws IOException {
		File file = new File("data/miridamgi");
		file.delete();
		if(!file.exists()) file.createNewFile();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
		for(VMiriDamgi v : this.miriList) {
			bufferedWriter.write(v.toString());bufferedWriter.newLine();
		}bufferedWriter.close(); return true;
	}

	public boolean dupliLecture(String id) {
		boolean retVal = false;
		for(int i=0; i<this.miriList.size(); i++) {
			VMiriDamgi mMiridamgi = this.miriList.get(i);
			if(mMiridamgi.checkID(id)) {
				
				retVal = true; 
				return retVal;
			}
		}return retVal;
	}

}
