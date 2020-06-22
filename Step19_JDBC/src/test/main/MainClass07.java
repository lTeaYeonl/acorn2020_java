package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 		member 테이블에 저장된 모든 회원의 정보를
		 * 		번호에 대해서 오름차순 정렬해서
		 * 		List<MemberDto> 객체에 담아 오려고 한다.
		 */
		
		// 회원 목록을 담을 객체 생성
		List<MemberDto> list=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Statement stmt=null;
		try {
			// DBConnect 객체를 이용해서 Connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			// 실행 할 sql 문
			String sql="SELECT *"
					+ " FROM member"
					+ " ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			// query 문 수행하고 결과 얻어오기
			rs=pstmt.executeQuery();
			// ResultSet 객체의 Row 개수 계산
			// 커서의 위치를 제일 뒤로 이동한 뒤 row의 개수를 계산
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs2=stmt.executeQuery("SELECT num FROM member");
			rs2.last(); // 커서의 위치를 제일 뒤로 이동
			int rowCount=rs2.getRow(); // 현재 커서의 Row Index 값을 저장
			// 반복문 돌면서 select 된 회원정보 읽어오기
			while(rs.next()) {
				// 회원정보를 list에 담아 보세요.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				// MemberDto 객체를 생성해서 회원 한명의 정보를 담는다.
				MemberDto dto=new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				// MemberDto 객체를 List 에 누적 시킨다.
				list.add(dto);
				int size=list.size(); // 리스트의 값을 담는 지역변수
				System.out.println(dto.getNum()+" | "+dto.getName()+" | "+dto.getAddr());
				if(size==rowCount) { // list에 담은 값과 member 테이블의 row 수가 같으면 탈출
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}