package test_ng.pages.pim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test_ng.core.BasePage;

public class AddEmployeePage extends BasePage {

    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");

    private By employeeIdInput = By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    private By saveBtn = By.xpath("//button[@type='submit']");

    private By successToast = By.xpath("//div[@id='oxd-toaster_1']");

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public void enterEmployeeName(String firstName, String lastName) {
        setText(firstNameInput, firstName);
        setText(lastNameInput, lastName);
    }

    public String getGeneratedEmployeeId() {
        return getInputValue(employeeIdInput);
    }

    public void clickButtonSave() {
        clickElement(saveBtn);
    }

    public boolean waitForSaveSuccess() {
        // Đợi cho đến khi thông báo thành công hiển thị
        return isElementDisplayed(successToast);
    }
}
