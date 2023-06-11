package presentation;

import global.Constants;
import global.Locale;
import valueObject.VAccount;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//헤더 부분의 학생 이름, 환영 문구, 로그인 시간 정보 
public class PAccountPanel extends JPanel { //JPanel 확장해서 사용할 것
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    //public PAccountPanel(String name){  //name을 받아와야 함
    public PAccountPanel(VAccount vAccount){  //name을 받아와야 함
        JLabel lName = new JLabel(vAccount.getName());
        this.add(lName); //자식 등록

        JLabel lGreeting = new JLabel(Locale.LAccountPanel.WELCOME);
        this.add(lGreeting); //자식 등록

        JLabel lLogin = new JLabel(Locale.LAccountPanel.LOGIN_TIME_IS);
        this.add(lLogin); //자식 등록

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Locale.TIME_FORMAT);
        JLabel lTime = new JLabel(simpleDateFormat.format(new Date()));
        this.add(lTime); //자식 등록

        JLabel lDescription = new JLabel(Locale.LAccountPanel.TIME);
        this.add(lDescription); //자식 등록
    }
}
