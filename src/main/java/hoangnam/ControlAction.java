package hoangnam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ControlAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/selectable/");

//		1. Lấy frame chứa danh sách
		WebElement ifr = driver.findElement(By.cssSelector(".demo-frame"));

//		2. switch vào frame
		driver.switchTo().frame(ifr);

//		3. Khởi tạo Actions
		Actions act = new Actions(driver);

//		4. Lấy toàn bộ các item của list 
		List<WebElement> items = driver.findElements(By.cssSelector(".ui-selectee"));

		/**
		 * 5. Thực hiện thao tác nhấn chọn các item. Bắt đầu là key down và kết thúc
		 * luôn là Key up. Đồng thời phải dùng method build() để tập hợp các hành động
		 * lại thành một gói hành động duy nhất. Kết thúc luôn phải là perform() nếu
		 * không selenium sẽ ghi nhận nhưng không thực hiện các hành động đó.
		 */
		act.keyDown(Keys.CONTROL).click(items.get(0)).click(items.get(2)).click(items.get(4)).keyUp(Keys.CONTROL)
				.build().perform();

		System.out.println("--- KIỂM TRA TRẠNG THÁI CHỌN ---");
		for (WebElement item : items) {
			String className = item.getAttribute("class");
			String itemText = item.getText();

			// Kiểm tra nếu class chứa 'ui-selected' thì mục đó đang được chọn
			if (className.contains("ui-selected")) {
				System.out.println("[SELECTED] " + itemText + " - Class: " + className);
			} else {
				System.out.println("[UNSELECTED] " + itemText);
			}
		}
	}

}
