package com.ezreb.graphics;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Popup extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4421622061637294858L;
	public Popup(String reason) {
		this.setTitle("DnD Toolkit");
		LayoutManager lm = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(lm);
		Label tl = new Label(reason, Label.CENTER);
		tl.setPreferredSize(new Dimension(94, 15));
		this.add(tl);
		this.addButton("Ok", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		Point p = new Point();
		p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		p.x = p.x-200;
		p.y = p.y-100;
		this.setLocation(p);
		this.setSize(400, 200);
	}
	public Popup addButton(String name, ActionListener a) {
		Button b = new Button(name);
		b.addActionListener(a);
		this.add(b);
		return this;
	}
	public Popup pop() {
		this.setVisible(true);
		return this;
	}

}
