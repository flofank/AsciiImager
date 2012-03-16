import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.border.Border;
import javax.swing.UIManager;


public class Window extends JFrame{
	private Container cp;
	private Application app;
	private JLabel lblImg;
	private JTextArea lblAscii;
	private JLabel lblProg;
	private JProgressBar progressBar;
	private JSpinner spinner;
	
	public Window(Application app) {
		super();
		this.app = app;
		initialize();
	}
	
	public void setImage(BufferedImage img) {
		Image img2 = img.getScaledInstance(lblImg.getSize().width, lblImg.getSize().height, Image.SCALE_FAST);
		lblImg.setIcon(new ImageIcon(img2));
	}
	
	public void setAscii(String Ascii) {
		lblAscii.setText(Ascii);
	}
	
	public void setProgress(String str) {
		lblProg.setText(str);
		lblProg.paint(lblProg.getGraphics());
	}
	
	public void setProgress(int prc) {
		progressBar.setValue(prc);
		progressBar.paint(progressBar.getGraphics());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cp = getContentPane();
		setBounds(50, 50, 1163, 706);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setLayout(null);
		
		lblImg = new JLabel();
		lblImg.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblImg.setBounds(10, 11, 270, 210);
		lblImg.setOpaque(true);
		cp.add(lblImg);
		
		
		lblAscii = new JTextArea();
		lblAscii.setBackground(null);
		lblAscii.setFont(new Font("Lucida Console", Font.PLAIN, 1));
		lblAscii.setForeground(Color.BLACK);
		lblAscii.setBounds(334, 11, 800, 600);
		lblAscii.setEditable(false);
		lblAscii.setOpaque(true);
		JScrollPane scroll = new JScrollPane(lblAscii);
		scroll.setBounds(334, 11, 800, 600);
		cp.add(scroll);
		
		JButton btnCreateASCII = new JButton("Create ASCII");
		btnCreateASCII.setBounds(10, 263, 137, 23);
		getContentPane().add(btnCreateASCII);
		
		progressBar = new JProgressBar();
		progressBar.setToolTipText("");
		progressBar.setBounds(334, 613, 640, 14);
		getContentPane().add(progressBar);
		
		lblProg = new JLabel("");
		lblProg.setBounds(334, 626, 356, 23);
		getContentPane().add(lblProg);
		
		spinner = new JSpinner(new SpinnerNumberModel(5,1,50,1));
		spinner.setBounds(99, 232, 48, 20);
		getContentPane().add(spinner);
		
		JLabel lblPrecision = new JLabel("Precision:");
		lblPrecision.setBounds(11, 232, 90, 20);
		getContentPane().add(lblPrecision);
		
		JButton btnCharDemo = new JButton("Char Demo");
		btnCharDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.charDemo();
			}
		});
		btnCharDemo.setBounds(10, 297, 137, 23);
		getContentPane().add(btnCharDemo);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpenImage = new JMenuItem("Open Image");
		mnFile.add(mntmOpenImage);
		
		mntmOpenImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.openImage();
			}
		});
		
		btnCreateASCII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.calculateAscii(Integer.parseInt(spinner.getValue().toString()));
			}
		});
	}
}
