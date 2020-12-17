package br.com.meowlenium.framework.widgets.desktop;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Element extends SuperElement implements IElement {
    public Element(Screen screen, Pattern pattern) {
        super(screen, pattern);
    }

    @Override
    public boolean findScreenElement() {
        if (this.pattern.isValid()) {
            if (this.screen.exists(this.pattern.exact()) != null) {
                try {
                    this.screen.find(this.pattern).highlight(1);
                    return true;
                } catch (FindFailed ignore) {
                }
            }
        }

        return false;
    }

    @Override
    public boolean waitScreenElement() {
        if (this.pattern.isValid()) {
            int timeout = 0;

            do {
                try {
                    Thread.sleep(1000);

                    if (this.screen.exists(this.pattern.exact()) != null) {
                        this.screen.find(this.pattern).highlight(1);
                        return true;
                    }

                    timeout++;
                } catch (InterruptedException | FindFailed ignore) {
                }
            } while (timeout < 10);
        }

        return false;
    }

    @Override
    public Pattern pattern() {
        return this.pattern;
    }
}