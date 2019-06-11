package com.ys.p3;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXML {
	
	
	public static void main(String[] args) {
		//创建一个Sax解析器
		SAXReader sax = new SAXReader();
		try {
			//返回一个文档对象  用来指代当前的XML文件
			Document dom = sax.read(new File("src/test.xml"));
			//元素 ----获取根元素的信息
			Element root = dom.getRootElement();
			//输出当前元素的名字
			System.out.println(root.getName());
			//获取当前元素下所有子元素对象
			List<Element> c1 = root.elements();
			for (Element e1 : c1) {
				
				
				//获取当前元素中属性名为ID的属性值
				String s = e1.attributeValue("id");
				System.out.println(e1.getName()+"------"+s);
				List<Element> c2 = e1.elements();
				for (Element e2 : c2) {
					//当前元素的名字   和  当前元素中包含的文本数据
					System.out.println(e2.getName()+"------"+e2.getTextTrim());
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}
