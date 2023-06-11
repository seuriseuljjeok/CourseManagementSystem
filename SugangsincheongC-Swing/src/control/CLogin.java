package control;
import model.MAccount;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class CLogin {
	private MAccount mAccount;

	public VUserInfo login(VLogin vLogin) {
		mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.login(vLogin);
		
		return vUserInfo;		
	}

}
