package Main;

import Presentation.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import java.util.Map;
import java.util.HashMap;


/** <p>This is the Main.KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {
	private static Presentation presentation;
	private static final Map<Integer, Runnable> COMMANDS;

	static {
		COMMANDS = new HashMap<>();
		COMMANDS.put(KeyEvent.VK_PAGE_DOWN, () -> presentation.nextSlide());
		COMMANDS.put(KeyEvent.VK_DOWN, () -> presentation.nextSlide());
		COMMANDS.put(KeyEvent.VK_ENTER, () -> presentation.nextSlide());
		COMMANDS.put((int) '+', () -> presentation.nextSlide());
		COMMANDS.put(KeyEvent.VK_PAGE_UP, () -> presentation.prevSlide());
		COMMANDS.put(KeyEvent.VK_UP, () -> presentation.prevSlide());
		COMMANDS.put((int) '-', () -> presentation.prevSlide());
		COMMANDS.put((int) 'q', () -> System.exit(0));
		COMMANDS.put((int) 'Q', () -> System.exit(0));
	}

	public KeyController(Presentation p) {
		presentation = p;
	}
	public void keyPressed(KeyEvent keyEvent) {
		Runnable command = COMMANDS.get(keyEvent.getKeyCode());
		if (command != null) {
			command.run();
		}
	}
}

/*
Old version of code
 */

//public class Main.KeyController extends KeyAdapter {
//	private Presentation.Presentation presentation; //Commands are given to the presentation
//
//	public Main.KeyController(Presentation.Presentation p) {
//		presentation = p;
//	}
//
//	public void keyPressed(KeyEvent keyEvent) {
//		switch(keyEvent.getKeyCode()) {
//			case KeyEvent.VK_PAGE_DOWN:
//			case KeyEvent.VK_DOWN:
//			case KeyEvent.VK_ENTER:
//			case '+':
//				presentation.nextSlide();
//				break;
//			case KeyEvent.VK_PAGE_UP:
//			case KeyEvent.VK_UP:
//			case '-':
//				presentation.prevSlide();
//				break;
//			case 'q':
//			case 'Q':
//				System.exit(0);
//				break; //Should not be reached
//			default:
//				break;
//		}
//	}
//}
