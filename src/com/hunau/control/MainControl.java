/**
 * 
 */
package com.hunau.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.hunau.dao.MainDao;

/**
 * @author shadow-cxw
 *
 */
public class MainControl implements ActionListener{
	
	private JPanel pan2= new JPanel();
	private JPanel pan3= new JPanel();
	private JPanel pan4= new JPanel();
	private JPanel pan5= new JPanel();
	private JPanel pan6= new JPanel();
	
	public MainControl(JPanel pan2,JPanel pan3,JPanel pan4,JPanel pan5,JPanel pan6) {
		this.pan2 =pan2;
		this.pan3 =pan3;
		this.pan4 =pan4;
		this.pan5 =pan5;
		this.pan6 =pan6;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainDao dao=new MainDao();
		dao.btnLs(e,pan2,pan3,pan4,pan5,pan6);
	}	
}
