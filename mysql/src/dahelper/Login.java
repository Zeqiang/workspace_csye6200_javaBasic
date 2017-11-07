package dahelper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	public Login() {
		super();
		JFrame login=new JFrame("登录");           //创建”登录“的框架
	    JLabel t1=new JLabel("用  户  名：");          //创建标签”用户号“
	    JTextField t2=new JTextField("",15);    //创建用户号的输入栏 
	    JLabel t3=new JLabel("登录密码：");         //创建标签"登录密码"
	    JTextField t4=new JPasswordField("",15);//创建登录密码的输入栏 
	    JButton sure = new JButton(" 确定");       //创建”确定“按钮
	    
	    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置登录界面的按钮标签的的大小和具体坐标位置
		login.setSize(390,220);    //设置大小                          
		login.setVisible(true);    //设置可见性
		login.setLocation(500,210);//设置坐标
	}
}
