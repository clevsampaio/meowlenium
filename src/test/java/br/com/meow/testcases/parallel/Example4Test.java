package br.com.meow.testcases.parallel;

import br.com.meow.framework.reports.Report;
import br.com.meow.framework.utils.BaseTest;
import br.com.meow.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Example4Test extends BaseTest
{
    @Test(
            description = "Pratica de automação 4",
            priority = 4
    )
    public void test4()
    {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com.br");
        Report.log(Status.INFO, "Está tudo certo!");
    }
}