package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import views.MainFrame;
import views.MapFrame;
import views.QueryFrame;

public class MapFrameController {
	private List<JCheckBox> cbxList = new ArrayList<>();
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
				mapFrame.dispose();
				new QueryFrame(cbxList);
			}
		}
	}
	
	private class ItmListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox cbx = (JCheckBox) e.getSource();
			if(!cbxList.contains(cbx))
				cbxList.add(cbx);
			else
				cbxList.remove(cbx);
		}
	}
}
