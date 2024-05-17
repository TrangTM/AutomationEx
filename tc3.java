package pck1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class tc3 {
	public WebDriver driver = null;
	public String baseUrl = "https://automationexercise.com/";

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		// 1. Launch browser
		// 2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to(baseUrl);
	}

	//@Test(priority = 1)
	public void emptyString() {
		checkHomepage(3);
		login("", "");
		
	}
	
	//@Test(priority = 2)
	public void invalidEmailFomat() {
		checkHomepage(3);
		login("trangtm8989gmail.com", "123456");
	}
	
	@Test(priority = 3)
	public void invalidEmail() {
		checkHomepage(3);
		login("trangtm8989@gmail.com", "123456");
		checkErrorVisiable();
		checkErrorContent("Your email or password is incorrect!");
	}
	
	@Test(priority = 4)
	public void invalidPass() {
		checkHomepage(3);
		login("trangtm89@gmail.com", "123");
		checkErrorVisiable();
		checkErrorContent("Your email or password is incorrect!!!");
	}

	// 3. Verify that home page is visible successfully
	public boolean checkHomepage(int step) {
		WebElement imgLogo = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));

		if (imgLogo.isDisplayed()) {
			System.out.println(step + ". Verify that home page is visible successfully");
			return true;
		}
		return false;
	}
	
	// 4. Click on 'Signup / Login' button
	// 5. Verify 'Login to your account' is visible
	// 6. Enter incorrect email address and password
	// 7. Click 'login' button
	public void login(String email, String pass) {
		WebElement btnSiLo = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
		btnSiLo.click();
		
		WebElement lblLogin = driver.findElement(By.xpath("//div[@class='login-form']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement btnLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

		if (lblLogin.isDisplayed()) {
			System.out.println("5. Verify 'Login to your account' is visible");
			txtEmail.sendKeys(email);
			txtPassword.sendKeys(pass);
			btnLogin.submit();
		}
	}
	
	// 8. Verify error 'Your email or password is incorrect!' is visible
	public boolean checkErrorVisiable() {
		WebElement lblIncorect = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
		if(lblIncorect.isDisplayed()) {
			System.out.println("8. Verify error 'Your email or password is incorrect!' is visible");
			return true;
		}
		return false;
	}
	
	public void checkErrorContent(String expContent) {
		WebElement lblIncorect = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
		Assert.assertEquals(lblIncorect.getText(), expContent);
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
