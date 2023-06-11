package valueObject;

import java.util.Scanner;
import java.util.StringTokenizer;

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
		
//		public VIndex(String data) {
//			StringTokenizer stringTokenizer = new StringTokenizer(data);
//			this.id = stringTokenizer.nextToken();
//			this.name = stringTokenizer.nextToken();
//			this.fileName = stringTokenizer.nextToken();
//		}
		
		public void show() {
			System.out.println(this.getCode() + " " +this.getName());	
		}

		
//		public boolean match(String id) {return this.id.equals(id);}
//		
		public String findFileName(String code) {return this.fileName;}
		
		public String toString() {
			String returnString = this.id + " " + this.name + " " + this.fileName;
			return returnString + "\n";
		}
//		public boolean checkID(String id) {
//			return this.id.equals(id);
//		}
}
