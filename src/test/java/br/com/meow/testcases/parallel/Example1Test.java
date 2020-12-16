package br.com.meow.testcases.parallel;

import br.com.meow.framework.reports.Report;
import br.com.meow.framework.utils.BaseTest;
import br.com.meow.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Example1Test extends BaseTest
{
    @Test(
            description = "Pratica de automação 1",
            priority = 1
    )
    public void test1()
    {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com.br");
        Report.log(Status.INFO, "Está tudo certo!");
    }
}