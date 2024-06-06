package com.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class NewPostPage {
	 WebDriver driver;

	    @FindBy(xpath = "//button[@id=':R3ana9lara:']")
	    WebElement newPostButton;

	    @FindBy(id = "post-caption")
	    WebElement postCaption;

	    @FindBy(xpath = "//div[@class='MuiStack-root css-1ud9st0']")  // Adjust the selector based on the actual plus icon element
	    WebElement plusIcon;

	    @FindBy(xpath = "//button[@id=':r7:' and @type='button']")
	    WebElement uploadMediaButton;

	    @FindBy(xpath = "//div[@class='filepond--drop-label']")
	    WebElement browseButton;

	    @FindBy(id = ":ri:")WebElement continueButton;
	    
	    @FindBy(xpath = "//div[@class='MuiStack-root css-1ex1g4g']//div[1]//div[1]//img[1]")  // Assuming the uploaded media is displayed as an <img> element within a div with class 'uploaded-media'
	    WebElement uploadedMedia;
	    
	    @FindBy(xpath = "//button[@id=':ro:']")
	    WebElement addMediaFinalButton;
	    
	    @FindBy(xpath = "//body[1]/div[4]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[6]/div[1]/span[1]/p[1]")
	    WebElement subscriptionPrice;

	    @FindBy(xpath = "//div[@class='MuiBox-root css-1yuhvjn']//p[@class='MuiTypography-root MuiTypography-body1 interBold12 css-i9555c'][normalize-space()='Custom']")
	    WebElement nonSubscriptionPrice;

	    @FindBy(xpath = "//button[@id=':r12:']")
	    WebElement postButton;

	    public NewPostPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void createNewPost(String caption, String filePath, String price) {
	        newPostButton.click();
	        postCaption.sendKeys(caption);
	        plusIcon.click();
	        uploadMediaButton.click();
	        browseButton.sendKeys("C:\\Users\\HP\\Downloads\\th.jpg"); // This assumes the browse button is of type <input type="file">
	        continueButton.click();
	        uploadMediaButton.click();
	        addMediaFinalButton.click();
	        subscriptionPrice.sendKeys(price);
	        nonSubscriptionPrice.sendKeys(price);
	    }
	    public void setPrice(String price) {
	       // customPriceOption.click(); // Select the Custom price option
	        subscriptionPrice.sendKeys("5");
	        nonSubscriptionPrice.sendKeys("5");
	    }
	    public void submitPost() {
	        postButton.click();
	    }

	    public boolean isPostButtonEnabled() {
	        return postButton.isEnabled();
	    }
}
