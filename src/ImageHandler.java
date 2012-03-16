import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class ImageHandler {
	private BufferedImage img;
	private Application app;
	
	public ImageHandler(Application app) {
		this.app = app;
	}

	public BufferedImage openImage() {
		JFileChooser fc = new JFileChooser("C:\\Users\\Public\\Pictures\\Sample Pictures");
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			  	try {
					img = ImageIO.read(fc.getSelectedFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return img;
	}
	
	public String getAscii(int precision) throws IOException {
		int i,j;
		File out = new File("c:\\manyfiles\\img_out.txt");
		StringBuilder ascii = new StringBuilder();
		app.setProgress("Calculation Ascii Graphic");
		for (i = 0; i < img.getHeight(); i = i + precision) {
			for (j = 0; j < img.getWidth(); j = j + precision) {
				Color col = new Color(img.getRGB(j, i));
				float h = Color.RGBtoHSB(col.getRed(), col.getGreen(), col.getBlue(), null)[2];
				for (int c = 0; c < Application.chars.length; c++) {
					if (h <= (c + 1) * (1.0 / Application.chars.length)) {
						ascii.append(Application.chars[c]);
						break;
					}
				}
			}
			ascii.append(System.getProperty("line.separator"));
			app.setProgress((int) (i * 1.0 / img.getHeight() * 100));
		}
		app.setProgress((int) (100));
		return ascii.toString();
	}
//}
}
