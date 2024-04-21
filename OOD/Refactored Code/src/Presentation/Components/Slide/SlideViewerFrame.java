package Presentation.Components.Slide;

import Main.*;
import Main.Menu.MenuController;
import Presentation.Presentation;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * <p>The applicatiewindow for a slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class SlideViewerFrame extends JFrame {
	private static final long serialVersionUID = 3227L;
	private static final String JABBERPOINT_TITLE = "Jabberpoint 1.6 - OU";
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 800;

	private final Presentation presentation;
	private final SlideViewerComponent slideViewerComponent;

	public SlideViewerFrame(String title, Presentation presentation) {
		super(title);
		this.presentation = presentation;
		this.slideViewerComponent = new SlideViewerComponent(presentation, this);
		presentation.setShowView(slideViewerComponent);
		setupWindow();
	}

	private void setupWindow() {
		setTitle(JABBERPOINT_TITLE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(slideViewerComponent);
		addKeyListener(new KeyController(presentation));
		setMenuBar(new MenuController(this, presentation));
		setSize(new Dimension(WIDTH, HEIGHT));
		setVisible(true);
	}
}

/*
Old version of code
 */

//public class Presentation.Components.Slide.SlideViewerFrame extends JFrame {
//	private static final long serialVersionUID = 3227L;
//
//	private static final String JABTITLE = "Jabberpoint 1.6 - OU";
//	public final static int WIDTH = 1200;
//	public final static int HEIGHT = 800;
//
//	public Presentation.Components.Slide.SlideViewerFrame(String title, Presentation.Presentation presentation) {
//		super(title);
//		Presentation.Components.Slide.SlideViewerComponent slideViewerComponent = new Presentation.Components.Slide.SlideViewerComponent(presentation, this);
//		presentation.setShowView(slideViewerComponent);
//		setupWindow(slideViewerComponent, presentation);
//	}
//
////Setup the GUI
//	public void setupWindow(Presentation.Components.Slide.SlideViewerComponent
//			slideViewerComponent, Presentation.Presentation presentation) {
//		setTitle(JABTITLE);
//		addWindowListener(new WindowAdapter() {
//				public void windowClosing(WindowEvent e) {
//					System.exit(0);
//				}
//			});
//		getContentPane().add(slideViewerComponent);
//		addKeyListener(new Main.KeyController(presentation)); //Add a controller
//		setMenuBar(new Main.Menu.MenuController(this, presentation));	//Add another controller
//		setSize(new Dimension(WIDTH, HEIGHT)); //Same sizes a slide has
//		setVisible(true);
//	}
//}
