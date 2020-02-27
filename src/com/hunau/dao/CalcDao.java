/**
 * 
 */
package com.hunau.dao;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * @author shadow-cxw
 *
 */
public class CalcDao {

	private static double result = 0; // ��¼�����
	private static String cou = "="; // ��¼����������
	private static boolean point = false; // ����ȷ��ÿ���������ֻ��һ��С����

	public void btnLs(ActionEvent e, JTextField input) {

		String command = e.getActionCommand();
		String text = input.getText();

		if ("0".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("1".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("2".equals(command)) {

			this.clearChar(text, command, input);
		} else if ("3".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("4".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("5".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("6".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("7".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("8".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("9".equals(command)) {
			this.clearChar(text, command, input);
		} else if ("+".equals(command)) {
			this.clearNum(text, command, input);
		} else if ("-".equals(command)) {
			this.clearNum(text, command, input);
		} else if ("*".equals(command)) {
			this.clearNum(text, command, input);
		} else if ("/".equals(command)) {
			this.clearNum(text, command, input);
		} else if (".".equals(command)) {
			if (point) {
				input.setText(text);
			} else {
				point = true;
				input.setText(text + ".");
			}
		} else if ("C".equals(command)) {
			input.setText("");
			this.initChar();
		} else {
			if ("+".equals(text)) {
				input.setText("+");
			} else if ("-".equals(text)) {
				input.setText("-");
			} else if ("/".equals(text)) {
				input.setText("/");
			} else if ("*".equals(text)) {
				input.setText("*");
			} else if ("".equals(text)) {
				input.setText("");
			} else {
				this.count(text);
				input.setText("" + result);
				this.initChar();
			}
		}
	}

	public void initCou(String text) { // �õ���һ���������
		cou = text;
	}

	public void initChar() { // ÿ�μ�����ɣ�������ݻ��档
		cou = "=";
		result = 0;
	}

	public void clearChar(String text, String command, JTextField input) { // ��������ʱ�����������е��������
		if ("+".equals(text) || "-".equals(text) || "/".equals(text) || "*".equals(text) || "=".equals(cou)) {
			this.initCou(text);
			input.setText(command);
		} else {
			input.setText(text + command);
		}
	}

	public void clearNum(String text, String command, JTextField input) { // ��������������������е����֡�
		point = false; // ���С����ļ�¼��
		if ("+".equals(text)) {
			input.setText("+");
		} else if ("-".equals(text)) {
			input.setText("-");
		} else if ("/".equals(text)) {
			input.setText("/");
		} else if ("*".equals(text)) {
			input.setText("*");
		} else if ("".equals(text)) {
			input.setText("");
		} else {
			this.count(text);
			input.setText(command);
		}
	}

	public void count(String text) { // �������ݵ����㡣
		if ("+".equals(cou))
			result = result + Double.parseDouble(text);
		else if ("-".equals(cou))
			result = result - Double.parseDouble(text);
		else if ("/".equals(cou))
			result = result / Double.parseDouble(text);
		else if ("*".equals(cou))
			result = result * Double.parseDouble(text);
		else
			result = Double.parseDouble(text);
	}
}
