package com.ezreb.utils;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@Deprecated
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
		Label l = new Label("Error: "+this.reason);
		l.setBounds(50, 32, 100, 15);
		retVal.setVisible(true);
		retVal.add(l);
		Choice c = new Choice();
		for (String string : options) {
			c.add(string);
		}
		c.setBounds(60, 42, 80, 10);
		retVal.add(c);
		Button b = new Button("Done");
		//b.setBounds(13, 75, 174, 10);
		b.setLocation(13, 75);
		b.setPreferredSize(new Dimension(80, 10));
		final ErrorWindow e3 = this;
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				e3.hasAnswer = true;
			}
		});
		System.out.println(b.getBounds().getWidth());
		System.out.println(b.getBounds().getHeight());
		retVal.add(b);
		Component[] comps = retVal.getComponents();
		for (int i = 0; i < comps.length; i++) {
			System.out.println(comps[i].getName());
		}
		String chosen = null;
		while(hasAnswer==false) {
			chosen = c.getSelectedItem();
		}
		retVal.dispose();
		return chosen;
	}
}
