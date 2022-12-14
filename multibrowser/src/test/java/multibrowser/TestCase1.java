package multibrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase1 {
	// open browser and Setup browser
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/sanketlaptop/Desktop/chromedriver");

	}

//Test Case 1 incorrect phone number
	@Test
	public void incorrectPhone() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("860023487");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		WebElement E = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4"));
		String act = E.getText();
		System.out.println("Test 1 :" + act);
		driver.quit();
	};

	// Test Case 2 incorrect password
	@Test
	public void incorrectPassword() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8600234923");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("qwsdvf");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		WebElement E1 = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
		String act1 = E1.getText();
		System.out.println("Test 2 :" + act1);
		driver.quit();
	};

//Test Case 3 successful Login
	@Test
	public void successfulLogin() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a:nth-child(1) > span:nth-child(1)")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("8600234923");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("QAZxsw23@");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		WebElement E2 = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		String act2 = E2.getText();
		System.out.println("Test 3 :" + act2);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span/span"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]")).click();
		WebElement E3 = driver.findElement(
				By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/div[1]/label"));
		String act3 = E3.getText();
		System.out.println("Test 4 :" + act3);
		driver.quit();

	};
}
