/**
 * 
 */
package com.hunau.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hunau.dao.LoginDao;
import com.hunau.ui.LoginUi;

/**
 * @author shadow-cxw
 *
 */
public class LoginControl implements ActionListener{
	
	private JTextField admin;
	private JPasswordField password;
	private LoginUi loginUi;
	
	public LoginControl(JTextField admin,JPasswordField password,LoginUi loginUi) {
		this.admin = admin;
		this.password = password;
		this.loginUi=loginUi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LoginDao dao=new LoginDao();
		dao.check(e,admin,password,loginUi);
	}
}
