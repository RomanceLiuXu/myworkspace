package com.liuxu.ssas.view;

import java.util.List;
import java.util.Scanner;

import com.liuxu.ssas.controller.ServiceController;
import com.liuxu.ssas.model.ScoreList;
import com.liuxu.ssas.model.Student;

public class MainView {

	public void view() {
		System.out.println("*********欢迎进入学生成绩分析系统**********");
		System.out.println(
				"请选择你要进行的操作：1.添加学生  2.修改学生成绩  3.修改学生姓名  4.删除学生信息 5.获取学生成绩 6.查询所有学生 7.查询所有成绩 8.根据学号修改所有成绩 9.查询学科最高成绩 10.获取某一学科的平均分 11.其他功能");
		Scanner scanner = new Scanner(System.in);
		ServiceController sc = new ServiceController();
		int select = scanner.nextInt();
		switch (select) {
		case 1:{
			// 添加学生
			System.out.println("请输入学号");
			int sid = scanner.nextInt();
			System.out.println("请输入姓名");
			String name = scanner.next();
			Student student = new Student(name, sid);
			sc.addStudent(student);
		 }
		view();
			break;
		case 2:{
			// 修改学生成绩
			System.out.println("请输入学生姓名");
			String name = scanner.next();
			System.out.println("请输入学科");
			String subjectName = scanner.next();
			System.out.println("请输入新的分数");
			Integer newScore = scanner.nextInt();
			sc.updateSubjectScore(name, subjectName, newScore);
		}
		view();
		break;
		case 3:{
			// 修改学生姓名
			System.out.println("请输入学号");
			Integer sid = scanner.nextInt();
			System.out.println("请输入新名字");
			String newName = scanner.next();
			sc.updateStudentName(sid, newName);
		}
		view();
		break;
		case 4:{
			// 删除学生信息
			System.out.println("请输入要删除学生的学号");
			Integer sid = scanner.nextInt();
			System.out.println("请输入要删除学生的姓名");
			String name = scanner.next();
			sc.deleteStudentAndScore(new Student(name, sid));
		}
		view();
		break;
		case 5:{
			// 获取学生成绩
			System.out.println("请选择获取方式:1.按学号获取  2.按学生获取");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				System.out.println("请输入学号");
				Integer sid = scanner.nextInt();
				List<ScoreList> list = sc.searchScore(sid);
				for(ScoreList scoreList : list){
					System.out.println("姓名:"+scoreList.getStudent().getName());
					System.out.println(scoreList.getSubject().getSubjectName()+":"+scoreList.getScore());
				}
				view();
				break;
			case 2:
				System.out.println("请输入学号");
				Integer sid1 = scanner.nextInt();
				System.out.println("请输入姓名");
				String  name = scanner.next();
				List<ScoreList> list1 = sc.searchScore(new Student(name, sid1));
				for(ScoreList scoreList : list1){
					System.out.println("姓名:"+scoreList.getStudent().getName());
					System.out.println(scoreList.getSubject().getSubjectName()+":"+scoreList.getScore());
				}
				view();
				break;
			default:
				break;
			}

		}
			break;
		case 6:
			sc.allStudentInfo();
			view();
			// 查询所有学生
			break;
		case 7:
			// 查询所有成绩
			sc.allScoreInfo();
			view();
			break;
		case 8:{
			// 根据学号修改所有成绩
		System.out.println("请输入学号");
		Integer sid = scanner.nextInt();
		System.out.println("请输入新的语文成绩");
		Integer newChinese = scanner.nextInt();
		System.out.println("请输入新的数学成绩");
		Integer newMath = scanner.nextInt();
		System.out.println("请输入新的英语成绩");
		Integer newEnglish = scanner.nextInt();
		sc.updateStudentAllScore(sid, newChinese, newMath, newEnglish);
		}
		view();
		break;
		case 9 :{
			//查询学科最高成绩的学生
			System.out.println("请输入要查询的学科");
			String subjectName = scanner.next();
			sc.searchHighestScore(subjectName);
		}view();
		break;
		case 10 :{
			//获取某一学科的平均分
			System.out.println("请输入学科");
			String subjectName = scanner.next();
			sc.searchAverageScore(subjectName);
		}view();
		break;
		default:
			System.out.println("抱歉，其他功能正在开发中");
			break;
		}

	}

}
