package com.liuxu.ssas.dao.interf;
//数据控制

import java.util.List;

import com.liuxu.ssas.model.ScoreList;
import com.liuxu.ssas.model.Student;
import com.liuxu.ssas.model.Subject;

public interface DataHandleInterface {

	// 根据学生查成绩
	List<ScoreList> searchScore(Student student);

	// 根据指定学号查成绩
	List<ScoreList> searchScore(Integer sid);

	// 根据学生的id修改姓名
	Boolean updateStudentName(Integer sid,String newName);

	// 根据姓名修改指定学科的成绩
	Boolean updateSubjectScore(String name, String subjectName, Integer newScore);

	// 删除指定学生及其成绩
	Boolean deleteStudentAndScore(Student student);

	// 添加学生
	Boolean addStudent(Student student);
	
	//获取所有学生信息 只是打印
	void allStudentInfo();
	
	//获取所有学生的成绩 只是打印
	void allScoreInfo();
	
	//根据学号修改该学生所有成绩
	Boolean updateStudentAllScore(Integer sid,Integer newChinese,Integer newMath,Integer newEnglish);

    //查询学科最高成绩的学生
	public void searchHighestScore(String subjectName);
	
	//获取某一学科的平均分
	void searchAverageScore(String subjectName);
}
