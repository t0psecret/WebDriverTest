package hrtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static String pageURL = "https://www.wrike.com/login/";

    @FindBy(linkText = "Create account")
    private WebElement createAccountLink;

    @Override
    protected void openPage() {
        getDriver().get(pageURL);
    }

    @Override
    public boolean isPageOpened() {
        return createAccountLink.isDisplayed();
    }

    public LoginPage() {
        super(true);
    }

    public LoginPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    public FreeTrialPage clickCreateAccount() {
        createAccountLink.click();
        return new FreeTrialPage(false);
    }

}
