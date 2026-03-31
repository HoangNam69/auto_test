package test_ng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test_ng.core.BasePage;

public class LoginPage extends BasePage {

    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        setText(usernameInput, username);
        setText(passwordInput, password);
        clickElement(loginBtn);
    }

    public String getErrorMessage() {
        return getTextElement(errorMessage);
    }
}
