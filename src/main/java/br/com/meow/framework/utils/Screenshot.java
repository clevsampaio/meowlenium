package br.com.meow.framework.utils;

import br.com.meow.framework.reports.Report;
import br.com.meow.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Screenshot {
    public static MediaEntityModelProvider capture() {
        String base64image = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        try {
            return MediaEntityBuilder.createScreenCaptureFromBase64String(base64image).build();
        } catch (IOException e) {
            Report.log(Status.ERROR, "Não foi possível gerar uma evidência!");
        }

        return null;
    }
}