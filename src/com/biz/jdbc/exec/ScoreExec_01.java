package com.biz.jdbc.exec;

import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.service.ScoreService;
import com.biz.jdbc.service.ScoreServiceImp_01;

public class ScoreExec_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ScoreService ss = new ScoreServiceImp_01();
		List<ScoreVO> stdList = ss.findByStNum("001");
		
		ScoreVO vo = new ScoreVO();
		vo.setSc_seq(2);
		vo.setSc_date("2019-06-28");
		vo.setSc_score(90);
		vo.setSc_st_num("002");
		vo.setSc_subject("지구과학");
				
		ss.insert(vo);		
		
		for(ScoreVO to : stdList) {
			System.out.println(to);
			
		}
		
		
		
	}

}
