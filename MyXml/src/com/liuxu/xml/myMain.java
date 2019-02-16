package com.liuxu.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class myMain {

	public static void main(String[] args) {
		// 获取路径
		String path = "C:\\Users\\asus\\workspace\\MyXml\\src\\com\\liuxu\\xml\\Students.xml";
		// 实例化File对象
		File file = new File(path);
		// 实例化解析工具对象
		SAXReader reader = new SAXReader();

		try {
			// 读取文件，获取Document对象
			Document document = reader.read(file);
			// 获取根标签
			Element eles = document.getRootElement();
			// 获取student节点集合
			List<Element> ele = eles.elements("student");
			// 获取迭代器对象
			Iterator<Element> it = ele.iterator();
			while (it.hasNext()) {
				Element el = it.next();
				// 获取name节点
				Element name = el.element("name");
				// 获取age节点
				Element age = el.element("age");
				// 获取文本
				String na = name.getText();
				String ag = age.getText();
				System.out.println(na + ":" + ag);
			}
		} catch (DocumentException e) {

			e.printStackTrace();
		}
	}
}
