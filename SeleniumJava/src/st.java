import java.io.IOException;

import org.openqa.selenium.By;

public class st extends st_data { /*	
	 
	Available/Done tests.
	-----------------
		nyhet_SkrivNyhet_Test			-	Will create 3 news with different visibility (All, member, förtroendevald)
		nyhet_RaderaNyhet_Test			-	Should be run after nyhet_SkrivNyhet_Test to have something to remove
		-----------
		nyhet_Avpublicera_Test			-	Will test that you can unpublish news
		nyhet_Publicera_Test				-	Will test that you can publish news
		-----------
		startsida_Redigera_Test			-	Will test that you can edit the startpage
		-----------
		laggTill_Sida_Test				-	Will test that you can add a Sida 
		radera_Sida_Test					-	Will test that you can edit a Sida
		
	Under development.
	-----------------
	
		laggTill_Sida_Test				-	Done (Need testing with stable connection)
		radera_Sida_Test				-	Done (Need testing with stable connection)
		
		laggTill_Arbetsmaterial_Test
		laggTill_Avtal_Test
		laggTill_Protokoll_Test
  
	 Planned tests:
	 -----------------
		 nyhet_SynligForAlla_Test
		 nyhet_SynligForMedlem_Test
		 nyhet_SynligForFortroendevald_Test
		 
		 laggTill_Kalenderhandelse_Test
		 laggTill_Arbetsmaterial_Test
		 laggTill_Avtal_Test
		 laggTill_Protokoll_Test
		 laggTill_SocialaMedier_Test
		 
		 radera_Kalenderhandelse_Test
		 radera_Arbetsmaterial_Test
		 radera_Avtal_Test
		 radera_Protokoll_Test
		 radera_SocialaMedier_Test
	 
	*/ 
	//----------------------------------------------------------------------------------------------------//
	//-Test which will create 3 news articles all with different visibility (All, Member, Förtroendevald)-//
	//----------------------------------------------------------------------------------------------------//	
	public static void nyhet_SkrivNyhet_Test() { 
		if(st_data.counter == 1) {
			//The first loop of this script we will need to login and navigate to SkrivNyhet, which we wont need the seconds time
			login();
			navigateToNyheter();
			_utils.clickByXpath(buttonSkapaNyheter);
		}
		else {
			//Dont navigate through login, just click the button skapa nyheter
			_utils.clickByXpath(buttonSkapaNyheter);
		}
		
		nyhetCheckVisibility();
		nyhetSkriv();
		_utils.assertContainsCss(st_data.nyheterMessage, "Perfekt!");
		counter++;
		
		_utils.clickByXpath(goToNyheter);
		nyheterAssertVisible();
		
		//Make 3 loops news articles with all 3 visibilities
		if (st_data.counter > 3) {
			//
		}
		else {
			nyhet_SkrivNyhet_Test();
		}
	}
	
	public static void screenshot_test() {
		_utils.readInputFile();
	}
	
	//----------------------------------------------------------------------------------------------------//
	//-------------Test to see if edtor is able to create a "Sida" on avdelning or sektion----------------//
	//----------------------------------------------------------------------------------------------------//
	public static void laggTill_Sida_Test() {
		if (counter == 1) {
			login();
			_utils.clickByCss(hanteraAvdSek);	// at startsida
			_utils.clickByXpath(goToAvdelningOrSektion);
		}
		else {
			//Do nothing
		}
		
		_utils.clickByXpath(goToSida);
		_utils.clickByCss(buttonSkapaSida);
		
		if(counter == 1) 
			_utils.sendKeysId(sidaTitle, "Selenium test sida no. " + counter + "No pic, Visible to All");
		else if (counter == 2)
			_utils.sendKeysId(sidaTitle, "Selenium test sida no. " + counter + "Pic under title, Visible to Members");
		else if (counter == 3)
			_utils.sendKeysId(sidaTitle, "Selenium test sida no. " + counter + "Pic on title, Visible to Elected");
		else if (counter == 4) 
			_utils.sendKeysId(sidaTitle, "Selenium test sida no. " + counter + "Video under title, Visible to All");
		else {
			//Do nothing
		}
		
		_utils.sendKeysId(sidaMenuTitle, "Selenium Test " + counter);
		
		if (counter == 1) {
			_utils.clickById(sidaRadioTitleUnderPic);
			_utils.sleep(500);
			_utils.clickById(sidaRadioOnlyTitle);
		}
		else if (counter == 2)
			_utils.clickById(sidaRadioTitleUnderPic);
		else if (counter == 3)
			_utils.clickById(sidaRadioTitleOnPic);
		else if (counter == 4)
			_utils.clickById(sidaRadioTitleUnderVideo);
		else {
			//Do nothing
		}
		
		_utils.switchOffIFrame();
		_utils.switchToIFrameCss(sidaBrodtext);
		_utils.sendKeysCssSelector(skapaNyhetBrodtext, "This is a test brödtext for a Sida");
		_utils.switchOffIFrame();
		
		_utils.fileUploadId(sidaUploadFile, exampleDocumentPdf);
		
		if (counter == 1) {
			_utils.clickByCss(sidaVisibleToMembers);
			_utils.sleep(500);
			_utils.clickByCss(sidaVisibleToAll);
		}
		else if (counter == 2) {
			_utils.clickByCss(sidaVisibleToMembers);
		}
		else if (counter == 3) {
			_utils.clickByCss(sidaVisibleToElected);
		}
		else {
			_utils.clickByCss(sidaVisibleToAll);
		}
		
		// TODO CHECK IF PUBLISHED IS CHECKED ELSE DO IT
		
		_utils.clickById(sidaButtonSpara);
		
		if (counter > 4) {
			//Done
		}
		else {
			counter++;
			laggTill_Sida_Test();
		}		
	}
	
