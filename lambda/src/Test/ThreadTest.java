package Test;

public class ThreadTest {
	public static void main(String[] args) {
		
		new Thread(()->{
			int i=0;
			while(true){
				try {
					Thread.sleep(1000);
					System.out.println("我是lambda表达式"+"loop of "+(++i));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
