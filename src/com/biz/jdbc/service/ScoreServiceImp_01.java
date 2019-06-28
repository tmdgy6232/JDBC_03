package com.biz.jdbc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {

	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScoreVO findBySeq() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScoreVO> findByStNum(String stNum) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ";
		sql += " where sc_st_num = ? ";
		
		PreparedStatement ps = null;
		try {
			ps = DBConnection.dbConn.prepareStatement(sql);
			ps.setString(1, stNum);
			ResultSet rs = ps.executeQuery();
			List<ScoreVO> stdList = new ArrayList<ScoreVO>();
			while(rs.next()) {
			ScoreVO vo = new ScoreVO();
			vo.setSc_seq(rs.getLong("sc_seq"));
			vo.setSc_date(rs.getString("sc_date"));
			vo.setSc_score(rs.getInt("sc_score"));
			vo.setSc_st_num(rs.getString("sc_st_num"));
			vo.setSc_subject(rs.getString("sc_subject"));
			stdList.add(vo);
			}
			return stdList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		
		String sql = " INSERT INTO tbl_score ( " ;
		sql += " SC_SEQ, " ; 
		sql += " SC_DATE, " ;
		sql += " SC_ST_NUM, " ;
		sql += " SC_SUBJECT, " ;
		sql += " SC_SCORE ) " ;
		sql += " values(?,?,?,?,?) ";
		
		PreparedStatement ps = null;
		try {
			ps = DBConnection.dbConn.prepareStatement(sql);
			
			ps.setLong(1, vo.getSc_seq());
			ps.setString(2, vo.getSc_date());
			ps.setString(3, vo.getSc_st_num());
			ps.setString(4, vo.getSc_subject());
			ps.setInt(5, vo.getSc_score());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void 
}
