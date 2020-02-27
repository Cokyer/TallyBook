/**
 * 
 */
package com.hunau.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hunau.control.CalcControl;

/**
 * @author shadow-cxw
 *
 */
@SuppressWarnings("serial")
public class CalcUi extends JFrame {

	private JButton btn0 = new JButton("0");
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	private JButton btn7 = new JButton("7");
	private JButton btn8 = new JButton("8");
	private JButton btn9 = new JButton("9");
	private JButton btnPlus = new JButton("+");
	private JButton btnJian = new JButton("-");
	private JButton btnCheng = new JButton("*");
	private JButton btnChu = new JButton("/");
	private JButton btnDian = new JButton(".");
	private JButton clear = new JButton("C");
	public JButton result = new JButton("=");
	public JTextField input = new JTextField(10);

	public CalcUi() {
		init();
	}

	public void buttonInit() {

		input.setFont(new Font("宋体", 1, 45));
		btn0.setFont(new Font("宋体", 1, 45));
		btn1.setFont(new Font("宋体", 1, 45));
		btn2.setFont(new Font("宋体", 1, 45));
		btn3.setFont(new Font("宋体", 1, 45));
		btn4.setFont(new Font("宋体", 1, 45));
		btn5.setFont(new Font("宋体", 1, 45));
		btn6.setFont(new Font("宋体", 1, 45));
		btn7.setFont(new Font("宋体", 1, 45));
		btn8.setFont(new Font("宋体", 1, 45));
		btn9.setFont(new Font("宋体", 1, 45));
		btnPlus.setFont(new Font("宋体", 1, 45));
		btnJian.setFont(new Font("宋体", 1, 45));
		btnCheng.setFont(new Font("宋体", 1, 45));
		btnChu.setFont(new Font("宋体", 1, 45));
		btnDian.setFont(new Font("宋体", 1, 45));
		result.setFont(new Font("宋体", 1, 45));
		clear.setFont(new Font("宋体", 1, 45));
	}

	public void addContext() {

		this.buttonInit();
		Container content = this.getContentPane();

		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		pan1.setLayout(new GridLayout(1, 4, 0, 0));
		pan2.setLayout(new GridLayout(1, 4, 0, 0));
		pan3.setLayout(new GridLayout(1, 4, 0, 0));
		pan4.setLayout(new GridLayout(1, 4, 0, 0));
		pan1.add(btn1);
		pan1.add(btn2);
		pan1.add(btn3);
		pan1.add(btnPlus);
		pan2.add(btn4);
		pan2.add(btn5);
		pan2.add(btn6);
		pan2.add(btnJian);
		pan3.add(btn7);
		pan3.add(btn8);
		pan3.add(btn9);
		pan3.add(btnCheng);
		pan4.add(btnDian);
		pan4.add(btn0);
		pan4.add(clear);
		pan4.add(btnChu);

		content.setLayout(new GridLayout(6, 1, 0, 0));
		content.add(input);
		content.add(pan1);
		content.add(pan2);
		content.add(pan3);
		content.add(pan4);
		content.add(result);
	}

	private void init() {

		this.setIconImage(new ImageIcon("img/calc.jpg").getImage());
		this.setTitle("计算");
		this.setSize(300, 420);// 设置窗体大小
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.addContext();

		this.setVisible(true);
		this.bindEvent();
	}

	public void bindEvent() {
		CalcControl listener = new CalcControl(input);
		btn0.addActionListener(listener);
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		btn4.addActionListener(listener);
		btn5.addActionListener(listener);
		btn6.addActionListener(listener);
		btn7.addActionListener(listener);
		btn8.addActionListener(listener);
		btn9.addActionListener(listener);
		clear.addActionListener(listener);
		result.addActionListener(listener);
		btnPlus.addActionListener(listener);
		btnCheng.addActionListener(listener);
		btnChu.addActionListener(listener);
		btnDian.addActionListener(listener);
		btnJian.addActionListener(listener);
	}
}
