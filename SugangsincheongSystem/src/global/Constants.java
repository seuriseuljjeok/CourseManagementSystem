package global;

import java.awt.*;

//상수 클래스
public class Constants {
    public static final long SERIAL_VERSION_UID = 1L; //long이라는 타입이라서 1L이라 하는 것. 롱은 8바이트고 int는 4바이트여서 남는 공간을 채워주기 위해 L을 적어주는 것

    public final static class CMainFrame { //메인프레임에서 쓰는 constants를 정의하는 클래스
        public final static int WIDTH = 1000;
        public final static int HEIGHT = 600;
        public final static int HGAP = 50;
        public final static int VGAP = 50;

    }

    public final static class CLoginDialog { //메인프레임에서 쓰는 constants를 정의하는 클래스
        //로그인 패널
        public final static int LOGIN_ROW = 2;
        public final static int LOGIN_COLUMN = 2;
        public final static int LOGIN_HGAP = 30;
        public final static int LOGIN_VGAP = 10;

        //inner 패널
        public final static int INNER_HGAP = 500;
        public final static int INNER_VGAP = 50;

        //button 패널
        public final static int BUTTON_ROW = 1;
        public final static int BUTTON_COLUMN = 2;
        public final static int BUTTON_HGAP = 50;
        public final static int BUTTON_VGAP = 10;

        //인트로 패널
        public final static String INTRO_LABEL = "명지대학교 수강신청시스템";
    }

    public final static class CSignUPPanel{
        //signup 패널
        public final static int SIGNUP_ROW = 11;
        public final static int SIGNUP_COLUMN = 2;
        public final static int SIGNUP_HGAP = 50;
        public final static int SIGNUP_VGAP = 10;

        //inner 패널
        public final static int INNER_HGAP = 500;
        public final static int INNER_VGAP = 50;

        //상태 라벨
        public final static int STATUS_WIDTH = 80;
        public final static int STATUS_HEIGHT = 30;


        //인트로 패널
        public final static String INTRO_LABEL = "명지대학교 학생 등록";

        //버튼
        public final static String CHECKBT = "중복 확인";
        public final static int CHECKBT_WIDTH = 20;
        public final static int CHECKBT_HEIGHT = 30;
        public final static String SIGNUPBT = "등록";
        public final static String CANCELBT = "취소";
    }
    public final static class CImagePanel{
        public final static int X_POINT = 0;
        public final static int Y_POINT = 0;
    }
}