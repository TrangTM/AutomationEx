package pck1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class tc2 {
	// tc1_1 tc1 = new tc1_1();
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

	@Test
	public void main() {
		// tc1.checkHomepage(3);
		WebElement btnSiLo = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));

		checkHomepage(3);
		btnSiLo.click();
		login("trangtm89@gmail.com", "123456");
		checkLogged();
		deleteAcc();

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
	// 6. Enter correct email address and password
	// 7. Click 'login' button
	public void login(String email, String pass) {
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

	// 8. Verify that 'Logged in as username' is visible
	public boolean checkLogged() {
		WebElement lblLogged = driver.findElement(By.xpath("//li[10]//a[1]"));
		if (lblLogged.isDisplayed()) {
			System.out.println("8. Verify that 'Logged in as username' is visible");
			return true;
		}
		return false;
	}
	
	//9. Click 'Delete Account' button
	//10. Verify that 'ACCOUNT DELETED!' is visible
	public void deleteAcc() {
		WebElement btnDelAcc = driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
		btnDelAcc.click();

		WebElement lblAccDel = driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
		if (lblAccDel.isDisplayed()) {
			System.out.println("18. Verify that 'ACCOUNT DELETED!' is visible");
		}
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
