package aummation_test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxElementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

		driver.get("https://the-internet.herokuapp.com/checkboxes");
		/**
		 * Nguyên tắc phải kiểm tra checkbox đã được checked hay chưa mới tiếp tục xử lý theo nghiệp vụ
		 */
//		WebElement cb1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
//
//		if (!cb1.isSelected()) {
//			cb1.click();
//		}

//		List<WebElement> cbs = driver.findElements(By.tagName("input"));
//		
//		for (WebElement cb : cbs) {
//			if (!cb.isSelected()) {
//				cb.click();
//			} else {
//				cb.click();
//			}
//		}

		List<WebElement> cbs = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement cb : cbs) {
			if (!cb.isSelected()) {
				cb.click();
			} else {
				cb.click();
			}
		}

	}

}
