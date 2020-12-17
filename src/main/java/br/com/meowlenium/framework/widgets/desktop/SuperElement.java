package br.com.meowlenium.framework.widgets.desktop;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SuperElement {
    protected Screen screen;
    protected Pattern pattern;

    public SuperElement(Screen screen, Pattern pattern) {
        this.screen = screen;
        this.pattern = pattern;
    }
}