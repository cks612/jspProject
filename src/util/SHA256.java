package util;

import java.security.MessageDigest;

public class SHA256 {

	public static String getSHA256(String input) {
		StringBuffer result = new StringBuffer();
		
		try {
			//salt��� ���� �̿��� �������� ��ŷ�� ����
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] salt = "Hello! This is Salt".getBytes();	//�ܼ��ϰ� sha 256�� �����ϸ� ���ȿ� ������ �ǹǷ� salt���� ����
			digest.reset();
			//salt���� ����
			digest.update(salt);
			//�迭������ ����� ���ڵ�
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			//���� �ؽ÷� ������ ���� ĳ���� ������ ����ְ� ���ڿ� ���·� �������
			for(int i=0; i<chars.length; i++) {
				//oxff�ٽ� ���� ���� �ؽð��� ������ ĳ������ �ش� �ε����� &������ ������
				//���������� 0�� ���� ���ڸ��� �����
				String hex = Integer.toHexString(0xff & chars[i]);
				if(hex.length() == 1) {
					result.append('0');
					result.append(hex);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
