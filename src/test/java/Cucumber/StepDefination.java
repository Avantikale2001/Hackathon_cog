//package Cucumber;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.checkerframework.common.value.qual.StaticallyExecutable;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.Assert;
//
//import PageObject.java.HomePage;
//import PageObject.java.LanguageAndLevels;
//import PageObject.java.Search_Web_Dev;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class StepDefination {
//	static WebDriver driver;
//	static Logger logger ;
//	static Properties p ; 
//	Search_Web_Dev S;
//	LanguageAndLevels L;
//	HomePage home_Page;
//
//	@Given("launched the browser and open url")
//	public void launched_the_browser_and_open_url() throws IOException {
//		driver = new ChromeDriver();
//		//Loading property file
//			FileReader file=new FileReader(".//src//test//resources//config.properties");
//			p=new Properties();
//			p.load(file);
//			
//		logger= LogManager.getLogger(this.getClass());
//		logger.info("****************** Driver Launch **********************");
//		driver.get(p.getProperty("AppUrl"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		
//	}
//
//	@When("search Course")
//	public void search_course() throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//		S = new Search_Web_Dev(driver);
//		 Thread.sleep(4000);
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 Assert.assertEquals(driver.getTitle(), "Coursera | Degrees, Certificates, & Free Online Courses" );
//		 logger.info(" Search ' WEB DEVELOPMENT ' Courses ");
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 S.searchCourse(p.getProperty("courseName"));
//	}
//
//	@When("select language")
//	public void select_language() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		S.Select_Lang();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 logger.info(" Language seleted ");
//	}
//	@When("select level")
//	public void select_level() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		logger.info(" Level Selected ");
//		 S.Select_Level();
//	}
//
//	@Then("Getting data of courses")
//	public void getting_data_of_courses() throws InterruptedException {
//		logger.info("Printing Course Data");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 S.Course_names();
//	}
//
//	@Given("Gettig the list of languages")
//	public void gettig_the_list_of_languages() throws InterruptedException, IOException {
//		L = new LanguageAndLevels(driver);
//		Thread.sleep(3000);
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		L.btn_ShowMore();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		logger.info("Language count");
//		 L.languageCount();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 logger.info("Language list got printed ");
//		 L.lanuageDisplay();
//	}
//
//	@When("Click on apply button")
//	public void click_on_apply_button() throws InterruptedException {
//		 Thread.sleep(4000);
//		 logger.info("Click On Apply Button ");
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 L.ClickApply();
//	}
//
//	@Then("getting list of levels")
//	public void getting_list_of_levels() throws InterruptedException, IOException {
//		logger.info("Level list got printed ");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 L.displayLevels();
//		
//	}
//
//	@Given("get back to home page")
//	public void get_back_to_home_page() {
//		home_Page = new HomePage(driver);
//		 logger.info("Clicked On 'COURSERA' ");
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 home_Page.HoverHomePage();
//	}
//
//	@When("Click on For Enterprises")
//	public void click_on_for_enterprises() throws InterruptedException {
//		 System.out.println("successfully clicked on 'COURSEERA'");
//		 logger.info(" Clicked  on 'FOR ENTERPRISE' ");
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 home_Page.forEnterprise();
//		 System.out.println("successfully clicked  on 'FOR ENTERPRISE'");
//	}
//
//	@When("Click on Soltions")
//	public void click_on_soltions() throws InterruptedException {
//		Thread.sleep(1000);
//		 logger.info("Clicked On Solutions ");
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.solutionClick();
//		System.out.println("successfully clicked on 'SOLUTION'");
//	}
//
//	@When("Click on For Campus")
//	public void click_on_for_campus() throws InterruptedException {
//		Thread.sleep(2000);
//		logger.info("Clicked on 'COURSES FOR CAMPUS' ");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.CoursesForCampus();
//
//		System.out.println("successfully clicked on 'COURSES FOR CAMPUS' ");
//	}
//
//	@When("Fill the form")
//	public void fill_the_form() {
//		Assert.assertEquals(driver.getTitle(), "Online Learning Platform for Universities | Coursera");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.FillForm1(p.getProperty("FirstName"), p.getProperty("LastName"),p.getProperty("EmailId"), p.getProperty("ContactNo"), p.getProperty("InstituteName"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.InstituteType();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.JobRole();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.Department();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.WhichRoleDescribeYou();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		home_Page.country();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		logger.info("form got filled  ");
//	}
//
//	@When("Submit the form")
//	public void submit_the_form() {
//		logger.info("Error Message Occur ");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 home_Page.button();
//	}
//
//	@Then("Capture the Error Message")
//	public void capture_the_error_message() throws IOException {
//		
//		 System.out.println("Error Message");
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		 Assert.assertEquals(home_Page.ErrorMessage(), home_Page.exp_error);
//	}
//    
//	@Then("close the browser")
//	public void close_the_browser() {
//		driver.quit();
//	}
//}









