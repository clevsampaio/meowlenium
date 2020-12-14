package br.com.meow.framework.utils;

import org.openqa.selenium.*;

public class JsExecutor {
    public static void scriptElement(WebDriver driver, WebElement element, String script) {
        try {
            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript(script, element);
            }
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException("O elemento foi desvinculado do DOM atual.", e);
        } catch (JavascriptException e) {
            throw new RuntimeException("Não foi possível executar o comando JS.", e);
        }
    }
}