package com.ezreb.graphics.elements;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.geom.Rectangle2D;

public class Word extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1229384704646204538L;
	public Word(String word) {
		this.word = word;
		this.f = new Font("Word", Font.PLAIN, 1);
		this.addHierarchyListener(new HierarchyListener() {
			
			@Override
			public void hierarchyChanged(HierarchyEvent arg0) {
				if(arg0.getID()==HierarchyEvent.HIERARCHY_CHANGED) {
					Word.this.g = arg0.getComponent().getGraphics();
					Rectangle2D r = Word.this.f.getStringBounds("Health", ((Graphics2D) Word.this.g).getFontRenderContext());
					Word.this.length = (int) Math.abs(r.getWidth());
					Word.this.hieght = (int) Math.abs(r.getHeight());
					Word.this.setFont(Word.this.f);
				} else if(arg0.getID()==HierarchyEvent.DISPLAYABILITY_CHANGED) {
					if(arg0.getComponent().isVisible()==true) {
						Word.this.setVisible(true);
					} else if(arg0.getComponent().isVisible()==false) {
						Word.this.setVisible(false);
					}
				}
				
			}
		});
		this.setSize(this.length, this.hieght);
	}
	public String word;
	public Graphics g;
	public int length;
	public int hieght;
	public Font f;
	public void draw() {
		if(this.isVisible()) {
			this.g.drawString(this.word, 0, this.hieght);
		}
	}
	public void clear() {
		if(this.isVisible()) {
			this.g.clearRect(0, 0, this.length, this.hieght);
		}
	}
}
