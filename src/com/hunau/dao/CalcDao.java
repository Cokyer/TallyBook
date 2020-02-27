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

	private static double result = 0; // 记录结果；
	private static String cou = "="; // 记录输入的运算符
	private static boolean point = false; // 用于确保每次输入的数只有一个小数点

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

	public void initCou(String text) { // 得到上一个运算符。
		cou = text;
	}

	public void initChar() { // 每次计算完成，清除数据缓存。
		cou = "=";
		result = 0;
	}

	public void clearChar(String text, String command, JTextField input) { // 输入数字时，清除输入框中的运算符。
		if ("+".equals(text) || "-".equals(text) || "/".equals(text) || "*".equals(text) || "=".equals(cou)) {
			this.initCou(text);
			input.setText(command);
		} else {
			input.setText(text + command);
		}
	}

	public void clearNum(String text, String command, JTextField input) { // 输入运算符，清除输入框中的数字。
		point = false; // 清空小数点的记录；
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

	public void count(String text) { // 进行数据的运算。
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
