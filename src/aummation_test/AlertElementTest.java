package aummation_test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertElementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//		1. click btn
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

		/**
		 * Khởi tạo bộ đếm thời gian cho driver. Báo cho Selenium là chuẩn bị để đợi một
		 * thứ gì đó với thời gian đợi là 5s
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		/**
		 * Không đợi cứng nhắc mà luôn liên tục đợi và kiểm tra, khoảng 500ms kiểm tra
		 * một lần. Nếu như Alert đã được bật lên rồi không đợi nữa. Còn hết thời gian
		 * vẫn chưa hiển thị Alert thì sễ throw lỗi timeout exception
		 */
		wait.until(ExpectedConditions.alertIsPresent());

//		2. chuyển hướng sang Alert
		Alert promptAlert = driver.switchTo().alert();

//		3. action of alert
////		3.1 Click ok btn of alert
//		driver.switchTo().alert().accept();
////		3.2 Click cancel/Huy btn of alert
//		driver.switchTo().alert().dismiss();
////		3.3 Nhập nội dung vào alert
//		driver.switchTo().alert().sendKeys("Nội dung cần nhập vào prompt alert");

		promptAlert.sendKeys("Ted - Software Testing Engineer");
		promptAlert.accept();

		String result = driver.findElement(By.id("result")).getText();
		System.out.println("Result: " + result);

//		driver.quit();

	}

}
