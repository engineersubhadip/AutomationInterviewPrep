package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody //tr //td[@class='cart_description']/h4")
	List<WebElement> productName;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody //tr //td[@class='cart_price']/p")
	List<WebElement> individualPrice;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody //tr //td[@class='cart_quantity']/button")
	List<WebElement> quantity;
	
	@FindBy(xpath="//table[@id='cart_info_table']/tbody //tr //td[@class='cart_total']/p")
	List<WebElement> totalProductPrice;
	
	public boolean validateProductName(List<String> userPurchase) throws IllegalAccessException {
		try {
			for (int i=0; i<productName.size(); i++) {
				String currEle = productName.get(i).getText().trim();
				if (currEle.equals(userPurchase.get(i))) {
					continue;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			throw new IllegalAccessException();
		}
		return true;
	}
	

	public boolean validateProductPrice() throws IllegalAccessException {
		try {
			if ((individualPrice.size() != totalProductPrice.size()) && (totalProductPrice.size() != quantity.size())) {
				return false;
			}
			for (int i=0; i<totalProductPrice.size(); i++) {
				int totalPrice = Integer.parseInt(totalProductPrice.get(i).getText().split(" ")[1].trim());
				int unitPrice = Integer.parseInt(individualPrice.get(i).getText().split(" ")[1].trim());
				int units = Integer.parseInt(quantity.get(i).getText());
				if (totalPrice != (unitPrice * units)) {
					return false;
				}
			}
		} catch (Exception e) {
			throw new IllegalAccessException();
		}
		return true;
	}
}
