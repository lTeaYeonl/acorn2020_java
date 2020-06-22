package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 * 		DAO (Data Access Object) 의 약자
 * 
 * 		- 만드는 방법
 * 
 * 		1. 외부에서 객체 생성하지 못하도록 생성자의 접근 지정자를 private 로 지정
 * 		2. 자신의 참조값을 저장할 수 있는 필드를 private 로 선언
 * 		3. 자신의 참조값을 오직 하나만 생성해서 리턴해주는 static 메소드 만들기
 * 		4. 나머지 기능(select, insert, update, delete)들은 non static 으로 만들기
 */
public class MemberDao {
	// 자신의 참조값을 저장할 private 필드
	private static MemberDao dao;
	
	// 외부에서 객체 생성하지 못하도록
	private MemberDao() {}
	
	// 참조값을 리턴해주는 메소드
	public static MemberDao getInstance() {
		if(dao==null) { // 최초 호출되면 null 이므로
			dao=new MemberDao(); // 객체를 생성해서 static 필드에 담는다.
		}
		return dao;
	}
	// 회원 한명의 정보를 리턴해주는 메소드
	public MemberDto getData(int num) {
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT *"
					+ " FROM member"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			System.out.println("member 테이블의 "+num+" 번째 회원정보를 출력합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	// 회원 목록을 리턴해주는 메소드
	public List<MemberDto> getList(){
		List<MemberDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT *"
					+ " FROM member"
					+ " ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			pstmt.executeQuery();
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				MemberDto dto=new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				list.add(dto);
			}
			System.out.println("member 테이블의 회원 목록을 출력합니다.");
			for(MemberDto tmp:list) {
				System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
			}
		}
		return printMember(list);
	}
	// 회원목록을 콘솔창에 출력해주는 메소드
	public static void printMember(List<MemberDto> list) {
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
		}
	}
	// 회원 정보를 DB에서 삭제하는 메소드
	public void delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="DELETE FROM member"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제 했습니다.");
		} catch (Exception e) {
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
	// 회원 정보를 DB에 저장하는 메소드
	public void insert(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다");
		} catch (Exception e) {
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
	// 회원 정보를 DB에서 수정하는 메소드
	public void update(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			pstmt.executeUpdate();
			System.out.println("회원 정보를 업데이트 했습니다.");
		} catch (Exception e) {
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
