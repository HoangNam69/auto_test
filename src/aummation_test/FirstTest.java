package aummation_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) {
//		1. khởi tạo trình duyệt
		WebDriver driver = new ChromeDriver();
		
//		2. phóng to cửa sổ trình duyệt
		driver.manage().window().maximize();
		
//		3. truy cập một trang web
		driver.get("https://google.com");
		
//		4. in tiêu đề trang để kiểm tra
		System.out.println("Page title: " + driver.getTitle());
		
//		5. đóng trình duyệt
		driver.quit();

	}

}
