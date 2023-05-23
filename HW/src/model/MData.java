package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import valueObject.VData;

public class MData {
	ArrayList<VData> dataList;
	VData mData;
//	
//	public MData(String fileName) throws IOException {
//		BufferedReader dataFile = new BufferedReader(new FileReader(fileName));
//		this.dataList = new ArrayList<VData>();
//		while(dataFile.ready()) {
//			String data = dataFile.readLine(); //���پ�
//			if(!data.equals("")) this.dataList.add(new VData(data));
//		}
//		//dataFile.close();
//	}

	public String findFileName(String code) {
		for(int i=0; i<this.dataList.size(); i++) {
			VData data = this.dataList.get(i);
			if(data.checkID(code)) return data.findFileName(code);
		}return null;
	}
	public ArrayList<VData> getAllData(){
		if(this.dataList.size()==0) System.out.println("DATA IS NULL");
		return this.dataList;
	}

	public String printAllDataList() {
		String returnList = "";
		if(this.getAllData().size()==0) System.out.println("DATA IS NULL");
		for(VData mData : this.getAllData()) returnList = returnList + printAllData(mData)+"\n";

		return returnList;
	}

	private String printAllData(VData mData) {
		String returnData = mData.id + " " + mData.name + " " + mData.fileName;
        return returnData+"\n";
	}
	
	public String popData(String code) {
		for(int i=0; i<this.dataList.size(); i++) {
			VData data = this.dataList.get(i);
			if(data.checkID(code)) {
				return data.toString();
			}
		}return null;
	}
	
	public boolean addLecture(String data) {
		if(this.dataList.add(new VData(data))) return true;
		else return false;
	}
	
	public boolean deleteLecture(String id) {
		for(int i=0; i<this.dataList.size(); i++) {
			VData data = this.dataList.get(i);
			if(data.checkID(id)) {
				if(this.dataList.remove(data)) return true;
				else return false;
			}
		}return false;
	}
}
