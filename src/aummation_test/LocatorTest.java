package aummation_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://google.com");

		// 1. Tìm ô tìm kiếm bằng Name
		WebElement searchBox = driver.findElement(By.name("q"));
		
		// 2. Gõ nội dung cần tìm và nhấn phím Enter
		searchBox.sendKeys("Scented Candles LULL");
		searchBox.submit();
		
		// 3. Đợi 2s xem kết quả (Tạm thời dùng sleep -> sau này dùng wait)
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		
		// 4. Kiểm tra xem tiêu đề trang có chứa chữ "LULL" không
		if (driver.getTitle().contains("LULL")) {
			System.out.println("Test Case PASSED!");
		} else {
			System.out.println("Test Case FAILED!");
		}
		
//		driver.quit();
	}

}
