package br.com.meowlenium.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLight {
    private static final String HIGHLIGHT_RED = "arguments[0].style.outline='2px solid #B00020'";
    private static final String HIGHLIGHT_REMOVE = "arguments[0].style.outline='none'";

    public static void add(WebDriver driver, WebElement element) {
        JsExecutor.scriptElement(driver, element, HIGHLIGHT_RED);
    }

    public static void remove(WebDriver driver, WebElement element) {
        JsExecutor.scriptElement(driver, element, HIGHLIGHT_REMOVE);
    }
}