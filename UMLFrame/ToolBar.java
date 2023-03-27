package UMLFrame;

import javax.swing.*;

import UMLFrame.Canvas;
import UMLObject.CreateClassObject;
import UMLObject.CreateLineObject;
import UMLObject.CreateUseCaseObject;
import UMLObject.Mode;
import UMLObject.SelectMode;
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
		canvas = Canvas.getCanvas();
		
		myJPanel = new JPanel();
		
        // Add components to left panel
		myJPanel.setLayout(new GridLayout(toolbarCounts,1));
        
		button = new ButtonItem("img/select.png",new SelectMode());
		myJPanel.add(button);
		
		button = new ButtonItem("img/associationLine.png",new CreateLineObject());
		myJPanel.add(button);
		
		button = new ButtonItem("img/generalizationLine.png",new CreateClassObject());
		myJPanel.add(button);
		
		button = new ButtonItem("img/compositionLine.png",new CreateClassObject());
		myJPanel.add(button);
		
		button = new ButtonItem("img/class.png",new CreateClassObject());
		myJPanel.add(button);
		
		button = new ButtonItem("img/useCase.png",new CreateUseCaseObject());
		myJPanel.add(button);
		
	}
	
	private class ButtonItem extends JButton {
		Mode btnMode;
		public ButtonItem(String url,Mode btnMode){
			this.setBackground(originCol);
			
			this.setIcon(new ImageIcon(getClass().getResource(url)));
			
			this.addActionListener(new chg_bgd_col());
		
			this.btnMode = btnMode;
			
		}
		
		private class chg_bgd_col implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(selectedBtn != null)
					selectedBtn.setBackground(new Color(255,255,255));
				selectedBtn = (JButton) e.getSource();
				selectedBtn.setBackground(selectCol);
				canvas.setCurrentMode(btnMode);
				canvas.setCurrentListener();
			}
		}
	}
	
	public JPanel getPanel() {
		return myJPanel;
	}

    public JButton getCurrentMode() {
    	return selectedBtn;
    } 	
    
 
    
//	public void addListener(Canvas can) {
//		
//		selectedBtn.addActionListener(new ActionListener() {
//	        @Override
//	        public void actionPerformed(ActionEvent e) {
//	        	can.setColor(Color.BLACK);
//	        }
//	     });
//	}
	
}
