package zframe;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class AutoClicker {
	
	private Robot robot;
	// delay between clicks in ms
	private int delay;
	
	boolean run = false;
	
	public AutoClicker(){
		try{
			robot = new Robot();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		delay = 100;
	}
	
	public void setDelay(int ms){
		this.delay = ms;
	}
	
	List<String> keys = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"); 
//			"slash", "back_slash", "quote", "braceleft", "braceright", "back_quote", "colon", "comma");
	
	//total 10+26+8 (44)
	
	public void RunOnThread() {
		Thread t1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				while(run==true) {
					clickMouse(InputEvent.BUTTON1_MASK);
					robot.delay(delay);
//					Thread.sleep(delay);
				}
				
			}
		});
	    
		t1.start();
	}
	
	public void clickMouse(int button) {
		try{
			for(String tkey : keys) {
		        String code = "VK_" + tkey.toUpperCase();

		        Field f = KeyEvent.class.getField(code);
		        int keyEvent = f.getInt(null);
		        
//			        robot.keyPress(KeyEvent.);
				robot.keyPress(keyEvent);
				robot.keyRelease(keyEvent);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}