/**
 * 
 */
package com.hunau.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.hunau.dao.CountDao;
import com.hunau.dao.Ctent4Dao;
import com.hunau.dao.Ctent5Dao;
import com.hunau.ui.CountUi;
import com.hunau.ui.TableUi;

/**
 * @author shadow-cxw
 *
 */
public class Ctent4Control implements ActionListener {
	private JComboBox<String> year = new JComboBox<String>();
	private JComboBox<String> month = new JComboBox<String>();
	private JComboBox<String> day = new JComboBox<String>();
	private JComboBox<String> part = new JComboBox<String>();
	private Vector vec = new Vector();

	public Ctent4Control() {
	}

	public Ctent4Control(JComboBox<String> year, JComboBox<String> month, JComboBox<String> day,
			JComboBox<String> part) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.part = part;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if ("��ѯ".equals(command)) {
			
			TableUi tableUi = new TableUi();
			Ctent4Dao dao = new Ctent4Dao();
			vec = dao.contentLs(e, year, month, day, part);
			tableUi.getInfo(vec);		
		} 
		else if ("����ͼ��".equals(command)) {
			String p="����";
			CountDao dao = new CountDao();
			CountUi count=new CountUi(dao.contentLs(p));
			JFrame jframe=new JFrame();
			jframe.setTitle("����ͼ��");
			jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jframe.setResizable(false);
			jframe.setSize(1000, 600);
			jframe.setLocationRelativeTo(null);
			// f.setUndecorated(true);
			jframe.add(count.getChartPanel());
			jframe.setVisible(true);
		}
		else if ("֧��ͼ��".equals(command)) {
			String p="֧��";
			CountDao dao = new CountDao();
			CountUi count=new CountUi(dao.contentLs(p));
			JFrame jframe=new JFrame();
			jframe.setTitle("֧��ͼ��");
			jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jframe.setResizable(false);
			jframe.setSize(1000, 600);
			jframe.setLocationRelativeTo(null);
			// f.setUndecorated(true);
			jframe.add(count.getChartPanel());
			jframe.setVisible(true);
		} 
		else if ("ɾ��".equals(command)) {
			Ctent5Dao dao = new Ctent5Dao();
			dao.contentLs(e, year, month, day, part);
			JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��Ϣ", JOptionPane.WARNING_MESSAGE);
		}
	}
}
