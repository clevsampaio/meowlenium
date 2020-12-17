package br.com.meowlenium.framework.exceptions;

import br.com.meowlenium.framework.reports.Report;
import br.com.meowlenium.framework.utils.Screenshot;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;

public class ExceptionMessage {
    public static void elementNotVisibleException(By by) {
        String message = "O elemento " + by.toString() + " existente no DOM e tem um conjunto de recursos como oculto.";
        Report.log(Status.WARNING, message, Screenshot.capture());
        throw new ElementNotVisibleException(message);
    }

    public static void noSuchElementException(By by) {
        String message = "O elemento " + by.toString() + " não pode ser encontrado.";
        Report.log(Status.WARNING, message, Screenshot.capture());
        throw new NoSuchElementException(message);
    }

    public static void staleElementReferenceException(By by) {
        String message = "O elemento " + by.toString() + " foi desvinculado do DOM atual.";
        Report.log(Status.WARNING, message, Screenshot.capture());
        throw new StaleElementReferenceException(message);
    }

    public static void timeoutException(By by) {
        String message = "O elemento " + by.toString() + " pesquisado não foi encontrado no tempo especificado.";
        Report.log(Status.WARNING, message, Screenshot.capture());
        throw new TimeoutException(message);
    }

    public static void invalidElementStateException(By by) {
        String message = "O comando não pode ser finalizado, pois o elemento " + by.toString() + " é inválido.";
        Report.log(Status.WARNING, message, Screenshot.capture());
        throw new InvalidElementStateException(message);
    }
}