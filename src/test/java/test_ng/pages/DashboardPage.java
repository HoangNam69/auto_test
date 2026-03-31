package test_ng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test_ng.core.BasePage;

public class DashboardPage extends BasePage {
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By pimElement = By.xpath("//span[text()='PIM']");
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     *
     * @return Kiểm tra xem đã mở được trang Dashboard chưa
     */
    public boolean isDashboardDisplayed() {
        return isElementDisplayed(dashboardHeader);
    }

    /**
     * Click chuyển qua trang PIM
     */
    public void clickPIMElement() {
        clickElement(pimElement);
    }
}
