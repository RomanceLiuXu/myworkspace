package com.liuxu.elephantManage;


import java.util.ArrayList;
import java.util.List;
//系统信息类
public class SysInfo {

 //大象列表	
 private static List<Elephant> elephantList = new ArrayList<>();
	
	static{
		System.out.println("初始化大象信息...");
		Elephant elephant1 = new Elephant(1, "壮壮", 6, 100);
		Elephant elephant2 = new Elephant(2, "胖胖", 5, 100);
		Elephant elephant3 = new Elephant(3, "花花", 4.5, 100);
		Elephant elephant4 = new Elephant(4, "妞妞", 7, 100);
		Elephant elephant5 = new Elephant(5, "壮壮", 9, 100);
	//装进elephantlist
	elephantList.add(elephant1);
	elephantList.add(elephant2);
	elephantList.add(elephant3);
	elephantList.add(elephant4);
	elephantList.add(elephant5);
	
	}
     //获取大象列表 
    public static List getEpList(){
    	
    	return elephantList;
    }
   }
