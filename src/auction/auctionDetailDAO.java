package auction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import user.Util;

public class auctionDetailDAO {

	private static auctionDetailDAO instance = new auctionDetailDAO();

	public static auctionDetailDAO getInstance() {
		return instance;
	}

	private final String JDBC_Driver = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "jspProject";
	private final String PASS = "1111";

	public auctionDetailDAO() {
		try {
			Class.forName(JDBC_Driver);
		} catch (Exception e) {
			System.out.println("ERRPR : JDBC 드라이버 로딩 실패");
		}
	}

	public boolean insertArticle(auctionDetailDTO article) throws Exception {
		
		Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		boolean flag = false;
		int number = 0;

		try {
			pstmt = conn.prepareStatement("select betNum.nextval from dual");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1) + 1;
			} else {
				number = 1;
			}
			sql = "insert into auctionDetail(BETCODE,auctioncode,id,betdate,betprice)";
			sql += " values(?, ?, ?, sysdate , ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setInt(2, article.getAuctionCode());
			pstmt.setString(3, article.getId());
			pstmt.setInt(4, article.getBetPrice());
			pstmt.executeUpdate();
			if (pstmt.executeUpdate() == 1) {
				flag = true;
			}
		} catch (SQLIntegrityConstraintViolationException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}

		return flag;
	}

	public int getbetCnt(int auctioncode, String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int count = 0;
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			pstmt = conn.prepareStatement("select count(*) from auctiondetail where auctioncode = ? and id = ?");
			pstmt.setInt(1, auctioncode);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				count = rs.getInt(1);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);

		}

		return count;
	}

	public int setBetState(int auctioncode) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int minBetcode = 0;
		conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
		try {
			pstmt = conn.prepareStatement(
					"select min(betcode) from auctiondetail where betprice = (select max(betprice) from auctiondetail where auctioncode = ? )");
			pstmt.setInt(1, auctioncode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				minBetcode = rs.getInt(1);
			}

			sql = "update auctiondetail set betState = ? where betcode = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, minBetcode);
			rs = pstmt.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);

		}
		return auctioncode;
	}

	public int getBetPrice(int auctioncode) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int betPrice = 0;
		conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
		try {
			pstmt = conn.prepareStatement("select betprice from auctiondetail where betstate = 1 and auctioncode = ? ");
			pstmt.setInt(1, auctioncode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				betPrice = rs.getInt(1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);

		}
		return betPrice;
	}

	public String getWinnerId(int auctioncode) throws Exception {
		System.out.println("위너 나왓니");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		String winnerId = null;
		conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
		try {
			pstmt = conn.prepareStatement("select id from auctiondetail where betstate = 1 and auctioncode = ? ");
			pstmt.setInt(1, auctioncode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				winnerId = rs.getString(1);
			
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);

		}
		return winnerId;

	}

	public static void main(String[] args) {

	}

}
