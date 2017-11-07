package com.test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

public class fenster{
	
    public void log(){
    	
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

	Container n=login.getContentPane();//面板
	n.setLayout(null);

	t1.setBounds(80,30,70,25);//设置标签坐标
	t2.setBounds(160,30,120,25);
	t3.setBounds(80,80,70,25);
	t4.setBounds(160,80,120,25);

	sure.setBounds(160,130,63,33);//设置“确定”按钮坐标

	n.add(t1);//将登陆界面的按钮和标签添加到登录的面板里
	n.add(t2);
	n.add(t3);
	n.add(t4);
	
	n.add(sure);
	
	login.add(sure);
	
    }
 
	public static void main(String args[]){//主方法
			fenster m = new fenster();
			m.log(); 
		}
    } 