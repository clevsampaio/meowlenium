package br.com.meowlenium.testcases.parallel;

import br.com.meowlenium.framework.reports.Report;
import br.com.meowlenium.framework.utils.BaseTest;
import br.com.meowlenium.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Example3Test extends BaseTest
{
    @Test(
            description = "Pratica de automação 3",
            priority = 3
    )
    public void example3Test()
    {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://www.google.com.br");
        Report.log(Status.INFO, "Está tudo certo!");
    }
}