package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

	 WebDriver driver;

	    public LoginPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }

By userLoginname =By.id("txtLanId");  // User login user name
By userLoginPass =By.id("txtPassword");  // User login user password
By signBtn =By.id("btnSubmit");  // User clicking Sign in button
By informationPanel =By.xpath("(//button[@class='close'])[3]"); //Information panel pop up xpath

//SendKeys Method
public void SendKeysMethod(By locator, String value) {
	WebElement element = driver.findElement(locator);
	element.sendKeys(value);
}
//public void LoginCredentials(String lname, String lPass) {
//	driver.findElement(userLoginname).sendKeys(lname);
//	driver.findElement(userLoginPass).sendKeys(lPass);
//}
public void LoginUserName(String lName) {
	SendKeysMethod(userLoginname, lName);
}
public void LoginUserPass(String lPass) {
	SendKeysMethod(userLoginPass, lPass);
}

public void ClickAction() {
	driver.findElement(signBtn).click();
}
public void InformationPanel() {
	driver.findElement(informationPanel).click();
}

}
