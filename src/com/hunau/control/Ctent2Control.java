/**
 * 
 */
package com.hunau.control;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hunau.dao.Ctent2Dao;
import com.hunau.ui.InTable;

/**
 * @author shadow-cxw
 *
 */
public class Ctent2Control implements ActionListener {
	private JComboBox<String> year = new JComboBox<String>();
	private JComboBox<String> month = new JComboBox<String>();
	private JComboBox<String> day = new JComboBox<String>();
	private JTextField textDay = new JTextField();
	private JTextField textMonth = new JTextField();
	private JTextField textYear = new JTextField();
	private String part;
	private JPanel pan3;
	private JPanel pan2;
	private InTable intable;

	public Ctent2Control(JComboBox<String> year, JComboBox<String> month, JComboBox<String> day, JTextField textDay,
			JTextField textMonth, JTextField textYear, String part,JPanel pan3,JPanel pan2) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.textDay = textDay;
		this.textMonth = textMonth;
		this.textYear = textYear;
		this.part = part;
		this.pan3=pan3;
		this.pan2=pan2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctent2Dao dao = new Ctent2Dao();
		List<Integer> list=dao.contentLs(e, year, month, day, textDay, textMonth, textYear, part);
		intable=new InTable(list.get(0),list.get(1),list.get(2));
		this.refresh();
	}
	
	public void refresh() {
		pan2.remove(pan3);
		pan3=new JPanel();
		pan3.add(intable.getChartPanel());
		pan3.setLayout(new GridLayout(1,1,0,0));
		pan3.setSize(400, 300);
		pan3.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		pan3.setBounds(350, 180, 400, 300);
		pan3.setOpaque(false);
		pan3.setVisible(false);
		pan2.add(pan3);	
		pan3.setVisible(true);
		pan2.repaint();
	}
}
