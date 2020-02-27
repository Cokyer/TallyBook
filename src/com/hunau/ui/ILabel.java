/**
 * 
 */
package com.hunau.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;


@SuppressWarnings("serial")
class ILabel extends JLabel {
	private Image image;

	ILabel(Image image) {
		this.image = image;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = this.getWidth();
		int y = this.getHeight();
		g.drawImage(image, 0, 0, x, y, null);
	}
}
