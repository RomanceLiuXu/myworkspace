package com.liuxu.gather;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GatherClass {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		String[] array = { "���ص���", "����͢", "�Ĵ�����", "����ά��", "����", "��������", "�ձ�", "����", "�й�", "������", "����", "����ʱ", "����",
				"����¡", "�鶼��˹", "�����" };
		
		for (String string : array) {
			list.add(string);
		}
		//��һ��
		for(int j = 0; j < 4; j++){
			System.out.println("��"+(j+1)+"��");
			for(int i = 0; i < 4; i++) {
				//�±�
//				int random = (int)(Math.random() * list.size());
				Random r = new Random();
				int random = r.nextInt(list.size());
				//ȡ�����
				String name = list.get(random);
				System.out.print(name + " ");
				//�����ֵ�����Ƴ���
				list.remove(random);
			}
			System.out.println();
		}

		

	}

}
