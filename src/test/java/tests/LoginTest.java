package tests;


import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.ApplyPermission;
import pages.ClaimApplyPage;
import pages.LeaveCancelApply;
import pages.LoginPage;
import utilities.Utilities;


@Listeners(reports.TestListener.class)
public class LoginTest extends BaseClass {
	

	@Test(dataProvider = "MultipleClaimData",dataProviderClass = Utilities.class,enabled=true)
	
	public void MultipleClaim(String username, String password,String claimDate, String receiptDate,int amount) throws  InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);

	    System.out.println("Logging in with : " + username);

	    loginPage.LoginUserName(username);
	    loginPage.LoginUserPass(password);
	    loginPage.ClickAction();

	    try {
	        loginPage.InformationPanel();
	    } catch (Exception e) {
	    }
		ClaimApplyPage claimApplyPage = new ClaimApplyPage(driver);
		claimApplyPage.ApplyClaimIcon();
		claimApplyPage.MultipleClaim(1, 2, claimDate, receiptDate, amount);
			
	}
	@Test(dataProvider = "SingleClaimData",dataProviderClass = Utilities.class,priority=1,enabled=true)
	public void SingleClaim(String username, String password,String claimDate, String receiptDate) throws IOException {
		LoginPage loginPage = new LoginPage(driver);

	    System.out.println("Logging in with : " + username);

	    loginPage.LoginUserName(username);
	    loginPage.LoginUserPass(password);
	    loginPage.ClickAction();

	    try {
	        loginPage.InformationPanel();
	    } catch (Exception e) {
	    }
		ClaimApplyPage claimApplyPage = new ClaimApplyPage(driver);
		claimApplyPage.ApplyClaimIcon();
		claimApplyPage.SingleClaim(claimDate, receiptDate);
		driver.navigate().refresh();
	}
	
	
	@Test(dataProvider = "PermissionData",dataProviderClass = Utilities.class,enabled=true)
	public void ApplyPermission(String username, String password,String permissionDate) throws IOException {
		 LoginPage loginPage = new LoginPage(driver);

		    System.out.println("Logging in with : " + username);

		    loginPage.LoginUserName(username);
		    loginPage.LoginUserPass(password);
		    
		    loginPage.ClickAction();

		    try {
		        loginPage.InformationPanel();
		    } catch (Exception e) {
		    }
		ApplyPermission applypermission=new ApplyPermission(driver);
		
		applypermission.ApplyPermissionIconClick();
		applypermission.ApplyPermissionPortal(permissionDate);	
		driver.navigate().refresh();
	}
	@Test(dataProvider = "leaveData",dataProviderClass = Utilities.class,enabled=true)
	public void ApplyLeave(String username, String password,String fromDate, String toDate)  throws IOException, InterruptedException{
		LoginPage loginPage = new LoginPage(driver);

	    System.out.println("Logging in with : " + username);

	    loginPage.LoginUserName(username);
	    loginPage.LoginUserPass(password);
	    loginPage.ClickAction();

	    try {
	        loginPage.InformationPanel();
	    } catch (Exception e) {
	    }
		pages.ApplyLeave applypermission=new pages.ApplyLeave(driver);
		applypermission.ApplyLeaveIconCLick();
		applypermission.ApplyLeavePortal(fromDate, toDate);
		driver.navigate().refresh();

	}
	
	@Test(dataProvider = "loginData",dataProviderClass = Utilities.class,enabled=false)
	public void ApplyLeaveCancel(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);

	    System.out.println("Logging in with : " + username);

	    loginPage.LoginUserName(username);
	    loginPage.LoginUserPass(password);
	    loginPage.ClickAction();

	    try {
	        loginPage.InformationPanel();
	    } catch (Exception e) {
	    }
		LeaveCancelApply cancelLeave=new LeaveCancelApply(driver);
		cancelLeave.ApplyLeaveCancelIconCLick();
		cancelLeave.ApplyCancelLeave();

	}

}
