package UMLFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBar extends JMenuBar {
	Canvas canvas = Canvas.getCanvas();
	
	private JMenuBar menuBar;
	
	private JMenu menu_file,menu_edit;
	private JMenuItem chg_name, gp, ugp;
	
	public MenuBar() {
		menuBar = new JMenuBar();
			
		/* --- File menu --- */
		menu_file = new JMenu("File");
		menuBar.add(menu_file);

		/* --- Edit menu --- */
		menu_edit = new JMenu("Edit");
		menuBar.add(menu_edit);
		
		chg_name = new JMenuItem("Change object name");
		chg_name.addActionListener(new ChgName());
		menu_edit.add(chg_name);
		
		
		gp = new JMenuItem("Group");
		gp.addActionListener(new GroupFunc());
		menu_edit.add(gp);
	
		
		ugp = new JMenuItem("Ungroup");
		ugp.addActionListener(new UnGroupFunc());
		menu_edit.add(ugp);
			
		menuBar.add(menu_edit);
	}
	
	private class ChgName implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			canvas.chgName();
		}
	}
	
	private class GroupFunc implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			canvas.toGroup();
		}
	}
	
	private class UnGroupFunc implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			canvas.unGroup();
		}
	}
	
//	public void addListener(Canvas can) {
//		
//		chg_name.addActionListener(new ActionListener() {
//	        @Override
//	        public void actionPerformed(ActionEvent e) {
//	        	can.setColor(Color.BLACK);
//	        }
//	     });
//		
//	}
	
	public JMenuBar getJmenu(){
		return menuBar;
	}
	
	
}
