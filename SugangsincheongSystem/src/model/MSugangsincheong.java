package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import global.Locale;
import valueObject.VLecture;

public class MSugangsincheong {
	ArrayList<VLecture> sugangList;
	VLecture vSugang;
	
	public MSugangsincheong(String fileName) throws IOException {
		BufferedReader dataFile = new BufferedReader(new FileReader(fileName+".txt"));
		this.sugangList = new ArrayList<VLecture>();
		while(dataFile.ready()) {
			String data = dataFile.readLine();
			if(!data.equals("")) this.sugangList.add(new VLecture(data));
		}
		dataFile.close();
	}

	public ArrayList<VLecture> getAllSugang(){
		if(this.sugangList.size()==0) System.out.println(Locale.NULL);
		return this.sugangList;
	}

	public String printAllSugangList() {
		String returnList = "";
		if(this.getAllSugang().size()==0) System.out.println(Locale.NULL);
		for(VLecture mMiri : this.getAllSugang()) returnList = returnList + printAllSugang(mMiri)+"\n";

		return returnList;
	}

	private String printAllSugang(VLecture mSugang) {
		String returnData = mSugang.id + " " + mSugang.name + " " + mSugang.professor + " " + mSugang.credit + " "+ mSugang.time;
        return returnData+"\n";
	}
	
	public boolean sincheong(String data) throws IOException {
		boolean retVal = false;
		if(this.sugangList.add(new VLecture(data))) {
			if(saveFile()) retVal = true;
		}
		return retVal;
	}
	
	public boolean sincheongCancel(String id) throws IOException {
		boolean retVal = false;
		for(int i=0; i<this.sugangList.size(); i++) {
			VLecture mSugang = this.sugangList.get(i);
			if(mSugang.checkID(id)) {
				if(this.sugangList.remove(mSugang) && saveFile()) {
					retVal = true; return retVal;
				}
			}
		}return retVal;
	}
	
	public boolean saveFile() throws IOException {
		File file = new File(Locale.DIRECTORY_SINCHEONG+".txt");
		file.delete();
		if(!file.exists()) file.createNewFile();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
		for(VLecture v : this.sugangList) {
			bufferedWriter.write(v.toString());bufferedWriter.newLine();
		}bufferedWriter.close(); return true;
	}
	
	public boolean dupliLecture(String id) {
		boolean retVal = false;
		for(int i=0; i<this.sugangList.size(); i++) {
			VLecture mSugang = this.sugangList.get(i);
			if(mSugang.checkID(id)) {
				retVal = true; 
				return retVal;
			}
		}return retVal;
	}

}
