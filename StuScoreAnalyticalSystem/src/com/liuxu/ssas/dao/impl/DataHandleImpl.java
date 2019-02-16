package com.liuxu.ssas.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.Attributes.Name;

import com.liuxu.ssas.dao.interf.DataCollection;
import com.liuxu.ssas.dao.interf.DataHandleInterface;
import com.liuxu.ssas.model.ScoreList;
import com.liuxu.ssas.model.Student;
import com.liuxu.ssas.model.Subject;

public class DataHandleImpl implements DataHandleInterface {

	/*
	 * 由于学科变动不大，每次都加载默认数据
	 */
	static {
		DataCollection.subjectList.add(new Subject(1, "语文"));
		DataCollection.subjectList.add(new Subject(2, "数学"));
		DataCollection.subjectList.add(new Subject(3, "英语"));
	}

	@Override
	public List<ScoreList> searchScore(Student student) {
		
		
		return searchScore(student.getSid());
	}

	@Override
	public List<ScoreList> searchScore(Integer sid) {
		//创建集合 存放所有成绩
		ArrayList<ScoreList> list = new ArrayList<>();
		//取出该学生的所有成绩单放在list中
		for(ScoreList scoreList : DataCollection.scoreLists){
			if (scoreList.getStudent().getSid().equals(sid)) {
				list.add(scoreList);
			}
			
		}
		return list;
	}

	@Override
	public Boolean updateStudentName(Integer sid,String newName) {
		//在student中修改该学号对应的学生
		for(Student student : DataCollection.studentList){
			if (student.getSid().equals(sid)) {
				student.setName(newName);
			}
		}
		//在scoreList在修改该学号对应的学生
		for( ScoreList scoreList:DataCollection.scoreLists){
			if (scoreList.getStudent().getSid().equals(sid)) {
				scoreList.getStudent().setName(newName);
			}
		}
		
		
		return null;
	}

	@Override
	public Boolean updateSubjectScore(String name, String subjectName, Integer newScore) {
		for (ScoreList scoreList : DataCollection.scoreLists) {
			if (scoreList.getStudent().getName().equals(name)) {
				if (scoreList.getSubject().getSubjectName().equals(subjectName)) {
					scoreList.setScore(newScore);
				}
			}
			
		}
		
		
		return true;
	}

	@Override
	public Boolean deleteStudentAndScore(Student student) {
		//在学生中删除该学生
	Iterator<Student> iterator = DataCollection.studentList.iterator();
		while (iterator.hasNext()) {
		Student student2 = iterator.next();
         if (student2.getSid().equals(student.getSid())) {
			if (student2.getName().equals(student.getName())) {
				iterator.remove();
			}
		}		
		}
		//在成绩单中删除该学生
		Iterator<ScoreList> iterator2 = DataCollection.scoreLists.iterator();
		while (iterator2.hasNext()) {
			ScoreList scoreList =  iterator2.next();
			if (scoreList.getStudent().getSid().equals(student.getName())) {
				if (scoreList.getStudent().getName().equals(student.getName())) {
					iterator2.remove();
				}
			}
			
		}
		
		
		return null;
	}

	@Override
	public Boolean addStudent(Student student) {
		// 将学生添加进学生集合中
		DataCollection.studentList.add(student);
		// 为添加的学生初始化成绩单
		for (int i = 0; i < 3; i++) {
			ScoreList scoreList = new ScoreList();
				scoreList.setStudent(student);
				scoreList.setSubject(DataCollection.subjectList.get(i));
				scoreList.setScore(0);
		//将成绩单存放到成绩单集合
		DataCollection.scoreLists.add(scoreList);		
		}

		return true;
	}

	@Override
	public void allStudentInfo() {
		System.out.println("学号"+"\t"+"姓名");
		for (Student student : DataCollection.studentList) {
			System.out.println(student.getSid()+"\t"+student.getName());
			
		}
		
	}

	@Override
	public void allScoreInfo() {
		System.out.println("学号"+"\t"+"姓名"+"\t"+"语文"+"\t"+"数学"+"\t"+"英语");
		for(Student student : DataCollection.studentList){
			//根据学生获取所有的信息
			List<ScoreList> list = searchScore(student);
			//遍历list 获取所有的成绩
			StringBuilder builder = new StringBuilder();
			builder.append(student.getSid()+"\t");
			builder.append(student.getName()+"\t");
			for(ScoreList score : list){
				builder.append(score.getScore()+"\t");
				
			}
			System.out.println(builder);
		}
		
	}

	@Override
	public Boolean updateStudentAllScore(Integer sid,Integer newChinese,Integer newMath,Integer newEnglish) {
		for(ScoreList scoreList : DataCollection.scoreLists){
			if (scoreList.getStudent().getSid().equals(sid)) {
				String name = getNameById(sid);
				updateSubjectScore(name, "语文", newChinese);
				updateSubjectScore(name, "数学", newMath);
				updateSubjectScore(name, "英语", newEnglish);
			}
			
		}
		
		
		return null;
	}



public String getNameById(Integer sid){
	for(Student student : DataCollection.studentList){
		if (student.getSid().equals(sid)) {
			return student.getName();
		}
		
	}
	return null;
}

@Override
public void searchHighestScore(String subjectName) {
	int max = -1;
	String name = "";
	for(ScoreList scoreList : DataCollection.scoreLists){
		if (scoreList.getSubject().getSubjectName().equals(subjectName)) {
			if (scoreList.getScore() > max) {
				max = scoreList.getScore();
				name = scoreList.getStudent().getName();
			}
			
		}
		
	}
	
   System.out.println("获得"+subjectName+"最高分的学生是："+name);
   System.out.println("分数为："+max);
}

@Override
public void searchAverageScore(String subjectName) {
	//获取某一科目所有的成绩放入一个集合
	ArrayList<Integer> signalSubjectScore = new ArrayList<>();
	int sum = 0;
	double average = 0;
	for(ScoreList scoreList  : DataCollection.scoreLists){
		if (scoreList.getSubject().getSubjectName().equals(subjectName)) {
			signalSubjectScore.add(scoreList.getScore());
			sum+=scoreList.getScore();
		}
		
	}
	average = sum/signalSubjectScore.size();
	System.out.println("学科"+subjectName+"的平均分为："+average);
}
}