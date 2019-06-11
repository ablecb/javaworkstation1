package com.ys.p3;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXML {
	
	
	public static void main(String[] args) {
		//����һ��Sax������
		SAXReader sax = new SAXReader();
		try {
			//����һ���ĵ�����  ����ָ����ǰ��XML�ļ�
			Document dom = sax.read(new File("src/test.xml"));
			//Ԫ�� ----��ȡ��Ԫ�ص���Ϣ
			Element root = dom.getRootElement();
			//�����ǰԪ�ص�����
			System.out.println(root.getName());
			//��ȡ��ǰԪ����������Ԫ�ض���
			List<Element> c1 = root.elements();
			for (Element e1 : c1) {
				
				
				//��ȡ��ǰԪ����������ΪID������ֵ
				String s = e1.attributeValue("id");
				System.out.println(e1.getName()+"------"+s);
				List<Element> c2 = e1.elements();
				for (Element e2 : c2) {
					//��ǰԪ�ص�����   ��  ��ǰԪ���а������ı�����
					System.out.println(e2.getName()+"------"+e2.getTextTrim());
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}
