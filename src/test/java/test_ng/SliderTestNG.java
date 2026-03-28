package test_ng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test_ng.base.BaseTest;

public class SliderTestNG extends BaseTest {

	@Test
	public void testSliderHandle() {

		driver.get("https://www.google.com");

		WebElement searchField = driver.findElement(By.name("q"));
		searchField.sendKeys("JQuery UI Slider");
		searchField.submit();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Slider')]"))).click();

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		WebElement sliderHandle = driver.findElement(By.xpath("//div[@id='slider']/span"));
		actions.dragAndDropBy(sliderHandle, 200, 0).perform();

//		Verification
		String styleAttribute = sliderHandle.getAttribute("style");
		System.out.println("Style attribute: " + styleAttribute);

		Assert.assertTrue(styleAttribute.contains("left"), "Slider should have moved!");
	}

}
