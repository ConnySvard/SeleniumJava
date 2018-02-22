
public class st_data {
	
	//Global variables
		static String nyheterVisibleTo = "";
		static int counter = 1;
		static String elementText;
		static int stillTrue = 1;
		static String currentURL;
		static Boolean isPresent = false;
		static String exampleImageJpeg = "/Users/connysvard/Documents/Images/Images.jpeg";											//Example JPEG
		static String exampleDocumentPdf = "/Users/connysvard/Documents/Images/example.pdf";											//Example PDF
		static String exampleDocumentOds = "/Users/connysvard/Documents/Images/example.ods";											//Example ODS
	
	//Global elements
		//Pop up
		static String popUpEjMedlem = "edit-not-member";																				//ID
		static String popUpMedlem = "edit-member";																					//ID
		static String popUpFortroendevald = "edit-elected-representative"; 															//ID
		//Login page
		static String loginSpan = "span[class='fieldset-legend']";																	//CSS 	SPAN CLASS
		static String loginField = "edit-name";																						//ID
		static String passwordField = "edit-pass";																					//ID
		static String buttonLogin = "edit-submit";																					//ID
	
	//Avdelning / Sektor - Mina sidor
		static String hanteraAvdSek  = "a[href='#manage_departments']";																//CSS 	A HREF
		static String goToAvdelningOrSektion  = "//*[contains(text(), 'inom')]";														//XPATH
		static String goToNyheter  = "//a[contains(@href,'news')]";																	//XPATH
		static String buttonSkapaNyheter = "//*[contains(text(), 'Skapa Nyhet')]";													//XPATH
		
	//Sida
		static String goToSida = "//a[contains(@href,'page')]";																		//XPATH
		static String buttonSkapaSida = "a[class='EditForm-createContent']";															//CSS A HREF
		static String sidaTitle = "edit-title"; 															//Title						//ID
		static String sidaMenuTitle = "edit-field-menu-link-text-und-0-value"; 							//menyTitle					//ID
		static String sidaRadioOnlyTitle = "edit-field-header-style-und-title"; 							//endastTitle				//ID
		static String sidaRadioTitleUnderPic  = "edit-field-header-style-und-image"; 						//titleUnderPic				//ID
		static String sidaRadioTitleOnPic = "edit-field-header-style-und-imagetitle";						//titleOnPic					//ID
		static String sidaRadioTitleUnderVideo = "edit-field-header-style-und-video";						//titleUnderVideo			//ID
		static String sidaIngress = "edit-field-lead-und-0-value";										//ingress					//ID
		static String sidaBrodtext = "iframe[title='Rich Text Editor, edit-field-body-und-0-value']";									//IFRAME
		static String sidaUploadFile = "edit-field-attachment-und-0-upload";								//bifoga dok					//ID
		static String sidaVisibleToAll = "edit-field-visibility-und-all";									//visibilityAlla				//ID
		static String sidaVisibleToMembers = "edit-field-visibility-und-member";							//visibilityMembers			//ID
		static String sidaVisibleToElected = "edit-field-visibility-und-elected";							//visibilityFortroendevalda	//ID
		static String sidaCheckboxPublished = "edit-status";												//publicerat					//ID
		static String sidaButtonSpara = "edit-submit";													//buttonSpara				//ID
		//Sidor table
		static String sidaInTableTitle = "td[class='views-field views-field-title']";						//Sidtitle in table			//CSS 	TD CLASS
		
	//Startsida
		static String startsidaIngress = "edit-field-lead-und-0-value";																//ID
		static String startsidaIframeBrodtext = "iframe[title='Rich Text Editor, edit-field-body-und-0-value]";						//CSS 	IFRAME TITLE
		static String goToStartsida  = "//a[contains(@href,'start')]";																//XPATH
		
	//Arbetsmaterial
		static String goToArbetsmaterial = "//a[contains(@href,'working_material')]";													//XPATH
	
	//Nyheter form
		static String skapaNyhetTitle = "edit-title";																				//ID
		static String skapaNyhetIngress = "edit-field-lead-und-0-value";																//ID
		static String skapaNyhetBrodtext = "body[class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']";			//CSS 	BODY CLASS
		static String labelIsPublished = "label[for='edit-status']";																	//CSS 	LABEL CLASS
		static String labelIsPublishedTitle = "span[class='LocalItem-NotPublished']";													//CSS 	SPAN CLASS
		//Radio buttons
		static String radioNyhetVisibleAll = "edit-field-visibility-und-all";															//ID
		static String radioNyhetVisibleMember = "edit-field-visibility-und-member";													//ID
		static String radioNyhetVisibleElected = "edit-field-visibility-und-elected";													//ID
		//Checkbox
		static String checkboxPublicerat =  "edit-status";																			//ID
		static String nyheterTitle = "td[class='views-field views-field-title']";														//CSS 	TD CLASS
		//Buttons
		static String buttonNyhetSpara = "edit-submit";																				//ID
		static String nyheterButtonPicBrowse = "edit-field-image-und-0-upload";														//ID
		static String nyheterButtonDocBrowse = "edit-field-attachment-und-0-upload";													//ID
		static String buttonUploadImage = "edit-field-image-und-0-upload-button--3";													//ID
		static String buttonUploadFile = "edit-field-image-und-0-upload-button--7";													//ID
		//Video
		static String buttonBladdraVideo = "edit-field-video-und-0-browse-button";													//ID
		static String nyheterVideoField = "edit-embed-code";																			//ID
		static String nyheterVideoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";												
		static String nyheterVideoNext = "edit-next";																				//ID
		//Redigera
		static String nyheterRedigera = "td[class='views-field views-field-edit-node']";												//CSS 	TD CLASS
		//Radera
		static String nyheterRadera = "edit-delete";																					//ID
		static String nyheterRaderaConfirm = "edit-submit";																			//ID
		//Message status
		static String nyheterMessage = "div[class='Message Message--status']";														//CSS 	DIV CLASS
		//visible to table
		static String nyheterVisbleToField = "td[class='views-field views-field-field-visibility']";									//CSS 	TD CLASS
		//iFrames
		static String iFrameBrodText = "iframe[title='Rich Text Editor, edit-field-body-und-0-value']";								//IFRAME
		static String iFrameMediaBrowser = "iframe[class='media-modal-frame ui-dialog-content ui-widget-content']";					//IFRAME
		
		//Bli medlem Page 1
		static String buttonBliMedlem = "a[class='Register-button Button Register-button--regular']";									//CSS 	A CLASS
		static String radioTypAvMedlemskap = "edit-type-employed"; 																	//ID
		static String radioTypAvEmail = "edit-email-type-work";																		//ID
		static String salery = "edit-salary";																						//ID
		static String buttonCalculateSalery = "edit-calculate";																		//ID
		static String personalNumber = "edit-personal-number";																		//ID
		static String firstName = "edit-name-first";																					//ID
		static String lastName = "edit-name-last";																					//ID
		static String emailAddress = "edit-email";																					//ID
		static String mobilePhone = "edit-mobilephone";																				//ID
		static String dropDownCountry = "select2-edit-country-container"; 															//ID
		static String address = "edit-address-line1";																				//ID
		static String coAddress = "edit-address-line2";																				//ID
		static String postCode = "edit-postal-code";																					//ID
		static String checkboxFolkbokforing = "edit-address-type";																	//ID
		static String checkboxCondition = "edit-terms-and-conditions"; 																//ID
		static String buttonNext = "edit-next";																						//ID

}