	public static void laggTill_Arbetsmaterial_Test() {
		login();
		_utils.clickByXpath(goToArbetsmaterial);
	}
	
	//----------------------------------------------------------------------------------------------------//
	//------------Test to see if editor is able to remove "sida" on avdelning or sektion------------------//
	//----------------------------------------------------------------------------------------------------//
	public static void radera_Sida_Test() {
		//First loop will need login 
		if (counter == 1) {
			login();
			_utils.clickByCss(hanteraAvdSek);	// at startsida
			_utils.clickByXpath(goToAvdelningOrSektion);
			}
		else {
			//Do nothing
		}
		
		_utils.clickByXpath(goToSida);
		
		//Check to see if any existing selenium "Sida" exist, then remove it 
		isPresent = _utils.checkPresentCss(sidaInTableTitle, true);
		
		if(isPresent == true) {
			//Get the news title, if there is some left, delete them
			_utils.getTextFromElementCss(sidaInTableTitle);
			
			if (elementText.contains("Selenium test sida no. ")) {
				_utils.clickByCss(nyheterRedigera);
				_utils.sleep(1000);
				_utils.getAttributeFromElementID(skapaNyhetTitle, "value");
				if (elementText.contains("Selenium test sida no. ")) {
					_utils.clickById(nyheterRadera);
					_utils.clickById(nyheterRaderaConfirm);
					_utils.assertContainsCss(st_data.nyheterMessage, "Perfekt!");
				}
				else {
					System.out.println("No more Sidor to remove or (Selenium test sida no. ) not visible - " + elementText);
					st_data.stillTrue = 0;
				}
			}
			else {
				System.out.println("No more news to remove or (Selenium test sida no. ) not visible");
				st_data.stillTrue = 0;
			}
		}
		else {
			st_data.stillTrue = 0;
		}
		
		//Will remove news untill it cant find anymore news uploaded by this script
		if (st_data.stillTrue == 0) {/*Do nothing = DONE*/}
		else
			radera_Sida_Test();
	}
	
	//----------------------------------------------------------------------------------------------------//
	//---------Test to see if edtor is able to edit the 'Startsida' for Avdelning or Sektion--------------//
	//----------------------------------------------------------------------------------------------------//
	public static void startsida_Redigera_Test() {
		login();
		_utils.clickByCss(hanteraAvdSek);	// at startsida
		_utils.clickByXpath(goToAvdelningOrSektion);
		_utils.sendKeysId(skapaNyhetIngress, "This is a test ingress for a Sida");
		_utils.switchOffIFrame();
		_utils.switchToIFrameCss(iFrameBrodText);						//Switch to iFrame
		_utils.sendKeysCssSelector(skapaNyhetBrodtext, "This is a test brödtext for a Sida");
		_utils.switchOffIFrame();
		_utils.clickById(buttonNyhetSpara);
		_utils.assertContainsCss(st_data.nyheterMessage, "Perfekt!");
		_utils.clickByXpath(goToStartsida);
		_utils.assertThisId(skapaNyhetIngress, "This is a test ingress for a Sida");
	}
	
