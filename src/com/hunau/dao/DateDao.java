/**
 * 
 */
package com.hunau.dao;

import java.util.Calendar;

import javax.swing.JComboBox;

/**
 * @author shadow-cxw
 *
 */
public class DateDao {

	public int setDay(JComboBox<String> year, JComboBox<String> month, JComboBox<String> day) {
		int y = Integer.parseInt((String) year.getSelectedItem());
		int m = Integer.parseInt((String) month.getSelectedItem());
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, y);
		c.set(Calendar.MONTH, m - 1);
		int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days;
	}	
	public String[] getModel(int start, int end) {
		String[] m = new String[end - start + 1];
		for (int i = 0; i < m.length; i++) {
			m[i] = String.valueOf(i + start);
		}
		return m;
	}
}
