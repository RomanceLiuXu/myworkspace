package com.liuxu.ssas.model;

public class Subject {
     
     private Integer subjectID;//学科编号
     private String subjectName;//学科名称
     
     public Subject(){
    	 
     }
      
     public Subject(Integer subjectID , String subjectName){
                this.subjectID = subjectID;
                this.subjectName = subjectName;
     
     }

	public Integer getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
     



}
