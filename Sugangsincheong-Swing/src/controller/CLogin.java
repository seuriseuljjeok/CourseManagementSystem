package controller;

import global.Locale;
import model.MAccount;
import valueObject.VAccount;

import java.io.IOException;

public class CLogin {
    private MAccount mAccount;
    private VAccount vAccount;

    public CLogin() throws IOException {mAccount=new MAccount();}

    public String login(String ID, String PW) {
        String retVal= Locale.BLANK;
        if(this.mAccount.checkLogin(ID,PW)==Locale.CORRECT) retVal = Locale.CORRECT;//eAccount에게 해당하는 id를 가져와 달라 요청
        else if (this.mAccount.checkLogin(ID,PW)==Locale.NONE) retVal=Locale.NONE;
        else if (this.mAccount.checkLogin(ID,PW)==Locale.WRONG) retVal=Locale.WRONG;
        return retVal;
    }
    public VAccount read(String ID,String PW) throws IOException {
        if(this.login(ID,PW)==Locale.CORRECT)  vAccount = this.mAccount.getAccount(ID, PW);
        return vAccount;
    }
    public boolean match(String ID){
        if(this.mAccount.isRegistered(ID)) return true;//등록되어있지 않은
        return false;
    }
    public boolean signUp(String info) throws IOException {
        if(this.mAccount.signUp(info)) {
        	System.out.println("CLogin : 계정생성 ");
        	return true;
        }
        return false;
    }
}
