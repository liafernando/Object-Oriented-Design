import Presentation.*;
import Presentation.Components.Slide.SlideViewerFrame;
import Services.Accessor;
import Services.XMLAccessor;

import javax.swing.JOptionPane;
import java.io.IOException;

/** JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint {

	private static final String IO_ERROR = "An input/output error occurred: %s";
	private static final String JABBER_ERROR = "An error occurred in Jabberpoint";
	private static final String JABBER_VERSION_INFO = "Jabberpoint Version 1.6 - Educational Edition";

	public static void main(String[] parameters) {
		Style.createStyles();
		Presentation presentationInstance = new Presentation();
		new SlideViewerFrame(JABBER_VERSION_INFO, presentationInstance);

		try {
			if (parameters.length == 0) {
				Accessor.getDemoAccessor().loadFile(presentationInstance, "Demo");
			}
			else {
				new XMLAccessor().loadFile(presentationInstance, parameters[0]);
			}
			presentationInstance.setSlideNumber(0);
		}

		catch (IOException ioException) {
			JOptionPane.showMessageDialog(null,
					String.format(IO_ERROR, ioException.getMessage()),
					JABBER_ERROR,
					JOptionPane.ERROR_MESSAGE);
		}
	}
}



/*
Old version of code
 */

//public class  JabberPoint {
//	protected static final String IOERR = "IO Error: ";
//	protected static final String JABERR = "Jabberpoint Error ";
//	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";
//
//	/** The main program */
//	public static void main(String[] argv) {
//
//		Presentation.Style.createStyles();
//		Presentation.Presentation presentation = new Presentation.Presentation();
//		new Presentation.Components.Slide.SlideViewerFrame(JABVERSION, presentation);
//		try {
//			if (argv.length == 0) { //a demo presentation
//				Accessor.getDemoAccessor().loadFile(presentation, "");
//			} else {
//				new Services.XMLAccessor().loadFile(presentation, argv[0]);
//			}
//			presentation.setSlideNumber(0);
//		} catch (IOException ex) {
//			JOptionPane.showMessageDialog(null,
//					IOERR + ex, JABERR,
//					JOptionPane.ERROR_MESSAGE);
//		}
//	}
//}
