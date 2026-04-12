package test_ng.pages.pim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test_ng.core.BasePage;

public class PimPage extends BasePage {
    private By addBtn = By.xpath("//button[normalize-space()='Add']");
    private By employeeIdInput = By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    private By searchBtn = By.xpath("//button[@type='submit']");
    private By firstResultNameCell = By.xpath("//div[@class='oxd-table-card']//div[@role='cell'][3]/div");
    private By employeeList = By.xpath("//a[text()='Employee List']");

    private By firstResultIdCell = By.xpath("//div[@class='oxd-table-card']//div[@role='cell'][2]/div");
    public PimPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddEmployee() {
        clickElement(addBtn);
    }

    public void searchByEmployeeId(String employeeId) {
        setText(employeeIdInput, employeeId);
        clickElement(searchBtn);
        // Bắt Selenium đợi cho đến khi ô ID của dòng đầu tiên
        // biến thành đúng cái số ID mà ta vừa nhập vào
        wait.until(ExpectedConditions.textToBe(firstResultIdCell, employeeId));
    }

    public String getFirstResultName () {
        return getTextElement(firstResultNameCell);
    }

    public void clickTobackEmployeeList() {
        clickElement(employeeList);
    }
}
