package hrtest.pages;

import basic.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    private static String pageURL = "https://wrike.com";

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(css = "body.m-home.lang-en")
    private WebElement body;


    public HomePage() {
        super(true);
    }

    public HomePage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    public void openPage() {
        WebDriverManager.getWebDriver().get(pageURL);
    }

    @Override
    public boolean isPageOpened() {
        return body.isDisplayed();
    }

    public LoginPage clickLogin() {
        loginLink.click();
        return new LoginPage(false);
    }
}
