package aummation_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/drag_and_drop");

		Actions dad = new Actions(driver);

		WebElement source = driver.findElement(By.id("column-a"));
		WebElement target = driver.findElement(By.id("column-b"));

//		1. Dùng lệnh drag and drop có sẵn
//		dad.dragAndDrop(source, target).perform();

//		2. Kéo thả thủ công từng bước(click - giữ - di chuyển - thả)
		dad.clickAndHold(source).moveToElement(target).release().perform();
	}
}
