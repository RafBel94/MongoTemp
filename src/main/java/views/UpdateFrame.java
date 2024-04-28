package views;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class UpdateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public UpdateFrame() {
		super("Actualizar datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		try (InputStream stream = getClass().getResourceAsStream("/resources/image/FrameIcon.png")){
			setIconImage(new ImageIcon(ImageIO.read(stream)).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}

}
