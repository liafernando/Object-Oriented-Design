package Presentation;

import java.io.IOException;

import Presentation.Components.Slide.Slide;
import org.w3c.dom.Element;

public interface Saver {
    void saveFile(Presentation p, String fn) throws IOException;
    String getTitle(Element element, String tagName);

    void loadSlideItem(Slide slide, Element item);
}
