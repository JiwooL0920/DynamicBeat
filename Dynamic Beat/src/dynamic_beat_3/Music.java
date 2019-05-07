package dynamic_beat_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

//Thread is a small program within a program
public class Music extends Thread {
	private Player player; 
	private boolean isLoop;
	private File file;
	private FileInputStream fls;
	private BufferedInputStream bis;
	
//	public Music(String name, boolean isLoop) {
//		try {
//			this.isLoop = isLoop;
//			file = new File(Main.class.getResource("../music/" + name).toURI()); 
//			fls = new FileInputStream(file);
//			bis = new BufferedInputStream(fls);
//			player = new Player(bis);
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//	public int getTime() {
//		if (player == null) {
//			return 0;
//		}
//		return player.getPosition();
//	}
//	
//	public void close() {
//		isLoop = false;
//		player.close();
//		this.interrupt();
//	}
//	
////	@override
//	public void run() {
//		try {
//			do {
//				player.play();
//				fls = new FileInputStream(file);
//				bis = new BufferedInputStream(fls);
//				player = new Player(bis);
//			} while (isLoop);	
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	
//	}

}
