/**
 * 
 */
package com.hunau.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import com.hunau.dao.CalcDao;

/**
 * @author shadow-cxw
 *
 */
public class CalcControl implements ActionListener {

	private JTextField input;

	public CalcControl(JTextField input) {
		this.input = input;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CalcDao dao = new CalcDao();
		dao.btnLs(e, input);
	}
}
