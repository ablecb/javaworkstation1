package com.ys.p5;

public class TestHash {
	/*���Ŷ�ָ��*/
	
	public static void main(String[] args) {
		//ɢ�нṹ
		//�� Ҫ�洢������ ͨ��һ��keyֵ��������ݵ�λ��  
		// keyֵ��Ҫͨ��һ���ض��ĺ�������һ������  
		//���ǽ��������λ�õĺ�����֮Ϊɢ�к���
		MyHash<Integer, String> mh = new MyHash<Integer,String>();
		
		mh.put(7,"a");
		mh.put(4,"����");
		
		
		System.out.println(mh.get(24));
		//System.out.println(mh.get(24));
		
	}
	
	
	
	
}
