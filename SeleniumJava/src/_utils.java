
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _utils extends testBase{
	
	//Global variables
	static JavascriptExecutor js = (JavascriptExecutor) driver; 
	static int coordNow = 0;
	static int coordBefore = 0;
	static FileInputStream fstream;
	static BufferedReader br;
	
	//	----------------------------------------------------------------------------------------------		NORMAL CLICKS -with wait until clickable
	//use normal wait click (id)
	static void clickById(String id) {
		checkPresentId(id, true);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		getCoordsById(element);
		element.click();
	}
	
	//use normal wait click (className)
	static void clickByClassName(String className) {
		checkPresentClassName(className, true);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
		getCoordsById(element);
		element.click();
	}
	
	//use normal wait click (xpath)
	static void clickByXpath(String xpath) {
		checkPresentXpath(xpath, true);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		getCoordsById(element);
		element.click();
	}
	
	//use normal wait click (name)
	static void clickByName(String name) {
		checkPresentName(name, true);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
		getCoordsById(element);
		element.click();
	}
	
	//use normal wait click (css)    	Ex: "a[class='q qs']" for "Bilder" at google
	static void clickByCss(String css) {
		checkPresentCss(css, true);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
		getCoordsById(element);
		element.click();
	}
	
	//	----------------------------------------------------------------------------------------------		NORMAL CLICKS JAVASCRIPT
	//use if JavaScript needed (id)
	static void clickByIdJS(String id) {
		checkPresentId(id, true);
		js.executeScript("arguments[0].click();", driver.findElement(By.id(id)));
	}

	//use if JavaScript needed (className)
	static void clickByClassNameJS(String className) {
		checkPresentClassName(className, true);
		js.executeScript("arguments[0].click();", driver.findElement(By.className(className)));
	}

	//use if JavaScript needed (xpath)
	static void clickByXpathJS(String xpath) {
		checkPresentXpath(xpath, true);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
	}
	
	//use if JavaScript needed (xpath)
	static void clickByNameJS(String name) {
		checkPresentName(name, true);
		js.executeScript("arguments[0].click();", driver.findElement(By.name(name)));
	}
	
	//use if JavaScript needed (cssSelector)
	static void clickByCssJS(String css) {
		checkPresentCss(css, true);
		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(css)));
	}
	
	//	----------------------------------------------------------------------------------------------		CLICK ELEMENT NOT VISIBLE JAVASCRIPT
	//use if element not visible (id and JavaScript)
	static void clickNotVisibleIdJS(String id) {
		int ok_size=driver.findElements(By.id(id)).size();
		driver.findElements(By.id(id)).get(ok_size-1).click();
	}
	
	//use if element not visible (className and JavaScript)
	static void clickNotVisibleClassNameJS(String className) {
		int ok_size=driver.findElements(By.className(className)).size();
		driver.findElements(By.className(className)).get(ok_size-1).click();
	}
		
	//use if element not visible (xpath and JavaScript)
	static void clickNotVisibleXpathJS(String xpath) {
		//Example 		(By.xpath("//input[@type='submit']));
		int ok_size=driver.findElements(By.xpath(xpath)).size();
		driver.findElements(By.xpath(xpath)).get(ok_size-1).click();
	}
	
	//use if element not visible (name and JavaScript)
	static void clickNotVisibleNameJS(String name) {
		int ok_size=driver.findElements(By.name(name)).size();
		driver.findElements(By.name(name)).get(ok_size-1).click();
	}
	
	//use if element not visible (cssSelector and JavaScript)
	static void clickNotVisibleCssJS(String css) {
		int ok_size=driver.findElements(By.cssSelector(css)).size();
		driver.findElements(By.cssSelector(css)).get(ok_size-1).click();
	}
		
	//	----------------------------------------------------------------------------------------------		SEND KEYS
	//use if need to send keys with (id)
	static void sendKeysId(String id, String keysToSend) {
		checkPresentId(id, true);
		WebElement element = driver.findElement(By.id(id));
		getCoordsById(element);
		driver.findElement(By.id(id)).clear();
		sleep(100);
		driver.findElement(By.id(id)).sendKeys(keysToSend);
	}
	
	//use if need to send keys with (className)
	static void sendKeysClassName(String className, String keysToSend) {
		checkPresentClassName(className, true);
		WebElement element = driver.findElement(By.className(className));
		getCoordsById(element);
		driver.findElement(By.className(className)).clear();
		sleep(100);
		driver.findElement(By.className(className)).sendKeys(keysToSend);
	}
	
	//use if need to send keys with (xpath)
	static void sendKeysXpath(String xpath, String keysToSend) {
		checkPresentXpath(xpath, true);
		WebElement element = driver.findElement(By.xpath(xpath));
		getCoordsById(element);
		driver.findElement(By.xpath(xpath)).clear();
		sleep(100);
		driver.findElement(By.xpath(xpath)).sendKeys(keysToSend);
	}
	
	//use if need to send keys with (name)
	static void sendKeysName(String name, String keysToSend) {
		checkPresentName(name, true);
		WebElement element = driver.findElement(By.name(name));
		getCoordsById(element);
		driver.findElement(By.name(name)).clear();
		sleep(100);
		driver.findElement(By.name(name)).sendKeys(keysToSend);
	}
	
	//use if need to send keys with (css)
	static void sendKeysCssSelector(String css, String keysToSend) {
		checkPresentCss(css, true);
		WebElement element = driver.findElement(By.cssSelector(css));
		getCoordsById(element);
		driver.findElement(By.cssSelector(css)).clear();
		sleep(100);
		driver.findElement(By.cssSelector(css)).sendKeys(keysToSend);
	}
	
	//	----------------------------------------------------------------------------------------------		Check is present
	static boolean checkPresentCss(String element, Boolean dontBypass) {
		
			try{
		        testBase.driver.findElement(By.cssSelector(element));
		        return true;
		    }catch (NoSuchElementException e) {
				    	if (dontBypass == true) {
				    		getScreenshot();
				    		print("'CssSelector' " + element + " - is not found...\n");
				        return false;
				    	}
				    	else {
				    		return false;
				    	}
		    }
	}
	
	static boolean checkPresentId(String element, Boolean dontBypass) {
		
		try{
	        testBase.driver.findElement(By.id(element));
	        return true;
	    }catch (NoSuchElementException e) {
			    	if (dontBypass == true) {
			    		getScreenshot();
			    		print("'Id' " + element + " - is not found...\n");
			        return false;
			    	}
			    	else {
			    		return false;
			    	}
	    }
	}
	
	static boolean checkPresentClassName(String element, Boolean dontBypass) {
		
		try{
	        testBase.driver.findElement(By.className(element));
	        return true;
	    }catch (NoSuchElementException e) {
			    	if (dontBypass == true) {
			    		getScreenshot();
			    		print("'clasName' " + element + " - is not found...\n");
			        return false;
			    	}
			    	else {
			    		return false;
			    	}
	    }
	}
	
	static boolean checkPresentXpath(String element, Boolean dontBypass) {
		
		try{
	        testBase.driver.findElement(By.xpath(element));
	        return true;
	    }catch (NoSuchElementException e) {
			    	if (dontBypass == true) {
			    		getScreenshot();
			    		print("'Xpath' " + element + " - is not found...\n");
			        return false;
			    	}
			    	else {
			    		return false;
			    	}
	    }
	}
	
	static boolean checkPresentName(String element, Boolean dontBypass) {
		
		try{
	        testBase.driver.findElement(By.name(element));
	        return true;
	    }catch (NoSuchElementException e) {
			    	if (dontBypass == true) {
			    		getScreenshot();
			    		print("'name' " + element + " - is not found...\n");
			        return false;
			    	}
			    	else {
			    		return false;
			    	}
	    }
	}
	
	//	----------------------------------------------------------------------------------------------		GET ASSERT ELEMENT
	//Use this to assert a string with element id
	static void assertThisId(String assertElementStr, String expectedString) {
		checkPresentId(assertElementStr, true);
		String realString = driver.findElement(By.id(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.id(assertElementStr)).size() == 0;
		checkAssert(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element className
	static void assertThisClassName(String assertElementStr, String expectedString) {
		checkPresentClassName(assertElementStr, true);
		String realString = driver.findElement(By.className(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.className(assertElementStr)).size() == 0;
		checkAssert(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element Xpath
	static void assertThisXpath(String assertElementStr, String expectedString) {
		checkPresentXpath(assertElementStr, true);
		String realString = driver.findElement(By.xpath(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.xpath(assertElementStr)).size() == 0;
		checkAssert(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element name
	static void assertThisName(String assertElementStr, String expectedString) {
		checkPresentName(assertElementStr, true);
		String realString = driver.findElement(By.name(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.name(assertElementStr)).size() == 0;
		checkAssert(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element Css
	static void assertThisCss(String assertElementStr, String expectedString) {
		checkPresentCss(assertElementStr, true);
		String realString = driver.findElement(By.cssSelector(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.cssSelector(assertElementStr)).size() == 0;
		checkAssert(exist, expectedString, realString);
	}
	
	//	----------------------------------------------------------------------------------------------		GET ASSERT ELEMENT CONTAINS
	//Use this to assert a string with element id
	static void assertContainsId(String assertElementStr, String expectedString) {
		checkPresentId(assertElementStr, true);
		String realString = driver.findElement(By.id(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.id(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element className
	static void assertContainsClassName(String assertElementStr, String expectedString) {
		checkPresentClassName(assertElementStr, true);
		String realString = driver.findElement(By.className(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.className(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element Xpath
	static void assertContainsXpath(String assertElementStr, String expectedString) {
		checkPresentXpath(assertElementStr, true);
		String realString = driver.findElement(By.xpath(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.xpath(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//
	//Use this to assert a string with element name
	static void assertContainsName(String assertElementStr, String expectedString) {
		checkPresentName(assertElementStr, true);
		String realString = driver.findElement(By.name(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.name(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element Css
	static void assertContainsCss(String assertElementStr, String expectedString) {
		checkPresentCss(assertElementStr, true);
		String realString = driver.findElement(By.cssSelector(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.cssSelector(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	
	//	----------------------------------------------------------------------------------------------		GET ASSERT ELEMENT DONT CONTAINS
	//Use this to assert a string with element id
	static void assertDontContainsId(String assertElementStr, String expectedString) {
		checkPresentId(assertElementStr, true);
		String realString = driver.findElement(By.id(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.id(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element className
	static void assertDontContainsClassName(String assertElementStr, String expectedString) {
		checkPresentClassName(assertElementStr, true);
		String realString = driver.findElement(By.className(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.className(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element Xpath
	static void assertDontContainsXpath(String assertElementStr, String expectedString) {
		checkPresentXpath(assertElementStr, true);
		String realString = driver.findElement(By.xpath(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.xpath(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//
	//Use this to assert a string with element name
	static void assertDontContainsName(String assertElementStr, String expectedString) {
		checkPresentName(assertElementStr, true);
		String realString = driver.findElement(By.name(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.name(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	
	//Use this to assert a string with element Css
	static void assertDontContainsCss(String assertElementStr, String expectedString) {
		checkPresentCss(assertElementStr, true);
		String realString = driver.findElement(By.cssSelector(assertElementStr)).getText();
		Boolean exist = driver.findElements(By.cssSelector(assertElementStr)).size() == 0;
		checkAssertContains(exist, expectedString, realString);
	}
	//	----------------------------------------------------------------------------------------------		ASSERT 
	static void checkAssert(Boolean exist, String expectedString, String realString) {
		if (exist == false) {
			try{
				assertEquals(expectedString, realString);
				passOrFail = 1;
				passedAssert++;
				print("Assert Passed!");
			}catch(AssertionError e){
				passOrFail = 0;
				failedAssert++;
				print("Assert Failed! \n\nExpected: \n" + expectedString + "\nWas: \n" + realString);
				testBase.errors++;
			}
		}
		else {
			print("assertElement not found.");
			failedAssert++;
		}
	}
	
	//	----------------------------------------------------------------------------------------------		ASSERT CONTAINS
	static void checkAssertContains(Boolean exist, String expectedString, String realString) {
		if (exist == false) {
			if(realString.contains(expectedString)) {
				passOrFail = 1;
				passedAssert++;
				print("Assert Passed!");
			}
			else {
				passOrFail = 0;
				failedAssert++;
				print("Assert Failed! \n\nExpected: \n" + expectedString + "\nWas: \n" + realString);
				testBase.errors++;
			}
		}
		else {
			print("assertElement not found.");
			failedAssert++;
			}
	}
	
	//	----------------------------------------------------------------------------------------------		ASSERT DONT CONTAINS
	static void checkAssertDontContains(Boolean exist, String expectedString, String realString) {
		if (exist == false) {
			if(!realString.contains(expectedString)) {
				passOrFail = 1;
				passedAssert++;
				print("Assert Passed!");
			}
			else {
				passOrFail = 0;
				failedAssert++;
				print("Assert Failed! \n\nExpected: \n" + expectedString + "\nWas: \n" + realString);
				testBase.errors++;
			}
		}
		else {
			print("assertElement not found.");
			failedAssert++;
			}
	}
	
	//	----------------------------------------------------------------------------------------------		SUBMIT
	//submit element by id
	static void submitId(String str) {
		checkPresentId(str, true);
		WebElement element = driver.findElement(By.name(str));
		element.submit();
	}
	
	//submit element by className
	static void submitClassName(String str) {
		checkPresentClassName(str, true);
		WebElement element = driver.findElement(By.name(str));
		element.submit();
	}
	
	//submit element by xpath
	static void submitXpath(String str) {
		checkPresentXpath(str, true);
		WebElement element = driver.findElement(By.name(str));
		element.submit();
	}
	
	//submit element by name
	static void submitName(String str) {
		checkPresentName(str, true);
		WebElement element = driver.findElement(By.name(str));
		element.submit();
	}
	
	//submit element by name
	static void submitCss(String str) {
		checkPresentCss(str, true);
		WebElement element = driver.findElement(By.cssSelector(str));
		element.submit();
	}
	
	//	----------------------------------------------------------------------------------------------		SCROLL - Check if element is to high or low, then scroll
	// Get coordinates of an Element
	
	//NEED RE-WRITE -INNERWINDOW
	
	static void getCoordsById(WebElement element) {

		Point p = element.getLocation();
		int elementYPos = p.getY();
		coordNow = elementYPos;
		
		if (coordNow < coordBefore) {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("window.scrollBy(0,-200)", "");
		}
		else {
			//do nothing
		}
		coordBefore = coordNow;
	}
	
	//	----------------------------------------------------------------------------------------------		iFrame handle
	// handle iframe windows
	static void switchToIFrameCss(String element) {
		driver.switchTo().defaultContent();
		checkPresentCss(element, true);
		WebElement iFrame= driver.findElement(By.cssSelector(element));
		driver.switchTo().frame(iFrame);
	}
	
	static void switchToIFrameId(String element) {
		driver.switchTo().defaultContent();
		checkPresentId(element, true);
		WebElement iFrame= driver.findElement(By.id(element));
		driver.switchTo().frame(iFrame);
	}
	
	static void switchToIFrameClassName(String element) {
		driver.switchTo().defaultContent();
		checkPresentClassName(element, true);
		WebElement iFrame= driver.findElement(By.className(element));
		driver.switchTo().frame(iFrame);
	}
	
	static void switchToIFrameName(String element) {
		driver.switchTo().defaultContent();
		checkPresentName(element, true);
		WebElement iFrame= driver.findElement(By.name(element));
		driver.switchTo().frame(iFrame);
	}
	
	static void switchToIFrameXpath(String element) {
		driver.switchTo().defaultContent();
		checkPresentXpath(element, true);
		WebElement iFrame= driver.findElement(By.xpath(element));
		driver.switchTo().frame(iFrame);
	}
	
	static void switchOffIFrame() {
		driver.switchTo().defaultContent();
	}
	
	//	----------------------------------------------------------------------------------------------		UploadPic
	static void fileUploadId(String element, String pathToFile) {
		sleep(1500);
		checkPresentId(element, true);
		WebElement mm = driver.findElement(By.id(element));
		mm.sendKeys(pathToFile);
		sleep(1500);
	}
	static void fileUploadCss(String element, String pathToFile) {
		sleep(1500);
		checkPresentCss(element, true);
		WebElement mm = driver.findElement(By.cssSelector(element));
		mm.sendKeys(pathToFile);
		sleep(1500);
	}
	static void fileUploadClassName(String element, String pathToFile) {
		sleep(1500);
		checkPresentClassName(element, true);
		WebElement mm = driver.findElement(By.className(element));
		mm.sendKeys(pathToFile);
		sleep(1500);
	}
	static void fileUploadXpath(String element, String pathToFile) {
		sleep(1500);
		checkPresentXpath(element, true);
		WebElement mm = driver.findElement(By.xpath(element));
		mm.sendKeys(pathToFile);
		sleep(1500);
	}
	static void fileUploadName(String element, String pathToFile) {
		sleep(1500);
		checkPresentName(element, true);
		WebElement mm = driver.findElement(By.name(element));
		mm.sendKeys(pathToFile);
		sleep(1500);
	}
	
	//	----------------------------------------------------------------------------------------------		Get element text
	
	static void getTextFromElementCss(String element) {
		checkPresentCss(element, true);
		st_data.elementText = driver.findElement(By.cssSelector(element)).getText();
	}
	
	static void getTextFromElementID(String element) {
		checkPresentId(element, true);
		st_data.elementText = driver.findElement(By.id(element)).getText();
	}
	
	static void getTextFromElementClassName(String element) {
		checkPresentClassName(element, true);
		st_data.elementText = driver.findElement(By.className(element)).getText();
	}
	
	static void getTextFromElementXpath(String element) {
		checkPresentXpath(element, true);
		st_data.elementText = driver.findElement(By.xpath(element)).getText();
	}
	
	static void getTextFromElementName(String element) {
		checkPresentName(element, true);
		st_data.elementText = driver.findElement(By.name(element)).getText();
	}
	
//	----------------------------------------------------------------------------------------------		Get element attribute
	
	static void getAttributeFromElementCss(String element, String attribute) {
		checkPresentCss(element, true);
		st_data.elementText = driver.findElement(By.cssSelector(element)).getAttribute(attribute);
	}
	
	static void getAttributeFromElementID(String element, String attribute) {
		checkPresentId(element, true);
		st_data.elementText = driver.findElement(By.id(element)).getAttribute(attribute);
	}
	
	static void getAttributeFromElementClassName(String element, String attribute) {
		checkPresentClassName(element, true);
		st_data.elementText = driver.findElement(By.className(element)).getAttribute(attribute);
	}
	
	static void getAttributeFromElementXpath(String element, String attribute) {
		checkPresentXpath(element, true);
		st_data.elementText = driver.findElement(By.xpath(element)).getAttribute(attribute);
	}
	
	static void getAttributeFromElementName(String element, String attribute) {
		checkPresentName(element, true);
		st_data.elementText = driver.findElement(By.name(element)).getAttribute(attribute);
	}
	
	//	----------------------------------------------------------------------------------------------		Print wrapper
	
	static void print(String message) {
		
		if (testBase.silent != "NONE"){
			if(testBase.silentMessage == 1) {
				System.out.println("Shh, silent mode active");
				silentMessage = 0;
			}
			else {/*SHHHH*/}
		}
		else {
			System.out.print("\n" + message);
		}
	}
	
	//	----------------------------------------------------------------------------------------------		CheckPopup (ST)
	static void checkPopUp() {
		//Need re-write
		sleep(2000);
		clickById(st_data.popUpEjMedlem);
		sleep(500);
	}
	
	
	//	----------------------------------------------------------------------------------------------		SLEEP (if needed)
	//sleep x
	static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
			print("Sleep failed.");
		}
	}
	
	//	----------------------------------------------------------------------------------------------		Get current timestamp
	static String getTimestamp (String str) {
		//create timestamp
		Date date = new Date( );															
		SimpleDateFormat ft = 															
	    new SimpleDateFormat ("yyyy.MM.dd'_'hh-mm-ss");
		str = ft.format(date);
		return str;
	}
	
	//	----------------------------------------------------------------------------------------------		Take screenshot on regular tests
	static void getScreenshot() {	
		String timestamp = "";
		getTimestamp(timestamp);
		
        File scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(scrFile, new File(testBase.sourceFolder + testBase.testCase + "/" + testBase.testCase + "_" + timestamp));
		} catch (IOException e) {
			print("Attempt to take screenshot failed.");
			e.printStackTrace();
		}
        print("Screenshot captured!");
    }
	
	//	----------------------------------------------------------------------------------------------		Take screenshots test
	static void getScreenshotTest() {
		testBase.outputFilename = "0-files.txt";
		
		String folderName = getBaseUrlFormated();
	
		String timestamp = "";
		getTimestamp(timestamp);
		String outputFolder = testBase.sourceFolder + "Screenshots/"+ folderName + "_" + testBase.startTime + "/";
		String tmp_output_filename = "tmp_name.jpg";
		
        File scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(scrFile, new File(outputFolder + tmp_output_filename));
		} catch (IOException e) {
			print("Attempt to take screenshot failed.");
			testBase.errors++;
			e.printStackTrace();
		}
        renameScreenshot(outputFolder, tmp_output_filename);
    }
	
	//	----------------------------------------------------------------------------------------------		rename a screenshot
	static void renameScreenshot(String outputFolder, String tmp_output_filename) {
		//Do this, generate a real filename
		testBase.counter++;
		
		getCurrentUrlFormated();
		String final_name = counter + "_" + currentURL + ".jpg";
		
		File tmp_file = new File(outputFolder + tmp_output_filename);
		File file = new File(outputFolder + final_name);
		
		boolean success = tmp_file.renameTo(file);
		if (success == true) {/*Do nothing*/}
		else
			print("Did not succed to rename file");
		
		print(final_name + " -saved");
		logWrite(final_name, outputFolder);
	}
	
	//	----------------------------------------------------------------------------------------------		Read input file
	static void readInputFile() {
		
		try {
			fstream = new FileInputStream(testBase.inputFilename);
			br = new BufferedReader(new InputStreamReader(fstream));
	
			String nextLine;
	
			while ((nextLine = br.readLine()) != null)   
			{
				driver.navigate().to(nextLine);
				sleep(100);
				readInputDoNext();		// Depending on which testCase is active, it will do different things
			}
		}
		catch (IOException e) {
			_utils.print("Error: Could not read input file! File source: " + fstream);
			testBase.errors++;
		}
	}
	
	//	----------------------------------------------------------------------------------------------		This decides what to do after read input
	static void readInputDoNext() {
		if (testBase.testCase.equals("screenshot_test")) {		//Depending of which testCase is active, do different things
			getScreenshotTest();									//Example, if screenshot_test is testCase, it will call getScreenshotTest();
		}
		else {
			print("Dont know what to do with tis input file! File source: " + testBase.inputFilename);
		}
	}
	
	//	----------------------------------------------------------------------------------------------		Get the current URL formatted, remove '/' etc
	static void getCurrentUrlFormated() {
		currentURL = driver.getCurrentUrl();
			currentURL = currentURL.replace("http://","");
			currentURL = currentURL.replace("https://","");
			currentURL = currentURL.replace(" ","");
			currentURL = currentURL.replace("/","_");
	}
	
	//	----------------------------------------------------------------------------------------------		Get the current URL formatted, remove '/' etc
	static String getBaseUrlFormated() {
		String returnThis;
		returnThis = url.replace("http://","");
		returnThis = url.replace("https://","");
		returnThis = url.replace(" ","");
		returnThis = url.replace("/","_");
		returnThis = url.replace("www.","");
		return returnThis;
	}
	
	//	----------------------------------------------------------------------------------------------		Will provide a txt to get all files inside folder
	static void getFilelistFromFolder() {
		File folder = new File(testBase.sourceFolder);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        print("" + listOfFiles[i].getName());
		        logWrite(listOfFiles[i].getName(), testBase.sourceFolder);
		      } else if (listOfFiles[i].isDirectory()) {
			    logWrite(listOfFiles[i].getName(), testBase.sourceFolder);
		      }
		    }
	}
	
	//	----------------------------------------------------------------------------------------------		Write to a log file
	static void logWrite(String logThis, String folder) {																					
																									
		try(FileWriter fw = new FileWriter(folder + testBase.outputFilename, true);			
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter log = new PrintWriter(bw))
		{
			log.println(logThis);
		} catch (IOException e) 
		{
			sleep(50);
		}
	}
}
