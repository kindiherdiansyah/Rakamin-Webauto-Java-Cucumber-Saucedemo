package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class allStepDef {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo")
    public void halaman_login_saucedemo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @Then("user in on the dashboard page")
    public void userInOnTheDashboardPage() {
        driver.findElement(By.xpath("//*[@id='inventory_sidebar_link']"));
        String username = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(username,"Products");
        driver.close();
    }

    @And("input Invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @When("I input (.*) as username$")
    public void user_input_tdd_selenium_gmail_com_as_email(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("I input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if(status.equals("success")){ //Assert success login
            driver.findElement(By.xpath("//*[@id='inventory_sidebar_link']"));
            String username = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
            Assert.assertEquals(username,"Products");
        } else { // Assert error message
            String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
            Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
        }
        driver.close();
    }

    @And("click Add to Cart button on one of the product or more")
    public void clickAddToCartButtonOnOneOfTheProductOrMore() {
        WebElement addProductButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addProductButton.click();
    }

    @And("click Cart icon on the top right side")
    public void clickCartIconOnTheTopRightSide() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    @And("click button Checkout")
    public void clickButtonCheckout() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @Then("click button Checkout and go to the checkout page to fill in the information")
    public void clickButtonCheckoutAndGoToTheCheckoutPageToFillInTheInformation() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        String checkoutPageAct = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span[contains(text(), 'Checkout: Your Information')]")).getText();
        Assert.assertEquals(checkoutPageAct,"Checkout: Your Information");
        driver.close();
    }

    @Then("verify click button Checkout and get error")
    public void clickButtonCheckoutAndGetError() {
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id='checkout']"));
        checkoutButton.click();
        driver.close();
        String expectedResult = "Message Error : Anda belum menambahkan produk";
        Assert.assertEquals("Hasil seharusnya sama dengan ekspektasi", expectedResult, checkoutButton);
    }

    @And("User fill the buyer's biodata form and click the Continue button")
    public void userFillTheBuyerSBiodataFormAndClickTheContinueButton() {
        driver.findElement(By.id("first-name")).sendKeys("Alam");
        driver.findElement(By.id("last-name")).sendKeys("Semesta");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @And("click the Continue button without input biodata")
    public void clickTheContinueButtonWithoutInputBiodata() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @Then("user is redirected to the Checkout: Overview page")
    public void userIsRedirectedToTheCheckoutOverviewPage() {
        String checkoutOverview = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span[contains(text(), 'Checkout: Overview')]")).getText();
        Assert.assertEquals(checkoutOverview,"Checkout: Overview");
        driver.close();
    }

    @And("click Continue button")
    public void clickContinueButton() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @Then("user get error message {string}")
    public void userGetErrorMessage(String arg0) {
        String errorCheckout = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3")).getText();
        Assert.assertEquals(errorCheckout,arg0);
        driver.close();
    }

    @And("I input (.*) as first name$")
    public void iInputFirstNameAsFirstName(String firstname) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
    }

    @And("I input (.*) as last name$")
    public void iInputLastNameAsLastName(String lastname) {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
    }

    @And("I input (.*) as postal code$")
    public void iInputPostalCodeAsPostalCode(String postalcode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalcode);
    }

    @Then("I verify (.*) checkout step one result$")
    public void iVerifyStatusCheckoutStepOneResult(String status) {
        if (status.equals("success")){ //Assert success login
            String checkoutOverview = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span[contains(text(), 'Checkout: Overview')]")).getText();
            Assert.assertEquals(checkoutOverview,"Checkout: Overview");
        } else {
            String errorCheckout = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3[contains(text(), 'Error: First Name is required')]")).getText();
            Assert.assertEquals(errorCheckout,"Error: First Name is required");
        }
        driver.close();
    }

    @Then("I see the number of products in the cart increasing")
    public void iSeeTheNumberOfProductsInTheCartIncreasing() {
        String badge = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).getText();
        Assert.assertEquals(badge,"1");
        driver.close();
    }

    @And("click burger menu button on the top left side")
    public void clickBurgerMenuButtonOnTheTopLeftSide() {
        WebElement clickBurger = driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']"));
        clickBurger.click();
    }

    @And("click Menu Logout")
    public void clickMenuLogout() {
        WebElement clickLogout = driver.findElement(By.xpath("//*[@id='logout_sidebar_link']"));
        clickLogout.click();
    }

    @Then("user back to login page saucedemo")
    public void userBackToLoginPageSaucedemo() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
        driver.close();
    }

    @Then("I verify (.*) logout result back to login page saucedemo$")
    public void iVerifyStatusLogoutResultBackToLoginPageSaucedemo(String status) {
        if (status.equals("success")){ //Assert success login
            String loginPageAssert = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
            Assert.assertEquals(loginPageAssert, "Swag Labs");
            driver.close();
        }
    }

    @And("click Menu About")
    public void clickMenuAbout() {
        WebElement clickLogout = driver.findElement(By.xpath("//*[@id='about_sidebar_link']"));
        clickLogout.click();
    }

    @Then("user is redirected to the page saucelabs.com")
    public void userIsRedirectedToThePageSaucelabsCom() {
        WebElement sauceLabsLogo = driver.findElement(By.xpath("//*[@id='__next']/header/div/div/div[1]/div[1]/a/div[1]/span/img"));
        Assert.assertTrue("Logo Sauce Labs terlihat", sauceLabsLogo.isDisplayed());
        driver.close();
    }

    @Then("I verify (.*) About result to the page saucelabs.com$")
    public void iVerifyStatusAboutResultToThePageSaucelabsCom(String status) {
        if (status.equals("success")){ //Assert success Menu About
            WebElement sauceLabsLogo = driver.findElement(By.xpath("//*[@id='__next']/header/div/div/div[1]/div[1]/a/div[1]/span/img"));
            Assert.assertTrue("Logo Sauce Labs terlihat", sauceLabsLogo.isDisplayed());
            driver.close();
        }
    }

    @And("i check the shopping list and click button Checkout and directed page biodata form")
    public void iCheckTheShoppingListAndClickButtonCheckoutAndDirectedPageBiodataForm() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @And("i check the shopping list and click the Finish button")
    public void iCheckTheShoppingListAndClickTheFinishButton() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    @Then("I verify (.*) purchased the product and directed to Checkout: Complete Page$")
    public void iVerifyStatusPurchasedTheProductAndDirectedToCheckoutCompletePage(String status) {

        if (status.equals("success")){
            WebElement checkoutCompletePage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
            Assert.assertTrue("Checkout: Complete!", checkoutCompletePage.isDisplayed());

        }
    }

    @And("i can back to Homepage with click the Back Home button")
    public void iCanBackToHomepageWithClickTheBackHomeButton() {
        WebElement backHomeButton = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
        Assert.assertTrue("Back to Homepage", backHomeButton.isDisplayed());
        driver.close();
    }

    @And("I click Continue button without input biodata form")
    public void iClickContinueButtonWithoutInputBiodataForm() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @Then("I verify failed to buy product and system will display the warning message")
    public void iVerifyStatusFailedToBuyProductAndSystemWillDisplayTheWarningMessage() {
        WebElement errorMessageForm = driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3"));
        Assert.assertTrue("Get Error Massage must fill form with valid", errorMessageForm.isDisplayed());
        driver.close();

    }
}
