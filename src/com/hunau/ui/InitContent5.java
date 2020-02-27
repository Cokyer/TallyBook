/**
 * 
 */
package com.hunau.ui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hunau.control.Ctent4Control;
import com.hunau.dao.DateDao;

/**
 * @author shadow-cxw
 *
 */
public class InitContent5 {

	final JComboBox<String> year = new JComboBox<String>();
	final JComboBox<String> month = new JComboBox<String>();
	final JComboBox<String> day = new JComboBox<String>();
	final JComboBox<String> part = new JComboBox<String>();
	private JLabel date = new JLabel("日期");
	private JLabel partLabel = new JLabel("类型");
	private JButton findBtn = new JButton("删除");
	private JPanel pan2 = new JPanel();

	public JPanel initContent() {

		pan2.setLayout(null);
		pan2.setSize(798, 600);
		pan2.setBorder(BorderFactory.createTitledBorder("删除信息"));
		pan2.setBounds(201, 0, 800, 600);

		this.initSet();

		pan2.add(date);
		pan2.add(year);
		pan2.add(month);
		pan2.add(day);
		pan2.add(findBtn);
		pan2.add(partLabel);
		pan2.add(part);

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
		partLabel.setFont(new Font("宋体", 1, 20));
		part.setFont(new Font("宋体", 1, 20));

		part.addItem("所有");
		part.addItem("收入");
		part.addItem("支出");

		date.setBounds(50, 100, 50, 50);
		year.setBounds(120, 100, 100, 50);
		month.setBounds(240, 100, 100, 50);
		day.setBounds(360, 100, 100, 50);
		partLabel.setBounds(50, 200, 50, 50);
		part.setBounds(120, 200, 110, 50);
		findBtn.setBounds(350, 400, 90, 60);
	}

	public void bindEvent() {
		Ctent4Control listener = new Ctent4Control(year, month, day, part);
		findBtn.addActionListener(listener);
	}
}
