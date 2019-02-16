package com.liuxu.ssas.dao.interf;

import java.util.ArrayList;

import com.liuxu.ssas.model.ScoreList;
import com.liuxu.ssas.model.Student;
import com.liuxu.ssas.model.Subject;

public interface DataCollection {
	//存放所有学生
    ArrayList<Student> studentList = new ArrayList<>();
    
    //存放所有学科
    ArrayList<Subject> subjectList = new ArrayList<>();
    
    //存放所有成绩单
    ArrayList<ScoreList> scoreLists = new ArrayList<>();



}
