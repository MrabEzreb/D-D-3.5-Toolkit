package com.ezreb.graphics.menu;

import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ezreb.data.Language;
import com.ezreb.graphics.FullScreen;
import com.ezreb.graphics.images.ImageLoader;
import com.ezreb.utils.InitialFileCreator;

public class OptionsMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5554900456369886734L;
	private MenuScreen menuScreen;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	public OptionsMenu() {
		setBounds(new Rectangle(0, 0, 1366, 768));
		setLayout(null);
		
		menuScreen = new MenuScreen();
		menuScreen.setBounds(10, 11, 201, 101);
		add(menuScreen);
		
		MenuOption menuOption = new MenuOption(200, 100, (Image) ImageLoader.BACK_OPTION);
		menuOption.setSize(200, 100);
		menuOption.getCanvas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				OptionsMenu.this.setVisible(false);
				((FullScreen) OptionsMenu.this.getParent().getParent().getParent().getParent()).start();
			}
		});
		menuScreen.add(menuOption);
		
		JTabbedPane Options = new JTabbedPane();
		Options.setBounds(10, 150, 1346, 468);
		add(Options);
		
		JPanel GraphicsTab = new JPanel();
		Options.addTab(Language.currentLanguage.GraphicsTab, null, GraphicsTab, "Graphical Options, ya know.");
		
		JPanel LanguageTab = new JPanel();
		Options.addTab(Language.currentLanguage.LanguageTab, null, LanguageTab, null);
		LanguageTab.setLayout(null);
		
		JList Languages = new JList();
		Languages.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent paramListSelectionEvent) {
				try {
					Language.setBaseLanguage((String) ((JList) paramListSelectionEvent.getSource()).getSelectedValue());
				} catch(ClassCastException e) {
					System.err.println("WHAT? LANGUAGES ARE BEING ATTACKED!");
				}
			}
		});
		int i3 = InitialFileCreator.langFolder.list().length-1;
		final String[] values2 = new String[i3];
		int i = 0;
		for (int i2 = 0; i2 < InitialFileCreator.langFolder.list().length; i2++) {
			if(InitialFileCreator.langFolder.list()[i2].equals("Current.json")) {
				System.out.println("broke");
			} else {
				String value = InitialFileCreator.langFolder.list()[i2].substring(0, InitialFileCreator.langFolder.list()[i2].length()-5);
				values2[i] = value;
				i++;
			}
		}
		Languages.setModel(new AbstractListModel() {
			String[] values = values2;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		Languages.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Languages.setBounds(0, 25, 1342, 415);
		LanguageTab.add(Languages);
		
		JLabel lblNoteChangesRequire = new JLabel("Note, changes require a restart to take effect.");
		lblNoteChangesRequire.setBounds(0, 0, 400, 25);
		LanguageTab.add(lblNoteChangesRequire);

		
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		// TODO Auto-generated method stub
		super.setVisible(aFlag);
		Component[] c = this.getComponents();
		for (Component component : c) {
			component.setVisible(aFlag);
		}
		if (aFlag) {
			this.requestFocusInWindow();
			this.menuScreen.start();
		}
	}
	public MenuScreen getMenuScreen() {
		return menuScreen;
	}
}
