package valueObject;
import java.util.StringTokenizer;

public class VLecture {
	public String id;
	public String name;
	public String professor;
	public String credit;
	public String time;
	
	public VLecture(String fileName) {
		StringTokenizer stringTokenizer = new StringTokenizer(fileName);
		this.id = stringTokenizer.nextToken();
		this.name = stringTokenizer.nextToken();
		this.professor = stringTokenizer.nextToken();
		if(stringTokenizer.hasMoreTokens()) {
            this.credit = stringTokenizer.nextToken();
            this.time = stringTokenizer.nextToken();
        }else {
        	this.credit = " ";
            this.time = " ";
        }
	}

    public String getId() {return id;}
    public String getName() {return name;}
    public String getProfessor() {return professor;}
    public String getCredit() {return credit;}
    public String getTime() {return time;}
			
	public String toString() {
		String returnString = this.id + " " + this.name + " " + this.professor + " " + this.credit + " " + this.time;
		return returnString + "\n";
	}
	public boolean checkID(String id) {return this.id.equals(id);}
}
