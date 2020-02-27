/**
 * 
 */
package com.hunau.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.hunau.control.LoginControl;

/**
 * @author shadow-cxw
 *
 */
@SuppressWarnings("serial")
public class LoginUi extends JFrame {

	private JLabel label1;
	private JPanel pan1 = new JPanel();
	private JLabel nameLabel = new JLabel("�û�����");
	private JLabel pwdLabel = new JLabel("��  �룺");
	private JButton login = new JButton("��¼");
	private JButton register = new JButton("ע��");
	private JButton forgetPwd = new JButton("��������");
	private JTextField admin = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JCheckBox remAdmin = new JCheckBox("��ס�˺�");
	private JCheckBox remPwd = new JCheckBox("��ס����");

	public LoginUi() {
		init();
	}

	public void initUi() {

		Image image1 = new ImageIcon("img/login.jpg").getImage();
		JLabel labelimg = new ILabel(image1);
		this.getLayeredPane().add(labelimg, new Integer(Integer.MIN_VALUE));
		((JPanel) this.getContentPane()).setOpaque(false);// �������������Ϊ͸�������ܹ����������LayeredPane�ϵı�����
		labelimg.setBounds(0, 0, this.getWidth(), this.getHeight());

		this.textSet(admin);
		this.textSet(password);

		pan1.setLayout(null);
		pan1.add(nameLabel);
		pan1.add(admin);
		pan1.add(pwdLabel);
		pan1.add(password);
		pan1.add(login);
		pan1.add(register);
		pan1.add(remAdmin);
		pan1.add(remPwd);
		pan1.add(forgetPwd);
		/*
		 * ���ø�����Ĵ�С
		 */
		nameLabel.setFont(new Font("����", 1, 20));
		admin.setFont(new Font("����", 1, 20));
		pwdLabel.setFont(new Font("����", 1, 20));
		password.setFont(new Font("����", 1, 20));
		remAdmin.setFont(new Font("����", 1, 20));
		register.setFont(new Font("����", 1, 20));
		remPwd.setFont(new Font("����", 1, 20));
		forgetPwd.setFont(new Font("����", 1, 20));
		login.setFont(new Font("����", 1, 20));
		/*
		 * ���Բ���
		 */
		nameLabel.setBounds(65, 60, 100, 45);
		admin.setBounds(145, 60, 250, 45);
		pwdLabel.setBounds(65, 104, 100, 45);
		password.setBounds(145, 104, 250, 45);
		remAdmin.setBounds(85, 160, 150, 45);
		remPwd.setBounds(245, 160, 150, 45);
		register.setBounds(60, 225, 100, 45);
		forgetPwd.setBounds(165, 225, 125, 45);
		login.setBounds(295, 225, 100, 45);

		admin.setOpaque(false); // ͸����
		password.setOpaque(false);
		pan1.setOpaque(false);
		remAdmin.setOpaque(false);
		remPwd.setOpaque(false);
		this.getContentPane().add(pan1);
	}

	/*
	 * �����ı���ı߽���ʽ
	 */
	public void textSet(JTextField field) {
		field.setBackground(new Color(255, 255, 255));
		field.setPreferredSize(new Dimension(150, 28));
		MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192, 192));
		field.setBorder(border);
	}

	public void init() {

		this.setIconImage(new ImageIcon("img/ico.png").getImage());
		this.setTitle("�û���¼");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500, 350);
		this.setLocationRelativeTo(null);
		// f.setUndecorated(true);

		this.initUi();
		this.setVisible(true);
		this.bindEvent();
	}

	public void bindEvent() {
		LoginControl listener = new LoginControl(admin, password, this);
		login.addActionListener(listener);
		register.addActionListener(listener);
		forgetPwd.addActionListener(listener);
		remAdmin.addActionListener(listener);
		remPwd.addActionListener(listener);
	}

	public static void main(String[] args) {
		new LoginUi();
	}
}
