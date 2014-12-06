package com.ezreb.utils;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import sun.awt.DesktopBrowse;
import sun.java2d.ScreenUpdateManager;

public class ErrorWindow {

	public ErrorWindow(String reason) {
		this.reason = reason;
	}
	private String[] options = new String[0];
	private String reason;
	public boolean hasAnswer = false;
	//private int numberOfOptions = 1;
	public ErrorWindow addOptions(String option) {
		if(this.options.length==0) {
			this.options = new String[1];
			this.options[0] = option;
		} else {
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
		}
		return this;
	}
	public String showError() {
		Frame retVal = new Frame("DnD Toolkit Error");
		Dimension r = new Dimension(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().x, GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().y);
		int w = (int) Math.floor(r.getWidth());
		int h = (int) Math.floor(r.getHeight());
		System.out.println(w);
		System.out.println(h);
		w = w-100;
		h = h-50;
		System.out.println(w);
		System.out.println(h);
		retVal.setSize(200, 100);
		retVal.setLocation(w, h);
		Label l = new Label("Error: "+this.reason, Label.CENTER);
		l.setBounds(3, 10, 94, 10);
		retVal.add(l);
		Choice c = new Choice();
		for (String string : options) {
			c.add(string);
		}
		c.setBounds(3, 20, 94, 10);
		retVal.add(c);
		Button b = new Button("Done");
		b.setBounds(28, 35, 54, 10);
		final ErrorWindow e3 = this;
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				e3.hasAnswer = true;
				
				
			}
		});
		retVal.add(b);
		Component[] comps = retVal.getComponents();
		for (int i = 0; i < comps.length; i++) {
			System.out.println(comps[i].getName());
			
		}
		retVal.setVisible(true);
		String chosen = null;
		while(hasAnswer==false) {
			chosen = c.getSelectedItem();
		}
		retVal.dispose();
		return chosen;
	}
}
