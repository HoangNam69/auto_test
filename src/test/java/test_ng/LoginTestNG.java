package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_ng.base.BaseTest;
import test_ng.helpers.ExcelHelper;
import test_ng.pages.LoginPage;

public class LoginTestNG extends BaseTest {

    private LoginPage loginPage;

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        String excelFilePath = "src/test/resources/LoginData.xlsx";
        String sheetName = "Sheet1";
        return ExcelHelper.readExcel(excelFilePath, sheetName);
    }

    //    Method test hứng 4 data cols tương ứng với 4 tham số của method
    @Test(dataProvider = "LoginData", description = "Kiểm tra tính năng đăng nhập với nhiều trạng thái tài khoản")
    public void testLogin(String username, String password, boolean isSuccessExpected, String expectedError) {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (isSuccessExpected) {
//            Case 01: mong đợi thành công
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("inventory.html"), "Lỗi: Không thể đăng nhập với tài khoản " + username);
        } else {
//            Case 02 + 03: Mong đợi không thành công và in ra lỗi
            String actualError = loginPage.getErrorMessage();

            Assert.assertEquals(actualError, expectedError, "Lỗi: Thông báo sai lệch cho tài khoản " + username);
        }
    }
}
