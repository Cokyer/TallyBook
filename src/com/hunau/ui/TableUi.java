/**
 * 
 */
package com.hunau.ui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hunau.control.Ctent4Control;

/**
 * @author shadow-cxw
 *
 */
public class TableUi extends JFrame {

	private Vector rowData = new Vector();
	private Vector<String> columname = new Vector<String>();
	private JTable selecttable;

	private void tableSet() {
		this.setTitle("��Ϣ��");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		// f.setUndecorated(true);

		this.tableInit();
		this.setVisible(true);
	}

	private void tableInit() {
		Vector test = new Vector();
		test = rowData;
		columname.add("����");
		columname.add("����");
		columname.add("�˻�");
		columname.add("���");
		columname.add("ʱ��");
		columname.add("��ע");
		selecttable = new JTable(test, columname);
		JScrollPane scroll = new JScrollPane(selecttable);
		this.add(scroll);
		scroll.setBounds(50, 50, 600, 600);
	}

	public void getInfo(Vector vector) {
		// TODO Auto-generated method stub
		Ctent4Control control = new Ctent4Control();
		this.rowData = vector;
		this.tableSet();
	}
}
