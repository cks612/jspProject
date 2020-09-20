package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	//gmail를 이용 계정
	//인증 수행을 도와주는 Authenticator를 상속
	//구글 설정 -> 보안 수준이 낮은 앱의 액세스 -> 허용 하므로 특정한 가입 사용자에게 메일전송 구현
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		//실제로 메일을 보내줄 사람의 즉 관리자 메일 및 비밀번호
		return new PasswordAuthentication("이메일주소", "비밀번호");
	}
}
