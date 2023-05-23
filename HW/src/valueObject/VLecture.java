package valueObject;

import java.util.Scanner;

public class VLecture {
	//직접적으로 아래의 변수들을 사용하면 안됨 (ex .code)
	//getter, setter를 이용하여 캡슐화해서 사용해야 함.
	private int code;
	private String name;
	private String lecturer;
	private int credit;
	private String time;
	
	public int getCode() {return code;}
	public void setCode(int code) {this.code = code;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getLecturer() {return lecturer;}
	public void setLecturer(String professor) {this.lecturer = professor;}
	public int getCredit() {return credit;}
	public void setCredit(int credit) {this.credit = credit;}
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	
	public void load(Scanner file) {
		this.setCode(file.nextInt());
		this.setName(file.next());
		this.setLecturer(file.next());		
		if(file.hasNext()) {
			this.setCredit(file.nextInt());			
			this.setTime(file.next());	
		}else {
			this.setCredit(0);			
			this.setTime("");	
		}
	}
}
