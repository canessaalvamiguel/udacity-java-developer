package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;

	private static final String FIRST_NAME = "Miguel";
	private static final String LAST_NAME  = "Canessa";
	private static final String USERNAME   = "mcanessa";
	private static final String PASSWORD   = "testPass!";

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void testAuthorisedEndpoint() {
		driver.get("http://localhost:" + this.port + "/signup");
		assertEquals("Sign Up", driver.getTitle());

		driver.get("http://localhost:" + this.port + "/login");
		assertEquals("Login", driver.getTitle());

		driver.get("http://localhost:" + this.port + "/home");
		assertFalse("Home" == driver.getTitle());
	}

	@Test
	public void testSignupLoginFlow()  throws InterruptedException{
		performSignup();
		Thread.sleep(2000);

		assertEquals("Login", driver.getTitle());

		performLogin(false);
		Thread.sleep(2000);

		assertEquals("Home", driver.getTitle());

		Thread.sleep(2000);
		HomePage homePage = new HomePage(driver);
		homePage.performLogout();

		assertEquals("Login", driver.getTitle());

		Thread.sleep(2000);
		driver.get("http://localhost:" + this.port + "/home");

		assertFalse(driver.getTitle() == "Home");

	}

	public void performSignup(){
		driver.get("http://localhost:" + this.port + "/signup");
		SignupPage signupPage = new SignupPage(driver);
		signupPage.performSignUp(FIRST_NAME, LAST_NAME, USERNAME, PASSWORD);
	}

	public void performLogin(boolean forceUrl){

		if(forceUrl)
			driver.get("http://localhost:" + this.port + "/login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(USERNAME, PASSWORD);
	}

}
