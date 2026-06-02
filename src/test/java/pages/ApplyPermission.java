package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class ApplyPermission  {

	WebDriver driver;

    public  ApplyPermission(WebDriver driver) {
    	
        this.driver = driver;

        PageFactory.initElements(driver, this);
        // Initialize after driver assignment
     //   ClaimApplyPage  claimApplyPage = new ClaimApplyPage(driver);
}
   
    
    By applyPermissionIcon= By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lnkPermission\"]"); // Click Apply Permission Icon
    By permissionDatePicker= By.xpath("//*[@format='dd-mmm-yyyy']"); // Click the Permission date
    By reasonTextBox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtreason']"); // Reason Text box X path
    By attachmentField =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$fileupload']"); //Attachment X path
    By saveBtn =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$btnSaveDown']"); // Click Save Button
    
   
  
    
   public void ApplyPermissionIconClick() {
    	ClaimApplyPage claimApplyPage = new ClaimApplyPage(driver);
		claimApplyPage.ClickAction(applyPermissionIcon);

	}
    
    public void ApplyPermissionPortal(String permissionDate) throws IOException {
    	 ClaimApplyPage claimApplyPage =
    	            new ClaimApplyPage(driver);

    	//    Properties property = Utilities.getProperty();

    	//    claimApplyPage.ClickAction(applyPermissionIcon);

    //	    String permissionDate =
    //	            property.getProperty("PermissionDate");

    	    claimApplyPage.setValueUsingJS(
    	            permissionDatePicker,
    	            permissionDate);

    	    claimApplyPage.enterText(
    	            reasonTextBox,
    	            "Automated the Appy permission Module ");

    	    claimApplyPage.uploadFile(attachmentField);

    	    claimApplyPage.ClickAction(saveBtn);
    	 // Wait for the message to appear
       	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       	 WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lblMsg\"]")));

       	 String actualMessage = messageElement.getText().trim();

       	 // Print the message
       	 System.out.println("Leave Message: " + actualMessage);

       	 // Validate the message
       	 if (actualMessage.equalsIgnoreCase("Record is added successfully.")) {
       	     System.out.println("Record is added successfully.");
       	 } else {
       	     Assert.fail("Leave application failed. Message displayed: " + actualMessage);
       	     System.out.println(actualMessage);
       	 }
     	
       }

}
    	
	
   

    
    
    

