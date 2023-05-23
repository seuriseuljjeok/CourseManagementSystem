package valueObject;

public class VLogin {
	//���ο� ������ id�� pw
	private String id;
	private String pw;
	
	//�ܺο��� ���޹��� userID�� ������ id�� ����
	public String getUserID() {return this.id;}
	public void setUserID(String userID) {this.id = userID;}

	public String getUserPW() {return this.pw;}
	public void setUserPW(String userPW) {this.pw = userPW;}
}
