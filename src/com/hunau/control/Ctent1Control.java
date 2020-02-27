/**
 * 
 */
package com.hunau.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.hunau.dao.Ctent1Dao;

/**
 * @author shadow-cxw
 *
 */
public class Ctent1Control implements ActionListener {
	private JTextField text1 = new JTextField();
	private JTextField text2 = new JTextField();
	private JComboBox<String> selectKind = new JComboBox<String>();
	private JComboBox<String> selectAc = new JComboBox<String>();
	private JRadioButton jrb1 = new JRadioButton();
	private JRadioButton jrb2 = new JRadioButton();

	public Ctent1Control(JTextField text1, JTextField text2, JComboBox<String> selectKind, JComboBox<String> selectAc,
			JRadioButton jrb1, JRadioButton jrb2) {
		this.text1 = text1;
		this.text2 = text2;
		this.selectKind = selectKind;
		this.selectAc = selectAc;
		this.jrb1 = jrb1;
		this.jrb2 = jrb2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ctent1Dao dao = new Ctent1Dao();
		dao.contentLs(e, text1, text2, selectKind, selectAc, jrb1, jrb2);
	}
}
