package com.liuxu.elephantManage;

import java.util.List;

//大象服务类
public class ElephantService {
//获取大象列表  "1.新增","2.查看","3.修改","4.删除","5.返回"
private List<Elephant> elephantList = SysInfo.getEpList();

	//获取大象列表
public List<Elephant> getElephants(){
	
	return elephantList;
}
public void saveElephant(Elephant elephant){
	//编号:唯一性，采用简单方式，系统自动生成：现有最大编号+1
	elephant.setSum(getElephantMaxNum()+1);
	elephantList.add(elephant);
	
}

//检查大象是否存在
public boolean checkElephantExistence(final int number){
	if (getElephantByNum(number)!= null) {
		return true;
	}else {
		return false;
	}
	
}

//获取大象最大编号
public int getElephantMaxNum(){
	
	int maxNum = 1;
	for(int i = 0;i < elephantList.size()-1;i++){
		Elephant e1 = elephantList.get(i);
		Elephant e2 = elephantList.get(i+1);
		if (e1.getSum() > e2.getSum()) {
			maxNum = e1.getSum();
		}else{
			maxNum = e2.getSum();
		}
	}
	return maxNum;
}

//根据大象编号查找大象
public Elephant getElephantByNum(final int number){
	//业务操作
	if (number<1) {
		System.out.println("编号错误！");
		return null;
	}for (int i = 0; i < elephantList.size(); i++) {
		Elephant elephant = elephantList.get(i);
		if (elephant.getSum()==number) {
			System.out.println("查找成功！");
			return elephant;
		}
		
	}
	
	return null;
	
}

//根据名称获取大象
public Elephant getElephantByName(String name){
	for (Elephant elephant : elephantList) {
		if (elephant.getName().equals(name)) {
			return elephant;
		}
	}
	return null;
}

}
