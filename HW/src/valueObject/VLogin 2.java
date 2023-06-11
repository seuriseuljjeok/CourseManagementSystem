package valueObject;

public class VLogin {
	//내부에 저장할 id와 pw
	private String id;
	private String pw;

	public void setUserID(String userID) {
		this.id = userID;	//외부에서 전달받은 userID를 내부의 id에 저장
	}

	public void setUserPW(String userPW) {
		this.pw = userPW;
	}

	public String getUserID() {
		return this.id;
	}

	public String getUserPW() {
		return this.pw;
	}
}
