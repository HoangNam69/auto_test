package test_ng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test_ng.base.BasePage;

public class LoginPage extends BasePage {

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver); // Super được call để đẩy driver lên cho BasePage khởi tạo
    }

    public void enterUsername(String username) {
       setText(usernameInput, username);
    }

    public void enterPassword(String password) {
        setText(passwordInput,password);
    }

    public void clickLoginBtn() {
       clickElement(loginBtn);
    }

    public String getErrorMessage() {
        return getTextElement(errorMessage);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }
}
