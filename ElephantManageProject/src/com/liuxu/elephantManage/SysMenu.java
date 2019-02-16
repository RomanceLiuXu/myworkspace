package com.liuxu.elephantManage;

//系统菜单类
public class SysMenu {
//系统操作
public static final String[] MENU = {"1.大象管理","2.冰箱管理","3.退出"};
	
//操作细项
public static final String[] MOPERATION_MENU = {"1.新增","2.查看","3.修改","4.删除","5.返回"};

//显示菜单信息
public static void showMenu(final String[] menu){
	for (int i = 0; i < menu.length; i++) {
		System.out.print(menu[i]+"\t\t");
	}
	
System.out.println();
System.out.println("----------------------------------------------------------------");
}



}
