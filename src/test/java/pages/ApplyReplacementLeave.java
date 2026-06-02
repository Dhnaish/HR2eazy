package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ApplyReplacementLeave {

	WebDriver driver;

    public  ApplyReplacementLeave (WebDriver driver) {
    	
        this.driver = driver;

        PageFactory.initElements(driver, this);
}
    
    By repalacementLeaveIcon =By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lnkReplacementLeave\"]");
    
    
    public void ReplacementLeaveIconClick() {
    	ClaimApplyPage claimApplyPage = new ClaimApplyPage(driver);
    	claimApplyPage.ClickAction(repalacementLeaveIcon);
	}
    
    
    
    
    
    
}