package Cucumber;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import PageObject.java.HomePage;
import PageObject.java.LanguageAndLevels;
import PageObject.java.Search_Web_Dev;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
	static WebDriver driver;
	static Logger logger ;
	static Properties p ; 
	Search_Web_Dev S;
	LanguageAndLevels L;
	HomePage home_Page;

	@Given("the browser is launched and the URL is opened")
	public void the_browser_is_launched_and_the_URL_is_opened() throws IOException {
		driver = new ChromeDriver();
		//Loading property file
			FileReader file=new FileReader(".//src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
		logger= LogManager.getLogger(this.getClass());
		logger.info("****************** Driver Launch **********************");
		driver.get(p.getProperty("AppUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}

	@When("searching for a course")
	public void searching_for_a_course() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		S = new Search_Web_Dev(driver);
		 Thread.sleep(4000);
		 Assert.assertEquals(driver.getTitle(), "Coursera | Degrees, Certificates, & Free Online Courses" );
		 logger.info(" Search ' WEB DEVELOPMENT ' Courses ");
		 S.searchCourse(p.getProperty("courseName"));
	}

	@When("selecting the language")
	public void selecting_the_language() throws InterruptedException {
		S.Select_Lang();
		 
		 logger.info(" Language selected ");
	}
	@When("selecting the level")
	public void selecting_the_level() {
		logger.info(" Level Selected ");
		 S.Select_Level();
	}

	@Then("retrieve data for the selected courses")
	public void retrieve_data_for_the_selected_courses() throws InterruptedException {
		logger.info("Printing Course Data");
		 S.Course_names();
	}

	@Given("obtaining the list of languages")
	public void obtaining_the_list_of_languages() throws InterruptedException, IOException {
		L = new LanguageAndLevels(driver);
		Thread.sleep(8000);
		
		
		L.btn_ShowMore();
		
		logger.info("Language count");
		 L.languageCount();
		
		 logger.info("Language list got printed ");
		 L.lanuageDisplay();
	}

	@When("Clicking on the apply button")
	public void Clicking_on_the_apply_button() throws InterruptedException {
		 Thread.sleep(4000);
		 logger.info("Click On Apply Button ");
		 L.ClickApply();
	}

	@Then("retrieve the list of levels")
	public void retrieve_the_list_of_levels() throws InterruptedException, IOException {
		logger.info("Level list got printed ");
		
		 L.displayLevels();
		
	}

	@Given("navigate back to the home page")
	public void navigate_back_to_home_page() {
		home_Page = new HomePage(driver);
		 logger.info("Clicked On 'COURSERA' ");
		 home_Page.HoverHomePage();
	}

	@When("Clicking on For Enterprises")
	public void Clicking_on_for_enterprises() throws InterruptedException {
		 System.out.println("successfully clicked on 'COURSEERA'");
		 logger.info(" Clicked  on 'FOR ENTERPRISE' ");
		 home_Page.forEnterprise();
		 System.out.println("successfully clicked  on 'FOR ENTERPRISE'");
	}

	@When("Clicking on Solutions")
	public void Clicking_on_solutions() throws InterruptedException {
		Thread.sleep(4000);
		 logger.info("Clicked On Solutions ");
		home_Page.solutionClick();
		System.out.println("successfully clicked on 'SOLUTION'");
	}

	@When("Clicking on For Campus")
	public void Clicking_on_for_campus() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("Clicked on 'COURSES FOR CAMPUS' ");
		home_Page.CoursesForCampus();

		System.out.println("successfully clicked on 'COURSES FOR CAMPUS' ");
	}

	@When("Filling out the form with an invalid email")
	public void Filling_out_the_form_with_an_invalid_email() {
		Assert.assertEquals(driver.getTitle(), "Online Learning Platform for Universities | Coursera");
		home_Page.FillForm1(p.getProperty("FirstName"), p.getProperty("LastName"),p.getProperty("EmailId"), p.getProperty("ContactNo"), p.getProperty("InstituteName"));

		home_Page.InstituteType();
		home_Page.JobRole();
		home_Page.Department();
		home_Page.WhichRoleDescribeYou();
		home_Page.country();
		logger.info("form got filled  ");
	}

	@When("Submitting the form")
	public void Submitting_the_form() throws InterruptedException {
		logger.info("Error Message Occur ");
		 home_Page.button();
	}

	@Then("Capture the Error Message")
	public void Capture_the_Error_Message() throws IOException {
		
		 System.out.println("Error Message");
		 Assert.assertEquals(home_Page.ErrorMessage(), home_Page.exp_error);
	}
    
	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}
}
