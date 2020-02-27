/**
 * 
 */
package com.hunau.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.hunau.control.RegisterControl;

/**
 * @author shadow-cxw
 *
 */
@SuppressWarnings("serial")
public class RegisterUi extends JFrame {

	private JPanel pan1 = new JPanel();
	private JLabel nameLabel = new JLabel("用户名：");
	private JLabel pwdLabel = new JLabel("密  码：");
	private JLabel phoneLabel = new JLabel("电   话：");
	private JLabel pwdLabels = new JLabel("确认密码：");
	private JButton close = new JButton("重置");
	private JButton register = new JButton("注册");
	private JTextField phone = new JTextField();
	private JTextField admin = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JPasswordField passwords = new JPasswordField();

	public RegisterUi() {
		init();
	}

	public void init() {
		this.setIconImage(new ImageIcon("img/ico.png").getImage());
		this.setTitle("注册");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(450, 500);
		this.setLocationRelativeTo(null);
		// f.setUndecorated(true);

		this.initUi();
		this.setVisible(true);
		this.lisEvent();
	}

	public void initUi() {

		Image image1 = new ImageIcon("img/register.jpg").getImage();
		JLabel labelimg = new ILabel(image1);
		this.getLayeredPane().add(labelimg, new Integer(Integer.MIN_VALUE));
		((JPanel) this.getContentPane()).setOpaque(false);// 将内容面板设置为透明，就能够看见添加在LayeredPane上的背景。
		labelimg.setBounds(0, 0, this.getWidth(), this.getHeight());

		this.textSet(admin);
		this.textSet(password);
		this.textSet(passwords);
		this.textSet(phone);
		this.sizeSet();

		pan1.setLayout(null);
		pan1.add(nameLabel);
		pan1.add(admin);
		pan1.add(pwdLabel);
		pan1.add(password);
		pan1.add(pwdLabels);
		pan1.add(passwords);
		pan1.add(phoneLabel);
		pan1.add(phone);
		pan1.add(close);
		pan1.add(register);

		admin.setOpaque(false); // 设置组件透明。
		password.setOpaque(false);
		passwords.setOpaque(false);
		phone.setOpaque(false);
		pan1.setOpaque(false);
		close.setOpaque(false);
		register.setOpaque(false);
		this.getContentPane().add(pan1);
	}

	public void sizeSet() {
		/*
		 * 设置组件大小
		 */
		nameLabel.setFont(new Font("宋体", 1, 20));
		admin.setFont(new Font("宋体", 1, 20));
		pwdLabel.setFont(new Font("宋体", 1, 20));
		phoneLabel.setFont(new Font("宋体", 1, 20));
		password.setFont(new Font("宋体", 1, 20));
		passwords.setFont(new Font("宋体", 1, 20));
		register.setFont(new Font("宋体", 1, 20));
		pwdLabels.setFont(new Font("宋体", 1, 20));
		phone.setFont(new Font("宋体", 1, 20));
		close.setFont(new Font("宋体", 1, 20));
		/*
		 * 绝对布局
		 */
		nameLabel.setBounds(55, 60, 100, 45);
		admin.setBounds(185, 60, 200, 45);
		pwdLabel.setBounds(55, 125, 100, 45);
		password.setBounds(185, 125, 200, 45);
		pwdLabels.setBounds(55, 190, 150, 45);
		passwords.setBounds(185, 190, 200, 45);
		phoneLabel.setBounds(55, 255, 100, 45);
		phone.setBounds(185, 255, 200, 45);
		close.setBounds(75, 340, 125, 45);
		register.setBounds(215, 340, 125, 45);
	}

	/*
	 * 设置文本框的边界样式
	 */
	public void textSet(JTextField field) {
		field.setBackground(new Color(255, 255, 255));
		field.setPreferredSize(new Dimension(150, 28));
		MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192, 192));
		field.setBorder(border);
	}

	public void lisEvent() {
		RegisterControl listener = new RegisterControl(admin, password, passwords, phone);
		close.addActionListener(listener);
		register.addActionListener(listener);
		admin.addActionListener(listener);
		password.addActionListener(listener);
		passwords.addActionListener(listener);
		phone.addActionListener(listener);
	}
}
