package br.com.meow.pageobjects;

import br.com.meow.framework.widgets.IElement;
import br.com.meow.framework.widgets.web.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationPracticePageObject {
    private WebDriver driver;

    public AutomationPracticePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public IElement searchTextField() {
        return new Element(this.driver, By.id("search_query_top"));
    }

    public IElement submitSearchButton() {
        return new Element(this.driver, By.name("submit_search"));
    }

    public IElement firstResultProductButton() {
        return new Element(this.driver, By.xpath("//div[@id='center_column']/ul/li/div/div[2]/h5/a"));
    }

    public IElement productPriceLabel() {
        return new Element(this.driver, By.id("our_price_display"));
    }

    public IElement addToCartButton() {
        return new Element(this.driver, By.id("add_to_cart"));
    }

    public IElement layerToCartButton() {
        return new Element(this.driver, By.xpath("//div[@id='layer_cart']/div[1]/div[2]/div[4]/a"));
    }

    public IElement totalPriceLabel() {
        return new Element(this.driver, By.id("total_price"));
    }

    public IElement proceedToCheckoutButton() {
        return new Element(this.driver, By.xpath("//div[@id='center_column']/p[2]/a[1]"));
    }

    public IElement createAnAccountTextField() {
        return new Element(this.driver, By.id("email_create"));
    }

    public IElement createAnAccountButton() {
        return new Element(this.driver, By.id("SubmitCreate"));
    }

    public IElement genderCheckBox() {
        return new Element(this.driver, By.id("id_gender1"));
    }

    public IElement customerFirstNameTextField() {
        return new Element(this.driver, By.id("customer_firstname"));
    }

    public IElement customerLastNameTextField() {
        return new Element(this.driver, By.id("customer_lastname"));
    }

    public IElement passwordTextField() {
        return new Element(this.driver, By.id("passwd"));
    }

    public IElement firstNameTextField() {
        return new Element(this.driver, By.id("firstname"));
    }

    public IElement lastNameTextField() {
        return new Element(this.driver, By.id("lastname"));
    }

    public IElement addressTextField() {
        return new Element(this.driver, By.id("address1"));
    }

    public IElement cityTextField() {
        return new Element(this.driver, By.id("city"));
    }

    public IElement stateComboBox() {
        return new Element(this.driver, By.id("id_state"));
    }

    public IElement postalCodeTextField() {
        return new Element(this.driver, By.id("postcode"));
    }

    public IElement phoneMobileTextField() {
        return new Element(this.driver, By.id("phone_mobile"));
    }

    public IElement registerButton() {
        return new Element(this.driver, By.id("submitAccount"));
    }

    public IElement processAddressButton() {
        return new Element(this.driver, By.name("processAddress"));
    }

    public IElement termsOfServiceCheckBox() {
        return new Element(this.driver, By.id("uniform-cgv"));
    }

    public IElement processCarrierButton() {
        return new Element(this.driver, By.name("processCarrier"));
    }

    public IElement payByBankWireButton() {
        return new Element(this.driver, By.xpath("//div[@id='HOOK_PAYMENT']/div[1]/div/p/a"));
    }

    public IElement iConfirmMyOrderButton() {
        return new Element(this.driver, By.xpath("//p[@id='cart_navigation']/button"));
    }

    public IElement orderConfirmationLabel() {
        return new Element(this.driver, By.xpath("//div[@id='center_column']/div/p/strong"));
    }

    public IElement signOutButton() {
        return new Element(this.driver, By.xpath("//header[@id='header']/div[2]/div/div/nav/div[2]/a"));
    }

    public IElement authenticationLabel() {
        return new Element(this.driver, By.xpath("//div[@id='center_column']/h1"));
    }
}