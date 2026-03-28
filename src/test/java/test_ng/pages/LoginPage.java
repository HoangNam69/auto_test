package test_ng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_ng.base.BasePage;

import java.time.Duration;

public class LoginPage extends BasePage {

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver); // Super được call để đẩy driver lên cho BasePage khởi tạo
    }


    public void enterUsername(String username) {
        WebElement userEle = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        userEle.clear();
        userEle.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passEle = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passEle.clear();
        passEle.sendKeys(password);
    }

    public void clickLoginBtn() {
        WebElement btnLoginEle = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        btnLoginEle.click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }
}
