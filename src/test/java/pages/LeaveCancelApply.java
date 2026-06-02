package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LeaveCancelApply {
	WebDriver driver;

    public  LeaveCancelApply(WebDriver driver) {
    	
        this.driver = driver;

        PageFactory.initElements(driver, this);
}
    
    By leaveCancelIcon =By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lnkCancelLeave\"]"); // Leave Cancel Icon Click
    By leaveCancelCheckBox =By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_gvLeaveApproval_ctl02_chkLeave\"]"); // Check Box Click
    By leaveCancelSubmitBtn =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$btnLeaveCancelDown']"); //Leave Cancel Submit button.
    
    
    
    public void ApplyLeaveCancelIconCLick() {
    	ClaimApplyPage claimApplyPage = new ClaimApplyPage(driver);
    	claimApplyPage.ClickAction(leaveCancelIcon);

	}
    
    public void ApplyCancelLeave() {
    	ClaimApplyPage claimApplyPage = new ClaimApplyPage(driver);
    	claimApplyPage.ClickAction(leaveCancelCheckBox);
    	claimApplyPage.ClickAction(leaveCancelSubmitBtn);
    	// Wait for the message to appear
   	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

   	 WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lblMsg\"]")));

   	 String actualMessage = messageElement.getText().trim();

   	 // Print the message
   	 System.out.println("Leave Message: " + actualMessage);

   	 // Validate the message
   	 if (actualMessage.equalsIgnoreCase("Leave Cancel Applied Successfully.")) {
   	     System.out.println("Leave Cancel Applied Successfully.");
   	 } else {
   	     Assert.fail("Leave application failed. Message displayed: " + actualMessage);
   	     System.out.println(actualMessage);
   	 }
		
	}
    
    
}
