/**
 * 
 */
package com.hunau.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hunau.control.Ctent2Control;
import com.hunau.dao.DateDao;

/**
 * @author shadow-cxw
 *
 */
public class InitContent3 {

	final JComboBox<String> year = new JComboBox<String>();
	final JComboBox<String> month = new JComboBox<String>();
	final JComboBox<String> day = new JComboBox<String>();
	private JLabel monthInput = new JLabel("本月支出：");
	private JTextField textDay = new JTextField();
	private JLabel dayInput = new JLabel("本日支出：");
	private JTextField textMonth = new JTextField();
	private JLabel yearInput = new JLabel("本年支出：");
	private JTextField textYear = new JTextField();
	private JLabel date = new JLabel("日期");
	private JButton findBtn = new JButton("查询");
	private JPanel pan3 = new JPanel();
	final String part = "支出";
	private JPanel pan2 = new JPanel();

	public JPanel initContent() { // 主面板支出信息

		pan2.setLayout(null);
		pan2.setSize(798, 600);
		pan2.setBorder(BorderFactory.createTitledBorder("支出信息"));
		pan2.setBounds(201, 0, 800, 600);

		pan3.setLayout(null);
		pan3.setSize(400, 300);
		pan3.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		pan3.setBounds(350, 180, 400, 300);
		
		// this.tableInit();
		this.initSet();

		pan2.add(date);
		pan2.add(year);
		pan2.add(month);
		pan2.add(day);
		pan2.add(findBtn);
		pan2.add(monthInput);
		pan2.add(dayInput);
		pan2.add(yearInput);
		pan2.add(textDay);
		pan2.add(textMonth);
		pan2.add(textYear);
		pan2.add(pan3);
		pan3.setOpaque(false);
		
		return pan2;
	}

	public void initDate() {

		DateDao dateDao = new DateDao();
		year.setModel(new DefaultComboBoxModel(dateDao.getModel(2000, 3000)));
		month.setModel(new DefaultComboBoxModel(dateDao.getModel(1, 12)));

		year.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				day.setModel(new DefaultComboBoxModel(dateDao.getModel(1, dateDao.setDay(year, month, day))));
			}
		});
		month.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				day.setModel(new DefaultComboBoxModel(dateDao.getModel(1, dateDao.setDay(year, month, day))));
			}
		});
	}

	public void initSet() {

		this.initDate();

		year.setFont(new Font("宋体", 1, 20));
		month.setFont(new Font("宋体", 1, 20));
		day.setFont(new Font("宋体", 1, 20));
		date.setFont(new Font("宋体", 1, 20));
		findBtn.setFont(new Font("宋体", 1, 20));
		monthInput.setFont(new Font("宋体", 1, 20));
		dayInput.setFont(new Font("宋体", 1, 20));
		yearInput.setFont(new Font("宋体", 1, 20));
		textDay.setFont(new Font("宋体", 1, 20));
		textMonth.setFont(new Font("宋体", 1, 20));
		textYear.setFont(new Font("宋体", 1, 20));

		date.setBounds(60, 50, 60, 40);
		year.setBounds(130, 50, 100, 40);
		month.setBounds(250, 50, 100, 40);
		day.setBounds(370, 50, 100, 40);
		findBtn.setBounds(500, 50, 80, 40);
		monthInput.setBounds(70, 280, 120, 40);
		textDay.setBounds(210, 180, 120, 40);
		dayInput.setBounds(70, 180, 120, 40);
		textMonth.setBounds(210, 280, 120, 40);
		yearInput.setBounds(70, 380, 120, 40);
		textYear.setBounds(210, 380, 120, 40);
	}

	public void bindEvent() {
		Ctent2Control listener = new Ctent2Control(year, month, day, textDay, textMonth, textYear, part,pan3,pan2);
		findBtn.addActionListener(listener);
	}
}
