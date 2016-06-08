package hrtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingPage extends BasePage{

    private static String pageURL = "http://wrike.com/pricing";

    @FindBy(css = ".price__col.price__col--pro")
    private WebElement columnProPlan;

    @FindBy(css = ".price__col-btn.form-open")
    private WebElement startFreeButton;

    @FindBy(id = "modal-pro-price")
    private WebElement modalWindowProPlan;

    @FindBy(name = "email")
    private WebElement emailProPlan;

    @FindBy(name = "start-project")
    private WebElement createAccountProPlanButton;


    public PricingPage() {
        super(true);
    }

    public PricingPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    protected void openPage() {
        getDriver().get(pageURL);
    }

    @Override
    public boolean isPageOpened() {
        return columnProPlan.isDisplayed();
    }

    public PricingPage clickProPlanStartFreeTrial() {
        startFreeButton.click();
        return this;
    }

    public ResendPage clickCreateWrikeAccount(String s) {
        if (s != null) enterProPlanEmail(s);
        createAccountProPlanButton.click();
        return new ResendPage(false);
    }

    public PricingPage enterProPlanEmail(String s) {
        emailProPlan.sendKeys(s);
        return this;
    }
}
