package com.ezreb.graphics;

import java.awt.Frame;
import java.awt.GraphicsEnvironment;

public class FullScreen extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1740628702648147613L;

	public FullScreen() {
		this.setUndecorated(true);
		this.setVisible(true);
		this.g = this.getGraphics();
		this.setVisible(false);
	}
	private Graphics g;
	@Override
	public Graphics getGraphics() {
		return this.g;
	}
	public FullScreen toggleVisible() {
		if(this.isVisible()==true) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
		return this;
	}
}
