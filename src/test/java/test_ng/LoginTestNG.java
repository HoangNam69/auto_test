package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_ng.base.BaseTest;

public class LoginTestNG extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        return new Object[][]{
//                col 1: username, col 2: password, col 3: Expected result  - Pass(true) || Fail (false), col 4: Thông báo lỗi mong đợi
                {"standard_user", "secret_sauce", true, ""},
                {"locked_out_user", "secret_sauce", false, "Epic sadface: Sorry, this user has been locked out."},
                {"nam_test", "wrong_password", false, "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    //    Method test hứng 4 data cols tương ứng với 4 tham số của method
    @Test(dataProvider = "LoginData", description = "Kiểm tra tính năng đăng nhập với nhiều trạng thái tài khoản")
    public void testLogin(String username, String password, boolean isSuccessExpected, String expectedError) {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        if (isSuccessExpected) {
//            Case 01: mong đợi thành công
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("inventory.html"), "Lỗi: Không thể đăng nhập với tài khoản " + username);
        } else {
//            Case 02 + 03: Mong đợi không thành công và in ra lỗi
            String actualError = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

            Assert.assertEquals(actualError, expectedError, "Lỗi: Thông báo sai lệch cho tài khoản " + username);
        }
    }
}
