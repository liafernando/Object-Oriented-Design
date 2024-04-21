package Main.Menu;

import Main.AboutBox;
import Presentation.Presentation;
import Services.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */


public class MenuController extends MenuBar {
	protected static final String TEST_FILE = "testPresentation.xml";
	protected static final String FILE_NAME = "savedPresentation.xml";
	protected static final String IO_EXCEPTION = "IO Exception: ";
	protected static final String LOAD_ERROR = "Load Error";
	protected static final String SAVE_ERROR = "Save Error";
	private Frame parent; //The frame, only used as parent for the Dialogs
	private Presentation presentation; //Commands are given to the presentation

	public MenuController(Frame frame, Presentation pres) {
		parent = frame;
		presentation = pres;
		MenuItem menuItem;
		Menu fileMenu = new Menu(MenuAction.FILE);
		fileMenu.add(menuItem = mkMenuItem(MenuDirection.OPEN));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.clear();
				XMLAccessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.loadFile(presentation, TEST_FILE);
					presentation.setSlideNumber(0);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exc,
         			LOAD_ERROR, JOptionPane.ERROR_MESSAGE);
				}
				parent.repaint();
			}
		} );
		fileMenu.add(menuItem = mkMenuItem(MenuAction.NEW));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.clear();
				parent.repaint();
			}
		});
		fileMenu.add(menuItem = mkMenuItem(MenuAction.SAVE));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XMLAccessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.saveFile(presentation, MenuAction.SAVE);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IO_EXCEPTION + exc,
							SAVE_ERROR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(menuItem = mkMenuItem(MenuAction.EXIT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.exit(0);
			}
		});
		add(fileMenu);
		Menu viewMenu = new Menu(MenuDirection.VIEW);
		viewMenu.add(menuItem = mkMenuItem(MenuDirection.NEXT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.nextSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(MenuDirection.PREVIOUS));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.prevSlide();
			}
		});
		viewMenu.add(menuItem = mkMenuItem(MenuDirection.GO_TO));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)MenuDirection.PAGE_NUMBER);
				int pageNumber = Integer.parseInt(pageNumberStr);
				presentation.setSlideNumber(pageNumber - 1);
			}
		});
		add(viewMenu);
		Menu helpMenu = new Menu(MenuHelp.HELP);
		helpMenu.add(menuItem = mkMenuItem(MenuHelp.ABOUT));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(parent);
			}
		});
		setHelpMenu(helpMenu);//Needed for portability (Motif, etc.).
	}

//Creating a menu-item
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
