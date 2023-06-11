package valueObject;

import java.util.StringTokenizer;

public class VUserInfo {
	public String name;
	public String id;
	public String pw;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public boolean checkID(String id) {
		return this.id.equals(id);
	}
    public boolean matchPW(String ID, String PW){
        if(checkID(ID))
            if(this.pw.equals(PW)) return true;
        return false;
    }
	public VUserInfo() {}
	
    public VUserInfo(String input){
        StringTokenizer st = new StringTokenizer(input);
        this.id = st.nextToken();
        this.pw = st.nextToken();
        this.name = st.nextToken();
    }
    public String getString() {
        String returnString = this.id + "  " + this.pw + "  " +this.name;
        return returnString+"\n";
    }
    
}