	//----------------------------------------------------------------------------------------------------//
	//--------------------Test will unpublish a nyhet and verify that it is unpublished-------------------//
	//----------------------------------------------------------------------------------------------------//
	public static void nyhet_Avpublicera_Test() {
		if (stillTrue == 1) {
		login();
		navigateToNyheter();
		}
		else {
		//Do nothing
		}

		isPresent = _utils.checkPresentCss(nyheterTitle, true);
		
		if(isPresent == true) {
			//Get the news title, if there is some left, delete them
			_utils.getTextFromElementCss(nyheterTitle);
			_utils.clickByCss(nyheterRedigera);
			_utils.getTextFromElementCss(labelIsPublished);
			
			if (elementText.contains("Ej publicerat")) {
				_utils.sleep(1000);
				_utils.clickById(buttonNyhetSpara);
			}
			else {
				_utils.clickByIdJS(checkboxPublicerat);
				_utils.clickById(buttonNyhetSpara);
			}
			_utils.assertContainsCss(st_data.labelIsPublishedTitle, "(Ej publicerad)");
		}
		else { //If no news is publish, create one to test with
			System.out.println("No news available - creating one");
			_utils.clickByXpath(buttonSkapaNyheter);
			nyhetCheckVisibility();
			nyhetSkriv();
			_utils.assertContainsCss(st_data.nyheterMessage, "Perfekt!");
			_utils.clickByXpath(goToNyheter);
			nyheterAssertVisible();
			stillTrue = 0;
			_utils.print("Running " + testBase.testCase + " again");
			nyhet_Avpublicera_Test();
		}
	}
	
	//----------------------------------------------------------------------------------------------------//
	//----------------------Test will Publish a nyhet and verify that it is Published---------------------//
	//----------------------------------------------------------------------------------------------------//
	public static void nyhet_Publicera_Test() {
		
		if (stillTrue == 1) {
			login();
			navigateToNyheter();
		}
		else {
			//Do nothing
		}

		isPresent = _utils.checkPresentCss(nyheterTitle, true);
		
		if(isPresent == true) {
			//Get the news title, if there is some left, delete them
			_utils.getTextFromElementCss(nyheterTitle);
			_utils.clickByCss(nyheterRedigera);
			_utils.getTextFromElementCss(labelIsPublished);
			
			if (!elementText.contains("Ej publicerat")) {
				_utils.sleep(1000);
				_utils.clickById(buttonNyhetSpara);
			}
			else {
				_utils.clickByIdJS(checkboxPublicerat);
				_utils.clickById(buttonNyhetSpara);
			}
			_utils.assertContainsCss(st_data.nyheterMessage, "Perfekt!");		//Assert perfekt!
			_utils.clickByXpath(goToNyheter);
			//_utils.assertDontContainsCss(st_data.labelIsPublishedTitle, "(Ej publicerad)");	//Assert that this does not show
			//assert EJ publicerat element is not showing
			isPresent = _utils.checkPresentCss(labelIsPublishedTitle, true);
			if(isPresent == true) {
				//Fail
				_utils.passOrFail = 0;
				_utils.failedAssert++;
				System.out.println("Assert Failed! \n\nExpected: \nElement NOT present\nWas: \nElement Present");
				testBase.errors++;
			}
			else {
				//Pass
				_utils.passOrFail = 1;
				_utils.passedAssert++;
				System.out.println("Assert Passed!");
			}
				
			}
			else {
				System.out.println("No news available - creating one");
				_utils.clickByXpath(buttonSkapaNyheter);
				nyhetCheckVisibility();
				nyhetSkriv();
				_utils.assertContainsCss(st_data.nyheterMessage, "Perfekt!");
				_utils.clickByXpath(goToNyheter);
				nyheterAssertVisible();
				stillTrue = 0;
				_utils.print("Running " + testBase.testCase + " again");
				nyhet_Publicera_Test();
			}
	}
	
	//----------------------------------------------------------------------------------------------------//
	//----------Test which will delete all news with the name (Test Nyhet Selenium no. x)-----------------//
	//----------------------------------------------------------------------------------------------------//
	public static void nyhet_RaderaNyhet_Test() {
		if(st_data.counter == 1) {
			login();
			counter++;
			_utils.clickByCss(hanteraAvdSek);
			_utils.clickByXpath(goToAvdelningOrSektion);
			_utils.clickByXpath(goToNyheter);
		}
		else {
			_utils.clickByXpath(goToNyheter);
		}
		
		//if element exist
		isPresent = _utils.checkPresentCss(nyheterTitle, false);
		
		if(isPresent == true) {
			//Get the news title, if there is some left, delete them
			_utils.getTextFromElementCss(nyheterTitle);
			
			if (elementText.contains("Test Nyhet Selenium no. ")) {
				_utils.clickByCss(nyheterRedigera);
				_utils.sleep(1000);
				_utils.getAttributeFromElementID(skapaNyhetTitle, "value");
				if (elementText.contains("Test Nyhet Selenium no. ")) {
					_utils.clickById(nyheterRadera);
					_utils.clickById(nyheterRaderaConfirm);
					_utils.assertContainsCss(st_data.nyheterMessage, "Perfekt!");
				}
				else {
					System.out.println("No more news to remove or (Test Nyhet Selenium no. ) not visible - " + elementText);
					st_data.stillTrue = 0;
				}
			}
			else {
				System.out.println("No more news to remove or (Test Nyhet Selenium no. ) not visible");
				st_data.stillTrue = 0;
			}
		}
		else {
			System.out.println("No more news to remove or (Test Nyhet Selenium no. ) not visible");
			st_data.stillTrue = 0;
		}
		
		//Will remove news untill it cant find anymore news uploaded by this script
		if (st_data.stillTrue == 0) {/*Do nothing = DONE*/}
		else
			nyhet_RaderaNyhet_Test();
	}
	
	
	
