package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import views.MapFrame;
import views.QueryFrame;

public class QueryFrameController {
	private QueryFrame qFrame;

	public QueryFrameController(QueryFrame qFrame) {
		this.qFrame = qFrame;
		
		this.qFrame.addActListener(new ActListener());
		this.qFrame.addItmListener(new ItmListener());
	}
	
	private class ActListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			
			if(obj == qFrame.getBtnVolver()) {
				qFrame.dispose();
				new MapFrame();
			}else if (obj == qFrame.getBtnConsultar()) {
				
			}else if (obj == qFrame.getBtnAyuda()) {
				
			}
		}
	}
	
	private class ItmListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			JComboBox combo = (JComboBox) e.getSource();
		}
	}
}
