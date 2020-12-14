package br.com.meow.framework.webdrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWait {
    protected static WebDriverWait wait;
    protected static int TIMEOUT_IN_SECONDS = 15;

    public static WebElement visibilityOfElementLocated(WebDriver driver, By by) {
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement visibilityOfElementLocated(WebDriver driver, By by, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement visibilityOf(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOf(WebDriver driver, WebElement element, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement elementToBeClickable(WebDriver driver, By by) {
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement elementToBeClickable(WebDriver driver, By by, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement elementToBeClickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(WebDriver driver, WebElement element, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static Boolean invisibilityOfElementLocated(WebDriver driver, By by) {
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static Boolean invisibilityOfElementLocated(WebDriver driver, By by, int timeOutInSeconds) {
        wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}