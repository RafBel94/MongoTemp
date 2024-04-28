package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import views.AdminFrame;
import views.MainFrame;
import views.MapFrame;
import views.QueryFrame;

public class MapFrameController {
	private static List<JCheckBox> cbxList = new ArrayList<>();
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
				if(mapFrame.getLastFrame() instanceof MainFrame)
					new MainFrame();
				else if (mapFrame.getLastFrame() instanceof AdminFrame)
					new AdminFrame();
			}else if(obj == mapFrame.getBtnContinuar()) {
				if(cbxList.isEmpty())
					JOptionPane.showMessageDialog(mapFrame, "No se ha seleccionado ninguna provincia", "Error",JOptionPane.ERROR_MESSAGE);
				else {
					mapFrame.dispose();
					new QueryFrame(mapFrame.getLastFrame());
				}
			}else if(obj == mapFrame.getBtnTodo()) {
				selectAll();
			}else if(obj == mapFrame.getBtnNada()) {
				deselectAll();
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
	
	public static List<JCheckBox> getJCheckBoxList (){
		return cbxList;
	}
	
	private void selectAll() {
		for(JCheckBox cbx : mapFrame.getAllJCheckBox()) {
			cbx.setSelected(true);
		}
	}
	
	private void deselectAll() {
		for(JCheckBox cbx : mapFrame.getAllJCheckBox()) {
			cbx.setSelected(false);
		}
	}
}
