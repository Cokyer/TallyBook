/**
 * 
 */
package com.hunau.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hunau.dao.RegisterDao;

/**
 * @author shadow-cxw
 *
 */
public class RegisterControl implements ActionListener{

	private JTextField admin;
	private JPasswordField password;
	private JPasswordField passwords;
	private JTextField phone;

	public RegisterControl(JTextField admin,JPasswordField password,JPasswordField passwords,JTextField phone) {
		this.admin = admin;
		this.password = password;
		this.passwords = passwords;
		this.phone = phone;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RegisterDao dao=new RegisterDao();
		dao.check(e,admin,password,passwords,phone);
	}
}
