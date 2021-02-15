package sfdc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Properties;

public class LoginStepDefinitions {

    public static WebDriver driverWeb;

    @FindBy(id="username")
    WebElement uName;

    @FindBy(id="password")
    WebElement pWord;

    @FindBy(id="Login")
    WebElement loginButton;

    @FindBy(xpath="//*[@id=\"userNav\"]")
    WebElement userNavBtn;


    @Given("^user is already on Login Page$")
    public void user_is_already_on_Login_Page() throws Exception {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        driverWeb = new ChromeDriver();
        PageFactory.initElements(driverWeb, this);
        driverWeb.get("https://login.salesforce.com/");
    }

    @When("^title of login page is Login Salesorce$")
    public void title_of_login_page_is_Login_Salesorce() throws Exception {
        String title = driverWeb.getTitle();
	    System.out.println(title);
	    Assert.assertEquals("Login | Salesforce", title);
    }

    @Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_and(String userName, String password) throws Exception {
        Thread.sleep(7000);
        uName.clear();
        uName.sendKeys(userName);
        pWord.clear();
        pWord.sendKeys(password);
    }

    @Then("^user clicks on login button$")
    public void user_clicks_on_login_button() throws Exception {
        loginButton.click();
    }

    @Then("^user is on home page$")
    public void user_is_on_home_page() throws Exception {
        String title = driverWeb.getTitle();
	 System.out.println("Home Page title ::"+ title);
//	 Assert.assertEquals("CRMPRO", title);
    }

    @Then("^Close the browser$")
    public void close_the_browser() throws Exception {
        driverWeb.close();
    }

}
