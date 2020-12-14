package br.com.meow.framework.widgets.web;

import br.com.meow.framework.utils.HighLight;
import br.com.meow.framework.webdrivers.DriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuperElement {
    protected WebDriver webDriver;
    protected By byElement;

    public SuperElement(WebDriver driver, By by) {
        webDriver = driver;
        byElement = by;
    }

    public WebElement waitVisibilityElement(WebDriver driver, By by) {
        WebElement element = DriverWait.visibilityOfElementLocated(driver, by);
        HighLight.add(webDriver, element);
        return element;
    }

    public WebElement waitVisibilityElement(WebDriver driver, By by, int timeOutInSeconds) {
        WebElement element = DriverWait.visibilityOfElementLocated(driver, by, timeOutInSeconds);
        HighLight.add(webDriver, element);
        return element;
    }

    public WebElement waitClickableElement(WebDriver driver, By by) {
        WebElement element = DriverWait.elementToBeClickable(driver, by);
        HighLight.add(webDriver, element);
        return element;
    }

    public WebElement waitClickableElement(WebDriver driver, By by, int timeOutInSeconds) {
        WebElement element = DriverWait.elementToBeClickable(driver, by, timeOutInSeconds);
        HighLight.add(webDriver, element);
        return element;
    }

    public WebElement waitVisibilityAndClickableElement(WebDriver driver, By by) {
        WebElement elementVisibility = DriverWait.visibilityOfElementLocated(driver, by);
        WebElement element = DriverWait.elementToBeClickable(driver, elementVisibility);
        HighLight.add(webDriver, element);
        return element;
    }
}