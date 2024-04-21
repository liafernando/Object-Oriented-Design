package Presentation.Components.Slide;

import Presentation.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/** <p>The abstract class for items on a slide.<p>
 * <p>All SlideItems have drawing capabilities.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public abstract class SlideItem {
	private int itemLevel;

	public SlideItem(int lev) {
		itemLevel = lev;
	}

	public SlideItem() {
		this(0);
	}

	public int getItemLevel() {
		return itemLevel;
	}

	public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

	public abstract void drawImage(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);
}

/*
Old version of code
 */

//public abstract class Presentation.Components.Slide.SlideItem {
//	private int itemLevel = 0; //The level of the Presentation.Components.Slide.SlideItem
//
//	public Presentation.Components.Slide.SlideItem(int lev) {
//		itemLevel = lev;
//	}
//
//	public Presentation.Components.Slide.SlideItem() {
//		this(0);
//	}
//
////Returns the level
//	public int getItemLevel() {
//		return itemLevel;
//	}
//
////Returns the bounding box
//	public abstract Rectangle getBoundingBox(Graphics g,
//			ImageObserver observer, float scale, Presentation.Style style);
//
////Draws the item
//	public abstract void drawImage(int x, int y, float scale,
//								   Graphics g, Presentation.Style style, ImageObserver observer);
//}
