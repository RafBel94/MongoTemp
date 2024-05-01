package util;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageLoader {
	public static void loadFrameIcon(String path, JFrame frame) {
		try(InputStream inputStream = frame.getClass().getResourceAsStream(path)){
			frame.setIconImage(new ImageIcon(ImageIO.read(inputStream)).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadJLabelImage(String path, JFrame frame, JLabel label) {
		try(InputStream inputStream = frame.getClass().getResourceAsStream(path)){
			label.setIcon(new ImageIcon(ImageIO.read(inputStream)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadJButtonImage(String path, JFrame frame, JButton button) {
		try(InputStream inputStream = frame.getClass().getResourceAsStream(path)){
			button.setIcon(new ImageIcon(ImageIO.read(inputStream)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
