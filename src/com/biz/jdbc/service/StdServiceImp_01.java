package com.biz.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.StudentVO;

public class StdServiceImp_01 implements StdService {

	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_sudent ";
		
		PreparedStatement ps = null;
		
		try {
			ps = DBConnection.dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<StudentVO> stdList = new ArrayList<StudentVO>();
			while(rs.next()){
				StudentVO vo = new StudentVO(
				rs.getString("st_no"),
				rs.getString("st_name"),
				rs.getString("st_addr"),
				rs.getInt("st_grade"),
				rs.getInt("st_height"),
				rs.getInt("st_weight"),
				rs.getString("st_nick"),
				rs.getString("st_nick_rem"),
				rs.getString("st_dept_name")
						);
				stdList.add(vo);
			}

			return stdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

//		ps = DBConnection.dbConn.prepareStatement(sql);
//		ResultSet rs = ps.executeQuery();
//		List<StudentVO> stdList = new ArrayList<StudentVO>();
//		while(true) {
//			StudentVO vo =
//		}
		return null;
	}

	@Override
	public StudentVO findByNum(String stNo) {
		// TODO Auto-generated method stub
	
		String sql = " SELECT FROM tbl_student ";
				sql += " WHERE st_no = ? ";// + stNo;
				
		PreparedStatement ps = null;
		try {
			ps = DBConnection.dbConn.prepareStatement(sql);
			ps.setString(1, stNo);// ?표에 stNo를 대입시켜라
			// 이런 코드를 사용하여야 DB 인젝션 공격을 막을 수 있다.
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				StudentVO vo = null;
				vo = new StudentVO();
				vo.setSt_no(rs.getString("st_no"));
				vo.setSt_name(rs.getString("st_name"));
				vo.setSt_addr(rs.getString("st_addr"));
				vo.setSt_grade(rs.getInt("st_grade"));
				vo.setSt_height(rs.getInt("st_height"));
				vo.setSt_weight(rs.getInt("st_weight"));
				vo.setSt_nick(rs.getString("st_nick"));
				vo.setSt_nick_rem(rs.getString("st_nick_rem"));
				vo.setSt_dept_name(rs.getString("st_dept_name"));
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<StudentVO> fineByName(String stName) {
		// TODO Auto-generated method stub

		String sql = " SELECT FROM tbl_student ";
				sql += " WHERE st_no = " + stName;
				
		PreparedStatement ps = null;
		try {
			ps = DBConnection.dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<StudentVO> vo = null;
			vo = new ArrayList<StudentVO>();
			
			while(rs.next()) {
				StudentVO svo = new StudentVO();
				svo.setSt_addr(rs.getString(" ST_ADDR "));
				svo.setSt_dept_name(rs.getString(" ST_dept_name "));
				svo.setSt_grade(rs.getInt(" ST_grade "));
				svo.setSt_height(rs.getInt(" ST_height "));
				svo.setSt_weight(rs.getInt(" ST_weight "));
				svo.setSt_nick(rs.getString(" ST_nick "));
				svo.setSt_nick_rem(rs.getString(" ST_nick_rem "));
				svo.setSt_no(rs.getString(" ST_no "));
				svo.setSt_name(rs.getString(" ST_name "));
				vo.add(svo);
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO 여기는 학생 정보를 추가하는 매서드
		
		String sql = " INSERT INTO tbl_student ( " ;
		sql += " ST_NO, " ;
		sql += " ST_NAME, " ;
		sql += " ST_ADDR, " ;
		sql += " ST_GRADE, " ;
		sql += " ST_HEIGHT, " ;
		sql += " ST_WEIGHT, " ;
		sql += " ST_NICK, " ;
		sql += " ST_NICK_REM, " ;
		sql += " ST_DEPT_NAME ) " ;
		sql += " values( ?,?,?,?,?,?,?,?,? ) ";
		
		PreparedStatement ps = null;
		try {
			/*
			 *  DBMS와 연결되는 Connection 정보를
			 *  service 클래스에 변수로 등록하고
			 *  변수를 사용해서 query를 사용하는 방법이 아닌
			 *  
			 *  필요할 때마다 DBConnection 클래스의
			 *  dbConn 객체변수를 직접 사용하여
			 *  query를 직접 실행하는 방법을 사용한다.
			 *  
			 *  Service 클래스에 변수를 선언, 생성하는 절차가 필요없이
			 *  필요할때마다 dbConn 변수를 직접 사용하므로써
			 *  
			 *  Service 클래스에 불필요한 변수 생성코드를 
			 *  작성하지 않아도 되고 혹시 모를 변수 생성이 되지 않아
			 *  발생할 수 있는 runtime exception을 예방할 수 있다.
			 */
			ps = DBConnection.dbConn.prepareStatement(sql);
			ps.setString(1, vo.getSt_no());
			ps.setString(2, vo.getSt_name());
			ps.setString(3, vo.getSt_addr());
			ps.setInt(4, vo.getSt_grade());
			ps.setInt(5, vo.getSt_height());
			ps.setInt(6, vo.getSt_weight());
			ps.setString(7, vo.getSt_nick());
			ps.setString(8, vo.getSt_nick_rem());
			ps.setString(9, vo.getSt_dept_name());
			
			return ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(StudentVO stNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String makeStNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
