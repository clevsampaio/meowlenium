package br.com.meow.testcases;

import br.com.meow.framework.utils.BaseTest;
import br.com.meow.framework.utils.Screenshot;
import br.com.meow.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.annotations.Test;

public class SecondThreadTest extends BaseTest
{
    @Test(
            description = "Segundo teste",
            priority = 2
    )
    public void test()
    {
        DriverManager.getDriver().get("https://www.google.com.br");
        ExtentTestManager.getTest().log(Status.INFO, "Segunda thread");
        ExtentTestManager.getTest().log(Status.INFO, "Segunda evidência", Screenshot.capture());
    }
}