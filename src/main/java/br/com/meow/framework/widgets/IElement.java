package br.com.meow.framework.widgets;

import br.com.meow.framework.widgets.web.Element;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface IElement {
    Element click();
    Element setText(String text);
    String getText();
    String getValue();
    Element setAttribute(String attribute, String value);
    String getAttribute(String attribute);
    Element clear();
    boolean isEmpty();
    Element keys(Keys keys);
    void submit();
    WebElement getElement();
    boolean waitElementVisible();
    boolean waitElementVisible(int timeOutInSeconds);
}