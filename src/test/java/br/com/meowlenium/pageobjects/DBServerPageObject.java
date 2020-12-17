package br.com.meowlenium.pageobjects;

import br.com.meowlenium.framework.utils.Directory;
import br.com.meowlenium.framework.widgets.desktop.Element;
import br.com.meowlenium.framework.widgets.desktop.IElement;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.io.File;

public class DBServerPageObject {
    private Screen screen;

    public DBServerPageObject(Screen screen) {
        this.screen = screen;
    }

    public IElement openChrome() {
        return new Element(this.screen, new Pattern(Directory.OBJECTS_FOLDER + File.separator + "chrome_icon.png"));
    }

    public IElement searchGoogle() {
        return new Element(this.screen, new Pattern(Directory.OBJECTS_FOLDER + File.separator + "input_google.png"));
    }

    public IElement dbserverLink() {
        return new Element(this.screen, new Pattern(Directory.OBJECTS_FOLDER + File.separator + "dbserver_link.png"));
    }

    public IElement dbserverLogo() {
        return new Element(this.screen, new Pattern(Directory.OBJECTS_FOLDER + File.separator + "dbserver_logo.png"));
    }
}