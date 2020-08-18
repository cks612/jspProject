package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import user.Util;
import user.UserDTO;

public class UserDAO {
	
	private final String JDBC_Driver = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "jspProject";
	private final String PASS = "1111";
	
	public UserDAO(){
		try {
			Class.forName(JDBC_Driver);
		}
		catch(Exception e) {
			System.out.println("ERRPR : JDBC ����̹� �ε� ����");
		}
	}
	
	//ID �ߺ�Ȯ��
		public boolean checkId(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			
			boolean flag = false;
			
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				sql = "select id from MEMBER where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				flag = pstmt.executeQuery().next();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Util.close(con, pstmt);
			}
			return flag;
		}
		
		
		//�α���
		public boolean loginUser(String id, String pwd) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			boolean flag = false;
			
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				sql = "select id from MEMBER where id = ? and pwd = ?";
				pstmt = con.prepareStatement(sql); //sql���� �� �� �ְ� �غ�
				pstmt.setString(1, id);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();	//db���� ����� ���� rs�� ����ش�
				flag = rs.next();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Util.close(con, pstmt, rs);
			}
			return flag;
		}
		
		//���̵� ã��
		public String findId(String name, String tel, String email) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String id = null;
			String sql = null;
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				sql = "select id from MEMBER where name = ? and tel = ? and email = ?";
				pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, name);
				pstmt.setString(2, tel);
				pstmt.setString(3, email);
				rs = pstmt.executeQuery();	
				 while(rs.next()){
					    id = rs.getString("id");
					   }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Util.close(con, pstmt, rs);
			}
			return id;
		}
		
		//��й�ȣ ã��
		public String findPwd(String id, String name, String email, String tel) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String pwd = null;
			String sql = null;
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				sql = "select pwd from MEMBER where id = ? and name = ? and email = ? and tel = ?";
				pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, email);
				pstmt.setString(4, tel);
				
				rs = pstmt.executeQuery();	
				 while(rs.next()){
					    pwd = rs.getString("pwd");
					   }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Util.close(con, pstmt, rs);
			}
			return pwd;
		}
		
		//ȸ������
		public boolean join(UserDTO user){
			Connection con = null;
			PreparedStatement pstmt = null;
			boolean flag = false;
			
			
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				String strQuery = "insert into MEMBER(id,pwd,name,email,agency,tel,birthdate,gender,zipcode,address,userEmailHash) values(?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(strQuery);
				
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPwd());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getAgency());
				pstmt.setString(6, user.getTel());
				pstmt.setString(7, user.getBirthdate());
				pstmt.setString(8, user.getGender());
				pstmt.setString(9, user.getZipcode());
				pstmt.setString(10, user.getAddress());
				pstmt.setString(11, user.getUserEmailHash());

				if(pstmt.executeUpdate()==1) {
					flag = true;
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
				
					Util.close(con, pstmt);
			}
			
			return flag;
		}
		//Ư��ȸ���� �̸��� ��ü�� ��ȯ�ϴ� �Լ�
		public String getUserEmail(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				sql = "select email from MEMBER where id=?";
				pstmt = con.prepareStatement(sql); //sql���� �� �� �ְ� �غ�
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();	//db���� ����� ���� rs�� ����ش�
				
				if(rs.next()) {
					return rs.getString(1);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Util.close(con, pstmt, rs);
			}
			return null; //�����ͺ��̽� ����
		}

		//�̸��� ������ �Ǿ����� Ȯ��
		public boolean getUserEmailChecked(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				sql = "select userEmailChecked from MEMBER where id=?";
				pstmt = con.prepareStatement(sql); //sql���� �� �� �ְ� �غ�
				pstmt.setString(1, id);

				rs = pstmt.executeQuery();	//db���� ����� ���� rs�� ����ش�
				if(rs.next()) {
					return rs.getBoolean(1);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Util.close(con, pstmt, rs);
			}
			return false; //�����ͺ��̽� ����
		}
		
		//�̸��� �Ϸ��Ű�� �Լ�
		public boolean setUserEmailChecked(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			
			try {
				con = DriverManager.getConnection(JDBC_URL,USER,PASS);
				sql = "update MEMBER set userEmailChecked = true where id=?";
				pstmt = con.prepareStatement(sql); //sql���� �� �� �ְ� �غ�
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();	//db���� ����� ���� rs�� ����ش�
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				Util.close(con, pstmt, rs);
			}
			return false; //�����ͺ��̽� ����
		}
}
