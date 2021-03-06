package dynamic_beat_6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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

	// retrieve background.jpg and put into background variable
	// Having Main.class as a reference point get the resource from file path; reset
	// variable background to that file
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Cool Start Image.png")).getImage(); 																									
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage(); 																									
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png"))); 
	
	//Buttons	
	//Exit Button
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("/images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage); //basic default button is exitButtonBasicImage

	//Start Button
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("/images/startButtonBasic.png"));
	private JButton startButton = new JButton(startButtonBasicImage);
	
	//Quit Button
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("/images/quitButtonBasic.png"));
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	//Left Button
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("/images/leftButtonBasic.png"));
	private JButton leftButton = new JButton(leftButtonBasicImage);
	
	//Right Button
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("/images/rightButtonBasic.png"));
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	//Title Image
	private Image titleImage = new ImageIcon(Main.class.getResource("/images/Cool Title Image.png")).getImage();


	//Make the screen move when we drag menu bar
	private int mouseX, mouseY;
	
	//Screen
	private boolean isMainScreen = false; //initially not on main screen therefore false
	
	
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

		//Exit button
		//Notice that the exit button must be declared before menu bar so that it gets placed on top of the menu bar
		exitButton.setBounds(1245, 0, 30, 30); //put exit button on the rightmost side of the menu bar
		exitButton.setBorderPainted(false); //need to set JButton so that it fits our button image
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			//@Override
			//When mouse is on top of the exit button
			public void mouseEntered(MouseEvent e) { 
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //change the icon of the mouse cursor 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
			}
			//When mouse gets out of the exit button
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//When exit button is pressed
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
				//In order to prevent music not being heard (becaue the program exits immediately, make it so that the program 
				//terminates 1 sec later the music plays
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //exit the game
			}
		});
		add(exitButton);
		
		//Start Button
		startButton.setBounds(40, 200, 400, 100); 
		startButton.setBorderPainted(false); 
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseEntered(MouseEvent e) { 
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //change the icon of the mouse cursor 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
			}
			//When mouse gets out of the exit button
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//When button is pressed
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
				//Game Start Event--come back later
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		//Quit Button
		quitButton.setBounds(40, 330, 400, 100); 
		quitButton.setBorderPainted(false); 
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseEntered(MouseEvent e) { 
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //change the icon of the mouse cursor 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
			}
			//When mouse gets out of the exit button
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//When quit button is pressed
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); //exit the game
			}
		});
		add(quitButton);
		
		//Left Button
		leftButton.setVisible(false); //make it so that it's not visible in the beginning
		leftButton.setBounds(140, 310, 60, 60); 
		leftButton.setBorderPainted(false); 
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseEntered(MouseEvent e) { 
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //change the icon of the mouse cursor 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
				//Left Button Event
				
			}
		});
		add(leftButton);
		
		//Right Button
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); 
		rightButton.setBorderPainted(false); 
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseEntered(MouseEvent e) { 
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //change the icon of the mouse cursor 
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false); //play only once
				buttonEnteredMusic.start();
				//Right Button Event
				
			}
		});
		add(rightButton);
		
		//Menubar
		menuBar.setBounds(0, 0, 1280, 30); // declares position and size of menubar
		menuBar.addMouseListener(new MouseAdapter() {
//			@Override
			public void mousePressed(MouseEvent e) { //when a mouse event occurs, retrieve the x and y coordinates of the mouse
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			//@Override
			public void mouseDragged(MouseEvent e) { // whenever mouse is dragged, get x,y position of the mouse and move the screen accordingly
				int x = e.getXOnScreen(); 
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar); // adds menubar to jframe

		

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
		g.drawImage(background, 0, 0, null); //generally, we use drawImage to draw moving images
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g); // draws the images in the screen image (menubar stays constant; doesn't change. therefore use paintcomponent not drawimage), draws all the "add()" components
		this.repaint(); // calling the paint method again
		// Way this works: the computer paints the screen at every moment until the
		// program terminates
	}

}
