package com.TestCases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MobilePages.ChangeMyPin;
import com.MobilePages.CreateAccountPage;
import com.MobilePages.EmailMySummary;
import com.MobilePages.ForgotPassword;
import com.MobilePages.HomePage;
import com.MobilePages.LoginPage;
import com.MobilePages.MyAppointments;
import com.MobilePages.MyHospitalName;
import com.MobilePages.MyIBDTeam;
import com.MobilePages.MyMedicalHistory;
import com.MobilePages.MyMedication;
import com.MobilePages.MyProfile;
import com.Utils.AndroidSetUp;
import com.Utils.GetScreenShot;
import com.Utils.TestRecorder;

@Listeners ({GetScreenShot.class})

public class IDBTestCases extends AndroidSetUp{
	
//	@SuppressWarnings("rawtypes")
//	protected static AndroidDriver driver;
//    
//    String appiumServiceUrl;
//    
//    AppiumDriverLocalService appiumService;
//    
//    AppiumServiceBuilder builder;

//	ScreenRecorder sr = new ScreenRecorder();
	
	TestRecorder ts = new TestRecorder();
	
//	To run these test cases to Another Device Device Name, UDID and Platform Version Values should be changed 
	
	String DeviceName = "Google Nexus 5";
	
	String UDID = "192.168.57.101:5555";
	
	String PlatformVersion = "6.0";
	
//	String Url = "";


	@Parameters({"DeviceName", "UDID", "PlatformVersion", "Url"})
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		
//		System.out.println("Screen Recording Started");

		ts.StartRecord();
			
//		prepareAndStartAppium();

//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		

	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
			
//		System.out.println("Screen Recording Stopped");
		
		ts.StopRecord();
	
//		sr.StopRecord();

	}

	@Test(priority = 1)
	public void inValidLoginTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Invalid Login Test");
		new LoginPage(driver).accountLogin("fatma@mailinator.com", "4700");
	}

	@Test(priority = 2)
	public void validLoginTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Valid Login Test");
		new LoginPage(driver).accountLogin("fatman@mailinator.com", "1234");
	}
	
	@Test(priority = 3)
	public void loginAsSomeoneElseTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Login as Someone Else Test");
		new LoginPage(driver).loginAsSomeoneElse("fatman@mailinator.com", "1234");
		
	}
	
	@Test(priority = 4)
	public void loginAsLoggedInUserTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Logged In User Login Test");
		new LoginPage(driver).loginAsLogedInUser("fatman@mailinator.com", "1234");
		
	}
	
	@Test(priority = 5)
	public void forgorPasswordTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Forgot Password Test");
		new ForgotPassword(driver).forgotPassword("batman@mailinator.com");
		
	}
	
	@Test(priority = 6)
	public void changeMyPinToSamePinTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Change My PIN to Same PIN Test");
//		Need to change the PIN every time
		new ChangeMyPin(driver).chnageMyPin("uderman@mailinator.com", "9335", "9335");
        
	}
	
	@Test(priority = 7)
	public void changeMyPinToNewPinTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Change My PIN to New PIN Test");
//		Need to change the PIN every time
		new ChangeMyPin(driver).chnageMyPin("uberman@mailinator.com", "3345", "3346");
        
	}
	
	@Test(priority = 8)
	public void createAccountWithInvalidDetailsTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Create Account With Invalid Details Test");
		new CreateAccountPage(driver).createAccount("Uber Man", "uberman.com", "2345", "09886543210", "Black");
	}
	
	@Test(priority = 9)
	public void createAccountWithValidDetailsTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Create Account With Valid Details Test");
		
		// Need to change the mail id to create new Account
		
		new CreateAccountPage(driver).createAccount("Uderr Man", "uderrman@mailinator.com", "2345", "09886543210", "Black");
	}
	
	@Test(priority = 10)
	public void verifyHomePageTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Verify Home Page Test");
		new HomePage(driver).verifyHomePage("fatman@mailinator.com", "1234");
	}
	
	@Test(priority = 11)
	public void addNewAppointmentTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Add New Appointment Test");
//		prepareAndStartAppium();
		new MyAppointments(driver).addNewAppointment("fatman@mailinator.com", "1234", "12");
		
	}
	
	@Test(priority = 12)
	public void deleteAppointmentTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Delete an Appointment Test");
//		prepareAndStartAppium();
		new MyAppointments(driver).deleteAppointment("fatman@mailinator.com", "1234");
		
	}

	@Test(priority = 13)
	public void changeMyNameAndPhoneNoTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Change My Name and Phone No Test");
		new MyProfile(driver).changeMynameAndPhoneNo("fatman@mailinator.com", "1234", "Tin Tin", "09230497690");
	}

	@Test(priority = 14)
	public void changeHospitalNameTest() throws InterruptedException, MalformedURLException {
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Change Hospital Name Test");
		new MyHospitalName(driver).myHospital("fatman@mailinator.com", "1234", "Black");
	}
		
	@Test(priority = 15)
	public void addMyMedicationTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
        System.out.println("Executing : Add My Medication Test");
		new MyMedication(driver).addMedication("fatman@mailinator.com", "1234", "Paracetamol 600 ", "3", 2, "mg", "Week");
		
	}
	
	@Test(priority = 16)
	public void stopMyMedicationTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Stop My Medication Test");
		new MyMedication(driver).stopMedication("fatman@mailinator.com", "1234");
		
	}
	
	@Test(priority = 17)
	public void editMyMedicationTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Edit My Medication Test");
		new MyMedication(driver).editMedication("fatman@mailinator.com", "1234", "Test Medicine", "3");
		
	}
	
	@Test(priority = 18)
	public void restartMyMedicationTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing Restart My Medication Test");
		new MyMedication(driver).restartMedication("fatman@mailinator.com", "1234");
		
	}
	
	@Test(priority = 19)
	public void addIBDTeamMemberTest() throws MalformedURLException, InterruptedException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Add My IBD Team Member Test");
		new MyIBDTeam(driver).addIDBTeamMember("fatman@mailinator.com", "1234", "Vin Diesel", "Doctor");
		
	}
	
	@Test(priority = 20)
	public void deleteIBDTeamMemberTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Delete My IBD Team Member Test");
		new MyIBDTeam(driver).deleteTeamMember("fatman@mailinator.com", "1234");
		
	}
	
	@Test(priority = 21)
	public void editMyMedicalHistoryTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Edit My Medical History Test");
		new MyMedicalHistory(driver).editMyMedicalHistory("fatman@mailinator.com", "1234", "I Want to Edit this Condition");
		
	}
	
	@Test(priority = 22)
	public void deleteMyMedicalHistoryTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Delete My Medical History Test");
		new MyMedicalHistory(driver).deleteMyMedicalHistory("fatman@mailinator.com", "1234");
		
	}
	
	@Test(priority = 23)
	public void addMyMedicalHistoryTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Add My Medical History Test");
		new MyMedicalHistory(driver).addMyMedicalHistory("fatman@mailinator.com", "1234", "Cholecystectomy", "I Want to Add Cholecystectomy Condition");
		
	}
		
	@Test(priority = 24)
	public void emailMySummaryTest() throws MalformedURLException{
//		prepareAndStartAppium("Google Nexus 5", "192.168.57.101:5555", "6.0");
		prepareAndStartAppium(DeviceName, UDID, PlatformVersion);
		System.out.println("Executing : Email My Summary Test");
		new EmailMySummary(driver).emailMySummary("fatman@mailinator.com", "1234", "fatman@mailinator.com");
		
	}
	

}
	
