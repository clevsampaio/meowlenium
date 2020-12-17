package br.com.meowlenium.framework.utils;

import br.com.meowlenium.framework.reports.ReportListener;
import br.com.meowlenium.framework.webdrivers.DriverFactory;
import br.com.meowlenium.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({
        ExtentITestListenerClassAdapter.class,
        ReportListener.class
})
public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        WebDriver driver = DriverFactory.createInstance();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.closeDriver();
    }
}