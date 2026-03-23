package aummation_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicSeleniumSummerizeExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. Khởi tạo trình duyệt
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions acts = new Actions(driver);

//		2. Truy cập google
		driver.get("https://www.google.com");

//		3. Tìm ô nhập liệu tìm kiếm và nhấn tìm kiếm
		WebElement ggSearchField = driver.findElement(By.name("q"));

		ggSearchField.sendKeys("JQuery UI Slider");
		ggSearchField.submit();

//		4. Đợi kết quả hiện thị & click
		exWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Slider')]"))).click();

//		5. Nhảy vào frame chứa slider
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

//		6. Lấy thanh slider
		WebElement sliderHandle = driver.findElement(By.xpath("//div[@id='slider']/span"));

//		7. Thực hiện kéo thanh slider qua bên phải 200px
		acts.dragAndDropBy(sliderHandle, 200, 0).perform();

//		8. Verification kết quả đã kéo
		System.out.println("Vị trí mới: " + sliderHandle.getAttribute("style"));

//		9. Thoát khỏi frame & back to home
		driver.switchTo().defaultContent();

//		WebElement logo = driver.findElement(By.xpath("//h2[@class='logo']/a"));
		WebElement logo = driver.findElement(By.cssSelector(".logo a"));

		logo.click();

		driver.quit();

	}

}
