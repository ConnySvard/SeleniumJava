//Running on Selenium 2.53 | Firefox 43

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


//Change to something else "Base-like", which will get testcases
public class testBase {
	
	//Arguments from commandline
	public static String none = "NONE";
	public static String url = none;						// -u		URL
	public static String authUser = none;				// -a		Authentication user
	public static String authPass = none;				// -p		Authentication password
	public static String siteUser = none;				// -us		Site login user
	public static String sitePass = none;				// -pw		Site login password
	public static String testCase = none;				// -t		Testcase
	public static String testlinkAPIkey = none;			// -ts		API key to testlink
	public static String outputFilename = none;			// -o		Output filename
	public static String outputFoldername = none;		// -O		Output filename
	public static String inputFilename = none;			// -i		Input filename
	public static String sourceFolder = none;			// -s 		Source folder
	public static String json = none;					// -j		Json filename
	public static String browser = none;					// -b		Browser
	public static String silent = none;					// -S		Silent mode
	public static String variable = none;				// -v		Variable, if needed, can be anything
	
	//Global variables
	public static String baseUrl;		// Base URL
	public static int passOrFail = 0; 	// 0 = Fail
	public static int passedAssert = 0; 	// Total asserts that passed
	public static int failedAssert = 0; 	// Total asserts that failed
	public static int errors = 0; 		// Total asserts that failed
	public static int counter = 0;		// Counter variable
	public static String currentURL = "";
	public static int silentMessage = 1;
	public static String startTime;
	
	//Selenium
	static File pathToBinary;	
	static FirefoxBinary ffBinary;						
	static FirefoxProfile firefoxProfile;   
	static WebDriver driver;
	
