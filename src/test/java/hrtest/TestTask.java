package hrtest;
/*
* EXPRIMENTAL!
* */

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTask  {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        System.setProperty("webdriver.chrome.driver", "c:\\soft\\maven\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // And now use this to visit Google
        driver.get("http://wrike.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Click Login button
       // WebElement element = null;
        WebElement element = null;
        try {
            element = driver.findElement(By.className("nav_login"));
        } catch (Exception e) {
            element = driver.findElement(By.linkText("Login"));
        }

        element.click();

        element = driver.findElement(By.linkText("Create account"));

        element.click();

        element = driver.findElement(By.name("email"));
        element.sendKeys(Utils.generateRandomEMail());

        //element.submit();
        // click "Get Started for free"
        element = driver.findElement(By.className("btn"));
        element.click();

        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("wrike - enterprise project management");
            }
        });

        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //System.out.println(driver.getPageSource());
        //WebDriver driver2 = new ChromeDriver();

        if (driver.getPageSource().contains("Registration succeeded"))
            System.out.println("Registration OK!");
        else
            System.out.println("Registration FAIL");

        // click "Resend"
        try {
            //element = driver.findElement(By.cssSelector("button#resendEmail.btn.btn-transparent.btn-outline"));
            element = driver.findElement(By.id("resendEmail"));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // click "Pricing"
        /*element = driver.findElement(By.linkText("Pricing"));
        element.click();*/

        // click "Start Free Trial" for professional plan

        /*try {
            element = driver.findElement(By.cssSelector(".wg-cell.wg-cell--md-3.wg-cell--xl-3.price-cell.price-cell--pro.price-cell--special"));
            element = element.findElement(By.cssSelector(".wg-btn.wg-btn--green"));
            element.click();
        } catch (Exception e) {
            element = driver.findElement(By.cssSelector(".price__col.price__col--pro"));
            element = element.findElement(By.cssSelector(".price__col-btn.form-open"));
            element.click();
        }*/


        // enter random email
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       /* try {
            element = driver.findElement(By.cssSelector(".price__form.form-professional.price__form--open"));
        } catch (Exception e) {
            element = driver.findElement(By.id("modal-pro-price"));

        }
        WebElement elementEmail = element.findElement(By.name("email"));
        elementEmail.sendKeys(Utils.generateRandomEMail());

        //click "Create My Wrike account"
        try {
            element = element.findElement(By.name("start-project"));
        } catch (Exception e) {
            element = element.findElement(By.cssSelector(".wg-btn.wg-btn--green.modal-form-trial__submit"));
        }
        element.click();*/

        // Wait for the page to load, timeout after 10 seconds
       /* (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("wrike - enterprise project management");
            }
        });*/

        // check for "Registration succeeded"
       /* if (driver.getPageSource().contains("Registration succeeded"))
            System.out.println("Registration OK!");
        else
            System.out.println("Registration FAIL");*/

        // click "Resend"
        /*try {
            //element = driver.findElement(By.cssSelector("button#resendEmail.btn.btn-transparent.btn-outline"));
            element = driver.findElement(By.id("resendEmail"));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //element.submit();

        // click Create my Wrike account
        /*try {
            element = driver.findElement(By.cssSelector(".wg-btn.wg-btn--green.modal-form-trial__submit"));
        } catch (Exception e) {
            element = driver.findElement(By.name("start-project"));
        }
        element.click();*/

//        element = driver.findElement(By.id("2qrzks-6"));
//        element.click();




        // Enter something to search for
        //element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
//        element.submit();

        // Check the title of the page
//        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });

        // Should see: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        //driver.quit();
    }
}