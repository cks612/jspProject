package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	//gmail�� �̿� ����
	//���� ������ �����ִ� Authenticator�� ���
	//���� ���� -> ���� ������ ���� ���� �׼��� -> ��� �ϹǷ� Ư���� ���� ����ڿ��� �������� ����
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		//������ ������ ������ ����� �� ������ ���� �� ��й�ȣ
		return new PasswordAuthentication("kyusung612@gmail.com","Ksc8331028");
	}
}