	//Setup Firefox
	public static void setupFirefox() {
		pathToBinary = new File("/Users/connysvard/Documents/Selenium/Firefox/bin/Firefox.app/Contents/MacOS/firefox");
		ffBinary  = new FirefoxBinary(pathToBinary);	
		firefoxProfile  = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary,firefoxProfile);
		System.setProperty("webdriver.gecko.driver", "/Users/connysvard/Documents/Selenium/geckodriver");	
	}
	
	//Setup Chrome
	public static void setupChrome() {
		System.setProperty("webdriver.chrome.driver", "/Users/connysvard/Documents/Libs/chromedriver");
		driver = new ChromeDriver();
	}
	
	public static void main (String[]args) {
		
		startTimer();														// Start new thread with a timer to keep track of how long the test will take
		variableSetter(args);												// Set variables from arguments
		getBrowser();
		getSourceFolder();
		
		//Print info in console
		_utils.print("-u "+url+ " -au "+authUser+ " -ap "+authPass+ " -us "+siteUser+ " -pw "+sitePass+ " -t "+testCase
					+ " -b " + browser + " -tl " + testlinkAPIkey + " -i " + inputFilename + " -o " + outputFilename + " -j " + json + " -s " + sourceFolder
					+ " -sh " + silent + "\n");
		_utils.print("Running test: \t" + testCase);
		_utils.print("Navigating to:\t " + url + "\n");
		
		if(!url.equals("NONE")) {
			splitUrl();															// Split and get baseUrl
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl); 
		}
		getTestCase();														// Get which test is going to run
		result();															// After tests is done, run result()
	}
	
	//Method to get which test case is going to run
		public static void getTestCase() {
			
			if (testCase.equals("screenshot_test")) {						//NotDone	ST		
				st.screenshot_test();
			}
			else if (testCase.equals("skrivNyhet_Avdelning")) {				//NotDone	ST		
				//Run
			}
			else if (testCase.equals("nyhet_SkrivNyhet_Test")) {				//Done		ST		nyhet_SkrivNyhet_Test
				st.nyhet_SkrivNyhet_Test();
			}
			else if (testCase.equals("nyhet_RaderaNyhet_Test")) {				//Done		ST		nyhet_RaderaNyhet_Test
				st.nyhet_RaderaNyhet_Test();
			}
			else if (testCase.equals("nyhet_Avpublicera_Test")) {				//Done		ST		nyhet_Avpublicera_Test
				st.nyhet_Avpublicera_Test();
			}
			else if (testCase.equals("nyhet_Publicera_Test")) {				//Done		ST		nyhet_Publicera_Test
				st.nyhet_Publicera_Test();
			}
			else if (testCase.equals("startsida_Redigera_Test")) {			//Done		ST		startsida_Redigera_Test
				st.startsida_Redigera_Test();
			}
			else if (testCase.equals("laggTill_Sida_Test")) {					//NOT Done	ST		laggTill_Sida_Test
				st.laggTill_Sida_Test();
			}
			else if (testCase.equals("radera_Sida_Test")) {					//NOT Done	ST		radera_Sida_Test
				st.radera_Sida_Test();
			}
			else	 {																										
				System.out.println("\nError: " + testCase + " is not a valid testcase OR its not added to testBase.java");		//If selected test does not exist -come here
			}	
		}
	
	
	//Method starts the timer
	public static void startTimer() {
		new Thread(() -> {
			timer.timer();
		}).start();
	}
	
	//Sets variables from commandline
	public static void variableSetter(String[]args) {
		int x = 0;															// Index of String[x]args
		// For every argument from the commandline check if these keys are found, then jump one index to get the value.
		// Will run 'args.length/2-1' since x++ 2 times each loop.
		for(int i = 0; i <= args.length/2-1; ++i) {
			if (args[x].equals("-u")) { 										//site url
				x++;
				url = args[x];
			}
			else if (args[x].equals("-a")) {	 								//site authentication username
				x++;
				authUser = args[x];
			}
			else if (args[x].equals("-p")) { 								//site authentication password
				x++;
				authPass = args[x];
			}
			else if (args[x].equals("-us")) { 								//login username
				x++;
				siteUser = args[x];
			}
			else if (args[x].equals("-pw")) { 								//login password
				x++;
				sitePass = args[x];
			}
			else if (args[x].equals("-t")) { 								//testcase
				x++;
				testCase = args[x];
			}
			else if (args[x].equals("-tl")) { 								//testlink API key
				x++;
				testlinkAPIkey = args[x];
			}
			else if (args[x].equals("-o")) { 								//output file name
				x++;
				outputFilename = args[x];
			}
			else if (args[x].equals("-O")) { 								//output folder name
				x++;
				outputFoldername = args[x];
			}
			else if (args[x].equals("-b")) { 								//browser
				x++;
				browser = args[x];
			}
			else if (args[x].equals("-j")) { 								//json 
				x++;
				json = args[x];
			}
			else if (args[x].equals("-i")) { 								//input file 
				x++;
				inputFilename = args[x];
			}
			else if (args[x].equals("-s")) { 								//sourceFolder
				x++;
				sourceFolder = args[x];
			}
			else if (args[x].equals("-sh")) { 								//silent mode
				x++;
				silent = args[x];
			}
			else if (args[x].equals("-v")) { 								//variable
				x++;
				variable = args[x];
			}
			x++;
		}
	}
	
	//splits URL to be able to use authentication. Handles http:// or https://
	public static void splitUrl() {
		String http = "";
		
		if (url.contains("http://")) {				// If URL is http://, use that in (http - variable)
			url = url.replace("http://", "");
			http = "http://";
		}
		else if (url.contains("https://")) {			// If URL is https://, use that in (http - variable)
			url = url.replace("https://", "");
			http = "https://";
		}
		
		// Set the baseUrl with the auth user and pass
		baseUrl = http + authUser + ":" + authPass + "@" + url;
	}
	
	public static void testlinkResults() {
		// Function to be able to  automatically post results on testlink
		/*
		 * TODO
		 * CODE
		 */
	}
	
	public static void jsonData() {
		// Function to able to read json data.
		/*
		 * TODO
		 * CODE 
		 */
	}
	
	
	//Firefox is set as standard
	public static void getBrowser() {
		if (browser.equals("chrome")) {
			setupChrome();
		}
		else if (browser.equals("firefox"))  {
			setupFirefox();
		}
		else {
			browser = "firefox";
			setupFirefox();
		}
	}
	
	public static void getSourceFolder() {
		if (sourceFolder.equals(none) ) {
			sourceFolder = "/Users/connysvard/Documents/Automation/";
		}
		else {/*Do nothing*/}
		_utils.print(sourceFolder);
	}
	
	//Result method
	public static void result() {
		driver.quit();
		
		silent = "NONE";
		// Results, which testCase, execution time, how many failed asserts, passed asserts and total asserts and total errors
		_utils.print("\nTest: " + testCase + " - Finnished.");
		_utils.print("Test execution time: " + timer.minutes + " minutes, " + timer.seconds + " seconds\n");
		_utils.print("Failed asserts: " + failedAssert + " | Passed asserts: " + passedAssert + " | Total asserts: " + (failedAssert + passedAssert) + "\nErrors: " + errors);
	}
	
	
}
