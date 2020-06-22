package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass04 {
	public static void main(String[] args) {
		/* 
		 * 		2번 회원의 이름을 김청하 로 수정하고자 한다.
		 */
		//DB 연결객체를 담을 지역변수 만들기
		Connection conn=null;
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 의 정보 @아이피주소:port번호:db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String id="scott";
			String pw="tiger";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, id, pw);
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int num=2;
		String name="김청하";
		
		PreparedStatement pstmt=null;
		try {
			String sql="UPDATE member"
					+ " SET name=?"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2,  num);
			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정 했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
