package Test;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListenerTest {
	public static void main(String[] args) {
		JFrame jframe=new JFrame("标题");
		JButton jb=new JButton("我是按钮");
		jb.addActionListener((e)->{
			JOptionPane.showMessageDialog(null,"我是消息对话框","标题",JOptionPane.PLAIN_MESSAGE);
		});
		Container container=jframe.getContentPane();
		jframe.add(jb);
		jframe.setVisible(true);
		jframe.setSize(500, 200);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
