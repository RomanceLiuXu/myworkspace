package com.liuxu.elephant;

public class MyElephant_0418 {
//功能：大象猜拳，胜利者进入冰箱
	public static void main(String[] args) {
	  System.out.println("大象工程启动");
	  // 定义大象
	  String eName1 = "大象1号";  
      String eName2 = "大象2号";
	  System.out.println(eName1+"PK"+eName2); 
	  //大象PK，通过猜拳方式
	  //产生[1,3]的随机数，1 石头 2 剪刀 3布
	  String gueName1 = null;
	  String gueName2 = null;
	  String winE = null;
	  do{int Num1 = (int)(Math.random()*3+1);
	  int Num2 = (int)(Math.random()*3+1);
	  //System.out.println(Num1);
	  //将数字表示为对应的拳
	  switch (Num1) {
	  case 1:
		gueName1 = "石头";
		break;
	  case 2:
		gueName1 = "剪刀";
		break;
	  case 3:
		gueName1 = "布";
		break;

	  default:
		break;
	}
	  switch (Num2) {
	  case 1:
	  gueName2 = "石头";
		break;
	  case 2:
		gueName2 = "剪刀";
		break;
	  case 3:
		gueName2 = "布";
		break;

	  default:
		break;
	}
	  System.out.println(gueName1+"-"+gueName2);
	 //pk决定胜负
	if (Num1==1 && Num2==2 ||Num1==2 && Num2==3 ||Num1==3 && Num2==1) {
		System.out.println(eName1+"胜利");
		winE = eName1;
	}else if(Num2==1 && Num1==2 ||Num2==2 && Num1==3 ||Num2==3 && Num1==1){
		System.out.println(eName2+"胜利");
		winE = eName2;
	} else 
	System.out.println("平局，再来一盘");
	}while(winE == null);
	
	  
	  System.out.println(winE+"进入冰箱");
	}
}
