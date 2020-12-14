package br.com.meow.testcases;

import br.com.meow.framework.utils.BaseTest;
import br.com.meow.framework.webdrivers.DriverManager;
import br.com.meow.pageobjects.AutomationPracticePageObject;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeTest extends BaseTest
{
    @Test(
            description = "Pratica de automação",
            priority = 1
    )
    public void test()
    {
        WebDriver driver = DriverManager.getDriver();
        driver.get("http://automationpractice.com");

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        AutomationPracticePageObject page = new AutomationPracticePageObject(driver);
        page.searchTextField().setText("Blouse");
        page.submitSearchButton().click();
        page.firstResultProductButton().click();
        Assert.assertEquals(page.productPriceLabel().getText(), "$27.00");
        page.addToCartButton().click();
        page.layerToCartButton().click();
        Assert.assertEquals(page.totalPriceLabel().getText(), "$29.00");
        page.proceedToCheckoutButton().click();
        page.createAnAccountTextField().setText(faker.internet().safeEmailAddress());
        page.createAnAccountButton().click();
        page.genderCheckBox().click();
        page.customerFirstNameTextField().setText(firstName);
        page.customerLastNameTextField().setText(lastName);
        page.passwordTextField().setText(faker.internet().password());
        page.firstNameTextField().setText(firstName);
        page.lastNameTextField().setText(lastName);
        page.addressTextField().setText(faker.address().streetAddress());
        page.cityTextField().setText(faker.address().city());
        page.stateComboBox().selectByIndex(6);
        page.postalCodeTextField().setText(faker.number().digits(5));
        page.phoneMobileTextField().setText(faker.phoneNumber().cellPhone());
        page.registerButton().click();
        page.processAddressButton().click();
        page.termsOfServiceCheckBox().click();
        page.processCarrierButton().click();
        page.payByBankWireButton().click();
        page.iConfirmMyOrderButton().click();
        Assert.assertEquals(page.orderConfirmationLabel().getText(), "Your order on My Store is complete.");
        page.signOutButton().click();
        Assert.assertEquals(page.authenticationLabel().getText(), "AUTHENTICATION");
    }
}