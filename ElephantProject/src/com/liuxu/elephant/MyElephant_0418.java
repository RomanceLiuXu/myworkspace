package com.liuxu.elephant;

public class MyElephant_0418 {
//���ܣ������ȭ��ʤ���߽������
	public static void main(String[] args) {
	  System.out.println("���󹤳�����");
	  // �������
	  String eName1 = "����1��";  
      String eName2 = "����2��";
	  System.out.println(eName1+"PK"+eName2); 
	  //����PK��ͨ����ȭ��ʽ
	  //����[1,3]���������1 ʯͷ 2 ���� 3��
	  String gueName1 = null;
	  String gueName2 = null;
	  String winE = null;
	  do{int Num1 = (int)(Math.random()*3+1);
	  int Num2 = (int)(Math.random()*3+1);
	  //System.out.println(Num1);
	  //�����ֱ�ʾΪ��Ӧ��ȭ
	  switch (Num1) {
	  case 1:
		gueName1 = "ʯͷ";
		break;
	  case 2:
		gueName1 = "����";
		break;
	  case 3:
		gueName1 = "��";
		break;

	  default:
		break;
	}
	  switch (Num2) {
	  case 1:
	  gueName2 = "ʯͷ";
		break;
	  case 2:
		gueName2 = "����";
		break;
	  case 3:
		gueName2 = "��";
		break;

	  default:
		break;
	}
	  System.out.println(gueName1+"-"+gueName2);
	 //pk����ʤ��
	if (Num1==1 && Num2==2 ||Num1==2 && Num2==3 ||Num1==3 && Num2==1) {
		System.out.println(eName1+"ʤ��");
		winE = eName1;
	}else if(Num2==1 && Num1==2 ||Num2==2 && Num1==3 ||Num2==3 && Num1==1){
		System.out.println(eName2+"ʤ��");
		winE = eName2;
	} else 
	System.out.println("ƽ�֣�����һ��");
	}while(winE == null);
	
	  
	  System.out.println(winE+"�������");
	}
}
