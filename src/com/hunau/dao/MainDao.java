/**
 * 
 */
package com.hunau.dao;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

/**
 * @author shadow-cxw
 *
 */
public class MainDao {

	public void btnLs(ActionEvent e,JPanel pan2,JPanel pan3,JPanel pan4,JPanel pan5,JPanel pan6) {
		String command = e.getActionCommand();
		
		if ("������ҳ".equals(command)) {
			pan2.setVisible(true);
			pan3.setVisible(false);
			pan4.setVisible(false);
			pan5.setVisible(false);
			pan6.setVisible(false);
		}
		else if("������Ϣ".equals(command)) {
			pan3.setVisible(true);
			pan2.setVisible(false);
			pan4.setVisible(false);
			pan5.setVisible(false);
			pan6.setVisible(false);
		}
		else if("֧����Ϣ".equals(command)) {
			pan4.setVisible(true);
			pan3.setVisible(false);
			pan2.setVisible(false);
			pan5.setVisible(false);
			pan6.setVisible(false);
		}
		else if("��ѯ��Ϣ".equals(command)) {
			pan5.setVisible(true);
			pan3.setVisible(false);
			pan2.setVisible(false);
			pan4.setVisible(false);
			pan6.setVisible(false);
		}
		else if("ɾ����Ϣ".equals(command)) {
			pan6.setVisible(true);
			pan5.setVisible(false);
			pan3.setVisible(false);
			pan2.setVisible(false);
			pan4.setVisible(false);
		}
	}
}
