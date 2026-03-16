package aummation_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownElementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

		driver.get("https://the-internet.herokuapp.com/dropdown");

//		1. Lấy element dropdown từ trang web
		WebElement dropdown = driver.findElement(By.id("dropdown"));

//		2. Khởi tạo select selenium cho element dropdown vừa lấy được
		Select dropdownList = new Select(dropdown);

//		3. Chọn lựa chọn từ dropdown: có 3 cách chọn
		/**
		 * Cách 1: chọn theo nội dung option hiển thị
		 */
		dropdownList.selectByVisibleText("Option 1");

		/**
		 * Cách 2: chọn theo thứ tự của option
		 */
//		dropdownList.selectByIndex(1);

		/**
		 * Cách 3: chọn theo value của option
		 */
//		dropdownList.selectByValue("2");

//		driver.quit();
	}

}
