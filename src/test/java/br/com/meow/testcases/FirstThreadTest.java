package br.com.meow.testcases;

import br.com.meow.framework.utils.BaseTest;
import br.com.meow.framework.utils.HighLight;
import br.com.meow.framework.utils.Screenshot;
import br.com.meow.framework.webdrivers.DriverManager;
import br.com.meow.framework.webdrivers.DriverWait;
import br.com.meow.framework.widgets.web.Element;
import br.com.meow.pageobjects.GooglePageObject;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

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