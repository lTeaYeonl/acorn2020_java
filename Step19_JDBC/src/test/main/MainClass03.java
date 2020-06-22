package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 		member 테이블에 추가할 회원의 정보
		 * 		김청하, 동대문구
		 * 		회원의 번호는 시퀀스 객체를 이용해서 넣기
		 * 		시퀀스 명 : member_seq.NEXTVAR
		 */
		String name="김지훈";
		String addr="성북구";
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
		// 필요한 객체의 참조값을 담을 빈 지역 변수 미리 만들기
		PreparedStatement pstmt=null;
		try {
			// 실행할 sql문
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES( member_seq.NEXTVAL, ?, ?)";
			//PreaparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ?에 값을 바인딩해서 미완성인 sql 문을 완성 시킨다.
			pstmt.setString(1,  name);
			pstmt.setString(2, addr);
			// 실제로 수행하기
			pstmt.executeUpdate();
			System.out.print("회원 정보를 저장했습니다.");
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {
				// 안전하게 마무리 작업하기
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {
				
			}
		}
	}
}
