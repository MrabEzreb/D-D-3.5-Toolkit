package com.ezreb.jsongen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import org.json.JSONObject;

public class JSONApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2141247133845661094L;
	private JTextField Name;
	private JTextField MinWeight;
	private JTextField MaxWeight;
	private JTextField MinHeight;
	private JTextField MaxHeight;
	private JTextField Child;
	private JTextField Teen;
	private JTextField Adult;
	private JTextField Elder;
	private JTextField Death;
	private JTextField Hair;
	private JTextField BODAY;
	private JEditorPane txtTesting1 = new JEditorPane();
	private JTextArea StatChanges;
	@SuppressWarnings("unused")
	private final Action action = new SwingAction();
	private JTextField StatName;
	public JTabbedPane tabbedPane;
	private JTextField StatMinimum;
	private JTextField StatMaximum;

	/**
	 * Create the applet.
	 */
	public JSONApplet() {
		setSize(new Dimension(450, 300));
		
		JLabel lblRaceGenerator = new JLabel("JSON Generator");
		lblRaceGenerator.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblRaceGenerator, BorderLayout.NORTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Race = new JPanel();
		tabbedPane.addTab("Race", null, Race, "Generates JSON text for new Races.");
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		
		Name = new JTextField();
		lblName.setLabelFor(Name);
		Name.setColumns(10);
		
		JLabel lblPhysicalChari = new JLabel("Physical Description");
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblStatChanges = new JLabel("Stat Changes");
		
		StatChanges = new JTextArea();
		StatChanges.setWrapStyleWord(true);
		StatChanges.setLineWrap(true);
		StatChanges.setFont(new Font("Monospaced", Font.PLAIN, 11));
		StatChanges.setTabSize(4);
		StatChanges.setText("Enter stat changes in the format of\r\n{Stat:change,Stat:-change}\r\n(the second for negative changes)");
		GroupLayout gl_Race = new GroupLayout(Race);
		gl_Race.setHorizontalGroup(
			gl_Race.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Race.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Race.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Race.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Race.createSequentialGroup()
							.addComponent(lblPhysicalChari)
							.addGap(111)
							.addComponent(lblStatChanges))
						.addGroup(gl_Race.createSequentialGroup()
							.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(StatChanges, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		gl_Race.setVerticalGroup(
			gl_Race.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Race.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Race.createParallelGroup(Alignment.BASELINE)
						.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Race.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhysicalChari)
						.addComponent(lblStatChanges))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Race.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(StatChanges, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel Weight = new JPanel();
		tabbedPane_1.addTab("Weight", null, Weight, null);
		FlowLayout fl_Weight = new FlowLayout(FlowLayout.CENTER, 10, 5);
		Weight.setLayout(fl_Weight);
		
		JLabel lblNewLabel = new JLabel("Minimum");
		Weight.add(lblNewLabel);
		
		MinWeight = new JTextField();
		lblNewLabel.setLabelFor(MinWeight);
		Weight.add(MinWeight);
		MinWeight.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Maximum");
		Weight.add(lblNewLabel_1);
		
		MaxWeight = new JTextField();
		lblNewLabel_1.setLabelFor(MaxWeight);
		Weight.add(MaxWeight);
		MaxWeight.setColumns(10);
		
		JPanel Height = new JPanel();
		tabbedPane_1.addTab("Height", null, Height, null);
		Height.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JLabel label = new JLabel("Minimum");
		Height.add(label);
		
		MinHeight = new JTextField();
		label.setLabelFor(MinHeight);
		MinHeight.setColumns(10);
		Height.add(MinHeight);
		
		JLabel label_1 = new JLabel("Maximum");
		Height.add(label_1);
		
		MaxHeight = new JTextField();
		label_1.setLabelFor(MaxHeight);
		MaxHeight.setColumns(10);
		Height.add(MaxHeight);
		
		JPanel Age = new JPanel();
		tabbedPane_1.addTab("Age", null, Age, null);
		FlowLayout fl_Age = new FlowLayout(FlowLayout.CENTER, 1, 5);
		Age.setLayout(fl_Age);
		
		JLabel lblToddlerchild = new JLabel("Toddler>Child");
		Age.add(lblToddlerchild);
		
		Child = new JTextField();
		lblToddlerchild.setLabelFor(Child);
		Child.setColumns(10);
		Age.add(Child);
		
		JLabel lblChildteen = new JLabel("Child>Teen");
		Age.add(lblChildteen);
		
		Teen = new JTextField();
		lblChildteen.setLabelFor(Teen);
		Teen.setColumns(10);
		Age.add(Teen);
		
		JLabel lblTeenadult = new JLabel("Teen>Adult");
		Age.add(lblTeenadult);
		
		Adult = new JTextField();
		lblTeenadult.setLabelFor(Adult);
		Adult.setColumns(10);
		Age.add(Adult);
		
		JLabel lblAdultelder = new JLabel("Adult>Elder");
		Age.add(lblAdultelder);
		
		Elder = new JTextField();
		lblAdultelder.setLabelFor(Elder);
		Elder.setColumns(10);
		Age.add(Elder);
		
		JLabel lblElderdeath = new JLabel("Elder>Death");
		Age.add(lblElderdeath);
		
		Death = new JTextField();
		lblElderdeath.setLabelFor(Death);
		Death.setColumns(10);
		Age.add(Death);
		
		JPanel Colors = new JPanel();
		tabbedPane_1.addTab("Colors", null, Colors, null);
		Colors.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JLabel lblHair = new JLabel("Hair Color");
		Colors.add(lblHair);
		
		Hair = new JTextField();
		lblHair.setLabelFor(Hair);
		Hair.setColumns(10);
		Colors.add(Hair);
		
		JLabel lblSkinColor = new JLabel("Skin Color");
		Colors.add(lblSkinColor);
		
		BODAY = new JTextField();
		lblSkinColor.setLabelFor(BODAY);
		BODAY.setColumns(10);
		Colors.add(BODAY);
		gl_Race.setAutoCreateContainerGaps(true);
		gl_Race.setAutoCreateGaps(true);
		Race.setLayout(gl_Race);
		
		JPanel Stat = new JPanel();
		tabbedPane.addTab("Stat", null, Stat, "Generates JSON text for new Stats.");
		
		JLabel label_2 = new JLabel("Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		StatName = new JTextField();
		label_2.setLabelFor(StatName);
		StatName.setColumns(10);
		
		JLabel lblDetails = new JLabel("Details");
		
		JPanel StatDetails = new JPanel();
		FlowLayout flowLayout = (FlowLayout) StatDetails.getLayout();
		flowLayout.setHgap(11);
		lblDetails.setLabelFor(StatDetails);
		GroupLayout gl_Stat = new GroupLayout(Stat);
		gl_Stat.setHorizontalGroup(
			gl_Stat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Stat.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Stat.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Stat.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(StatName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDetails)
						.addComponent(StatDetails, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(318, Short.MAX_VALUE))
		);
		gl_Stat.setVerticalGroup(
			gl_Stat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Stat.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Stat.createParallelGroup(Alignment.BASELINE)
						.addComponent(StatName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDetails)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(StatDetails, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		
		JLabel lblMinimum = new JLabel("Minimum");
		StatDetails.add(lblMinimum);
		
		StatMinimum = new JTextField();
		lblMinimum.setLabelFor(StatMinimum);
		StatDetails.add(StatMinimum);
		StatMinimum.setColumns(10);
		
		JLabel lblMaximum = new JLabel("Maximum");
		StatDetails.add(lblMaximum);
		
		StatMaximum = new JTextField();
		lblMaximum.setLabelFor(StatMaximum);
		StatDetails.add(StatMaximum);
		StatMaximum.setColumns(10);
		gl_Stat.setAutoCreateGaps(true);
		gl_Stat.setAutoCreateContainerGaps(true);
		Stat.setLayout(gl_Stat);
		
		JPanel Language = new JPanel();
		tabbedPane.addTab("Language", null, Language, "Generates JSON Text for new Languages.");
		Language.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(428, 0, 17, 233);
		Language.add(scrollBar);
		
		JSplitPane splitQuestion_1 = new JSplitPane();
		splitQuestion_1.setDividerSize(0);
		splitQuestion_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitQuestion_1.setBounds(10, 10, 400, 25);
		Language.add(splitQuestion_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		splitQuestion_1.setLeftComponent(lblName_1);
		
		textField = new JTextField();
		splitQuestion_1.setRightComponent(textField);
		textField.setColumns(10);
		splitQuestion_1.setDividerLocation(200);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(0);
		splitPane_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane_1.setBounds(10, 34, 400, 25);
		Language.add(splitPane_1);
		
		JLabel lblGraphicstab = new JLabel("Graphics (tab)");
		lblGraphicstab.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_1.setLeftComponent(lblGraphicstab);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		splitPane_1.setRightComponent(textField_1);
		splitPane_1.setDividerLocation(200);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setDividerSize(0);
		splitPane_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane_2.setBounds(10, 58, 400, 25);
		Language.add(splitPane_2);
		
		JLabel lblLanguagetab = new JLabel("Language (tab)");
		lblLanguagetab.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_2.setLeftComponent(lblLanguagetab);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		splitPane_2.setRightComponent(textField_2);
		splitPane_2.setDividerLocation(200);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setDividerSize(0);
		splitPane_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane_3.setBounds(10, 83, 400, 25);
		Language.add(splitPane_3);
		
		JLabel lblControlstab = new JLabel("Controls (tab)");
		lblControlstab.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_3.setLeftComponent(lblControlstab);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		splitPane_3.setRightComponent(textField_3);
		splitPane_3.setDividerLocation(200);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setDividerSize(0);
		splitPane_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane_4.setBounds(10, 108, 400, 25);
		Language.add(splitPane_4);
		
		JLabel lblSoundtab = new JLabel("Sound (tab)");
		lblSoundtab.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_4.setLeftComponent(lblSoundtab);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		splitPane_4.setRightComponent(textField_4);
		splitPane_4.setDividerLocation(200);
		
		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setDividerSize(0);
		splitPane_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane_5.setBounds(10, 133, 400, 25);
		Language.add(splitPane_5);
		
		JLabel lblResolutiongraphics = new JLabel("Resolution (Graphics)");
		lblResolutiongraphics.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_5.setLeftComponent(lblResolutiongraphics);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		splitPane_5.setRightComponent(textField_5);
		splitPane_5.setDividerLocation(200);
		
		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setDividerSize(0);
		splitPane_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		splitPane_6.setBounds(10, 158, 400, 25);
		Language.add(splitPane_6);
		
		JLabel lblOriginalBetter = new JLabel("Original & Better Images (Graphics)");
		lblOriginalBetter.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_6.setLeftComponent(lblOriginalBetter);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		splitPane_6.setRightComponent(textField_6);
		splitPane_6.setDividerLocation(200);
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.SOUTH);
		txtTesting1.setText("JSON will appear here");
		
		splitPane.setRightComponent(txtTesting1);
		
		JButton btnGenerate = new JButton("Generate");
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(":D");
				JSONApplet r = JSONApplet.this;
				//System.out.println(r.tabbedPane.getSelectedIndex());
				if(r.tabbedPane.getSelectedIndex()==0) {
					JSONObject gen = new JSONObject();
					JSONObject desc = new JSONObject();
					JSONObject stats = new JSONObject(r.StatChanges.getText());
					desc.put("Light Weight", r.MinWeight.getText());
					desc.put("Heavy Weight", r.MaxWeight.getText());
					desc.put("Short Height", r.MinHeight.getText());
					desc.put("Tall Height", r.MaxHeight.getText());
					desc.put("Hair Color", r.Hair.getText());
					desc.put("Child Age", r.Child.getText());
					desc.put("Teen Age", r.Teen.getText());
					desc.put("Adult Age", r.Adult.getText());
					desc.put("Elder Age", r.Elder.getText());
					desc.put("Death Age", r.Death.getText());
					gen.put("Stat Changes", stats);
					gen.put("physicalDescription", desc);
					r.txtTesting1.setText(gen.toString());
				} else if(r.tabbedPane.getSelectedIndex()==1) {
					JSONObject gen = new JSONObject();
					gen.put("Name", r.StatName.getText());
					gen.put("Min", r.StatMinimum.getText());
					gen.put("Max", r.StatMaximum.getText());
					r.txtTesting1.setText(gen.toString());
				} else if(r.tabbedPane.getSelectedIndex()==2) {
					JSONObject lang = new JSONObject();
					lang.put("Name", textField.getText());
					lang.put("Graphics Tab", textField_1.getText());
					lang.put("Language Tab", textField_2.getText());
					lang.put("Controls Tab", textField_3.getText());
					lang.put("Sound Tab", textField_4.getText());
					lang.put("Resolution", textField_5.getText());
					lang.put("Better Images", textField_6.getText());
					r.txtTesting1.setText(lang.toString());
				}
//				r.
			}
		});
		splitPane.setLeftComponent(btnGenerate);


	}
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1357692268391657274L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public JTextField getTextField() {
		return textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JTextField getTextField_2() {
		return textField_2;
	}
	public JTextField getTextField_3() {
		return textField_3;
	}
	public JTextField getTextField_4() {
		return textField_4;
	}
	public JTextField getTextField_5() {
		return textField_5;
	}
	public JTextField getTextField_6() {
		return textField_6;
	}
}
