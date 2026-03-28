package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_ng.base.BaseTest;

public class HoverTestNG extends BaseTest {

    @Test(priority = 1, description = "Kiểm tra thao tác di chuột (Hover) để hiển thị Tooltip")
    public void testHoverAction() {

        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement fig = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

        actions.moveToElement(fig).perform();

        WebElement userText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user1']")));
        System.out.println("User is hovered: " + userText.getText());
        Assert.assertTrue(userText.getText().contains("name: user1"), "Lỗi đang hover vào không đúng user 1");
    }
}
