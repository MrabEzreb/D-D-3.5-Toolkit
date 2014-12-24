package com.ezreb.jsongen;

import javax.swing.JApplet;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.FlowLayout;

import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import org.json.JSONObject;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

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
				}
//				r.
			}
		});
		splitPane.setLeftComponent(btnGenerate);


	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
