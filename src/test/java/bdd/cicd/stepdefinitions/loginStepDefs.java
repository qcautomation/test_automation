package bdd.cicd.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefs {

	String content ;
	
	@Given("I am placed on the Online Banking platform")
	public void i_am_placed_on_the_Online_Banking_platform() throws MalformedURLException {
		
		String USERNAME = "qcautomation";
		String ACCESS_KEY = "7f9e43de-a27a-43fe-81c3-a96673426dc0";
		String URL = "https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";
		
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability("platform","Windows");
//		caps.setCapability("version","latest");
//		caps.setCapability("name","CalCoast - Remote Driver test execution");
//		caps.setCapability("extendedDebugging","true");
		
		MutableCapabilities sauceOptions = new MutableCapabilities();

		SafariOptions browserOptions = new SafariOptions();
		browserOptions.setCapability("platformName", "macOS 10.15");
		browserOptions.setCapability("browserVersion", "13.1");
		browserOptions.setCapability("name", "CalCoast - Remote Driver test execution");
		browserOptions.setCapability("extendedDebugging", "true");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		WebDriver driver = new RemoteWebDriver(new URL(URL),browserOptions);
		
//		WebDriver driver = new RemoteWebDriver(new URL(URL),caps);
		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/windows/chromedriver.exe");
//    	WebDriver driver = new ChromeDriver();
        String baseUrl = "https://calcoastcu-uat.konycloud.com/apps/KonyOLB/#_frmLogin";

        
        driver.get(baseUrl);
        content = driver.findElement(By.id("frmLogin_topHeader_lblWelcome")).getText();
        driver.quit();

	}

	@When("I check greeting message")
	public void i_check_greeting_message() {
		System.out.println("Captured greeting content: " + content);
	}

	@Then("I validate message content")
	public void i_validate_message_content() {
		assertThat(content).isNotNull();
	}

	
}
