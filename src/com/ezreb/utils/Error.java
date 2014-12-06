package com.ezreb.utils;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Rectangle;

public class Error {

	public Error(String reason) {
		this.reason = reason;
	}
	private String[] options = new String[1];
	private String reason;
	//private int numberOfOptions = 1;
	public Error addOptions(String option) {
		String[] options2 = new String[this.options.length+1];
		for (int i = 0; i < options2.length; i++) {
			if(i==options.length) {
				options2[i] = option;
				break;
			} else {
				options2[i] = options[i];
			}
		}
		this.options = options2;
		return this;
	}
	public Frame showError() {
		Frame retVal = new Frame("DnD Toolkit Error");
		Rectangle r = retVal.getMaximizedBounds();
		int w = r.width;
		int h = r.height;
		w = (w/2)-50;
		h = (h/2)-25;
		retVal.setSize(100, 50);
		retVal.setLocation(w, h);
		Label l = new Label("Error: "+this.reason, Label.CENTER);
		l.setBounds(3, 10, 94, 10);
		retVal.add(l);
		Choice c = new Choice();
		for (String string : options) {
			c.add(string);
		}
		retVal.add(c);
		return retVal;
	}
}
