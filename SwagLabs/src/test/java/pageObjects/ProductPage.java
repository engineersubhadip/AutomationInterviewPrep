package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public By productPageTitleLoc = By.xpath("//span[contains(text(),'Products')]");
	
	@FindBy(xpath = "//span[contains(text(),'Products')]")
	WebElement productPageTitle;
	
	@FindBy(xpath = "//div[@id='inventory_container' and @class='inventory_container']/div //div[@class='inventory_item']")
	List<WebElement> products;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement shoppingCartIcon;
	
	
	public boolean productPageDisplayStatus () {
		try {
			waitForElementToAppear(productPageTitleLoc);
			return productPageTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void addToCart (String productName) {
		
		WebElement targetProduct = products.stream().filter(currEle -> {
			String currProductName = currEle.findElement(By.xpath("./div[2] //div[@class='inventory_item_name ']")).getText();
			if (currProductName.equalsIgnoreCase(productName)) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList()).get(0);
		
		targetProduct.findElement(By.xpath("./div[2] //button")).click();
	}
	
	public void clickCartIcon () throws InterruptedException {
		shoppingCartIcon.click();
		Thread.sleep(4000);
	}
}
