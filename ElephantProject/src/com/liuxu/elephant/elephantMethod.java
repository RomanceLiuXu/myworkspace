package com.liuxu.elephant;

public class elephantMethod {

	public static void main(String[] args) {
		System.out.println("大象工程启动");
		String[] epS = eleNum(2);
		String winner = epsPK(epS[0], epS[1]);
		enterFridge(winner);
        
	}

	// 大象封装
	public static String[] eleNum(int num) {
		System.out.println("来了" + num + "头大象");
		// 每个大象命名
		String[] eps = new String[num];
		for (int i = 0; i < eps.length; i++) {

			eps[i] = "大象" + (i + 1+"号");
			System.out.print(eps[i] + " ");

		}
		System.out.println();
		return eps;
	}

	// 大象PK封装为方法
	public static String epsPK(String gueName01, String gueName02) {
		String winE = null;
		do {
			int Num1 = (int) (Math.random() * 3 + 1);
			int Num2 = (int) (Math.random() * 3 + 1);
			// 将数字表示为对应的拳
			getNumName(Num1);
			getNumName(Num2);
			System.out.println(getNumName(Num1) + "-" + getNumName(Num2));
			// pk决定胜负
			if (Num1 == 1 && Num2 == 2 || Num1 == 2 && Num2 == 3 || Num1 == 3 && Num2 == 1) {
				System.out.println(gueName01 + "胜利");
				winE = gueName01;
			} else if (Num2 == 1 && Num1 == 2 || Num2 == 2 && Num1 == 3 || Num2 == 3 && Num1 == 1) {
				System.out.println(gueName02 + "胜利");
				winE = gueName02;
			} else
				System.out.println("平局，再来一盘");
		} while (winE == null);
		return winE;
	}

	// 由数字得到对应的名称
	public static String getNumName(int num) {
		String name = null;
		switch (num) {
		case 1:
			name = "石头";
			break;
		case 2:
			name = "剪刀";
			break;
		case 3:
			name = "布";
			break;

		default:
			break;
		}
		return name;
	}

	// 胜利者进入冰箱
	public static void enterFridge(String winner) {
		System.out.println(winner + "进入了冰箱");

	}

}
