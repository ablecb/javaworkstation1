package com.ys.p1;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMyBatis {
	//数据库进行交互的框架 ----- JDBC
	public static void main(String[] args) throws Exception {	
//		SqlSessionFactoryBuilder sb = new SqlSessionFactoryBuilder();		
//		//解析XML文件信息 --- sqlSessionFactory ---类似于Connection
//		SqlSessionFactory sf = 
//				sb.build(new FileInputStream("src/ConfigLocation1.xml"));
//		//获取数据操作对象 --- statement  Preperstatment
//		SqlSession sqlSession = sf.openSession();
		//sqlSession.insert("u1.in1");
		//int t = sqlSession.selectOne("u1.sel1");
		//System.out.println(t);
		//int  t = sqlSession.selectOne("u1.sel2",11);
		//System.out.println(t);		
		//User u = sqlSession.selectOne("u1.sel3",1001);
		//System.out.println(u);		
		/*Map<String, Object> map = new HashMap<String, Object>();		
		map.put("name", "张三");
		map.put("age", 11);		
		List<User> listU = sqlSession.selectList("u1.sel4",map);
		System.out.println(listU);*/		
		/*User u = sqlSession.selectOne("u1.sel6",1001);
		System.out.println(u);				
		sqlSession.commit();*/
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory  sf=ssfb.build(new FileInputStream("src/ConfigLocation.xml"));
		SqlSession sqlSession=sf.openSession();
		int t=sqlSession.insert("u1.u1");
			
		System.out.println(t);
		sqlSession.commit();
	}
	
	
	
}
