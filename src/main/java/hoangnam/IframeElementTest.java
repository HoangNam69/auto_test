package hoangnam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeElementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");

		WebElement ifr = driver.findElement(By.id("iframeResult"));

		driver.switchTo().frame(ifr);

		String contextH1 = driver.findElement(By.tagName("h1")).getText();

		System.out.println("Context of H1 tag: " + contextH1);

		driver.switchTo().defaultContent();

		WebElement btnGetWebsite = driver.findElement(By.id("getwebsitebtn"));

		btnGetWebsite.click();

	}

}
