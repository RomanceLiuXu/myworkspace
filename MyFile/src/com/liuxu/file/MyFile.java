package com.liuxu.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFile {

	public static void main(String[] args) {
		File file = new File("src/jys.txt");
		try {
			boolean success = file.createNewFile();
			// if (success) {
			// System.out.println("创建成功");
			// }else{
			// System.out.println("创建失败");
			// }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			writer.write("                    静夜思\r\n");
			writer.write("                           李白\r\n");
			writer.write("               窗前明月光，\r\n");
			writer.write("                   疑是地上霜。\r\n");
			writer.write("                   举头望明月，\r\n");
			writer.write("                 低头思故乡。\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileReader reader = null;
		File file2 = new File("src/test.txt");
		FileWriter file2Writer = null;
		int c = 0;
		try {
			file2.createNewFile();
			file2Writer = new FileWriter(file2);
			reader = new FileReader(file);
			while ((c = reader.read()) != -1) {
				char ch = (char) c;
            file2Writer.write(ch);
				//System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				reader.close();
				file2Writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        //计算workspace的大小   C:\Users\asus\workspace
		File file3 = new File("C:/Users/asus/workspace");
	    long size = calFileSize(file3);
		System.out.println("size:"+size);
		//按照层级结构打印所有文件夹
		File file4 = new File("C:/Users/asus/workspace/MyFile");
		showFileNames(file4, 0);
	}
	//打印所有的名称 第二个参数：当前正在遍历的文件夹在哪一级
		public static void showFileNames(File file,int level){
			if (file == null||!file.exists()) {
				System.out.println("文件不存在");
				return;
			}
			//打印名字之前，按照等级确定前面的空格数
			String space ="";
			for(int i = 0;i < level;i++){
				space+="--";
			}
			if (file.isFile()&&!file.isHidden()) {
				System.out.println(space + file.getName());
				return;
			}
		//获取文件夹所有的子目录
			File[] files = file.listFiles();
			//说明是空文件夹，直接打印名称
			if (files == null||files.length == 0) {
				System.out.println(space + file.getName());
				return;
			}
			//将当前正在遍历的文件夹名称打印出来
		 System.out.println(space + file.getName());
		 //打印的是正在遍历文件夹中的子目录名称
		 //子目录比当前文件更低一级
		 space +="--";
		    for (File file2 : files) {
				if (file2.isFile()&&!file2.isHidden()) {
					System.out.println(space + file2.getName());
				}else if (file2.isDirectory()) {
					showFileNames(file2,level+1);
				}
			}
		
		}
	//获得文件夹大小	
		public static long calFileSize(File file){
			if (file == null) {
				throw new NullPointerException("The parameter file cannot be null ");
				
			}//判断给定路径下的文件是否存在
			if (!file.exists()) {
				System.err.println("路径无效，文件不存在");
			}//判断是否是文件
			if (file.isFile()) {
				return file.length();
			}
			//说明是一个文件夹，得到该文件夹中所有的子文件／文件夹，遍历计算大小
			File[] files = file.listFiles();
			long sum = 0; //记录最终的累加值
			for (File file2 : files) {
				if (file2.isFile()) {
					//说明是文件 直接得到大小 累加
					sum += file2.length();
				}else if(file2.isDirectory()){
					//说明是文件夹  遍历得到大小 累加
				long subSum = calFileSize(file2);
				sum += subSum;
				}
				
			}
			//将计算好的总大小返回
			return sum;
		}
}
