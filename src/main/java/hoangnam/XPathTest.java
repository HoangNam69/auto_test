package hoangnam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// Chờ tối đa 20 giây cho mọi phần tử trước khi báo lỗi
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		driver.get("https://google.com");

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("Scented Candles LULL");
		searchBox.submit();

		// 1. Khai báo XPath cho tiêu đề kết quả đầu tiên
		// Lưu ý: XPath này có thể thay đổi tùy theo cấu trúc Google tại thời điểm chạy
		By firstResultTitle = By.xpath("(//h3)[1]");
		
		/**
		 * bọc tag h3 vào trong () với ý nghĩa là list toàn bộ tag h3 thành một danhbọc tag h3 vào trong () với ý nghĩa là list toàn bộ tag h3 thành một danh
		 * sách và [1] để lấy tag h3 đầu tiên trong danh sách
		 */
		
		/**
		 * nếu không () thì sẽ lấy tất cả tag h3 mà tag h3 đó là con đầu tiên của cha nó (h1 > h3 => true, h1 > h2 > 3 => false)
		 * 
		 */

		// 2. Lấy Text của kết quả đó
		WebElement element = driver.findElement(firstResultTitle);

		String actualTitle = element.getText();

		// 3. In ra để kiểm chứng
		System.out.println("Tiêu đề kết quả đầu tiên là: " + actualTitle);

		// 4. Verification
		if (actualTitle.contains("Lull")) {
			System.out.println("Đúng là nến thơm LULL rồi! Test Pass.");
		} else {
			System.out.println("Hình như kết quả không khớp. Test Fail.");
		}

		driver.quit();

	}
}
