package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import views.MainFrame;
import views.MapFrame;

public class MapFrameController {
	private MapFrame mapFrame;
	
	public MapFrameController(MapFrame mapFrame) {
		this.mapFrame = mapFrame;
		
		mapFrame.addActListener(new ActListener());
		mapFrame.addItmListener(new ItmListener());
	}
	
	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == mapFrame.getBtnVolver()) {
				mapFrame.dispose();
				new MainFrame();
			}else if(obj == mapFrame.getBtnContinuar()) {
				JOptionPane.showMessageDialog(mapFrame, "Todavia por implementar =^P");
			}
		}
	}
	
	private class ItmListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
		}
	}
}
