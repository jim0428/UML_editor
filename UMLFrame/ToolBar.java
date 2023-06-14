package UMLFrame;

import javax.swing.*;

import UMLCreator.CanvasSingleton;
import UMLCreator.CreateLine;
import UMLCreator.CreateShape;
import UMLCreator.Mode;
import UMLCreator.SelectMode;
import UMLFrame.Canvas;
import UMLObject.UseCase;

import java.awt.*;
import java.awt.event.*;

public class ToolBar extends JToolBar{
	private JPanel myJPanel;
	private final int toolbarCounts = 6; 
	private JButton button;
	private JButton selectedBtn = null;
	
	private Color selectCol = new Color(0, 0, 0);
	private Color originCol = new Color(255,255,255);
    
	private Canvas canvas;
	
	public ToolBar(){
		canvas =  CanvasSingleton.getCanvas();
		
		myJPanel = new JPanel();
		
        // Add components to left panel
		myJPanel.setLayout(new GridLayout(toolbarCounts,1));
        
		
		button = new ButtonItem("img/select.png",selectCol,new SelectMode());
		selectedBtn = button;
		canvas.setCurrentListener(new SelectMode());
		myJPanel.add(button);
		
		button = new ButtonItem("img/associationLine.png",originCol,new CreateLine("association"));
		myJPanel.add(button);
		
		button = new ButtonItem("img/generalizationLine.png",originCol,new CreateLine("general"));
		myJPanel.add(button);
		
		button = new ButtonItem("img/compositionLine.png",originCol,new CreateLine("composition"));
		myJPanel.add(button);
		
		button = new ButtonItem("img/class.png",originCol,new CreateShape("class"));
		myJPanel.add(button);
		
		button = new ButtonItem("img/useCase.png",originCol,new CreateShape("usecase"));
		myJPanel.add(button);
		
	}
	
	private class ButtonItem extends JButton {
		Mode btnMode;
		public ButtonItem(String url,Color color,Mode btnMode){
			this.setBackground(color);
			
			this.setIcon(new ImageIcon(getClass().getResource(url)));
			
			this.btnMode = btnMode;
			
			this.addActionListener(new setListener());		
		}
		
		private class setListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedBtn != null)
					selectedBtn.setBackground(originCol);
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(selectCol);
				canvas.setCurrentListener(btnMode);
			}
		}
	}
	
	public JPanel getPanel() {
		return myJPanel;
	}

    public JButton getCurrentMode() {
    	return selectedBtn;
    } 	
    
 
	
}
