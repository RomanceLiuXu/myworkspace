package com.liuxu.ssas.model;

public class ScoreList {

	private Student student;// 学生
	private Subject subject;// 学科
	private Integer score;

	public ScoreList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreList(Student student, Subject subject, Integer score) {
		super();
		this.student = student;
		this.subject = subject;
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
