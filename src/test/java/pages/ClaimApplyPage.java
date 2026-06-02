package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ClaimApplyPage {
	static WebDriver driver;

    public  ClaimApplyPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
}
    By applyClaim =By.linkText("Claims"); //ESS Apply Claim icon
    By multipleRadioBtn =By.xpath("(//*[@type='radio'])[2]"); //Multiple Radio button X path
    By clientDropDown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlClientMultiple']"); //Client DropDown X path
    By projectDropDown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlMultipleProject']"); //Project DropDown X path  
    By objectiveTextBox=By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtMultipleObjective']"); //Objective text box X path
    By claimDatePicker =By.xpath("(//*[@format='dd-mmm-yyyy'])[1]"); // Claim Date Picker X path 
    By receiptDatePicker =By.xpath("(//*[@format='dd-mmm-yyyy'])[2]"); //Receipt Date Picker X path
    By claimTypeDropdown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlClaimtypeMultiple']"); // Claim Type Drop down X path
    By companyNameText =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtCompanyNameMultiple']"); // Company name text X path
    By choosePersonRadioBtn =By.xpath("(//*[@name='ctl00$ContentPlaceHolder1$rblMultiplePerson'])[1]"); // Choose Person Radio Button X path
    By receiptNoText =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtReceiptNoMultiple']"); // Receipt no text box X path
    By glCodeDropDown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlMultipleGLCode']"); // GL Code Drop Down X path
    By issuerTextBox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtMultipleIssuer']"); // Issuer Text Box X path
    By detailsDropDown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$drpMultipleTypeDetails']"); // Details Drop Down X path
    By detailsTextBox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtMultipleDetails']"); // Details Text Box X path
    By additionalTextBox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtMultipleAdditional']"); //Additional Text Box X path
    By claimAmountTextBox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtClaimAmountMultiple']"); // Claim amount text box X path
    By descriptionTextBox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtDescriptionMultiple']"); // Description text box X path
    By attachmentField =By.id("ctl00_ContentPlaceHolder1_fileuploadMultiple"); // Attachment Id 
    By addBtn =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$BtnAdd']"); // Add button X path
    By confirmationPopUp =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$chkMultipleRequiredConfirm']"); //Confirmation Pop Up X path
    By saveButton =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$btnSaveDownMultiple']"); // Save Button X path
    By singleClientDropdown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlClient']"); //  Client Drop down Single Claim
    By singleProjectDropdown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlClient']"); // Project Drop down Single Claim
    By selectSingleClaimType =By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddlClaimtype']"); // Select Single Claim Type Single Claim
    By companyNameSingleClaim =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtCompanyName']"); //Enter the Company Name Single Claim
    By choosePersonSingleRadioBtn = By.xpath("(//*[@name='ctl00$ContentPlaceHolder1$rblSinglePerson'])[1]"); // Choose the Person Single Claim
    By receiptNoSingle =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtReceiptNo']"); //Enter Receipt No Randomly Single Claim
    By glCodeSingle =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$ddlSingleGLCode']"); // Select GL Code Single Claim
    By issuerTextBoxSingle= By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtIssuer']"); //Enter Issuer Text box Single Claim
    By detailsSingleDropdown =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$drpTypeDetails']"); //Select the Details Drop down Single Claim
    By detailsSingleTextbox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtMultipleDetails']");//Enter the Details Single Claim
    By additionalSingleTextbox =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtSingleAdditional']"); //Enter Additional text Single Claim
    By amountSingle =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtClaimAmount']"); //Enter the Amount Single Claim
    By descriptionsTextboxSingle =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$txtDescription']"); // Enter the Description Text Single Claim
    By attachmentSingle =By.xpath("//*[@name='ctl00$ContentPlaceHolder1$fileupload']"); // Add Attachment Single Claim
    By confirmationPopUpSingle =By.xpath("//*[@type='checkbox']"); //Confirmation Pop Up X path Single Claim
    By saveBtnSingle =By.xpath("(//*[@type='submit'])[2]"); // Click Save Button Single Claim
    
    public void WaitCondition(By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
//    public void WaitCondition(By Locator) {
//		WebDriver driver = DriverFactory.getDriver();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)); 
//	}
    
    public void ClickAction(By click) {
    	driver.findElement(click).click();
	}
    
    public void selectMethodByIndex (int count, By selectingElement) {   
  WebElement varaible = driver.findElement(selectingElement);    	    	
        Select s = new Select(varaible);
        s.selectByIndex(count);
    }
    public void selectMethodByVisibleText (String Text, By selectingElement) {   
    	  WebElement varaible = driver.findElement(selectingElement);    	    	
    	        Select s = new Select(varaible);
    	        s.selectByVisibleText(Text);
    	    }
   
    public void SendKeysAndClearMethod(By text, String value) {

        Actions actions = new Actions(driver);

        WaitCondition(text);

        driver.findElement(text).clear();

        actions.sendKeys(driver.findElement(text), value).perform();
    }
    
    
    public void MultipleClaim(int startValue, int endValue, String claimDate, String receiptDate, int amount)
            throws IOException, InterruptedException {
    	MultipleRatioBtn();

		try {
			SelectTheClient(1);
		} catch (Exception e) {
			System.out.println("Client field is not displayed");
		}
		try {
			SelectTheProject(1);
		} catch (Exception e) {
			System.out.println("Project field is not didplayed");
		}


    //    String claimDate = property.getProperty("ClaimDate");
        
    //    String receiptDate = property.getProperty("ReceiptDate");

     //   int amount = Integer.parseInt(property.getProperty("Amount"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = startValue; i <= endValue; i++) {

            // ENTER OBJECTIVE TEXT
            enterText(objectiveTextBox, "Objective " + i);

            // CLAIM DATE
            
            setValueUsingJS(claimDatePicker, claimDate);

            // RECEIPT DATE
            setValueUsingJS(receiptDatePicker, receiptDate);

            // CLAIM TYPE
            if (isElementDisplayed(claimTypeDropdown)) {

                Select s1 = new Select(driver.findElement(claimTypeDropdown));

                s1.selectByIndex(i);

                System.out.println("Claim Type Selected Index : " + i);
            }

            // COMPANY NAME
            enterText(companyNameText, "Company is ISCISTECH " + i);

            // PERSON RADIO BUTTON
            if (isElementDisplayed(choosePersonRadioBtn)) {

                WebElement person = driver.findElement(choosePersonRadioBtn);

                js.executeScript("arguments[0].click();", person);
            }

            // RECEIPT NUMBER
            setValueUsingJS(receiptNoText, "Receipt " + i);

            // GL CODE
            selectDropdown(glCodeDropDown, 1);

            // ISSUER
            setValueUsingJS(issuerTextBox, "Issuer " + i);

            // DETAILS DROPDOWN
            selectDropdown(detailsDropDown, 1);

            // DETAILS TEXT
            setValueUsingJS(detailsTextBox, "Details " + i);

            // ADDITIONAL TEXT
            setValueUsingJS(additionalTextBox, "Justification Text " + i);

            // CLAIM AMOUNT
            if (isElementDisplayed(claimAmountTextBox)) {

                WebElement claimAmount =
                        driver.findElement(claimAmountTextBox);

                claimAmount.clear();

                claimAmount.sendKeys(String.valueOf(amount + i));

                System.out.println("Claim Amount : " + (amount + i));
            }

            // DESCRIPTION
            enterText(descriptionTextBox, "Automated the Multiple Claim page " + i);

            // FILE UPLOAD
            uploadFileAttachemet();

            // CLICK ADD BUTTON
            if (isElementDisplayed(addBtn)) {

                WebElement addButton = driver.findElement(addBtn);

                wait.until(ExpectedConditions.elementToBeClickable(addButton));

                addButton.click();
            }
        }

        // CONFIRMATION CHECKBOX
        if (isElementDisplayed(confirmationPopUp)) {

            WebElement confirmationCheckBox =
                    driver.findElement(confirmationPopUp);

            confirmationCheckBox.click();
        }

        // SAVE BUTTON
        By saveButton =
                By.xpath("//*[@name='ctl00$ContentPlaceHolder1$btnSaveDownMultiple']");

        if (isElementDisplayed(saveButton)) {

            WebElement claimSave = driver.findElement(saveButton);

            wait.until(ExpectedConditions.elementToBeClickable(claimSave));

            claimSave.click();
            driver.navigate().refresh();
        }
    }
    
    
    
    public static boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }
    
    public static boolean isElementDisplayed(By locator) {

        return isElementPresent(locator) && driver.findElement(locator).isDisplayed();
    }
    
    public void enterText(By locator, String value) {

        if (isElementDisplayed(locator)) {

            WebElement element = driver.findElement(locator);

            element.clear();

            element.sendKeys(value);
        }
    }
    
    public static void selectDropdown(By locator, int index) {

        if (isElementDisplayed(locator)) {

            Select select = new Select(driver.findElement(locator));

            select.selectByIndex(index);
        }
    }
    
    public void setValueUsingJS(By locator, String value) {

        if (isElementDisplayed(locator)) {

            WebElement element = driver.findElement(locator);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].value=arguments[1];",element,value);
        }
    }
    
    public void uploadFile(By element) {

        String filePath =
                System.getProperty("user.dir")
                        + "/src/test/resources/dummy-pdf_2.pdf";

        File file = new File(filePath);

        if (file.exists() && isElementDisplayed(element)) {

            WebElement uploadAttachment =driver.findElement(element);

            uploadAttachment.sendKeys(file.getAbsolutePath());

            System.out.println("File uploaded successfully");
        }
        else {

            System.out.println("File not found : " + filePath);
        }
    }
     
 // ---------------------------------------------------------------------------------------------------------------------------  
    public void SingleClaim(String claimDate, String receiptDate) throws IOException {
    	//CHOOSE CLIENT DETAILS	
		try {
			SelectTheSingleClient(1);
		} catch (Exception e) {
			System.out.println("Client field is not didplayed");
		}
		
		//CHOOSE PROJECT DETAILS
		try {
			SelectTheSingleProject(1);
		} catch (Exception e) {
			System.out.println("Project field is not didplayed");
		}
    	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	//	 Properties property = Utilities.getProperty();

	   //     String claimDate = property.getProperty("ClaimDate");
	   //     String receiptDate = property.getProperty("ReceiptDate");
	        // CLAIM DATE
            setValueUsingJS(claimDatePicker, claimDate);

            // RECEIPT DATE
            setValueUsingJS(receiptDatePicker, receiptDate);
	     
//CHOOSE THE CLAIM TYPE
		
		ClaimTypeSelect();
		
//ENTER THE COMPANY NAME
		
        enterText(companyNameSingleClaim, "Company is Hr2eazy ");

// PERSON RADIO BUTTON
        if (isElementDisplayed(choosePersonSingleRadioBtn)) {

            WebElement person = driver.findElement(choosePersonSingleRadioBtn);

            js.executeScript("arguments[0].click();", person);
        }
//ENTER THE RECEIPT NO
		WebElement receiptNo = driver
				.findElement(receiptNoSingle);
		receiptNo.sendKeys(EnterRandomNumber());

		 // GL CODE
        selectDropdown(glCodeSingle, 1);

// ISSUER
        setValueUsingJS(issuerTextBoxSingle, "Issuer ");

// DETAILS DROPDOWN
        selectDropdown(detailsSingleDropdown, 1);

//DETAILS TEXT
setValueUsingJS(detailsSingleTextbox, "Details Text ");

// ADDITIONAL TEXT
        setValueUsingJS(additionalSingleTextbox, "Justification Text ");
		
//ENTER THE CLAIM AMOUNT                      
		WebElement claimAmount = driver
				.findElement(amountSingle);
		claimAmount.sendKeys(EnterRandomNumber1());
		

		// DESCRIPTION
        enterText(descriptionsTextboxSingle, "Automated the Single claim page");

//UPLOAD THE ATTCAHMENT
        uploadFileAttachemet1();
        
// CONFIRMATION CHECKBOX
        if (isElementDisplayed(confirmationPopUpSingle)) {

            WebElement confirmationCheckBox =
                    driver.findElement(confirmationPopUpSingle);

            confirmationCheckBox.click();
        }

//CLICK THE SAVE BUTTON
		WebElement ClaimSave = driver.findElement(saveBtnSingle);
		ClaimSave.click();
		
	}

	

    
 // Random Select By Index Method
    public void RandomSelectByIndex(By locator) {
    	 WebElement element = driver.findElement(locator);
    	 	
            Select select = new Select(element);

            // Get all dropdown options
            List<WebElement> options = select.getOptions();

            // Generate random index
            Random random = new Random();

            // Skip first option if it is "Select"
            int randomIndex = random.nextInt(options.size() - 1) + 1;

         // Print selected option
            System.out.println("Selected Option : "
                    + options.get(randomIndex).getText());

            
            
         // Select random option
            select.selectByIndex(randomIndex);
            
         
        }
 // Enter Random Number in Text Field
    public String EnterRandomNumber() {

        Random random = new Random();

        // Generate 5 digit random number
        int randomNumber = 10000 + random.nextInt(90000);

        System.out.println("Entered Random Number : " + randomNumber);

        return String.valueOf(randomNumber);
    }
	
 // Enter Random Number in Text Field
    public String EnterRandomNumber1() {

        Random random = new Random();

        // Generate 5 digit random number
        int randomNumber = 100 + random.nextInt(900);

        System.out.println("Entered Random Number : " + randomNumber);

        return String.valueOf(randomNumber);
    }
    public String getIncrementDate(String baseDate, int incrementDays) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        LocalDate date =
                LocalDate.parse(baseDate, formatter);

        LocalDate updatedDate =
                date.plusDays(incrementDays);

        return updatedDate.format(formatter);
    }
    
    
    public void ClaimTypeSelect() {
    	RandomSelectByIndex(selectSingleClaimType);
	}
    
    public void uploadFileAttachemet() {
    	uploadFile(attachmentField);

	}
    public void uploadFileAttachemet1() {
    	uploadFile(attachmentSingle);

	}
    
    public void ApplyClaimIcon() {
    	ClickAction(applyClaim);
	}
    public void MultipleRatioBtn() {
    	ClickAction(multipleRadioBtn);

	}
    public void SelectTheClient(int count) {
    	selectMethodByIndex(count,clientDropDown);

	}
    public void SelectTheProject(int count) {
    	selectMethodByIndex(count,projectDropDown);

	}
   
    public void EnterObjectiveTextBox(String i) {
		SendKeysAndClearMethod(objectiveTextBox, i);
	}
    public void SelectTheSingleClient(int count) {
    	selectMethodByIndex(count,singleClientDropdown);

	}
    public void SelectTheSingleProject(int count) {
    	selectMethodByIndex(count,singleProjectDropdown);
	}
   
	
   
	}
    
