package Main;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**The About-box for JabberPoint.
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class AboutBox {
	public static void show(Frame parent) {
		showAboutBox(parent);
	}

	public static void showAboutBox(Frame parent) {
		String message = readAboutBoxMessageFromFile();
		JOptionPane.showMessageDialog(parent, message, "About JabberPoint", JOptionPane.INFORMATION_MESSAGE);
	}

	private static String readAboutBoxMessageFromFile() {
		// Read the aboutbox message from a file and return it as a string
			try {
				File file = new File("about.txt");
				BufferedReader reader = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
				return sb.toString();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
}

/*
Old version of code
 */

//public class Main.AboutBox {
//	public static void show(Frame parent) {
//		JOptionPane.showMessageDialog(parent,
//				"JabberPoint is a primitive slide-show program in Java(tm). It\n" +
//				"is freely copyable as long as you keep this notice and\n" +
//				"the splash screen intact.\n" +
//				"Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n" +
//				"Adapted by Gert Florijn (version 1.1) and " +
//				"Sylvia Stuurman (version 1.2 and higher) for the Open" +
//				"University of the Netherlands, 2002 -- now.\n" +
//				"Author's version available from http://www.darwinsys.com/",
//				"About JabberPoint",
//				JOptionPane.INFORMATION_MESSAGE
//		);
//	}
//}
