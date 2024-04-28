package views;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
		
		try (InputStream stream = getClass().getResourceAsStream("/resources/image/FrameIcon.png")){
			setIconImage(new ImageIcon(ImageIO.read(stream)).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		labelLogo = new JLabel("");
		try(InputStream stream = getClass().getResourceAsStream("/resources/image/LogoAbout.png")){
			labelLogo.setIcon(new ImageIcon(ImageIO.read(stream)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setBounds(62, 11, 310, 312);
		getContentPane().add(labelLogo);
		
		setVisible(true);
	}
}
