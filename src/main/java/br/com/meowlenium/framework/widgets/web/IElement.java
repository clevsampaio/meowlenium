package br.com.meowlenium.framework.widgets.web;

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
    void selectByValue(String value);
    void selectByIndex(int index);
    void selectByVisibleText(String text);
    void submit();
    WebElement getElement();
    boolean waitElementVisible();
    boolean waitElementVisible(int timeOutInSeconds);
}