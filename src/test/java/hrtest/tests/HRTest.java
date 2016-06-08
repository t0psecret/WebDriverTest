package hrtest.tests;

/*
1. open url: wrike.com
        2.click "Login" button
        3.click "sign Up"
        4.fill it up email address(random generated)
        5.click "Get started for free" button
        6.check at the loaded page, that you have success confirmation of registration
        7.click resend button
        8.open "Pricing" link
        9.click "Get started for free" for professional plan
        10.In appeared window fill it up another random generated email
        11.click "Create my Wrike account" button
        12.check at the loaded page, that you have success confirmation of registration
        13.click resend button
        */

import Utils.Utils;
import basic.WebDriverManager;
import hrtest.pages.HomePage;
import hrtest.pages.ResendPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HRTest {

    @Before
    public void beforeTest() {
        WebDriverManager.initWebDriver();
    }

    @Test
    public void startHRTest() {
        ResendPage resendPage = new HomePage().clickLogin().clickCreateAccount().
                getStartForFree(Utils.generateRandomEMail());
        Assert.assertTrue("Registration failed", resendPage.checkForSucceededRegistration());
        resendPage = resendPage.clickResend().clickPricing().clickProPlanStartFreeTrial().
                clickCreateWrikeAccount(Utils.generateRandomEMail());
        Assert.assertTrue("Registration failed", resendPage.checkForSucceededRegistration());
        resendPage.clickResend();
    }

    @After
    public void afterTest() {
        WebDriverManager.finish();
    }

}
