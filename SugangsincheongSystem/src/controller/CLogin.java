package controller;
import java.io.IOException;

import model.MAccount;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class CLogin {
	public VUserInfo login(VLogin vLogin) throws IOException {
		MAccount mAccount = new MAccount();
		VUserInfo vUserInfo = mAccount.checkLogin(vLogin);
		return vUserInfo;		
	}
}
