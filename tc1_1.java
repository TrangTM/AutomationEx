package pck1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

// import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;

public class tc1_1 {

	public WebDriver driver = null;
	public String baseUrl = "https://automationexercise.com/";

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void main() throws Exception {
		WebElement btnSiLo = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));

		// if (checkHomepage() == true) {
		checkHomepage(3);
		btnSiLo.click();
		signUp("trangtm89@gmail.com");
		enterAccInfo();
		checkAccCreated();
		checkLogged();
		//deleteAcc();
		//checkHomepage(19);
		// }
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
	// 5. Verify 'New User Signup!' is visible
	// 6. Enter name and email address
	// 7. Click 'Signup' button
	public void signUp(String email) {
		WebElement lblNewSignup = driver.findElement(By.xpath("//div[@class='signup-form']"));
		WebElement txtName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		WebElement txtEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		WebElement btnSignup = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));

		if (lblNewSignup.isDisplayed()) {
			System.out.println("5. Verify 'New User Signup!' is visible");
			txtName.sendKeys("Trang Trang");
			txtEmail.sendKeys(email);
			btnSignup.submit();
		}
	}

	// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
	// 9. Fill details: Title, Name, Email, Password, Date of birth
	// 10. Select checkbox 'Sign up for our newsletter!'
	// 11. Select checkbox 'Receive special offers from our partners!'
	// 12. Fill details: First name, Last name, Company, Address, Address2, Country,
	// State, City, Zipcode, Mobile Number
	// 13. Click 'Create Account button'
	public void enterAccInfo() {
		WebElement lblEnter = driver.findElement(By.xpath("//div[@class='login-form']"));
		WebElement rdbTitle = driver.findElement(By.xpath("//input[@id='id_gender2']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
		Select dplDay = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		Select dplMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		Select dplYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		WebElement cbbSignUp = driver.findElement(By.xpath("//input[@id='newsletter']"));
		WebElement cbbRecei = driver.findElement(By.xpath("//input[@id='optin']"));
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@id='first_name']"));
		WebElement txtLastName = driver.findElement(By.xpath("//input[@id='last_name']"));
		WebElement txtCompany = driver.findElement(By.xpath("//input[@id='company']"));
		WebElement txtAddress = driver.findElement(By.xpath("//input[@id='address1']"));
		WebElement txtAddress2 = driver.findElement(By.xpath("//input[@id='address2']"));
		Select dplCountry = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		WebElement txtState = driver.findElement(By.xpath("//input[@id='state']"));
		WebElement txtCity = driver.findElement(By.xpath("//input[@id='city']"));
		WebElement txtZipcode = driver.findElement(By.xpath("//input[@id='zipcode']"));
		WebElement txtMobileNumber = driver.findElement(By.xpath("//input[@id='mobile_number']"));
		WebElement btnCreateAcc = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));

		if (lblEnter.isDisplayed()) {
			System.out.println("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
			rdbTitle.click();
			txtPassword.sendKeys("123456");
			dplDay.selectByValue("11");
			dplMonth.selectByVisibleText("December");
			dplYear.selectByValue("1989");
			cbbSignUp.click();
			cbbRecei.click();
			txtFirstName.sendKeys("Mai Trang");
			txtLastName.sendKeys("Tran");
			txtCompany.sendKeys("Test");
			txtAddress.sendKeys("Hà Nội");
			txtAddress2.sendKeys("Ba Đình");
			dplCountry.selectByValue("Singapore");
			txtState.sendKeys("HN");
			txtCity.sendKeys("HHN");
			txtZipcode.sendKeys("10000");
			txtMobileNumber.sendKeys("0879500999");
			btnCreateAcc.submit();
		}

	}

	// 14. Verify that 'ACCOUNT CREATED!' is visible
	// 15. Click 'Continue' button
	public boolean checkAccCreated() {
		WebElement lblAccCre = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
		WebElement btnCont = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
		if (lblAccCre.isDisplayed()) {
			btnCont.click();
			System.out.println("14. Verify that 'ACCOUNT CREATED!' is visible");
			return true;
		}
		return false;
	}

	// 16. Verify that 'Logged in as username' is visible
	public boolean checkLogged() {
		WebElement lblLogged = driver.findElement(By.xpath("//li[10]//a[1]"));
		if (lblLogged.isDisplayed()) {
			System.out.println("16. Verify that 'Logged in as username' is visible");
			return true;
		}
		return false;
	}

	// 17. Click 'Delete Account' button
	// 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
	public void deleteAcc() {
		WebElement btnDelAcc = driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
		btnDelAcc.click();

		WebElement lblAccDel = driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
		WebElement btnCon = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
		if (lblAccDel.isDisplayed()) {
			System.out.println("18. Verify that 'ACCOUNT DELETED!' is visible");
		}
		btnCon.click();
	}

	@AfterTest
	public void afterTest() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
