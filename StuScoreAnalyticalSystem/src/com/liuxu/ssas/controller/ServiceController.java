package com.liuxu.ssas.controller;

import java.util.List;

import com.liuxu.ssas.dao.impl.DataHandleImpl;
import com.liuxu.ssas.dao.interf.DataCollection;
import com.liuxu.ssas.dao.interf.DataHandleInterface;
import com.liuxu.ssas.model.ScoreList;
import com.liuxu.ssas.model.Student;

//业务控制
public class ServiceController implements DataHandleInterface{
     DataHandleImpl dao = new DataHandleImpl();
	@Override
	public List<ScoreList> searchScore(Student student) {
		
		return dao.searchScore(student);
	}

	@Override
	public List<ScoreList> searchScore(Integer sid) {
		
		return dao.searchScore(sid);
	}

	@Override
	public Boolean updateStudentName(Integer sid,String newName) {
		
		return dao.updateStudentName(sid, newName);
	}

	@Override
	public Boolean updateSubjectScore(String name, String subjectName, Integer newScore) {
		dao.updateSubjectScore(name, subjectName, newScore);
		return null;
	}

	@Override
	public Boolean deleteStudentAndScore(Student student) {
		
		return dao.deleteStudentAndScore(student);
	}

	@Override
	public Boolean addStudent(Student student) {
		
		
		return dao.addStudent(student);
	}

	@Override
	public void allStudentInfo() {
		
		dao.allScoreInfo();
		
	}

	@Override
	public void allScoreInfo() {
		
		dao.allScoreInfo();
		
	}

	
	@Override
	public Boolean updateStudentAllScore(Integer sid, Integer newChinese, Integer newMath, Integer newEnglish) {
		
		return dao.updateStudentAllScore(sid, newChinese, newMath, newEnglish);
	}

	@Override
	public void searchHighestScore(String subjectName) {
		dao.searchHighestScore(subjectName);
	}

	@Override
	public void searchAverageScore(String subjectName) {
		dao.searchAverageScore(subjectName);
		
	}







}
