import java.io.IOException;


public class Application {
	private Window window;
	private ImageHandler imgH;
	public static String[] chars = new String[] {"88","UU","LL","||","..","  "};
	//public static String[] chars = new String[] {"88","$$","UU","LL","ll","||","| ",", ",". ","  "};
	
	public Application () {
		window = new Window(this);
		window.setVisible(true);
		imgH = new ImageHandler(this);
	}

	public void openImage() {
		window.setImage(imgH.openImage());		
	}
	
	public static void main(String[] args) {
		Application app = new Application();
	}

	public void calculateAscii(int i) {
		try {
			window.setAscii(imgH.getAscii(i));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setProgress(String str) {
		window.setProgress(str);
	}
	
	public void setProgress(int prc) {
		window.setProgress(prc);
	}
	
	public void charDemo() {
		StringBuilder ascii = new StringBuilder();
		for (String s : chars) {
			for (int i = 1; i < 5000; i++) {
				ascii.append(s);
				if (i%500==0) {
					ascii.append(System.getProperty("line.separator"));
				}
			}
			ascii.append(System.getProperty("line.separator"));
			ascii.append(System.getProperty("line.separator"));
		}
		window.setAscii(ascii.toString());
	}
}
