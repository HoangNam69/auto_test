package aummation_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {
	public static void main(String[] args) {
		// 1. Khởi tạo trình duyệt
		WebDriver driver = new ChromeDriver();

		// 2. Mở full màn hình
		driver.manage().window().fullscreen();

		// 3. Truy cập vào trang google
		driver.get("https://google.com");

		// 4. Điều hướng sang trang selenium
		driver.navigate().to("https://www.selenium.dev");

		// 5. Back lại trang google
		driver.navigate().back();

		// 6. In ra url hiện tại
		System.out.println("URL: " + driver.getCurrentUrl());
		
		// 7. Dừng trình duyệt
		driver.quit();

	}
}
