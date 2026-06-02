package pages;

import java.io.IOException;
import java.time.Duration;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Utilities;

public class ApplyLeave {

	WebDriver driver;

    public  ApplyLeave(WebDriver driver) {
    	
        this.driver = driver;

        PageFactory.initElements(driver, this);
}
    
    
    
    By applyLeaveicon =By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lnkApplyLeave\"]"); // Apply leave Icon
    By leaveTypeClick =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlLeaveType']"); // Select The Unpaid Leave Type
    By fromDatePicker =By.xpath("(//*[@format='dd-mmm-yyyy'])[1]"); // Select The From Date
    By toDatePicker =By.xpath("(//*[@format='dd-mmm-yyyy'])[2]"); //Select the TO Date
    By reasonTextBox=By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtReason']"); // Enter the Leave Reason Text box
    By attachmentField =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$fileupload']"); // Attachment click
    By ApplyLeaveSaveBtn =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$btnSaveDown']"); // Save Button Click
    By leaveMessage = By.xpath("//*[@id=\\\"ctl00_ContentPlaceHolder1_lblMsg\\\"]");
    
    
    
    public void ApplyLeaveIconCLick() {
    	ClaimApplyPage claimApplyPage = new ClaimApplyPage(driver);
    	claimApplyPage.ClickAction(applyLeaveicon);

	}
    
    public void ApplyLeavePortal(String fromDate, String toDate) throws IOException, InterruptedException {
    	ClaimApplyPage claimApplyPage =
	            new ClaimApplyPage(driver);
    	Properties property = Utilities.getProperty();
    	 String leaveTypeName =property.getProperty("LeaveType");
    	 try {
    	        claimApplyPage.selectMethodByVisibleText(leaveTypeName, leaveTypeClick);
    	    } catch (Exception e) {
    	        System.out.println("There is no leave type named 'UnPaid Leave' in the dropdown.");
    	        return; // Stop execution if leave type is not found
    	    }
  
    //	 String fromDate =property.getProperty("FromDate");
    	 claimApplyPage.setValueUsingJS(fromDatePicker,fromDate);
    //	 String toDate =property.getProperty("ToDate");
    	 claimApplyPage.setValueUsingJS(toDatePicker,toDate);
    	 claimApplyPage.enterText(reasonTextBox, "Automated the Leave Application");
    	 claimApplyPage.uploadFile(attachmentField);
    	 claimApplyPage.ClickAction(ApplyLeaveSaveBtn);
    	// Wait for the message to appear
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	 WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lblMsg\"]")));

    	 String actualMessage = messageElement.getText().trim();

    	 // Print the message
    	 System.out.println("Leave Message: " + actualMessage);

    	 // Validate the message
    	 if (actualMessage.equalsIgnoreCase("Leave applied successfully")) {
    	     System.out.println("Leave applied successfully.");
    	 } else {
    	     Assert.fail("Leave application failed. Message displayed: " + actualMessage);
    	     System.out.println(actualMessage);
    	 }
  	
    }

//    public String getLeaveMessage() { 
//    	return driver.findElement(leaveMessage).getText().trim(); 
//
//}
}
