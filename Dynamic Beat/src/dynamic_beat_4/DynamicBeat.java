package dynamic_beat_4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// JFrame -> needed in order to develop GUI based applications in Java
// Inherit an already existing Library(class) in Java

public class DynamicBeat extends JFrame {

	/*
	 * Double Buffering Technique -in Java, if you show an image on the screen, you
	 * might have buffering problems -to avoid this, use the double buffering
	 * technique -In computer science, multiple buffering is the use of more than
	 * one buffer to hold a block of data, so that a "reader" will see a complete
	 * (though perhaps old) version of the data, rather than a partially updated
	 * version of the data being created by a "writer". It also is used to avoid the
	 * need to use dual-ported RAM (DPRAM) when the readers and writers are
	 * different devices.
	 */

	// Instances needed for double buffering technique
	private Image screenImage;
	private Graphics screenGraphic;

	// retrieve introBackground.jpg and put into introBackground variable
	// Having Main.class as a reference point get the resource from file path; reset
	// variable introBackground to that file
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage(); // tutorial																										// has																												// me??
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png"))); 

	//Buttons
//	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("/images/exitButtonBasic.png")));

	// DynamicBeat() is a constructor
	// Constructor is a method that has the same name as the class
	// A constructor in Java is a special method that is used to initialize objects.
	// The constructor is called when
	// an object of a class is created. It can be used to set initial values for
	// object attributes
	public DynamicBeat() {
		setUndecorated(true); // when first executed, menubar doesn't show
		setTitle("Dynamic Beat"); // the name of our game becomes "Dynamic Beat"
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // user cannot redefine the screen size
		setLocationRelativeTo(null); // when you run the project, the screen will appear right on the centre of the
										// screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // need to declare this; otherwise the program continues to run
														// in computer even after we close screen
		setVisible(true); // make the screen visible
		setBackground(new Color(0, 0, 0, 0)); // paintcomponent changes to white
		setLayout(null); // button and layout gets located right on spot we declared

		menuBar.setBounds(0, 0, 1280, 30); // declares position and size of menubar
		add(menuBar); // adds menubar to jframe

//		exitButton.setBounds(50, 50, 30, 30);
//		add(exitButton);

		// Add intro music
		Music introMusic = new Music("intromusic.mp3", true);
		introMusic.start();

	}

	// Methods
	// 1) Paint method
	// Extend JFrame class to create your own frame class so that you can override
	// the paint() method.
	// The paint() method provides you a Graphics object, which will give you
	// utility methods to draw various types of graphics.
	// The paint() method is inherited by JFrame class from the Component class. It
	// will be called whenever this component should be painted.
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // create image by the screen size
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // draw the image we want on the screen
		g.drawImage(screenImage, 0, 0, null); // draw screenImage at point (0,0)
	}

	// 2) screenDraw method
	// There are two ways to draw: drawimage and paintcomponents
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g); // draws the images in the screen image (menubar stays constant; doesn't change. therefore use paintcomponent not drawimage)
		this.repaint(); // calling the paint method again
		// Way this works: the computer paints the screen at every moment until the
		// program terminates
	}

}
