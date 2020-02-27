/**
 * 
 */
package com.hunau.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hunau.control.MainControl;

/**
 * @author shadow-cxw
 *
 */
@SuppressWarnings("serial")
public class MainUi extends JFrame {

	private JLabel label = new JLabel("账本管理");
	private JButton btn1 = new JButton("记账首页");
	private JButton btn2 = new JButton("收入信息");
	private JButton btn3 = new JButton("支出信息");
	private JButton btn4 = new JButton("查询信息");
	private JButton btn5 = new JButton("删除信息");
	private JPanel panel = new JPanel();
	private JPanel pan2 = new JPanel();
	private JPanel pan3 = new JPanel();
	private JPanel pan4 = new JPanel();
	private JPanel pan5 = new JPanel();
	private JPanel pan6 = new JPanel();
	private InitContent1 con1 = new InitContent1();
	private InitContent2 con2 = new InitContent2();
	private InitContent3 con3 = new InitContent3();
	private InitContent4 con4 = new InitContent4();
	private InitContent5 con5 = new InitContent5();

	public MainUi() {
		init();
	}

	public void init() {

		this.setIconImage(new ImageIcon("img/ico.png").getImage());
		this.setTitle("记账本");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		// f.setUndecorated(true);

		this.addContent();
		this.setVisible(true);
		this.lisEvent();
		con1.bindEvent();
		con2.bindEvent();
		con3.bindEvent();
		con4.bindEvent();
		con5.bindEvent();
	}

	public void initSet() {

		label.setFont(new Font("宋体", 1, 30));
		btn1.setFont(new Font("宋体", 1, 30));
		btn2.setFont(new Font("宋体", 1, 30));
		btn3.setFont(new Font("宋体", 1, 30));
		btn4.setFont(new Font("宋体", 1, 30));
		btn5.setFont(new Font("宋体", 1, 30));

		label.setBounds(40, 30, 180, 60);
		btn1.setBounds(10, 120, 180, 60);
		btn2.setBounds(10, 200, 180, 60);
		btn3.setBounds(10, 280, 180, 60);
		btn4.setBounds(10, 360, 180, 60);
		btn5.setBounds(10, 440, 180, 60);
	}

	public void addContent() {

		this.initSet();
		Image image1 = new ImageIcon("img/background.jpg").getImage();
		JLabel label1 = new ILabel(image1);
		this.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
		((JPanel) this.getContentPane()).setOpaque(false);// 将内容面板设置为透明，就能够看见添加在LayeredPane上的背景。
		label1.setBounds(0, 0, this.getWidth(), this.getHeight());

		JPanel pan1 = new JPanel();
		pan1.setLayout(null);
		pan1.add(label);
		pan1.add(btn1);
		pan1.add(btn2);
		pan1.add(btn3);
		pan1.add(btn4);
		pan1.add(btn5);
		pan1.setSize(200, 600);
		pan1.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		pan1.setBounds(0, 0, 200, 600);

		pan2 = con1.initContent();
		pan2.setVisible(true);

		pan3 = con2.initContent();
		pan3.setVisible(false);

		pan4 = con3.initContent();
		pan4.setVisible(false);

		pan5 = con4.initContent();
		pan5.setVisible(false);

		pan6 = con5.initContent();
		pan6.setVisible(false);

		panel.setLayout(null);
		panel.add(pan1);
		panel.add(pan2);
		panel.add(pan3);
		panel.add(pan4);
		panel.add(pan5);
		panel.add(pan6);
		panel.setOpaque(false);
		pan1.setOpaque(false);
		pan2.setOpaque(false);
		pan3.setOpaque(false);
		pan4.setOpaque(false);
		pan5.setOpaque(false);
		pan6.setOpaque(false);
		this.getContentPane().add(panel);
	}

	public void lisEvent() {

		MainControl listener = new MainControl(pan2, pan3, pan4, pan5, pan6);
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		btn4.addActionListener(listener);
		btn5.addActionListener(listener);
	}
}
