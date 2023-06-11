package valueObject;

import java.util.Scanner;

public class VIndex {
//직접적으로 아래의 변수들을 사용하면 안됨 (ex .code)
		//getter, setter를 이용하여 캡슐화해서 사용해야 함.
		private int code;
		private String name;
		private String fileName;
		
		public int getCode() {return code;}
		public void setCode(int code) {this.code = code;}
		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
		public String getFileName() {return fileName;}
		public void setFileName(String fileName) {this.fileName = fileName;}
		
		public void load(Scanner file) {
			this.setCode(file.nextInt());
			this.setName(file.next());
			this.setFileName(file.next());			
		}
		
		public void show() {
			System.out.println(this.getCode() + " " +this.getName());	
		}

}
