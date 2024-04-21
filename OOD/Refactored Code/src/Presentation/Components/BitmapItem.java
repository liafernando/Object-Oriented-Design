package Presentation.Components;

import Presentation.Components.Slide.SlideItem;
import Presentation.Style;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;

import java.io.IOException;


/** <p>The class for a Bitmap item</p>
 * <p>Bitmap items are responsible for drawing themselves.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/


public class BitmapItem extends SlideItem {
	private BufferedImage bufferedImage;
	private String imageName;
	private static final String FILE_NOT_FOUND_MESSAGE = "File %s not found";

	private int itemLevel;
	//level indicates the item-level; name indicates the name of the file with the image
	public BitmapItem(int itemLevel, String fileName) {
		super(itemLevel);
		imageName = fileName;
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			System.err.println(String.format(FILE_NOT_FOUND_MESSAGE, imageName));
		}
	}

	//An empty bitmap item
	public BitmapItem() {
		this(0, null);
	}

	//Returns the filename of the image
	public String getName() {
		return imageName;
	}

	//Returns the bounding box of the image
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
		return new Rectangle((int) (myStyle.indent * scale), 0,
				(int) (bufferedImage.getWidth(observer) * scale),
				((int) (myStyle.leading * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
	}

	//Draws the image
	public void drawImage(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
		int width = x + (int) (myStyle.indent * scale);
		int height = y + (int) (myStyle.leading * scale);
		g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
				(int) (bufferedImage.getHeight(observer) * scale), observer);
	}

	@Override
	public String toString() {
		return String.format("Presentation.Components.BitmapItem[%d,%s]", getItemLevel(), imageName);
	}
}

/*
Old version of code
 */

//public class Presentation.Components.BitmapItem extends Presentation.Components.Slide.SlideItem {
//  private BufferedImage bufferedImage;
//  private String imageName;
//
//  protected static final String FILE = "File ";
//  protected static final String NOTFOUND = " not found";
//
//
//  	//level indicates the item-level; name indicates the name of the file with the image
//	public Presentation.Components.BitmapItem(int level, String name) {
//		super(level);
//		imageName = name;
//		try {
//			bufferedImage = ImageIO.read(new File(imageName));
//		}
//		catch (IOException e) {
//			System.err.println(FILE + imageName + NOTFOUND) ;
//		}
//	}
//
//	//An empty bitmap item
//	public Presentation.Components.BitmapItem() {
//		this(0, null);
//	}
//
//	//Returns the filename of the image
//	public String getName() {
//		return imageName;
//	}
//
//	//Returns the bounding box of the image
//	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Presentation.Style myStyle) {
//		return new Rectangle((int) (myStyle.indent * scale), 0,
//				(int) (bufferedImage.getWidth(observer) * scale),
//				((int) (myStyle.leading * scale)) +
//				(int) (bufferedImage.getHeight(observer) * scale));
//	}
//
//	//Draws the image
//	public void draw(int x, int y, float scale, Graphics g, Presentation.Style myStyle, ImageObserver observer) {
//		int width = x + (int) (myStyle.indent * scale);
//		int height = y + (int) (myStyle.leading * scale);
//		g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*scale),
//                (int) (bufferedImage.getHeight(observer)*scale), observer);
//	}
//
//	public String toString() {
//		return "Presentation.Components.BitmapItem[" + getLevel() + "," + imageName + "]";
//	}
//}
