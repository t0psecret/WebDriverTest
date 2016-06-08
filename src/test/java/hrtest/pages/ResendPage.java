package hrtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static basic.WebDriverManager.getWebDriver;

public class ResendPage extends BasePage{

    private static String pageURL = "http://wrike.com/resend";
    private static String SUCCEEDED_REGISTRATION_TEXT = "Registration succeeded";

    @FindBy(linkText = "Pricing")
    private WebElement pricingLink;

    @FindBy(id = "resendEmail")
    private WebElement resendButton;

    public ResendPage() {
        super(true);
    }

    public ResendPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    public void openPage() {
        getWebDriver().get(pageURL);
    }

    @Override
    public boolean isPageOpened() {
        (new WebDriverWait(getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("wrike - enterprise project management");
            }
        });
        return resendButton.isDisplayed();
    }

    public boolean checkForSucceededRegistration() {
        return getWebDriver().getPageSource().contains(SUCCEEDED_REGISTRATION_TEXT);
    }

    public ResendPage clickResend() {
        resendButton.click();
        return this;
    }

    public PricingPage clickPricing() {
        pricingLink.click();
        return new PricingPage(false);
    }
}
