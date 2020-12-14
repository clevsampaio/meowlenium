package br.com.meow.testcases;

import br.com.meow.framework.utils.BaseTest;
import br.com.meow.framework.utils.Screenshot;
import br.com.meow.framework.webdrivers.DriverManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.annotations.Test;

public class FirstThreadTest extends BaseTest
{
    @Test(
            description = "Primeiro teste",
            priority = 1
    )
    public void test()
    {
        DriverManager.getDriver().get("https://www.google.com.br");
        ExtentTestManager.getTest().log(Status.INFO, "Primeira thread");
        ExtentTestManager.getTest().log(Status.INFO, "Primeira evidência", Screenshot.capture());
    }
}