package valueObject;

import java.util.StringTokenizer;


public class VData {
	public String id;
	public String name;
	public String fileName;


	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getFileName() {return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;}
	
	public VData(String data) {
		StringTokenizer stringTokenizer = new StringTokenizer(data);
		this.id = stringTokenizer.nextToken();
		this.name = stringTokenizer.nextToken();
		this.fileName = stringTokenizer.nextToken();
	}
	
	public boolean match(String id) {return this.id.equals(id);}
	
	public String findFileName(String code) {return this.fileName;}
	
	public String toString() {
		String returnString = this.id + " " + this.name + " " + this.fileName;
		return returnString + "\n";
	}
	public boolean checkID(String id) {
		return this.id.equals(id);
	}

}
