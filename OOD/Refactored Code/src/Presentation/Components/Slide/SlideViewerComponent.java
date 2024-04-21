package Presentation.Components.Slide;

import Presentation.Presentation;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;


/** <p>Presentation.Components.Slide.SlideViewerComponent is a graphical component that ca display Slides.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent {
	private Slide slide;
	private Presentation presentation;
	private JFrame frame;
	private Font labelFont = null;

	private static final long serialVersionUID = 227L;

	public SlideViewerComponent(Presentation pres, JFrame frame) {
		setBackground(SlideViewerColors.BACKGROUND_COLOR);
		presentation = pres;
		labelFont = new Font(SlideViewerFonts.FONT_NAME, SlideViewerFonts.FONT_STYLE, SlideViewerFonts.FONT_HEIGHT);
		this.frame = frame;
	}

	public Dimension getPreferredSize() {
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	public void update(Presentation presentation, Slide data) {
		if (data == null) {
			repaint();
			return;
		}
		this.presentation = presentation;
		this.slide = data;
		repaint();
		frame.setTitle(presentation.getTitle());
	}

	public void paintComponent(Graphics g) {
		g.setColor(SlideViewerColors.BACKGROUND_COLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);
		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}
		g.setFont(labelFont);
		g.setColor(SlideViewerColors.FOREGROUND_COLOR);
		g.drawString(
				"Slide " + (1 + presentation.getSlideNumber()) + " of " + presentation.getSize(),
				SlideViewerPosition.X_POSITION, SlideViewerPosition.Y_POSITION
		);
		Rectangle area = new Rectangle(0, SlideViewerPosition.Y_POSITION, getWidth(), (getHeight() - SlideViewerPosition.Y_POSITION));
		slide.draw(g, area, this);
	}
}

/*
Old version of code
 */

//public class Presentation.Components.Slide.SlideViewerComponent extends JComponent {
//
//	private Presentation.Components.Slide.Slide slide; //The current slide
//	private Font labelFont = null; //The font for labels
//	private Presentation.Presentation presentation = null; //The presentation
//	private JFrame frame = null;
//
//	private static final long serialVersionUID = 227L;
//
//	private static final Color BGCOLOR = Color.white;
//	private static final Color COLOR = Color.black;
//	private static final String FONTNAME = "Dialog";
//	private static final int FONTSTYLE = Font.BOLD;
//	private static final int FONTHEIGHT = 10;
//	private static final int XPOS = 1100;
//	private static final int YPOS = 20;
//
//	public Presentation.Components.Slide.SlideViewerComponent(Presentation.Presentation pres, JFrame frame) {
//		setBackground(BGCOLOR);
//		presentation = pres;
//		labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
//		this.frame = frame;
//	}
//
//	public Dimension getPreferredSize() {
//		return new Dimension(Presentation.Components.Slide.Slide.WIDTH, Presentation.Components.Slide.Slide.HEIGHT);
//	}
//
//	public void update(Presentation.Presentation presentation, Presentation.Components.Slide.Slide data) {
//		if (data == null) {
//			repaint();
//			return;
//		}
//		this.presentation = presentation;
//		this.slide = data;
//		repaint();
//		frame.setTitle(presentation.getTitle());
//	}
//
////Draw the slide
//	public void paintComponent(Graphics g) {
//		g.setColor(BGCOLOR);
//		g.fillRect(0, 0, getSize().width, getSize().height);
//		if (presentation.getSlideNumber() < 0 || slide == null) {
//			return;
//		}
//		g.setFont(labelFont);
//		g.setColor(COLOR);
//		g.drawString("Presentation.Components.Slide.Slide " + (1 + presentation.getSlideNumber()) + " of " +
//                 presentation.getSize(), XPOS, YPOS);
//		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
//		slide.draw(g, area, this);
//	}
//}
