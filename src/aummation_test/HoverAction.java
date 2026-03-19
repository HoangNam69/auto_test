package aummation_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoverAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/hovers");

//		1. Khởi tạo Actions
		Actions actions = new Actions(driver);

//		2. Lấy element cần thực hiện actions
		WebElement avatar = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

//		3. Thực hiệc action vào element vừa lấy
		actions.moveToElement(avatar).perform();

//		4. Đưa hành động vào hàng đợi bằng explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//		5. Tìm và lấy nội dung của tag h5 đã được hover
		WebElement userText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user1']")));
		
//		WebElement userText = driver.findElement(By.xpath("//h5[text()='name: user1']"));

		if (userText.isDisplayed()) {
			System.out.println("Hover is successfully, " + userText.getText());
		}

	}

}
