package com.biz.jdbc.service;

import java.util.List;

import com.biz.jdbc.model.StudentVO;

public interface StdService {
		//CRUD를 위한 매서드 선언
	
	public List<StudentVO >selectAll();
	
	//select를 실행해서 데이터를 조회할 때
	// 분명히 1개의 데이터만 조회될 것이다
	//라고 하면 return타입으로 vo를 사용한다.
	public StudentVO findByNum(String stNo);

	//확률적으로 대부분 1개의 데이터가 조회될 것이지만
	//어쩌다 한번이라도 한개 이상의 데이터가 조회될 것 같다.
	//라고 한다면 return 타입은 무조건 list형이 된다.
	public List<StudentVO> fineByName(String stName);
	
	
	public int insert(StudentVO vo);
	public int update(StudentVO vo);
	public int delete(StudentVO stNo);
	public String makeStNum();

	
	
}
