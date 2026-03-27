package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HoverTestNG {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test(priority = 1, description = "Kiểm tra thao tác di chuột (Hover) để hiển thị Tooltip")
    public void testHoverAction() {
        WebElement fig = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

        actions.moveToElement(fig).perform();

        WebElement userText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user1']")));
        System.out.println("User is hovered: " + userText.getText());
        Assert.assertTrue(userText.getText().contains("name: user1"), "Lỗi đang hover vào không đúng user 1");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
