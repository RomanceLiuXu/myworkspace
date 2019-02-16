package com.liuxu.gather;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GatherClass {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		String[] array = { "科特迪瓦", "阿根廷", "澳大利亚", "塞尔维亚", "荷兰", "尼日利亚", "日本", "美国", "中国", "新西兰", "巴西", "比利时", "韩国",
				"喀麦隆", "洪都拉斯", "意大利" };
		
		for (String string : array) {
			list.add(string);
		}
		//第一组
		for(int j = 0; j < 4; j++){
			System.out.println("第"+(j+1)+"组");
			for(int i = 0; i < 4; i++) {
				//下标
//				int random = (int)(Math.random() * list.size());
				Random r = new Random();
				int random = r.nextInt(list.size());
				//取出球队
				String name = list.get(random);
				System.out.print(name + " ");
				//将出现的球队移除掉
				list.remove(random);
			}
			System.out.println();
		}

		

	}

}
