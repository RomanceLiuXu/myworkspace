package com.liuxu.elephant;

public class elephantMethod {

	public static void main(String[] args) {
		System.out.println("���󹤳�����");
		String[] epS = eleNum(2);
		String winner = epsPK(epS[0], epS[1]);
		enterFridge(winner);
        
	}

	// �����װ
	public static String[] eleNum(int num) {
		System.out.println("����" + num + "ͷ����");
		// ÿ����������
		String[] eps = new String[num];
		for (int i = 0; i < eps.length; i++) {

			eps[i] = "����" + (i + 1+"��");
			System.out.print(eps[i] + " ");

		}
		System.out.println();
		return eps;
	}

	// ����PK��װΪ����
	public static String epsPK(String gueName01, String gueName02) {
		String winE = null;
		do {
			int Num1 = (int) (Math.random() * 3 + 1);
			int Num2 = (int) (Math.random() * 3 + 1);
			// �����ֱ�ʾΪ��Ӧ��ȭ
			getNumName(Num1);
			getNumName(Num2);
			System.out.println(getNumName(Num1) + "-" + getNumName(Num2));
			// pk����ʤ��
			if (Num1 == 1 && Num2 == 2 || Num1 == 2 && Num2 == 3 || Num1 == 3 && Num2 == 1) {
				System.out.println(gueName01 + "ʤ��");
				winE = gueName01;
			} else if (Num2 == 1 && Num1 == 2 || Num2 == 2 && Num1 == 3 || Num2 == 3 && Num1 == 1) {
				System.out.println(gueName02 + "ʤ��");
				winE = gueName02;
			} else
				System.out.println("ƽ�֣�����һ��");
		} while (winE == null);
		return winE;
	}

	// �����ֵõ���Ӧ������
	public static String getNumName(int num) {
		String name = null;
		switch (num) {
		case 1:
			name = "ʯͷ";
			break;
		case 2:
			name = "����";
			break;
		case 3:
			name = "��";
			break;

		default:
			break;
		}
		return name;
	}

	// ʤ���߽������
	public static void enterFridge(String winner) {
		System.out.println(winner + "�����˱���");

	}

}
