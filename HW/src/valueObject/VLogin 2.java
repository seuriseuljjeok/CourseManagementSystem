package valueObject;

public class VLogin {
	//���ο� ������ id�� pw
	private String id;
	private String pw;

	public void setUserID(String userID) {
		this.id = userID;	//�ܺο��� ���޹��� userID�� ������ id�� ����
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
