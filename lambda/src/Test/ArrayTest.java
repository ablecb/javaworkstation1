package Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.forEach(n->System.out.println("数字:"+n));
		list.forEach(System.out::println);
	}
}
