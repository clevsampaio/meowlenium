package br.com.meowlenium.testcases.parallel;

import br.com.meowlenium.framework.reports.Report;
import br.com.meowlenium.framework.utils.BaseTest;
import br.com.meowlenium.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Example1Test extends BaseTest
{
    @Test(
            description = "Pratica de automação 1",
            priority = 1
    )
    public void example1Test()
    {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com.br");
        Report.log(Status.INFO, "Está tudo certo!");
    }
}