package hrtest.pages;

import basic.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FreeTrialPage extends BasePage {

    private static String pageURL = "https://www.wrike.com/free-trial";

    @FindBy(css = "body.m-free-trial.lang-en")
    private WebElement body;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(className = "btn")
    private WebElement getStartForFreeButton;


    public FreeTrialPage() {
        super(true);
    }

    public FreeTrialPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }


    @Override
    protected void openPage() {
        getDriver().get(pageURL);
    }

    @Override
    public boolean isPageOpened() {
        return body.isDisplayed();
    }

    public ResendPage getStartForFree(String s) {
        if (s != null) enterEmail(s);
        getStartForFreeButton.click();
        return new ResendPage(false);
    }

    public FreeTrialPage enterEmail(String s) {
        email.sendKeys(s);
        return this;
    }
}
