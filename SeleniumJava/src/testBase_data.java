
public class testBase_data {
	
	//Test data
	
	//BLI MEDLEM DATA String[]
	static String[] data_personalNumer_valid = {	"121212121212", 
												"1212121212"};			//2
	
	static String[] data_personalNumer_notValid = {"", 
												"121212121", 
												"test", 
												"!))#!==&#)!&"};			//4
	
	static String[] data_firstName_valid = {		"Berit", 
												"Lars-Åke", 
												"Ola Jocke"};			//3
	
	static String[] data_firstName_notValid = {	"",
												"@"};					//2
	
	static String[] data_lastName_valid = {		"Sten",
												"Svens-son", 
												"von Svänsson"};			//3
	
	static String[] data_lastName_notValid = {	"",
												"@"};					//2
	
	static String[] data_email_valid = {			"test.t@test.test", 
												"test-t@test.test", 
												"test_t@test.test",
												"test@test.test.test"};	//4
	
	static String[] data_email_notValid = {		"", 
												"test", 
												"test@test", 
												"@test.test", 
												"test@.test", 
												"!@!.!"};				//6
	
	static String[] data_mobile_valid = {		"0701234567", 
												"+46701234567"};			//2
	
	static String[] data_mobile_notValid = {		"", 
												"07012345", 
												"test", 
												"€%&%€%&%€&"};			//4
	
	static String[] data_address_valid = {		"Testvägen 3a"};			//1
	
	static String[] data_address_notValid = {	""};						//1
	
	static String[] data_coAddress_valid = {		"Testvägen 3a"};			//1
	
	static String[] data_coAddress_notValid = {	""};						//1
	
	static String[] data_postcode_valid = {		"11111"};
	static String[] data_postcode_notValid = {	"", 
												"111", 
												"test", 
												"!#€%&", 
												"111111"};				//5
	
	

}
