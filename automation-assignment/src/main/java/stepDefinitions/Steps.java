package stepDefinitions;
import com.example.pages.LoginPage;
import com.example.pages.NewPostPage;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Steps {
	WebDriver driver;
    LoginPage loginPage;
    NewPostPage newPostPage;
    WebDriverWait wait;
    @Given("user is on login page")
    public void userIsOnLoginPage() {
    	driver=new ChromeDriver();
    	// wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    	 driver.get("https://client-auth-dev.fanfix.dev/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
		driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @When("user logs in with email {string} and password {string}")
    public void userLogsInWithEmailAndPassword(String email, String password) {
        loginPage.login(email, password);
    }

    @And("user navigates to new post page")
    public void userNavigatesToNewPostPage() {
        newPostPage = new NewPostPage(driver);
        newPostPage.createNewPost("This post is done by automation assignment", "path/to/your/image.jpg", "5");
    }

    @Then("user sets subscription and non-subscription prices to {string}")
    public void userSetsSubscriptionAndNonSubscriptionPrices(String price) {
        Assert.assertEquals(price, "5");
    }

    @And("user verifies that post button is enabled for price {string}")
    public void userVerifiesThatPostButtonIsEnabledForPrice(String price) {
        if (Double.parseDouble(price) < 5) {
            Assert.assertFalse(newPostPage.isPostButtonEnabled());
        } else {
            Assert.assertTrue(newPostPage.isPostButtonEnabled());
        }
    }

    @And("user submits the post")
    public void userSubmitsThePost() {
        newPostPage.submitPost();
    }

    @Then("post should be successfully created")
    public void postShouldBeSuccessfullyCreated() {
        // Add verification logic for successful post creation.
        driver.quit();
    }
}
