package views;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AboutFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel labelLogo;
	/**
	 * Create the dialog.
	 */
	public AboutFrame() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Sobre el equipo");
		setBounds(100, 100, 450, 421);
		setLocationRelativeTo(getParent());
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(null);
		
		labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("image/LogoAbout.png"));
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setBounds(62, 11, 310, 312);
		getContentPane().add(labelLogo);
		
		setVisible(true);
	}
}
