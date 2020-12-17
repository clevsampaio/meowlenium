package br.com.meowlenium.framework.webdrivers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverRemote {
    public static WebDriver connect(Capabilities capabilities) {
        String hub = System.getProperty("property.hub");

        if (StringUtils.isEmpty(hub)){
            System.setProperty("property.hub", "http://localhost:4444/wd/hub");
            hub = "http://localhost:4444/wd/hub";
        }

        try {
            return new RemoteWebDriver(new URL(hub), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Não foi possível conectar ao grid, url informada incorretamente.", e);
        }
    }
}