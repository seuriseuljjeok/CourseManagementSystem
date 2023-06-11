package global;

public class Locale {

    public final static String BLANK = "";
    public final static String ACCOUNT = "account/Account.txt";
    public final static String PATH = "data/";
    public final static String DIRECTORY_ROOT = "data/root";
    public final static String DIRECTORY_CAMPUS = "campus/";
    public final static String DIRECTORY_COLLEGE = "college/";
    public final static String DIRECTORY_DEPARTMENT = "department/";
    public final static String DIRECTORY_MIRIDAMGI = "data/miridamgi.txt";
    public final static String DIRECTORY_SINCHEONG = "data/sincheong";
    public final static String NULL = "DATA IS NULL";

    
    //PLectureSelection
    public final static String CHOICE_CAMPUS = "캠퍼스 선택";
    public final static String CHOICE_COLLEGE = "대학 선택";
    public final static String CHOICE_DEPARTMENT = "학부 선택";
    public final static String CHOICE_LECTURE = "강좌 선택";

    //PLogin
    public final static String WRITE_ID = "아이디를 입력해주세요.";
    public final static String WRITE_PW = "비밀번호를 입력해주세요.";
    public final static String NO_USERINFO = "사용자 정보가 없습니다.";
    public final static String OVER_3TIMES = "3회 이상 로그인에 실패하셨습니다. 시스템 종료";
    public final static String FIRST_WELCOME = "**********";
    public final static String SECOND_WELCOME = "님 어서오세요.**********";
    
    //PSignUp
    public final static String WRITE_NAME = "이름을 입력해주세요.";

    
    //Main
    public final static String USER_PAGE = "*******회원관리 페이지입니다.*******";
    public final static String SUCCESS_SIGNUP = "회원등록에 성공하셨습니다.";
    public final static String FAIL_SIGNUP = "회원등록에 실패하셨습니다.";
    public final static String USER_MENU = "1.로그인 | 2. 회원가입";
    public final static String WELCOME_MESSAGE = "*******수강신청 시스템에 오신 것 환영합니다.*******";
    public final static String MENU = "1. 미리담기  | 2. 미리담기 취소 | 3. 수강신청 | 4. 수강철회 | 5. 미리담기 바구니 | 6. 수강신청 바구니  | 0. 시스템 종료";
    public final static String MIRIDAMGI_CANCEL = "******미리담기 취소*******";
    public final static String MIRIDAMGI_BASKET = "******미리담기 바구니*******";
    public final static String MIRIDAMGI_CHOICE = "미리담기 취소할 강좌 코드를 선택하세요";
    public final static String MIRIDAMGI_TYPE = "1. 미리담기 바구니 | 2. 강좌검색";
    public final static String SINCHEONG_TYPE = "1. 수강신청 바구니 | 2. 강좌검색";
    public final static String MIRIDAMGI = "*******미리담기*******";
    public final static String SUGANGSINCHEONG = "*******수강신청*******";
    public final static String SUGANGSINCHEONG_CANCEL = "*******수강신청 취소*******";
    public final static String SUGANGSINCHEONG_CHOICE = "수강신청 취소할 강좌 코드를 선택하세요";
    public final static String SUGANGSINCHEONG_BASKET = "*******수강신청 바구니*******";
    public final static String EXIT_TITLE = "프로그램 종료";
    
    
    //PMiridamgiBasket
    public final static String DUP_MIRIDAMGI= "이미 미리담기한 강좌입니다.";
    public final static String SUCCESS_MIRIDAMGI= "미리담기 성공";
    public final static String FAIL_MIRIDAMGI= "미리담기 실패";
    public final static String SUCCESS_CANCEL_MIRIDAMGI= "미리담기 철회 성공";
    public final static String FAIL_CANCEL_MIRIDAMGI= "미리담기 철회 실패";
    
    
    //PSugangsincheongBasket
    public final static String DUP_SINCHEONG= "이미 수강신청한 강좌입니다.";
    public final static String SUCCESS_SINCHEONG= "수강신청 성공";
    public final static String FAIL_SINCHEONG= "수강신청 실패";
    public final static String SUCCESS_CANCEL_SINCHEONG= "수강신청 철회 성공";
    public final static String FAIL_CANCEL_SINCHEONG= "수강신청 철회 실패";
    
    //PAccountPanel
    public final static class LAccountPanel{
        public final static String INSA_POSTFIX = "님 안녕하세요! ";//값을 한 번 할당하고 나면 바뀌지 않는 다는 것 : final
        public final static String LOGIN_TIME_PREFIX = "로그인 시간은 ";
        public final static String IPNIDA = "입니다. ";
    }

}
