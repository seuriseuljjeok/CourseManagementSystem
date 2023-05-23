package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import valueObject.VSugangsincheong;

public class MSugangsincheong {
	ArrayList<VSugangsincheong> sugangList;
	VSugangsincheong vSugang;
	
	public MSugangsincheong(String fileName) throws IOException {
		BufferedReader dataFile = new BufferedReader(new FileReader(fileName));
		this.sugangList = new ArrayList<VSugangsincheong>();
		while(dataFile.ready()) {
			String data = dataFile.readLine(); //���پ�
			if(!data.equals("")) this.sugangList.add(new VSugangsincheong(data));
		}
		dataFile.close();
	}

	public ArrayList<VSugangsincheong> getAllSugang(){
		if(this.sugangList.size()==0) System.out.println("DATA IS NULL");
		return this.sugangList;
	}

	public String printAllSugangList() {
		String returnList = "";
		if(this.getAllSugang().size()==0) System.out.println("DATA IS NULL");
		for(VSugangsincheong mMiri : this.getAllSugang()) returnList = returnList + printAllSugang(mMiri)+"\n";

		return returnList;
	}

	private String printAllSugang(VSugangsincheong mSugang) {
		String returnData = mSugang.id + " " + mSugang.name + " " + mSugang.professor + " " + mSugang.credit + " "+ mSugang.time;
        return returnData+"\n";
	}
	
	public boolean sincheong(String data) throws IOException {
		boolean retVal = false;
		if(this.sugangList.add(new VSugangsincheong(data))) {
			if(saveFile()) retVal = true;
		}
		return retVal;
	}
	
	public boolean sincheongCancel(String id) throws IOException {
		boolean retVal = false;
		for(int i=0; i<this.sugangList.size(); i++) {
			VSugangsincheong mSugang = this.sugangList.get(i);
			if(mSugang.checkID(id)) {
				if(this.sugangList.remove(mSugang) && saveFile()) {
					retVal = true; return retVal;
				}
			}
		}return retVal;
	}
	
	public boolean saveFile() throws IOException {
		File file = new File("data/sincheong");
		file.delete();
		if(!file.exists()) file.createNewFile();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
		for(VSugangsincheong v : this.sugangList) {
			bufferedWriter.write(v.toString());bufferedWriter.newLine();
		}bufferedWriter.close(); return true;
	}
	
	public boolean dupliLecture(String id) {
		boolean retVal = false;
		for(int i=0; i<this.sugangList.size(); i++) {
			VSugangsincheong mSugang = this.sugangList.get(i);
			if(mSugang.checkID(id)) {
				retVal = true; 
				return retVal;
			}
		}return retVal;
	}

}