	//----------------------------------------------------------------------------------------------------//
	//-----------------------Methods to speed up the process of writing new tests-------------------------//
	//----------------------------------------------------------------------------------------------------//
	
	//Method to assert that the newest news was created with the right visibility.
	public static void nyheterAssertVisible() {
		if (st_data.nyheterVisibleTo == "all")
			_utils.assertThisCss(nyheterVisbleToField, "Alla");
		if (st_data.nyheterVisibleTo == "member")
			_utils.assertThisCss(nyheterVisbleToField, "Medlem");	
		if (st_data.nyheterVisibleTo == "elected")
			_utils.assertThisCss(nyheterVisbleToField, "Förtroendevalda");
	}
	
	//Method to check which visibility that will be used and sets a variable to it.
	public static void nyhetCheckVisibility() {
		if (st_data.counter == 1)
			st_data.nyheterVisibleTo = "all";
		else if (st_data.counter == 2)
			st_data.nyheterVisibleTo = "member";
		else if (st_data.counter == 3)
			st_data.nyheterVisibleTo = "elected";
	}
	
	//Method to fill in the Nyheter field with data
	public static void nyhetSkriv() {
		_utils.sendKeysId(skapaNyhetTitle, "Test Nyhet Selenium no. " + counter + " visible to " + nyheterVisibleTo);	//Sets a title of the new, with counter
		_utils.sendKeysId(skapaNyhetIngress, "Test Ingress");
		_utils.fileUploadId(nyheterButtonPicBrowse, exampleImageJpeg);	//Upload image JPEG
		_utils.clickById(buttonBladdraVideo); 							//Upload video
		_utils.sleep(500);
		_utils.switchToIFrameCss(iFrameMediaBrowser);					//Switch to iFrame
		_utils.sendKeysId(nyheterVideoField, nyheterVideoUrl); 			//Video details
		_utils.clickById(nyheterVideoNext); 								//Next button
		_utils.switchOffIFrame();
		_utils.switchToIFrameCss(iFrameBrodText);						//Switch to iFrame
		_utils.sendKeysCssSelector(skapaNyhetBrodtext, "Test Brödtext");
		_utils.switchOffIFrame();										//Switch back from iFrame
		_utils.fileUploadId(nyheterButtonDocBrowse, exampleDocumentPdf);	//Upload file PDF
		
		
		//select visibility that the news should have either "All" "Member" or "Elected" controlled by st_data.counter in skrivNyheter_Test
		if(st_data.nyheterVisibleTo == "all") 
			_utils.clickByIdJS(radioNyhetVisibleAll);
		else if(st_data.nyheterVisibleTo == "member")
			_utils.clickByIdJS(radioNyhetVisibleMember);
		else if(st_data.nyheterVisibleTo == "elected")
			_utils.clickByIdJS(radioNyhetVisibleElected);
		
		//Click on Spara nyhet
		_utils.clickById(buttonNyhetSpara);
	}
	
	//Quick method to navigate to Skapa Nyheter.
	public static void navigateToNyheter() {
		_utils.clickByCss(hanteraAvdSek);
		_utils.clickByXpath(goToAvdelningOrSektion);
		currentURL = testBase.driver.getCurrentUrl();
		_utils.clickByXpath(goToNyheter);
	}

	
	//Quick method to login with a user.
	public static void login() {
		testBase.driver.get(testBase.baseUrl);
		_utils.checkPopUp();
		testBase.driver.get(testBase.baseUrl + "/user");			
		_utils.clickNotVisibleCssJS(loginSpan);					
		_utils.sendKeysId(loginField, testBase.siteUser);			
		_utils.sendKeysId(passwordField, testBase.sitePass);		
		_utils.clickById(buttonLogin);
		_utils.print("Login done...");
	}
}
