package valueObject;

import java.util.Scanner;
import java.util.StringTokenizer;

public class VLecture {
	//직접적으로 아래의 변수들을 사용하면 안됨 (ex .code)
	//getter, setter를 이용하여 캡슐화해서 사용해야 함.
	private String code;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	
	public VLecture(String fileName) {
		StringTokenizer stringTokenizer = new StringTokenizer(fileName);
		this.code = stringTokenizer.nextToken();
		this.name = stringTokenizer.nextToken();
		this.lecturer = stringTokenizer.nextToken();
		if(stringTokenizer.hasMoreTokens()) {
            this.credit = stringTokenizer.nextToken();
            this.time = stringTokenizer.nextToken();
        }else {
        	this.credit = " ";
            this.time = " ";
        }
	}
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getLecturer() {return lecturer;}
	public void setLecturer(String lecturer) {this.lecturer = lecturer;}
	
	public String getCredit() {return credit;}
	public void setCredit(String credit) {this.credit = credit;}
	
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	
//	public void load(Scanner file) {
//		this.setCode(file.nextInt());
//		this.setName(file.next());
//		this.setLecturer(file.next());	
//		if(file.hasNext()) {
//			this.setCredit(file.nextInt());			
//			this.setTime(file.next());	
//		}else {
//			this.setCredit(0);			
//			this.setTime("");	
//		}
//	}
	public boolean checkID(String id) {
		return code.equals(id);
	}
	public void show() {
		System.out.println(this.getCode() + " " +this.getName() + " " +this.getLecturer() + " " +this.getCredit() + " " +this.getTime());	
	}
	public String string() {
		String returnString = this.getCode() + " " +this.getName() + " " +this.getLecturer() + " " +this.getCredit() + " " +this.getTime();
		return returnString + "\n";
	}
}
