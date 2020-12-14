package br.com.meow.framework.widgets.web;

import br.com.meow.framework.exceptions.ExceptionMessage;
import br.com.meow.framework.reports.Report;
import br.com.meow.framework.utils.JsExecutor;
import br.com.meow.framework.widgets.IElement;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Element extends SuperElement implements IElement {
    public Element(WebDriver driver, By by) {
        super(driver, by);
    }

    @Override
    public Element click() {
        try {
            WebElement element = waitVisibilityAndClickableElement(webDriver, byElement);
            element.click();
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        Report.log(Status.INFO, "O elemento " + byElement.toString() + " recebeu um clique.");
        return this;
    }

    @Override
    public Element setText(String text) {
        try {
            WebElement element = waitVisibilityAndClickableElement(webDriver, byElement);
            element.sendKeys(text);
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        Report.log(Status.INFO, "O elemento " + byElement.toString() + " recebeu seguinte texto " + text + ".");
        return this;
    }

    @Override
    public String getText() {
        try {
            WebElement element = waitVisibilityElement(webDriver, byElement);
            return element.getText();
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        return null;
    }

    @Override
    public String getValue() {
        try {
            WebElement element = waitVisibilityElement(webDriver, byElement);
            return element.getAttribute("value");
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        return null;
    }

    @Override
    public Element setAttribute(String attribute, String value) {
        try {
            WebElement element = waitVisibilityElement(webDriver, byElement);
            JsExecutor.scriptElement(webDriver, element, "arguments[0].setAttribute('" + attribute + "', '" + value + "')");
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        Report.log(Status.INFO, "Setado atributo " + attribute + " com valor " + value + " no elemento " + byElement.toString() + ".");
        return this;
    }

    @Override
    public String getAttribute(String attribute) {
        try {
            WebElement element = waitVisibilityElement(webDriver, byElement);
            return element.getAttribute(attribute);
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        return null;
    }

    @Override
    public Element clear() {
        try {
            WebElement element = waitVisibilityAndClickableElement(webDriver, byElement);
            element.clear();
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        Report.log(Status.INFO, "O elemento " + byElement.toString() + " foi limpo.");
        return this;
    }

    @Override
    public boolean isEmpty() {
        try {
            WebElement element = waitVisibilityAndClickableElement(webDriver, byElement);
            return element.getAttribute("value").isEmpty();
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        return false;
    }

    @Override
    public Element keys(Keys keys) {
        try {
            WebElement element = waitVisibilityAndClickableElement(webDriver, byElement);
            element.sendKeys(keys);
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }

        Report.log(Status.INFO, "Pressionada tecla " + keys.name() + ".");
        return this;
    }

    @Override
    public void selectByValue(String value) {
        try {
            Select select = new Select(webDriver.findElement(byElement));
            select.selectByValue(value);
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }
    }

    @Override
    public void selectByIndex(int index) {
        try {
            Select select = new Select(webDriver.findElement(byElement));
            select.selectByIndex(index);
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }
    }

    @Override
    public void selectByVisibleText(String text) {
        try {
            Select select = new Select(webDriver.findElement(byElement));
            select.selectByVisibleText(text);
        } catch (ElementNotVisibleException e) {
            ExceptionMessage.elementNotVisibleException(byElement);
        } catch (NoSuchElementException e) {
            ExceptionMessage.noSuchElementException(byElement);
        } catch (StaleElementReferenceException e) {
            ExceptionMessage.staleElementReferenceException(byElement);
        } catch (TimeoutException e) {
            ExceptionMessage.timeoutException(byElement);
        } catch (InvalidElementStateException e) {
            ExceptionMessage.invalidElementStateException(byElement);
        }
    }

    @Override
    public void submit() {
        getElement().submit();
    }

    @Override
    public WebElement getElement() {
        return webDriver.findElement(byElement);
    }

    @Override
    public boolean waitElementVisible() {
        try {
            waitVisibilityElement(webDriver, byElement);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean waitElementVisible(int timeOutInSeconds) {
        try {
            waitVisibilityElement(webDriver, byElement, timeOutInSeconds);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}