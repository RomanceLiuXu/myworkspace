package com.liuxu.elephantManage;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//系统运行类
public class SysRun {
	Scanner scanner = new Scanner(System.in);
	ElephantService eService = new ElephantService();

	public static void main(String[] args) {
		SysRun Run = new SysRun();
		Run.sysRun();

	}

	// 启动系统
	public void sysRun() {
		System.out.println("大象工程——启动");
		// 输出菜单
		System.out.println("------------------------------操作选项-------------------------");
		SysMenu.showMenu(SysMenu.MENU);
		// 获取用户输入进行操作
		// 用方法实现
		int operationNum = getCorrectNum(SysMenu.MENU);
		// 操作
		doMoperation(operationNum);
	}

	// 管理操作
	private boolean doMoperation(int operationNum) {
		// "1.大象管理","2.冰箱管理","3.退出"
		switch (operationNum) {
		case 1:
			// 显示大象列表并输出
			showElephantList();
			System.out.println("----------------------------操作选项------------------------------");
			SysMenu.showMenu(SysMenu.MOPERATION_MENU);
			// 获取输入
			int manageNum = getCorrectNum(SysMenu.MOPERATION_MENU);
			// 操作
			doElephantOperation(manageNum);
			break;

		default:
			break;
		}

		return true;
	}

	private void doElephantOperation(int manageNum) {
		// 1.新增","2.查看","3.修改","4.删除","5.返回"
		switch (manageNum) {
		case 1:
			// 方法
			addElephant();
			// 显示最新的大象列表
			showElephantList();
			break;
		case 2:
			viewElephant();
			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		default:
			break;
		}

	}

	// 查看大象
	public void viewElephant() {
		System.out.println("-----查看大象-----");
		// 输入编号，查找大象是否存在，输出大象信息
		// 获取有效的大象信息（对象）
		// 输出
		showElephant(getValidElephant());
	}

	// 获取有效的大象
	private Elephant getValidElephant() {
		Elephant elephant = null;
		boolean isOK = false;
		do {
			System.out.println("请输入大象编号(数字):");
			int number = getVaildIntData();
			// 检查大象是否存在
			if (eService.checkElephantExistence(number)) {
				elephant = eService.getElephantByNum(number);
				isOK = true;
			} else {
				System.out.println("大象不存在，请重新输入编号：");

			}
			// 存在即获取
		} while (!isOK);
		return elephant;
	}

	// 新增大象
	private void addElephant() {
		System.out.println("------新增大象-----");
		boolean isOK = false;
		String name = null;
		do {
			System.out.println("请输入名称(唯一，不能与现有大象同名)");
			name = scanner.next();
			// 处理同名情况
			if (eService.getElephantByName(name) == null) {
				isOK = true;
			} else {
				System.out.println("名称已经存在，请重新输入！");

			}
		} while (!isOK);
		// 获取其他数据
		System.out.println("请输入体重");
		double weight = getVaildDoubleData();
		System.out.println("请输入血量");
		int bloodVolume = getVaildIntData();

		// 保存大象到系统中
		eService.saveElephant(new Elephant(0, name, weight, bloodVolume));

	}

	// 获取有效的double类型数据
	private double getVaildDoubleData() {
		double doubledata = 0;
		boolean isOK = false;
		do {
			try {
				doubledata = scanner.nextDouble();
				isOK = true;
			} catch (InputMismatchException e) {
				System.out.println("输入类型错误，请重新输入！");
				scanner.next();
			}

		} while (!isOK);
		return doubledata;
	}

	// 获取有效的int类型数据
	private int getVaildIntData() {
		int intdata = 0;
		boolean isOK = false;
		do {
			try {
				intdata = scanner.nextInt();
				isOK = true;
			} catch (InputMismatchException e) {
				System.out.println("输入类型错误，请重新输入！");
				scanner.next();
			}

		} while (!isOK);
		return intdata;
	}

	private void showElephant(Elephant e) {
		System.out.println("大象信息");
		System.out.println("编号\t\t名称\t\t体重(吨)\t\t血量(点)");
		System.out.println(e.getSum() + "\t\t" + e.getName() + "\t\t" + e.getWeight() + "\t\t" + e.getBloodVolume());
	}

	private void showElephantList() {
		System.out.println("大象列表");
		System.out.println("编号\t\t名称\t\t体重(吨)\t\t血量(点)");
		// 获取大象并显示

		List<Elephant> eList = eService.getElephants();
		for (int i = 0; i < eList.size(); i++) {
			Elephant e = eList.get(i);
			System.out
					.println(e.getSum() + "\t\t" + e.getName() + "\t\t" + e.getWeight() + "\t\t" + e.getBloodVolume());
		}

	}

	// 对于给定的菜单，获取有效的编号选项
	public int getCorrectNum(String[] targetMenu) {
		int intputNum = 0;
		System.out.println("请输入菜单操作对应的数字：");

		boolean isOK = false;
		do {
			try {
				intputNum = scanner.nextInt();
				// System.out.println("输入的是"+intputNum);
				if (intputNum >= 1 && intputNum <= targetMenu.length) {
					isOK = true;
				} else {
					System.out.println("输入错误，请重新输入！");
				}

			} catch (InputMismatchException e) {
				System.out.println("输入类型错误，请重新输入：");
				// 如果输入错误，需要丢弃本次输入
				scanner.next();
			}
		} while (!isOK);

		return intputNum;
	}

}
