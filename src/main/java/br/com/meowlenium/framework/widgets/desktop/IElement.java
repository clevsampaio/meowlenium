package br.com.meowlenium.framework.widgets.desktop;

import org.sikuli.script.Pattern;

public interface IElement {
    boolean findScreenElement();
    boolean waitScreenElement();
    Pattern pattern();
}