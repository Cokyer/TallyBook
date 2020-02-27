/**
 * 
 */
package com.hunau.ui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.hunau.control.Ctent1Control;

/**
 * @author shadow-cxw
 *
 */
public class InitContent1 {

	private JLabel part = new JLabel("类型");
	private JLabel kind = new JLabel("分类");
	private JLabel account = new JLabel("账户");
	private JLabel money = new JLabel("金额");
	private JLabel comt = new JLabel("备注");
	private JButton calcBtn = new JButton("计算");
	private JButton remBtn = new JButton("记账");
	private JTextField text1 = new JTextField();
	private JTextField text2 = new JTextField();
	private JComboBox<String> selectKind = new JComboBox<String>();
	private JComboBox<String> selectAc = new JComboBox<String>();
	private ButtonGroup bg = new ButtonGroup();
	final JRadioButton jrb1 = new JRadioButton("收入");
	final JRadioButton jrb2 = new JRadioButton("支出");
	private JPanel pan2 = new JPanel();

	public void initSet() {

		jrb1.setFont(new Font("宋体", 1, 20));
		jrb2.setFont(new Font("宋体", 1, 20));
		part.setFont(new Font("宋体", 1, 20));
		kind.setFont(new Font("宋体", 1, 20));
		account.setFont(new Font("宋体", 1, 20));
		comt.setFont(new Font("宋体", 1, 20));
		money.setFont(new Font("宋体", 1, 20));
		text1.setFont(new Font("宋体", 1, 20));
		text2.setFont(new Font("宋体", 1, 20));
		calcBtn.setFont(new Font("宋体", 1, 20));
		remBtn.setFont(new Font("宋体", 1, 20));
		selectKind.setFont(new Font("宋体", 1, 20));
		selectAc.setFont(new Font("宋体", 1, 20));

		part.setBounds(20, 70, 60, 40);
		jrb1.setBounds(90, 70, 100, 40);
		jrb2.setBounds(300, 70, 100, 40);
		kind.setBounds(20, 160, 60, 40);
		selectKind.setBounds(90, 160, 150, 40);
		account.setBounds(420, 160, 60, 40);
		selectAc.setBounds(490, 160, 150, 40);
		money.setBounds(20, 250, 60, 40);
		text1.setBounds(100, 250, 180, 40);
		calcBtn.setBounds(300, 250, 90, 40);
		comt.setBounds(20, 340, 60, 40);
		text2.setBounds(100, 340, 540, 100);
		remBtn.setBounds(350, 480, 90, 40);

		selectKind.addItem("");
		selectKind.addItem("餐饮");
		selectKind.addItem("娱乐");
		selectKind.addItem("购物");
		selectKind.addItem("交通");
		selectKind.addItem("工资");
		selectKind.addItem("其他");
		selectAc.addItem("");
		selectAc.addItem("微信");
		selectAc.addItem("支付宝");
		selectAc.addItem("银行账户");
	}

	public JPanel initContent() { // 主面板记账首页

		this.initSet();
		pan2.setLayout(null);
		pan2.setSize(798, 600);
		pan2.setBorder(BorderFactory.createTitledBorder("日常记账"));
		pan2.setBounds(201, 0, 800, 600);

		bg.add(jrb1);
		bg.add(jrb2);

		pan2.add(part);
		pan2.add(jrb1);
		pan2.add(jrb2);
		pan2.add(kind);
		pan2.add(selectKind);
		pan2.add(account);
		pan2.add(selectAc);
		pan2.add(money);
		pan2.add(text1);
		pan2.add(calcBtn);
		pan2.add(comt);
		pan2.add(text2);
		pan2.add(remBtn);

		jrb1.setOpaque(false);
		jrb2.setOpaque(false);
		return pan2;
	}

	public void bindEvent() {
		Ctent1Control listener = new Ctent1Control(text1, text2, selectKind, selectAc, jrb1, jrb2);
		calcBtn.addActionListener(listener);
		remBtn.addActionListener(listener);
	}
}
